import numpy as np
from scipy import fft
import matplotlib.pyplot as plt


def structure_function(separation_distance):
    return separation_distance ** (2/3)


if __name__ == '__main__':
    # Define the seed for generating random numbers
    np.random.seed(1)
    num_pts = 512
    samples = 100

    # Define array of r values in km - then use to get ks
    rs = np.linspace(0, 1, num_pts)
    ks = 2*np.pi / rs

    # Define inner scale value of k ~ 9 km^-1
    k_inner = 9

    # Calculate power spectral density
    """
    # Create array of wavenumbers for calculating power spectral density
    ks = np.logspace(1, 4, num_pts)
    print(ks)
    rs = 2*np.pi / ks

    # Define inner scale km
    km = 9000

    # Calculate power spectral density using ks and km
    pow_spec_dens = 0.033 * ks ** (-11/3) * np.exp(-ks**2 / km ** 2)

    # Calculate kernel as sqrt of pow_spec_dens
    kernel = np.sqrt(pow_spec_dens)

    # Generate Gaussian white noise vector
    # Consider the location to range from rs[start] to rs[end]
    samples = 100
    var = 0.01
    x = np.random.randn(samples, num_pts)

    # Get output noise vectors
    y = np.zeros((samples, num_pts), dtype=complex)
    for i in range(samples):
        # First Fourier transform x to k space
        x_k = fft.fft(x[i])
        y[i] = fft.ifft(kernel*x_k)

    plt.figure(1)
    plt.plot(y.real)
    plt.xlabel("Num Points")
    plt.ylabel("Noise")
    plt.title(str(samples) + " samples")

    print(y.T[4].size)
    cov = np.zeros((num_pts, num_pts), dtype=complex)
    dr = np.zeros((num_pts, num_pts), dtype=complex)
    for i in range(num_pts):
        for j in range(num_pts):
            cov[i][j] = np.mean(y.T[i] * y.T[j]).real
            dr[i][j] = np.mean((y[i] - y[j]) ** 2).real

    plt.figure(2)
    plt.imshow(cov.real)
    plt.colorbar()

    plt.figure(3)
    plt.imshow(dr.real)
    plt.colorbar()

    diag = [cov[i][i] for i in range(num_pts)]
    print(diag)
    
    # Algorithm for calculating phase change due to index of refraction fluctuations
    # Define 2D square matrix of Gaussian white noise with mean 0
    #   Important - needs to be power of two for FFT
    size = 64
    var = 0.01
    r_matrix = var * np.random.randn(size, size)

    # Calculate FFT of r_matrix * pow_spec_dens for each value of k
    phi = []
    for psd in pow_spec_dens:
        phi.append(fft.fft2(r_matrix * psd).real)
    """

    plt.show()