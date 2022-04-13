from string import Template
import numpy as np

# Open java file as created by COMSOL
input_filename = "Bubbles_2D.java"
input_file = open(input_filename, "r")

# Read in java file and convert to template
prev_java_code = input_file.read()
output_text = Template(prev_java_code)
input_file.close()

# Create random numbers for pos_x, pos_y, radius, and number of bubbles
np.random.seed(1)
min_bubbles = 10
max_bubbles = 20
num_bubbles = int(np.random.random() * (max_bubbles - min_bubbles + 1) + min_bubbles)

min_x_pos = 5
max_x_pos = 15
min_y_pos = 0
max_y_pos = 10
min_r = 0.1
max_r = 0.5

code = ""
for i in range(num_bubbles):
    # Create random pos_x, pos_y, and rad values
    rad = np.random.random() * (max_r - min_r + 1) + min_r
    x_pos = np.random.random() * (max_x_pos - min_x_pos - 2 * rad) + min_x_pos + rad
    y_pos = np.random.random() * (max_y_pos - min_y_pos - 2 * rad) + min_y_pos + rad

    """
    # Create code block
    code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature().create(\"c"+str(i)+"\", \"Circle\"); \n"
    code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature(\"c"+str(i)+"\").set(\"pos\", new String[] {\"rn1("+str(i)+\
            ")*(xmax-rn1("+str(i)+")-xmin-rn1("+str(i)+")+1)+xmin+rn1("+str(i)+")\", \"rn1("+str(i)+\
            ")*(ymax-rn1("+str(i)+")-ymin-rn1("+str(i)+")+1)+ymin+rn1("+str(i)+")\"}); \n"
    code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature(\"c"+str(i)+"\").set(\"r\", \"rn1("+str(i)+")*(rmax-rmin+1)+" \
                                                                                                 "rmin\"); \n"
    """
    # Create code block
    code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature().create(\"c"+str(i)+"\", \"Circle\"); \n"
    code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature(\"c"+str(i)+"\").set(\"pos\", new double[]{"+str(x_pos)+", "+str(y_pos)+"}); \n"
    code += "\t \tmodel.component(\"comp1\").geom(\"geom1\").feature(\"c"+str(i)+"\").set(\"r\", " + str(rad) + "); \n"

temp = output_text.substitute(what=code, name="Finished_Bubbles_2D")
output_file = "Finished_Bubbles_2D.java"
output = open(output_file, "w")
output.write(temp)
output.close()