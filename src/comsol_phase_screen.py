import os
import numpy as np
from string import Template


def get_filenames(directory):
    """
    creates array of filenames in given dir for accessing
    :param directory:       directory to pull from
    :return:                array of filenames
    """
    files = np.sort(os.listdir(directory))
    return np.array([directory + "/" + _ for _ in files])


def create_func(func_name, screen_file):
    """
    function that creates the code for the interpolation function to insert into phase_screen.java file using templates
    Base outline:
        model.func().create(name, "Interpolation");
        model.func(name).set("source", "file");
        model.func(name).set(screen, "/home/jacob/PycharmProjects/DOP_Comm/src/phase_screens/00.csv");
        model.func(name).set("nargs", 3);
        model.func(name).set("fununit", new String[]{"1"});
        model.func(name).set("argunit", new String[]{"m", "m", "m"});
    :param func_name:       name to use for the function
    :param screen_file:     filename for the file screen to create interpolation function
    :return:                code block
    """
    func_code = "model.func().create(\"" + func_name + "\", \"Interpolation\"); \n"
    func_code += "model.func(\"" + func_name + "\").set(\"source\", \"file\"); \n"
    func_code += "model.func(\"" + func_name + "\").set(\"filename\", \"" + screen_file + "\"); \n"
    func_code += "model.func(\"" + func_name + "\").set(\"nargs\", \"3\"); \n"
    func_code += "model.func(\"" + func_name + "\").set(\"fununit\", new String[]{\"1\"}); \n"
    func_code += "model.func(\"" + func_name + "\").set(\"argunit\", new String[]{\"m\", \"m\", \"m\"}); \n"
    return func_code


def add_geometry(geom_feature, geom_label, pos_x):
    """
    function that adds a new object and applies a new material on it using phase screens
    Base outline for geometry:
        model.component("comp1").geom("geom1").create("geom_feature", "Block");
        model.component("comp1").geom("geom1").feature("geom_feature").label(geom_label);
        model.component("comp1").geom("geom1").feature("geom_feature").set("pos", new String[]{"width/2", "0", "0"});
        model.component("comp1").geom("geom1").feature("geom_feature").set("size", new String[]{"screen_thickness", "depth", "height"});
        model.component("comp1").geom("geom1").feature("blk1").set("selresult", true);
    :param geom_feature:    name of the geometry feature in COMSOL
    :param geom_label:      label of the geometry feature in COMSOL
    :param pos_x:           x position of the geometry feature in COMSOL
    :return:                code block
    """
    # Store some code snippets for easier access when creating code blocks
    geom_create_prefactor = "model.component(\"comp1\").geom(\"geom1\").create(\""
    geom_label_prefactor = "model.component(\"comp1\").geom(\"geom1\").feature(\"" + geom_feature + "\").label(\""
    geom_set_prefactor = "model.component(\"comp1\").geom(\"geom1\").feature(\"" + geom_feature + "\").set(\""

    # Create geometry code
    geom_code = geom_create_prefactor + geom_feature + "\", \"Block\"); \n"
    geom_code += geom_label_prefactor + geom_label + "\"); \n"
    geom_code += geom_set_prefactor + "pos\", new String[]{\"" + str(pos_x) + "\", \"0\", \"0\"}); \n"
    geom_code += geom_set_prefactor + "size\", new String[]{\"screen_thickness\", \"depth\", \"height\"}); \n"
    geom_code += geom_set_prefactor + "selresult\", true);\n"

    return geom_code


