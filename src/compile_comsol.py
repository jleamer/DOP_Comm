import os
from string import Template
import numpy as np
import time


def check_overlap(a, b, c, d, pos):
    """
    function to check if the intervals (a, b) and (c, d) overlap
    :param a: lower bound of interval 1
    :param b: upper bound of interval 1
    :param c: lower bound of interval 2
    :param d: upper bound of interval 2
    :return:
    """
    # Create boolean arrays - set to false (0)
    c_gt_a = np.zeros(a.size, dtype=bool)
    c_lt_b = np.zeros(a.size, dtype=bool)
    d_gt_a = np.zeros(a.size, dtype=bool)
    d_lt_b = np.zeros(a.size, dtype=bool)
    pos_gt_a = np.zeros(a.size, dtype=bool)
    pos_lt_b = np.zeros(a.size, dtype=bool)

    # Assign 1 to indices where c and d are between a and b
    c_gt_a[a <= c] = True
    c_lt_b[c <= b] = True
    c_in_int1 = c_gt_a & c_lt_b

    d_gt_a[a <= d] = True
    d_lt_b[d <= b] = True
    d_in_int1 = d_gt_a & d_lt_b

    pos_gt_a[a <= pos] = True
    pos_lt_b[pos <= b] = True
    pos_in_int1 = pos_gt_a & pos_lt_b

    return c_in_int1 | d_in_int1 | pos_in_int1


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

    epsilon = 0.01  # create cushion around channel boundaries so comsol doesn't intersect them
    min_x_pos = 0.25
    max_x_pos = 1.25
    min_y_pos = 0 + epsilon
    max_y_pos = 1 - epsilon
    min_z_pos = 0 + epsilon
    max_z_pos = 1 - epsilon
    min_r = 0.01
    max_r = 0.025

    code = ""
    num_methods = 0

    # Create array for making sure that there is no overlap between spheres so comsol doesn't break
    num_skipped = 0
    x_lower_bounds = 100*np.ones(num_bubbles)
    x_upper_bounds = np.zeros(num_bubbles)
    y_lower_bounds = 100*np.ones(num_bubbles)
    y_upper_bounds = np.zeros(num_bubbles)
    z_lower_bounds = 100*np.ones(num_bubbles)
    z_upper_bounds = np.zeros(num_bubbles)
    for i in range(num_bubbles):
        # Create random pos_x, pos_y, and rad values
        rad = np.random.random() * (max_r - min_r) + min_r
        x_pos = np.random.random() * (max_x_pos - min_x_pos - 2 * rad) + min_x_pos + rad
        y_pos = np.random.random() * (max_y_pos - min_y_pos - 2 * rad) + min_y_pos + rad
        z_pos = np.random.random() * (max_z_pos - min_z_pos - 2 * rad) + min_z_pos + rad

        # Check for overlap
        x_overlap = check_overlap(x_lower_bounds, x_upper_bounds, x_pos - rad, x_pos + rad, x_pos)
        y_overlap = check_overlap(y_lower_bounds, y_upper_bounds, y_pos - rad, y_pos + rad, y_pos)
        z_overlap = check_overlap(z_lower_bounds, z_upper_bounds, z_pos - rad, z_pos + rad, z_pos)

        # Need to create a new method every 50 for adding spheres to java code due to memory limits
        if i % 50 == 0:
            code += "\tpublic static void createGeom" + str(num_methods) + "(Model model) {\n"

        if np.any(x_overlap & y_overlap & z_overlap):
            num_skipped += 1
        else:
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
        elif i == num_bubbles-1:
            code += "\t}\n"
            num_methods += 1

        x_lower_bounds[i] = x_pos - rad
        x_upper_bounds[i] = x_pos + rad
        y_lower_bounds[i] = y_pos - rad
        y_upper_bounds[i] = y_pos + rad
        z_lower_bounds[i] = z_pos - rad
        z_upper_bounds[i] = z_pos + rad

    class_name = "Finished_Bubbles_3D_" + str(seed)
    intensity_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/Int/ray_intensity_" + str(seed) + ".csv\""
    s1_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/s1/ray_s1_" + str(seed) + ".csv\""
    s2_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/s2/ray_s2_" + str(seed) + ".csv\""
    s3_file = "\"/home/jacob/PycharmProjects/DOP_Comm/src/s3/ray_s3_" + str(seed) + ".csv\""
    mat_set = "\t \tmodel.component(\"comp1\").material(\"mat2\").selection().set(1);"
    #domain_set = "\t \tmodel.component(\"comp1\").physics(\"gop\").feature(\"wall1\").selection().set(" + str(2 + (num_bubbles-num_skipped)*8) + ");"
    x_set = "\"/home/jacob/PycharmProjects/DOP_Comm/src/x/ray_x_" + str(seed) + ".csv\""
    y_set = "\"/home/jacob/PycharmProjects/DOP_Comm/src/y/ray_y_" + str(seed) + ".csv\""
    z_set = "\"/home/jacob/PycharmProjects/DOP_Comm/src/z/ray_z_" + str(seed) + ".csv\""
    call_geom = ""
    for i in range(num_methods):
        call_geom += "createGeom" + str(i) + "(model);"
    temp = output_text.substitute(what=code, name=class_name, int=intensity_file, s1=s1_file, s2=s2_file,
                                  s3=s3_file, set=mat_set, geom=call_geom, x=x_set, y=y_set, z=z_set)

    output = open(output_file, "w+")
    output.write(temp)
    output.close()


start = time.time()
#batch_filename = "output_class_files/comsol_batch.bat"
#batch_script = "#!/bin/bash\n"
#batch_file = open(batch_filename, 'w+')
for i in range(10):
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
    class_filename = "output_class_files/Finished_Bubbles_3D_" + str(seed) + ".class"
    mph_filename = "Finished_Bubbles_3D_" + str(seed) + ".mph"
    #batch_script += "comsol batch -inputfile " + class_filename + "\n"

    # run comsol batch
    temp2 = os.system("comsol batch -inputfile " + class_filename + "\n")

#batch_file.write(batch_script)
end = time.time()
print("Time elapsed: ", end-start)