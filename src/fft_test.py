import numpy as np
import matplotlib.pyplot as plt
from scipy import fft

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
kx = (index - x_grid_dim / 2) * (np.pi / x_amplitude)

# Set up minus array
minus = (-1) ** np.arange(x_grid_dim)

# Define analytic correlation and calculate spectral density
analytic_corr = a ** 2 * np.exp(-np.abs(x/r0))
spec_dens = minus * fft.fft(minus * analytic_corr) * dx / (2 * np.pi)

# Define analtyic spectral density and calculate corr
#analytic_spec_dens = a ** 2 * r0 ** 3 / (np.pi ** 2 * (1 + r0 ** 2 * k ** 2) ** 2)
analytic_spec_dens = a ** 2 * r0 / (np.pi * (1 + kx ** 2 * r0 ** 2))
corr = minus * fft.ifft(minus * analytic_spec_dens) / dx * 2 * np.pi

plt.figure(1)
plt.plot(kx, spec_dens, label='From FFT')
plt.plot(kx, analytic_spec_dens, label='From Eqn')
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
# Try same approach for a known 3D function from Tatarski
#
########################################################

# Define grid terms for z
z_amplitude = 10
z_grid_dim = 256
dz = 2 * z_amplitude / z_grid_dim
z_index = np.arange(z_grid_dim)
z = (z_index - z_grid_dim / 2) * dz
kz = (index - z_grid_dim / 2) * (np.pi / z_amplitude)

# Define mesh grid for space and spatial frequency
X, Y, Z = np.meshgrid(x, y, z)
Kx, Ky, Kz = np.meshgrid(kx, ky, kz)

# Define analytic functions
R = np.sqrt(X ** 2 + Y ** 2 + Z ** 2)
analytic_corr_3D = a ** 2 * np.exp(-np.abs(R/r0))
K = np.sqrt(Kx ** 2 + Ky ** 2 + Kz ** 2)
#analytic_spec_dens_3D = a ** 2 * r0 ** 3 / (np.pi ** 2 * (1 + r0 ** 2 * K ** 2) ** 2)
analytic_spec_dens_3D = a ** 2 * r0 / (np.pi * (1 + K ** 2 * r0 ** 2))


# Create arrays for minus terms
minus_x = np.array([[[(-1) ** i for k in range(z_grid_dim)] for j in range(y_grid_dim)] for i in range(x_grid_dim)])
minus_y = minus_x.transpose((1, 0, 2)).copy()
minus_z = minus_x.transpose((2, 1, 0)).copy()

# Calculate FFT and iFFT
# Does not work as written - need to figure out how to handle minuses properly
spec_dens_3D = minus_x * fft.fft(minus_x * minus_y * fft.fft(minus_y * minus_z * fft.fft(minus_z * analytic_corr_3D, axis=2) * dx / np.sqrt(2*np.pi), axis=1) * dy / np.sqrt(2*np.pi), axis=0) * dz / np.sqrt(2*np.pi)
corr_3D = minus_x * fft.ifft(minus_x * minus_y * fft.ifft(minus_y * minus_z * fft.ifft(minus_z * analytic_spec_dens_3D, axis=2) / dx * np.sqrt(2*np.pi), axis=1) / dy * np.sqrt(2*np.pi), axis=0) / dz * np.sqrt(2*np.pi)

# Check that they are equal
print("Analytic Corr = Calculated Corr?: ", np.allclose(analytic_corr_3D, corr_3D.real))
print("Analytic Spec Dens = Calculated Spec Dens?: ", np.allclose(analytic_spec_dens_3D, spec_dens_3D.real))

fig5 = plt.figure(5)
ax5 = fig5.add_subplot(projection='3d')
ax5.plot_wireframe(Kx[:, :, 128], Ky[:, :, 128], analytic_spec_dens_3D[:, :, 128], label='Analytic')
ax5.plot_wireframe(Kx[:, :, 128], Ky[:, :, 128], spec_dens_3D[:, :, 128], label='FFT', color='orange')
ax5.set_xlabel("Kx")
ax5.set_ylabel("Ky")
ax5.set_zlabel("phi(kx, ky, kz=kz[128])")
ax5.legend(numpoints=1)

plt.show()