def apply_material(mat_feature, mat_label, set_number, func_name):
    """
    function that creates and applies material to geometries in COMSOL
    Base outline for material:
        model.component("comp1").material().create("mat_feature", "Common");
            model.component("comp1").material("mat1").selection().named("geom1_blk1_dom");
        model.component("comp1").material("mat_feature").propertyGroup().create("RefractiveIndex", "Refractive index");
        model.component("comp1").material("mat_feature").label(mat_label);
        model.component("comp1").material("mat_feature").propertyGroup("RefractiveIndex").set("n", "");
        model.component("comp1").material("mat_feature").propertyGroup("RefractiveIndex").set("ki", "");
        model.component("comp1").material("mat_feature").propertyGroup("RefractiveIndex")
             .set("n", new String[]{"int1(x,y,z)", "0", "0", "0", "int1(x,y,z)", "0", "0", "0", "int1(x,y,z)"});
        model.component("comp1").material("mat_feature").propertyGroup("RefractiveIndex")
             .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    :param mat_feature:     name of the material feature
    :param mat_label:       label of the material feature
    :param set_number:      number to use for setting material
    :param func_name:       name of function to use for setting material
    :return:                code block
    """
    # Store code snippets for reuse
    mat_create_prefactor = "model.component(\"comp1\").material().create(\""
    mat_prefactor = "model.component(\"comp1\").material(\"" + mat_feature + "\")"

    # Create code block
    mat_code = mat_create_prefactor + mat_feature + "\", \"Common\"); \n"
    mat_code += mat_prefactor + ".selection().named(\"geom1_blk" + str(set_number) + "_dom\"); \n"
    mat_code += mat_prefactor + ".propertyGroup().create(\"RefractiveIndex\", \"Refractive index\"); \n"
    mat_code += mat_prefactor + ".label(\"" + mat_label + "\"); \n"
    mat_code += mat_prefactor + ".propertyGroup(\"RefractiveIndex\").set(\"n\", "
    mat_code += "new String[]{\"1+" + func_name + "(x,y,z)\", \"0\", \"0\", \"0\", \"1+" + func_name + "(x,y,z)\", \"0\", \"0\", \"0\", \"1+" + func_name + "(x,y,z)\"}); \n"
    mat_code += mat_prefactor + ".propertyGroup(\"RefractiveIndex\").set(\"ki\", "
    mat_code += "new String[]{\"0\", \"0\", \"0\", \"0\", \"0\", \"0\", \"0\", \"0\", \"0\"}); \n"

    return mat_code


def write_model_file(input_filename, output_filename, func_code, geom_code, mat_code, dop, int_file, s1_file, s2_file, s3_file):
    """
    function that edits java file
    outline:
        create java method that applies all the necessary steps for one phase screen
        create method calls for the main method of the java file for each method
        apply template to insert those changes into the file
        write to output
        close output
    :param input_filename:      filename of the file to be edited
    :param output_filename:     filename of the edited file
    :param func_code:           list of code segments for interpolation functions
    :param geom_code:           list of code segments for geometric objects
    :param mat_code:            list of code segments for setting material properties
    :param dop:                 desired input dop
    :param int_file:            location to save intensity results
    :param: s1_file:            location to save s1 results
    :param: s2_file:            location to save s2 results
    :param: s3_file:            location to save s3 results
    :return:                    nothing
    """
    # Read in java file and convert to template
    input_file = open(input_filename, "r")
    prev_java_code = input_file.read()
    output_text = Template(prev_java_code)
    input_file.close()

    # Loop over code segments and create java method implementing them
    code = ""
    calls = ""
    method_num = 0
    for _ in zip(func_code, geom_code, mat_code):
        # Create method heading
        code += "public static void phaseScreen" + str(method_num) + "(Model model) {\n"

        # Add code segments
        code += _[0] + _[1] + _[2]

        # End method code
        code += "}\n"

        # Add new function calls
        calls += "\tphaseScreen" + str(method_num) + "(model);\n"

        method_num += 1

    # Rename class to match ouput file name
    name = output_filename.split(".")[0]

    # Apply template
    output_text = output_text.substitute(name=name, funcs=code, calls=calls, dop=dop, int_file=int_file,
                                         s1_file=s1_file, s2_file=s2_file, s3_file=s3_file)

    output = open(output_filename, "w+")
    output.write(output_text)
    output.close()


if __name__ == "__main__":
    # Get phase screen files
    screen_files = get_filenames("phase_screens")
    num_screens = screen_files.size
    int_file = "\"phase_screens/intensity.csv\""
    s1_file = "\"phase_screens/s1.csv\""
    s2_file = "\"phase_screens/s2.csv\""
    s3_file = "\"phase_screens/s3.csv\""

    # Loop over screens and create code blocks for each
    func_code = []
    geom_code = []
    mat_code = []

    for i in range(2, num_screens+2):
        func_code.append(create_func("int" + str(i), screen_files[i-2]))
        geom_code.append(add_geometry("blk" + str(i), "Screen" + str(i), "width/" + str(num_screens) + "*" + str(i)))
        mat_code.append(apply_material("mat" + str(i), "Screen" + str(i), i, "int" + str(i)))

    # Write edits to file
    input_name = "phase_screen.java"
    output_name = "edited_phase_screen.java"
    dop = "\"" + str(0.2) + "\""
    write_model_file(input_name, output_name, func_code, geom_code, mat_code, dop, int_file, s1_file, s2_file, s3_file)

    # Compile java file into class file
    temp = os.system("comsol compile -jdkroot /usr/bin/java " + output_name)

    # Run COMSOL simulation
    class_filename = "edited_phase_screen.class"
    temp2 = os.system("comsol batch -inputfile " + class_filename)