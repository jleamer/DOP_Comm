import numpy as np
import os
from scipy import fft
from scipy.signal import convolve
from multiprocessing import Pool
from refractive_index_fluctuations import get_realization, get_seeds
from itertools import repeat
from comsol_phase_screen import get_filenames, create_func, add_geometry, apply_material, write_model_file
import shutil
from string import Template
import matplotlib.pyplot as plt


def batch_sim(realization, vol_file, output_directory, init_dop, a10, a20, delta0, run_num):
    """
    function to run comsol on a batch as in comsol_phase_screen.py
    :param input_directory:     directory where phase screens are saved
    :param output_directory:    directory where the outputs should be saved
    :param init_dop:            desired initial dop
    :param run_num:             number of run
    :return:
    """
    # Save realization to file
    np.savetxt(vol_file, realization[0].T, delimiter=',')

    # Get phase screen files
    interp_file = "\"" + vol_file + "\""
    int_file = "\"" + output_directory + "/intensity_" + str(run_num) + ".csv\""
    s1_file = "\"" + output_directory + "/s1_" + str(run_num) + ".csv\""
    s2_file = "\"" + output_directory + "/s2_" + str(run_num) + ".csv\""
    s3_file = "\"" + output_directory + "/s3_" + str(run_num) + ".csv\""

    # Write edits to file
    input_name = "phase_screen.java"
    output_name = "edited_phase_screen.java"
    dop = "\"" + str(init_dop) + "\""

    # Use template
    # Read in java file and convert to template
    input_file = open(input_name, "r")
    prev_java_code = input_file.read()
    output_text = Template(prev_java_code)
    input_file.close()

    # Rename class to match ouput file name
    name = output_name.split(".")[0]

    output_text = output_text.substitute(name=name, dop=dop, int_file=int_file,
                                         s1_file=s1_file, s2_file=s2_file, s3_file=s3_file, interp=interp_file,
                                         a10="\"" + str(a10) + "\"", a20="\"" + str(a20) + "\"",
                                         delta0="\"" + str(delta0) + "\"")
    output = open(output_name, "w+")
    output.write(output_text)
    output.close()


    # Compile java file into class file
    temp = os.system("comsol compile -jdkroot /usr/bin/java " + output_name)

    # Run COMSOL simulation
    class_filename = "edited_phase_screen.class"
    temp2 = os.system("comsol batch -inputfile " + class_filename)
    """
    # Save realization again in a different location to see if anything has changed
    after_data = np.loadtxt(vol_file, delimiter=',')
    np.savez_compressed("phase_volumes_arb_pol/compressed_vols/" + str(realization[1]) + "_after", x=after_data.T[0], y=after_data.T[1], z=after_data.T[2], f=after_data.T[3])
    """
    # Check that nothing in the volume file changed
    """
    if not compare_volumes("phase_volumes_arb_pol/compressed_vols/" + str(realization[1]) + "_after.npz", "phase_volumes_arb_pol/compressed_vols/" + str(realization[1]) + "_before.npz"):
        print("Error in file: ", str(realization[1]))
        print("Run num: ", str(run_num))
        exit()
    """


def compare_volumes(file1, file2):
    """
    Function to compare data in file1 and file2 to check that nothing was changed after simulating with COMSOL
    :param file1:   the data in a csv file
    :param file2:   the data in a npz file
    :return:
    """
    # Load file 1
    a = np.load(file1)

    # Load file 2
    b = np.load(file2)

    for a_key, b_key in zip(a, b):
        if np.all(a[a_key] != b[b_key]):
            return False

    return True


if __name__ == "__main__":
    # Define number of grid points - should be power of 2 for fft
    N_gridpts = 256

    # Define number of points and amplitude
    k_grid_dim = N_gridpts
    k_amplitude = 10

    # Create index for kx and ky using np.newaxis
    indx_kx = np.arange(k_grid_dim)[:, np.newaxis, np.newaxis]
    indx_ky = np.arange(k_grid_dim)[np.newaxis, :, np.newaxis]
    indx_kz = np.arange(k_grid_dim)[np.newaxis, np.newaxis, :]

    # Define difference between successive k values
    dk = 2 * k_amplitude / k_grid_dim

    # Create kx and ky from index, grid_dim, and dk
    k_x = (indx_kx - k_grid_dim / 2) * dk
    k_y = (indx_ky - k_grid_dim / 2) * dk
    k_z = (indx_kz - k_grid_dim / 2) * dk

    x = (indx_kx - k_grid_dim / 2) * np.pi / k_amplitude
    y = (indx_ky - k_grid_dim / 2) * np.pi / k_amplitude
    z = (indx_kz - k_grid_dim / 2) * np.pi / k_amplitude

    xx, yy, zz = np.meshgrid(x[:, 0, 0], y[0, :, 0], z[0, 0, :])

    # Combine to create k_grid
    k_grid = np.sqrt(k_x ** 2 + k_y ** 2 + k_z ** 2)

    # Now calculate power spectral density for index of refraction on k_grid
    k0 = 10
    km = 1000
    pow_spec_dens = 0.033 / (k0 + k_grid) ** (11 / 6) * np.exp(-k_grid ** 2 / km ** 2)

    # Get kernel in position space
    pos_kernel = (-1) ** (indx_kx + indx_ky + indx_kz) * fft.ifftn((-1) ** (indx_kx + indx_ky + indx_kz) * np.sqrt(pow_spec_dens))

    # Set dop and sop for runs
    dop = 0.8
    a10 = 0.45
    a20 = -0.33
    delta0 = -1.0471975511965976

    # Perform simulation specified number of times
    num_batches = 1000

    # Set flag for resetting directory if desired
    reset = False

    # Make directory if it doesn't exist, empty it and remake it if it does and reset is true
    vol_directory = "phase_volumes_arb_pol"
    dop_vol_directory = vol_directory + "/compressed_vols/P=" + str(dop)
    if not os.path.exists(vol_directory):
        os.makedirs(vol_directory)
        os.makedirs(dop_vol_directory)
    elif reset:
        shutil.rmtree(vol_directory)
        os.makedirs(vol_directory)
        os.makedirs(dop_vol_directory)

    if not os.path.exists(dop_vol_directory):
        os.makedirs(dop_vol_directory)

    # Generate random phase volumes
    args = zip(get_seeds(num_batches), repeat(N_gridpts), repeat(pos_kernel), repeat(xx), repeat(yy), repeat(zz), repeat(dop_vol_directory))
    with Pool() as pool:
        realizations = list(pool.imap(get_realization, args))

    # Make directory for results if it doesn't exist, empty it and remake if it does and reset is true
    output_loc = vol_directory + "/P=" + str(dop)
    if not os.path.exists(output_loc):
        os.makedirs(output_loc)
    elif reset:
        shutil.rmtree(output_loc)
        os.makedirs(output_loc)

    # Get volume files
    for run_num, _ in enumerate(realizations):
        batch_sim(_, vol_directory + "/vol.csv", vol_directory + "/P=" + str(dop), dop, a10, a20, delta0, run_num)
