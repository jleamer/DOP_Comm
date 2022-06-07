import numpy as np
import matplotlib.pyplot as plt
import os


def get_filenames(dir):
    """
    creates array of filenames in given dir for accessing
    :param dir:     directory to pull from
    :return:        array of filenames
    """
    files = np.sort(os.listdir(dir))
    return np.array([dir + "/" + _ for _ in files])


def check_within_bounds(data, upper_bound, lower_bound):
    """
    Checks which indices of data lie within the upper and lower bounds
    :param data:            array of data to be checked
    :param upper_bound:     upper bound of the data to compare against
    :param lower_bound:     lower bound of the data to compare against
    :return:                array of bools
    """
    # Create arrays of bools for checking - set to false initially to avoid false positives
    lt_upper = np.zeros(data.size, dtype=bool)
    gt_lower = np.zeros(data.size, dtype=bool)

    # Check for data values that are less than the upper bound and set to true
    lt_upper[data <= upper_bound] = True

    # Check for data values that are greater than the lower bound and set to true
    gt_lower[lower_bound <= data] = True

    # Data values that are between upper and lower bound
    return lt_upper & gt_lower


def remove_rays(arr, x_file, y_file, z_file, x_pos, yu, yl, zu, zl, tol):
    """
    Checks for rays that aren't lying on the second surface in the sim and sets their values to 0 in file
    :param file:    file to be checked
    :param x_file:  file detailing x position of rays at the final time
    :param y_file:  file detailing y position of rays at the final time
    :param z_file:  file detailing z position of rays at the final time
    :param x_pos:   x position of second surface
    :param yu:      upper bound of second surface in y direction
    :param yl:      lower bound of second surface in y direction
    :param zu:      upper bound of second surface in z direction
    :param zl:      lower bound of second surface in z direction
    :param tol:     tolerance to use for determining if the ray is on the second surface
    :return:        array with required rays removed
    """
    # Read in data from files
    x_data = np.loadtxt(x_file, skiprows=5, delimiter=',')[1:]
    y_data = np.loadtxt(y_file, skiprows=5, delimiter=',')[1:]
    z_data = np.loadtxt(z_file, skiprows=5, delimiter=',')[1:]

    # Check that rays x_data is on x_pos of surface
    within_x = check_within_bounds(x_data, x_pos + tol, x_pos - tol)

    # Check that rays are within y bounds
    within_y = check_within_bounds(y_data, yu + tol, yl - tol)

    # Check that rays are within z bounds
    within_z = check_within_bounds(z_data, zu + tol, zl - tol)

    # Only want rays that are within x, y, and z bounds
    arr[np.invert(within_x & within_y & within_z)] = 0

    return arr


def get_initial_data(file):
    """
    Get initial data of simulation from file
    :param file:    the name of the file to process
    :return:        array of initial data
    """
    data = np.loadtxt(file, skiprows=5, delimiter=',').T[1:]
    initial_data = np.array([data[i][0] for i in range(501)])
    return np.sum(initial_data)


def log_normal(i, i0, sigma):
    """
    function to calculate the log normal distribution using our simulation results
    :param i:       array of intensity values to calculate
    :param i0:      mean value of intensity
    :param sigma:   mean value of scintillation index
    :return:        array of function values
    """
    coeff = 1 / (2 * i * sigma * np.sqrt(2 * np.pi))
    arg = (np.log(i / i0) + sigma ** 2 / 2) ** 2 / (2 * sigma ** 2)

    return coeff * np.exp(-arg)


