import numpy as np
from scipy import fft
import matplotlib.pyplot as plt


if __name__ == '__main__':

    # Define the seed for generating random numbers and number of samples to use
    np.random.seed(1)
    samples = 100000

    # Define outer and inner scales in m
    #   outer scale is on order of 10's of m
    #   inner scale is on order of mm
    l_outer = 10
    l_inner = 1e-3

    # Define k_outer and k_inner
    k_outer = 2*np.pi / l_outer
    k_inner = 5.92 / l_inner

    # Create a block from l_inner to l_outer with grid spacing ~ l_inner
    dx = 2 * l_inner
    x_grid_dim = 2 ** np.floor(np.log2((l_outer - l_inner) / dx))
    x_index = np.arange(x_grid_dim)
    x = (x_index - x_grid_dim / 2) * dx

    # Create meshgrid - y and z are equal to x in this case
    X, Y, Z = np.meshgrid(x, x, x)

    # Get k space grid and meshgrid
    kx = (x_index - x_grid_dim / 2) * (np.pi / l_outer)
    Kx, Ky, Kz = np.meshgrid(kx, kx, kx)