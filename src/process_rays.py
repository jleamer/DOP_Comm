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


# Create lists for filenames
intensity_files = get_filenames("Int")
s1_files = get_filenames("s1")
s2_files = get_filenames("s2")
s3_files = get_filenames("s3")
x_files = get_filenames("x")
y_files = get_filenames("y")
z_files = get_filenames("z")

# Define variables for looping
num_files = intensity_files.size
num_rays = np.loadtxt(intensity_files[0], skiprows=5, delimiter=',').size - 1

# Define bounds
x_pos = 1.5
yu = 1
yl = 0
zu = 1
zl = 0
tol = 1e-4

# Load intensity, s1, s2, and s3 data
test = remove_rays(intensity_files[0], x_files[0], y_files[0], z_files[0], x_pos, yu, yl, zu, zl, tol)
intensity = [np.sum(remove_rays(intensity_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in range(num_files)]
s1 = [np.sum(remove_rays(s1_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in range(num_files)]
s2 = [np.sum(remove_rays(s2_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in range(num_files)]
s3 = [np.sum(remove_rays(s3_files[i], x_files[i], y_files[i], z_files[i], x_pos, yu, yl, zu, zl, tol)) for i in range(num_files)]


# Process s1, s2, and s3
intensity = np.array(intensity) / num_rays
s1 = np.array(s1) / num_rays
s2 = np.array(s2) / num_rays
s3 = np.array(s3) / num_rays

# Process dop
dop = np.sqrt(s1 ** 2 + s2 ** 2 + s3 ** 2) / intensity

# Plot results
plt.figure(1)
plt.plot(intensity)
plt.xlabel("Iteration #")
plt.ylabel("Intensity (W/m^2)")

plt.figure(2)
plt.plot(s1)
plt.xlabel("Iteration #")
plt.ylabel("Normalized s1")

plt.figure(3)
plt.plot(s2)
plt.xlabel("Iteration #")
plt.ylabel("Normalized s2")

plt.figure(4)
plt.plot(s3)
plt.xlabel("Iteration #")
plt.ylabel("Normalized s3")

plt.figure(5)
plt.plot(dop)
plt.xlabel("Iteration #")
plt.ylabel("DOP")

plt.show()