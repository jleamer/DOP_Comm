/*
 * phase_screen.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Jul 8 2022, 16:06 by COMSOL 6.0.0.312. */
public class phase_screen {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");

    model.study().create("std1");
    model.study("std1").create("rtrac", "RayTracing");
    model.study("std1").feature("rtrac").setSolveFor("/physics/gop", true);

    model.param().set("lda0", "795[nm]");
    model.param().descr("lda0", "wavelength in vacuum");
    model.param().set("width", "1[m]");
    model.param().descr("width", "width of volume");
    model.param().set("height", "1[m]");
    model.param().descr("height", "height of volume");
    model.param().set("depth", "1[m]");
    model.param().descr("depth", "depth of volume");
    model.param().set("n_air", "1");
    model.param().descr("n_air", "index of refraction of air");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width", "depth", "height"});
    model.component("comp1").geom("geom1").runPre("fin");

    model.param().set("screen_thickness", "width/128");

    model.func().create("int1", "Interpolation");
    model.func("int1").set("source", "file");
    model.func("int1").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/phase_screens/3d/1_0.csv");
    model.func("int1").setIndex("fununit", 1, 0);
    model.func("int1").setIndex("argunit", "m", 0);
    model.func("int1").setIndex("argunit", "m", 1);
    model.func("int1").setIndex("argunit", "m", 2);
    model.func("int1").set("dseparator", "point");
    model.func("int1").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/phase_screens/3d/1.csv");

    model.component("comp1").geom("geom1").feature("blk1").set("pos", new String[]{"-width/2", "-depth/2", "0"});
    model.component("comp1").geom("geom1").feature("blk1").setIndex("pos", "-height/2", 2);
    model.component("comp1").geom("geom1").run("blk1");

