import os
from string import Template
import numpy as np


def write_model_file(seed, input_file, output_file):
    """
    function for editing java file to include random bubbles
    :param seed:            number for seeding np.random
    :param input_file:      input file name to edit
    :param output_file:     output file name to save to
    :return:
    """
    input_file = open(input_file, "r")

    # Read in java file and convert to template
    prev_java_code = input_file.read()
    output_text = Template(prev_java_code)
    input_file.close()

    # Create random numbers for pos_x, pos_y, radius, and number of bubbles
    np.random.seed(seed)
    min_bubbles = 100
    max_bubbles = 1000
    num_bubbles = int(np.random.random() * (max_bubbles - min_bubbles + 1) + min_bubbles)

    min_x_pos = 0.5
    max_x_pos = 1
    min_y_pos = 0
    max_y_pos = 1
    min_z_pos = 0
    max_z_pos = 1
    min_r = 0.001
    max_r = 0.025

    code = ""
    num_methods = 0
    for i in range(num_bubbles):
        # Create random pos_x, pos_y, and rad values
        rad = np.random.random() * (max_r - min_r) + min_r
        x_pos = np.random.random() * (max_x_pos - min_x_pos - 2 * rad) + min_x_pos + rad
        y_pos = np.random.random() * (max_y_pos - min_y_pos - 2 * rad) + min_y_pos + rad
        z_pos = np.random.random() * (max_z_pos - min_z_pos - 2 * rad) + min_z_pos + rad

        # Need to create a new method every 50 for adding spheres to java code due to memory limits
        if i % 50 == 0:
            code += "\tpublic static void createGeom" + str(num_methods) + "(Model model) {\n"
        # Create code block
        code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature().create(\"sph" + str(
            i) + "\", \"Sphere\"); \n"
        code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature(\"sph" + str(
            i) + "\").set(\"pos\", new double[]{" + str(x_pos) + ", " + str(y_pos) + ", " + str(z_pos) + "}); \n"
        code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature(\"sph" + str(i) + "\").set(\"r\", " + str(
            rad) + "); \n"

        if i % 50 == 49:
            code += "\t}\n"
            num_methods += 1

        if i == num_bubbles-1:
            code += "\t}\n"
            num_methods += 1

    class_name = "Finished_Bubbles_3D_" + str(seed)
    intensity_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/Int/ray_intensity_" + str(seed) + ".csv\""
    s1_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/s1/ray_s1_" + str(seed) + ".csv\""
    s2_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/s2/ray_s2_" + str(seed) + ".csv\""
    s3_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/s3/ray_s3_" + str(seed) + ".csv\""
    mat_set = "\t \tmodel.component(\"comp1\").material(\"mat2\").selection().set(1);"
    domain_set = "\t \tmodel.component(\"comp1\").physics(\"gop\").feature(\"wall1\").selection().set(" + str(6 + num_bubbles*8) + ");"
    call_geom = ""
    for i in range(num_methods):
        call_geom += "createGeom" + str(i) + "(model);"
    temp = output_text.substitute(what=code, name=class_name, int=intensity_file, s1=s1_file, s2=s2_file,
                                  s3=s3_file, set=mat_set, domain_set=domain_set, geom=call_geom)

    output = open(output_file, "w+")
    output.write(temp)
    output.close()


batch_filename = "comsol_batch.bat"

for i in range(10):
    # Open batch file
    batch_file = open(batch_filename, 'w+')

    # Define seed for random number generation
    seed = i

    # Define input and output filenames
    input_filename = "Bubbles_3D.java"
    output_filename = "output_class_files/Finished_Bubbles_3D_" + str(seed) + ".java"

    # Edit file
    write_model_file(seed, input_filename, output_filename)

    # Compile comsol file
    temp = os.system("comsol compile -jdkroot /usr/bin/java " + output_filename)

    # Write line to batch file
    class_filename = "Finished_Bubbles_3D_" + str(seed) + ".class"
    batch_file.write("comsol batch -inputfile " + class_filename + " -outputfile " + class_filename)