def get_plots(dir):
    """
    function to generate and save plots processing data from comsol simulations
    :param dir: directory where files are stored
    :return:
    """
    # Create lists for filenames
    intensity_files = get_filenames(dir + "/Int")
    s1_files = get_filenames(dir + "/s1")
    s2_files = get_filenames(dir + "/s2")
    s3_files = get_filenames(dir + "/s3")
    x_files = get_filenames(dir + "/x")
    y_files = get_filenames(dir + "/y")
    z_files = get_filenames(dir + "/z")

    # Define variables for looping
    num_files = intensity_files.size
    num_rays = np.loadtxt(intensity_files[0], skiprows=5, delimiter=',').size - 1

    # Define bounds for filtering rays
    x_pos = 1.125
    yu = 1
    yl = 0
    zu = 1
    zl = 0
    tol = 1e-4

    # Load intensity, s1, s2, and s3 data at final time
    intensity_of_rays = np.nanmean([np.loadtxt(_, skiprows=6, delimiter=',') for _ in intensity_files])
    final_s1 = np.nanmean([np.loadtxt(_, skiprows=6, delimiter=',') for _ in s1_files])
    final_s2 = np.nanmean([np.loadtxt(_, skiprows=6, delimiter=',') for _ in s2_files])
    final_s3 = np.nanmean([np.loadtxt(_, skiprows=6, delimiter=',') for _ in s3_files])

    """
    # Normalize stokes parameters of rays using intensity of rays
    final_norm_s1 = final_s1 / intensity_of_rays
    final_norm_s2 = final_s2 / intensity_of_rays
    final_norm_s3 = final_s3 / intensity_of_rays

    # Remove rays that do not lie on the detector
    int_of_rays_det = np.array([remove_rays(intensity_of_rays[i][1:], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol) for i in range(num_files)])
    num_rays_left = np.array([np.count_nonzero(_) for _ in intensity_of_rays])
    exp_s1 = np.array([remove_rays(final_norm_s1[i][1:], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol) for i in range(num_files)])
    exp_s2 = np.array([remove_rays(final_norm_s2[i][1:], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol) for i in range(num_files)])
    exp_s3 = np.array([remove_rays(final_norm_s3[i][1:], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol) for i in range(num_files)])
    """
    # Process initial data from simulations
    initial_intensity = np.array([np.nanmean(get_initial_data(_)) for _ in intensity_files])
    initial_s1 = np.array([np.nanmean(get_initial_data(_)) for _ in s1_files])
    initial_s2 = np.nanmean([np.nanmean(get_initial_data(_)) for _ in s2_files])
    initial_s3 = np.nanmean([np.nanmean(get_initial_data(_)) for _ in s3_files])

    """
    # Process data for plotting
    avg_I = np.array([np.mean(int_of_rays_det[i]) for i in range(num_files)])
    rem_fin_s1 = []
    rem_fin_s2 = []
    rem_fin_s3 = []
    rem_init_s1 = []
    rem_init_s2 = []
    rem_init_s3 = []
    for i in range(num_rays_left.size):
        if num_rays_left[i]:
            rem_init_s1.append(initial_s1[i])
            rem_init_s2.append(initial_s2[i])
            rem_init_s3.append(initial_s3[i])

            # Average final stokes parameters
            rem_fin_s1.append(np.sum(exp_s1[i]) / num_rays_left[i])
            rem_fin_s2.append(np.sum(exp_s2[i]) / num_rays_left[i])
            rem_fin_s3.append(np.sum(exp_s3[i]) / num_rays_left[i])


    # Process dop
    rem_fin_s1 = np.array(rem_fin_s1)
    rem_fin_s2 = np.array(rem_fin_s2)
    rem_fin_s3 = np.array(rem_fin_s3)
    dop = np.sqrt(rem_fin_s1 ** 2 + rem_fin_s2 ** 2 + rem_fin_s3 ** 2)
    
    # Calculate initial dop for each iteration that had some rays reach detector
    rem_init_s1 = np.array(rem_init_s1)
    rem_init_s2 = np.array(rem_init_s2)
    rem_init_s3 = np.array(rem_init_s3)
    """
    initial_dop = np.sqrt(initial_s1 ** 2 + initial_s2 ** 2 + initial_s3 ** 2) / initial_intensity

    # Create parameters for tables to attach to plots
    columns = ["Initial Mean", "Final Mean"]

    # Plot results
    plt.figure(1)
    plt.plot(avg_I, 'o-')
    plt.xlabel("Iteration #")
    plt.ylabel("Intensity (W/m^2)")
    plt.savefig(dir + "/figs/intensity.png", format='png', dpi=300)

    plt.figure(2)
    plt.plot(rem_fin_s1, 'o-', label='Final')
    plt.plot(initial_s1, '-', label='Initial')
    plt.plot(np.mean(rem_fin_s1) * np.ones(rem_fin_s1.size), 'k--', label='Final Mean')
    plt.xlabel("Iteration #")
    plt.ylabel("Normalized s1")
    plt.legend(numpoints=1)
    plt.table(cellText=[['%.5f' % (np.nanmean(initial_s1)), '%.5f' % (np.mean(rem_fin_s1))]],
              colLabels=columns,
              cellLoc='center',
              loc='top')
    plt.savefig(dir + "/figs/s1.png", format='png', dpi=300)

    plt.figure(3)
    plt.plot(rem_fin_s2, 'o-', label='Final')
    plt.plot(initial_s2, '-', label='Initial')
    plt.plot(np.mean(rem_fin_s2) * np.ones(rem_fin_s2.size), 'k--', label='Final Mean')
    plt.xlabel("Iteration #")
    plt.ylabel("Normalized s2")
    plt.legend(numpoints=1)
    plt.table(cellText=[['%.5f' % (np.nanmean(initial_s2)), '%.5f' % (np.mean(rem_fin_s2))]],
              colLabels=columns,
              cellLoc='center',
              loc='top')
    plt.savefig(dir + "/figs/s2.png", format='png', dpi=300)

    plt.figure(4)
    plt.plot(rem_fin_s3, 'o-', label='Final')
    plt.plot(initial_s3, '-', label='Initial')
    plt.plot(np.mean(rem_fin_s3) * np.ones(rem_fin_s3.size), 'k--', label='Final Mean')
    plt.xlabel("Iteration #")
    plt.ylabel("Normalized s3")
    plt.legend(numpoints=1)
    plt.table(cellText=[['%.5f' % (np.nanmean(initial_s3)), '%.5f' % (np.mean(rem_fin_s3))]],
              colLabels=columns,
              cellLoc='center',
              loc='top')
    plt.savefig(dir + "/figs/s3.png", format='png', dpi=300)

    plt.figure(5)
    plt.plot(dop, 'o-', label='Final')
    plt.plot(initial_dop, 'x-', label='Initial')
    plt.plot(np.mean(dop) * np.ones(dop.size), 'k--', label='Final Mean')
    plt.xlabel("Iteration #")
    plt.ylabel("DOP")
    plt.legend(numpoints=1)
    plt.table(cellText=[['%.5f' % (np.nanmean(initial_dop)), '%.5f' % (np.nanmean(dop))]],
              colLabels=columns,
              cellLoc='center',
              loc='top')
    plt.savefig(dir + "/figs/dop.png", format='png', dpi=300)

    print("Directory: ", dir)
    print("Mean initial DOP: ", np.nanmean(initial_dop))
    print("Mean final DOP: ", np.nanmean(dop))
    print("Mean initial s1:", np.nanmean(initial_s1))
    print("Mean final s1: ", np.nanmean(exp_s1))
    print("Mean initial s2: ", np.nanmean(initial_s2))
    print("Mean final s2: ", np.nanmean(exp_s2))
    print("Mean initial s3: ", np.nanmean(initial_s3))
    print("Mean final s3: ", np.nanmean(exp_s3))

    plt.show()

if __name__ == "__main__":
    get_plots("DOP_test/P=0.2")
    get_plots("DOP_test/P=0.4")