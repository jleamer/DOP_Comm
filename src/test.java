/*
 * test.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on May 30 2022, 16:27 by COMSOL 6.0.0.312. */
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
    model.result().table().create("tbl6", "Table");
    model.result().table("tbl6").label("x");
    model.result().table().create("tbl7", "Table");
    model.result().table("tbl7").label("y");
    model.result().table().create("tbl8", "Table");
    model.result().table("tbl8").label("z");
    model.result().table().create("tbl9", "Table");
    model.result().table("tbl9").label("Ray s0");

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").label("Channel");
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width/4", "depth", "height"});
    model.component("comp1").geom("geom1").feature("blk1").set("pos", new String[]{"width/2", "0", "0"});
    model.component("comp1").geom("geom1").create("ps1", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps1").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("ps3", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps3").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").feature("ps3").set("parmax1", "height");
    model.component("comp1").geom("geom1").feature("ps3").set("parmax2", "depth");
    model.component("comp1").geom("geom1").feature("ps3").set("pos", new String[]{"3*width/4", "0", "0"});
    model.component("comp1").geom("geom1").feature("ps3").set("selresult", true);
    model.component("comp1").geom("geom1").create("blk2", "Block");
    model.component("comp1").geom("geom1").feature("blk2").label("Left Wall");
    model.component("comp1").geom("geom1").feature("blk2").set("size", new String[]{"width/4", "0.01", "1"});
    model.component("comp1").geom("geom1").feature("blk2").setIndex("size", 0.01, 2);
    model.component("comp1").geom("geom1").feature("blk2").set("pos", new String[]{"0", "height", "0"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk2").setIndex("size", "height", 2);
    model.component("comp1").geom("geom1").feature("blk2").set("pos", new String[]{"0", "depth", "0"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk2").set("size", new String[]{"width/2", "0.01", "height"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat2").label("Glass");
    model.component("comp1").material("mat2").selection().set(1);
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive_index");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", new String[]{"1.5"});

    model.component("comp1").geom("geom1").feature().duplicate("blk3", "blk2");
    model.component("comp1").geom("geom1").feature("blk3").label("Top Wall");
    model.component("comp1").geom("geom1").feature("blk3").setIndex("size", "depth", 1);
    model.component("comp1").geom("geom1").feature("blk3").setIndex("size", 0.01, 2);
    model.component("comp1").geom("geom1").feature("blk3").set("pos", new String[]{"0", "height", "depth"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk3").set("pos", new String[]{"0", "0", "depth"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk3").set("pos", new String[]{"0", "0", "depth-0.01"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature().duplicate("blk4", "blk3");
    model.component("comp1").geom("geom1").feature("blk4").label("Right Wall");
    model.component("comp1").geom("geom1").feature("blk4").setIndex("size", 0.01, 1);
    model.component("comp1").geom("geom1").feature("blk4").setIndex("size", "height", 2);
    model.component("comp1").geom("geom1").feature("blk4").setIndex("pos", "height-1", 1);
    model.component("comp1").geom("geom1").feature("blk4").set("pos", new String[]{"0", "height-0.01", "0"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk4").set("pos", new double[]{0, 0.01, 0});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk4").set("pos", new int[]{0, 0, 0});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature().duplicate("blk5", "blk4");
    model.component("comp1").geom("geom1").feature("blk5").label("Bottom Wall");
    model.component("comp1").geom("geom1").feature("blk5").setIndex("size", "depth", 1);
    model.component("comp1").geom("geom1").feature("blk5").setIndex("size", 0.01, 2);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("blk2").set("pos", new String[]{"0", "depth-0.01", "0"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").material("mat2").selection().set(1, 2, 3, 4, 5, 6, 7, 8);

    model.component("comp1").geom("geom1").feature().create("sph0", "Sphere");
    model.component("comp1").geom("geom1").feature("sph0")
         .set("pos", new double[]{0.42772802073944494, 0.5068759438562832, 0.44739359787713945});
    model.component("comp1").geom("geom1").feature("sph0").set("r", 0.018449355426565645);
    model.component("comp1").geom("geom1").feature().create("sph1", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1")
         .set("pos", new double[]{0.34277697177940314, 0.6886207994487005, 0.7290869305056762});
    model.component("comp1").geom("geom1").feature("sph1").set("r", 0.016855564600533092);
    model.component("comp1").geom("geom1").feature().create("sph2", "Sphere");
    model.component("comp1").geom("geom1").feature("sph2")
         .set("pos", new double[]{0.5291363341757663, 0.49893228628246206, 0.5184406768749964});
    model.component("comp1").geom("geom1").feature("sph2").set("r", 0.010819154932992887);
    model.component("comp1").geom("geom1").feature().create("sph3", "Sphere");
    model.component("comp1").geom("geom1").feature("sph3")
         .set("pos", new double[]{0.15904987657016328, 0.28956343979860405, 0.2591436559147639});
    model.component("comp1").geom("geom1").feature("sph3").set("r", 0.023288722680731205);
    model.component("comp1").geom("geom1").feature().create("sph4", "Sphere");
    model.component("comp1").geom("geom1").feature("sph4")
         .set("pos", new double[]{0.5162200397919753, 0.6765938145947492, 0.7376551781127813});
    model.component("comp1").geom("geom1").feature("sph4").set("r", 0.021150256447602572);
    model.component("comp1").geom("geom1").feature().create("sph5", "Sphere");
    model.component("comp1").geom("geom1").feature("sph5")
         .set("pos", new double[]{0.3553838002776151, 0.6281235178782785, 0.30381317233627514});
    model.component("comp1").geom("geom1").feature("sph5").set("r", 0.02038064697698464);
    model.component("comp1").geom("geom1").feature().create("sph6", "Sphere");
    model.component("comp1").geom("geom1").feature("sph6")
         .set("pos", new double[]{0.19076927843975747, 0.7182816239889054, 0.495441233515298});
    model.component("comp1").geom("geom1").feature("sph6").set("r", 0.01671818349053305);
    model.component("comp1").geom("geom1").feature().create("sph7", "Sphere");
    model.component("comp1").geom("geom1").feature("sph7")
         .set("pos", new double[]{0.25093833623477685, 0.6247696588584883, 0.46317470323403126});
    model.component("comp1").geom("geom1").feature("sph7").set("r", 0.011537224619782042);
    model.component("comp1").geom("geom1").feature().create("sph8", "Sphere");
    model.component("comp1").geom("geom1").feature("sph8")
         .set("pos", new double[]{0.12484189688104623, 0.5434396859755117, 0.5406304412028282});
    model.component("comp1").geom("geom1").feature("sph8").set("r", 0.015073980823978915);
    model.component("comp1").geom("geom1").feature().create("sph9", "Sphere");
    model.component("comp1").geom("geom1").feature("sph9")
         .set("pos", new double[]{0.6046933401875428, 0.5763105977421243, 0.4165610511026956});
    model.component("comp1").geom("geom1").feature("sph9").set("r", 0.016189481928119406);
    model.component("comp1").geom("geom1").feature().create("sph10", "Sphere");
    model.component("comp1").geom("geom1").feature("sph10")
         .set("pos", new double[]{0.4789335601826482, 0.2773014771767557, 0.5685464580736462});
    model.component("comp1").geom("geom1").feature("sph10").set("r", 0.012051734937384853);
    model.component("comp1").geom("geom1").feature().create("sph11", "Sphere");
    model.component("comp1").geom("geom1").feature("sph11")
         .set("pos", new double[]{0.22580338576961964, 0.3087007356059184, 0.3956029928977005});
    model.component("comp1").geom("geom1").feature("sph11").set("r", 0.017424671001217668);
    model.component("comp1").geom("geom1").feature().create("sph12", "Sphere");
    model.component("comp1").geom("geom1").feature("sph12")
         .set("pos", new double[]{0.4121529958597894, 0.45463823567745437, 0.7432735155785647});
    model.component("comp1").geom("geom1").feature("sph12").set("r", 0.01036534773168032);
    model.component("comp1").geom("geom1").feature().create("sph13", "Sphere");
    model.component("comp1").geom("geom1").feature("sph13")
         .set("pos", new double[]{0.21741325917889787, 0.32360557289330605, 0.5615314590962847});
    model.component("comp1").geom("geom1").feature("sph13").set("r", 0.004347030647204646);
    model.component("comp1").geom("geom1").feature().create("sph14", "Sphere");
    model.component("comp1").geom("geom1").feature("sph14")
         .set("pos", new double[]{0.3569982091027947, 0.3622014309013968, 0.3225262117508984});
    model.component("comp1").geom("geom1").feature("sph14").set("r", 0.007825706858414988);
    model.component("comp1").geom("geom1").feature().create("sph15", "Sphere");
    model.component("comp1").geom("geom1").feature("sph15")
         .set("pos", new double[]{0.45956223042479155, 0.3129541022060849, 0.3399227383084674});
    model.component("comp1").geom("geom1").feature("sph15").set("r", 0.0045386282467790185);
    model.component("comp1").geom("geom1").feature().create("sph16", "Sphere");
    model.component("comp1").geom("geom1").feature("sph16")
         .set("pos", new double[]{0.5448178224579647, 0.29411935273534995, 0.6590466096754293});
    model.component("comp1").geom("geom1").feature("sph16").set("r", 0.010480678925202174);
    model.component("comp1").geom("geom1").feature().create("sph17", "Sphere");
    model.component("comp1").geom("geom1").feature("sph17")
         .set("pos", new double[]{0.6330406660806794, 0.46927625535838446, 0.7365881962600946});
    model.component("comp1").geom("geom1").feature("sph17").set("r", 0.00421026338156115);
    model.component("comp1").geom("geom1").feature().create("sph18", "Sphere");
    model.component("comp1").geom("geom1").feature("sph18")
         .set("pos", new double[]{0.4989809091657603, 0.2677421880849403, 0.3802044655434727});
    model.component("comp1").geom("geom1").feature("sph18").set("r", 0.015911446954136058);
    model.component("comp1").geom("geom1").feature().create("sph19", "Sphere");
    model.component("comp1").geom("geom1").feature("sph19")
         .set("pos", new double[]{0.2648196972195531, 0.30402101521043573, 0.3968128910453869});
    model.component("comp1").geom("geom1").feature("sph19").set("r", 0.004764520907902884);
    model.component("comp1").geom("geom1").feature().create("sph20", "Sphere");
    model.component("comp1").geom("geom1").feature("sph20")
         .set("pos", new double[]{0.14533018091958264, 0.5818254905333724, 0.5177181046005921});
    model.component("comp1").geom("geom1").feature("sph20").set("r", 0.01152804887383741);
    model.component("comp1").geom("geom1").feature().create("sph21", "Sphere");
    model.component("comp1").geom("geom1").feature("sph21")
         .set("pos", new double[]{0.3874096268953745, 0.2926746324174323, 0.5224020390355438});
    model.component("comp1").geom("geom1").feature("sph21").set("r", 0.008103958291607243);
    model.component("comp1").geom("geom1").feature().create("sph22", "Sphere");
    model.component("comp1").geom("geom1").feature("sph22")
         .set("pos", new double[]{0.2836943944384484, 0.5688777351319346, 0.3100195981925105});
    model.component("comp1").geom("geom1").feature("sph22").set("r", 0.02337381254425292);
    model.component("comp1").geom("geom1").feature().create("sph23", "Sphere");
    model.component("comp1").geom("geom1").feature("sph23")
         .set("pos", new double[]{0.2669550174027745, 0.33371765505283574, 0.5277120124981591});
    model.component("comp1").geom("geom1").feature("sph23").set("r", 0.018475525694727005);
    model.component("comp1").geom("geom1").feature().create("sph24", "Sphere");
    model.component("comp1").geom("geom1").feature("sph24")
         .set("pos", new double[]{0.5542970038184818, 0.2521216119406024, 0.5742422155264468});
    model.component("comp1").geom("geom1").feature("sph24").set("r", 0.002462473562312352);
    model.component("comp1").geom("geom1").feature().create("sph25", "Sphere");
    model.component("comp1").geom("geom1").feature("sph25")
         .set("pos", new double[]{0.5004947400628061, 0.7282452344215442, 0.3642253276097804});
    model.component("comp1").geom("geom1").feature("sph25").set("r", 0.008210183383419792);
    model.component("comp1").geom("geom1").feature().create("sph26", "Sphere");
    model.component("comp1").geom("geom1").feature("sph26")
         .set("pos", new double[]{0.4228154853207165, 0.5205488672892953, 0.3522408387981849});
    model.component("comp1").geom("geom1").feature("sph26").set("r", 0.015251618691610248);
    model.component("comp1").geom("geom1").feature().create("sph27", "Sphere");
    model.component("comp1").geom("geom1").feature("sph27")
         .set("pos", new double[]{0.3484477639150185, 0.6636580892139701, 0.5854630510246897});
    model.component("comp1").geom("geom1").feature("sph27").set("r", 0.023913227264890653);
    model.component("comp1").geom("geom1").feature().create("sph28", "Sphere");
    model.component("comp1").geom("geom1").feature("sph28")
         .set("pos", new double[]{0.5420401964903971, 0.4342940143861764, 0.6827113769863584});
    model.component("comp1").geom("geom1").feature("sph28").set("r", 0.008841049869668074);
    model.component("comp1").geom("geom1").feature().create("sph29", "Sphere");
    model.component("comp1").geom("geom1").feature("sph29")
         .set("pos", new double[]{0.5732204566956349, 0.5818563305776191, 0.5989108232392993});
    model.component("comp1").geom("geom1").feature("sph29").set("r", 0.01536927607062475);
    model.component("comp1").geom("geom1").feature().create("sph30", "Sphere");
    model.component("comp1").geom("geom1").feature("sph30")
         .set("pos", new double[]{0.6135039556297932, 0.5568637117127132, 0.4474905023384169});
    model.component("comp1").geom("geom1").feature("sph30").set("r", 0.013530460784314151);
    model.component("comp1").geom("geom1").feature().create("sph31", "Sphere");
    model.component("comp1").geom("geom1").feature("sph31")
         .set("pos", new double[]{0.12589115344207757, 0.38905235082890693, 0.5651567058439705});
    model.component("comp1").geom("geom1").feature("sph31").set("r", 0.01594704392494226);
    model.component("comp1").geom("geom1").feature().create("sph32", "Sphere");
    model.component("comp1").geom("geom1").feature("sph32")
         .set("pos", new double[]{0.4378616771035042, 0.4498696333472097, 0.3117088051520973});
    model.component("comp1").geom("geom1").feature("sph32").set("r", 0.008671784965840213);
    model.component("comp1").geom("geom1").feature().create("sph33", "Sphere");
    model.component("comp1").geom("geom1").feature("sph33")
         .set("pos", new double[]{0.4122408536131238, 0.5299072997313043, 0.5215886162859603});
    model.component("comp1").geom("geom1").feature("sph33").set("r", 0.008860493496988708);
    model.component("comp1").geom("geom1").feature().create("sph34", "Sphere");
    model.component("comp1").geom("geom1").feature("sph34")
         .set("pos", new double[]{0.45347810231019164, 0.45115365946321073, 0.6912724272037732});
    model.component("comp1").geom("geom1").feature("sph34").set("r", 0.017023618856714072);
    model.component("comp1").geom("geom1").feature().create("sph35", "Sphere");
    model.component("comp1").geom("geom1").feature("sph35")
         .set("pos", new double[]{0.3410666351632635, 0.6887042440353078, 0.6418701901455287});
    model.component("comp1").geom("geom1").feature("sph35").set("r", 0.01045392301110162);
    model.component("comp1").geom("geom1").feature().create("sph36", "Sphere");
    model.component("comp1").geom("geom1").feature("sph36")
         .set("pos", new double[]{0.16966808405377073, 0.7040814425434085, 0.5931518290484392});
    model.component("comp1").geom("geom1").feature("sph36").set("r", 0.018189437421428423);
    model.component("comp1").geom("geom1").feature().create("sph37", "Sphere");
    model.component("comp1").geom("geom1").feature("sph37")
         .set("pos", new double[]{0.1997055598740887, 0.67555601186973, 0.3241516010132524});
    model.component("comp1").geom("geom1").feature("sph37").set("r", 0.024973481151060926);
    model.component("comp1").geom("geom1").feature().create("sph38", "Sphere");
    model.component("comp1").geom("geom1").feature("sph38")
         .set("pos", new double[]{0.18025752617847146, 0.6645311921343894, 0.6424755148609027});
    model.component("comp1").geom("geom1").feature("sph38").set("r", 0.016157869978528416);
    model.component("comp1").geom("geom1").feature().create("sph39", "Sphere");
    model.component("comp1").geom("geom1").feature("sph39")
         .set("pos", new double[]{0.32675189477420075, 0.2813720423394654, 0.5843977928022512});
    model.component("comp1").geom("geom1").feature("sph39").set("r", 0.015089316988135646);
    model.component("comp1").geom("geom1").feature().create("sph42", "Sphere");
    model.component("comp1").geom("geom1").feature("sph42")
         .set("pos", new double[]{0.386319903714514, 0.2746237529736012, 0.3415068700954028});
    model.component("comp1").geom("geom1").feature("sph42").set("r", 0.005947482577013132);
    model.component("comp1").geom("geom1").feature().create("sph43", "Sphere");
    model.component("comp1").geom("geom1").feature("sph43")
         .set("pos", new double[]{0.5351087148423752, 0.3526335990484423, 0.4098108138496459});
    model.component("comp1").geom("geom1").feature("sph43").set("r", 0.0024260012725941214);
    model.component("comp1").geom("geom1").feature().create("sph44", "Sphere");
    model.component("comp1").geom("geom1").feature("sph44")
         .set("pos", new double[]{0.47788345705340035, 0.2644087482525474, 0.32516750130513083});
    model.component("comp1").geom("geom1").feature("sph44").set("r", 0.023345869749708592);
    model.component("comp1").geom("geom1").feature().create("sph45", "Sphere");
    model.component("comp1").geom("geom1").feature("sph45")
         .set("pos", new double[]{0.4149589979872687, 0.3591490086189151, 0.7123696524528859});
    model.component("comp1").geom("geom1").feature("sph45").set("r", 0.01629400323449456);
    model.component("comp1").geom("geom1").feature().create("sph46", "Sphere");
    model.component("comp1").geom("geom1").feature("sph46")
         .set("pos", new double[]{0.39344915336487096, 0.5294222928412033, 0.6014626377050875});
    model.component("comp1").geom("geom1").feature("sph46").set("r", 0.01612121698721561);
    model.component("comp1").geom("geom1").feature().create("sph47", "Sphere");
    model.component("comp1").geom("geom1").feature("sph47")
         .set("pos", new double[]{0.3208891737631845, 0.34608068726006946, 0.33510742290056605});
    model.component("comp1").geom("geom1").feature("sph47").set("r", 0.009174734896030844);
    model.component("comp1").geom("geom1").feature().create("sph48", "Sphere");
    model.component("comp1").geom("geom1").feature("sph48")
         .set("pos", new double[]{0.4953883768821217, 0.47996247455514063, 0.35426006189294007});
    model.component("comp1").geom("geom1").feature("sph48").set("r", 0.023720564969630473);
    model.component("comp1").geom("geom1").feature().create("sph49", "Sphere");
    model.component("comp1").geom("geom1").feature("sph49")
         .set("pos", new double[]{0.13885515633679188, 0.45260744021296817, 0.3938837491581768});
    model.component("comp1").geom("geom1").feature("sph49").set("r", 0.007850199080719038);
    model.component("comp1").geom("geom1").feature().create("sph50", "Sphere");
    model.component("comp1").geom("geom1").feature("sph50")
         .set("pos", new double[]{0.3121683329471986, 0.3320573940442926, 0.2611637089609374});
    model.component("comp1").geom("geom1").feature("sph50").set("r", 0.018015900242755567);
    model.component("comp1").geom("geom1").feature().create("sph51", "Sphere");
    model.component("comp1").geom("geom1").feature("sph51")
         .set("pos", new double[]{0.4723935058265902, 0.4619792086347958, 0.5027462129074786});
    model.component("comp1").geom("geom1").feature("sph51").set("r", 0.0035467415236547176);
    model.component("comp1").geom("geom1").feature().create("sph52", "Sphere");
    model.component("comp1").geom("geom1").feature("sph52")
         .set("pos", new double[]{0.6225001138110494, 0.34936120886665323, 0.5666492797932928});
    model.component("comp1").geom("geom1").feature("sph52").set("r", 0.02262343973992787);
    model.component("comp1").geom("geom1").feature().create("sph53", "Sphere");
    model.component("comp1").geom("geom1").feature("sph53")
         .set("pos", new double[]{0.11908171834122191, 0.6163539662922399, 0.39777654068485657});
    model.component("comp1").geom("geom1").feature("sph53").set("r", 0.008056414664954464);
    model.component("comp1").geom("geom1").feature().create("sph54", "Sphere");
    model.component("comp1").geom("geom1").feature("sph54")
         .set("pos", new double[]{0.42166328848314555, 0.655299419364713, 0.5492069167052409});
    model.component("comp1").geom("geom1").feature("sph54").set("r", 0.010819669565953653);
    model.component("comp1").geom("geom1").feature().create("sph55", "Sphere");
    model.component("comp1").geom("geom1").feature("sph55")
         .set("pos", new double[]{0.2604444108298104, 0.6374933530674486, 0.33484945330379756});
    model.component("comp1").geom("geom1").feature("sph55").set("r", 0.02207096507529009);
    model.component("comp1").geom("geom1").feature().create("sph56", "Sphere");
    model.component("comp1").geom("geom1").feature("sph56")
         .set("pos", new double[]{0.4691512846937186, 0.348714733567826, 0.7198134289749393});
    model.component("comp1").geom("geom1").feature("sph56").set("r", 0.023914208110354725);
    model.component("comp1").geom("geom1").feature().create("sph58", "Sphere");
    model.component("comp1").geom("geom1").feature("sph58")
         .set("pos", new double[]{0.21562398838776328, 0.44789240355553334, 0.42357257439017126});
    model.component("comp1").geom("geom1").feature("sph58").set("r", 0.002590242515254226);
    model.component("comp1").geom("geom1").feature().create("sph59", "Sphere");
    model.component("comp1").geom("geom1").feature("sph59")
         .set("pos", new double[]{0.25832722351183834, 0.527848601081716, 0.6732089220087636});
    model.component("comp1").geom("geom1").feature("sph59").set("r", 0.012662234760390646);
    model.component("comp1").geom("geom1").feature().create("sph60", "Sphere");
    model.component("comp1").geom("geom1").feature("sph60")
         .set("pos", new double[]{0.3843950329650822, 0.31014374453283794, 0.594519265096677});
    model.component("comp1").geom("geom1").feature("sph60").set("r", 0.004703232687126761);
    model.component("comp1").geom("geom1").feature().create("sph61", "Sphere");
    model.component("comp1").geom("geom1").feature("sph61")
         .set("pos", new double[]{0.40952814198947646, 0.33375860957803094, 0.3160200392089472});
    model.component("comp1").geom("geom1").feature("sph61").set("r", 0.011109373164567756);
    model.component("comp1").geom("geom1").feature().create("sph62", "Sphere");
    model.component("comp1").geom("geom1").feature("sph62")
         .set("pos", new double[]{0.29940613393242543, 0.7158827174428596, 0.6200357443074704});
    model.component("comp1").geom("geom1").feature("sph62").set("r", 0.013225294454925955);
    model.component("comp1").geom("geom1").feature().create("sph63", "Sphere");
    model.component("comp1").geom("geom1").feature("sph63")
         .set("pos", new double[]{0.5815274649401674, 0.28787141491417906, 0.5105181630090404});
    model.component("comp1").geom("geom1").feature("sph63").set("r", 0.01921926325656259);
    model.component("comp1").geom("geom1").feature().create("sph64", "Sphere");
    model.component("comp1").geom("geom1").feature("sph64")
         .set("pos", new double[]{0.6147976877893034, 0.38460420163990816, 0.36052041290845843});
    model.component("comp1").geom("geom1").feature("sph64").set("r", 0.015442949585982683);
    model.component("comp1").geom("geom1").feature().create("sph65", "Sphere");
    model.component("comp1").geom("geom1").feature("sph65")
         .set("pos", new double[]{0.11320153998225359, 0.7097286617213399, 0.5701681880688039});
    model.component("comp1").geom("geom1").feature("sph65").set("r", 0.00430676067210645);
    model.component("comp1").geom("geom1").feature().create("sph67", "Sphere");
    model.component("comp1").geom("geom1").feature("sph67")
         .set("pos", new double[]{0.6250456447283781, 0.6801721664847714, 0.40638820075467064});
    model.component("comp1").geom("geom1").feature("sph67").set("r", 0.013169434706496327);
    model.component("comp1").geom("geom1").feature().create("sph68", "Sphere");
    model.component("comp1").geom("geom1").feature("sph68")
         .set("pos", new double[]{0.24037652264415427, 0.7209190937196757, 0.7164178339803137});
    model.component("comp1").geom("geom1").feature("sph68").set("r", 0.024116113554454463);
    model.component("comp1").geom("geom1").feature().create("sph69", "Sphere");
    model.component("comp1").geom("geom1").feature("sph69")
         .set("pos", new double[]{0.44142887441096684, 0.6789492449269008, 0.3850156806513295});
    model.component("comp1").geom("geom1").feature("sph69").set("r", 0.02038165950910501);
    model.component("comp1").geom("geom1").feature().create("sph70", "Sphere");
    model.component("comp1").geom("geom1").feature("sph70")
         .set("pos", new double[]{0.43475742352241853, 0.255983883230863, 0.4107070650527031});
    model.component("comp1").geom("geom1").feature("sph70").set("r", 0.02152570177219712);
    model.component("comp1").geom("geom1").feature().create("sph71", "Sphere");
    model.component("comp1").geom("geom1").feature("sph71")
         .set("pos", new double[]{0.6347954302914273, 0.4740321452532355, 0.48337103888075744});
    model.component("comp1").geom("geom1").feature("sph71").set("r", 0.005407239801807796);
    model.component("comp1").geom("geom1").feature().create("sph72", "Sphere");
    model.component("comp1").geom("geom1").feature("sph72")
         .set("pos", new double[]{0.30711287544691507, 0.3123643837406501, 0.6504605329482127});
    model.component("comp1").geom("geom1").feature("sph72").set("r", 0.016707867877170643);
    model.component("comp1").geom("geom1").feature().create("sph73", "Sphere");
    model.component("comp1").geom("geom1").feature("sph73")
         .set("pos", new double[]{0.3810813157511048, 0.3528164002590328, 0.29445914711088794});
    model.component("comp1").geom("geom1").feature("sph73").set("r", 0.006366501973763433);
    model.component("comp1").geom("geom1").feature().create("sph74", "Sphere");
    model.component("comp1").geom("geom1").feature("sph74")
         .set("pos", new double[]{0.6144576711011088, 0.7274726934403903, 0.6968480062329083});
    model.component("comp1").geom("geom1").feature("sph74").set("r", 0.021830404900698715);
    model.component("comp1").geom("geom1").feature().create("sph75", "Sphere");
    model.component("comp1").geom("geom1").feature("sph75")
         .set("pos", new double[]{0.2898383163085616, 0.2868123767408176, 0.43946489469131444});
    model.component("comp1").geom("geom1").feature("sph75").set("r", 0.019803088652068694);
    model.component("comp1").geom("geom1").feature().create("sph76", "Sphere");
    model.component("comp1").geom("geom1").feature("sph76")
         .set("pos", new double[]{0.17826429884630166, 0.27420967948025216, 0.5990889784094819});
    model.component("comp1").geom("geom1").feature("sph76").set("r", 0.007341385269931683);
    model.component("comp1").geom("geom1").feature().create("sph77", "Sphere");
    model.component("comp1").geom("geom1").feature("sph77")
         .set("pos", new double[]{0.5225948543683366, 0.31698618027475567, 0.2860919600407029});
    model.component("comp1").geom("geom1").feature("sph77").set("r", 0.0022628315483757136);
    model.component("comp1").geom("geom1").feature().create("sph78", "Sphere");
    model.component("comp1").geom("geom1").feature("sph78")
         .set("pos", new double[]{0.46822896655887886, 0.3626416774417194, 0.4458865685605531});
    model.component("comp1").geom("geom1").feature("sph78").set("r", 0.004060869787487924);
    model.component("comp1").geom("geom1").feature().create("sph79", "Sphere");
    model.component("comp1").geom("geom1").feature("sph79")
         .set("pos", new double[]{0.5626167822000222, 0.5998487295846621, 0.3743378347839977});
    model.component("comp1").geom("geom1").feature("sph79").set("r", 0.014819482200450089);
    model.component("comp1").geom("geom1").feature().create("sph80", "Sphere");
    model.component("comp1").geom("geom1").feature("sph80")
         .set("pos", new double[]{0.13492356788341017, 0.38906359868115165, 0.37048530661160217});
    model.component("comp1").geom("geom1").feature("sph80").set("r", 0.005024104383695935);
    model.component("comp1").geom("geom1").feature().create("sph81", "Sphere");
    model.component("comp1").geom("geom1").feature("sph81")
         .set("pos", new double[]{0.47122591480412285, 0.5834614923081797, 0.3805395280473302});
    model.component("comp1").geom("geom1").feature("sph81").set("r", 0.012491233036411031);
    model.component("comp1").geom("geom1").feature().create("sph82", "Sphere");
    model.component("comp1").geom("geom1").feature("sph82")
         .set("pos", new double[]{0.20648083495530212, 0.6324043992972034, 0.27576514040546074});
    model.component("comp1").geom("geom1").feature("sph82").set("r", 0.01073831998570277);
    model.component("comp1").geom("geom1").feature().create("sph83", "Sphere");
    model.component("comp1").geom("geom1").feature("sph83")
         .set("pos", new double[]{0.518232189760232, 0.6264596275682204, 0.36922157147856005});
    model.component("comp1").geom("geom1").feature("sph83").set("r", 0.018030936559674707);
    model.component("comp1").geom("geom1").feature().create("sph84", "Sphere");

    return model;
  }

  public static Model run2(Model model) {
    model.component("comp1").geom("geom1").feature("sph84")
         .set("pos", new double[]{0.421323089669561, 0.37550927187695027, 0.4219844606883156});
    model.component("comp1").geom("geom1").feature("sph84").set("r", 0.010597702172448913);
    model.component("comp1").geom("geom1").feature().create("sph85", "Sphere");
    model.component("comp1").geom("geom1").feature("sph85")
         .set("pos", new double[]{0.35344519874756686, 0.2702046500519795, 0.6384319511020156});
    model.component("comp1").geom("geom1").feature("sph85").set("r", 0.006532248444269711);
    model.component("comp1").geom("geom1").feature().create("sph86", "Sphere");
    model.component("comp1").geom("geom1").feature("sph86")
         .set("pos", new double[]{0.3852173148999165, 0.39152587658849325, 0.5232033601604645});
    model.component("comp1").geom("geom1").feature("sph86").set("r", 0.0037699982806925526);
    model.component("comp1").geom("geom1").feature().create("sph88", "Sphere");
    model.component("comp1").geom("geom1").feature("sph88")
         .set("pos", new double[]{0.3939041600373077, 0.5760894805518064, 0.3777531638162553});
    model.component("comp1").geom("geom1").feature("sph88").set("r", 0.013730387603319755);
    model.component("comp1").geom("geom1").feature().create("sph89", "Sphere");
    model.component("comp1").geom("geom1").feature("sph89")
         .set("pos", new double[]{0.3170370935531014, 0.7249485268727986, 0.33554179878347634});
    model.component("comp1").geom("geom1").feature("sph89").set("r", 0.004963793005725364);
    model.component("comp1").geom("geom1").feature().create("sph90", "Sphere");
    model.component("comp1").geom("geom1").feature("sph90")
         .set("pos", new double[]{0.3970964544462069, 0.46354568869857393, 0.6832300441149289});
    model.component("comp1").geom("geom1").feature("sph90").set("r", 0.02279163096334945);
    model.component("comp1").geom("geom1").feature().create("sph91", "Sphere");
    model.component("comp1").geom("geom1").feature("sph91")
         .set("pos", new double[]{0.4926665379423863, 0.43550656055040454, 0.695447134289818});
    model.component("comp1").geom("geom1").feature("sph91").set("r", 0.012547891120677475);
    model.component("comp1").geom("geom1").feature().create("sph92", "Sphere");
    model.component("comp1").geom("geom1").feature("sph92")
         .set("pos", new double[]{0.4776574078681001, 0.40142952644176455, 0.6155071263056526});
    model.component("comp1").geom("geom1").feature("sph92").set("r", 0.017870575464398228);
    model.component("comp1").geom("geom1").feature().create("sph93", "Sphere");
    model.component("comp1").geom("geom1").feature("sph93")
         .set("pos", new double[]{0.24065776631353364, 0.3232500261681844, 0.6366055498477124});
    model.component("comp1").geom("geom1").feature("sph93").set("r", 0.01662940427528425);
    model.component("comp1").geom("geom1").feature().create("sph94", "Sphere");
    model.component("comp1").geom("geom1").feature("sph94")
         .set("pos", new double[]{0.353990784271362, 0.5299634280420216, 0.6698446458453426});
    model.component("comp1").geom("geom1").feature("sph94").set("r", 0.024060831869810118);
    model.component("comp1").geom("geom1").feature().create("sph95", "Sphere");
    model.component("comp1").geom("geom1").feature("sph95")
         .set("pos", new double[]{0.6122195143467972, 0.5223040166936267, 0.6497300644513684});
    model.component("comp1").geom("geom1").feature("sph95").set("r", 0.012516139427138712);
    model.component("comp1").geom("geom1").feature().create("sph96", "Sphere");
    model.component("comp1").geom("geom1").feature("sph96")
         .set("pos", new double[]{0.5340849603755576, 0.32273139623388153, 0.5491644565652477});
    model.component("comp1").geom("geom1").feature("sph96").set("r", 0.02290340552349298);
    model.component("comp1").geom("geom1").feature().create("sph97", "Sphere");
    model.component("comp1").geom("geom1").feature("sph97")
         .set("pos", new double[]{0.14425585827991677, 0.4475762579546531, 0.3688754545228904});
    model.component("comp1").geom("geom1").feature("sph97").set("r", 0.011163987948252572);
    model.component("comp1").geom("geom1").feature().create("sph98", "Sphere");
    model.component("comp1").geom("geom1").feature("sph98")
         .set("pos", new double[]{0.13841146961419357, 0.7264166633632496, 0.4145854392038848});
    model.component("comp1").geom("geom1").feature("sph98").set("r", 0.02152788109385575);
    model.component("comp1").geom("geom1").feature().create("sph99", "Sphere");
    model.component("comp1").geom("geom1").feature("sph99")
         .set("pos", new double[]{0.1188516944313702, 0.3346625553053307, 0.43658229318946956});
    model.component("comp1").geom("geom1").feature("sph99").set("r", 0.010204258479258486);
    model.component("comp1").geom("geom1").feature().create("sph100", "Sphere");
    model.component("comp1").geom("geom1").feature("sph100")
         .set("pos", new double[]{0.17350517471304414, 0.7186401560136876, 0.6763056261383965});
    model.component("comp1").geom("geom1").feature("sph100").set("r", 0.02337370259796242);
    model.component("comp1").geom("geom1").feature().create("sph102", "Sphere");
    model.component("comp1").geom("geom1").feature("sph102")
         .set("pos", new double[]{0.11125788323842335, 0.4498827238861577, 0.2808742487837869});
    model.component("comp1").geom("geom1").feature("sph102").set("r", 0.0027607156039366294);
    model.component("comp1").geom("geom1").feature().create("sph103", "Sphere");
    model.component("comp1").geom("geom1").feature("sph103")
         .set("pos", new double[]{0.2259854055282316, 0.36630245281175966, 0.30967846826182954});
    model.component("comp1").geom("geom1").feature("sph103").set("r", 0.007794642729660137);
    model.component("comp1").geom("geom1").feature().create("sph104", "Sphere");
    model.component("comp1").geom("geom1").feature("sph104")
         .set("pos", new double[]{0.16526731960629165, 0.5438684454093025, 0.7351504863015059});
    model.component("comp1").geom("geom1").feature("sph104").set("r", 0.002276833126646048);
    model.component("comp1").geom("geom1").feature().create("sph105", "Sphere");
    model.component("comp1").geom("geom1").feature("sph105")
         .set("pos", new double[]{0.32948665588843884, 0.32436455916666723, 0.5541926395002755});
    model.component("comp1").geom("geom1").feature("sph105").set("r", 0.02477793503590056);
    model.component("comp1").geom("geom1").feature().create("sph106", "Sphere");
    model.component("comp1").geom("geom1").feature("sph106")
         .set("pos", new double[]{0.6311795677963336, 0.27961296734641716, 0.629566890754101});
    model.component("comp1").geom("geom1").feature("sph106").set("r", 0.013277022970620955);
    model.component("comp1").geom("geom1").feature().create("sph107", "Sphere");
    model.component("comp1").geom("geom1").feature("sph107")
         .set("pos", new double[]{0.23724499270656915, 0.5663544169906237, 0.3629671207032363});
    model.component("comp1").geom("geom1").feature("sph107").set("r", 0.00863316543862436);
    model.component("comp1").geom("geom1").feature().create("sph108", "Sphere");
    model.component("comp1").geom("geom1").feature("sph108")
         .set("pos", new double[]{0.38392029882888334, 0.4476037156818164, 0.5117631406791099});
    model.component("comp1").geom("geom1").feature("sph108").set("r", 0.017314759703861315);
    model.component("comp1").geom("geom1").feature().create("sph109", "Sphere");
    model.component("comp1").geom("geom1").feature("sph109")
         .set("pos", new double[]{0.48506210078806644, 0.4431402387142651, 0.4170565914876237});
    model.component("comp1").geom("geom1").feature("sph109").set("r", 0.008602184958151484);
    model.component("comp1").geom("geom1").feature().create("sph110", "Sphere");
    model.component("comp1").geom("geom1").feature("sph110")
         .set("pos", new double[]{0.5908329525042619, 0.2708381805936242, 0.3566909969423552});
    model.component("comp1").geom("geom1").feature("sph110").set("r", 0.02105910903478197);
    model.component("comp1").geom("geom1").feature().create("sph111", "Sphere");
    model.component("comp1").geom("geom1").feature("sph111")
         .set("pos", new double[]{0.5419221894712902, 0.7416110564714127, 0.732122337142537});
    model.component("comp1").geom("geom1").feature("sph111").set("r", 0.010015945498328955);
    model.component("comp1").geom("geom1").feature().create("sph112", "Sphere");
    model.component("comp1").geom("geom1").feature("sph112")
         .set("pos", new double[]{0.2723886000067293, 0.7453743622372137, 0.3645373528167073});
    model.component("comp1").geom("geom1").feature("sph112").set("r", 0.022813811947648317);
    model.component("comp1").geom("geom1").feature().create("sph114", "Sphere");
    model.component("comp1").geom("geom1").feature("sph114")
         .set("pos", new double[]{0.5003478543451986, 0.6830524573878307, 0.3753283994902635});
    model.component("comp1").geom("geom1").feature("sph114").set("r", 0.0033421962565535392);
    model.component("comp1").geom("geom1").feature().create("sph115", "Sphere");
    model.component("comp1").geom("geom1").feature("sph115")
         .set("pos", new double[]{0.3085575654276913, 0.6112846263523171, 0.35910904436076035});
    model.component("comp1").geom("geom1").feature("sph115").set("r", 0.010718308609780857);
    model.component("comp1").geom("geom1").feature().create("sph116", "Sphere");
    model.component("comp1").geom("geom1").feature("sph116")
         .set("pos", new double[]{0.347714102000253, 0.3904191968584973, 0.6597236392476015});
    model.component("comp1").geom("geom1").feature("sph116").set("r", 0.005952621278095789);
    model.component("comp1").geom("geom1").feature().create("sph117", "Sphere");
    model.component("comp1").geom("geom1").feature("sph117")
         .set("pos", new double[]{0.3762785123857493, 0.7171004345121917, 0.5517622463371347});
    model.component("comp1").geom("geom1").feature("sph117").set("r", 0.007468061998359692);
    model.component("comp1").geom("geom1").feature().create("sph119", "Sphere");
    model.component("comp1").geom("geom1").feature("sph119")
         .set("pos", new double[]{0.6229289358855118, 0.4610659560238538, 0.28214774874866605});
    model.component("comp1").geom("geom1").feature("sph119").set("r", 0.024263208031897222);
    model.component("comp1").geom("geom1").feature().create("sph120", "Sphere");
    model.component("comp1").geom("geom1").feature("sph120")
         .set("pos", new double[]{0.18986793879821956, 0.44441062985731433, 0.3097859976691074});
    model.component("comp1").geom("geom1").feature("sph120").set("r", 0.008734262723131932);
    model.component("comp1").geom("geom1").feature().create("sph123", "Sphere");
    model.component("comp1").geom("geom1").feature("sph123")
         .set("pos", new double[]{0.402460368374499, 0.3749600620881784, 0.4628305384817852});
    model.component("comp1").geom("geom1").feature("sph123").set("r", 0.01135486695422221);
    model.component("comp1").geom("geom1").feature().create("sph124", "Sphere");
    model.component("comp1").geom("geom1").feature("sph124")
         .set("pos", new double[]{0.24228277488949165, 0.48754564055656424, 0.3932143198914326});
    model.component("comp1").geom("geom1").feature("sph124").set("r", 0.011239411313730768);
    model.component("comp1").geom("geom1").feature().create("sph125", "Sphere");
    model.component("comp1").geom("geom1").feature("sph125")
         .set("pos", new double[]{0.3882053785765697, 0.6122384513726037, 0.40417735605415905});
    model.component("comp1").geom("geom1").feature("sph125").set("r", 0.010579801869257192);
    model.component("comp1").geom("geom1").feature().create("sph127", "Sphere");
    model.component("comp1").geom("geom1").feature("sph127")
         .set("pos", new double[]{0.16724074607255413, 0.41129899004927695, 0.6067043673999356});
    model.component("comp1").geom("geom1").feature("sph127").set("r", 0.012261116791161644);
    model.component("comp1").geom("geom1").feature().create("sph128", "Sphere");
    model.component("comp1").geom("geom1").feature("sph128")
         .set("pos", new double[]{0.43799081670538315, 0.5912146870869053, 0.34379452857278747});
    model.component("comp1").geom("geom1").feature("sph128").set("r", 0.017651833066284997);
    model.component("comp1").geom("geom1").feature().create("sph129", "Sphere");
    model.component("comp1").geom("geom1").feature("sph129")
         .set("pos", new double[]{0.46845819602164346, 0.6816790076059389, 0.5062760742264059});
    model.component("comp1").geom("geom1").feature("sph129").set("r", 0.009859056641888839);
    model.component("comp1").geom("geom1").feature().create("sph130", "Sphere");
    model.component("comp1").geom("geom1").feature("sph130")
         .set("pos", new double[]{0.12461735798632502, 0.5911147969056755, 0.25356301342092885});
    model.component("comp1").geom("geom1").feature("sph130").set("r", 0.008502091971747342);
    model.component("comp1").geom("geom1").feature().create("sph131", "Sphere");
    model.component("comp1").geom("geom1").feature("sph131")
         .set("pos", new double[]{0.3911498124382425, 0.705556934556184, 0.2906435061589736});
    model.component("comp1").geom("geom1").feature("sph131").set("r", 0.010571618605882897);
    model.component("comp1").geom("geom1").feature().create("sph133", "Sphere");
    model.component("comp1").geom("geom1").feature("sph133")
         .set("pos", new double[]{0.22024944886902784, 0.30263448323592795, 0.5230011955055412});
    model.component("comp1").geom("geom1").feature("sph133").set("r", 0.008418562809257762);
    model.component("comp1").geom("geom1").feature().create("sph134", "Sphere");
    model.component("comp1").geom("geom1").feature("sph134")
         .set("pos", new double[]{0.4633889932260781, 0.7206592019469001, 0.2512212867033319});
    model.component("comp1").geom("geom1").feature("sph134").set("r", 0.017991210135807775);
    model.component("comp1").geom("geom1").feature().create("sph135", "Sphere");
    model.component("comp1").geom("geom1").feature("sph135")
         .set("pos", new double[]{0.42682537953869093, 0.5288328835602047, 0.7285773342050683});
    model.component("comp1").geom("geom1").feature("sph135").set("r", 0.016885523039562828);
    model.component("comp1").geom("geom1").feature().create("sph136", "Sphere");
    model.component("comp1").geom("geom1").feature("sph136")
         .set("pos", new double[]{0.48212691774287947, 0.645901983989867, 0.4894896888460649});
    model.component("comp1").geom("geom1").feature("sph136").set("r", 0.002388048487510913);
    model.component("comp1").geom("geom1").feature().create("sph137", "Sphere");
    model.component("comp1").geom("geom1").feature("sph137")
         .set("pos", new double[]{0.5293307308516184, 0.2941841122989149, 0.4563061103546689});
    model.component("comp1").geom("geom1").feature("sph137").set("r", 0.009681192000726611);
    model.component("comp1").geom("geom1").feature().create("sph139", "Sphere");
    model.component("comp1").geom("geom1").feature("sph139")
         .set("pos", new double[]{0.43999184360646104, 0.6859526083142976, 0.5440440403421221});
    model.component("comp1").geom("geom1").feature("sph139").set("r", 0.01143693594187289);
    model.component("comp1").geom("geom1").feature().create("sph140", "Sphere");
    model.component("comp1").geom("geom1").feature("sph140")
         .set("pos", new double[]{0.6344463616563569, 0.6775703781489916, 0.48599519036896355});
    model.component("comp1").geom("geom1").feature("sph140").set("r", 0.005069613831503492);
    model.component("comp1").geom("geom1").feature().create("sph141", "Sphere");
    model.component("comp1").geom("geom1").feature("sph141")
         .set("pos", new double[]{0.39583820877747244, 0.7062279381927071, 0.6546748724567769});
    model.component("comp1").geom("geom1").feature("sph141").set("r", 0.023214003581322556);
    model.component("comp1").geom("geom1").feature().create("sph143", "Sphere");
    model.component("comp1").geom("geom1").feature("sph143")
         .set("pos", new double[]{0.6137764702075771, 0.3883224129979891, 0.3232171912398286});
    model.component("comp1").geom("geom1").feature("sph143").set("r", 0.010950097573327272);
    model.component("comp1").geom("geom1").feature().create("sph144", "Sphere");
    model.component("comp1").geom("geom1").feature("sph144")
         .set("pos", new double[]{0.3479168513193634, 0.6975849968762066, 0.32310778293893966});
    model.component("comp1").geom("geom1").feature("sph144").set("r", 0.02238500731999088);
    model.component("comp1").geom("geom1").feature().create("sph147", "Sphere");
    model.component("comp1").geom("geom1").feature("sph147")
         .set("pos", new double[]{0.4959600943782202, 0.6921154163423996, 0.5715418627796729});
    model.component("comp1").geom("geom1").feature("sph147").set("r", 0.02287785802215591);
    model.component("comp1").geom("geom1").feature().create("sph148", "Sphere");
    model.component("comp1").geom("geom1").feature("sph148")
         .set("pos", new double[]{0.27298577673720464, 0.7488185843163365, 0.41784166317611526});
    model.component("comp1").geom("geom1").feature("sph148").set("r", 0.014165618367710313);
    model.component("comp1").geom("geom1").feature().create("sph150", "Sphere");
    model.component("comp1").geom("geom1").feature("sph150")
         .set("pos", new double[]{0.4707493705162867, 0.27865856433371444, 0.5381763305432418});
    model.component("comp1").geom("geom1").feature("sph150").set("r", 0.009543724020885831);
    model.component("comp1").geom("geom1").feature().create("sph152", "Sphere");
    model.component("comp1").geom("geom1").feature("sph152")
         .set("pos", new double[]{0.35199574706503395, 0.4060641274966935, 0.7329937837596665});
    model.component("comp1").geom("geom1").feature("sph152").set("r", 0.01046233435235195);
    model.component("comp1").geom("geom1").feature().create("sph153", "Sphere");
    model.component("comp1").geom("geom1").feature("sph153")
         .set("pos", new double[]{0.1573298619984101, 0.40887770927128053, 0.5299849597804197});
    model.component("comp1").geom("geom1").feature("sph153").set("r", 0.005069106930148892);
    model.component("comp1").geom("geom1").feature().create("sph154", "Sphere");
    model.component("comp1").geom("geom1").feature("sph154")
         .set("pos", new double[]{0.3220175769595266, 0.7495812863637127, 0.4129276287717329});
    model.component("comp1").geom("geom1").feature("sph154").set("r", 0.017161058852550648);
    model.component("comp1").geom("geom1").feature().create("sph155", "Sphere");
    model.component("comp1").geom("geom1").feature("sph155")
         .set("pos", new double[]{0.445554509845214, 0.6455650266018396, 0.7362807535141352});
    model.component("comp1").geom("geom1").feature("sph155").set("r", 0.018592353363078906);
    model.component("comp1").geom("geom1").feature().create("sph156", "Sphere");
    model.component("comp1").geom("geom1").feature("sph156")
         .set("pos", new double[]{0.5086221819393799, 0.5848235586847979, 0.40512329234023037});
    model.component("comp1").geom("geom1").feature("sph156").set("r", 0.02246525409824742);
    model.component("comp1").geom("geom1").feature().create("sph157", "Sphere");
    model.component("comp1").geom("geom1").feature("sph157")
         .set("pos", new double[]{0.13917050599030192, 0.361021751522698, 0.4515720405016697});
    model.component("comp1").geom("geom1").feature("sph157").set("r", 0.005396768298754269);
    model.component("comp1").geom("geom1").feature().create("sph158", "Sphere");
    model.component("comp1").geom("geom1").feature("sph158")
         .set("pos", new double[]{0.5175463850240714, 0.7262788421609702, 0.3033758143645785});
    model.component("comp1").geom("geom1").feature("sph158").set("r", 0.014005914293489597);
    model.component("comp1").geom("geom1").feature().create("sph159", "Sphere");
    model.component("comp1").geom("geom1").feature("sph159")
         .set("pos", new double[]{0.42353182425646346, 0.6094963841608703, 0.6646088084273538});
    model.component("comp1").geom("geom1").feature("sph159").set("r", 0.004461095224457206);
    model.component("comp1").geom("geom1").feature().create("sph160", "Sphere");
    model.component("comp1").geom("geom1").feature("sph160")
         .set("pos", new double[]{0.6181400621217072, 0.435880317212517, 0.42652703393063757});
    model.component("comp1").geom("geom1").feature("sph160").set("r", 0.023524137844986137);
    model.component("comp1").geom("geom1").feature().create("sph161", "Sphere");
    model.component("comp1").geom("geom1").feature("sph161")
         .set("pos", new double[]{0.47471679744697526, 0.5634052584542293, 0.6722245679001175});
    model.component("comp1").geom("geom1").feature("sph161").set("r", 0.0053995995640372645);
    model.component("comp1").geom("geom1").feature().create("sph162", "Sphere");
    model.component("comp1").geom("geom1").feature("sph162")
         .set("pos", new double[]{0.3737961374930449, 0.5249809098593824, 0.3608606925708892});
    model.component("comp1").geom("geom1").feature("sph162").set("r", 0.004236933880115735);
    model.component("comp1").geom("geom1").feature().create("sph163", "Sphere");
    model.component("comp1").geom("geom1").feature("sph163")
         .set("pos", new double[]{0.5685353350271573, 0.27653238484279385, 0.47023923719943483});
    model.component("comp1").geom("geom1").feature("sph163").set("r", 0.0058875843409707095);
    model.component("comp1").geom("geom1").feature().create("sph164", "Sphere");
    model.component("comp1").geom("geom1").feature("sph164")
         .set("pos", new double[]{0.3517828902397336, 0.7384278133130818, 0.4474185455073429});
    model.component("comp1").geom("geom1").feature("sph164").set("r", 0.0046641820299203616);
    model.component("comp1").geom("geom1").feature().create("sph165", "Sphere");
    model.component("comp1").geom("geom1").feature("sph165")
         .set("pos", new double[]{0.18114268285609295, 0.37477186060836976, 0.4378026318528132});
    model.component("comp1").geom("geom1").feature("sph165").set("r", 0.02171387310260505);
    model.component("comp1").geom("geom1").feature().create("sph167", "Sphere");
    model.component("comp1").geom("geom1").feature("sph167")
         .set("pos", new double[]{0.32290690955386403, 0.45131929308430585, 0.541863181184526});
    model.component("comp1").geom("geom1").feature("sph167").set("r", 0.016701298682184028);
    model.component("comp1").geom("geom1").feature().create("sph168", "Sphere");
    model.component("comp1").geom("geom1").feature("sph168")
         .set("pos", new double[]{0.5499953037349031, 0.561691822491764, 0.5994809419584045});
    model.component("comp1").geom("geom1").feature("sph168").set("r", 0.0036109703733268267);
    model.component("comp1").geom("geom1").feature().create("sph169", "Sphere");
    model.component("comp1").geom("geom1").feature("sph169")
         .set("pos", new double[]{0.17194111733509604, 0.43840159977019727, 0.4385645019957375});
    model.component("comp1").geom("geom1").feature("sph169").set("r", 0.01434922902489498);
    model.component("comp1").geom("geom1").feature().create("sph170", "Sphere");
    model.component("comp1").geom("geom1").feature("sph170")
         .set("pos", new double[]{0.12529456044341858, 0.6052086413280803, 0.29992278550125057});
    model.component("comp1").geom("geom1").feature("sph170").set("r", 0.009383988770993988);
    model.component("comp1").geom("geom1").feature().create("sph171", "Sphere");
    model.component("comp1").geom("geom1").feature("sph171")
         .set("pos", new double[]{0.4802889817103837, 0.552164339408111, 0.7265076003670609});
    model.component("comp1").geom("geom1").feature("sph171").set("r", 0.015945087060036958);
    model.component("comp1").geom("geom1").feature().create("sph172", "Sphere");
    model.component("comp1").geom("geom1").feature("sph172")
         .set("pos", new double[]{0.5737285951248415, 0.2632080237696479, 0.5019205212854703});
    model.component("comp1").geom("geom1").feature("sph172").set("r", 0.004375857566958188);
    model.component("comp1").geom("geom1").feature().create("sph173", "Sphere");
    model.component("comp1").geom("geom1").feature("sph173")
         .set("pos", new double[]{0.38775468389881174, 0.41923274484156287, 0.3371337127835009});
    model.component("comp1").geom("geom1").feature("sph173").set("r", 0.011297603212602952);
    model.component("comp1").geom("geom1").feature().create("sph174", "Sphere");
    model.component("comp1").geom("geom1").feature("sph174")
         .set("pos", new double[]{0.3848938327867005, 0.6616775756561, 0.42311572203553466});
    model.component("comp1").geom("geom1").feature("sph174").set("r", 0.002439826641319865);
    model.component("comp1").geom("geom1").feature().create("sph175", "Sphere");
    model.component("comp1").geom("geom1").feature("sph175")
         .set("pos", new double[]{0.1502707489007294, 0.28873332542509555, 0.3514559117610006});
    model.component("comp1").geom("geom1").feature("sph175").set("r", 0.007125867814344545);
    model.component("comp1").geom("geom1").feature().create("sph176", "Sphere");
    model.component("comp1").geom("geom1").feature("sph176")
         .set("pos", new double[]{0.2477926446674156, 0.27999781383584593, 0.27974985379973405});
    model.component("comp1").geom("geom1").feature("sph176").set("r", 0.004300323401195769);
    model.component("comp1").geom("geom1").feature().create("sph177", "Sphere");
    model.component("comp1").geom("geom1").feature("sph177")
         .set("pos", new double[]{0.2038263074743033, 0.5142574388778602, 0.6243555980753838});
    model.component("comp1").geom("geom1").feature("sph177").set("r", 0.021694352131323986);
    model.component("comp1").geom("geom1").feature().create("sph179", "Sphere");
    model.component("comp1").geom("geom1").feature("sph179")
         .set("pos", new double[]{0.2964528148875496, 0.6286304604109055, 0.612463756407756});
    model.component("comp1").geom("geom1").feature("sph179").set("r", 0.014149384051106322);
    model.component("comp1").geom("geom1").feature().create("sph181", "Sphere");
    model.component("comp1").geom("geom1").feature("sph181")
         .set("pos", new double[]{0.4714598031854615, 0.7426820546799077, 0.6168325159801937});
    model.component("comp1").geom("geom1").feature("sph181").set("r", 0.022202567393739867);
    model.component("comp1").geom("geom1").feature().create("sph182", "Sphere");
    model.component("comp1").geom("geom1").feature("sph182")
         .set("pos", new double[]{0.3755626639663776, 0.424635609680348, 0.41914285543374014});
    model.component("comp1").geom("geom1").feature("sph182").set("r", 0.010384526397926091);
    model.component("comp1").geom("geom1").feature().create("sph185", "Sphere");
    model.component("comp1").geom("geom1").feature("sph185")
         .set("pos", new double[]{0.12626219633713387, 0.33158382334262704, 0.5410211782241776});
    model.component("comp1").geom("geom1").feature("sph185").set("r", 0.024326823183724554);
    model.component("comp1").geom("geom1").feature().create("sph186", "Sphere");
    model.component("comp1").geom("geom1").feature("sph186")
         .set("pos", new double[]{0.5820860514888888, 0.5959621143915841, 0.7306453816604567});
    model.component("comp1").geom("geom1").feature("sph186").set("r", 0.0038715007736260217);
    model.component("comp1").geom("geom1").feature().create("sph188", "Sphere");
    model.component("comp1").geom("geom1").feature("sph188")
         .set("pos", new double[]{0.25347160102751615, 0.6806652807487188, 0.422494671934605});
    model.component("comp1").geom("geom1").feature("sph188").set("r", 0.013977513056562791);
    model.component("comp1").geom("geom1").feature().create("sph189", "Sphere");
    model.component("comp1").geom("geom1").feature("sph189")
         .set("pos", new double[]{0.23725207811730314, 0.3969314717312033, 0.6704227358126932});
    model.component("comp1").geom("geom1").feature("sph189").set("r", 0.0020318170499769805);
    model.component("comp1").geom("geom1").feature().create("sph190", "Sphere");
    model.component("comp1").geom("geom1").feature("sph190")
         .set("pos", new double[]{0.34591337673054623, 0.4054104167527655, 0.6824764461109473});
    model.component("comp1").geom("geom1").feature("sph190").set("r", 0.012545572842528234);
    model.component("comp1").geom("geom1").feature().create("sph191", "Sphere");
    model.component("comp1").geom("geom1").feature("sph191")
         .set("pos", new double[]{0.6221890412294468, 0.4248043233214235, 0.7305067196350798});
    model.component("comp1").geom("geom1").feature("sph191").set("r", 0.023735615869629002);
    model.component("comp1").geom("geom1").feature().create("sph192", "Sphere");
    model.component("comp1").geom("geom1").feature("sph192")
         .set("pos", new double[]{0.4645265408690031, 0.36241830929301655, 0.3491565800716323});
    model.component("comp1").geom("geom1").feature("sph192").set("r", 0.02021323010151073);
    model.component("comp1").geom("geom1").feature().create("sph193", "Sphere");
    model.component("comp1").geom("geom1").feature("sph193")
         .set("pos", new double[]{0.6025960096732742, 0.38551381827192444, 0.46168568521567793});
    model.component("comp1").geom("geom1").feature("sph193").set("r", 0.0058190999639886505);
    model.component("comp1").geom("geom1").feature().create("sph194", "Sphere");
    model.component("comp1").geom("geom1").feature("sph194")
         .set("pos", new double[]{0.5205610593326314, 0.6624723999345757, 0.3133632331077102});
    model.component("comp1").geom("geom1").feature("sph194").set("r", 0.01336103018170614);
    model.component("comp1").geom("geom1").feature().create("sph195", "Sphere");
    model.component("comp1").geom("geom1").feature("sph195")
         .set("pos", new double[]{0.5554659214174744, 0.6482525612447171, 0.2965489640784253});
    model.component("comp1").geom("geom1").feature("sph195").set("r", 0.011818800284854694);
    model.component("comp1").geom("geom1").feature().create("sph197", "Sphere");
    model.component("comp1").geom("geom1").feature("sph197")
         .set("pos", new double[]{0.41190910078318294, 0.3631980275190916, 0.5327107709156252});
    model.component("comp1").geom("geom1").feature("sph197").set("r", 0.004475207218440384);
    model.component("comp1").geom("geom1").feature().create("sph198", "Sphere");
    model.component("comp1").geom("geom1").feature("sph198")
         .set("pos", new double[]{0.6322598785076847, 0.7114373227683429, 0.43202961622274866});
    model.component("comp1").geom("geom1").feature("sph198").set("r", 0.004703089786783667);
    model.component("comp1").geom("geom1").feature().create("sph199", "Sphere");
    model.component("comp1").geom("geom1").feature("sph199")
         .set("pos", new double[]{0.24149804187356483, 0.4764943846126411, 0.26810752018591516});
    model.component("comp1").geom("geom1").feature("sph199").set("r", 0.007570107664899965);
    model.component("comp1").geom("geom1").feature().create("sph200", "Sphere");
    model.component("comp1").geom("geom1").feature("sph200")
         .set("pos", new double[]{0.32763170644987666, 0.42512313618351266, 0.6435770392277196});
    model.component("comp1").geom("geom1").feature("sph200").set("r", 0.01671321743972792);
    model.component("comp1").geom("geom1").feature().create("sph202", "Sphere");
    model.component("comp1").geom("geom1").feature("sph202")
         .set("pos", new double[]{0.3022036634033646, 0.5454859833907117, 0.38291816488570757});
    model.component("comp1").geom("geom1").feature("sph202").set("r", 0.019709245283752043);
    model.component("comp1").geom("geom1").feature().create("sph203", "Sphere");
    model.component("comp1").geom("geom1").feature("sph203")
         .set("pos", new double[]{0.17897441719566332, 0.34728516916507074, 0.3336444862077195});
    model.component("comp1").geom("geom1").feature("sph203").set("r", 0.02211119809272137);
    model.component("comp1").geom("geom1").feature().create("sph204", "Sphere");
    model.component("comp1").geom("geom1").feature("sph204")
         .set("pos", new double[]{0.5043507742387245, 0.4979470319058767, 0.47859596534903515});
    model.component("comp1").geom("geom1").feature("sph204").set("r", 0.01126959805529864);
    model.component("comp1").geom("geom1").feature().create("sph205", "Sphere");
    model.component("comp1").geom("geom1").feature("sph205")
         .set("pos", new double[]{0.3342712155336692, 0.27881612316309395, 0.3453414488352919});
    model.component("comp1").geom("geom1").feature("sph205").set("r", 0.0020125571926309003);

    return model;
  }

  public static Model run3(Model model) {
    model.component("comp1").geom("geom1").feature().create("sph206", "Sphere");
    model.component("comp1").geom("geom1").feature("sph206")
         .set("pos", new double[]{0.2318140250786394, 0.670181662625056, 0.6400955461449719});
    model.component("comp1").geom("geom1").feature("sph206").set("r", 0.023445060596091367);
    model.component("comp1").geom("geom1").feature().create("sph207", "Sphere");
    model.component("comp1").geom("geom1").feature("sph207")
         .set("pos", new double[]{0.4319448403004015, 0.30261552572447903, 0.6002910928845262});
    model.component("comp1").geom("geom1").feature("sph207").set("r", 0.005660363449671585);
    model.component("comp1").geom("geom1").feature().create("sph208", "Sphere");
    model.component("comp1").geom("geom1").feature("sph208")
         .set("pos", new double[]{0.5361713976502512, 0.47452906517465715, 0.7014923495689542});
    model.component("comp1").geom("geom1").feature("sph208").set("r", 0.016661632379560753);
    model.component("comp1").geom("geom1").feature().create("sph209", "Sphere");
    model.component("comp1").geom("geom1").feature("sph209")
         .set("pos", new double[]{0.2623873101392029, 0.5935754064243731, 0.44471164565642485});
    model.component("comp1").geom("geom1").feature("sph209").set("r", 0.003135025776134113);
    model.component("comp1").geom("geom1").feature().create("sph210", "Sphere");
    model.component("comp1").geom("geom1").feature("sph210")
         .set("pos", new double[]{0.16366200494596553, 0.6478776059742444, 0.47147290939018127});
    model.component("comp1").geom("geom1").feature("sph210").set("r", 0.005977881148236597);
    model.component("comp1").geom("geom1").feature().create("sph212", "Sphere");
    model.component("comp1").geom("geom1").feature("sph212")
         .set("pos", new double[]{0.5781984798150875, 0.6052214382665513, 0.2523283846617996});
    model.component("comp1").geom("geom1").feature("sph212").set("r", 0.01385968197297879);
    model.component("comp1").geom("geom1").feature().create("sph213", "Sphere");
    model.component("comp1").geom("geom1").feature("sph213")
         .set("pos", new double[]{0.590655643600864, 0.5911768088427488, 0.3308557455704843});
    model.component("comp1").geom("geom1").feature("sph213").set("r", 0.017965630581489887);
    model.component("comp1").geom("geom1").feature().create("sph214", "Sphere");
    model.component("comp1").geom("geom1").feature("sph214")
         .set("pos", new double[]{0.18661257715823573, 0.4163162831944438, 0.714008740458961});
    model.component("comp1").geom("geom1").feature("sph214").set("r", 0.01312091693083155);
    model.component("comp1").geom("geom1").feature().create("sph215", "Sphere");
    model.component("comp1").geom("geom1").feature("sph215")
         .set("pos", new double[]{0.2656522840897723, 0.4070882976280691, 0.5346189161742416});
    model.component("comp1").geom("geom1").feature("sph215").set("r", 0.02323602207385029);
    model.component("comp1").geom("geom1").feature().create("sph216", "Sphere");
    model.component("comp1").geom("geom1").feature("sph216")
         .set("pos", new double[]{0.1983044213111396, 0.36804728279127114, 0.6785462137305917});
    model.component("comp1").geom("geom1").feature("sph216").set("r", 0.024153537790988742);
    model.component("comp1").geom("geom1").feature().create("sph217", "Sphere");
    model.component("comp1").geom("geom1").feature("sph217")
         .set("pos", new double[]{0.5838054467030231, 0.33479478989112993, 0.5008043517550429});
    model.component("comp1").geom("geom1").feature("sph217").set("r", 0.013313521329291924);
    model.component("comp1").geom("geom1").feature().create("sph218", "Sphere");
    model.component("comp1").geom("geom1").feature("sph218")
         .set("pos", new double[]{0.277585640914463, 0.4586595897633861, 0.4519579741177429});
    model.component("comp1").geom("geom1").feature("sph218").set("r", 0.009504201550935565);
    model.component("comp1").geom("geom1").feature().create("sph220", "Sphere");
    model.component("comp1").geom("geom1").feature("sph220")
         .set("pos", new double[]{0.4163930113425979, 0.627403861543013, 0.6361760804206771});
    model.component("comp1").geom("geom1").feature("sph220").set("r", 0.008668009340614975);
    model.component("comp1").geom("geom1").feature().create("sph221", "Sphere");
    model.component("comp1").geom("geom1").feature("sph221")
         .set("pos", new double[]{0.518603624967668, 0.6044935020615655, 0.31448262095129187});
    model.component("comp1").geom("geom1").feature("sph221").set("r", 0.009924200597349182);
    model.component("comp1").geom("geom1").feature().create("sph222", "Sphere");
    model.component("comp1").geom("geom1").feature("sph222")
         .set("pos", new double[]{0.3452988934404775, 0.4779745761137031, 0.4593855014634895});
    model.component("comp1").geom("geom1").feature("sph222").set("r", 0.021916745777028977);
    model.component("comp1").geom("geom1").feature().create("sph223", "Sphere");
    model.component("comp1").geom("geom1").feature("sph223")
         .set("pos", new double[]{0.4379933573219185, 0.48375893222999405, 0.6748204988026237});
    model.component("comp1").geom("geom1").feature("sph223").set("r", 0.015060458033982673);
    model.component("comp1").geom("geom1").feature().create("sph225", "Sphere");
    model.component("comp1").geom("geom1").feature("sph225")
         .set("pos", new double[]{0.22207589779762657, 0.27691827128328206, 0.6799082243821021});
    model.component("comp1").geom("geom1").feature("sph225").set("r", 0.010008414683169962);
    model.component("comp1").geom("geom1").feature().create("sph226", "Sphere");
    model.component("comp1").geom("geom1").feature("sph226")
         .set("pos", new double[]{0.1836367333546764, 0.4046364626233429, 0.3301003220093124});
    model.component("comp1").geom("geom1").feature("sph226").set("r", 0.023126568377378046);
    model.component("comp1").geom("geom1").feature().create("sph227", "Sphere");
    model.component("comp1").geom("geom1").feature("sph227")
         .set("pos", new double[]{0.5911954202886042, 0.2757784124803522, 0.738728790806789});
    model.component("comp1").geom("geom1").feature("sph227").set("r", 0.004665664782995234);
    model.component("comp1").geom("geom1").feature().create("sph228", "Sphere");
    model.component("comp1").geom("geom1").feature("sph228")
         .set("pos", new double[]{0.5718423498398618, 0.517670373199384, 0.4205800557791587});
    model.component("comp1").geom("geom1").feature("sph228").set("r", 0.004218369796039836);
    model.component("comp1").geom("geom1").feature().create("sph229", "Sphere");
    model.component("comp1").geom("geom1").feature("sph229")
         .set("pos", new double[]{0.5114679161949006, 0.39519819077321017, 0.5636910732677363});
    model.component("comp1").geom("geom1").feature("sph229").set("r", 0.00987387466237863);
    model.component("comp1").geom("geom1").feature().create("sph230", "Sphere");
    model.component("comp1").geom("geom1").feature("sph230")
         .set("pos", new double[]{0.36714901479610057, 0.6938409080106027, 0.5117418050984794});
    model.component("comp1").geom("geom1").feature("sph230").set("r", 0.013898499920869842);
    model.component("comp1").geom("geom1").feature().create("sph231", "Sphere");
    model.component("comp1").geom("geom1").feature("sph231")
         .set("pos", new double[]{0.48958331729483745, 0.2674560565135032, 0.624171791757617});
    model.component("comp1").geom("geom1").feature("sph231").set("r", 0.021017816870119985);
    model.component("comp1").geom("geom1").feature().create("sph232", "Sphere");
    model.component("comp1").geom("geom1").feature("sph232")
         .set("pos", new double[]{0.5910978736030645, 0.2694381554048288, 0.40397049742273955});
    model.component("comp1").geom("geom1").feature("sph232").set("r", 0.006988015752093935);
    model.component("comp1").geom("geom1").feature().create("sph233", "Sphere");
    model.component("comp1").geom("geom1").feature("sph233")
         .set("pos", new double[]{0.3617836481160204, 0.6493274555715339, 0.387453139865607});
    model.component("comp1").geom("geom1").feature("sph233").set("r", 0.004293857786399342);
    model.component("comp1").geom("geom1").feature().create("sph235", "Sphere");
    model.component("comp1").geom("geom1").feature("sph235")
         .set("pos", new double[]{0.14410240878369823, 0.5887040909090507, 0.4336818688302989});
    model.component("comp1").geom("geom1").feature("sph235").set("r", 0.007229336328782541);
    model.component("comp1").geom("geom1").feature().create("sph238", "Sphere");
    model.component("comp1").geom("geom1").feature("sph238")
         .set("pos", new double[]{0.20445214567988138, 0.40988413452887074, 0.4748604969016124});
    model.component("comp1").geom("geom1").feature("sph238").set("r", 0.00868934085310508);
    model.component("comp1").geom("geom1").feature().create("sph239", "Sphere");
    model.component("comp1").geom("geom1").feature("sph239")
         .set("pos", new double[]{0.5595752501424236, 0.6873310142001039, 0.3508539972934265});
    model.component("comp1").geom("geom1").feature("sph239").set("r", 0.014010044987048739);
    model.component("comp1").geom("geom1").feature().create("sph240", "Sphere");
    model.component("comp1").geom("geom1").feature("sph240")
         .set("pos", new double[]{0.17400869950500494, 0.4645493739405815, 0.398874442654345});
    model.component("comp1").geom("geom1").feature("sph240").set("r", 0.016326562740272305);
    model.component("comp1").geom("geom1").feature().create("sph243", "Sphere");
    model.component("comp1").geom("geom1").feature("sph243")
         .set("pos", new double[]{0.6362547607843342, 0.3402368427112175, 0.5019162224797037});
    model.component("comp1").geom("geom1").feature("sph243").set("r", 0.013645181152537938);
    model.component("comp1").geom("geom1").feature().create("sph245", "Sphere");
    model.component("comp1").geom("geom1").feature("sph245")
         .set("pos", new double[]{0.4889767355385993, 0.5140032864526463, 0.7056619739737124});
    model.component("comp1").geom("geom1").feature("sph245").set("r", 0.020521068678321028);
    model.component("comp1").geom("geom1").feature().create("sph246", "Sphere");
    model.component("comp1").geom("geom1").feature("sph246")
         .set("pos", new double[]{0.570645584659961, 0.6568920412531458, 0.3479367546393809});
    model.component("comp1").geom("geom1").feature("sph246").set("r", 0.013324312353890335);
    model.component("comp1").geom("geom1").feature().create("sph248", "Sphere");
    model.component("comp1").geom("geom1").feature("sph248")
         .set("pos", new double[]{0.4987994299419055, 0.2943822811685473, 0.49201574292015504});
    model.component("comp1").geom("geom1").feature("sph248").set("r", 0.013657848045208209);
    model.component("comp1").geom("geom1").feature().create("sph249", "Sphere");
    model.component("comp1").geom("geom1").feature("sph249")
         .set("pos", new double[]{0.23855451841623682, 0.5738935434324622, 0.5309189922355413});
    model.component("comp1").geom("geom1").feature("sph249").set("r", 0.02358347649897087);
    model.component("comp1").geom("geom1").feature().create("sph253", "Sphere");
    model.component("comp1").geom("geom1").feature("sph253")
         .set("pos", new double[]{0.12350279447552834, 0.4415752280866056, 0.4794711753865406});
    model.component("comp1").geom("geom1").feature("sph253").set("r", 0.012504183394791136);
    model.component("comp1").geom("geom1").feature().create("sph256", "Sphere");
    model.component("comp1").geom("geom1").feature("sph256")
         .set("pos", new double[]{0.37014312237286934, 0.3347163897368753, 0.7475749822680117});
    model.component("comp1").geom("geom1").feature("sph256").set("r", 0.021511941205170138);
    model.component("comp1").geom("geom1").feature().create("sph257", "Sphere");
    model.component("comp1").geom("geom1").feature("sph257")
         .set("pos", new double[]{0.3595855357355715, 0.28088291363734885, 0.717818129817959});
    model.component("comp1").geom("geom1").feature("sph257").set("r", 0.004975182503890091);
    model.component("comp1").geom("geom1").feature().create("sph258", "Sphere");
    model.component("comp1").geom("geom1").feature("sph258")
         .set("pos", new double[]{0.4850485048810285, 0.41202182937613724, 0.36686023822152136});
    model.component("comp1").geom("geom1").feature("sph258").set("r", 0.02419327363951411);
    model.component("comp1").geom("geom1").feature().create("sph259", "Sphere");
    model.component("comp1").geom("geom1").feature("sph259")
         .set("pos", new double[]{0.17605102404938106, 0.49740267884542694, 0.31462559319609656});
    model.component("comp1").geom("geom1").feature("sph259").set("r", 0.00810197646435209);
    model.component("comp1").geom("geom1").feature().create("sph260", "Sphere");
    model.component("comp1").geom("geom1").feature("sph260")
         .set("pos", new double[]{0.4423356718506616, 0.6001104690079508, 0.2609797796308381});
    model.component("comp1").geom("geom1").feature("sph260").set("r", 0.009284805330729494);
    model.component("comp1").geom("geom1").feature().create("sph261", "Sphere");
    model.component("comp1").geom("geom1").feature("sph261")
         .set("pos", new double[]{0.4550501926703197, 0.6673937204926265, 0.4725407173061585});
    model.component("comp1").geom("geom1").feature("sph261").set("r", 0.011892667640665018);
    model.component("comp1").geom("geom1").feature().create("sph263", "Sphere");
    model.component("comp1").geom("geom1").feature("sph263")
         .set("pos", new double[]{0.5479360550957931, 0.3567589688852779, 0.39333181561375});
    model.component("comp1").geom("geom1").feature("sph263").set("r", 0.007890617285460413);
    model.component("comp1").geom("geom1").feature().create("sph264", "Sphere");
    model.component("comp1").geom("geom1").feature("sph264")
         .set("pos", new double[]{0.4846377624461949, 0.5134424830569048, 0.5883074016670871});
    model.component("comp1").geom("geom1").feature("sph264").set("r", 0.020198230913439585);
    model.component("comp1").geom("geom1").feature().create("sph265", "Sphere");
    model.component("comp1").geom("geom1").feature("sph265")
         .set("pos", new double[]{0.11442567670249389, 0.25513267042238474, 0.49018797391007723});
    model.component("comp1").geom("geom1").feature("sph265").set("r", 0.01162864786211061);
    model.component("comp1").geom("geom1").feature().create("sph266", "Sphere");
    model.component("comp1").geom("geom1").feature("sph266")
         .set("pos", new double[]{0.1316072148739371, 0.7301461272604344, 0.6705461686749856});
    model.component("comp1").geom("geom1").feature("sph266").set("r", 0.003915692533536982);
    model.component("comp1").geom("geom1").feature().create("sph267", "Sphere");
    model.component("comp1").geom("geom1").feature("sph267")
         .set("pos", new double[]{0.1058546445277874, 0.7165820101933877, 0.37809605839040733});
    model.component("comp1").geom("geom1").feature("sph267").set("r", 0.005496626225820099);
    model.component("comp1").geom("geom1").feature().create("sph271", "Sphere");
    model.component("comp1").geom("geom1").feature("sph271")
         .set("pos", new double[]{0.13841383038640043, 0.5861784651341174, 0.700608591529319});
    model.component("comp1").geom("geom1").feature("sph271").set("r", 0.016206110599092598);
    model.component("comp1").geom("geom1").feature().create("sph272", "Sphere");
    model.component("comp1").geom("geom1").feature("sph272")
         .set("pos", new double[]{0.29892438722962883, 0.3047316453360542, 0.6145139614890991});
    model.component("comp1").geom("geom1").feature("sph272").set("r", 0.014065272552008398);
    model.component("comp1").geom("geom1").feature().create("sph273", "Sphere");
    model.component("comp1").geom("geom1").feature("sph273")
         .set("pos", new double[]{0.17301160557334078, 0.6166747676567139, 0.25771409936868145});
    model.component("comp1").geom("geom1").feature("sph273").set("r", 0.02235550257787154);
    model.component("comp1").geom("geom1").feature().create("sph275", "Sphere");
    model.component("comp1").geom("geom1").feature("sph275")
         .set("pos", new double[]{0.2571914022662425, 0.653725451530926, 0.7413904567216935});
    model.component("comp1").geom("geom1").feature("sph275").set("r", 0.02337370844610502);
    model.component("comp1").geom("geom1").feature().create("sph276", "Sphere");
    model.component("comp1").geom("geom1").feature("sph276")
         .set("pos", new double[]{0.38468417109424285, 0.279963574216518, 0.47111615294964077});
    model.component("comp1").geom("geom1").feature("sph276").set("r", 0.020018122846840535);
    model.component("comp1").geom("geom1").feature().create("sph278", "Sphere");
    model.component("comp1").geom("geom1").feature("sph278")
         .set("pos", new double[]{0.3434317042410556, 0.3708050428349009, 0.49554721412475017});
    model.component("comp1").geom("geom1").feature("sph278").set("r", 0.0057647380064879145);
    model.component("comp1").geom("geom1").feature().create("sph279", "Sphere");
    model.component("comp1").geom("geom1").feature("sph279")
         .set("pos", new double[]{0.5961453316388547, 0.6473512375890415, 0.5107121227519443});
    model.component("comp1").geom("geom1").feature("sph279").set("r", 0.002808681373472466);
    model.component("comp1").geom("geom1").feature().create("sph281", "Sphere");
    model.component("comp1").geom("geom1").feature("sph281")
         .set("pos", new double[]{0.6189896051067536, 0.536190450602953, 0.3082849991715007});
    model.component("comp1").geom("geom1").feature("sph281").set("r", 0.024953862021520147);
    model.component("comp1").geom("geom1").feature().create("sph282", "Sphere");
    model.component("comp1").geom("geom1").feature("sph282")
         .set("pos", new double[]{0.11648533842579832, 0.34100326180063695, 0.7247876434666931});
    model.component("comp1").geom("geom1").feature("sph282").set("r", 0.015413435112782148);
    model.component("comp1").geom("geom1").feature().create("sph285", "Sphere");
    model.component("comp1").geom("geom1").feature("sph285")
         .set("pos", new double[]{0.2278161825387885, 0.5772961987394007, 0.2965638436744795});
    model.component("comp1").geom("geom1").feature("sph285").set("r", 0.011023335621505566);
    model.component("comp1").geom("geom1").feature().create("sph287", "Sphere");
    model.component("comp1").geom("geom1").feature("sph287")
         .set("pos", new double[]{0.1308678709407958, 0.5517567524167136, 0.3557320101961444});
    model.component("comp1").geom("geom1").feature("sph287").set("r", 0.01824744328634125);
    model.component("comp1").geom("geom1").feature().create("sph288", "Sphere");
    model.component("comp1").geom("geom1").feature("sph288")
         .set("pos", new double[]{0.5352282155421884, 0.7244718304082389, 0.3961342038209035});
    model.component("comp1").geom("geom1").feature("sph288").set("r", 0.008180307661407534);
    model.component("comp1").geom("geom1").feature().create("sph291", "Sphere");
    model.component("comp1").geom("geom1").feature("sph291")
         .set("pos", new double[]{0.42438421074868676, 0.45314829092355957, 0.6378380287462838});
    model.component("comp1").geom("geom1").feature("sph291").set("r", 0.0024162162386339283);
    model.component("comp1").geom("geom1").feature().create("sph294", "Sphere");
    model.component("comp1").geom("geom1").feature("sph294")
         .set("pos", new double[]{0.6123708589925891, 0.311742986661926, 0.5962997858706806});
    model.component("comp1").geom("geom1").feature("sph294").set("r", 0.008066656788360629);
    model.component("comp1").geom("geom1").feature().create("sph298", "Sphere");
    model.component("comp1").geom("geom1").feature("sph298")
         .set("pos", new double[]{0.3114636448409714, 0.5146413525093033, 0.569293602260592});
    model.component("comp1").geom("geom1").feature("sph298").set("r", 0.010499041423211938);
    model.component("comp1").geom("geom1").feature().create("sph299", "Sphere");
    model.component("comp1").geom("geom1").feature("sph299")
         .set("pos", new double[]{0.11896430101355465, 0.43560142343104064, 0.3923380392513437});
    model.component("comp1").geom("geom1").feature("sph299").set("r", 0.00859448370992907);
    model.component("comp1").geom("geom1").feature().create("sph300", "Sphere");
    model.component("comp1").geom("geom1").feature("sph300")
         .set("pos", new double[]{0.5701651122830897, 0.6712634021470544, 0.5614758109651614});
    model.component("comp1").geom("geom1").feature("sph300").set("r", 0.023670248537415103);
    model.component("comp1").geom("geom1").feature().create("sph301", "Sphere");
    model.component("comp1").geom("geom1").feature("sph301")
         .set("pos", new double[]{0.4008980594204436, 0.6467362931463255, 0.2948093442922742});
    model.component("comp1").geom("geom1").feature("sph301").set("r", 0.009918650788075594);
    model.component("comp1").geom("geom1").feature().create("sph302", "Sphere");
    model.component("comp1").geom("geom1").feature("sph302")
         .set("pos", new double[]{0.1413914358762992, 0.6473818629873678, 0.6426072927092591});
    model.component("comp1").geom("geom1").feature("sph302").set("r", 0.02042472224587201);
    model.component("comp1").geom("geom1").feature().create("sph303", "Sphere");
    model.component("comp1").geom("geom1").feature("sph303")
         .set("pos", new double[]{0.4441313866768753, 0.48586330382271165, 0.3275342366076526});
    model.component("comp1").geom("geom1").feature("sph303").set("r", 0.0031731681030613837);
    model.component("comp1").geom("geom1").feature().create("sph304", "Sphere");
    model.component("comp1").geom("geom1").feature("sph304")
         .set("pos", new double[]{0.5223343714861169, 0.5182644974295075, 0.7401752522737611});
    model.component("comp1").geom("geom1").feature("sph304").set("r", 0.005412715566579639);
    model.component("comp1").geom("geom1").feature().create("sph305", "Sphere");
    model.component("comp1").geom("geom1").feature("sph305")
         .set("pos", new double[]{0.6217358097049036, 0.3039695680390424, 0.7146524091615772});
    model.component("comp1").geom("geom1").feature("sph305").set("r", 0.024591698877631914);
    model.component("comp1").geom("geom1").feature().create("sph306", "Sphere");
    model.component("comp1").geom("geom1").feature("sph306")
         .set("pos", new double[]{0.35265401434766586, 0.6158394100390567, 0.3431894910291523});
    model.component("comp1").geom("geom1").feature("sph306").set("r", 0.007625101007472945);
    model.component("comp1").geom("geom1").feature().create("sph307", "Sphere");
    model.component("comp1").geom("geom1").feature("sph307")
         .set("pos", new double[]{0.21164052313191284, 0.2976116163329891, 0.3030265603774177});
    model.component("comp1").geom("geom1").feature("sph307").set("r", 0.015025166927749588);
    model.component("comp1").geom("geom1").feature().create("sph308", "Sphere");
    model.component("comp1").geom("geom1").feature("sph308")
         .set("pos", new double[]{0.11269066015233521, 0.44797393887178405, 0.5672245687989236});
    model.component("comp1").geom("geom1").feature("sph308").set("r", 0.010225697801509032);
    model.component("comp1").geom("geom1").feature().create("sph309", "Sphere");
    model.component("comp1").geom("geom1").feature("sph309")
         .set("pos", new double[]{0.1564973969800878, 0.2784224568050124, 0.3779978758792809});
    model.component("comp1").geom("geom1").feature("sph309").set("r", 0.01123882825509174);
    model.component("comp1").geom("geom1").feature().create("sph310", "Sphere");
    model.component("comp1").geom("geom1").feature("sph310")
         .set("pos", new double[]{0.6253195172384147, 0.31895888014310686, 0.641476682344037});
    model.component("comp1").geom("geom1").feature("sph310").set("r", 0.005894191882502817);
    model.component("comp1").geom("geom1").feature().create("sph311", "Sphere");
    model.component("comp1").geom("geom1").feature("sph311")
         .set("pos", new double[]{0.41096261606459217, 0.49061208366756626, 0.7337210212393326});
    model.component("comp1").geom("geom1").feature("sph311").set("r", 0.01548048266004633);
    model.component("comp1").geom("geom1").feature().create("sph312", "Sphere");
    model.component("comp1").geom("geom1").feature("sph312")
         .set("pos", new double[]{0.5273831945048634, 0.512065755816106, 0.4338744786799403});
    model.component("comp1").geom("geom1").feature("sph312").set("r", 0.010368429827107669);
    model.component("comp1").geom("geom1").feature().create("sph315", "Sphere");
    model.component("comp1").geom("geom1").feature("sph315")
         .set("pos", new double[]{0.35449129205608826, 0.5212297396575469, 0.7241748992192407});
    model.component("comp1").geom("geom1").feature("sph315").set("r", 0.01943845547613795);
    model.component("comp1").geom("geom1").feature().create("sph318", "Sphere");
    model.component("comp1").geom("geom1").feature("sph318")
         .set("pos", new double[]{0.5246488659427817, 0.6108806944544535, 0.6350920804777738});
    model.component("comp1").geom("geom1").feature("sph318").set("r", 0.0135484283566546);
    model.component("comp1").geom("geom1").feature().create("sph319", "Sphere");
    model.component("comp1").geom("geom1").feature("sph319")
         .set("pos", new double[]{0.5350760045131003, 0.5088499423967339, 0.4715625603230756});
    model.component("comp1").geom("geom1").feature("sph319").set("r", 0.008914976650025637);
    model.component("comp1").geom("geom1").feature().create("sph321", "Sphere");
    model.component("comp1").geom("geom1").feature("sph321")
         .set("pos", new double[]{0.19459100673679586, 0.4027946885826889, 0.2731305723058259});
    model.component("comp1").geom("geom1").feature("sph321").set("r", 0.024608772529030314);
    model.component("comp1").geom("geom1").feature().create("sph322", "Sphere");
    model.component("comp1").geom("geom1").feature("sph322")
         .set("pos", new double[]{0.27963608668965134, 0.7194938399414598, 0.6629736395167549});
    model.component("comp1").geom("geom1").feature("sph322").set("r", 0.009619184246732703);
    model.component("comp1").geom("geom1").feature().create("sph323", "Sphere");
    model.component("comp1").geom("geom1").feature("sph323")
         .set("pos", new double[]{0.12389137011057202, 0.6552900086040688, 0.5653429808328113});
    model.component("comp1").geom("geom1").feature("sph323").set("r", 0.010803577042583744);
    model.component("comp1").geom("geom1").feature().create("sph324", "Sphere");
    model.component("comp1").geom("geom1").feature("sph324")
         .set("pos", new double[]{0.6423780663907234, 0.29555160485923854, 0.6749997350552366});
    model.component("comp1").geom("geom1").feature("sph324").set("r", 0.005504383123980124);
    model.component("comp1").geom("geom1").feature().create("sph326", "Sphere");
    model.component("comp1").geom("geom1").feature("sph326")
         .set("pos", new double[]{0.4359164107057082, 0.2944434539095886, 0.6845128074059604});
    model.component("comp1").geom("geom1").feature("sph326").set("r", 0.0235708806122129);
    model.component("comp1").geom("geom1").feature().create("sph328", "Sphere");
    model.component("comp1").geom("geom1").feature("sph328")
         .set("pos", new double[]{0.5482802147348875, 0.5860084555090207, 0.6838030873260423});
    model.component("comp1").geom("geom1").feature("sph328").set("r", 0.005851023847569402);
    model.component("comp1").geom("geom1").feature().create("sph329", "Sphere");
    model.component("comp1").geom("geom1").feature("sph329")
         .set("pos", new double[]{0.5127962439391017, 0.746659244174239, 0.5419859875940621});
    model.component("comp1").geom("geom1").feature("sph329").set("r", 0.024231227459255773);
    model.component("comp1").geom("geom1").feature().create("sph330", "Sphere");
    model.component("comp1").geom("geom1").feature("sph330")
         .set("pos", new double[]{0.11061096711839521, 0.4082647747307538, 0.6511931744553164});
    model.component("comp1").geom("geom1").feature("sph330").set("r", 0.0028539808895033);
    model.component("comp1").geom("geom1").feature().create("sph331", "Sphere");
    model.component("comp1").geom("geom1").feature("sph331")
         .set("pos", new double[]{0.6082438574183432, 0.27952977149495045, 0.27018594552829317});
    model.component("comp1").geom("geom1").feature("sph331").set("r", 0.021921098245468812);
    model.component("comp1").geom("geom1").feature().create("sph333", "Sphere");
    model.component("comp1").geom("geom1").feature("sph333")
         .set("pos", new double[]{0.462510327390415, 0.43639932200268994, 0.621559018500196});
    model.component("comp1").geom("geom1").feature("sph333").set("r", 0.011210316298926238);
    model.component("comp1").geom("geom1").feature().create("sph334", "Sphere");
    model.component("comp1").geom("geom1").feature("sph334")
         .set("pos", new double[]{0.23805922698005794, 0.3747972347342663, 0.368582634015786});
    model.component("comp1").geom("geom1").feature("sph334").set("r", 0.014137438688175913);
    model.component("comp1").geom("geom1").feature().create("sph337", "Sphere");
    model.component("comp1").geom("geom1").feature("sph337")
         .set("pos", new double[]{0.2700014218629446, 0.389863372095288, 0.41483369759816374});
    model.component("comp1").geom("geom1").feature("sph337").set("r", 0.017786745290010876);
    model.component("comp1").geom("geom1").feature().create("sph338", "Sphere");
    model.component("comp1").geom("geom1").feature("sph338")
         .set("pos", new double[]{0.4144721042360828, 0.28415638575709, 0.28551001625712746});
    model.component("comp1").geom("geom1").feature("sph338").set("r", 0.02063694787549434);
    model.component("comp1").geom("geom1").feature().create("sph339", "Sphere");
    model.component("comp1").geom("geom1").feature("sph339")
         .set("pos", new double[]{0.5160055519095419, 0.5798619061704132, 0.5898876105441597});
    model.component("comp1").geom("geom1").feature("sph339").set("r", 0.010539599718497484);
    model.component("comp1").geom("geom1").feature().create("sph340", "Sphere");
    model.component("comp1").geom("geom1").feature("sph340")
         .set("pos", new double[]{0.2662971159714079, 0.5085559213349403, 0.5061141264147621});
    model.component("comp1").geom("geom1").feature("sph340").set("r", 0.019645831519244226);
    model.component("comp1").geom("geom1").feature().create("sph341", "Sphere");
    model.component("comp1").geom("geom1").feature("sph341")
         .set("pos", new double[]{0.6089071799314996, 0.37793835839656753, 0.6349390543173268});
    model.component("comp1").geom("geom1").feature("sph341").set("r", 0.019011547527138836);
    model.component("comp1").geom("geom1").feature().create("sph343", "Sphere");
    model.component("comp1").geom("geom1").feature("sph343")
         .set("pos", new double[]{0.18307557592047086, 0.6152471250381416, 0.2880397729444989});
    model.component("comp1").geom("geom1").feature("sph343").set("r", 0.0028439026109964988);
    model.component("comp1").geom("geom1").feature().create("sph344", "Sphere");
    model.component("comp1").geom("geom1").feature("sph344")
         .set("pos", new double[]{0.22869496270971104, 0.3762017625150458, 0.5866905477578875});
    model.component("comp1").geom("geom1").feature("sph344").set("r", 0.013870845117045139);
    model.component("comp1").geom("geom1").feature().create("sph345", "Sphere");
    model.component("comp1").geom("geom1").feature("sph345")
         .set("pos", new double[]{0.578313916387641, 0.45749354621883276, 0.4858338517867203});
    model.component("comp1").geom("geom1").feature("sph345").set("r", 0.0026944337851803673);
    model.component("comp1").geom("geom1").feature().create("sph346", "Sphere");
    model.component("comp1").geom("geom1").feature("sph346")
         .set("pos", new double[]{0.45085154344431877, 0.40957507311351016, 0.29595139362857925});
    model.component("comp1").geom("geom1").feature("sph346").set("r", 0.014421103164954914);
    model.component("comp1").geom("geom1").feature().create("sph347", "Sphere");
    model.component("comp1").geom("geom1").feature("sph347")
         .set("pos", new double[]{0.1986657981815164, 0.5124846297989749, 0.3968344209411039});
    model.component("comp1").geom("geom1").feature("sph347").set("r", 0.00932271554332206);
    model.component("comp1").geom("geom1").feature().create("sph348", "Sphere");
    model.component("comp1").geom("geom1").feature("sph348")
         .set("pos", new double[]{0.608765498408862, 0.5447039681514305, 0.5433695371090008});

    return model;
  }

  public static Model run4(Model model) {
    model.component("comp1").geom("geom1").feature("sph348").set("r", 0.024035545093849003);
    model.component("comp1").geom("geom1").feature().create("sph350", "Sphere");
    model.component("comp1").geom("geom1").feature("sph350")
         .set("pos", new double[]{0.2169147922865083, 0.47833666312031076, 0.7444251731909135});
    model.component("comp1").geom("geom1").feature("sph350").set("r", 0.010407397646715756);
    model.component("comp1").geom("geom1").feature().create("sph351", "Sphere");
    model.component("comp1").geom("geom1").feature("sph351")
         .set("pos", new double[]{0.18263244563855158, 0.2613954593370007, 0.6924355038555745});
    model.component("comp1").geom("geom1").feature("sph351").set("r", 0.02297947191926654);
    model.component("comp1").geom("geom1").feature().create("sph353", "Sphere");
    model.component("comp1").geom("geom1").feature("sph353")
         .set("pos", new double[]{0.24509179765303254, 0.27723436421466935, 0.34608846173771346});
    model.component("comp1").geom("geom1").feature("sph353").set("r", 0.004807968957238746);
    model.component("comp1").geom("geom1").feature().create("sph354", "Sphere");
    model.component("comp1").geom("geom1").feature("sph354")
         .set("pos", new double[]{0.20937399834095838, 0.5781967418323186, 0.27242471390720274});
    model.component("comp1").geom("geom1").feature("sph354").set("r", 0.005043030521620447);
    model.component("comp1").geom("geom1").feature().create("sph355", "Sphere");
    model.component("comp1").geom("geom1").feature("sph355")
         .set("pos", new double[]{0.17697281714443983, 0.3961298996115858, 0.3877188391221063});
    model.component("comp1").geom("geom1").feature("sph355").set("r", 0.004342656150708979);
    model.component("comp1").geom("geom1").feature().create("sph356", "Sphere");
    model.component("comp1").geom("geom1").feature("sph356")
         .set("pos", new double[]{0.5088534827235877, 0.7488536661617022, 0.501454305714771});
    model.component("comp1").geom("geom1").feature("sph356").set("r", 0.007866467062282707);
    model.component("comp1").geom("geom1").feature().create("sph358", "Sphere");
    model.component("comp1").geom("geom1").feature("sph358")
         .set("pos", new double[]{0.3714900109624491, 0.5635498224670723, 0.46556422319489354});
    model.component("comp1").geom("geom1").feature("sph358").set("r", 0.008810938788537948);
    model.component("comp1").geom("geom1").feature().create("sph359", "Sphere");
    model.component("comp1").geom("geom1").feature("sph359")
         .set("pos", new double[]{0.5685300170359145, 0.5867618540250036, 0.47958231567118104});
    model.component("comp1").geom("geom1").feature("sph359").set("r", 0.02350869177778999);
    model.component("comp1").geom("geom1").feature().create("sph360", "Sphere");
    model.component("comp1").geom("geom1").feature("sph360")
         .set("pos", new double[]{0.31939331361374806, 0.5880229380592049, 0.38118290039298075});
    model.component("comp1").geom("geom1").feature("sph360").set("r", 0.005028807481732508);
    model.component("comp1").geom("geom1").feature().create("sph361", "Sphere");
    model.component("comp1").geom("geom1").feature("sph361")
         .set("pos", new double[]{0.595761395285048, 0.5904443947555255, 0.542242867572881});
    model.component("comp1").geom("geom1").feature("sph361").set("r", 0.0043917257834986696);
    model.component("comp1").geom("geom1").feature().create("sph367", "Sphere");
    model.component("comp1").geom("geom1").feature("sph367")
         .set("pos", new double[]{0.12963217776010344, 0.5562570468857396, 0.4567130021820738});
    model.component("comp1").geom("geom1").feature("sph367").set("r", 0.021388385817224936);
    model.component("comp1").geom("geom1").feature().create("sph369", "Sphere");
    model.component("comp1").geom("geom1").feature("sph369")
         .set("pos", new double[]{0.4898638665912506, 0.6549889767338251, 0.27624779753713025});
    model.component("comp1").geom("geom1").feature("sph369").set("r", 0.005230108991534218);
    model.component("comp1").geom("geom1").feature().create("sph370", "Sphere");
    model.component("comp1").geom("geom1").feature("sph370")
         .set("pos", new double[]{0.12896439242600108, 0.7250273244004292, 0.5687534036701606});
    model.component("comp1").geom("geom1").feature("sph370").set("r", 0.008701942872348763);
    model.component("comp1").geom("geom1").feature().create("sph372", "Sphere");
    model.component("comp1").geom("geom1").feature("sph372")
         .set("pos", new double[]{0.3105155016459041, 0.5639698809281465, 0.416534907984892});
    model.component("comp1").geom("geom1").feature("sph372").set("r", 0.010137837749170741);
    model.component("comp1").geom("geom1").feature().create("sph374", "Sphere");
    model.component("comp1").geom("geom1").feature("sph374")
         .set("pos", new double[]{0.12749377279872653, 0.3544122101252993, 0.45861890717089254});
    model.component("comp1").geom("geom1").feature("sph374").set("r", 0.004581749829509878);
    model.component("comp1").geom("geom1").feature().create("sph378", "Sphere");
    model.component("comp1").geom("geom1").feature("sph378")
         .set("pos", new double[]{0.5159529857430973, 0.44228514359072546, 0.5909695797578048});
    model.component("comp1").geom("geom1").feature("sph378").set("r", 0.015829374969196855);
    model.component("comp1").geom("geom1").feature().create("sph379", "Sphere");
    model.component("comp1").geom("geom1").feature("sph379")
         .set("pos", new double[]{0.28186373516952573, 0.7380298888222617, 0.5597629656821328});
    model.component("comp1").geom("geom1").feature("sph379").set("r", 0.020166998571509873);
    model.component("comp1").geom("geom1").feature().create("sph381", "Sphere");
    model.component("comp1").geom("geom1").feature("sph381")
         .set("pos", new double[]{0.1986991535163137, 0.513558466486431, 0.4496806161932121});
    model.component("comp1").geom("geom1").feature("sph381").set("r", 0.022889712722395317);
    model.component("comp1").geom("geom1").feature().create("sph383", "Sphere");
    model.component("comp1").geom("geom1").feature("sph383")
         .set("pos", new double[]{0.3700983247406721, 0.5948849301395532, 0.6056805266326799});
    model.component("comp1").geom("geom1").feature("sph383").set("r", 0.003698004475977716);
    model.component("comp1").geom("geom1").feature().create("sph384", "Sphere");
    model.component("comp1").geom("geom1").feature("sph384")
         .set("pos", new double[]{0.5262225200649472, 0.3934742800156385, 0.4838845481155112});
    model.component("comp1").geom("geom1").feature("sph384").set("r", 0.02284936488047218);
    model.component("comp1").geom("geom1").feature().create("sph387", "Sphere");
    model.component("comp1").geom("geom1").feature("sph387")
         .set("pos", new double[]{0.5295592516979323, 0.7490461337343702, 0.664148746177452});
    model.component("comp1").geom("geom1").feature("sph387").set("r", 0.021523159588901435);
    model.component("comp1").geom("geom1").feature().create("sph388", "Sphere");
    model.component("comp1").geom("geom1").feature("sph388")
         .set("pos", new double[]{0.17871612348936486, 0.6605139995182622, 0.2770887536372927});
    model.component("comp1").geom("geom1").feature("sph388").set("r", 0.011532500300530633);
    model.component("comp1").geom("geom1").feature().create("sph389", "Sphere");
    model.component("comp1").geom("geom1").feature("sph389")
         .set("pos", new double[]{0.5974139195536262, 0.7274337981262562, 0.5551132131245466});
    model.component("comp1").geom("geom1").feature("sph389").set("r", 0.010056237768931647);
    model.component("comp1").geom("geom1").feature().create("sph390", "Sphere");
    model.component("comp1").geom("geom1").feature("sph390")
         .set("pos", new double[]{0.13967419637313588, 0.49179740548716516, 0.5078644007504661});
    model.component("comp1").geom("geom1").feature("sph390").set("r", 0.01783891129062541);
    model.component("comp1").geom("geom1").feature().create("sph392", "Sphere");
    model.component("comp1").geom("geom1").feature("sph392")
         .set("pos", new double[]{0.4228259544864281, 0.5974119017680302, 0.3966464874923394});
    model.component("comp1").geom("geom1").feature("sph392").set("r", 0.012008265689875581);
    model.component("comp1").geom("geom1").feature().create("sph393", "Sphere");
    model.component("comp1").geom("geom1").feature("sph393")
         .set("pos", new double[]{0.12001960196928343, 0.2685078598004954, 0.3684713360341222});
    model.component("comp1").geom("geom1").feature("sph393").set("r", 0.00956593647813661);
    model.component("comp1").geom("geom1").feature().create("sph396", "Sphere");
    model.component("comp1").geom("geom1").feature("sph396")
         .set("pos", new double[]{0.42075480163205436, 0.26550981111093835, 0.7491456563908645});
    model.component("comp1").geom("geom1").feature("sph396").set("r", 0.015494494823134386);
    model.component("comp1").geom("geom1").feature().create("sph397", "Sphere");
    model.component("comp1").geom("geom1").feature("sph397")
         .set("pos", new double[]{0.5047748689437452, 0.6498642076169588, 0.4230384287307229});
    model.component("comp1").geom("geom1").feature("sph397").set("r", 0.005026247939421261);
    model.component("comp1").geom("geom1").feature().create("sph398", "Sphere");
    model.component("comp1").geom("geom1").feature("sph398")
         .set("pos", new double[]{0.15955620545981647, 0.6111884431737115, 0.46147103942186984});
    model.component("comp1").geom("geom1").feature("sph398").set("r", 0.006527597257302216);
    model.component("comp1").geom("geom1").feature().create("sph401", "Sphere");
    model.component("comp1").geom("geom1").feature("sph401")
         .set("pos", new double[]{0.45919881680959496, 0.2984168120754031, 0.5604070283606152});
    model.component("comp1").geom("geom1").feature("sph401").set("r", 0.006574521008651307);
    model.component("comp1").geom("geom1").feature().create("sph403", "Sphere");
    model.component("comp1").geom("geom1").feature("sph403")
         .set("pos", new double[]{0.4223603372022169, 0.6829679048911874, 0.7094678243672426});
    model.component("comp1").geom("geom1").feature("sph403").set("r", 0.011041815550138593);
    model.component("comp1").geom("geom1").feature().create("sph404", "Sphere");
    model.component("comp1").geom("geom1").feature("sph404")
         .set("pos", new double[]{0.20194978856221388, 0.3010403425020569, 0.33841662511346426});
    model.component("comp1").geom("geom1").feature("sph404").set("r", 0.0032311812647683163);
    model.component("comp1").geom("geom1").feature().create("sph406", "Sphere");
    model.component("comp1").geom("geom1").feature("sph406")
         .set("pos", new double[]{0.622016496641583, 0.5665353012854953, 0.663088420607095});
    model.component("comp1").geom("geom1").feature("sph406").set("r", 0.02247256545187356);
    model.component("comp1").geom("geom1").feature().create("sph407", "Sphere");
    model.component("comp1").geom("geom1").feature("sph407")
         .set("pos", new double[]{0.27680088072612297, 0.6797236588420659, 0.2693650369580281});
    model.component("comp1").geom("geom1").feature("sph407").set("r", 0.019894893479268073);
    model.component("comp1").geom("geom1").feature().create("sph408", "Sphere");
    model.component("comp1").geom("geom1").feature("sph408")
         .set("pos", new double[]{0.2514618390697201, 0.4660753079391294, 0.55398903377292});
    model.component("comp1").geom("geom1").feature("sph408").set("r", 0.0020084489062835308);
    model.component("comp1").geom("geom1").feature().create("sph409", "Sphere");
    model.component("comp1").geom("geom1").feature("sph409")
         .set("pos", new double[]{0.46865359785179983, 0.639516640441769, 0.3346998740186062});
    model.component("comp1").geom("geom1").feature("sph409").set("r", 0.00434071613052453);
    model.component("comp1").geom("geom1").feature().create("sph410", "Sphere");
    model.component("comp1").geom("geom1").feature("sph410")
         .set("pos", new double[]{0.38553017590833694, 0.46105881550558475, 0.6384502270536206});
    model.component("comp1").geom("geom1").feature("sph410").set("r", 0.011547880861131258);
    model.component("comp1").geom("geom1").feature().create("sph412", "Sphere");
    model.component("comp1").geom("geom1").feature("sph412")
         .set("pos", new double[]{0.23164866692334318, 0.319818919119493, 0.34035729202935344});
    model.component("comp1").geom("geom1").feature("sph412").set("r", 0.003531715641417677);
    model.component("comp1").geom("geom1").feature().create("sph413", "Sphere");
    model.component("comp1").geom("geom1").feature("sph413")
         .set("pos", new double[]{0.4645701702043718, 0.4700927249575925, 0.7268230943500057});
    model.component("comp1").geom("geom1").feature("sph413").set("r", 0.014151247922319064);
    model.component("comp1").geom("geom1").feature().create("sph414", "Sphere");
    model.component("comp1").geom("geom1").feature("sph414")
         .set("pos", new double[]{0.5157659592037419, 0.6766874078534041, 0.5154489872403616});
    model.component("comp1").geom("geom1").feature("sph414").set("r", 0.007526723360693833);
    model.component("comp1").geom("geom1").feature().create("sph415", "Sphere");
    model.component("comp1").geom("geom1").feature("sph415")
         .set("pos", new double[]{0.42549815852933404, 0.44988952927941184, 0.5120157283274087});
    model.component("comp1").geom("geom1").feature("sph415").set("r", 0.012493117545115721);
    model.component("comp1").geom("geom1").feature().create("sph416", "Sphere");
    model.component("comp1").geom("geom1").feature("sph416")
         .set("pos", new double[]{0.3225653494446024, 0.5833166908972458, 0.2921768786340771});
    model.component("comp1").geom("geom1").feature("sph416").set("r", 0.011589480898962437);
    model.component("comp1").geom("geom1").feature().create("sph419", "Sphere");
    model.component("comp1").geom("geom1").feature("sph419")
         .set("pos", new double[]{0.13080498710681113, 0.45107581920957374, 0.5715649719472494});
    model.component("comp1").geom("geom1").feature("sph419").set("r", 0.007094274112468028);
    model.component("comp1").geom("geom1").feature().create("sph423", "Sphere");
    model.component("comp1").geom("geom1").feature("sph423")
         .set("pos", new double[]{0.19290165112401617, 0.5837697174168969, 0.2998244316278988});
    model.component("comp1").geom("geom1").feature("sph423").set("r", 0.0046786548457240715);
    model.component("comp1").geom("geom1").feature().create("sph424", "Sphere");
    model.component("comp1").geom("geom1").feature("sph424")
         .set("pos", new double[]{0.33352374217369773, 0.6005982373637535, 0.6935697237914366});
    model.component("comp1").geom("geom1").feature("sph424").set("r", 0.01501443719463035);
    model.component("comp1").geom("geom1").feature().create("sph426", "Sphere");
    model.component("comp1").geom("geom1").feature("sph426")
         .set("pos", new double[]{0.3311032501413015, 0.3560509031787311, 0.3920288788278499});
    model.component("comp1").geom("geom1").feature("sph426").set("r", 0.013854960993785644);
    model.component("comp1").geom("geom1").feature().create("sph427", "Sphere");
    model.component("comp1").geom("geom1").feature("sph427")
         .set("pos", new double[]{0.2715737978513032, 0.41388669249284066, 0.2516761366717807});
    model.component("comp1").geom("geom1").feature("sph427").set("r", 0.023744912319006932);
    model.component("comp1").geom("geom1").feature().create("sph430", "Sphere");
    model.component("comp1").geom("geom1").feature("sph430")
         .set("pos", new double[]{0.1814900754333391, 0.3495389818563768, 0.6081790555833645});
    model.component("comp1").geom("geom1").feature("sph430").set("r", 0.023321473082087103);
    model.component("comp1").geom("geom1").feature().create("sph431", "Sphere");
    model.component("comp1").geom("geom1").feature("sph431")
         .set("pos", new double[]{0.26026239281199753, 0.3261127224903783, 0.3288636392470951});
    model.component("comp1").geom("geom1").feature("sph431").set("r", 0.006508017348456998);
    model.component("comp1").geom("geom1").feature().create("sph433", "Sphere");
    model.component("comp1").geom("geom1").feature("sph433")
         .set("pos", new double[]{0.3141560045753486, 0.2927577701262934, 0.4814956714620376});
    model.component("comp1").geom("geom1").feature("sph433").set("r", 0.0025646066800514844);
    model.component("comp1").geom("geom1").feature().create("sph435", "Sphere");
    model.component("comp1").geom("geom1").feature("sph435")
         .set("pos", new double[]{0.24199249762129899, 0.618233324654385, 0.6880611337140171});
    model.component("comp1").geom("geom1").feature("sph435").set("r", 0.02119548678533844);
    model.component("comp1").geom("geom1").feature().create("sph436", "Sphere");
    model.component("comp1").geom("geom1").feature("sph436")
         .set("pos", new double[]{0.17514831285355614, 0.25409470359121383, 0.3376700348954379});
    model.component("comp1").geom("geom1").feature("sph436").set("r", 0.020540855483130213);
    model.component("comp1").geom("geom1").feature().create("sph437", "Sphere");
    model.component("comp1").geom("geom1").feature("sph437")
         .set("pos", new double[]{0.4369903690235225, 0.42841612849996524, 0.5875054207692387});
    model.component("comp1").geom("geom1").feature("sph437").set("r", 0.008220978841772334);
    model.component("comp1").geom("geom1").feature().create("sph446", "Sphere");
    model.component("comp1").geom("geom1").feature("sph446")
         .set("pos", new double[]{0.3048650727182066, 0.3504701325942833, 0.6326677168347536});
    model.component("comp1").geom("geom1").feature("sph446").set("r", 0.008126519007009227);
    model.component("comp1").geom("geom1").feature().create("sph447", "Sphere");
    model.component("comp1").geom("geom1").feature("sph447")
         .set("pos", new double[]{0.5583930909776248, 0.565878056307685, 0.27675452391107386});
    model.component("comp1").geom("geom1").feature("sph447").set("r", 0.005317522346496018);
    model.component("comp1").geom("geom1").feature().create("sph450", "Sphere");
    model.component("comp1").geom("geom1").feature("sph450")
         .set("pos", new double[]{0.6243158540562384, 0.35369216253009167, 0.2571156873962764});
    model.component("comp1").geom("geom1").feature("sph450").set("r", 0.008753186855478434);
    model.component("comp1").geom("geom1").feature().create("sph451", "Sphere");
    model.component("comp1").geom("geom1").feature("sph451")
         .set("pos", new double[]{0.3763325165844698, 0.26283306400753814, 0.514040519983858});
    model.component("comp1").geom("geom1").feature("sph451").set("r", 0.009494661366087313);
    model.component("comp1").geom("geom1").feature().create("sph454", "Sphere");
    model.component("comp1").geom("geom1").feature("sph454")
         .set("pos", new double[]{0.4329539110031451, 0.7436857766957897, 0.6482891568472369});
    model.component("comp1").geom("geom1").feature("sph454").set("r", 0.0023062706046687483);
    model.component("comp1").geom("geom1").feature().create("sph456", "Sphere");
    model.component("comp1").geom("geom1").feature("sph456")
         .set("pos", new double[]{0.5629893848527551, 0.5122497128978297, 0.2960322471205557});
    model.component("comp1").geom("geom1").feature("sph456").set("r", 0.024242076215524433);
    model.component("comp1").geom("geom1").feature().create("sph463", "Sphere");
    model.component("comp1").geom("geom1").feature("sph463")
         .set("pos", new double[]{0.6010517197047599, 0.3328273166652069, 0.436644298271072});
    model.component("comp1").geom("geom1").feature("sph463").set("r", 0.01222638328235566);
    model.component("comp1").geom("geom1").feature().create("sph465", "Sphere");
    model.component("comp1").geom("geom1").feature("sph465")
         .set("pos", new double[]{0.3645566080548065, 0.4624142693371856, 0.3459686526842055});
    model.component("comp1").geom("geom1").feature("sph465").set("r", 0.0038642371385834155);
    model.component("comp1").geom("geom1").feature().create("sph468", "Sphere");
    model.component("comp1").geom("geom1").feature("sph468")
         .set("pos", new double[]{0.3283475467048788, 0.49592438692053575, 0.27012794716495186});
    model.component("comp1").geom("geom1").feature("sph468").set("r", 0.0064664667751097886);
    model.component("comp1").geom("geom1").feature().create("sph469", "Sphere");
    model.component("comp1").geom("geom1").feature("sph469")
         .set("pos", new double[]{0.4290285888868709, 0.35313538437118164, 0.6587101531223777});
    model.component("comp1").geom("geom1").feature("sph469").set("r", 0.005354346815029567);
    model.component("comp1").geom("geom1").feature().create("sph471", "Sphere");
    model.component("comp1").geom("geom1").feature("sph471")
         .set("pos", new double[]{0.1808862085367704, 0.6725557929865776, 0.36681609154201544});
    model.component("comp1").geom("geom1").feature("sph471").set("r", 0.0047144671585632215);
    model.component("comp1").geom("geom1").feature().create("sph474", "Sphere");
    model.component("comp1").geom("geom1").feature("sph474")
         .set("pos", new double[]{0.133845470664964, 0.5955745590856367, 0.6523892701751386});
    model.component("comp1").geom("geom1").feature("sph474").set("r", 0.020445016528589238);
    model.component("comp1").geom("geom1").feature().create("sph478", "Sphere");
    model.component("comp1").geom("geom1").feature("sph478")
         .set("pos", new double[]{0.2982263920744092, 0.3952736857474134, 0.5237391314276119});
    model.component("comp1").geom("geom1").feature("sph478").set("r", 0.008559023347049163);
    model.component("comp1").geom("geom1").feature().create("sph479", "Sphere");
    model.component("comp1").geom("geom1").feature("sph479")
         .set("pos", new double[]{0.25600899557769063, 0.3090847904023511, 0.2766569347056508});
    model.component("comp1").geom("geom1").feature("sph479").set("r", 0.017722834508131814);
    model.component("comp1").geom("geom1").feature().create("sph481", "Sphere");
    model.component("comp1").geom("geom1").feature("sph481")
         .set("pos", new double[]{0.16254668395681993, 0.6617561888332868, 0.7402924904573801});
    model.component("comp1").geom("geom1").feature("sph481").set("r", 0.014354229638914534);
    model.component("comp1").geom("geom1").feature().create("sph482", "Sphere");
    model.component("comp1").geom("geom1").feature("sph482")
         .set("pos", new double[]{0.13464034147075435, 0.3034791765522551, 0.4271593922090555});
    model.component("comp1").geom("geom1").feature("sph482").set("r", 0.012317815226407496);
    model.component("comp1").geom("geom1").feature().create("sph487", "Sphere");
    model.component("comp1").geom("geom1").feature("sph487")
         .set("pos", new double[]{0.4475291289553085, 0.5931823926489671, 0.48163675353418045});
    model.component("comp1").geom("geom1").feature("sph487").set("r", 0.02368392641990745);
    model.component("comp1").geom("geom1").feature().create("sph491", "Sphere");
    model.component("comp1").geom("geom1").feature("sph491")
         .set("pos", new double[]{0.19134474472385588, 0.32395782532948997, 0.7289768424916105});
    model.component("comp1").geom("geom1").feature("sph491").set("r", 0.011516668785547366);
    model.component("comp1").geom("geom1").feature().create("sph492", "Sphere");
    model.component("comp1").geom("geom1").feature("sph492")
         .set("pos", new double[]{0.6098331873053968, 0.28430837007907367, 0.46544361928107086});
    model.component("comp1").geom("geom1").feature("sph492").set("r", 0.009014176208027611);
    model.component("comp1").geom("geom1").feature().create("sph493", "Sphere");
    model.component("comp1").geom("geom1").feature("sph493")
         .set("pos", new double[]{0.10756660578685268, 0.5113031751804635, 0.301805392440667});
    model.component("comp1").geom("geom1").feature("sph493").set("r", 0.0049812381158854824);
    model.component("comp1").geom("geom1").feature().create("sph495", "Sphere");
    model.component("comp1").geom("geom1").feature("sph495")
         .set("pos", new double[]{0.2713926858591859, 0.5905397526015653, 0.6024115711172361});
    model.component("comp1").geom("geom1").feature("sph495").set("r", 0.01858399839394726);
    model.component("comp1").geom("geom1").feature().create("sph496", "Sphere");
    model.component("comp1").geom("geom1").feature("sph496")
         .set("pos", new double[]{0.3090298911163425, 0.41636939107434173, 0.5429236126495728});
    model.component("comp1").geom("geom1").feature("sph496").set("r", 0.009871205618772094);
    model.component("comp1").geom("geom1").feature().create("sph499", "Sphere");
    model.component("comp1").geom("geom1").feature("sph499")
         .set("pos", new double[]{0.45037253267943256, 0.4855283405914819, 0.6447372758321178});
    model.component("comp1").geom("geom1").feature("sph499").set("r", 0.01304247956433923);
    model.component("comp1").geom("geom1").feature().create("sph500", "Sphere");
    model.component("comp1").geom("geom1").feature("sph500")
         .set("pos", new double[]{0.3871360575190079, 0.3650523489774955, 0.5370601415178013});
    model.component("comp1").geom("geom1").feature("sph500").set("r", 0.012949931677269336);
    model.component("comp1").geom("geom1").feature().create("sph502", "Sphere");
    model.component("comp1").geom("geom1").feature("sph502")
         .set("pos", new double[]{0.3364473034293481, 0.37329616516116004, 0.30992725913270613});
    model.component("comp1").geom("geom1").feature("sph502").set("r", 0.011591684047415852);
    model.component("comp1").geom("geom1").feature().create("sph503", "Sphere");
    model.component("comp1").geom("geom1").feature("sph503")
         .set("pos", new double[]{0.11663290983761512, 0.374911927865641, 0.46595618302507424});
    model.component("comp1").geom("geom1").feature("sph503").set("r", 0.002901842401919632);
    model.component("comp1").geom("geom1").feature().create("sph505", "Sphere");
    model.component("comp1").geom("geom1").feature("sph505")
         .set("pos", new double[]{0.28817092036937164, 0.5231798843643816, 0.6671148551176013});
    model.component("comp1").geom("geom1").feature("sph505").set("r", 0.00615519429543459);
    model.component("comp1").geom("geom1").feature().create("sph506", "Sphere");
    model.component("comp1").geom("geom1").feature("sph506")
         .set("pos", new double[]{0.25205935819550995, 0.27805851364734624, 0.6500201075332391});
    model.component("comp1").geom("geom1").feature("sph506").set("r", 0.010054644895001259);
    model.component("comp1").geom("geom1").feature().create("sph507", "Sphere");
    model.component("comp1").geom("geom1").feature("sph507")
         .set("pos", new double[]{0.41281680712023044, 0.7404955934369211, 0.2507203668330432});
    model.component("comp1").geom("geom1").feature("sph507").set("r", 0.010732328193753617);
    model.component("comp1").geom("geom1").feature().create("sph508", "Sphere");
    model.component("comp1").geom("geom1").feature("sph508")
         .set("pos", new double[]{0.5255271530004352, 0.6412965418810078, 0.6221180929675816});
    model.component("comp1").geom("geom1").feature("sph508").set("r", 0.005345353236073917);
    model.component("comp1").geom("geom1").feature().create("sph509", "Sphere");
    model.component("comp1").geom("geom1").feature("sph509")
         .set("pos", new double[]{0.6246272109208236, 0.4341394922848448, 0.5354933350804004});
    model.component("comp1").geom("geom1").feature("sph509").set("r", 0.014350974493985072);
    model.component("comp1").geom("geom1").feature().create("sph510", "Sphere");
    model.component("comp1").geom("geom1").feature("sph510")
         .set("pos", new double[]{0.32604493085808284, 0.5974687231285682, 0.35954412009572395});
    model.component("comp1").geom("geom1").feature("sph510").set("r", 0.003457487104623511);
    model.component("comp1").geom("geom1").feature().create("sph512", "Sphere");
    model.component("comp1").geom("geom1").feature("sph512")
         .set("pos", new double[]{0.6324105473913225, 0.27232725842356953, 0.7119419328455859});
    model.component("comp1").geom("geom1").feature("sph512").set("r", 0.00391278975158651);
    model.component("comp1").geom("geom1").feature().create("sph515", "Sphere");
    model.component("comp1").geom("geom1").feature("sph515")
         .set("pos", new double[]{0.41103906412800817, 0.5691694484186562, 0.6606171045166112});
    model.component("comp1").geom("geom1").feature("sph515").set("r", 0.010637635166944479);
    model.component("comp1").geom("geom1").feature().create("sph520", "Sphere");
    model.component("comp1").geom("geom1").feature("sph520")
         .set("pos", new double[]{0.564277310103839, 0.5219222621069453, 0.6066201388265826});
    model.component("comp1").geom("geom1").feature("sph520").set("r", 0.005088141545509971);
    model.component("comp1").geom("geom1").feature().create("sph524", "Sphere");
    model.component("comp1").geom("geom1").feature("sph524")
         .set("pos", new double[]{0.3607845084034112, 0.656997768253693, 0.35565226482218404});
    model.component("comp1").geom("geom1").feature("sph524").set("r", 0.007934827005060357);
    model.component("comp1").geom("geom1").feature().create("sph526", "Sphere");
    model.component("comp1").geom("geom1").feature("sph526")
         .set("pos", new double[]{0.4985010430142395, 0.7309690284847041, 0.44293794892224275});
    model.component("comp1").geom("geom1").feature("sph526").set("r", 0.017648515851089487);
    model.component("comp1").geom("geom1").feature().create("sph527", "Sphere");
    model.component("comp1").geom("geom1").feature("sph527")
         .set("pos", new double[]{0.13340558257863783, 0.3341865784482396, 0.3588206448991746});
    model.component("comp1").geom("geom1").feature("sph527").set("r", 0.010173735746404178);
    model.component("comp1").geom("geom1").feature().create("sph528", "Sphere");
    model.component("comp1").geom("geom1").feature("sph528")
         .set("pos", new double[]{0.511961322488512, 0.5024003541564361, 0.5689927388463561});
    model.component("comp1").geom("geom1").feature("sph528").set("r", 0.006220602742640785);
    model.component("comp1").geom("geom1").feature().create("sph530", "Sphere");
    model.component("comp1").geom("geom1").feature("sph530")
         .set("pos", new double[]{0.1264865535663059, 0.452868698000636, 0.6978069853558663});
    model.component("comp1").geom("geom1").feature("sph530").set("r", 0.011033455755802874);
    model.component("comp1").geom("geom1").feature().create("sph532", "Sphere");
    model.component("comp1").geom("geom1").feature("sph532")
         .set("pos", new double[]{0.16440302716500527, 0.6320322269243525, 0.5899358471972208});
    model.component("comp1").geom("geom1").feature("sph532").set("r", 0.01041795460883716);
    model.component("comp1").geom("geom1").feature().create("sph534", "Sphere");
    model.component("comp1").geom("geom1").feature("sph534")
         .set("pos", new double[]{0.20118313553418066, 0.3976771178102255, 0.6476000539641715});
    model.component("comp1").geom("geom1").feature("sph534").set("r", 0.00667810436597);
    model.component("comp1").geom("geom1").feature().create("sph538", "Sphere");
    model.component("comp1").geom("geom1").feature("sph538")
         .set("pos", new double[]{0.1259448730220759, 0.2651199090090174, 0.5296086396217404});
    model.component("comp1").geom("geom1").feature("sph538").set("r", 0.022264532091559694);
    model.component("comp1").geom("geom1").feature().create("sph539", "Sphere");
    model.component("comp1").geom("geom1").feature("sph539")
         .set("pos", new double[]{0.24116536470085037, 0.37791268947376677, 0.3970117313658348});
    model.component("comp1").geom("geom1").feature("sph539").set("r", 0.009163336097470614);
    model.component("comp1").geom("geom1").feature().create("sph541", "Sphere");
    model.component("comp1").geom("geom1").feature("sph541")
         .set("pos", new double[]{0.3317053788663558, 0.4462415126935705, 0.7078918201621451});
    model.component("comp1").geom("geom1").feature("sph541").set("r", 0.021387501763929485);
    model.component("comp1").geom("geom1").feature().create("sph544", "Sphere");
    model.component("comp1").geom("geom1").feature("sph544")
         .set("pos", new double[]{0.6273137098443332, 0.6708389269006951, 0.7019346467575356});
    model.component("comp1").geom("geom1").feature("sph544").set("r", 0.00864485574121917);
    model.component("comp1").geom("geom1").feature().create("sph545", "Sphere");

    return model;
  }

  public static Model run5(Model model) {
    model.component("comp1").geom("geom1").feature("sph545")
         .set("pos", new double[]{0.41308838049127483, 0.3857843312180632, 0.6650884355828176});
    model.component("comp1").geom("geom1").feature("sph545").set("r", 0.002442337365085615);
    model.component("comp1").geom("geom1").feature().create("sph547", "Sphere");
    model.component("comp1").geom("geom1").feature("sph547")
         .set("pos", new double[]{0.6106758484664814, 0.5269764646559929, 0.7312233520795618});
    model.component("comp1").geom("geom1").feature("sph547").set("r", 0.016533795366197812);
    model.component("comp1").geom("geom1").feature().create("sph551", "Sphere");
    model.component("comp1").geom("geom1").feature("sph551")
         .set("pos", new double[]{0.3916757096759694, 0.5574508970992222, 0.7161759972671446});
    model.component("comp1").geom("geom1").feature("sph551").set("r", 0.010874043304078228);
    model.component("comp1").geom("geom1").feature().create("sph554", "Sphere");
    model.component("comp1").geom("geom1").feature("sph554")
         .set("pos", new double[]{0.25052338855366485, 0.6339603100813785, 0.5466047048576554});
    model.component("comp1").geom("geom1").feature("sph554").set("r", 0.007910435560512137);
    model.component("comp1").geom("geom1").feature().create("sph555", "Sphere");
    model.component("comp1").geom("geom1").feature("sph555")
         .set("pos", new double[]{0.11767982463620305, 0.7298096923160216, 0.7281508940654905});
    model.component("comp1").geom("geom1").feature("sph555").set("r", 0.012114142172385505);
    model.component("comp1").geom("geom1").feature().create("sph556", "Sphere");
    model.component("comp1").geom("geom1").feature("sph556")
         .set("pos", new double[]{0.12916505036579254, 0.49957920486383445, 0.7221073277290501});
    model.component("comp1").geom("geom1").feature("sph556").set("r", 0.007003700836440884);
    model.component("comp1").geom("geom1").feature().create("sph559", "Sphere");
    model.component("comp1").geom("geom1").feature("sph559")
         .set("pos", new double[]{0.17424970645238624, 0.4665374739669917, 0.7021576343494595});
    model.component("comp1").geom("geom1").feature("sph559").set("r", 0.008366282733752478);
    model.component("comp1").geom("geom1").feature().create("sph563", "Sphere");
    model.component("comp1").geom("geom1").feature("sph563")
         .set("pos", new double[]{0.2791104124321552, 0.7006689287191359, 0.34197517816022016});
    model.component("comp1").geom("geom1").feature("sph563").set("r", 0.0037957216461009984);
    model.component("comp1").geom("geom1").feature().create("sph564", "Sphere");
    model.component("comp1").geom("geom1").feature("sph564")
         .set("pos", new double[]{0.47457436072453446, 0.4198181734732375, 0.4990708080224469});
    model.component("comp1").geom("geom1").feature("sph564").set("r", 0.02140257826328379);
    model.component("comp1").geom("geom1").feature().create("sph565", "Sphere");
    model.component("comp1").geom("geom1").feature("sph565")
         .set("pos", new double[]{0.486528636807182, 0.4928232289894198, 0.31060679464934543});
    model.component("comp1").geom("geom1").feature("sph565").set("r", 0.014484548781314712);
    model.component("comp1").geom("geom1").feature().create("sph568", "Sphere");
    model.component("comp1").geom("geom1").feature("sph568")
         .set("pos", new double[]{0.25649119830334843, 0.5252813919326886, 0.46228972557493897});
    model.component("comp1").geom("geom1").feature("sph568").set("r", 0.00605447772322034);
    model.component("comp1").geom("geom1").feature().create("sph569", "Sphere");
    model.component("comp1").geom("geom1").feature("sph569")
         .set("pos", new double[]{0.5435212054011492, 0.706549471862584, 0.475471259594172});
    model.component("comp1").geom("geom1").feature("sph569").set("r", 0.012288426406881683);
    model.component("comp1").geom("geom1").feature().create("sph571", "Sphere");
    model.component("comp1").geom("geom1").feature("sph571")
         .set("pos", new double[]{0.41897145568966865, 0.6940640775315904, 0.2737459540294498});
    model.component("comp1").geom("geom1").feature("sph571").set("r", 0.016675945747612525);
    model.component("comp1").geom("geom1").feature().create("sph574", "Sphere");
    model.component("comp1").geom("geom1").feature("sph574")
         .set("pos", new double[]{0.5457996844348786, 0.5083817445515402, 0.5765723223541095});
    model.component("comp1").geom("geom1").feature("sph574").set("r", 0.009512610281398179);
    model.component("comp1").geom("geom1").feature().create("sph579", "Sphere");
    model.component("comp1").geom("geom1").feature("sph579")
         .set("pos", new double[]{0.36390308211731925, 0.3619748061439214, 0.597285906413535});
    model.component("comp1").geom("geom1").feature("sph579").set("r", 0.01361760908820799);
    model.component("comp1").geom("geom1").feature().create("sph580", "Sphere");
    model.component("comp1").geom("geom1").feature("sph580")
         .set("pos", new double[]{0.6402429075351701, 0.6630933399587389, 0.5017179624115528});
    model.component("comp1").geom("geom1").feature("sph580").set("r", 0.004594130091112707);
    model.component("comp1").geom("geom1").feature().create("sph582", "Sphere");
    model.component("comp1").geom("geom1").feature("sph582")
         .set("pos", new double[]{0.37528665349440743, 0.35758833226723724, 0.40590805764392734});
    model.component("comp1").geom("geom1").feature("sph582").set("r", 0.008325147216115724);
    model.component("comp1").geom("geom1").feature().create("sph583", "Sphere");
    model.component("comp1").geom("geom1").feature("sph583")
         .set("pos", new double[]{0.6385412089935834, 0.5201706574420016, 0.6028761189379485});
    model.component("comp1").geom("geom1").feature("sph583").set("r", 0.006375991705236647);
    model.component("comp1").geom("geom1").feature().create("sph584", "Sphere");
    model.component("comp1").geom("geom1").feature("sph584")
         .set("pos", new double[]{0.3025052635400019, 0.689101928991633, 0.28833504348647937});
    model.component("comp1").geom("geom1").feature("sph584").set("r", 0.004259748009396844);
    model.component("comp1").geom("geom1").feature().create("sph585", "Sphere");
    model.component("comp1").geom("geom1").feature("sph585")
         .set("pos", new double[]{0.4425233077433668, 0.5460569035216242, 0.6592001057642444});
    model.component("comp1").geom("geom1").feature("sph585").set("r", 0.005806114251811103);
    model.component("comp1").geom("geom1").feature().create("sph587", "Sphere");
    model.component("comp1").geom("geom1").feature("sph587")
         .set("pos", new double[]{0.14013648411952637, 0.3538296498630859, 0.47537076607443035});
    model.component("comp1").geom("geom1").feature("sph587").set("r", 0.0020207755669887414);
    model.component("comp1").geom("geom1").feature().create("sph591", "Sphere");
    model.component("comp1").geom("geom1").feature("sph591")
         .set("pos", new double[]{0.6327464480117428, 0.3564963288145203, 0.41365756057838604});
    model.component("comp1").geom("geom1").feature("sph591").set("r", 0.015227555678809635);
    model.component("comp1").geom("geom1").feature().create("sph593", "Sphere");
    model.component("comp1").geom("geom1").feature("sph593")
         .set("pos", new double[]{0.273256008353798, 0.42250234609210985, 0.7181712675605633});
    model.component("comp1").geom("geom1").feature("sph593").set("r", 0.02242089572368093);
    model.component("comp1").geom("geom1").feature().create("sph603", "Sphere");
    model.component("comp1").geom("geom1").feature("sph603")
         .set("pos", new double[]{0.32432238304566047, 0.2701580258574733, 0.3637975144692513});
    model.component("comp1").geom("geom1").feature("sph603").set("r", 0.002696633433585856);
    model.component("comp1").geom("geom1").feature().create("sph604", "Sphere");
    model.component("comp1").geom("geom1").feature("sph604")
         .set("pos", new double[]{0.22201673434279792, 0.4068444786411511, 0.3776694427098553});
    model.component("comp1").geom("geom1").feature("sph604").set("r", 0.006436256163432811);
    model.component("comp1").geom("geom1").feature().create("sph606", "Sphere");
    model.component("comp1").geom("geom1").feature("sph606")
         .set("pos", new double[]{0.15090562741086294, 0.46639925473202654, 0.2524899620167433});
    model.component("comp1").geom("geom1").feature("sph606").set("r", 0.01956617794532893);
    model.component("comp1").geom("geom1").feature().create("sph609", "Sphere");
    model.component("comp1").geom("geom1").feature("sph609")
         .set("pos", new double[]{0.1623973018904903, 0.56349608651554, 0.26339413212102786});
    model.component("comp1").geom("geom1").feature("sph609").set("r", 0.011413792181399526);
    model.component("comp1").geom("geom1").feature().create("sph611", "Sphere");
    model.component("comp1").geom("geom1").feature("sph611")
         .set("pos", new double[]{0.48701667670629883, 0.5142015352447693, 0.5267720341889565});
    model.component("comp1").geom("geom1").feature("sph611").set("r", 0.019344078423720497);
    model.component("comp1").geom("geom1").feature().create("sph612", "Sphere");
    model.component("comp1").geom("geom1").feature("sph612")
         .set("pos", new double[]{0.4294353666403257, 0.42709630061598386, 0.6752561532427791});
    model.component("comp1").geom("geom1").feature("sph612").set("r", 0.004099226579705897);
    model.component("comp1").geom("geom1").feature().create("sph614", "Sphere");
    model.component("comp1").geom("geom1").feature("sph614")
         .set("pos", new double[]{0.1499457473664064, 0.611214679741057, 0.44219364852799126});
    model.component("comp1").geom("geom1").feature("sph614").set("r", 0.007840083340751348);
    model.component("comp1").geom("geom1").feature().create("sph616", "Sphere");
    model.component("comp1").geom("geom1").feature("sph616")
         .set("pos", new double[]{0.12515853440185262, 0.4253962659284121, 0.7377575945631186});
    model.component("comp1").geom("geom1").feature("sph616").set("r", 0.016348961713277384);
    model.component("comp1").geom("geom1").feature().create("sph619", "Sphere");
    model.component("comp1").geom("geom1").feature("sph619")
         .set("pos", new double[]{0.32242947775479913, 0.5136781964811371, 0.2577051521478788});
    model.component("comp1").geom("geom1").feature("sph619").set("r", 0.0042734568931688);
    model.component("comp1").geom("geom1").feature().create("sph621", "Sphere");
    model.component("comp1").geom("geom1").feature("sph621")
         .set("pos", new double[]{0.5009758329627229, 0.6916056551560311, 0.4263828920589351});
    model.component("comp1").geom("geom1").feature("sph621").set("r", 0.014729359882407382);
    model.component("comp1").geom("geom1").feature().create("sph623", "Sphere");
    model.component("comp1").geom("geom1").feature("sph623")
         .set("pos", new double[]{0.464994809529014, 0.4707494129007551, 0.5869498939084086});
    model.component("comp1").geom("geom1").feature("sph623").set("r", 0.010680894259954058);
    model.component("comp1").geom("geom1").feature().create("sph624", "Sphere");
    model.component("comp1").geom("geom1").feature("sph624")
         .set("pos", new double[]{0.21687438817560928, 0.5661846366722623, 0.6663423826039073});
    model.component("comp1").geom("geom1").feature("sph624").set("r", 0.018659612522422916);
    model.component("comp1").geom("geom1").feature().create("sph625", "Sphere");
    model.component("comp1").geom("geom1").feature("sph625")
         .set("pos", new double[]{0.5131704749299575, 0.551674263243113, 0.7242200588607073});
    model.component("comp1").geom("geom1").feature("sph625").set("r", 0.00741804561161442);
    model.component("comp1").geom("geom1").feature().create("sph630", "Sphere");
    model.component("comp1").geom("geom1").feature("sph630")
         .set("pos", new double[]{0.5909217755754026, 0.670214818205825, 0.4658517080431814});
    model.component("comp1").geom("geom1").feature("sph630").set("r", 0.006389550095775542);
    model.component("comp1").geom("geom1").feature().create("sph632", "Sphere");
    model.component("comp1").geom("geom1").feature("sph632")
         .set("pos", new double[]{0.20717052946363615, 0.5365463331845359, 0.5661894772134808});
    model.component("comp1").geom("geom1").feature("sph632").set("r", 0.003253457577469741);
    model.component("comp1").geom("geom1").feature().create("sph633", "Sphere");
    model.component("comp1").geom("geom1").feature("sph633")
         .set("pos", new double[]{0.5669244767811326, 0.7461803503593789, 0.6192594218332518});
    model.component("comp1").geom("geom1").feature("sph633").set("r", 0.015362903829484513);
    model.component("comp1").geom("geom1").feature().create("sph635", "Sphere");
    model.component("comp1").geom("geom1").feature("sph635")
         .set("pos", new double[]{0.2069000222419259, 0.7343919759319952, 0.40652061910259724});
    model.component("comp1").geom("geom1").feature("sph635").set("r", 0.013921769111428981);
    model.component("comp1").geom("geom1").feature().create("sph642", "Sphere");
    model.component("comp1").geom("geom1").feature("sph642")
         .set("pos", new double[]{0.35094687852855583, 0.736308159306715, 0.7180498196055319});
    model.component("comp1").geom("geom1").feature("sph642").set("r", 0.011338857958253675);
    model.component("comp1").geom("geom1").feature().create("sph644", "Sphere");
    model.component("comp1").geom("geom1").feature("sph644")
         .set("pos", new double[]{0.30278826519757607, 0.6084118677400705, 0.4478052873519099});
    model.component("comp1").geom("geom1").feature("sph644").set("r", 0.005769927702524604);
    model.component("comp1").geom("geom1").feature().create("sph647", "Sphere");
    model.component("comp1").geom("geom1").feature("sph647")
         .set("pos", new double[]{0.1658756152150025, 0.49408076210048213, 0.29398309109222776});
    model.component("comp1").geom("geom1").feature("sph647").set("r", 0.011451061888856048);
    model.component("comp1").geom("geom1").feature().create("sph652", "Sphere");
    model.component("comp1").geom("geom1").feature("sph652")
         .set("pos", new double[]{0.6190882454503089, 0.6366703103202138, 0.5137820566352727});
    model.component("comp1").geom("geom1").feature("sph652").set("r", 0.012605162006977219);
    model.component("comp1").geom("geom1").feature().create("sph654", "Sphere");
    model.component("comp1").geom("geom1").feature("sph654")
         .set("pos", new double[]{0.5703110837127189, 0.45934315671640336, 0.2564871222367418});
    model.component("comp1").geom("geom1").feature("sph654").set("r", 0.012462798272409115);
    model.component("comp1").geom("geom1").feature().create("sph655", "Sphere");
    model.component("comp1").geom("geom1").feature("sph655")
         .set("pos", new double[]{0.6317763144314217, 0.6478287160984568, 0.5432379436886972});
    model.component("comp1").geom("geom1").feature("sph655").set("r", 0.0160641624500788);
    model.component("comp1").geom("geom1").feature().create("sph661", "Sphere");
    model.component("comp1").geom("geom1").feature("sph661")
         .set("pos", new double[]{0.39683653679725356, 0.3886519607660599, 0.6057716326490701});
    model.component("comp1").geom("geom1").feature("sph661").set("r", 0.00899661554447799);
    model.component("comp1").geom("geom1").feature().create("sph663", "Sphere");
    model.component("comp1").geom("geom1").feature("sph663")
         .set("pos", new double[]{0.6461408797303211, 0.3510410502380152, 0.3942466091443733});
    model.component("comp1").geom("geom1").feature("sph663").set("r", 0.0022478885606309427);
    model.component("comp1").geom("geom1").feature().create("sph664", "Sphere");
    model.component("comp1").geom("geom1").feature("sph664")
         .set("pos", new double[]{0.6046393369604288, 0.560970023639582, 0.48681598589642});
    model.component("comp1").geom("geom1").feature("sph664").set("r", 0.006793522326648493);
    model.component("comp1").geom("geom1").feature().create("sph665", "Sphere");
    model.component("comp1").geom("geom1").feature("sph665")
         .set("pos", new double[]{0.28023048895741803, 0.5416843520701461, 0.4454324799787826});
    model.component("comp1").geom("geom1").feature("sph665").set("r", 0.014825968733329118);
    model.component("comp1").geom("geom1").feature().create("sph669", "Sphere");
    model.component("comp1").geom("geom1").feature("sph669")
         .set("pos", new double[]{0.4172914182335476, 0.5824061915400929, 0.5719935918265463});
    model.component("comp1").geom("geom1").feature("sph669").set("r", 0.01094356446339377);
    model.component("comp1").geom("geom1").feature().create("sph672", "Sphere");
    model.component("comp1").geom("geom1").feature("sph672")
         .set("pos", new double[]{0.3402383200130712, 0.522126108895886, 0.4685223648470063});
    model.component("comp1").geom("geom1").feature("sph672").set("r", 0.01011983698029271);
    model.component("comp1").geom("geom1").feature().create("sph674", "Sphere");
    model.component("comp1").geom("geom1").feature("sph674")
         .set("pos", new double[]{0.517940526975246, 0.2845520419076387, 0.32210661907637844});
    model.component("comp1").geom("geom1").feature("sph674").set("r", 0.016010773215086017);
    model.component("comp1").geom("geom1").feature().create("sph678", "Sphere");
    model.component("comp1").geom("geom1").feature("sph678")
         .set("pos", new double[]{0.18731258816517327, 0.3624654054407997, 0.5309522869505219});
    model.component("comp1").geom("geom1").feature("sph678").set("r", 0.0036835378660745022);
    model.component("comp1").geom("geom1").feature().create("sph680", "Sphere");
    model.component("comp1").geom("geom1").feature("sph680")
         .set("pos", new double[]{0.5344089075280245, 0.47076359937393353, 0.6163470004017426});
    model.component("comp1").geom("geom1").feature("sph680").set("r", 0.012421547624560174);
    model.component("comp1").geom("geom1").feature().create("sph681", "Sphere");
    model.component("comp1").geom("geom1").feature("sph681")
         .set("pos", new double[]{0.3922093597213334, 0.6515358414103172, 0.33118447737616535});
    model.component("comp1").geom("geom1").feature("sph681").set("r", 0.005829066031510356);
    model.component("comp1").geom("geom1").feature().create("sph682", "Sphere");
    model.component("comp1").geom("geom1").feature("sph682")
         .set("pos", new double[]{0.4322244905156178, 0.3344506056470224, 0.6155002281012438});
    model.component("comp1").geom("geom1").feature("sph682").set("r", 0.012693209880046234);
    model.component("comp1").geom("geom1").feature().create("sph683", "Sphere");
    model.component("comp1").geom("geom1").feature("sph683")
         .set("pos", new double[]{0.617120670956172, 0.4690662304602944, 0.40542031298295517});
    model.component("comp1").geom("geom1").feature("sph683").set("r", 0.003816913699315301);
    model.component("comp1").geom("geom1").feature().create("sph684", "Sphere");
    model.component("comp1").geom("geom1").feature("sph684")
         .set("pos", new double[]{0.3385599335972682, 0.5649669229470307, 0.2929245051592164});
    model.component("comp1").geom("geom1").feature("sph684").set("r", 0.0046865611647407285);
    model.component("comp1").geom("geom1").feature().create("sph685", "Sphere");
    model.component("comp1").geom("geom1").feature("sph685")
         .set("pos", new double[]{0.5537316573462326, 0.5579841279261921, 0.34446778545826906});
    model.component("comp1").geom("geom1").feature("sph685").set("r", 0.009044189188858218);
    model.component("comp1").geom("geom1").feature().create("sph686", "Sphere");
    model.component("comp1").geom("geom1").feature("sph686")
         .set("pos", new double[]{0.5928548865691933, 0.3821881432100671, 0.3320095072835314});
    model.component("comp1").geom("geom1").feature("sph686").set("r", 0.005700925303241051);
    model.component("comp1").geom("geom1").feature().create("sph689", "Sphere");
    model.component("comp1").geom("geom1").feature("sph689")
         .set("pos", new double[]{0.5940118112220676, 0.4598721023946111, 0.31867157449156647});
    model.component("comp1").geom("geom1").feature("sph689").set("r", 0.004138509430853643);
    model.component("comp1").geom("geom1").feature().create("sph692", "Sphere");
    model.component("comp1").geom("geom1").feature("sph692")
         .set("pos", new double[]{0.5784482656523714, 0.32104749851571923, 0.3791612700926972});
    model.component("comp1").geom("geom1").feature("sph692").set("r", 0.007109218200507904);
    model.component("comp1").geom("geom1").feature().create("sph697", "Sphere");
    model.component("comp1").geom("geom1").feature("sph697")
         .set("pos", new double[]{0.51242160582357, 0.5806534856468499, 0.674750146847682});
    model.component("comp1").geom("geom1").feature("sph697").set("r", 0.004143886903042913);
    model.component("comp1").geom("geom1").feature().create("sph698", "Sphere");
    model.component("comp1").geom("geom1").feature("sph698")
         .set("pos", new double[]{0.2698400521461154, 0.5827692206142573, 0.25995854619288683});
    model.component("comp1").geom("geom1").feature("sph698").set("r", 0.004394114439069742);
    model.component("comp1").geom("geom1").feature().create("sph699", "Sphere");
    model.component("comp1").geom("geom1").feature("sph699")
         .set("pos", new double[]{0.5583682692069228, 0.4617878767480477, 0.4525653764336792});
    model.component("comp1").geom("geom1").feature("sph699").set("r", 0.01888374058780124);
    model.component("comp1").geom("geom1").feature().create("sph702", "Sphere");
    model.component("comp1").geom("geom1").feature("sph702")
         .set("pos", new double[]{0.19018565997174547, 0.6940909559468788, 0.7424765537926694});
    model.component("comp1").geom("geom1").feature("sph702").set("r", 0.008844463619277142);
    model.component("comp1").geom("geom1").feature().create("sph703", "Sphere");
    model.component("comp1").geom("geom1").feature("sph703")
         .set("pos", new double[]{0.4830091608889157, 0.40503073098593706, 0.2977281506939449});
    model.component("comp1").geom("geom1").feature("sph703").set("r", 0.009530462293211696);
    model.component("comp1").geom("geom1").feature().create("sph704", "Sphere");
    model.component("comp1").geom("geom1").feature("sph704")
         .set("pos", new double[]{0.40222564674017386, 0.30598826736096335, 0.6483819268331443});
    model.component("comp1").geom("geom1").feature("sph704").set("r", 0.01103192305829345);
    model.component("comp1").geom("geom1").feature().create("sph708", "Sphere");
    model.component("comp1").geom("geom1").feature("sph708")
         .set("pos", new double[]{0.1719877307555552, 0.7109948658155731, 0.7499704019328387});
    model.component("comp1").geom("geom1").feature("sph708").set("r", 0.0065510596474516024);
    model.component("comp1").geom("geom1").feature().create("sph713", "Sphere");
    model.component("comp1").geom("geom1").feature("sph713")
         .set("pos", new double[]{0.3147224268913499, 0.4590493779656893, 0.6130919356106302});
    model.component("comp1").geom("geom1").feature("sph713").set("r", 0.004480542668995807);
    model.component("comp1").geom("geom1").feature().create("sph718", "Sphere");
    model.component("comp1").geom("geom1").feature("sph718")
         .set("pos", new double[]{0.29170835483199836, 0.6391010157319411, 0.2667632283693315});
    model.component("comp1").geom("geom1").feature("sph718").set("r", 0.009626849350344004);
    model.component("comp1").geom("geom1").feature().create("sph719", "Sphere");
    model.component("comp1").geom("geom1").feature("sph719")
         .set("pos", new double[]{0.41756826495619714, 0.43458571336174895, 0.5511952342894602});
    model.component("comp1").geom("geom1").feature("sph719").set("r", 0.003697100611792529);
    model.component("comp1").geom("geom1").feature().create("sph720", "Sphere");
    model.component("comp1").geom("geom1").feature("sph720")
         .set("pos", new double[]{0.5936117974495678, 0.6177115343627895, 0.28072493477739013});
    model.component("comp1").geom("geom1").feature("sph720").set("r", 0.008128609352125806);
    model.component("comp1").geom("geom1").feature().create("sph721", "Sphere");
    model.component("comp1").geom("geom1").feature("sph721")
         .set("pos", new double[]{0.6144589983726538, 0.71701665250509, 0.6042779721285587});
    model.component("comp1").geom("geom1").feature("sph721").set("r", 0.020029825977555787);
    model.component("comp1").geom("geom1").feature().create("sph722", "Sphere");
    model.component("comp1").geom("geom1").feature("sph722")
         .set("pos", new double[]{0.416105393948913, 0.38087557397644034, 0.7328329926375939});
    model.component("comp1").geom("geom1").feature("sph722").set("r", 0.004842656330067958);
    model.component("comp1").geom("geom1").feature().create("sph724", "Sphere");
    model.component("comp1").geom("geom1").feature("sph724")
         .set("pos", new double[]{0.6054743984763774, 0.4034266769064866, 0.2687626264735049});
    model.component("comp1").geom("geom1").feature("sph724").set("r", 0.010572945283064954);
    model.component("comp1").geom("geom1").feature().create("sph726", "Sphere");
    model.component("comp1").geom("geom1").feature("sph726")
         .set("pos", new double[]{0.5976937596654519, 0.42102574221249117, 0.47189354985824333});
    model.component("comp1").geom("geom1").feature("sph726").set("r", 0.004442642955240166);
    model.component("comp1").geom("geom1").feature().create("sph729", "Sphere");
    model.component("comp1").geom("geom1").feature("sph729")
         .set("pos", new double[]{0.2041540661801478, 0.6218657993756029, 0.730880185551156});
    model.component("comp1").geom("geom1").feature("sph729").set("r", 0.016198471038980932);
    model.component("comp1").geom("geom1").feature().create("sph731", "Sphere");
    model.component("comp1").geom("geom1").feature("sph731")
         .set("pos", new double[]{0.4095342121599118, 0.3968352064153479, 0.32008142139196344});
    model.component("comp1").geom("geom1").feature("sph731").set("r", 0.007902550182697672);
    model.component("comp1").geom("geom1").feature().create("sph732", "Sphere");
    model.component("comp1").geom("geom1").feature("sph732")
         .set("pos", new double[]{0.3724228586207091, 0.744076910156174, 0.26919467605944614});
    model.component("comp1").geom("geom1").feature("sph732").set("r", 0.012223355637241974);
    model.component("comp1").geom("geom1").feature().create("sph733", "Sphere");
    model.component("comp1").geom("geom1").feature("sph733")
         .set("pos", new double[]{0.5622592050164423, 0.5649111841171661, 0.6529322148196054});
    model.component("comp1").geom("geom1").feature("sph733").set("r", 0.00892656957463736);
    model.component("comp1").geom("geom1").feature().create("sph738", "Sphere");
    model.component("comp1").geom("geom1").feature("sph738")
         .set("pos", new double[]{0.12272934450170327, 0.5673808763519331, 0.6753146257632503});
    model.component("comp1").geom("geom1").feature("sph738").set("r", 0.004259478247024701);
    model.component("comp1").geom("geom1").feature().create("sph740", "Sphere");
    model.component("comp1").geom("geom1").feature("sph740")
         .set("pos", new double[]{0.3792934633948546, 0.5386536006919848, 0.2672114783370908});
    model.component("comp1").geom("geom1").feature("sph740").set("r", 0.022736954718854528);
    model.component("comp1").geom("geom1").feature().create("sph741", "Sphere");
    model.component("comp1").geom("geom1").feature("sph741")
         .set("pos", new double[]{0.1350852545982804, 0.6959804909762967, 0.31139669313660656});
    model.component("comp1").geom("geom1").feature("sph741").set("r", 0.0049529679334014455);
    model.component("comp1").geom("geom1").feature().create("sph742", "Sphere");
    model.component("comp1").geom("geom1").feature("sph742")
         .set("pos", new double[]{0.29948724718769765, 0.6388623103000899, 0.4192058172010114});
    model.component("comp1").geom("geom1").feature("sph742").set("r", 0.021542475012001357);
    model.component("comp1").geom("geom1").feature().create("sph743", "Sphere");
    model.component("comp1").geom("geom1").feature("sph743")
         .set("pos", new double[]{0.1581421879188427, 0.3792161318190127, 0.47065924483693994});
    model.component("comp1").geom("geom1").feature("sph743").set("r", 0.008156732912936159);
    model.component("comp1").geom("geom1").feature().create("sph744", "Sphere");
    model.component("comp1").geom("geom1").feature("sph744")
         .set("pos", new double[]{0.35085885964916874, 0.7335333565599463, 0.5052585425224146});
    model.component("comp1").geom("geom1").feature("sph744").set("r", 0.020802702374626295);
    model.component("comp1").geom("geom1").feature().create("sph745", "Sphere");
    model.component("comp1").geom("geom1").feature("sph745")
         .set("pos", new double[]{0.32888766184040585, 0.5799736281010318, 0.3574677991594165});
    model.component("comp1").geom("geom1").feature("sph745").set("r", 0.002573749485663199);
    model.component("comp1").geom("geom1").feature().create("sph748", "Sphere");
    model.component("comp1").geom("geom1").feature("sph748")
         .set("pos", new double[]{0.26627317312270865, 0.7165929198542467, 0.5074981253760262});
    model.component("comp1").geom("geom1").feature("sph748").set("r", 0.022232675479522464);
    model.component("comp1").geom("geom1").feature().create("sph749", "Sphere");
    model.component("comp1").geom("geom1").feature("sph749")
         .set("pos", new double[]{0.5415280760649632, 0.5843830460622641, 0.4427083036491968});
    model.component("comp1").geom("geom1").feature("sph749").set("r", 0.009443115319574591);
    model.component("comp1").geom("geom1").feature().create("sph750", "Sphere");
    model.component("comp1").geom("geom1").feature("sph750")
         .set("pos", new double[]{0.5190385275914421, 0.6664705007031567, 0.6473773724488803});
    model.component("comp1").geom("geom1").feature("sph750").set("r", 0.016481220962251644);
    model.component("comp1").geom("geom1").feature().create("sph758", "Sphere");
    model.component("comp1").geom("geom1").feature("sph758")
         .set("pos", new double[]{0.18710456038532047, 0.5350976532964864, 0.3403669357578209});
    model.component("comp1").geom("geom1").feature("sph758").set("r", 0.007055501150698853);
    model.component("comp1").geom("geom1").feature().create("sph759", "Sphere");
    model.component("comp1").geom("geom1").feature("sph759")
         .set("pos", new double[]{0.26754968598092976, 0.5739303410866079, 0.5233644101762913});
    model.component("comp1").geom("geom1").feature("sph759").set("r", 0.0033764652576695644);
    model.component("comp1").geom("geom1").feature().create("sph760", "Sphere");
    model.component("comp1").geom("geom1").feature("sph760")
         .set("pos", new double[]{0.5520061358839851, 0.3771292826472709, 0.3697489531254577});
    model.component("comp1").geom("geom1").feature("sph760").set("r", 0.009606674206376623);
    model.component("comp1").geom("geom1").feature().create("sph761", "Sphere");
    model.component("comp1").geom("geom1").feature("sph761")
         .set("pos", new double[]{0.36366685177474056, 0.45821979462585677, 0.32105812057907773});
    model.component("comp1").geom("geom1").feature("sph761").set("r", 0.014878790448160529);
    model.component("comp1").geom("geom1").feature().create("sph765", "Sphere");
    model.component("comp1").geom("geom1").feature("sph765")
         .set("pos", new double[]{0.5483610826877366, 0.3961504000752961, 0.6297127954916293});
    model.component("comp1").geom("geom1").feature("sph765").set("r", 0.018933998433945137);
    model.component("comp1").geom("geom1").feature().create("sph767", "Sphere");
    model.component("comp1").geom("geom1").feature("sph767")
         .set("pos", new double[]{0.1581896812194834, 0.5097135488179885, 0.4622870382997679});
    model.component("comp1").geom("geom1").feature("sph767").set("r", 0.011395709711645398);
    model.component("comp1").geom("geom1").feature().create("sph768", "Sphere");
    model.component("comp1").geom("geom1").feature("sph768")
         .set("pos", new double[]{0.5845326323996911, 0.4277348266932941, 0.26771419736777163});
    model.component("comp1").geom("geom1").feature("sph768").set("r", 0.007816237405636275);
    model.component("comp1").geom("geom1").feature().create("sph770", "Sphere");
    model.component("comp1").geom("geom1").feature("sph770")
         .set("pos", new double[]{0.5569914095989954, 0.3638389510003341, 0.40818400714248676});
    model.component("comp1").geom("geom1").feature("sph770").set("r", 0.006599231475882258);

    return model;
  }

  public static Model run6(Model model) {
    model.component("comp1").geom("geom1").feature().create("sph777", "Sphere");
    model.component("comp1").geom("geom1").feature("sph777")
         .set("pos", new double[]{0.25242150509268874, 0.5907259887180502, 0.3600668728547787});
    model.component("comp1").geom("geom1").feature("sph777").set("r", 0.005720047476524949);
    model.component("comp1").geom("geom1").feature().create("sph779", "Sphere");
    model.component("comp1").geom("geom1").feature("sph779")
         .set("pos", new double[]{0.5436921983918723, 0.3759655905435033, 0.7029918090726882});
    model.component("comp1").geom("geom1").feature("sph779").set("r", 0.01569868592731285);
    model.component("comp1").geom("geom1").feature().create("sph781", "Sphere");
    model.component("comp1").geom("geom1").feature("sph781")
         .set("pos", new double[]{0.28620147798236945, 0.4642124096470946, 0.2717786839758466});
    model.component("comp1").geom("geom1").feature("sph781").set("r", 0.006654563013527546);
    model.component("comp1").geom("geom1").feature().create("sph782", "Sphere");
    model.component("comp1").geom("geom1").feature("sph782")
         .set("pos", new double[]{0.19386131039656765, 0.42599989862901405, 0.6105296754796895});
    model.component("comp1").geom("geom1").feature("sph782").set("r", 0.005444857413575421);
    model.component("comp1").geom("geom1").feature().create("sph789", "Sphere");
    model.component("comp1").geom("geom1").feature("sph789")
         .set("pos", new double[]{0.4373572582050163, 0.7297834851179681, 0.5581247574128235});
    model.component("comp1").geom("geom1").feature("sph789").set("r", 0.018232949728642013);
    model.component("comp1").geom("geom1").feature().create("sph790", "Sphere");
    model.component("comp1").geom("geom1").feature("sph790")
         .set("pos", new double[]{0.19222737726644457, 0.29227554056712995, 0.33741495587927506});
    model.component("comp1").geom("geom1").feature("sph790").set("r", 0.00525022314530617);
    model.component("comp1").geom("geom1").feature().create("sph793", "Sphere");
    model.component("comp1").geom("geom1").feature("sph793")
         .set("pos", new double[]{0.3623788860787091, 0.32903721618489234, 0.4662358161905377});
    model.component("comp1").geom("geom1").feature("sph793").set("r", 0.006003897754234311);
    model.component("comp1").geom("geom1").feature().create("sph795", "Sphere");
    model.component("comp1").geom("geom1").feature("sph795")
         .set("pos", new double[]{0.23611298410559514, 0.6036539823164911, 0.5945795534159652});
    model.component("comp1").geom("geom1").feature("sph795").set("r", 0.008340302542157368);
    model.component("comp1").geom("geom1").feature().create("sph799", "Sphere");
    model.component("comp1").geom("geom1").feature("sph799")
         .set("pos", new double[]{0.41517382316351226, 0.5354550715266123, 0.6742800118844059});
    model.component("comp1").geom("geom1").feature("sph799").set("r", 0.016584094860621054);
    model.component("comp1").geom("geom1").feature().create("sph803", "Sphere");
    model.component("comp1").geom("geom1").feature("sph803")
         .set("pos", new double[]{0.33113473725259446, 0.5057401200010829, 0.49547358586706963});
    model.component("comp1").geom("geom1").feature("sph803").set("r", 0.011942430359577977);
    model.component("comp1").geom("geom1").feature().create("sph804", "Sphere");
    model.component("comp1").geom("geom1").feature("sph804")
         .set("pos", new double[]{0.5140083096782124, 0.2804894083964042, 0.2660864892332874});
    model.component("comp1").geom("geom1").feature("sph804").set("r", 0.01045771375656054);
    model.component("comp1").geom("geom1").feature().create("sph809", "Sphere");
    model.component("comp1").geom("geom1").feature("sph809")
         .set("pos", new double[]{0.4016681312048592, 0.6458291860627691, 0.2680124390132837});
    model.component("comp1").geom("geom1").feature("sph809").set("r", 0.015634199705626274);
    model.component("comp1").geom("geom1").feature().create("sph810", "Sphere");
    model.component("comp1").geom("geom1").feature("sph810")
         .set("pos", new double[]{0.6299542063427661, 0.6539553685391484, 0.6105425063675219});
    model.component("comp1").geom("geom1").feature("sph810").set("r", 0.002318233776978421);
    model.component("comp1").geom("geom1").feature().create("sph811", "Sphere");
    model.component("comp1").geom("geom1").feature("sph811")
         .set("pos", new double[]{0.3623933101928445, 0.714108454078502, 0.7120230001013461});
    model.component("comp1").geom("geom1").feature("sph811").set("r", 0.005581117713331934);
    model.component("comp1").geom("geom1").feature().create("sph812", "Sphere");
    model.component("comp1").geom("geom1").feature("sph812")
         .set("pos", new double[]{0.5127529078241193, 0.25281873019442974, 0.7409254824743415});
    model.component("comp1").geom("geom1").feature("sph812").set("r", 0.0022126834605291626);
    model.component("comp1").geom("geom1").feature().create("sph813", "Sphere");
    model.component("comp1").geom("geom1").feature("sph813")
         .set("pos", new double[]{0.6244589194431922, 0.42049841975357516, 0.3850944264169576});
    model.component("comp1").geom("geom1").feature("sph813").set("r", 0.011590245645901064);
    model.component("comp1").geom("geom1").feature().create("sph814", "Sphere");
    model.component("comp1").geom("geom1").feature("sph814")
         .set("pos", new double[]{0.4975945213745482, 0.3413566445573065, 0.673319907098511});
    model.component("comp1").geom("geom1").feature("sph814").set("r", 0.009274715168195911);
    model.component("comp1").geom("geom1").feature().create("sph815", "Sphere");
    model.component("comp1").geom("geom1").feature("sph815")
         .set("pos", new double[]{0.618805655631752, 0.7425298559901288, 0.33463925335458855});
    model.component("comp1").geom("geom1").feature("sph815").set("r", 0.015583171953415074);
    model.component("comp1").geom("geom1").feature().create("sph819", "Sphere");
    model.component("comp1").geom("geom1").feature("sph819")
         .set("pos", new double[]{0.4965119484589885, 0.6055383837021197, 0.2507850909343401});
    model.component("comp1").geom("geom1").feature("sph819").set("r", 0.01691351515156205);
    model.component("comp1").geom("geom1").feature().create("sph826", "Sphere");
    model.component("comp1").geom("geom1").feature("sph826")
         .set("pos", new double[]{0.47285412406363037, 0.6216474412204331, 0.3981288441892058});
    model.component("comp1").geom("geom1").feature("sph826").set("r", 0.006803012370025891);
    model.component("comp1").geom("geom1").feature().create("sph829", "Sphere");
    model.component("comp1").geom("geom1").feature("sph829")
         .set("pos", new double[]{0.11129569083304396, 0.3591407668008832, 0.43751093130637475});
    model.component("comp1").geom("geom1").feature("sph829").set("r", 0.005814634034544268);
    model.component("comp1").geom("geom1").feature().create("sph834", "Sphere");
    model.component("comp1").geom("geom1").feature("sph834")
         .set("pos", new double[]{0.30717618238806166, 0.2933326781273014, 0.7308123578779692});
    model.component("comp1").geom("geom1").feature("sph834").set("r", 0.021149535909910228);
    model.component("comp1").geom("geom1").feature().create("sph838", "Sphere");
    model.component("comp1").geom("geom1").feature("sph838")
         .set("pos", new double[]{0.1576733351861954, 0.4459385787074237, 0.602159608642188});
    model.component("comp1").geom("geom1").feature("sph838").set("r", 0.0026770104524113077);
    model.component("comp1").geom("geom1").feature().create("sph840", "Sphere");
    model.component("comp1").geom("geom1").feature("sph840")
         .set("pos", new double[]{0.40842238744285503, 0.7499600643573539, 0.6005937957157726});
    model.component("comp1").geom("geom1").feature("sph840").set("r", 0.007200244943230612);
    model.component("comp1").geom("geom1").feature().create("sph846", "Sphere");
    model.component("comp1").geom("geom1").feature("sph846")
         .set("pos", new double[]{0.16223096021019656, 0.47057975902552196, 0.671171714603885});
    model.component("comp1").geom("geom1").feature("sph846").set("r", 0.01748500531781339);
    model.component("comp1").geom("geom1").feature().create("sph847", "Sphere");
    model.component("comp1").geom("geom1").feature("sph847")
         .set("pos", new double[]{0.6038188878623594, 0.3705136168048225, 0.2937538719666499});
    model.component("comp1").geom("geom1").feature("sph847").set("r", 0.015969390899712773);
    model.component("comp1").geom("geom1").feature().create("sph848", "Sphere");
    model.component("comp1").geom("geom1").feature("sph848")
         .set("pos", new double[]{0.1634367978743867, 0.6289803293148569, 0.36796565391255975});
    model.component("comp1").geom("geom1").feature("sph848").set("r", 0.01641210901888939);
    model.component("comp1").geom("geom1").feature().create("sph849", "Sphere");
    model.component("comp1").geom("geom1").feature("sph849")
         .set("pos", new double[]{0.5372951358842782, 0.6321316278198089, 0.48267420547851486});
    model.component("comp1").geom("geom1").feature("sph849").set("r", 0.014391292744204101);
    model.component("comp1").geom("geom1").feature().create("sph851", "Sphere");
    model.component("comp1").geom("geom1").feature("sph851")
         .set("pos", new double[]{0.34281185830822103, 0.44503998284316637, 0.25926509089880656});
    model.component("comp1").geom("geom1").feature("sph851").set("r", 0.01910378264917721);
    model.component("comp1").geom("geom1").feature().create("sph852", "Sphere");
    model.component("comp1").geom("geom1").feature("sph852")
         .set("pos", new double[]{0.5667083757451151, 0.6404239786022453, 0.6100831375160195});
    model.component("comp1").geom("geom1").feature("sph852").set("r", 0.009021397689684133);
    model.component("comp1").geom("geom1").feature().create("sph853", "Sphere");
    model.component("comp1").geom("geom1").feature("sph853")
         .set("pos", new double[]{0.1172399368879968, 0.3937271817609739, 0.47211412250880347});
    model.component("comp1").geom("geom1").feature("sph853").set("r", 0.002531952893541558);
    model.component("comp1").geom("geom1").feature().create("sph856", "Sphere");
    model.component("comp1").geom("geom1").feature("sph856")
         .set("pos", new double[]{0.39880808296394477, 0.5843676981212043, 0.7241415325241265});
    model.component("comp1").geom("geom1").feature("sph856").set("r", 0.004890282242217225);
    model.component("comp1").geom("geom1").feature().create("sph857", "Sphere");
    model.component("comp1").geom("geom1").feature("sph857")
         .set("pos", new double[]{0.2938424741240355, 0.4924763979966658, 0.5779229081049192});
    model.component("comp1").geom("geom1").feature("sph857").set("r", 0.010545291394499015);
    model.component("comp1").geom("geom1").feature().create("sph860", "Sphere");
    model.component("comp1").geom("geom1").feature("sph860")
         .set("pos", new double[]{0.2656595588469534, 0.33552950176533247, 0.3886546323903196});
    model.component("comp1").geom("geom1").feature("sph860").set("r", 0.01736755585451035);
    model.component("comp1").geom("geom1").feature().create("sph862", "Sphere");
    model.component("comp1").geom("geom1").feature("sph862")
         .set("pos", new double[]{0.514638718766524, 0.35345034613206494, 0.5334617084889319});
    model.component("comp1").geom("geom1").feature("sph862").set("r", 0.002063732002390685);
    model.component("comp1").geom("geom1").feature().create("sph863", "Sphere");
    model.component("comp1").geom("geom1").feature("sph863")
         .set("pos", new double[]{0.5572497852047402, 0.3356871760575016, 0.25215456083420634});
    model.component("comp1").geom("geom1").feature("sph863").set("r", 0.002577519378074292);
    model.component("comp1").geom("geom1").feature().create("sph864", "Sphere");
    model.component("comp1").geom("geom1").feature("sph864")
         .set("pos", new double[]{0.5987602695717998, 0.3707179363527646, 0.4863687329703669});
    model.component("comp1").geom("geom1").feature("sph864").set("r", 0.008927319592404788);
    model.component("comp1").geom("geom1").feature().create("sph865", "Sphere");
    model.component("comp1").geom("geom1").feature("sph865")
         .set("pos", new double[]{0.26651433580459105, 0.7085037710202295, 0.6326447281573441});
    model.component("comp1").geom("geom1").feature("sph865").set("r", 0.0113662864202272);
    model.component("comp1").geom("geom1").feature().create("sph867", "Sphere");
    model.component("comp1").geom("geom1").feature("sph867")
         .set("pos", new double[]{0.37173386569328115, 0.35869018286197407, 0.7064222267036374});
    model.component("comp1").geom("geom1").feature("sph867").set("r", 0.01269935966084578);
    model.component("comp1").geom("geom1").feature().create("sph870", "Sphere");
    model.component("comp1").geom("geom1").feature("sph870")
         .set("pos", new double[]{0.5647343594406744, 0.6287603585643518, 0.7145504760510788});
    model.component("comp1").geom("geom1").feature("sph870").set("r", 0.005048212482278358);
    model.component("comp1").geom("geom1").feature().create("sph872", "Sphere");
    model.component("comp1").geom("geom1").feature("sph872")
         .set("pos", new double[]{0.4928365428138672, 0.6528431387806368, 0.5581160503163177});
    model.component("comp1").geom("geom1").feature("sph872").set("r", 0.006671004921883515);
    model.component("comp1").geom("geom1").feature().create("sph873", "Sphere");
    model.component("comp1").geom("geom1").feature("sph873")
         .set("pos", new double[]{0.12637216198446188, 0.5246388996976209, 0.46635623907726126});
    model.component("comp1").geom("geom1").feature("sph873").set("r", 0.006280132820109348);
    model.component("comp1").geom("geom1").feature().create("sph878", "Sphere");
    model.component("comp1").geom("geom1").feature("sph878")
         .set("pos", new double[]{0.18657267231456226, 0.5776544550004976, 0.44391775056194377});
    model.component("comp1").geom("geom1").feature("sph878").set("r", 0.0022808419522587038);
    model.component("comp1").geom("geom1").feature().create("sph879", "Sphere");
    model.component("comp1").geom("geom1").feature("sph879")
         .set("pos", new double[]{0.3389125376061711, 0.5925022304249942, 0.5174971283556639});
    model.component("comp1").geom("geom1").feature("sph879").set("r", 0.021227185096866545);
    model.component("comp1").geom("geom1").feature().create("sph880", "Sphere");
    model.component("comp1").geom("geom1").feature("sph880")
         .set("pos", new double[]{0.49279923501140316, 0.5890486781638087, 0.30264132069669597});
    model.component("comp1").geom("geom1").feature("sph880").set("r", 0.004757782048558325);
    model.component("comp1").geom("geom1").feature().create("sph885", "Sphere");
    model.component("comp1").geom("geom1").feature("sph885")
         .set("pos", new double[]{0.20422009205214908, 0.6356083440712876, 0.31444012765199303});
    model.component("comp1").geom("geom1").feature("sph885").set("r", 0.01494954824444882);
    model.component("comp1").geom("geom1").feature().create("sph886", "Sphere");
    model.component("comp1").geom("geom1").feature("sph886")
         .set("pos", new double[]{0.534259709458917, 0.42120473466518576, 0.3942723362947405});
    model.component("comp1").geom("geom1").feature("sph886").set("r", 0.005100351578630478);
    model.component("comp1").geom("geom1").feature().create("sph887", "Sphere");
    model.component("comp1").geom("geom1").feature("sph887")
         .set("pos", new double[]{0.2816784376558427, 0.4075433227464172, 0.5838468107600943});
    model.component("comp1").geom("geom1").feature("sph887").set("r", 0.008409457180135436);
    model.component("comp1").geom("geom1").feature().create("sph888", "Sphere");
    model.component("comp1").geom("geom1").feature("sph888")
         .set("pos", new double[]{0.28155874633223, 0.6258225639087585, 0.7005337356684848});
    model.component("comp1").geom("geom1").feature("sph888").set("r", 0.007526030626479267);
    model.component("comp1").geom("geom1").feature().create("sph890", "Sphere");
    model.component("comp1").geom("geom1").feature("sph890")
         .set("pos", new double[]{0.5493497711381851, 0.6289501537742888, 0.5220809986395731});
    model.component("comp1").geom("geom1").feature("sph890").set("r", 0.009223212031159791);
    model.component("comp1").geom("geom1").feature().create("sph893", "Sphere");
    model.component("comp1").geom("geom1").feature("sph893")
         .set("pos", new double[]{0.1619813977067798, 0.6515596033576271, 0.5680526515703713});
    model.component("comp1").geom("geom1").feature("sph893").set("r", 0.009080502437855974);
    model.component("comp1").geom("geom1").feature().create("sph894", "Sphere");
    model.component("comp1").geom("geom1").feature("sph894")
         .set("pos", new double[]{0.1897328727466725, 0.42510901838639936, 0.6802443590395967});
    model.component("comp1").geom("geom1").feature("sph894").set("r", 0.016122014979456603);
    model.component("comp1").geom("geom1").feature().create("sph898", "Sphere");
    model.component("comp1").geom("geom1").feature("sph898")
         .set("pos", new double[]{0.28765509249789467, 0.4402319358689515, 0.30285979352499065});
    model.component("comp1").geom("geom1").feature("sph898").set("r", 0.007528093939649421);
    model.component("comp1").geom("geom1").feature().create("sph899", "Sphere");
    model.component("comp1").geom("geom1").feature("sph899")
         .set("pos", new double[]{0.6126865339549603, 0.4577476750169303, 0.36830489480368156});
    model.component("comp1").geom("geom1").feature("sph899").set("r", 0.024151152925233968);
    model.component("comp1").geom("geom1").feature().create("sph904", "Sphere");
    model.component("comp1").geom("geom1").feature("sph904")
         .set("pos", new double[]{0.62792095265525, 0.49401392803210387, 0.27382071625253757});
    model.component("comp1").geom("geom1").feature("sph904").set("r", 0.0024368387357281305);
    model.component("comp1").geom("geom1").feature().create("sph906", "Sphere");
    model.component("comp1").geom("geom1").feature("sph906")
         .set("pos", new double[]{0.16279404901711578, 0.2757916894912117, 0.6006421676226594});
    model.component("comp1").geom("geom1").feature("sph906").set("r", 0.006551874867029456);
    model.component("comp1").geom("geom1").feature().create("sph907", "Sphere");
    model.component("comp1").geom("geom1").feature("sph907")
         .set("pos", new double[]{0.12130082703879477, 0.35149507604691876, 0.5881689273516936});
    model.component("comp1").geom("geom1").feature("sph907").set("r", 0.01707123868842366);
    model.component("comp1").geom("geom1").feature().create("sph908", "Sphere");
    model.component("comp1").geom("geom1").feature("sph908")
         .set("pos", new double[]{0.41636878881866135, 0.3476209953416845, 0.4598064568492785});
    model.component("comp1").geom("geom1").feature("sph908").set("r", 0.005499239658190904);
    model.component("comp1").geom("geom1").feature().create("sph910", "Sphere");
    model.component("comp1").geom("geom1").feature("sph910")
         .set("pos", new double[]{0.2995231377046858, 0.6608620915632833, 0.7344565500567447});
    model.component("comp1").geom("geom1").feature("sph910").set("r", 0.0042115708489342315);
    model.component("comp1").geom("geom1").feature().create("sph913", "Sphere");
    model.component("comp1").geom("geom1").feature("sph913")
         .set("pos", new double[]{0.36387616799370925, 0.7185966183485573, 0.6922080138592015});
    model.component("comp1").geom("geom1").feature("sph913").set("r", 0.009875351008823531);
    model.component("comp1").geom("geom1").feature().create("sph914", "Sphere");
    model.component("comp1").geom("geom1").feature("sph914")
         .set("pos", new double[]{0.16210172365310146, 0.4381638360029687, 0.5024104630366603});
    model.component("comp1").geom("geom1").feature("sph914").set("r", 0.011729735607418055);
    model.component("comp1").geom("geom1").feature().create("sph920", "Sphere");
    model.component("comp1").geom("geom1").feature("sph920")
         .set("pos", new double[]{0.30796293683456083, 0.28863974569448614, 0.2899098021841574});
    model.component("comp1").geom("geom1").feature("sph920").set("r", 0.0046514672029714325);
    model.component("comp1").geom("geom1").feature().create("sph921", "Sphere");
    model.component("comp1").geom("geom1").feature("sph921")
         .set("pos", new double[]{0.227405065568426, 0.5479617792590346, 0.7096557294131094});
    model.component("comp1").geom("geom1").feature("sph921").set("r", 0.015038071625062537);
    model.component("comp1").geom("geom1").feature().create("sph922", "Sphere");
    model.component("comp1").geom("geom1").feature("sph922")
         .set("pos", new double[]{0.24717712310141043, 0.2907204086609351, 0.7214151933312013});
    model.component("comp1").geom("geom1").feature("sph922").set("r", 0.02094929082317197);
    model.component("comp1").geom("geom1").feature().create("sph924", "Sphere");
    model.component("comp1").geom("geom1").feature("sph924")
         .set("pos", new double[]{0.33487471381012696, 0.640160984406215, 0.5230797422604232});
    model.component("comp1").geom("geom1").feature("sph924").set("r", 0.01833415823388667);
    model.component("comp1").geom("geom1").feature().create("sph925", "Sphere");
    model.component("comp1").geom("geom1").feature("sph925")
         .set("pos", new double[]{0.2852099976933382, 0.6431630437259069, 0.579566918653042});
    model.component("comp1").geom("geom1").feature("sph925").set("r", 0.0029840276108325757);
    model.component("comp1").geom("geom1").feature().create("sph930", "Sphere");
    model.component("comp1").geom("geom1").feature("sph930")
         .set("pos", new double[]{0.24078967520531905, 0.35428597225635716, 0.4121309076139832});
    model.component("comp1").geom("geom1").feature("sph930").set("r", 0.007070467983378224);
    model.component("comp1").geom("geom1").feature().create("sph931", "Sphere");
    model.component("comp1").geom("geom1").feature("sph931")
         .set("pos", new double[]{0.4998569461517597, 0.40852698664085085, 0.3056893565088487});
    model.component("comp1").geom("geom1").feature("sph931").set("r", 0.005332150416609399);
    model.component("comp1").geom("geom1").feature().create("sph933", "Sphere");
    model.component("comp1").geom("geom1").feature("sph933")
         .set("pos", new double[]{0.47691735151483367, 0.5555914926741864, 0.25235234680243956});
    model.component("comp1").geom("geom1").feature("sph933").set("r", 0.011659880677130264);
    model.component("comp1").geom("geom1").feature().create("sph935", "Sphere");
    model.component("comp1").geom("geom1").feature("sph935")
         .set("pos", new double[]{0.12140923361395281, 0.6473411038634984, 0.3354659724062374});
    model.component("comp1").geom("geom1").feature("sph935").set("r", 0.011057129597563147);
    model.component("comp1").geom("geom1").feature().create("sph943", "Sphere");
    model.component("comp1").geom("geom1").feature("sph943")
         .set("pos", new double[]{0.34169090886368125, 0.3453279527147637, 0.5109021718128961});
    model.component("comp1").geom("geom1").feature("sph943").set("r", 0.014325423829134428);
    model.component("comp1").geom("geom1").feature().create("sph951", "Sphere");
    model.component("comp1").geom("geom1").feature("sph951")
         .set("pos", new double[]{0.13915810490749375, 0.38713762181021144, 0.2714712084793319});
    model.component("comp1").geom("geom1").feature("sph951").set("r", 0.003036606029981519);
    model.component("comp1").geom("geom1").feature().create("sph956", "Sphere");
    model.component("comp1").geom("geom1").feature("sph956")
         .set("pos", new double[]{0.2129397641774462, 0.44547225569486654, 0.5617278358408839});
    model.component("comp1").geom("geom1").feature("sph956").set("r", 0.011359019891520467);
    model.component("comp1").geom("geom1").feature().create("sph958", "Sphere");
    model.component("comp1").geom("geom1").feature("sph958")
         .set("pos", new double[]{0.36259387695800005, 0.32074581024964344, 0.525536393370895});
    model.component("comp1").geom("geom1").feature("sph958").set("r", 0.004427642738002547);
    model.component("comp1").geom("geom1").feature().create("sph961", "Sphere");
    model.component("comp1").geom("geom1").feature("sph961")
         .set("pos", new double[]{0.4058193402035127, 0.3578047446012456, 0.3044600788383249});
    model.component("comp1").geom("geom1").feature("sph961").set("r", 0.003317670886647731);
    model.component("comp1").geom("geom1").feature().create("sph963", "Sphere");
    model.component("comp1").geom("geom1").feature("sph963")
         .set("pos", new double[]{0.3708505222939823, 0.27393362032374946, 0.25003272719705105});
    model.component("comp1").geom("geom1").feature("sph963").set("r", 0.006905486092896346);
    model.component("comp1").geom("geom1").feature().create("sph967", "Sphere");
    model.component("comp1").geom("geom1").feature("sph967")
         .set("pos", new double[]{0.4198449660380781, 0.6835407181608295, 0.34985604870422776});
    model.component("comp1").geom("geom1").feature("sph967").set("r", 0.005628286608156711);
    model.component("comp1").geom("geom1").feature().create("sph969", "Sphere");
    model.component("comp1").geom("geom1").feature("sph969")
         .set("pos", new double[]{0.444936317947988, 0.4352208293566027, 0.5466780357041153});
    model.component("comp1").geom("geom1").feature("sph969").set("r", 0.00962610549631889);
    model.component("comp1").geom("geom1").feature().create("sph971", "Sphere");
    model.component("comp1").geom("geom1").feature("sph971")
         .set("pos", new double[]{0.43330391291721587, 0.4600072610663901, 0.26249367470462076});
    model.component("comp1").geom("geom1").feature("sph971").set("r", 0.01606507678778639);
    model.component("comp1").geom("geom1").feature().create("sph975", "Sphere");
    model.component("comp1").geom("geom1").feature("sph975")
         .set("pos", new double[]{0.17213897644369858, 0.41087372009498074, 0.402679242025012});
    model.component("comp1").geom("geom1").feature("sph975").set("r", 0.005245958099437195);
    model.component("comp1").geom("geom1").feature().create("sph976", "Sphere");
    model.component("comp1").geom("geom1").feature("sph976")
         .set("pos", new double[]{0.4285824663359708, 0.3958689989840448, 0.6218464875116508});
    model.component("comp1").geom("geom1").feature("sph976").set("r", 0.00956362437766238);
    model.component("comp1").geom("geom1").feature().create("sph978", "Sphere");
    model.component("comp1").geom("geom1").feature("sph978")
         .set("pos", new double[]{0.34228528494481836, 0.3926659841563999, 0.550678070760351});
    model.component("comp1").geom("geom1").feature("sph978").set("r", 0.004748859222442274);
    model.component("comp1").geom("geom1").feature().create("sph980", "Sphere");
    model.component("comp1").geom("geom1").feature("sph980")
         .set("pos", new double[]{0.21532919659091426, 0.3194231385946876, 0.2569426848273573});
    model.component("comp1").geom("geom1").feature("sph980").set("r", 0.01919121185427375);
    model.component("comp1").geom("geom1").feature().create("sph983", "Sphere");
    model.component("comp1").geom("geom1").feature("sph983")
         .set("pos", new double[]{0.5484161877281086, 0.42511631155375, 0.26270845933806647});
    model.component("comp1").geom("geom1").feature("sph983").set("r", 0.013483218199797352);
    model.component("comp1").geom("geom1").feature().create("sph984", "Sphere");
    model.component("comp1").geom("geom1").feature("sph984")
         .set("pos", new double[]{0.1565466309950098, 0.3987421266390107, 0.7414169694254165});
    model.component("comp1").geom("geom1").feature("sph984").set("r", 0.011801502325600594);
    model.component("comp1").geom("geom1").feature().create("sph988", "Sphere");
    model.component("comp1").geom("geom1").feature("sph988")
         .set("pos", new double[]{0.48325116859151473, 0.5070342701973798, 0.3962524864196152});
    model.component("comp1").geom("geom1").feature("sph988").set("r", 0.013252796685616975);
    model.component("comp1").geom("geom1").feature().create("sph989", "Sphere");
    model.component("comp1").geom("geom1").feature("sph989")
         .set("pos", new double[]{0.3968845537058908, 0.3147816543694539, 0.7152450468839374});
    model.component("comp1").geom("geom1").feature("sph989").set("r", 0.0055084836781070685);
    model.component("comp1").geom("geom1").feature().create("sph991", "Sphere");
    model.component("comp1").geom("geom1").feature("sph991")
         .set("pos", new double[]{0.3531959058550646, 0.31041656744922647, 0.2668452417427693});
    model.component("comp1").geom("geom1").feature("sph991").set("r", 0.01974783016940246);
    model.component("comp1").geom("geom1").feature().create("sph996", "Sphere");
    model.component("comp1").geom("geom1").feature("sph996")
         .set("pos", new double[]{0.12864703636782693, 0.2769950499126863, 0.42461275668696324});
    model.component("comp1").geom("geom1").feature("sph996").set("r", 0.013755370993871247);
    model.component("comp1").geom("geom1").feature().create("sph997", "Sphere");
    model.component("comp1").geom("geom1").feature("sph997")
         .set("pos", new double[]{0.31279189280903213, 0.3609511012263547, 0.3358379716065576});
    model.component("comp1").geom("geom1").feature("sph997").set("r", 0.003420918603900445);
    model.component("comp1").geom("geom1").feature().create("sph1008", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1008")
         .set("pos", new double[]{0.14901279841165282, 0.547542466821909, 0.48746046531889714});
    model.component("comp1").geom("geom1").feature("sph1008").set("r", 0.006933653758738244);
    model.component("comp1").geom("geom1").feature().create("sph1009", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1009")
         .set("pos", new double[]{0.13690399268340064, 0.25854724923141087, 0.6058616715262348});
    model.component("comp1").geom("geom1").feature("sph1009").set("r", 0.007401513447315461);
    model.component("comp1").geom("geom1").feature().create("sph1010", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1010")
         .set("pos", new double[]{0.24960819999821376, 0.25637991051251147, 0.31868655723995415});
    model.component("comp1").geom("geom1").feature("sph1010").set("r", 0.006329823350568909);
    model.component("comp1").geom("geom1").feature().create("sph1012", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1012")
         .set("pos", new double[]{0.5714858116913499, 0.4488232992138109, 0.3731645788044448});
    model.component("comp1").geom("geom1").feature("sph1012").set("r", 0.00782501354917182);
    model.component("comp1").geom("geom1").feature().create("sph1020", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1020")
         .set("pos", new double[]{0.34719815110413965, 0.4709515258855839, 0.2551243701463333});
    model.component("comp1").geom("geom1").feature("sph1020").set("r", 0.0066282736843436925);
    model.component("comp1").geom("geom1").feature().create("sph1027", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1027")
         .set("pos", new double[]{0.518386223196202, 0.3301952924960017, 0.3195720548594975});
    model.component("comp1").geom("geom1").feature("sph1027").set("r", 0.013396839306977158);
    model.component("comp1").geom("geom1").feature().create("sph1031", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1031")
         .set("pos", new double[]{0.49004071320504267, 0.7177222111293611, 0.30885376409207316});
    model.component("comp1").geom("geom1").feature("sph1031").set("r", 0.0031895062338379966);
    model.component("comp1").geom("geom1").feature().create("sph1035", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1035")
         .set("pos", new double[]{0.12993246322659874, 0.6687560807054544, 0.5204799022125495});
    model.component("comp1").geom("geom1").feature("sph1035").set("r", 0.022157607051504324);
    model.component("comp1").geom("geom1").feature().create("sph1039", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1039")
         .set("pos", new double[]{0.2660545807945372, 0.5431391396304162, 0.37557337292513665});
    model.component("comp1").geom("geom1").feature("sph1039").set("r", 0.008038340536797589);
    model.component("comp1").geom("geom1").feature().create("sph1040", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1040")
         .set("pos", new double[]{0.287171959014563, 0.48980112999344555, 0.3551689145551787});

    return model;
  }

  public static Model run7(Model model) {
    model.component("comp1").geom("geom1").feature("sph1040").set("r", 0.013491287885221638);
    model.component("comp1").geom("geom1").feature().create("sph1044", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1044")
         .set("pos", new double[]{0.25905521230277395, 0.7112448343694393, 0.5952682302740957});
    model.component("comp1").geom("geom1").feature("sph1044").set("r", 0.006395327614148844);
    model.component("comp1").geom("geom1").feature().create("sph1047", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1047")
         .set("pos", new double[]{0.5616458959004706, 0.6232424418173301, 0.3174404200232276});
    model.component("comp1").geom("geom1").feature("sph1047").set("r", 0.011167942205305384);
    model.component("comp1").geom("geom1").feature().create("sph1051", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1051")
         .set("pos", new double[]{0.6188722237798816, 0.45591895118445175, 0.6452083611361561});
    model.component("comp1").geom("geom1").feature("sph1051").set("r", 0.020521629874932237);
    model.component("comp1").geom("geom1").feature().create("sph1053", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1053")
         .set("pos", new double[]{0.19380088073140184, 0.7024803130725252, 0.39993612272865037});
    model.component("comp1").geom("geom1").feature("sph1053").set("r", 0.007881555496782607);
    model.component("comp1").geom("geom1").feature().create("sph1060", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1060")
         .set("pos", new double[]{0.40396486630841216, 0.5259805032752396, 0.6394119244189025});
    model.component("comp1").geom("geom1").feature("sph1060").set("r", 0.009965535951974433);
    model.component("comp1").geom("geom1").feature().create("sph1066", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1066")
         .set("pos", new double[]{0.28818738015741624, 0.7338412264424973, 0.27613759737442917});
    model.component("comp1").geom("geom1").feature("sph1066").set("r", 0.022801633355686378);
    model.component("comp1").geom("geom1").feature().create("sph1067", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1067")
         .set("pos", new double[]{0.3725280138980125, 0.35568759815978984, 0.502035334579621});
    model.component("comp1").geom("geom1").feature("sph1067").set("r", 0.01617726194893985);
    model.component("comp1").geom("geom1").feature().create("sph1068", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1068")
         .set("pos", new double[]{0.4041649658909824, 0.6680609664253492, 0.3142369472201018});
    model.component("comp1").geom("geom1").feature("sph1068").set("r", 0.0035169571731020564);
    model.component("comp1").geom("geom1").feature().create("sph1070", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1070")
         .set("pos", new double[]{0.36580757091207283, 0.42310614464421437, 0.31574416615614354});
    model.component("comp1").geom("geom1").feature("sph1070").set("r", 0.009784370657680466);
    model.component("comp1").geom("geom1").feature().create("sph1075", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1075")
         .set("pos", new double[]{0.12151161443263828, 0.6108426107285904, 0.7403319825634416});
    model.component("comp1").geom("geom1").feature("sph1075").set("r", 0.005042178774841137);
    model.component("comp1").geom("geom1").feature().create("sph1077", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1077")
         .set("pos", new double[]{0.11280369040345359, 0.6616263717029566, 0.4692413390419509});
    model.component("comp1").geom("geom1").feature("sph1077").set("r", 0.010760333389852331);
    model.component("comp1").geom("geom1").feature().create("sph1080", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1080")
         .set("pos", new double[]{0.34618501572618554, 0.39858569136763616, 0.6334677286195151});
    model.component("comp1").geom("geom1").feature("sph1080").set("r", 0.003878439096920196);
    model.component("comp1").geom("geom1").feature().create("sph1087", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1087")
         .set("pos", new double[]{0.13293564739642658, 0.45170014682061144, 0.441992739698739});
    model.component("comp1").geom("geom1").feature("sph1087").set("r", 0.010434287211014534);
    model.component("comp1").geom("geom1").feature().create("sph1090", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1090")
         .set("pos", new double[]{0.4210357636842175, 0.4409107820269816, 0.6082446922023412});
    model.component("comp1").geom("geom1").feature("sph1090").set("r", 0.006241223922192922);
    model.component("comp1").geom("geom1").feature().create("sph1092", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1092")
         .set("pos", new double[]{0.4377992995447342, 0.41856486791307546, 0.2562052008532056});
    model.component("comp1").geom("geom1").feature("sph1092").set("r", 0.002982996839478532);
    model.component("comp1").geom("geom1").feature().create("sph1096", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1096")
         .set("pos", new double[]{0.2138816746351643, 0.519422124295395, 0.5019368904523405});
    model.component("comp1").geom("geom1").feature("sph1096").set("r", 0.009366767289138028);
    model.component("comp1").geom("geom1").feature().create("sph1097", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1097")
         .set("pos", new double[]{0.5337084254354156, 0.602005780257768, 0.5794472819649497});
    model.component("comp1").geom("geom1").feature("sph1097").set("r", 0.010965203233638239);
    model.component("comp1").geom("geom1").feature().create("sph1101", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1101")
         .set("pos", new double[]{0.422854988695938, 0.5059317953377157, 0.2571012554846405});
    model.component("comp1").geom("geom1").feature("sph1101").set("r", 0.002316056640643196);
    model.component("comp1").geom("geom1").feature().create("sph1102", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1102")
         .set("pos", new double[]{0.5570765730192184, 0.46146369393769093, 0.3066171267749854});
    model.component("comp1").geom("geom1").feature("sph1102").set("r", 0.0043705812655112485);
    model.component("comp1").geom("geom1").feature().create("sph1103", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1103")
         .set("pos", new double[]{0.43503765185366383, 0.4018783079255573, 0.26162875596293605});
    model.component("comp1").geom("geom1").feature("sph1103").set("r", 0.005586171135698157);
    model.component("comp1").geom("geom1").feature().create("sph1106", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1106")
         .set("pos", new double[]{0.1858865521306065, 0.6103073766611286, 0.47863009999736017});
    model.component("comp1").geom("geom1").feature("sph1106").set("r", 0.012281358086646717);
    model.component("comp1").geom("geom1").feature().create("sph1109", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1109")
         .set("pos", new double[]{0.22831934452272112, 0.7024746609958492, 0.5659856577846237});
    model.component("comp1").geom("geom1").feature("sph1109").set("r", 0.018770194938331944);
    model.component("comp1").geom("geom1").feature().create("sph1115", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1115")
         .set("pos", new double[]{0.47142164083290583, 0.3149817562063406, 0.4647337849545963});
    model.component("comp1").geom("geom1").feature("sph1115").set("r", 0.0029345829193491027);
    model.component("comp1").geom("geom1").feature().create("sph1117", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1117")
         .set("pos", new double[]{0.462865340493041, 0.33933608435995916, 0.6025383560884001});
    model.component("comp1").geom("geom1").feature("sph1117").set("r", 0.012903280084914518);
    model.component("comp1").geom("geom1").feature().create("sph1121", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1121")
         .set("pos", new double[]{0.4405001311976558, 0.543457208339061, 0.604778356595337});
    model.component("comp1").geom("geom1").feature("sph1121").set("r", 0.0140200218782906);
    model.component("comp1").geom("geom1").feature().create("sph1123", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1123")
         .set("pos", new double[]{0.6020993771797722, 0.6299710051899244, 0.44579678963448477});
    model.component("comp1").geom("geom1").feature("sph1123").set("r", 0.005912231280277784);
    model.component("comp1").geom("geom1").feature().create("sph1126", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1126")
         .set("pos", new double[]{0.34333776633534185, 0.49488081502150416, 0.2515861721829537});
    model.component("comp1").geom("geom1").feature("sph1126").set("r", 0.010869256817044972);
    model.component("comp1").geom("geom1").feature().create("sph1127", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1127")
         .set("pos", new double[]{0.5614221839053144, 0.6177106947348795, 0.2850109105432484});
    model.component("comp1").geom("geom1").feature("sph1127").set("r", 0.006486265004248573);
    model.component("comp1").geom("geom1").feature().create("sph1133", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1133")
         .set("pos", new double[]{0.23545893111572758, 0.3045712374835045, 0.5116736020823042});
    model.component("comp1").geom("geom1").feature("sph1133").set("r", 0.003934342394802236);
    model.component("comp1").geom("geom1").feature().create("sph1134", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1134")
         .set("pos", new double[]{0.2812811087628566, 0.6477232764008849, 0.5203469921061769});
    model.component("comp1").geom("geom1").feature("sph1134").set("r", 0.00630713010398685);
    model.component("comp1").geom("geom1").feature().create("sph1139", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1139")
         .set("pos", new double[]{0.32682619506208127, 0.634824664227283, 0.2573713611839485});
    model.component("comp1").geom("geom1").feature("sph1139").set("r", 0.009443075377693552);
    model.component("comp1").geom("geom1").feature().create("sph1141", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1141")
         .set("pos", new double[]{0.5615143130967828, 0.51298127473887, 0.528292829825222});
    model.component("comp1").geom("geom1").feature("sph1141").set("r", 0.0029318849313280226);
    model.component("comp1").geom("geom1").feature().create("sph1143", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1143")
         .set("pos", new double[]{0.41686544186915975, 0.6002778900290506, 0.27403331130235964});
    model.component("comp1").geom("geom1").feature("sph1143").set("r", 0.012783319031486122);
    model.component("comp1").geom("geom1").feature().create("sph1145", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1145")
         .set("pos", new double[]{0.26124955523209603, 0.6042323002592291, 0.545327883227206});
    model.component("comp1").geom("geom1").feature("sph1145").set("r", 0.004575535556051853);
    model.component("comp1").geom("geom1").feature().create("sph1149", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1149")
         .set("pos", new double[]{0.5544956152673122, 0.4608841788681111, 0.411256297183845});
    model.component("comp1").geom("geom1").feature("sph1149").set("r", 0.00963533508477328);
    model.component("comp1").geom("geom1").feature().create("sph1150", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1150")
         .set("pos", new double[]{0.3255305195746642, 0.40227591319730654, 0.37229369724566896});
    model.component("comp1").geom("geom1").feature("sph1150").set("r", 0.015519777524694859);
    model.component("comp1").geom("geom1").feature().create("sph1151", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1151")
         .set("pos", new double[]{0.6004844959736165, 0.7268101470061784, 0.2949100492294098});
    model.component("comp1").geom("geom1").feature("sph1151").set("r", 0.009200045860289687);
    model.component("comp1").geom("geom1").feature().create("sph1153", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1153")
         .set("pos", new double[]{0.5062764685708822, 0.4825914681967159, 0.2608056724141163});
    model.component("comp1").geom("geom1").feature("sph1153").set("r", 0.008289440059207101);
    model.component("comp1").geom("geom1").feature().create("sph1155", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1155")
         .set("pos", new double[]{0.35776558072143116, 0.3621635801777864, 0.6744296769840611});
    model.component("comp1").geom("geom1").feature("sph1155").set("r", 0.014128644851239706);
    model.component("comp1").geom("geom1").feature().create("sph1156", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1156")
         .set("pos", new double[]{0.5601347094851142, 0.3535750217640116, 0.2944858707768992});
    model.component("comp1").geom("geom1").feature("sph1156").set("r", 0.020396715032402035);
    model.component("comp1").geom("geom1").feature().create("sph1157", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1157")
         .set("pos", new double[]{0.5873066261700678, 0.7024522602858387, 0.4988016583710456});
    model.component("comp1").geom("geom1").feature("sph1157").set("r", 0.01806423657183271);
    model.component("comp1").geom("geom1").feature().create("sph1158", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1158")
         .set("pos", new double[]{0.17465422706564787, 0.3766680104795496, 0.5033284347864933});
    model.component("comp1").geom("geom1").feature("sph1158").set("r", 0.016768420038233006);
    model.component("comp1").geom("geom1").feature().create("sph1163", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1163")
         .set("pos", new double[]{0.1090872321276635, 0.5863650730338457, 0.3382979080980564});
    model.component("comp1").geom("geom1").feature("sph1163").set("r", 0.00797433389782131);
    model.component("comp1").geom("geom1").feature().create("sph1164", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1164")
         .set("pos", new double[]{0.2602590022263254, 0.31948361546383436, 0.31180580488121756});
    model.component("comp1").geom("geom1").feature("sph1164").set("r", 0.009473977496484754);
    model.component("comp1").geom("geom1").feature().create("sph1165", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1165")
         .set("pos", new double[]{0.6271341508880608, 0.5997473781973869, 0.7156810229078462});
    model.component("comp1").geom("geom1").feature("sph1165").set("r", 0.005333010391079831);
    model.component("comp1").geom("geom1").feature().create("sph1169", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1169")
         .set("pos", new double[]{0.4659239457572381, 0.31319576100919183, 0.4969424528493366});
    model.component("comp1").geom("geom1").feature("sph1169").set("r", 0.010491161714282275);
    model.component("comp1").geom("geom1").feature().create("sph1176", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1176")
         .set("pos", new double[]{0.6114924337629297, 0.39988616144666356, 0.5292845824770346});
    model.component("comp1").geom("geom1").feature("sph1176").set("r", 0.007575349595610659);
    model.component("comp1").geom("geom1").feature().create("sph1177", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1177")
         .set("pos", new double[]{0.36386003200502415, 0.5389795605294796, 0.6228881719350028});
    model.component("comp1").geom("geom1").feature("sph1177").set("r", 0.004978715654582436);
    model.component("comp1").geom("geom1").feature().create("sph1181", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1181")
         .set("pos", new double[]{0.3329938969550639, 0.5566713239636675, 0.46033100890668227});
    model.component("comp1").geom("geom1").feature("sph1181").set("r", 0.005707790262029934);
    model.component("comp1").geom("geom1").feature().create("sph1185", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1185")
         .set("pos", new double[]{0.20243696365029354, 0.2625374985546417, 0.39036875183098163});
    model.component("comp1").geom("geom1").feature("sph1185").set("r", 0.008367039177671086);
    model.component("comp1").geom("geom1").feature().create("sph1188", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1188")
         .set("pos", new double[]{0.376606835400428, 0.478969651365928, 0.39851845855528184});
    model.component("comp1").geom("geom1").feature("sph1188").set("r", 0.008068941566322062);
    model.component("comp1").geom("geom1").feature().create("sph1192", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1192")
         .set("pos", new double[]{0.11503830627956009, 0.29271273115327184, 0.6666488105065665});
    model.component("comp1").geom("geom1").feature("sph1192").set("r", 0.008747485064688174);
    model.component("comp1").geom("geom1").feature().create("sph1199", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1199")
         .set("pos", new double[]{0.23013031592922467, 0.5092879232298015, 0.4407560759340016});
    model.component("comp1").geom("geom1").feature("sph1199").set("r", 0.006076870647657174);
    model.component("comp1").geom("geom1").feature().create("sph1201", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1201")
         .set("pos", new double[]{0.2513547321568397, 0.41030739972738484, 0.6675341205227948});
    model.component("comp1").geom("geom1").feature("sph1201").set("r", 0.0041071185688313205);
    model.component("comp1").geom("geom1").feature().create("sph1204", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1204")
         .set("pos", new double[]{0.366331357534642, 0.39687124077274416, 0.4435339063092916});
    model.component("comp1").geom("geom1").feature("sph1204").set("r", 0.007914687115499176);
    model.component("comp1").geom("geom1").feature().create("sph1205", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1205")
         .set("pos", new double[]{0.11187407691297092, 0.680783325952936, 0.2854487464728005});
    model.component("comp1").geom("geom1").feature("sph1205").set("r", 0.004141866207441688);
    model.component("comp1").geom("geom1").feature().create("sph1208", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1208")
         .set("pos", new double[]{0.6278105643264283, 0.618369699492191, 0.40692719426512025});
    model.component("comp1").geom("geom1").feature("sph1208").set("r", 0.0026865052067098615);
    model.component("comp1").geom("geom1").feature().create("sph1209", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1209")
         .set("pos", new double[]{0.3216549073177377, 0.3959515336260294, 0.42195651559432});
    model.component("comp1").geom("geom1").feature("sph1209").set("r", 0.007399029890322026);
    model.component("comp1").geom("geom1").feature().create("sph1214", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1214")
         .set("pos", new double[]{0.22528207171317632, 0.499246735059815, 0.5548481259289183});
    model.component("comp1").geom("geom1").feature("sph1214").set("r", 0.015751130627367008);
    model.component("comp1").geom("geom1").feature().create("sph1216", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1216")
         .set("pos", new double[]{0.49962674448127364, 0.4843372942401392, 0.5708580575489142});
    model.component("comp1").geom("geom1").feature("sph1216").set("r", 0.007553650169356742);
    model.component("comp1").geom("geom1").feature().create("sph1218", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1218")
         .set("pos", new double[]{0.19231408058484697, 0.6312818351697659, 0.700314767790856});
    model.component("comp1").geom("geom1").feature("sph1218").set("r", 0.01433404601224405);
    model.component("comp1").geom("geom1").feature().create("sph1223", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1223")
         .set("pos", new double[]{0.3023117181543225, 0.5529231958098787, 0.4744088078794796});
    model.component("comp1").geom("geom1").feature("sph1223").set("r", 0.005237593076447753);
    model.component("comp1").geom("geom1").feature().create("sph1241", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1241")
         .set("pos", new double[]{0.22017215804885606, 0.49486579095949, 0.2534720531627857});
    model.component("comp1").geom("geom1").feature("sph1241").set("r", 0.0026799890229027385);
    model.component("comp1").geom("geom1").feature().create("sph1253", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1253")
         .set("pos", new double[]{0.2785119850641524, 0.5305853167856673, 0.6065828152842859});
    model.component("comp1").geom("geom1").feature("sph1253").set("r", 0.00863753961378107);
    model.component("comp1").geom("geom1").feature().create("sph1263", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1263")
         .set("pos", new double[]{0.3215511905721375, 0.5869413648668899, 0.577755496203478});
    model.component("comp1").geom("geom1").feature("sph1263").set("r", 0.01870832435171882);
    model.component("comp1").geom("geom1").feature().create("sph1265", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1265")
         .set("pos", new double[]{0.604489175829069, 0.4931117699795261, 0.4319900681470442});
    model.component("comp1").geom("geom1").feature("sph1265").set("r", 0.009083611468873673);
    model.component("comp1").geom("geom1").feature().create("sph1273", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1273")
         .set("pos", new double[]{0.510266092246105, 0.5188074760629197, 0.5809970185928686});
    model.component("comp1").geom("geom1").feature("sph1273").set("r", 0.002048884080780138);
    model.component("comp1").geom("geom1").feature().create("sph1276", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1276")
         .set("pos", new double[]{0.24228876248210274, 0.6371849705935668, 0.5178303392764795});
    model.component("comp1").geom("geom1").feature("sph1276").set("r", 0.002204841677515023);
    model.component("comp1").geom("geom1").feature().create("sph1284", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1284")
         .set("pos", new double[]{0.5814295365827831, 0.6961826708655843, 0.3070346184721971});
    model.component("comp1").geom("geom1").feature("sph1284").set("r", 0.013105957763354862);
    model.component("comp1").geom("geom1").feature().create("sph1288", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1288")
         .set("pos", new double[]{0.1799909046157949, 0.7409831700743218, 0.3647813160045436});
    model.component("comp1").geom("geom1").feature("sph1288").set("r", 0.009698083068404674);
    model.component("comp1").geom("geom1").feature().create("sph1291", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1291")
         .set("pos", new double[]{0.6359781841333891, 0.3156168813164527, 0.4743577659806795});
    model.component("comp1").geom("geom1").feature("sph1291").set("r", 0.004386147488200317);
    model.component("comp1").geom("geom1").feature().create("sph1297", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1297")
         .set("pos", new double[]{0.3664944840890362, 0.615276354839506, 0.3461361349573149});
    model.component("comp1").geom("geom1").feature("sph1297").set("r", 0.002060371781923846);
    model.component("comp1").geom("geom1").feature().create("sph1302", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1302")
         .set("pos", new double[]{0.13250774914800012, 0.33385131726974365, 0.6487024812606029});
    model.component("comp1").geom("geom1").feature("sph1302").set("r", 0.019910994780663806);
    model.component("comp1").geom("geom1").feature().create("sph1304", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1304")
         .set("pos", new double[]{0.197259891465911, 0.7038090932658063, 0.4638970361405983});
    model.component("comp1").geom("geom1").feature("sph1304").set("r", 0.004884292317364748);
    model.component("comp1").geom("geom1").feature().create("sph1305", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1305")
         .set("pos", new double[]{0.46220174627574434, 0.2563865892770759, 0.5008170406450222});
    model.component("comp1").geom("geom1").feature("sph1305").set("r", 0.01286646704757047);
    model.component("comp1").geom("geom1").feature().create("sph1310", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1310")
         .set("pos", new double[]{0.4157206624594503, 0.6897005793970872, 0.4654572274701783});
    model.component("comp1").geom("geom1").feature("sph1310").set("r", 0.011623359472202511);
    model.component("comp1").geom("geom1").feature().create("sph1311", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1311")
         .set("pos", new double[]{0.33470428998091784, 0.42714638545336786, 0.6018514529895649});
    model.component("comp1").geom("geom1").feature("sph1311").set("r", 0.006129222273451466);
    model.component("comp1").geom("geom1").feature().create("sph1314", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1314")
         .set("pos", new double[]{0.5099616976493608, 0.49518600427433984, 0.6410333976975742});
    model.component("comp1").geom("geom1").feature("sph1314").set("r", 0.006457265612405216);
    model.component("comp1").geom("geom1").feature().create("sph1319", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1319")
         .set("pos", new double[]{0.6136134211140466, 0.6744805091706133, 0.6619925734687624});
    model.component("comp1").geom("geom1").feature("sph1319").set("r", 0.024419125915004905);
    model.component("comp1").geom("geom1").feature().create("sph1321", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1321")
         .set("pos", new double[]{0.5132930660236581, 0.5232999281943531, 0.2990430324107617});
    model.component("comp1").geom("geom1").feature("sph1321").set("r", 0.005925093058321199);
    model.component("comp1").geom("geom1").feature().create("sph1323", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1323")
         .set("pos", new double[]{0.5295324117416245, 0.5894136462304744, 0.5433888593218802});
    model.component("comp1").geom("geom1").feature("sph1323").set("r", 0.016919554888141047);
    model.component("comp1").geom("geom1").feature().create("sph1325", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1325")
         .set("pos", new double[]{0.22055589321368335, 0.5775789283892114, 0.6281821716241729});
    model.component("comp1").geom("geom1").feature("sph1325").set("r", 0.007152791130816164);
    model.component("comp1").geom("geom1").feature().create("sph1328", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1328")
         .set("pos", new double[]{0.5244854629165774, 0.3971116515495573, 0.602923459051026});
    model.component("comp1").geom("geom1").feature("sph1328").set("r", 0.004940721989135507);
    model.component("comp1").geom("geom1").feature().create("sph1330", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1330")
         .set("pos", new double[]{0.6178825308896747, 0.5007135251852969, 0.3598657325234013});
    model.component("comp1").geom("geom1").feature("sph1330").set("r", 0.0057703455370229865);
    model.component("comp1").geom("geom1").feature().create("sph1332", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1332")
         .set("pos", new double[]{0.5755978408788439, 0.5295518482103695, 0.4406409694786606});
    model.component("comp1").geom("geom1").feature("sph1332").set("r", 0.005226653851711378);
    model.component("comp1").geom("geom1").feature().create("sph1335", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1335")
         .set("pos", new double[]{0.37820948485807, 0.3675960330308488, 0.44517423046076804});
    model.component("comp1").geom("geom1").feature("sph1335").set("r", 0.01221585106737872);
    model.component("comp1").geom("geom1").feature().create("sph1340", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1340")
         .set("pos", new double[]{0.16586187383395265, 0.444080550776987, 0.3347036798715859});
    model.component("comp1").geom("geom1").feature("sph1340").set("r", 0.004408969260644846);
    model.component("comp1").geom("geom1").feature().create("sph1348", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1348")
         .set("pos", new double[]{0.3797082101383586, 0.5762824596534203, 0.4241565581439952});
    model.component("comp1").geom("geom1").feature("sph1348").set("r", 0.0034223401387152635);
    model.component("comp1").geom("geom1").feature().create("sph1351", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1351")
         .set("pos", new double[]{0.3479727874582114, 0.5482636999063051, 0.5464576334708894});
    model.component("comp1").geom("geom1").feature("sph1351").set("r", 0.004114414821558327);
    model.component("comp1").geom("geom1").feature().create("sph1356", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1356")
         .set("pos", new double[]{0.5147088706504912, 0.35690079488571363, 0.37160340346365206});
    model.component("comp1").geom("geom1").feature("sph1356").set("r", 0.024193576881085047);
    model.component("comp1").geom("geom1").feature().create("sph1358", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1358")
         .set("pos", new double[]{0.4802671023377263, 0.2522414404067018, 0.7029014584263916});
    model.component("comp1").geom("geom1").feature("sph1358").set("r", 0.020079971097335732);
    model.component("comp1").geom("geom1").feature().create("sph1364", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1364")
         .set("pos", new double[]{0.31953158323330344, 0.6713507235064212, 0.45816246616412926});
    model.component("comp1").geom("geom1").feature("sph1364").set("r", 0.002951919657769758);
    model.component("comp1").geom("geom1").feature().create("sph1365", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1365")
         .set("pos", new double[]{0.35283459444876714, 0.6025615269056716, 0.3960592708804109});
    model.component("comp1").geom("geom1").feature("sph1365").set("r", 0.003946277681342055);
    model.component("comp1").geom("geom1").feature().create("sph1369", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1369")
         .set("pos", new double[]{0.1814991144251919, 0.5814511776606025, 0.5935314932349092});
    model.component("comp1").geom("geom1").feature("sph1369").set("r", 0.0020626949872184592);
    model.component("comp1").geom("geom1").feature().create("sph1378", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1378")
         .set("pos", new double[]{0.581593488843522, 0.3408889493602882, 0.5180777451169455});
    model.component("comp1").geom("geom1").feature("sph1378").set("r", 0.0037955518674970892);
    model.component("comp1").geom("geom1").feature().create("sph1380", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1380")
         .set("pos", new double[]{0.13396016419520798, 0.6695975483765676, 0.7323067056509519});
    model.component("comp1").geom("geom1").feature("sph1380").set("r", 0.008801699809832059);
    model.component("comp1").geom("geom1").feature().create("sph1382", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1382")
         .set("pos", new double[]{0.43274811754695675, 0.5019773502088121, 0.5728288438910071});
    model.component("comp1").geom("geom1").feature("sph1382").set("r", 0.016538790748678797);
    model.component("comp1").geom("geom1").feature().create("sph1390", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1390")
         .set("pos", new double[]{0.30292979174463525, 0.34440143803217765, 0.49393051143295014});
    model.component("comp1").geom("geom1").feature("sph1390").set("r", 0.0034087418603387792);
    model.component("comp1").geom("geom1").feature().create("sph1396", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1396")
         .set("pos", new double[]{0.13665200853643084, 0.7040384583646532, 0.3655366887199885});

    return model;
  }

  public static Model run8(Model model) {
    model.component("comp1").geom("geom1").feature("sph1396").set("r", 0.002115854310791001);
    model.component("comp1").geom("geom1").feature().create("sph1401", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1401")
         .set("pos", new double[]{0.45653023311852364, 0.5306792251306184, 0.5349857395060811});
    model.component("comp1").geom("geom1").feature("sph1401").set("r", 0.0034073443369221053);
    model.component("comp1").geom("geom1").feature().create("sph1406", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1406")
         .set("pos", new double[]{0.34742263518754535, 0.6275625971514595, 0.6698347890466556});
    model.component("comp1").geom("geom1").feature("sph1406").set("r", 0.010034961753260867);
    model.component("comp1").geom("geom1").feature().create("sph1407", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1407")
         .set("pos", new double[]{0.5266105419157053, 0.3419160274150567, 0.45888590826805387});
    model.component("comp1").geom("geom1").feature("sph1407").set("r", 0.008350316842197576);
    model.component("comp1").geom("geom1").feature().create("sph1431", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1431")
         .set("pos", new double[]{0.16306043894553593, 0.26418481096318003, 0.29107764259260344});
    model.component("comp1").geom("geom1").feature("sph1431").set("r", 0.002163125763592129);
    model.component("comp1").geom("geom1").feature().create("sph1434", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1434")
         .set("pos", new double[]{0.6421396933673604, 0.4561168825881691, 0.7017209411259054});
    model.component("comp1").geom("geom1").feature("sph1434").set("r", 0.004645645454194336);
    model.component("comp1").geom("geom1").feature().create("sph1435", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1435")
         .set("pos", new double[]{0.639256785707487, 0.2768822157868222, 0.2767086127656176});
    model.component("comp1").geom("geom1").feature("sph1435").set("r", 0.0055186023834790125);
    model.component("comp1").geom("geom1").feature().create("sph1438", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1438")
         .set("pos", new double[]{0.1899899967696541, 0.5238388432649682, 0.7424467268346294});
    model.component("comp1").geom("geom1").feature("sph1438").set("r", 0.021943378697806666);
    model.component("comp1").geom("geom1").feature().create("sph1439", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1439")
         .set("pos", new double[]{0.34442473481024394, 0.6197853470469096, 0.7439680947091918});
    model.component("comp1").geom("geom1").feature("sph1439").set("r", 0.004199841128345532);
    model.component("comp1").geom("geom1").feature().create("sph1457", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1457")
         .set("pos", new double[]{0.4254203082982141, 0.35646430354325276, 0.4952111825932449});
    model.component("comp1").geom("geom1").feature("sph1457").set("r", 0.012923956823398662);
    model.component("comp1").geom("geom1").feature().create("sph1458", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1458")
         .set("pos", new double[]{0.16776628905803564, 0.6339843263520043, 0.4171759299802608});
    model.component("comp1").geom("geom1").feature("sph1458").set("r", 0.010050863379783838);
    model.component("comp1").geom("geom1").feature().create("sph1468", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1468")
         .set("pos", new double[]{0.1565870050419711, 0.5383279343769558, 0.42054506803449515});
    model.component("comp1").geom("geom1").feature("sph1468").set("r", 0.0034776271096179758);
    model.component("comp1").geom("geom1").feature().create("sph1471", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1471")
         .set("pos", new double[]{0.22687215829975602, 0.5300676353929121, 0.37699088136948294});
    model.component("comp1").geom("geom1").feature("sph1471").set("r", 0.017503829459719865);
    model.component("comp1").geom("geom1").feature().create("sph1473", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1473")
         .set("pos", new double[]{0.39141286888266263, 0.27459120313993174, 0.31555950323052856});
    model.component("comp1").geom("geom1").feature("sph1473").set("r", 0.0032945434630151935);
    model.component("comp1").geom("geom1").feature().create("sph1475", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1475")
         .set("pos", new double[]{0.5604909669046226, 0.5294386932167009, 0.634439604406996});
    model.component("comp1").geom("geom1").feature("sph1475").set("r", 0.00525294081883199);
    model.component("comp1").geom("geom1").feature().create("sph1479", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1479")
         .set("pos", new double[]{0.2275423918941288, 0.4548915687531312, 0.7433009836711948});
    model.component("comp1").geom("geom1").feature("sph1479").set("r", 0.009291512499782367);
    model.component("comp1").geom("geom1").feature().create("sph1486", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1486")
         .set("pos", new double[]{0.3033750962058588, 0.6419959375636705, 0.35154267131160194});
    model.component("comp1").geom("geom1").feature("sph1486").set("r", 0.011042905473355855);
    model.component("comp1").geom("geom1").feature().create("sph1489", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1489")
         .set("pos", new double[]{0.38227312669301233, 0.5284151431232883, 0.5376414602260181});
    model.component("comp1").geom("geom1").feature("sph1489").set("r", 0.009348321574163043);
    model.component("comp1").geom("geom1").feature().create("sph1498", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1498")
         .set("pos", new double[]{0.34038073436242494, 0.2973813166183993, 0.3135726356307861});
    model.component("comp1").geom("geom1").feature("sph1498").set("r", 0.015801587627985666);
    model.component("comp1").geom("geom1").feature().create("sph1501", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1501")
         .set("pos", new double[]{0.14363429172635708, 0.26565634321625753, 0.6257125516405295});
    model.component("comp1").geom("geom1").feature("sph1501").set("r", 0.00562199075878036);
    model.component("comp1").geom("geom1").feature().create("sph1505", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1505")
         .set("pos", new double[]{0.1566642162855384, 0.6723858694836863, 0.37968879102970254});
    model.component("comp1").geom("geom1").feature("sph1505").set("r", 0.013963974239050426);
    model.component("comp1").geom("geom1").feature().create("sph1507", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1507")
         .set("pos", new double[]{0.30342836169686077, 0.37873540012852414, 0.4739096409491846});
    model.component("comp1").geom("geom1").feature("sph1507").set("r", 0.014971015681131506);
    model.component("comp1").geom("geom1").feature().create("sph1512", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1512")
         .set("pos", new double[]{0.2689199905391256, 0.6974585221084189, 0.5725842862209176});
    model.component("comp1").geom("geom1").feature("sph1512").set("r", 0.004808332629470044);
    model.component("comp1").geom("geom1").feature().create("sph1520", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1520")
         .set("pos", new double[]{0.1512296946221175, 0.4243899214388619, 0.5475361817607431});
    model.component("comp1").geom("geom1").feature("sph1520").set("r", 0.005462681547969401);
    model.component("comp1").geom("geom1").feature().create("sph1521", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1521")
         .set("pos", new double[]{0.5969377527252038, 0.5800006644906319, 0.5786347447048322});
    model.component("comp1").geom("geom1").feature("sph1521").set("r", 0.008045212730013658);
    model.component("comp1").geom("geom1").feature().create("sph1522", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1522")
         .set("pos", new double[]{0.11877548326413245, 0.6455396224836235, 0.7030305668267322});
    model.component("comp1").geom("geom1").feature("sph1522").set("r", 0.017909345760902674);
    model.component("comp1").geom("geom1").feature().create("sph1526", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1526")
         .set("pos", new double[]{0.620054649846306, 0.34359264753908475, 0.3509844098038802});
    model.component("comp1").geom("geom1").feature("sph1526").set("r", 0.004248459850172297);
    model.component("comp1").geom("geom1").feature().create("sph1533", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1533")
         .set("pos", new double[]{0.389512596779365, 0.5736340962821571, 0.5440216234229193});
    model.component("comp1").geom("geom1").feature("sph1533").set("r", 0.003964503589149678);
    model.component("comp1").geom("geom1").feature().create("sph1535", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1535")
         .set("pos", new double[]{0.6001493991882993, 0.41426857654981347, 0.34940857617346316});
    model.component("comp1").geom("geom1").feature("sph1535").set("r", 0.005947905716081026);
    model.component("comp1").geom("geom1").feature().create("sph1541", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1541")
         .set("pos", new double[]{0.5752626277743553, 0.3151650409949102, 0.6472915527314971});
    model.component("comp1").geom("geom1").feature("sph1541").set("r", 0.016876895073489967);
    model.component("comp1").geom("geom1").feature().create("sph1546", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1546")
         .set("pos", new double[]{0.2057837825398657, 0.5772916100544252, 0.3665747207851006});
    model.component("comp1").geom("geom1").feature("sph1546").set("r", 0.004510857654305183);
    model.component("comp1").geom("geom1").run();

    model.view().create("view2", 2);

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").label("Bubble");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_bubble", "0", "0", "0", "n_bubble", "0", "0", "0", "n_bubble"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    model.component("comp1").physics("gop").create("relb1", "ReleaseFromBoundary", 2);
    model.component("comp1").physics("gop").feature("relb1").selection().set(1);
    model.component("comp1").physics("gop").feature("relb1").setIndex("Nr", 200, 0);
    model.component("comp1").physics("gop").feature("relb1").set("I0", "955.3800565174306[W/m^2]");
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().named("geom1_ps3_bnd");
    model.component("comp1").physics("gop").prop("IntensityComputation")
         .set("IntensityComputation", "ComputeIntensityAndPower");
    model.component("comp1").physics("gop").prop("ExteriorUnmeshedProperties").set("next", 1.33);
    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");
    model.component("comp1").physics("gop").feature("relb1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relb1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("relb1").set("P0", "0.25961831094544385");
    model.component("comp1").physics("gop").feature("relb1").active(false);
    model.component("comp1").physics("gop").create("relg1", "ReleaseGrid", -1);
    model.component("comp1").physics("gop").feature("relg1").set("GridType", "Cylindrical");
    model.component("comp1").physics("gop").feature("relg1")
         .set("qcc", new String[][]{{"0"}, {"height/2"}, {"depth/2"}});
    model.component("comp1").physics("gop").feature("relg1").set("Rc", 0.001);
    model.component("comp1").physics("gop").feature("relg1").set("Nphi", 20);
    model.component("comp1").physics("gop").feature("relg1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relg1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("relg1").set("P0", "0.25961831094544385");
    model.component("comp1").physics("gop").feature("relg1").set("I0", "955.3800565174306[W/m^2]");
    model.component("comp1").physics("gop").feature("matd1").set("ReleaseReflectedRays", "Always");
    model.component("comp1").physics("gop").prop("MaximumSecondary").setIndex("MaximumSecondary", 1000, 0);

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
    model.result().numerical().create("ray5", "Ray");
    model.result().numerical().create("ray6", "Ray");
    model.result().numerical().create("ray7", "Ray");
    model.result().numerical().create("ray8", "Ray");
    model.result().numerical("ray1").set("probetag", "none");
    model.result().numerical("ray2").set("probetag", "none");
    model.result().numerical("ray3").set("probetag", "none");
    model.result().numerical("ray4").set("probetag", "none");
    model.result().numerical("ray5").set("probetag", "none");
    model.result().numerical("ray6").set("probetag", "none");
    model.result().numerical("ray7").set("probetag", "none");
    model.result().numerical("ray8").set("probetag", "none");
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
    model.result().export().create("tbl5", "Table");
    model.result().export().create("tbl6", "Table");
    model.result().export().create("tbl7", "Table");
    model.result().export().create("tbl8", "Table");

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,15)");

    model.sol("sol1").attach("std1");
    model.sol("sol1").feature("st1").label("Compile Equations: Ray Tracing");
    model.sol("sol1").feature("v1").label("Dependent Variables 1.1");
    model.sol("sol1").feature("v1").set("clist", new String[]{"range(0,0.01,15)", "0.01[ns]"});
    model.sol("sol1").feature("t1").label("Time-Dependent Solver 1.1");
    model.sol("sol1").feature("t1").set("tunit", "ns");
    model.sol("sol1").feature("t1").set("tlist", "range(0,0.01,15)");
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

    model.label("Finished_Bubbles_3D_0_Model.mph");

    model.component("comp1").physics("gop").feature("relg1").setIndex("Ncr", 10, 0);

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    model = run2(model);
    model = run3(model);
    model = run4(model);
    model = run5(model);
    model = run6(model);
    model = run7(model);
    run8(model);
  }

}
