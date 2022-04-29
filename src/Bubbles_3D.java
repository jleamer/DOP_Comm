/*
 * Bubbles_3D.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Mar 31 2022, 16:16 by COMSOL 6.0.0.312. */
public class $name {
	
	$what
	
  public static Model run() {
	// Create the model
    Model model = ModelUtil.create("Model");

    // Define path to model file
    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    // Define name of file
    model.label("3D_Bubbles.mph");

    // Define parameters for channel, detector, and light
    model.param().set("lda0", "795[nm]", "wavelength of light");
    model.param().set("width", "1.5[m]", "width of channel");
    model.param().set("height", "1[m]", "height of channel");
    model.param().set("depth", "1[m]", "depth of channel");
    model.param().set("n_channel", "1.33", "index of refraction of channel");
    model.param().set("n_bubble", "1", "index of refraction of bubbles");
    model.param().set("x_det", "width+0.25[m]", "x position of detector");

    // Create component in model
    model.component().create("comp1", true);

    // Create geometry node for model
    model.component("comp1").geom().create("geom1", 3);

    // Create tables for storing desired data - Intensity, sn1, sn2, & sn3
    model.result().table().create("tbl2", "Table");
    model.result().table("tbl2").label("Ray Intensity");
    model.result().table("tbl2").comments("Ray Evaluation 1");
    model.result().table().create("tbl3", "Table");
    model.result().table("tbl3").label("Ray s1");
    model.result().table().create("tbl4", "Table");
    model.result().table("tbl4").label("Ray s2");
    model.result().table().create("tbl5", "Table");
    model.result().table("tbl5").label("Ray s3");
    model.result().table().create("tbl6", "Table");
    model.result().table("tbl6").label("x");
    model.result().table().create("tbl7", "Table");
    model.result().table("tbl7").label("y");
    model.result().table().create("tbl8", "Table");
    model.result().table("tbl8").label("z");
    
    // Create mesh for finite element solving
    model.component("comp1").mesh().create("mesh1");

    // Add elements to geometry for channel and detector
    //model.component("comp1").geom("geom1").create("blk1", "Block");
    //model.component("comp1").geom("geom1").feature("blk1").label("Channel");
    //model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width", "depth", "height"});
    //model.component("comp1").geom("geom1").create("blk2", "Block");
    //model.component("comp1").geom("geom1").feature("blk2").label("Detector");
    //model.component("comp1").geom("geom1").feature("blk2").set("pos", new String[]{"x_det", "0", "0"});
    //model.component("comp1").geom("geom1").feature("blk2").set("size", new String[]{"0.01", "depth", "height"});
    model.component("comp1").geom("geom1").create("ps1", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps1").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("ps2", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps2").set("pos", new String[]{"width", "0", "0"});
    model.component("comp1").geom("geom1").feature("ps2").set("parmax1", "height");
    model.component("comp1").geom("geom1").feature("ps2").set("parmax2", "depth");
    model.component("comp1").geom("geom1").feature("ps2").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").feature("ps2").set("selresult", true);
    //model.component("comp1").geom("geom1").create("ps3", "ParametricSurface");
    //model.component("comp1").geom("geom1").feature("ps3").set("coord", new String[] {"s1", "0", "s2"});
    //model.component("comp1").geom("geom1").feature("ps3").set("parmax1", "width");
    //model.component("comp1").geom("geom1").feature("ps3").set("parmax2", "depth");
    //model.component("comp1").geom("geom1").feature("ps3").set("selresult", true);
    //model.component("comp1").geom("geom1").create("ps4", "ParametricSurface");
    //model.component("comp1").geom("geom1").feature("ps4").set("coord", new String[] {"s1", "0", "s2"});
    //model.component("comp1").geom("geom1").feature("ps4").set("pos", new String[]{"0", "height", "0"});
    //model.component("comp1").geom("geom1").feature("ps4").set("parmax1", "width");
    //model.component("comp1").geom("geom1").feature("ps4").set("parmax2", "depth");
    //model.component("comp1").geom("geom1").feature("ps4").set("selresult", true);
    //model.component("comp1").geom("geom1").create("ps5", "ParametricSurface");
    //model.component("comp1").geom("geom1").feature("ps5").set("coord", new String[] {"s1", "s2", "0"});
    //model.component("comp1").geom("geom1").feature("ps5").set("parmax1", "width");
    //model.component("comp1").geom("geom1").feature("ps5").set("parmax2", "height");
    //model.component("comp1").geom("geom1").feature("ps5").set("selresult", true);
    //model.component("comp1").geom("geom1").create("ps6", "ParametricSurface");
    //model.component("comp1").geom("geom1").feature("ps6").set("coord", new String[] {"s1", "s2", "0"});
    //model.component("comp1").geom("geom1").feature("ps6").set("pos", new String[]{"0", "0", "depth"});
    //model.component("comp1").geom("geom1").feature("ps6").set("parmax1", "width");
    //model.component("comp1").geom("geom1").feature("ps6").set("parmax2", "height");
    //model.component("comp1").geom("geom1").feature("ps6").set("selresult", true);
        
    $geom
    
    model.component("comp1").geom("geom1").run();

    // Create viewing angle for GUI results - not necessary for API solutions
    model.view().create("view2", 2);

    // Add materials to component - need one for bubbles and channel
    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material().create("mat2", "Common");
    
    // Add property group to material for channel domain and then set values
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat2").label("Channel");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_channel", "0", "0", "0", "n_channel", "0", "0", "0", "n_channel"});
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    
    // Set label for bubble material - actual domain isn't implemented yet
    model.component("comp1").material("mat1").label("Bubble");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_bubble", "0", "0", "0", "n_bubble", "0", "0", "0", "n_bubble"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
