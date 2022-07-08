/*
 * temp.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Jun 30 2022, 15:53 by COMSOL 6.0.0.312. */
public class temp {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    model.label("phase_screen.mph");

    model.param().set("lda0", "795[nm]", "wavelength in vacuum");
    model.param().set("screen_thickness", "0.1[m]", "thickness of phase screens");
    model.param().set("width", "1[m]", "width of channel");
    model.param().set("height", "1[m]", "height of channel");
    model.param().set("depth", "1[m]", "depth of channel");
    model.param().set("n_ch", "1", "index of refraction in channel");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.func().create("int1", "Interpolation");
    model.func("int1").set("source", "file");
    model.func("int1").set("dseparator", "comma");
    model.func("int1").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/phase_screens/00.csv");
    model.func("int1").set("nargs", 3);
    model.func("int1").set("fununit", new String[]{"1"});
    model.func("int1").set("argunit", new String[]{"m", "m", "m"});

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").label("Channel");
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width", "depth", "height"});
    model.component("comp1").geom("geom1").create("ps1", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps1").set("parmax1", "depth");
    model.component("comp1").geom("geom1").feature("ps1").set("parmax2", "height");
    model.component("comp1").geom("geom1").feature("ps1").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("ps2", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps2").label("Detector");
    model.component("comp1").geom("geom1").feature("ps2").set("pos", new String[]{"width", "0", "0"});
    model.component("comp1").geom("geom1").feature("ps2").set("parmax1", "depth");
    model.component("comp1").geom("geom1").feature("ps2").set("parmax2", "height");
    model.component("comp1").geom("geom1").feature("ps2").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").run();

    model.view().create("view2", 3);

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    model.component("comp1").physics("gop").create("relg1", "ReleaseGrid", -1);
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
