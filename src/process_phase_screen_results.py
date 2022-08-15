import numpy as np
import matplotlib.pyplot as plt
import os


def get_filenames(directory):
    """
    creates array of filenames in given dir for accessing
    :param directory:       directory to pull from
    :return:                array of filenames
    """
    files = np.sort(os.listdir(directory))
    return np.array([directory + "/" + _ for _ in files])


def load_vals(directory):
    """
    function to load the values stored in files in a directory
    :param directory:           the directory to load from
    :return:                    an array of the the values in the file
    """
    int_files = get_filenames(directory + "/intensity")
    init_int = np.array([np.loadtxt(_, skiprows=5, delimiter=',')[0][1:] for _ in int_files])
    fin_int = np.array([np.loadtxt(_, skiprows=6, delimiter=',')[1:] for _ in int_files])
    intens = (init_int, fin_int)

    s1_files = get_filenames(directory + "/s1")
    init_s1 = np.array([np.loadtxt(_, skiprows=5, delimiter=',')[0][1:] for _ in s1_files])
    fin_s1 = np.array([np.loadtxt(_, skiprows=6, delimiter=',')[1:] for _ in s1_files])
    s1 = (init_s1, fin_s1)

    s2_files = get_filenames(directory + "/s2")
    init_s2 = np.array([np.loadtxt(_, skiprows=5, delimiter=',')[0][1:] for _ in s2_files])
    fin_s2 = np.array([np.loadtxt(_, skiprows=6, delimiter=',')[1:] for _ in s2_files])
    s2 = (init_s2, fin_s2)

    s3_files = get_filenames(directory + "/s3")
    init_s3 = np.array([np.loadtxt(_, skiprows=5, delimiter=',')[0][1:] for _ in s3_files])
    fin_s3 = np.array([np.loadtxt(_, skiprows=6, delimiter=',')[1:] for _ in s3_files])
    s3 = (init_s3, fin_s3)

    return intens, s1, s2, s3


def save_data():
    dop_list = [0.2, 0.4, 0.8]
    directory = "phase_volumes_arb_pol/P="
    for _ in dop_list:
        intensity, s1, s2, s3 = load_vals(directory + str(_))
        init_coll_s1 = np.array([np.nanmean(_) for _ in s1[0]])
        fin_coll_s1 = np.array([np.nanmean(_) for _ in s1[1]])

        init_coll_s2 = np.array([np.nanmean(_) for _ in s2[0]])
        fin_coll_s2 = np.array([np.nanmean(_) for _ in s2[1]])

        init_coll_s3 = np.array([np.nanmean(_) for _ in s3[0]])
        fin_coll_s3 = np.array([np.nanmean(_) for _ in s3[1]])

        init_dop = np.sqrt(init_coll_s1 ** 2 + init_coll_s2 ** 2 + init_coll_s3 ** 2)
        fin_dop = np.sqrt(fin_coll_s1 ** 2 + fin_coll_s2 ** 2 + fin_coll_s3 ** 2)


if __name__ == "__main__":
    dop_list = [0.2, 0.4, 0.8]
    directory = "phase_volumes_arb_pol/"
    fig_directory = "phase_volumes_arb_pol/figs/P="
    fig = 1

    # Create lists for saving dop and stokes parameters and writing to file
    mean_init_dop = []
    mean_fin_dop = []
    mean_init_s1 = []
    mean_fin_s1 = []
    mean_init_s2 = []
    mean_fin_s2 = []
    mean_init_s3 = []
    mean_fin_s3 = []
    for dop in dop_list:
        intensity, s1, s2, s3 = load_vals(directory + "P=" + str(dop))
        init_coll_s1 = np.array([np.nanmean(_) for _ in s1[0]])
        mean_init_s1.append(np.nanmean(init_coll_s1))
        fin_coll_s1 = np.array([np.nanmean(_) for _ in s1[1]])
        mean_fin_s1.append(np.nanmean(fin_coll_s1))

        init_coll_s2 = np.array([np.nanmean(_) for _ in s2[0]])
        mean_init_s2.append(np.nanmean(init_coll_s2))
        fin_coll_s2 = np.array([np.nanmean(_) for _ in s2[1]])
        mean_fin_s2.append(np.nanmean(fin_coll_s2))

        init_coll_s3 = np.array([np.nanmean(_) for _ in s3[0]])
        mean_init_s3.append(np.nanmean(init_coll_s3))
        fin_coll_s3 = np.array([np.nanmean(_) for _ in s3[1]])
        mean_fin_s3.append(np.nanmean(fin_coll_s3))

        init_dop = np.sqrt(init_coll_s1 ** 2 + init_coll_s2 ** 2 + init_coll_s3 ** 2)
        mean_init_dop.append(np.nanmean(init_dop))
        fin_dop = np.sqrt(fin_coll_s1 ** 2 + fin_coll_s2 ** 2 + fin_coll_s3 ** 2)
        mean_fin_dop.append(np.nanmean(fin_dop))

        print("Initial Intensity: ", np.nanmean(intensity[0]))
        print("Final Intensity: ", np.nanmean(intensity[1]))
        print("-----------------")
        print("Initial s1: ", np.nanmean(s1[0]))
        print("Final s1: ", np.nanmean(s1[1]))
        print("-----------------")
        print("Initial s2: ", np.nanmean(s2[0]))
        print("Final s2: ", np.nanmean(s2[1]))
        print("-----------------")
        print("Initial s3: ", np.nanmean(s3[0]))
        print("Final s3: ", np.nanmean(s3[1]))
        print("-----------------")
        print("Initial dop: ", np.nanmean(init_dop))
        print("Final dop: ", np.nanmean(fin_dop))

        title = "Arb. Pol"
        plt.figure(fig)
        fig += 1
        plt.plot(init_coll_s1, label='initial')
        plt.plot(fin_coll_s1, label='final')
        plt.xlabel("Iteration #")
        plt.ylabel("s1")
        plt.ylim([0.055, 0.65])
        plt.title(title)
        plt.legend(numpoints=1)

        plt.figure(fig)
        fig += 1
        plt.plot(init_coll_s2, label='initial')
        plt.plot(fin_coll_s2, label='final')
        plt.xlabel("Iteration #")
        plt.ylabel("s2")
        plt.ylim([-0.01, 0.01])
        plt.title(title)
        plt.legend(numpoints=1)

        plt.figure(fig)
        fig += 1
        plt.plot(init_coll_s3, label='initial')
        plt.plot(fin_coll_s3, label='final')
        plt.xlabel("Iteration #")
        plt.ylabel("s3")
        plt.ylim([-0.01, 0.01])
        plt.title(title)
        plt.legend(numpoints=1)

        plt.figure(fig)
        fig += 1
        plt.plot(init_dop, label='initial')
        plt.plot(fin_dop, label='final')
        plt.xlabel("Iteration #")
        plt.ylabel("DOP")
        plt.ylim([0.19, 0.21])
        plt.title(title)
        plt.legend(numpoints=1)
        plt.savefig(fig_directory + str(dop) + "/dop.png", format='png', dpi=300)

    init = np.vstack((np.array(mean_init_dop), np.array(mean_init_s1), np.array(mean_init_s2),
                      np.array(mean_init_s3)))
    print(mean_init_dop)
    fin = np.vstack((np.array(mean_fin_dop), np.array(mean_fin_s1), np.array(mean_fin_s2),
                      np.array(mean_fin_s3)))

    np.savetxt(directory + "turb_init.csv", init, delimiter=',')
    np.savetxt(directory + "turb_fin.csv", fin, delimiter=',')
    plt.show()