    model.param().set("width", ".4[m]");
    model.param().set("height", ".4[m]");
    model.param().set("depth", ".4[m]");

    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive_index");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", new String[]{"int1(x,y,z)"});

    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");

    model.sol().create("sol1");
    model.sol("sol1").study("std1");
    model.sol("sol1").attach("std1");

    model.component("comp1").physics("gop").create("relg1", "ReleaseGrid", -1);
    model.component("comp1").physics("gop").feature("relg1").set("GridType", "Cylindrical");
    model.component("comp1").physics("gop").feature("relg1").set("Rc", "0.1[m]");
    model.component("comp1").physics("gop").feature("relg1").set("L0", new int[]{1, 0, 0});
    model.component("comp1").physics("gop").prop("IntensityComputation")
         .setIndex("IntensityComputation", "ComputeIntensityAndPower", 0);
    model.component("comp1").physics("gop").feature("relg1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("relg1").set("P0", 0.2);

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,1)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "Default");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().dataset().create("ray1", "Ray");
    model.result().dataset("ray1").set("solution", "sol1");
    model.result().dataset("ray1").set("posdof", new String[]{"comp1.qx", "comp1.qy", "comp1.qz"});
    model.result().dataset("ray1").set("geom", "geom1");
    model.result().dataset("ray1").set("rgeom", "pgeom_gop");
    model.result().dataset("ray1").set("rgeomspec", "fromphysics");
    model.result().dataset("ray1").set("physicsinterface", "gop");
    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").set("data", "dset1");
    model.result("pg1").label("Ray Trajectories (gop)");
    model.result("pg1").set("data", "ray1");
    model.result("pg1").create("rtrj1", "RayTrajectories");
    model.result("pg1").feature("rtrj1").set("linetype", "line");
    model.result("pg1").feature("rtrj1").create("col1", "Color");
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.I");
    model.result("pg1").feature("rtrj1").create("filt1", "RayTrajectoriesFilter");
    model.result().remove("pg1");
    model.result().dataset().remove("ray1");

    model.component("comp1").physics("gop").feature("relg1").set("qcc", new String[]{"-width", "0", "0"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,1)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "Default");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().dataset().create("ray1", "Ray");
    model.result().dataset("ray1").set("solution", "sol1");
    model.result().dataset("ray1").set("posdof", new String[]{"comp1.qx", "comp1.qy", "comp1.qz"});
    model.result().dataset("ray1").set("geom", "geom1");
    model.result().dataset("ray1").set("rgeom", "pgeom_gop");
    model.result().dataset("ray1").set("rgeomspec", "fromphysics");
    model.result().dataset("ray1").set("physicsinterface", "gop");
    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").set("data", "dset1");
    model.result("pg1").label("Ray Trajectories (gop)");
    model.result("pg1").set("data", "ray1");
    model.result("pg1").create("rtrj1", "RayTrajectories");
    model.result("pg1").feature("rtrj1").set("linetype", "line");
    model.result("pg1").feature("rtrj1").create("col1", "Color");
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.I");
    model.result("pg1").feature("rtrj1").create("filt1", "RayTrajectoriesFilter");

    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 101, 0);
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 51, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 71, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 61, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 62, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 63, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 64, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 65, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 66, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 67, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 68, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 69, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 68, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 67, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 68, 0);
    model.result("pg1").run();
    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").run();
    model.result("pg2").create("slc1", "Slice");
    model.result("pg2").feature("slc1").set("expr", "gop.nrefC");
    model.result("pg2").feature("slc1").set("descr", "Refractive index, C-line");
    model.result("pg2").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,1)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 69, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 70, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 71, 0);
    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 101, 0);
    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg2").feature("slc1").set("quickxnumber", 10);
    model.result("pg2").run();

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,5)");

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,5)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 501, 0);
    model.result("pg1").run();

    model.param().set("width", "2[m]");
    model.param().set("height", "2[m]");
    model.param().set("depth", "2[m]");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,5)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg1").run();

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,10)");

    model.component("comp1").physics("gop").feature("relg1").set("Rc", "0.5[m]");
    model.component("comp1").physics("gop").feature("relg1").setIndex("Ncr", 10, 0);
    model.component("comp1").physics("gop").feature("relg1").setIndex("Nphi", 20, 0);

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,10)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 1001, 0);
    model.result("pg1").run();
    model.result("pg2").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+100000*int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,10)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();

    model.func("int1").refresh();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,10)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();
    model.result().table().create("evl3", "Table");
    model.result().table("evl3").comments("Interactive 3D values");
    model.result().table("evl3").label("Evaluation 3D");
    model.result().table("evl3")
         .addRow(new double[]{-0.8999999999973003, 0.0972857728140647, 0.2549373291990295, 1.0000125012154162}, new double[]{0, 0, 0, 0});
    model.result().table("evl3")
         .addRow(new double[]{-0.8999999999973003, -0.004898736387503488, 0.3690578082655247, 1.0000257621888577}, new double[]{0, 0, 0, 0});
    model.result().table("evl3")
         .addRow(new double[]{-0.6999999999973003, -0.9381219207887206, 0.280299503759419, 1.0000227446665297}, new double[]{0, 0, 0, 0});
    model.result().table("evl3")
         .addRow(new double[]{-0.49999999999730016, -0.9174095552830733, 0.32501881436850655, 1.0000205929609365}, new double[]{0, 0, 0, 0});

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+10*int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,10)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().set(6);

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,10)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");

    return model;
  }

  public static Model run2(Model model) {
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.sn1");
    model.result("pg1").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+int1(x,y,z)"});

    model.param().set("width", "100[m]");

    model.component("comp1").physics("gop").feature("relg1").set("qcc", new String[]{"-width/2 +1", "0", "0"});

    model.component("comp1").geom("geom1").run("fin");

    model.component("comp1").physics("gop").feature("relg1").set("qcc", new String[]{"-width/2 -1", "0", "0"});

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,100)");

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,100)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 10001, 0);
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.I");
    model.result("pg1").run();
    model.result("pg2").run();
    model.result().table("evl3")
         .addRow(new double[]{-44.99999999986501, -0.8132963938582591, -0.8449892263515117, 1.000000607748736}, new double[]{0, 0, 0, 0});

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.1,1000)");

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").setIndex("looplevel", 10001, 0);
    model.result("pg1").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+10*int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.component("comp1").physics("gop").feature("wall1").selection().set(2, 3, 4, 5, 6);

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();
    model.result().table("evl3")
         .addRow(new double[]{35, 0.6272606768920959, -0.44432033272192506, 0.9999879735166566}, new double[]{0, 0, 0, 0});
    model.result().table("evl3")
         .addRow(new double[]{45.00000000000001, -0.22648618829421485, -0.31434859919609925, 1.000004431989048}, new double[]{0, 0, 0, 0});
    model.result().table("evl3")
         .addRow(new double[]{14.999999999999996, 0.6638590040444852, -0.4125534391105412, 1.0002450997874694}, new double[]{0, 0, 0, 0});
    model.result().table("evl3")
         .addRow(new double[]{14.99999999999999, 0.850305419999539, 0.15527460822054473, 0.9997226747976948}, new double[]{0, 0, 0, 0});
    model.result("pg1").run();
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.sn1");
    model.result("pg1").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+1*int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.param().set("width", "200[m]");
    model.param().set("height", "20[m]");
    model.param().set("depth", "20[m]");

    model.component("comp1").geom("geom1").run("fin");

    model.component("comp1").physics("gop").feature("relg1").set("Rc", "5[m]");
    model.component("comp1").physics("gop").feature("relg1").setIndex("Ncr", 20, 0);
    model.component("comp1").physics("gop").feature("relg1").setIndex("Nphi", 50, 0);

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,1000)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.1,700)");

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,700)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+100*int1(x,y,z)"});

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,700)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    model.func("int1").refresh();
    model.func("int1").refresh();
    model.func("int1").refresh();
    model.func("int1").refresh();

    model.param().set("width", "50[m]");
    model.param().set("height", "50[m]");
    model.param().set("depth", "50[m]");

    model.result("pg1").run();

    model.component("comp1").geom("geom1").run();

    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1+1*int1(x,y,z)"});

    model.param().set("width", "80[m]");

    model.component("comp1").physics("gop").feature("relg1").set("Rc", "20[m]");

    model.component("comp1").geom("geom1").run();

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.1,270)");

    model.sol("sol1").study("std1");

    model.study("std1").feature("rtrac").set("notlistsolnum", 1);
    model.study("std1").feature("rtrac").set("notsolnum", "auto");
    model.study("std1").feature("rtrac").set("listsolnum", 1);
    model.study("std1").feature("rtrac").set("solnum", "auto");

    model.sol("sol1").feature().remove("t1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "rtrac");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "rtrac");
    model.sol("sol1").create("t1", "Time");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.1,270)");
    model.sol("sol1").feature("t1").set("plot", "off");
    model.sol("sol1").feature("t1").set("plotgroup", "pg1");
    model.sol("sol1").feature("t1").set("plotfreq", "tout");
    model.sol("sol1").feature("t1").set("probesel", "all");
    model.sol("sol1").feature("t1").set("probes", new String[]{});
    model.sol("sol1").feature("t1").set("probefreq", "tsteps");
    model.sol("sol1").feature("t1").set("rtol", 1.0E-5);
    model.sol("sol1").feature("t1").set("atolglobalvaluemethod", "factor");
    model.sol("sol1").feature("t1").set("tstepsgenalpha", "strict");
    model.sol("sol1").feature("t1").set("endtimeinterpolation", true);
    model.sol("sol1").feature("t1").set("timemethod", "genalpha");
    model.sol("sol1").feature("t1").set("estrat", "exclude");
    model.sol("sol1").feature("t1").set("control", "rtrac");
    model.sol("sol1").feature("t1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").create("i1", "Iterative");
    model.sol("sol1").feature("t1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("t1").feature("i1").create("ja1", "Jacobi");
    model.sol("sol1").feature("t1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("t1").feature("fc1").set("ntolfact", 0.1);
    model.sol("sol1").feature("t1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    run2(model);
  }

}
