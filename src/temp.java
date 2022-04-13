/*
 * temp.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Mar 4 2022, 14:24 by COMSOL 6.0.0.312. */
public class temp {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    model.label("2Dbubbles.mph");

    model.param().set("lda0", "795[nm]", "wavelength");
    model.param().set("f0", "c_const / lda0", "frequency");
    model.param().set("width", "20[um]", "length of channel");
    model.param().set("height", "10[um]", "height of channel");
    model.param().set("n", "1.33", "index of refraction of water");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 2);

    model.func().create("rn1", "Random");
    model.func("rn1").set("mean", 0.5);
    model.func("rn1").set("seedactive", true);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").lengthUnit("\u00b5m");
    model.component("comp1").geom("geom1").create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("r1").label("Channel");
    model.component("comp1").geom("geom1").feature("r1").set("size", new String[]{"width", "height"});
    model.component("comp1").geom("geom1").create("c1", "Circle");
    model.component("comp1").geom("geom1").feature("c1").set("pos", new String[]{"width*rn1(1)", "height*rn1(1)"});
    model.component("comp1").geom("geom1").feature("c1").set("r", "rn1(1)");
    model.component("comp1").geom("geom1").create("c2", "Circle");
    model.component("comp1").geom("geom1").feature("c2")
         .set("pos", new String[]{"width*abs(rn1(2))", "height*abs(rn1(2))"});
    model.component("comp1").geom("geom1").feature("c2").set("r", "abs(rn1(2))");
    model.component("comp1").geom("geom1").create("c3", "Circle");
    model.component("comp1").geom("geom1").feature("c3").set("pos", new int[]{10, 8});
    model.component("comp1").geom("geom1").feature("c3").set("r", "abs(rn1(3))");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat2").selection().set(2, 3, 4);
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");

    model.component("comp1").physics().create("ewfd", "ElectromagneticWavesFrequencyDomain", "geom1");

    model.component("comp1").view("view1").axis().set("xmax", 21);
    model.component("comp1").view("view1").axis().set("ymin", -1.8682546615600586);
    model.component("comp1").view("view1").axis().set("ymax", 11.868254661560059);

    model.component("comp1").material("mat1").label("Channel");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n", "0", "0", "0", "n", "0", "0", "0", "n"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    model.component("comp1").material("mat2").label("Bubbles");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    model.study().create("std1");
    model.study("std1").create("freq", "Frequency");

    model.result().dataset().create("rn1_ds1", "Grid1D");
    model.result().dataset().create("rn1_ds2", "Grid1D");
    model.result().create("pg1", "PlotGroup1D");
    model.result().create("pg2", "PlotGroup1D");
    model.result("pg1").create("plot1", "Function");
    model.result("pg1").feature("plot1").set("expr", "rn1(x)");
    model.result("pg2").create("plot1", "Function");
    model.result("pg2").feature("plot1").set("expr", "rn1(x)");

    model.study("std1").feature("freq").set("ngen", 1);
    model.study("std1").feature("freq").set("ngenactive", false);

    model.result().dataset("rn1_ds1").set("function", "rn1");
    model.result().dataset("rn1_ds2").set("function", "rn1");
    model.result("pg1").set("titletype", "manual");
    model.result("pg1").set("title", "rn1");
    model.result("pg1").set("ylabelactive", true);
    model.result("pg1").feature("plot1").set("solrepresentation", "solnum");
    model.result("pg1").feature("plot1").set("descr", "rn1");
    model.result("pg1").feature("plot1").set("xdataexpr", "x");
    model.result("pg1").feature("plot1").set("xdataunit", "m");
    model.result("pg1").feature("plot1").set("xdatadescractive", true);
    model.result("pg1").feature("plot1").set("xdatadescr", "");
    model.result("pg2").set("data", "rn1_ds2");
    model.result("pg2").set("titletype", "manual");
    model.result("pg2").set("title", "rn1");
    model.result("pg2").set("ylabelactive", true);
    model.result("pg2").feature("plot1").set("solrepresentation", "solnum");
    model.result("pg2").feature("plot1").set("descr", "rn1");
    model.result("pg2").feature("plot1").set("xdataexpr", "x");
    model.result("pg2").feature("plot1").set("xdataunit", "m");
    model.result("pg2").feature("plot1").set("xdatadescractive", true);
    model.result("pg2").feature("plot1").set("xdatadescr", "");

    model.label("2Dbubbles.mph");

    model.component("comp1").geom("geom1").feature("c1").setIndex("pos", 10.6, 0);
    model.component("comp1").geom("geom1").feature("c1").set("pos", new double[]{10.6, 4.3});

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
