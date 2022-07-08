import numpy as np
from scipy import fft
from scipy.signal import convolve
import matplotlib.pyplot as plt
from multiprocessing import Pool
from itertools import repeat


def get_seeds(size):
    """
    Generate unique random seeds for subsequently seeding them into random number generators in multiprocessing simulations
    This utility is to avoid the following artifact:
        https://stackoverflow.com/questions/24345637/why-doesnt-numpy-random-and-multiprocessing-play-nice
    :param size:    number of samples to generate
    :return:        numpy.array of np.uint32
    """
    # Note that np.random.seed accepts 32 bit unsigned integers

    # get the maximum value of np.uint32 can take
    max_val = np.iinfo(np.uint32).max

    # A set of unique and random np.uint32
    seeds = set()

    # generate random numbers until we have sufficiently many nonrepeating numbers
    while len(seeds) < size:
        seeds.update(
            np.random.randint(max_val, size=size, dtype=np.uint32)
        )

    # make sure we do not return more numbers that we are asked for
    return np.fromiter(seeds, np.uint32, size)


def get_realization(args):
    """
    Obtain a realization of noise convolved with kernel
    :param seed:        seed for random noise
    :param grid_pts:    number of grid points to use
    :param kernel:  kernel in position space for convolution
    :return:            a realization of the noise filtered by pos_kernel
    """
    seed = args[0]
    grid_pts = args[1]
    kernel = args[2]
    x = args[3]
    y = args[4]
    z = args[5]
    file = args[6] + str(seed) + ".csv"

    np.random.seed(seed)
    random_noise = np.random.uniform(low=-np.sqrt(3), high=np.sqrt(3), size=(grid_pts, grid_pts, grid_pts))
    filtered = convolve(kernel, random_noise, mode='same').real
    filtered = filtered.real * filtered.real[grid_pts // 2, grid_pts // 2, grid_pts // 2]
    data = np.vstack((x.flatten(), y.flatten(), z.flatten(), filtered.flatten()))
    np.savetxt(file + str(seed) + ".csv", data.T, delimiter=',')
    return filtered


def save_realization(path, realization, seed, x, y, z):
    """
    Function for saving a realization in 2d slices
    :param realization:     3d phase screen realization
    :return:
    """
    data = np.vstack((x.flatten(), y.flatten(), z.flatten(), realization.flatten()))
    np.savetxt(path + str(seed) + ".csv", data.T, delimiter=',')


# Script for generating random index of refraction fluctuations in volume
if __name__ == '__main__':

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
    print(x.min(), x.max())
    y = (indx_ky - k_grid_dim / 2) * np.pi / k_amplitude
    z = (indx_kz - k_grid_dim / 2) * np.pi / k_amplitude

    xx, yy, zz = np.meshgrid(x[:, 0, 0], y[0, :, 0], z[0, 0, :])
    # Combine to create k_grid
    k_grid = np.sqrt(k_x ** 2 + k_y ** 2 + k_z ** 2)

    # Now calculate power spectral density for index of refraction on k_grid
    k0 = 0.1
    km = 1000
    pow_spec_dens = 0.033 / (k0 + k_grid) ** (11 / 6) * np.exp(-k_grid ** 2 / km ** 2)

    L0 = 2*np.pi / k0
    l0 = 2*np.pi / km
    print(L0, l0)

    # Get kernel in position space
    pos_kernel = (-1) ** (indx_kx + indx_ky + indx_kz) * fft.ifftn((-1) ** (indx_kx + indx_ky + indx_kz) * np.sqrt(pow_spec_dens))

    # Obtain realizations of noise filtered by pos_kernel
    file = "phase_screens/"
    args = zip(get_seeds(4), repeat(N_gridpts), repeat(pos_kernel), repeat(xx), repeat(yy), repeat(zz), repeat(file))
    with Pool() as pool:
        realizations = list(pool.imap(get_realization, args))


    plt.figure(1)
    plt.imshow(realizations[1][N_gridpts // 2].real, origin='lower')
    plt.colorbar()

    save_realization(realizations[0], 1, xx, yy, zz)
    """
    plt.figure(2)
    plt.imshow(np.mean(realizations).real, origin='lower')
    plt.colorbar()
    """
    plt.show()