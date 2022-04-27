/*
 * test.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Apr 25 2022, 11:03 by COMSOL 6.0.0.312. */
public class test {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    model.label("3D_Bubbles.mph");

    model.param().set("lda0", "795[nm]", "wavelength of light");
    model.param().set("width", "1.5[m]", "width of channel");
    model.param().set("height", "1[m]", "height of channel");
    model.param().set("depth", "1[m]", "depth of channel");
    model.param().set("n_channel", "1.33", "index of refraction of channel");
    model.param().set("n_bubble", "1", "index of refraction of bubbles");
    model.param().set("x_det", "width+0.25[m]", "x position of detector");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.result().table().create("tbl2", "Table");
    model.result().table("tbl2").label("Ray Intensity");
    model.result().table("tbl2").comments("Ray Evaluation 1");
    model.result().table().create("tbl3", "Table");
    model.result().table("tbl3").label("Ray s1");
    model.result().table().create("tbl4", "Table");
    model.result().table("tbl4").label("Ray s2");
    model.result().table().create("tbl5", "Table");
    model.result().table("tbl5").label("Ray s3");

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").label("Channel");
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width", "depth", "height"});
    model.component("comp1").geom("geom1").create("blk2", "Block");
    model.component("comp1").geom("geom1").feature("blk2").label("Detector");
    model.component("comp1").geom("geom1").feature("blk2").set("pos", new String[]{"x_det", "0", "0"});
    model.component("comp1").geom("geom1").feature("blk2").set("size", new String[]{"0.01", "depth", "height"});
    model.component("comp1").geom("geom1").feature().create("sph0", "Sphere");
    model.component("comp1").geom("geom1").feature("sph0")
         .set("pos", new double[]{0.518340791926496, 0.3095623725820474, 0.1596759974678911});
    model.component("comp1").geom("geom1").feature("sph0").set("r", 0.018287787842611796);
    model.component("comp1").geom("geom1").feature().create("sph1", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1")
         .set("pos", new double[]{0.5951481592438935, 0.3465541194501757, 0.39743149190767935});
    model.component("comp1").geom("geom1").feature("sph1").set("r", 0.0032161262744511473);
    model.component("comp1").geom("geom1").feature().create("sph2", "Sphere");
    model.component("comp1").geom("geom1").feature("sph2")
         .set("pos", new double[]{0.7118487568691019, 0.6800586918146452, 0.21268715676205616});
    model.component("comp1").geom("geom1").feature("sph2").set("r", 0.013931601616080567);
    model.component("comp1").geom("geom1").feature().create("sph3", "Sphere");
    model.component("comp1").geom("geom1").feature("sph3")
         .set("pos", new double[]{0.5345594627758116, 0.6629414314928067, 0.42095576531985934});
    model.component("comp1").geom("geom1").feature("sph3").set("r", 0.02207481847338269);
    model.component("comp1").geom("geom1").feature().create("sph4", "Sphere");
    model.component("comp1").geom("geom1").feature("sph4")
         .set("pos", new double[]{0.5805564790804143, 0.2068013322157265, 0.792077978827178});
    model.component("comp1").geom("geom1").feature("sph4").set("r", 0.01440855588269804);
    model.component("comp1").geom("geom1").feature().create("sph5", "Sphere");
    model.component("comp1").geom("geom1").feature("sph5")
         .set("pos", new double[]{0.6657566422871432, 0.682999477691042, 0.8581431026145253});
    model.component("comp1").geom("geom1").feature("sph5").set("r", 0.024238277817265542);
    model.component("comp1").geom("geom1").feature().create("sph6", "Sphere");
    model.component("comp1").geom("geom1").feature("sph6")
         .set("pos", new double[]{0.5611706835134177, 0.05977017746306086, 0.18466861024914244});
    model.component("comp1").geom("geom1").feature("sph6").set("r", 0.02247055992409234);
    model.component("comp1").geom("geom1").feature().create("sph7", "Sphere");
    model.component("comp1").geom("geom1").feature("sph7")
         .set("pos", new double[]{0.5669067416575723, 0.4245907896436607, 0.9376733226917779});
    model.component("comp1").geom("geom1").feature("sph7").set("r", 0.022075420082305917);
    model.component("comp1").geom("geom1").feature().create("sph8", "Sphere");
    model.component("comp1").geom("geom1").feature("sph8")
         .set("pos", new double[]{0.8406442963726539, 0.32060591148010137, 0.6813550064539764});
    model.component("comp1").geom("geom1").feature("sph8").set("r", 0.01379596683935241);
    model.component("comp1").geom("geom1").feature().create("sph9", "Sphere");
    model.component("comp1").geom("geom1").feature("sph9")
         .set("pos", new double[]{0.5294059126861649, 0.7396227367023295, 0.9682985980186146});
    model.component("comp1").geom("geom1").feature("sph9").set("r", 0.021031016125536952);
    model.component("comp1").geom("geom1").feature().create("sph10", "Sphere");
    model.component("comp1").geom("geom1").feature("sph10")
         .set("pos", new double[]{0.6485457927368814, 0.7783121846072512, 0.11826848293711428});
    model.component("comp1").geom("geom1").feature("sph10").set("r", 0.018955975705116146);
    model.component("comp1").geom("geom1").feature().create("sph11", "Sphere");
    model.component("comp1").geom("geom1").feature("sph11")
         .set("pos", new double[]{0.9446962110686823, 0.2984639866451432, 0.2927623824023943});
    model.component("comp1").geom("geom1").feature("sph11").set("r", 0.011749444628221726);
    model.component("comp1").geom("geom1").feature().create("sph12", "Sphere");
    model.component("comp1").geom("geom1").feature("sph12")
         .set("pos", new double[]{0.5136445543720954, 0.6773616828823863, 0.21400469581520626});
    model.component("comp1").geom("geom1").feature("sph12").set("r", 0.0041206857308386646);
    model.component("comp1").geom("geom1").feature().create("sph13", "Sphere");
    model.component("comp1").geom("geom1").feature("sph13")
         .set("pos", new double[]{0.7459108438529125, 0.059948768063390515, 0.5730246495191536});
    model.component("comp1").geom("geom1").feature("sph13").set("r", 0.007373119824933429);
    model.component("comp1").geom("geom1").run();

    model.view().create("view2", 2);

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").label("Channel");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_channel", "0", "0", "0", "n_channel", "0", "0", "0", "n_channel"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    model.component("comp1").material("mat2").label("Bubble");
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_bubble", "0", "0", "0", "n_bubble", "0", "0", "0", "n_bubble"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    model.component("comp1").physics("gop").create("relb1", "ReleaseFromBoundary", 2);
    model.component("comp1").physics("gop").feature("relb1").selection().set(1);
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().set(7);
    model.component("comp1").physics("gop").prop("IntensityComputation")
         .set("IntensityComputation", "ComputeIntensityAndPower");
    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");
    model.component("comp1").physics("gop").feature("relb1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relb1").set("InitialPolarizationType", "PartiallyPolarized");

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
    model.result().dataset().create("cpl1", "CutPlane");
    model.result().dataset("cpl1").set("data", "ray1");
    model.result().numerical().create("ray1", "Ray");
    model.result().numerical().create("ray2", "Ray");
    model.result().numerical().create("ray3", "Ray");
    model.result().numerical().create("ray4", "Ray");
    model.result().numerical("ray1").set("probetag", "none");
    model.result().numerical("ray2").set("probetag", "none");
    model.result().numerical("ray3").set("probetag", "none");
    model.result().numerical("ray4").set("probetag", "none");
    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").set("data", "ray1");
    model.result("pg1").create("rtrj1", "RayTrajectories");
    model.result("pg1").feature("rtrj1").create("col1", "Color");
    model.result("pg1").feature("rtrj1").create("filt1", "RayTrajectoriesFilter");
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.I");
    model.result().export().create("tbl1", "Table");
    model.result().export().create("tbl2", "Table");
    model.result().export().create("tbl3", "Table");
    model.result().export().create("tbl4", "Table");

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,10)");

