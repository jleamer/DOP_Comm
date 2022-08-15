import numpy as np
import matplotlib.pyplot as plt
from matplotlib import animation
from process_phase_screen_results import get_filenames


def list_slices(file_list):
    slice_list = []
    for _ in file_list:
        temp = np.load(_)
        slice_list.append(temp['f'].reshape((256, 256, 256))[100])

    return slice_list


def init():
    im.set_data(np.zeros((256, 256)))
    return [im]


def animate(i):
    im.set_data(data_slices[i])
    return [im]


if __name__ == "__main__":
    # Load files
    directory = "phase_volumes/compressed_vols"
    files = get_filenames(directory)

    # Get slices from list
    data_slices = list_slices(files)

    # Create skeleton of plot
    fig = plt.figure()
    ax = plt.subplot(1, 1, 1)
    im = ax.imshow(np.zeros((256, 256)))
    fig.colorbar(im)

    anim = animation.FuncAnimation(fig, animate, init_func=init, frames=200, interval=20, blit=False)
    anim.save('basic_animation.mp4', fps=30, extra_args=['-vcodec', 'libx264'])
    """
    Steps:
        1) load files ignoring after - we've already checked that their the same
        2) take the first file in the list and get the 3D array of refractive index fluctuations
        3) take a random slice of the 3D array to get a 2D array and plot
        4) repeat, animating the slices
    """

    plt.show()
