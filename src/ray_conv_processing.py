import numpy as np
import matplotlib.pyplot as plt
import os
from process_rays import get_filenames


if __name__ == "__main__":
    # Define directory
    dir = "ray_convergence"

    # Get lists of filenames using get_filenames
    int_files = get_filenames(dir + "/Int")
    s1_files = get_filenames(dir + "/s1")
    s2_files = get_filenames(dir + "/s2")
    s3_files = get_filenames(dir + "/s3")

    # Get mean stokes parameter values at end of each iteration
    #   Ignore 0th element in files because that's the time
    s1 = np.array([np.nanmean(np.loadtxt(_, delimiter=',', skiprows=6)[1:]) for _ in s1_files])
    s2 = np.array([np.nanmean(np.loadtxt(_, delimiter=',', skiprows=6)[1:]) for _ in s2_files])
    s3 = np.array([np.nanmean(np.loadtxt(_, delimiter=',', skiprows=6)[1:]) for _ in s3_files])

    # Calculate dop of each iteration
    #   COMSOL calculated normalized stokes parameters, so no need to use int or s0
    dop = np.sqrt(s1 ** 2 + s2 ** 2 + s3 ** 2)
    print(np.nanmean(dop))

    # Calculate number of rays
    num_rad = np.arange(1000)
    num_azimuthal = 10
    num_rays = num_azimuthal * num_rad + 1

    # Plot dop vs number of rays to check for convergence
    plt.figure(1)
    plt.plot(num_rays, dop, 'o-', label='Final DOP')
    plt.xlabel("Number of rays")
    plt.ylabel("DOP")
    plt.ylim([0, 0.3])
    plt.savefig(dir + "/figs/dop_conv.png", format='png', dpi=300)
    plt.show()