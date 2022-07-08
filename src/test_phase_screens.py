import numpy as np
import os
import matplotlib.pyplot as plt
from multiprocessing import Pool
from scipy.signal import convolve

def loadtxt(file):
    return np.loadtxt(file, delimiter=',')

if __name__ == "__main__":
    # Load files in directory
    path = "phase_screens/10/"
    screen_files = os.listdir(path)
    screen_files = [path + _ for _ in screen_files]

    with Pool() as pool:
        screens = list(pool.imap(loadtxt, screen_files))

    N_gridpts = 1024
    screens = np.array([_ * _[N_gridpts//2, N_gridpts//2] for _ in screens])

    # Calculate mean
    plt.figure(1)
    plt.imshow(np.mean(screens, axis=0))
    plt.colorbar()
    plt.show()