    model.sol("sol1").attach("std1");
    model.sol("sol1").feature("st1").label("Compile Equations: Ray Tracing");
    model.sol("sol1").feature("v1").label("Dependent Variables 1.1");
    model.sol("sol1").feature("v1").set("clist", new String[]{"range(0,0.01,10)", "0.01[ns]"});
    model.sol("sol1").feature("t1").label("Time-Dependent Solver 1.1");
    model.sol("sol1").feature("t1").set("tunit", "ns");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,10)");
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

    model.result().dataset("cpl1").set("planetype", "general");
    model.result().dataset("cpl1")
         .set("genpoints", new double[][]{{0.7500000000000001, 0.500001, 0.500001}, {1.58759, 1.04628, 0.500001}, {0.632878, 0.6795750000000002, 1.47676}});
    model.result().numerical("ray1").label("Ray Intensity");
    model.result().numerical("ray1").set("looplevelinput", new String[]{"last"});
    model.result().numerical("ray1").set("table", "tbl2");
    model.result().numerical("ray1").set("expr", "gop.I");
    model.result().numerical("ray1").set("unit", "W/m^2");
    model.result().numerical("ray1").set("descr", "Intensity");
    model.result().numerical("ray2").label("Ray sn1");
    model.result().numerical("ray2").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray2").set("looplevelindices", new String[]{"1, 1001"});
    model.result().numerical("ray2").set("table", "tbl3");
    model.result().numerical("ray2").set("expr", "gop.sn1");
    model.result().numerical("ray2").set("descr", "Normalized Stokes parameter 1");
    model.result().numerical("ray3").label("Ray sn2");
    model.result().numerical("ray3").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray3").set("looplevelindices", new String[]{"1, 1001"});
    model.result().numerical("ray3").set("table", "tbl4");
    model.result().numerical("ray3").set("expr", "gop.sn2");
    model.result().numerical("ray3").set("descr", "Normalized Stokes parameter 2");
    model.result().numerical("ray4").label("Ray sn3");
    model.result().numerical("ray4").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray4").set("looplevelindices", new String[]{"1, 1001"});
    model.result().numerical("ray4").set("table", "tbl5");
    model.result().numerical("ray4").set("expr", "gop.sn3");
    model.result().numerical("ray4").set("descr", "Normalized Stokes parameter 3");
    model.result().numerical("ray1").setResult();
    model.result().numerical("ray2").setResult();
    model.result().numerical("ray3").setResult();
    model.result().numerical("ray4").setResult();
    model.result("pg1").label("Ray Trajectories (gop)");
    model.result().export("tbl1").label("Ray Intensity");
    model.result().export("tbl1").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/ray_intensity_1.csv");
    model.result().export("tbl2").label("Ray s1");
    model.result().export("tbl2").set("table", "tbl3");
    model.result().export("tbl2").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/ray_s1_1.csv");
    model.result().export("tbl3").label("Ray s2");
    model.result().export("tbl3").set("table", "tbl4");
    model.result().export("tbl3").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/ray_s2_1.csv");
    model.result().export("tbl4").label("Ray s3");
    model.result().export("tbl4").set("table", "tbl5");
    model.result().export("tbl4").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/ray_s3_1.csv");
    model.result().export("tbl1").run();
    model.result().export("tbl2").run();
    model.result().export("tbl3").run();
    model.result().export("tbl4").run();

    model.label("Finished_Bubbles_3D_Model.mph");

    model.component("comp1").physics("gop").feature("matd1").set("ReleaseReflectedRays", "Never");
    model.component("comp1").physics("gop").prop("MaximumSecondary").setIndex("MaximumSecondary", 0, 0);

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
