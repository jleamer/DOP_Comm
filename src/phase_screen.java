/*
 * phase_screen.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Jul 8 2022, 16:20 by COMSOL 6.0.0.312. */
public class $name {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    model.param().set("lda0", "795[nm]", "wavelength in vacuum");
    model.param().set("width", "80[m]", "width of volume");
    model.param().set("height", "50[m]", "height of volume");
    model.param().set("depth", "50[m]", "depth of volume");
    model.param().set("n_air", "1", "index of refraction of air");
    model.param().set("screen_thickness", "width/128");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.result().table().create("evl3", "Table");

    model.func().create("int1", "Interpolation");
    model.func("int1").set("source", "file");
    model.func("int1").set("filename", "$interp");
    model.func("int1").set("nargs", 3);
    model.func("int1").set("fununit", new String[]{"1"});
    model.func("int1").set("argunit", new String[]{"m", "m", "m"});

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1")
         .set("pos", new String[]{"-width/2", "-depth/2", "-height/2"});
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width", "depth", "height"});
    model.component("comp1").geom("geom1").run();
    model.component("comp1").geom("geom1").run("fin");

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    model.component("comp1").physics("gop").create("relg1", "ReleaseGrid", -1);
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().set(2, 3, 4, 5, 6);

    model.result().table("evl3").label("Evaluation 3D");
    model.result().table("evl3").comments("Interactive 3D values");

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+1*int1(x,y,z)", "0", "0", "0", "1+1*int1(x,y,z)", "0", "0", "0", "1+1*int1(x,y,z)"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    model.component("comp1").physics("gop").prop("IntensityComputation")
         .set("IntensityComputation", "ComputeIntensityAndPower");
    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");
    model.component("comp1").physics("gop").feature("relg1").set("GridType", "Cylindrical");
    model.component("comp1").physics("gop").feature("relg1")
         .set("qcc", new String[][]{{"-width/2 -1"}, {"0"}, {"0"}});
    model.component("comp1").physics("gop").feature("relg1").set("Rc", "20[m]");
    model.component("comp1").physics("gop").feature("relg1").set("Ncr", 20);
    model.component("comp1").physics("gop").feature("relg1").set("Nphi", 50);
    model.component("comp1").physics("gop").feature("relg1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relg1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("relg1").set("P0", 0.2);

    model.study().create("std1");
    model.study("std1").create("rtrac", "RayTracing");

    model.sol().create("sol1");
    model.sol("sol1").study("std1");
    model.sol("sol1").attach("std1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature().remove("fcDef");

    model.result().dataset().create("ray1", "Ray");
    model.result().create("pg1", "PlotGroup3D");
    model.result().create("pg2", "PlotGroup3D");
    model.result("pg1").set("data", "ray1");
    model.result("pg1").create("rtrj1", "RayTrajectories");
    model.result("pg1").feature("rtrj1").create("col1", "Color");
    model.result("pg1").feature("rtrj1").create("filt1", "RayTrajectoriesFilter");
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.sn1");
    model.result("pg2").create("slc1", "Slice");
    model.result("pg2").feature("slc1").set("expr", "gop.nrefC");

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.1,270)");

    model.sol("sol1").attach("std1");
    model.sol("sol1").feature("st1").label("Compile Equations: Ray Tracing");
    model.sol("sol1").feature("v1").label("Dependent Variables 1.1");
    model.sol("sol1").feature("v1").set("clist", new String[]{"range(0,0.1,270)", "0.27[ns]"});
    model.sol("sol1").feature("t1").label("Time-Dependent Solver 1.1");
    model.sol("sol1").feature("t1").set("tunit", "ns");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,270)");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").feature("dDef").label("Direct 1");
    model.sol("sol1").feature("t1").feature("aDef").label("Advanced 1");
    model.sol("sol1").feature("t1").feature("fc1").label("Fully Coupled 1.1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature("i1").label("Iterative 1.1");
    model.sol("sol1").feature("t1").feature("i1").feature("ilDef").label("Incomplete LU 1");
    model.sol("sol1").feature("t1").feature("i1").feature("ja1").label("Jacobi 1.1");
    model.sol("sol1").runAll();

    model.result("pg1").label("Ray Trajectories (gop)");
    model.result("pg2").set("looplevel", new int[]{11});
    model.result("pg2").feature("slc1").set("quickxnumber", 10);
    model.result("pg2").feature("slc1").set("resolution", "normal");

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
