import numpy as np
import matplotlib.pyplot as plt
from scipy import fft


def fft_3D(f_vals, i_grid, j_grid, k_grid, di, dj, dk):
    result = np.zeros_like(f_vals, dtype=complex)
    i_minus = (-1) ** np.arange(i_grid)
    j_minus = (-1) ** np.arange(j_grid)
    k_minus = (-1) ** np.arange(k_grid)

    for j in range(j_grid):
        for k in range(k_grid):
            result[:, j, k] += i_minus * fft.fft(i_minus * f_vals[:, j, k]) * di / (2 * np.pi)

    for i in range(i_grid):
        for k in range(k_grid):
            result[i, :, k] += j_minus * fft.fft(j_minus * f_vals[i, :, k]) * dj / (2 * np.pi)

    for i in range(i_grid):
        for j in range(j_grid):
            result[i, j, :] += k_minus * fft.fft(k_minus * f_vals[i, j, :]) * dk / (2 * np.pi)

    return result / (2 * np.pi) ** 2


def fft_2D(f_vals, x_grid, y_grid, delta_x, delta_y):
    i_minus = (-1) ** np.arange(x_grid)

    x_minus = np.array([i_minus for _ in range(x_grid)])
    minus = np.array([[(-1) ** (i+j) for i in range(x_grid)] for j in range(y_grid)])

    result = x_minus * fft.fft(minus * fft.fft(x_minus.T * f_vals, axis=0) * delta_x / np.sqrt(2 * np.pi), axis=1) * delta_y / np.sqrt(2 * np.pi)
    #result = minus * fft.fft2(minus * f_vals) * delta_x * delta_y / (2 * np.pi)


    """
    for i in range(x_grid):
        result[i, :] = minus[i, :] * fft.fft(minus[i, :] * f_vals[i, :]) * delta_y / np.sqrt(2 * np.pi)

    for j in range(y_grid):
        result[:, j] = minus[:, j] * fft.fft(minus[:, j] * result[:, j]) * delta_x / np.sqrt(2 * np.pi)
    """
    """
    temp = np.zeros_like(result, dtype=complex)
    for i in range(x_grid):
        for j in range(y_grid):
            temp = j_minus * fft.fft((-1) ** (i + j) * fft.fft(i_minus * f_vals[i, j]) * delta_x) * delta_y
    """

    #result = ii * fft.fft2(jj * f_vals) * delta_x * delta_y
    return result

#########################################
#
# 1D Tatarski example
#
#########################################
r0 = 0.5
a = 1

# Set up 1D grid
x_amplitude = 10
x_grid_dim = 256
dx = 2 * x_amplitude / x_grid_dim
index = np.arange(x_grid_dim)
x = (index - x_grid_dim / 2) * dx

# Get k space grid
k = (index - x_grid_dim / 2) * (np.pi / x_amplitude)

# Set up minus array
minus = (-1) ** np.arange(x_grid_dim)

# Define analytic correlation and calculate spectral density
analytic_corr = a ** 2 * np.exp(-np.abs(x/r0))
spec_dens = minus * fft.fft(minus * analytic_corr) * dx / (2 * np.pi)

# Define analtyic spectral density and calculate corr
#analytic_spec_dens = a ** 2 * r0 ** 3 / (np.pi ** 2 * (1 + r0 ** 2 * k ** 2) ** 2)
analytic_spec_dens = a ** 2 * r0 / (np.pi * (1 + k ** 2 * r0 ** 2))
corr = minus * fft.ifft(minus * analytic_spec_dens) / dx * 2 * np.pi

plt.figure(1)
plt.plot(k, spec_dens, label='From FFT')
plt.plot(k, analytic_spec_dens, label='From Eqn')
plt.ylabel("phi(k)")
plt.xlabel("k")
plt.legend(numpoints=1)

plt.figure(2)
plt.plot(x, corr, label='From iFFT')
plt.plot(x, analytic_corr, label='From Eqn')
plt.xlabel('r')
plt.ylabel("gamma(r)")
plt.legend(numpoints=1)

########################################################
#
# Try same approach for a known 2D function
#
########################################################
y_amplitude = 10
y_grid_dim = 256
dy = 2 * y_amplitude / y_grid_dim
y_index = np.arange(y_grid_dim)
y = (y_index - y_grid_dim / 2) * dy
ky = (index - y_grid_dim / 2) * (np.pi / y_amplitude)

# Define mesh grid for (x, y) and (kx, ky)
X, Y = np.meshgrid(x, y)
Kx, Ky = np.meshgrid(k, ky)

#print(np.allclose(Kx, 2*np.pi*X/(x_grid_dim * dx ** 2)))

# Define analytic functions
analytic_f = np.exp(-np.pi * (X ** 2 + Y ** 2))
analytic_g = 1/(2*np.pi) * np.exp(-1/(4*np.pi) * (Kx ** 2 + Ky ** 2))