$set

    // Add physics node to component - specifically the geometrical optics module
    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    
    // Define release boundary condition for releasing rays
    //	This is set to be the first surface of the channel on the x-axis
    model.component("comp1").physics("gop").create("relb1", "ReleaseFromBoundary", 2);
    model.component("comp1").physics("gop").feature("relb1").selection().set(1);
    
    // Define boundary condition on thin block for catching rays - effectively a detector
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().named("geom1_ps2_bnd");
    //model.component("comp1").physics("gop").create("wall2", "Wall", 2);
    //model.component("comp1").physics("gop").feature("wall2").selection().named("geom1_ps3_bnd");
    //model.component("comp1").physics("gop").create("wall3", "Wall", 2);
    //model.component("comp1").physics("gop").feature("wall3").selection().named("geom1_ps4_bnd");
    //model.component("comp1").physics("gop").create("wall4", "Wall", 2);
    //model.component("comp1").physics("gop").feature("wall4").selection().named("geom1_ps5_bnd");
    //model.component("comp1").physics("gop").create("wall5", "Wall", 2);
    //model.component("comp1").physics("gop").feature("wall5").selection().named("geom1_ps6_bnd");

    // Set flag for calculating intensity and power of rays - useful for calculating the intensity detected at the end
    model.component("comp1").physics("gop").prop("IntensityComputation")
         .set("IntensityComputation", "ComputeIntensityAndPower");
	model.component("comp1").physics("gop").prop("ExteriorUnmeshedProperties").set("next", 1.33);
    
    // Set vacuum wavelength to lda0 for creating rays
    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");
    
    // Set wavevector and polarization state of rays released from boundary
    model.component("comp1").physics("gop").feature("relb1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relb1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("wall1").set("WallCondition", "Freeze");
    //model.component("comp1").physics("gop").feature("wall2").set("WallCondition", "Disappear");
    //model.component("comp1").physics("gop").feature("wall3").set("WallCondition", "Disappear");
    //model.component("comp1").physics("gop").feature("wall4").set("WallCondition", "Disappear");
    //model.component("comp1").physics("gop").feature("wall5").set("WallCondition", "Disappear");
    
    // Turn reflected rays off
    model.component("comp1").physics("gop").feature("matd1").set("ReleaseReflectedRays", "Never");
    model.component("comp1").physics("gop").prop("MaximumSecondary").setIndex("MaximumSecondary", 0, 0);
    
    // Create mesh - coarse seems to avoid some issues with meshing
    //model.component("comp1").mesh("mesh1").create("ftet1", "FreeTet");
    //model.component("comp1").mesh("mesh1").feature("size").set("hauto", 6);
    //model.component("comp1").mesh("mesh1").run();

    // Create ray tracing study node
    model.study().create("std1");
    model.study("std1").create("rtrac", "RayTracing");

    // Create solution node and connect it to the ray tracing study
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

    // Create necessary structures for storing and exporting the desired results
    model.result().dataset().create("ray1", "Ray");
    model.result().dataset().create("cpl1", "CutPlane");
    model.result().dataset("cpl1").set("data", "ray1");
    model.result().numerical().create("ray1", "Ray");
    model.result().numerical().create("ray2", "Ray");
    model.result().numerical().create("ray3", "Ray");
    model.result().numerical().create("ray4", "Ray");
    model.result().numerical().create("ray5", "Ray");
    model.result().numerical().create("ray6", "Ray");
    model.result().numerical().create("ray7", "Ray");
    model.result().numerical("ray1").set("probetag", "none");
    model.result().numerical("ray2").set("probetag", "none");
    model.result().numerical("ray3").set("probetag", "none");
    model.result().numerical("ray4").set("probetag", "none");
    model.result().numerical("ray5").set("probetag", "none");
    model.result().numerical("ray6").set("probetag", "none");
    model.result().numerical("ray7").set("probetag", "none");
    
    // Create figure of rays and color by intensity as they propagate
    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").set("data", "ray1");
    model.result("pg1").create("rtrj1", "RayTrajectories");
    model.result("pg1").feature("rtrj1").create("col1", "Color");
    model.result("pg1").feature("rtrj1").create("filt1", "RayTrajectoriesFilter");
    model.result("pg1").feature("rtrj1").feature("col1").set("expr", "gop.I");
    
    // Create nodes for exporting tables
    model.result().export().create("tbl1", "Table");
    model.result().export().create("tbl2", "Table");
    model.result().export().create("tbl3", "Table");
    model.result().export().create("tbl4", "Table");
    model.result().export().create("tbl5", "Table");
    model.result().export().create("tbl6", "Table");
    model.result().export().create("tbl7", "Table");

    // Define extents of the ray tracing study - here we consider time steps of 0.01 ns from 0 to 10 ns
    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,10)");

    // Set up and run ray tracing study
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

    // Handle results of ray tracing study
    // Create cut plane
    model.result().dataset("cpl1").set("planetype", "general");
    model.result().dataset("cpl1")
         .set("genpoints", new double[][]{{0.7500000000000001, 0.500001, 0.500001}, {1.58759, 1.04628, 0.500001}, {0.632878, 0.6795750000000002, 1.47676}});
    
    // Prepare to store intensity values in table 2
    model.result().numerical("ray1").label("Ray Intensity");
    model.result().numerical("ray1").set("looplevelinput", new String[]{"last"});
    model.result().numerical("ray1").set("table", "tbl2");
    model.result().numerical("ray1").set("expr", "gop.I");
    model.result().numerical("ray1").set("unit", "W/m^2");
    model.result().numerical("ray1").set("descr", "Intensity");
    
    // Prepare to store normalized s1 in table 3
    model.result().numerical("ray2").label("Ray sn1");
    model.result().numerical("ray2").set("looplevelinput", new String[]{"last"});
    //model.result().numerical("ray2").set("looplevelindices", new String[]{"1, 1001"});
    model.result().numerical("ray2").set("table", "tbl3");
    model.result().numerical("ray2").set("expr", "gop.sn1");
    model.result().numerical("ray2").set("descr", "Normalized Stokes parameter 1");
    
    // Prepare to store normalized s2 in table 4
    model.result().numerical("ray3").label("Ray sn2");
    model.result().numerical("ray3").set("looplevelinput", new String[]{"last"});
    //model.result().numerical("ray3").set("looplevelindices", new String[]{"1, 1001"});
    model.result().numerical("ray3").set("table", "tbl4");
    model.result().numerical("ray3").set("expr", "gop.sn2");
    model.result().numerical("ray3").set("descr", "Normalized Stokes parameter 2");
    
    // Prepare to store normalized s3 in table 5
    model.result().numerical("ray4").label("Ray sn3");
    model.result().numerical("ray4").set("looplevelinput", new String[]{"last"});
    //model.result().numerical("ray4").set("looplevelindices", new String[]{"1, 1001"});
    model.result().numerical("ray4").set("table", "tbl5");
    model.result().numerical("ray4").set("expr", "gop.sn3");
    model.result().numerical("ray4").set("descr", "Normalized Stokes parameter 3");
    
    // Get position of rays at end to filter out
    model.result().numerical("ray5").label("Ray x");
    model.result().numerical("ray5").set("looplevelinput", new String[]{"last"});
    model.result().numerical("ray5").set("table", "tbl6");
    model.result().numerical("ray5").set("expr", "qx");
    model.result().numerical("ray5").set("descr", "X Coordinate");
    
    model.result().numerical("ray6").label("Ray y");
    model.result().numerical("ray6").set("looplevelinput", new String[]{"last"});
    model.result().numerical("ray6").set("table", "tbl7");
    model.result().numerical("ray6").set("expr", "qy");
    model.result().numerical("ray6").set("descr", "Y Coordinate");
    
    model.result().numerical("ray7").label("Ray z");
    model.result().numerical("ray7").set("looplevelinput", new String[]{"last"});
    model.result().numerical("ray7").set("table", "tbl8");
    model.result().numerical("ray7").set("expr", "qz");
    model.result().numerical("ray7").set("descr", "Z Coordinate");
    
    // Store desired results in tables
    model.result().numerical("ray1").setResult();
    model.result().numerical("ray2").setResult();
    model.result().numerical("ray3").setResult();
    model.result().numerical("ray4").setResult();
    model.result().numerical("ray5").setResult();
    model.result().numerical("ray6").setResult();
    model.result().numerical("ray7").setResult();
    
    // Label figure
    model.result("pg1").label("Ray Trajectories (gop)");
    
    // Label export nodes
    model.result().export("tbl1").label("Ray Intensity");
    model.result().export("tbl1").set("filename", $int);
    model.result().export("tbl2").label("Ray s1");
    model.result().export("tbl2").set("table", "tbl3");
    model.result().export("tbl2").set("filename", $s1);
    model.result().export("tbl3").label("Ray s2");
    model.result().export("tbl3").set("table", "tbl4");
    model.result().export("tbl3").set("filename", $s2);
    model.result().export("tbl4").label("Ray s3");
    model.result().export("tbl4").set("table", "tbl5");
    model.result().export("tbl4").set("filename", $s3);
    model.result().export("tbl5").label("X Coordinate");
    model.result().export("tbl5").set("table", "tbl6");
    model.result().export("tbl5").set("filename", $x);
    model.result().export("tbl6").label("Y Coordinate");
    model.result().export("tbl6").set("table", "tbl7");
    model.result().export("tbl6").set("filename", $y);
    model.result().export("tbl7").label("Z Coordinate");
    model.result().export("tbl7").set("table", "tbl8");
    model.result().export("tbl7").set("filename", $z);
    
    // Export data to tables
    model.result().export("tbl1").run();
    model.result().export("tbl2").run();
    model.result().export("tbl3").run();
    model.result().export("tbl4").run();
    model.result().export("tbl5").run();
    model.result().export("tbl6").run();
    model.result().export("tbl7").run();

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
