import numpy as np
import os
from scipy import fft
from scipy.signal import convolve
from multiprocessing import Pool
from refractive_index_fluctuations import get_realization, get_seeds
from itertools import repeat
from comsol_phase_screen import get_filenames, create_func, add_geometry, apply_material, write_model_file
import shutil


def batch_sim(input_directory, output_directory, init_dop, run_num):
    """
    function to run comsol on a batch as in comsol_phase_screen.py
    :param input_directory:     directory where phase screens are saved
    :param output_directory:    directory where the outputs should be saved
    :param init_dop:            desired initial dop
    :param run_num:             number of run
    :return:
    """
    # Get phase screen files
    screen_files = get_filenames(input_directory)
    num_screens = screen_files.size
    int_file = "\"" + output_directory + "/intensity_" + str(run_num) + ".csv\""
    s1_file = "\"" + output_directory + "/s1_" + str(run_num) + ".csv\""
    s2_file = "\"" + output_directory + "/s2_" + str(run_num) + ".csv\""
    s3_file = "\"" + output_directory + "/s3_" + str(run_num) + ".csv\""

    # Loop over screens and create code blocks for each
    func_code = []
    geom_code = []
    mat_code = []

    for j in range(2, num_screens + 2):
        func_code.append(create_func("int" + str(j), screen_files[j - 2]))
        geom_code.append(add_geometry("blk" + str(j), "Screen" + str(j), "width/" + str(num_screens) + "*" + str(j)))
        mat_code.append(apply_material("mat" + str(j), "Screen" + str(j), j, "int" + str(j)))

    # Write edits to file
    input_name = "phase_screen.java"
    output_name = "edited_phase_screen.java"
    dop = "\"" + str(init_dop) + "\""
    write_model_file(input_name, output_name, func_code, geom_code, mat_code, dop, int_file, s1_file, s2_file, s3_file)

    # Compile java file into class file
    temp = os.system("comsol compile -jdkroot /usr/bin/java " + output_name)

    # Run COMSOL simulation
    class_filename = "edited_phase_screen.class"
    temp2 = os.system("comsol batch -inputfile " + class_filename)


if __name__ == "__main__":
    # Define number of grid points - should be power of 2 for fft
    N_gridpts = 1024

    # Define number of points and amplitude
    k_grid_dim = N_gridpts
    k_amplitude = 1000

    # Create index for kx and ky using np.newaxis
    indx_kx = np.arange(k_grid_dim)[:, np.newaxis]
    indx_ky = np.arange(k_grid_dim)[np.newaxis, :]

    # Define difference between successive k values
    dk = 2 * k_amplitude / k_grid_dim

    # Create kx and ky from index, grid_dim, and dk
    k_x = (indx_kx - k_grid_dim / 2) * dk
    k_y = (indx_ky - k_grid_dim / 2) * dk

    x = (indx_kx - k_grid_dim / 2) * np.pi / k_amplitude
    y = (indx_ky - k_grid_dim / 2) * np.pi / k_amplitude

    # Combine to create k_grid
    k_grid = np.sqrt(k_x ** 2 + k_y ** 2)

    # Now calculate power spectral density for index of refraction on k_grid
    k0 = 10
    km = 1000
    pow_spec_dens = 0.033 / (k0 + k_grid) ** (11 / 6) * np.exp(-k_grid ** 2 / km ** 2)

    # Get kernel in position space
    pos_kernel = (-1) ** (indx_kx + indx_ky) * fft.ifft2((-1) ** (indx_kx + indx_ky) * np.sqrt(pow_spec_dens))

    dop = 0.2

    # Perform simulation specified number of times
    num_batches = 100
    num_seeds = 100
    for i in range(num_batches):
        # Create folders for phase screens
        # If the specified directory does not exist, create it
        if not os.path.exists("phase_screens/" + str(i)):
            os.makedirs("phase_screens/" + str(i))
        else:
            shutil.rmtree("phase_screens/" + str(i))
            os.makedirs("phase_screens/" + str(i))

        # Specify directory to save phase screens to
        screen_directory = "phase_screens/" + str(i) + "/"

        # Create the desired number of realization
        with Pool() as pool:
            realizations = list(
                pool.imap(get_realization, zip(get_seeds(num_seeds), repeat(N_gridpts), repeat(pos_kernel), repeat(screen_directory))))

        output_loc = "phase_screens/P=" + str(dop)
        if not os.path.exists(output_loc):
            os.makedirs(output_loc)
        batch_sim(screen_directory, output_loc, dop, i)