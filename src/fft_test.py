import numpy as np
import matplotlib.pyplot as plt
from scipy import fft
from scipy import integrate

#########################################
#
# 1st Tatarski example
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
# Spec Dens from before should be related to 3D density by derivative
#
########################################################

# Integrate 3D spec dens to check that the 1D spec dens from previous section is recovered
analytic_spec_dens_3D = a ** 2 * r0 ** 3 / (np.pi ** 2 * (1 + kx ** 2 * r0 ** 2) ** 2)
check_spec_dens = integrate.simpson(-2 * np.pi * kx * analytic_spec_dens_3D, kx)
analytic_diff = analytic_spec_dens[-1] - analytic_spec_dens[0]
print(np.allclose(check_spec_dens, analytic_diff))

########################################################
#
# Check that structure function is obtained from power spectral density
#
########################################################

# Define inner and outer scale for constructing grid
l_outer = 10
l_inner = 1e-3

# Define k_outer and k_inner
k_outer = 2*np.pi / l_outer
k_inner = 5.92 / l_inner

# Construct grid
dx = 2 * l_inner
x_grid_dim = int(2 ** np.floor(np.log2((l_outer - l_inner) / dx)))
x_index = np.arange(x_grid_dim)
x = (x_index - x_grid_dim / 2) * dx
minus = (-1) ** np.arange(x_grid_dim)

# Construct k space grid
kx = (x_index - x_grid_dim / 2) * (np.pi / l_outer)
print(kx[int(x_grid_dim/2)])

phi = 0.033 * np.exp(-kx ** 2 / k_inner ** 2) / (k_outer ** 2 + kx ** 2) ** (11/6)
#kx[int(x_grid_dim/2)] = k_outer
#phi = 0.033 * kx ** (-11/3)
v = np.array([integrate.simpson(-2 * np.pi * kx[0:i+1] * phi[0:i+1], kx[0:i+1]) for i in range(x_grid_dim)])
plt.figure(4)
plt.loglog(kx[int(x_grid_dim/2):], phi[int(x_grid_dim/2):])
gamma = minus * fft.ifft(minus * v) / dx * (2 * np.pi)
d = x[int(x_grid_dim/2):] ** (2/3)
d_from_gamma = 2 * (gamma[int(x_grid_dim/2)] - gamma[int(x_grid_dim/2):])
print(d_from_gamma)
plt.figure(3)
plt.plot(x[int(x_grid_dim/2):], d, label='Analytic')
plt.plot(x[int(x_grid_dim/2):], d_from_gamma, label='From Gamma')
plt.legend(numpoints=1)

print(kx)

########################################################
#
# According to Goodman, gamma = 4pi/r * int(phi*k*sin(k*r) dk, 0, infty)
#
########################################################
gamma = np.array([4 * np.pi * np.array([integrate.simpson(phi[0:i+1] * kx[0:i+1] * np.sin(kx[0:i+1] * _), kx[0:i+1]) for i in range(x_grid_dim)]) for _ in x])
temp = x.copy()
temp[int(x_grid_dim/2)] = 1
gamma /= temp
gamma[int(x_grid_dim/2)] = 1
d_from_gamma = 2 * (gamma[int(x_grid_dim/2)] - gamma[int(x_grid_dim/2):])
print(d_from_gamma)
plt.figure(5)
plt.plot(x[int(x_grid_dim/2):], d, label='Analytic')
plt.plot(x[int(x_grid_dim/2):], d_from_gamma, label='From Gamma')
plt.legend(numpoints=1)

plt.show()