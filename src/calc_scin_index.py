import numpy as np
import matplotlib.pyplot as plt
import os


def fix_names(directory):
    """
    function for fixing names in dir so that they sort properly
    :param directory:     directory of files
    :return:
    """
    files = os.listdir(directory)
    start_marker = "_"
    end_marker = "."
    for _ in files:
        start = _.index(start_marker, 4) + 1
        end = _.index(end_marker)
        if len(_[start:end]) < 2:
            new_name = _[:start] + "0" + _[start:]
            os.rename(directory + "/" + _, directory + "/" + new_name)


def get_filenames(directory):
    """
    creates array of filenames in given dir for accessing
    :param directory:  directory to pull from
    :return:        array of filenames
    """
    files = np.sort(os.listdir(directory))
    return np.array([directory + "/" + _ for _ in files])


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


def remove_rays(file, x_file, y_file, z_file, x_pos, yu, yl, zu, zl, tol):
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
    data = np.loadtxt(file, skiprows=5, delimiter=',')[1:]
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
    data[np.invert(within_x & within_y & within_z)] = 0

    return data


def process_files(directory):
    """
    function for processing files calculated with a given DOP
    :param directory: directories to pull from
    :return:
    """
    folders = np.sort(os.listdir(directory))
    folders = [directory + _ + "/" for _ in folders]

    # Fix names
    for _ in folders:
        fix_names(_)

    # Get files

    intensity_files = get_filenames(folders[0])
    s0_files = get_filenames(folders[1])
    s1_files = get_filenames(folders[2])
    s2_files = get_filenames(folders[3])
    s3_files = get_filenames(folders[4])
    x_files = get_filenames(folders[5])
    y_files = get_filenames(folders[6])
    z_files = get_filenames(folders[7])

    # Define variables for loops
    num_files = intensity_files.size

    # Define bounds for filtering rays
    x_pos = 3.0
    yu = 1
    yl = 0
    zu = 1
    zl = 0
    tol = 1e-4

    # Load data and remove rays
    intensity_of_rays = np.array(
        [remove_rays(intensity_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol) for i in
         range(num_files)])
    num_rays_left = np.array([np.count_nonzero(_) for _ in intensity_of_rays])
    s0 = np.array(
        [np.sum(remove_rays(s0_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])
    s1 = np.array(
        [np.sum(remove_rays(s1_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])
    s2 = np.array(
        [np.sum(remove_rays(s2_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])
    s3 = np.array(
        [np.sum(remove_rays(s3_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])

    # Calculate average intensity in sets of 10 for four data points
    avg_int = np.array([np.mean(intensity_of_rays[i:(i + 1) * 25]) for i in range(4)])
    # avg_int_sq = np.array([np.mean(intensity_of_rays[i:(i+1)*10] ** 2) for i in range(4)])

    # Calculate I(0, 0) using stokes parameters from files 1-10
    # I(0, 0) = (s0 + s1) / 2
    i00 = (s0[:25] + s1[:25]) / 2 / num_rays_left[:25]
    sigma_00 = np.mean(i00 ** 2) / np.mean(i00) ** 2 - 1

    # Calculate I(0, 90) using stokes parameters from files 11-20
    i090 = (s0[25:50] - s1[25:50]) / 2 / num_rays_left[25:50]
    sigma_090 = np.mean(i090 ** 2) / np.mean(i090) ** 2 - 1

    # Calculate I(45, 45) using stokes parameters from files 21-30
    i4545 = (s2[50:75] + s0[50:75]) / 2 / num_rays_left[50:75]
    sigma_4545 = np.mean(i4545 ** 2) / np.mean(i4545) ** 2 - 1

    # Calcualte I(0, 45) using stokes parameters from files 31-40
    i045 = (s3[75:] + s0[75:]) / 2 / num_rays_left[75:]
    sigma_045 = np.mean(i045 ** 2) / np.mean(i045) ** 2 - 1

    # collect results
    sigma = [sigma_00, sigma_090, sigma_4545, sigma_045]
    return avg_int, sigma


def process_files_no_bin(directory):
    folders = np.sort(os.listdir(directory))
    folders = [directory + _ + "/" for _ in folders]

    # Fix names
    for _ in folders:
        fix_names(_)

    # Get files

    intensity_files = get_filenames(folders[0])
    s0_files = get_filenames(folders[1])
    s1_files = get_filenames(folders[2])
    s2_files = get_filenames(folders[3])
    s3_files = get_filenames(folders[4])
    x_files = get_filenames(folders[5])
    y_files = get_filenames(folders[6])
    z_files = get_filenames(folders[7])

    # Define variables for loops
    num_files = intensity_files.size

    # Define bounds for filtering rays
    x_pos = 3.0
    yu = 1
    yl = 0
    zu = 1
    zl = 0
    tol = 1e-4

    # Load data and remove rays
    intensity_of_rays = np.array(
        [remove_rays(intensity_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol) for i in
         range(num_files)])
    num_rays_left = np.array([np.count_nonzero(_) for _ in intensity_of_rays])
    s0 = np.array(
        [np.sum(remove_rays(s0_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])
    s1 = np.array(
        [np.sum(remove_rays(s1_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])
    s2 = np.array(
        [np.sum(remove_rays(s2_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])
    s3 = np.array(
        [np.sum(remove_rays(s3_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in
         range(num_files)])

    # Scintillation Index
    #avg_I_sq = np.array([np.mean(intensity_of_rays[i] ** 2) for i in range(num_files)])
    #avg_I = np.array([np.mean(intensity_of_rays[i]) for i in range(num_files)])
    #sigma = avg_I_sq / avg_I ** 2 - 1

    avg_I = np.array([np.mean(intensity_of_rays[i:(i + 1) * 25]) for i in range(4)])
    avg_s0 = np.array([np.mean(s0[i:(i + 1) * 25] / 200) for i in range(4)])
    avg_I_sq = np.array([np.mean(intensity_of_rays[i:(i+1)*25] ** 2) for i in range(4)])
    sigma = avg_I_sq / avg_I ** 2 - 1

    return avg_I, sigma


p02_avg_int, p02_sigma = process_files("DOP_test/P=0.2/")
p04_avg_int, p04_sigma = process_files("DOP_test/P=0.4/")
p06_avg_int, p06_sigma = process_files("DOP_test/P=0.6/")
p08_avg_int, p08_sigma = process_files("DOP_test/P=0.8/")
p10_avg_int, p10_sigma = process_files("DOP_test/P=1.0/")

# Plot
plt.plot(p02_avg_int, p02_sigma, 'o', label='P=0.2')
plt.plot(p04_avg_int, p04_sigma, 'o', label='P=0.4')
plt.plot(p06_avg_int, p06_sigma, 'o', label='P=0.6')
plt.plot(p08_avg_int, p08_sigma, 'o', label='P=0.8')
plt.plot(p10_avg_int, p10_sigma, 'o', label='P=1.0')
plt.xlabel("Avg I")
plt.ylabel(r"$\sigma_i^2$")
plt.legend(numpoints=1)

# Calculate scintillation index without binning results into batches
p02_avg_int_nb, p02_sigma_nb = process_files_no_bin("DOP_test/P=0.2/")
p04_avg_int_nb, p04_sigma_nb = process_files_no_bin("DOP_test/P=0.4/")
p06_avg_int_nb, p06_sigma_nb = process_files_no_bin("DOP_test/P=0.6/")
p08_avg_int_nb, p08_sigma_nb = process_files_no_bin("DOP_test/P=0.8/")
p10_avg_int_nb, p10_sigma_nb = process_files_no_bin("DOP_test/P=1.0/")

avg_sq_I = np.mean((p02_sigma_nb + 1) * p02_avg_int_nb ** 2)
test_i = np.linspace(550, 625, 1000)
test_s = avg_sq_I / test_i ** 2 - 1

plt.figure(2)
plt.plot(p02_avg_int_nb, p02_sigma_nb, 'o', label='P=0.2')
plt.plot(p04_avg_int_nb, p04_sigma_nb, 'o', label='P=0.4')
plt.plot(p06_avg_int_nb, p06_sigma_nb, 'o', label='P=0.6')
plt.plot(p08_avg_int_nb, p08_sigma_nb, 'o', label='P=0.8')
plt.plot(p02_avg_int_nb, p02_sigma_nb, 'o', label='P=1.0')
#plt.plot(test_i, test_s)
plt.xlabel("Avg I")
plt.ylabel(r"$\sigma_i^2$")
plt.legend(numpoints=1)

plt.show()