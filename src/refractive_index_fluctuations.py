import numpy as np
from scipy import fft
import matplotlib.pyplot as plt


def structure_function(separation_distance):
    return separation_distance ** (2/3)


if __name__ == '__main__':

    # Define the seed for generating random numbers
    np.random.seed(1)
    num_pts = 512
    samples = 100000

    # Define outer and inner scales in m
    #   outer scale is on order of 10's of m
    #   inner scale is on order of mm
    l_outer = 50
    l_inner = 1e-3

    # Define k_outer and k_inner
    k_outer = 2*np.pi / l_outer
    k_inner = 5.92 / l_inner

    # Define array of r values in km - then use to get ks
    start_r = 0.001
    end_r = 1
    rs = np.linspace(l_inner, l_outer, num_pts)
    #print(rs)
    delta_r = rs[1] - rs[0]
    ks = 2*np.pi / rs
    print(ks[-1])

    # Define grid points
    grid_points = np.arange(num_pts)

    # Calculate power spectral density
    pow_spec_dens = 0.033 * ks ** (-5 / 3) # * np.exp(-ks ** 2 / k_inner ** 2)

    # Plot power_spectral density on log-log plot for comparison to analytical result in Goodman
    plt.figure(1)
    plt.loglog(ks, pow_spec_dens)
    plt.xlabel("k (m^-1)")
    plt.ylabel("Phi(k)/Cn2")

    # Calculate analytical autocorrelation function of r
    #   Needs to be continuous, so follow method in Denys's integrated notes for using the FFT to compute this
    minus = -1 ** grid_points
    analytic_autocorr = minus * fft.ifft(minus * pow_spec_dens) / delta_r
    test = minus * fft.fft(minus * analytic_autocorr) * delta_r
    print(np.allclose(test, pow_spec_dens))

    # Calculate kernel as sqrt of pow_spec_dens
    kernel = np.sqrt(pow_spec_dens)

    # Generate Gaussian white noise vector
    # Consider the location to range from rs[start] to rs[end]
    var = 1
    x = var * np.random.randn(samples, num_pts) / delta_r

    # Pad with zeros
    #padded_x = np.zeros((samples, 2*num_pts)).T
    #padded_kernel = np.zeros(2*num_pts)

    #padded_kernel[int(num_pts/2):int(3*num_pts/2)] += kernel
    #padded_x[int(num_pts/2):int(3*num_pts/2)] += x.T
    #padded_x = padded_x.T

    # Get output noise vectors
    y = np.zeros((samples, num_pts))
    for i in range(samples):
        # First Fourier transform x to k space
        x_k = minus * fft.fft(minus * x[i]) * delta_r
        y[i] = minus * fft.ifft(minus * kernel * x_k)

    plt.figure(2)
    plt.plot(y[0].real)
    plt.xlabel("Num Points")
    plt.ylabel("Noise")
    plt.title(str(samples) + " samples")

    # Calculate autocorrelation as a function of distance between points
    autocorr = np.array([np.mean(y.T[0] * _) for _ in y.T])
    autocorr_2 = np.array([np.mean(y.T[100] * _) for _ in y.T])

    plt.figure(3)
    plt.plot(analytic_autocorr, label='Analytic')
    plt.plot(autocorr, label='Calculated')
    plt.xlabel("Number of delta_rs")
    plt.legend(numpoints=1)

    dr = np.array([np.mean((y.T[0] - _) ** 2) for _ in y.T])
    second_dr = 2*(autocorr[0]*np.ones(num_pts) - autocorr)
    plt.figure(4)
    plt.plot(rs, dr, label='Calculated')
    analytical_dr = rs ** (2/3)
    plt.plot(rs, analytical_dr, label='Analytical')
    plt.plot(rs, second_dr, label='Alt Analytical')
    plt.xlabel("r (m)")
    plt.ylabel("D(r)/Cn2")
    plt.legend(numpoints=1)
    """
    # Create array of wavenumbers for calculating power spectral density
    num_pts = 32
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
    x = var * np.random.randn(samples, num_pts)

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