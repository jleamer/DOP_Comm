import os
from string import Template
import numpy as np
from scipy.stats import truncnorm
import time


def create_new_model_file(template_filename, output_filename, num_r, num_phi, etc):
    """
    function for constructing new comsol model files from the provided template
    total number of rays will be num_r * num_phi + 1
    :param template_filename:   location of the .java file to use as the template
    :param output_filename:     location where the finished file will be output
    :param num_r:               number of radial positions to use for rays
    :param num_phi:             number of azimuthal positions to use for rays
    :param etc:                 extra arguments for telling comsol where to save results to
    :return:
    """
    # Load template file, read previous code, then close
    template_file = open(template_filename, "r")
    prev_code = Template(template_file.read())
    template_file.close()

    # Apply changes to code
    temp = prev_code.substitute(
        name=etc['name'],
        int=etc['int_file'],
        s1=etc['s1_file'],
        s2=etc['s2_file'],
        s3=etc['s3_file'],
        s0=etc['s0_file'],
        nrad="\"" + str(num_r) + "\"",
        nphi="\"" + str(num_phi) + "\""
    )

    new_code = open(output_filename, "w+")
    new_code.write(temp)
    new_code.close()


if __name__ == "__main__":
    start = time.time()

    # For now keep the number of azimuthal positions fixed
    azimuthal_pos = 10

    # Maximum number of radial positions
    max_rad = 1000

    # Loop over radial positions
    for i in range(43, 44):
        # Define template filename and output filename
        template_name = "ray_convergence/template.java"
        output_name = "ray_convergence/class_files/ray_conv_" + str(i) + ".java"

        # Create parameter list
        params = {'name': "ray_conv_" + str(i),
                  'int_file': "\"ray_convergence/Int/" + str(i) + ".csv\"",
                  's1_file': "\"ray_convergence/s1/" + str(i) + ".csv\"",
                  's2_file': "\"ray_convergence/s2/" + str(i) + ".csv\"",
                  's3_file': "\"ray_convergence/s3/" + str(i) + ".csv\"",
                  's0_file': "\"ray_convergence/s0/" + str(i) + ".csv\"",
                  }

        # Create new model file
        create_new_model_file(template_name, output_name, i, azimuthal_pos, params)

        # Compile comsol class file from java file
        temp = os.system("comsol compile -jdkroot /usr/bin/java " + output_name)

        # Run simulation
        class_filename = "ray_convergence/class_files/ray_conv_" + str(i) + ".class"
        temp2 = os.system("comsol batch -inputfile " + class_filename + "\n")

    print("Time elapsed: ", time.time() - start)