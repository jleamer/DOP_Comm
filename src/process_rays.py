import numpy as np
import matplotlib.pyplot as plt
import os

# Create lists for filenames
intensity_files = np.sort(os.listdir("Int"))
s1_files = np.sort(os.listdir("s1"))
s2_files = np.sort(os.listdir("s2"))
s3_files = np.sort(os.listdir("s3"))
x_files = np.sort(os.listdir("x"))
y_files = np.sort(os.listdir("y"))
z_files = np.sort(os.listdir("z"))

# Process files
num_files = intensity_files.size
num_rays = np.loadtxt("Int/" + intensity_files[0], skiprows=5, delimiter=',').size - 1

intensity = [np.sum(np.loadtxt("Int/" + intensity_files[i], skiprows=5, delimiter=',')[1:num_rays-1]) for i in range(num_files)]
s1 = [np.sum(np.loadtxt("s1/" + s1_files[i], skiprows=6, delimiter=',')[1:num_rays-1]) for i in range(num_files)]
s2 = [np.sum(np.loadtxt("s2/" + s2_files[i], skiprows=6, delimiter=',')[1:num_rays-1]) for i in range(num_files)]
s3 = [np.sum(np.loadtxt("s3/" + s3_files[i], skiprows=6, delimiter=',')[1:num_rays-1]) for i in range(num_files)]

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