# Attempt to calculate Fourier transform of each
#g = fft_2D(analytic_f, x_grid_dim, y_grid_dim, dx, dy)
minus_mk = np.array([[(-1) ** (i+j) for i in range(x_grid_dim)] for j in range(y_grid_dim)])
minus_l = np.array([minus for _ in range(x_grid_dim)])
g = minus_l * fft.fft(minus_mk * fft.fft(minus_l.T * analytic_f, axis=0) * dx / np.sqrt(2 * np.pi), axis=1) * dy / np.sqrt(2 * np.pi)
print("Analytic g = Calculated g?: ", np.allclose(analytic_g, g.real))

fig3 = plt.figure(3)
ax3 = fig3.add_subplot(projection='3d')
ax3.plot_wireframe(Kx, Ky, analytic_g, label='Analytic')
ax3.plot_wireframe(Kx, Ky, g, label='FFT', color="orange")
ax3.set_xlabel("Kx")
ax3.set_ylabel("Ky")
ax3.set_zlabel("g(kx, ky)")
ax3.legend(numpoints=1)

# Attempt to calculate the inverse Fourier transform of each
f = minus_l * fft.ifft(minus_mk * fft.ifft(minus_l.T * analytic_g, axis=0) / dx * np.sqrt(2*np.pi), axis=1) / dy * np.sqrt(2*np.pi)
print("Analytic f = Calculated f?: ", np.allclose(analytic_f, f.real))

fig4 = plt.figure(4)
ax4 = fig4.add_subplot(projection='3d')
ax4.plot_wireframe(X, Y, analytic_f, label='Analytic')
ax4.plot_wireframe(X, Y, f, color='orange', label='iFFT')
ax4.set_xlabel("X")
ax4.set_ylabel("Y")
ax4.set_zlabel("f(x, y)")
ax4.legend(numpoints=1)

"""
# Try 3D case now
# Define y and z grids
y_grid_dim = 256
z_grid_dim = 256

y_amplitude = 10
z_amplitude = 10

dy = 2 * y_amplitude / y_grid_dim
dz = 2 * z_amplitude / z_grid_dim

y_index = np.arange(y_grid_dim)
z_index = np.arange(z_grid_dim)

y = (y_index - y_grid_dim / 2) * dy
z = (z_index - z_grid_dim / 2) * dz

# Create k_y and k_z values
k_y = (y_index - y_grid_dim / 2) * (np.pi / y_amplitude)
k_z = (z_index - z_grid_dim / 2) * (np.pi / z_amplitude)

# Create 3D mesh grid for calculating functions
xx, yy, zz = np.meshgrid(x, y, z)
kkx, kky, kkz = np.meshgrid(k, k_y, k_z)

# Calculate analytical correlation function
analytic_corr_3D = a ** 2 * np.exp(-np.abs(np.sqrt(xx**2 + yy**2 + zz**2)/r0))


plt.figure(4)
plt.plot(xx[128, :, 128], label='x')
plt.plot(yy[:, 128, 128], label='y')
plt.plot(zz[128, 128, :], label='z')
plt.legend(numpoints=1)

plt.figure(5)
#plt.imshow(xx[:, :, 128], origin='lower')
#plt.imshow(yy[:, :, 128], origin='lower')
plt.imshow(zz[128, :, :], origin='lower')


fig3 = plt.figure(3)
ax3 = fig3.add_subplot(projection='3d')
ax3.plot_wireframe(xx[:, :, 128], yy[:, :, 128], analytic_corr_3D[:, :, 128])
ax3.set_xlabel("x")
ax3.set_ylabel("y")
ax3.set_zlabel("Corr")

# Calculate power spectral density by calculating the fourier transform over each dimension
temp = fft_3D(analytic_corr_3D, x_grid_dim, y_grid_dim, z_grid_dim, dx, dy, dz)
pow_spec_dens_3D = minus * fft.fft(minus * analytic_corr_3D) * dx / (2 * np.pi)
pow_spec_dens_3D = minus * fft.fft(minus * pow_spec_dens_3D) * dy / (2 * np.pi)
pow_spec_dens_3D = minus * fft.fft(minus * pow_spec_dens_3D) * dz / (2 * np.pi)

# Calculate analytical power spectral density
k = np.sqrt(kkx ** 2 + kky ** 2 + kkz ** 2)
analytic_spec_dens_3D = a ** 2 * r0 ** 3 / (np.pi ** 2 * (1 + r0 ** 2 * k ** 2) ** 2)
print(np.allclose(temp.real / temp.real.max(), analytic_spec_dens_3D / analytic_spec_dens_3D.max()))
fig4 = plt.figure(4)
ax4 = fig4.add_subplot(projection='3d')
ax4.plot_wireframe(kkx[:, :, 128], kky[:, :, 128], analytic_spec_dens_3D[:, :, 128])
ax4.plot_wireframe(kkx[:, :, 128], kky[:, :, 128], temp[:, :, 128], color='orange')
ax4.set_xlabel("kx")
ax4.set_ylabel("ky")
ax4.set_zlabel("phi(k)")
"""

plt.show()