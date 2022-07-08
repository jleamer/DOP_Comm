/*
 * test.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Jun 13 2022, 12:33 by COMSOL 6.0.0.312. */
public class test {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src/ray_convergence/class_files");

    model.label("ray_conv_10_Model.mph");

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
    model.result().table().create("tbl4", "Table");
    model.result().table().create("tbl5", "Table");
    model.result().table().create("tbl6", "Table");
    model.result().table().create("tbl7", "Table");
    model.result().table().create("tbl8", "Table");
    model.result().table().create("tbl9", "Table");
    model.result().table().create("tbl10", "Table");
    model.result().table().create("tbl11", "Table");
    model.result().table().create("tbl12", "Table");
    model.result().table().create("tbl13", "Table");

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").label("Channel");
    model.component("comp1").geom("geom1").feature("blk1").set("pos", new String[]{"width/2", "0", "0"});
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"width/2", "depth", "height"});
    model.component("comp1").geom("geom1").create("ps1", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps1").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("ps3", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps3").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ps3").set("pos", new String[]{"width", "0", "0"});
    model.component("comp1").geom("geom1").feature("ps3").set("parmax1", "height");
    model.component("comp1").geom("geom1").feature("ps3").set("parmax2", "depth");
    model.component("comp1").geom("geom1").feature("ps3").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("sph0", "Sphere");
    model.component("comp1").geom("geom1").feature("sph0")
         .set("pos", new double[]{0.39916240233702627, 0.5442156170771532, 0.42479031270258183});
    model.component("comp1").geom("geom1").feature("sph0").set("r", 0.007436704297351776);
    model.component("comp1").geom("geom1").create("sph1", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1")
         .set("pos", new double[]{0.3602472453440067, 0.8864346650329707, 0.957344848125822});
    model.component("comp1").geom("geom1").feature("sph1").set("r", 0.006813047017599906);
    model.component("comp1").geom("geom1").create("sph2", "Sphere");
    model.component("comp1").geom("geom1").feature("sph2")
         .set("pos", new double[]{0.44533433859422616, 0.5286376986989034, 0.5674388319943781});
    model.component("comp1").geom("geom1").feature("sph2").set("r", 0.004450973669432);
    model.component("comp1").geom("geom1").create("sph3", "Sphere");
    model.component("comp1").geom("geom1").feature("sph3")
         .set("pos", new double[]{0.27576379891773045, 0.09483377228256185, 0.02917147693743527});
    model.component("comp1").geom("geom1").feature("sph3").set("r", 0.00933036974463395);
    model.component("comp1").geom("geom1").create("sph4", "Sphere");
    model.component("comp1").geom("geom1").feature("sph4")
         .set("pos", new double[]{0.43981409527731125, 0.8637266937112913, 0.970487977204946});
    model.component("comp1").geom("geom1").feature("sph4").set("r", 0.008493578609931444);
    model.component("comp1").geom("geom1").create("sph5", "Sphere");
    model.component("comp1").geom("geom1").feature("sph5")
         .set("pos", new double[]{0.366000995594711, 0.7759327466465268, 0.12452894372864833});
    model.component("comp1").geom("geom1").feature("sph5").set("r", 0.008192427077950513);
    model.component("comp1").geom("geom1").create("sph6", "Sphere");
    model.component("comp1").geom("geom1").feature("sph6")
         .set("pos", new double[]{0.29065967839178103, 0.9386576254395671, 0.5215529634999367});
    model.component("comp1").geom("geom1").feature("sph6").set("r", 0.0067592891919477155);
    model.component("comp1").geom("geom1").create("sph7", "Sphere");
    model.component("comp1").geom("geom1").feature("sph7")
         .set("pos", new double[]{0.31836712868154987, 0.7716383651292603, 0.45656532174171394});
    model.component("comp1").geom("geom1").feature("sph7").set("r", 0.004731957459914712);
    model.component("comp1").geom("geom1").create("sph8", "Sphere");
    model.component("comp1").geom("geom1").feature("sph8")
         .set("pos", new double[]{0.2605835223597451, 0.616196601899386, 0.6107245890192455});
    model.component("comp1").geom("geom1").feature("sph8").set("r", 0.006115905539817838);
    model.component("comp1").geom("geom1").create("sph9", "Sphere");
    model.component("comp1").geom("geom1").feature("sph9")
         .set("pos", new double[]{0.4801217845093234, 0.6794375782761767, 0.36134902311634853});
    model.component("comp1").geom("geom1").feature("sph9").set("r", 0.006552405971872813);
    model.component("comp1").geom("geom1").create("sph10", "Sphere");
    model.component("comp1").geom("geom1").feature("sph10")
         .set("pos", new double[]{0.4224578559315814, 0.06456454007058209, 0.6651212991121378});
    model.component("comp1").geom("geom1").feature("sph10").set("r", 0.004933287584194074);
    model.component("comp1").geom("geom1").create("sph11", "Sphere");
    model.component("comp1").geom("geom1").feature("sph11")
         .set("pos", new double[]{0.30667098674673526, 0.1341478544493609, 0.31802554749784157});
    model.component("comp1").geom("geom1").feature("sph11").set("r", 0.007035740826563435);
    model.component("comp1").geom("geom1").create("sph12", "Sphere");
    model.component("comp1").geom("geom1").feature("sph12")
         .set("pos", new double[]{0.3919492352768795, 0.4391262736711156, 0.9841998075304306});
    model.component("comp1").geom("geom1").feature("sph12").set("r", 0.004273396938483604);
    model.component("comp1").geom("geom1").create("sph13", "Sphere");
    model.component("comp1").geom("geom1").feature("sph13")
         .set("pos", new double[]{0.30333617260543483, 0.1626090077599188, 0.6525208784327384});
    model.component("comp1").geom("geom1").feature("sph13").set("r", 0.0019184032967322529);
    model.component("comp1").geom("geom1").create("sph14", "Sphere");
    model.component("comp1").geom("geom1").feature("sph14")
         .set("pos", new double[]{0.36679866923833193, 0.2461019681422608, 0.1612064870103469});
    model.component("comp1").geom("geom1").feature("sph14").set("r", 0.0032796244228580395);
    model.component("comp1").geom("geom1").create("sph15", "Sphere");
    model.component("comp1").geom("geom1").feature("sph15")
         .set("pos", new double[]{0.41345914997829086, 0.13962542638668646, 0.19779201272059685});
    model.component("comp1").geom("geom1").feature("sph15").set("r", 0.0019933762704787464);
    model.component("comp1").geom("geom1").create("sph16", "Sphere");
    model.component("comp1").geom("geom1").feature("sph16")
         .set("pos", new double[]{0.45247587190006744, 0.10058113345663634, 0.8350260593973593});
    model.component("comp1").geom("geom1").feature("sph16").set("r", 0.004318526535948677);
    model.component("comp1").geom("geom1").create("sph17", "Sphere");
    model.component("comp1").geom("geom1").feature("sph17")
         .set("pos", new double[]{0.4923377813950738, 0.468768125497405, 0.9749828783465806});
    model.component("comp1").geom("geom1").feature("sph17").set("r", 0.0018648856710456678);
    model.component("comp1").geom("geom1").create("sph18", "Sphere");
    model.component("comp1").geom("geom1").feature("sph18")
         .set("pos", new double[]{0.4317324526181088, 0.04512638025719039, 0.28560597689215533});
    model.component("comp1").geom("geom1").feature("sph18").set("r", 0.006443609677705415);
    model.component("comp1").geom("geom1").create("sph19", "Sphere");
    model.component("comp1").geom("geom1").feature("sph19")
         .set("pos", new double[]{0.32488382743558575, 0.12031516062355238, 0.31874101336174443});
    model.component("comp1").geom("geom1").feature("sph19").set("r", 0.00208176905091852);
    model.component("comp1").geom("geom1").create("sph20", "Sphere");
    model.component("comp1").geom("geom1").feature("sph20")
         .set("pos", new double[]{0.27015861523442536, 0.6906519617537252, 0.5659716219767064});
    model.component("comp1").geom("geom1").feature("sph20").set("r", 0.00472836695063203);
    model.component("comp1").geom("geom1").create("sph21", "Sphere");
    model.component("comp1").geom("geom1").feature("sph21")
         .set("pos", new double[]{0.38065446105639406, 0.09669238031746186, 0.5754318053327697});
    model.component("comp1").geom("geom1").feature("sph21").set("r", 0.003388505418455009);
    model.component("comp1").geom("geom1").create("sph22", "Sphere");
    model.component("comp1").geom("geom1").feature("sph22")
         .set("pos", new double[]{0.33303995749489484, 0.6642752302721237, 0.13869330591490997});
    model.component("comp1").geom("geom1").feature("sph22").set("r", 0.009363665778185929);
    model.component("comp1").geom("geom1").create("sph23", "Sphere");
    model.component("comp1").geom("geom1").feature("sph23")
         .set("pos", new double[]{0.3254880856544895, 0.18790987490919556, 0.5852244207036362});
    model.component("comp1").geom("geom1").feature("sph23").set("r", 0.007446944837067091);
    model.component("comp1").geom("geom1").create("sph24", "Sphere");
    model.component("comp1").geom("geom1").feature("sph24")
         .set("pos", new double[]{0.45645807206295874, 0.005865353694769963, 0.6773965455465601});
    model.component("comp1").geom("geom1").feature("sph24").set("r", 0.001180967915687442);
    model.component("comp1").geom("geom1").create("sph25", "Sphere");
    model.component("comp1").geom("geom1").feature("sph25")
         .set("pos", new double[]{0.4321850407844393, 0.959017865365807, 0.25047673301372153});
    model.component("comp1").geom("geom1").feature("sph25").set("r", 0.003430071758729484);
    model.component("comp1").geom("geom1").create("sph26", "Sphere");
    model.component("comp1").geom("geom1").feature("sph26")
         .set("pos", new double[]{0.39687184754744353, 0.5713580896012442, 0.22650734324634125});
    model.component("comp1").geom("geom1").feature("sph26").set("r", 0.006185416009760533);
    model.component("comp1").geom("geom1").create("sph27", "Sphere");
    model.component("comp1").geom("geom1").feature("sph27")
         .set("pos", new double[]{0.3627938662757866, 0.8397751257611856, 0.6956593504840856});
    model.component("comp1").geom("geom1").feature("sph27").set("r", 0.009574741103652865);
    model.component("comp1").geom("geom1").create("sph28", "Sphere");
    model.component("comp1").geom("geom1").feature("sph28")
         .set("pos", new double[]{0.45114182808602304, 0.3972668236690134, 0.8783006156045613});
    model.component("comp1").geom("geom1").feature("sph28").set("r", 0.0036769325576962034);
    model.component("comp1").geom("geom1").create("sph29", "Sphere");
    model.component("comp1").geom("geom1").feature("sph29")
         .set("pos", new double[]{0.4656763063533065, 0.6901320858697326, 0.7224469556185241});
    model.component("comp1").geom("geom1").feature("sph29").set("r", 0.006231455853722729);
    model.component("comp1").geom("geom1").create("sph30", "Sphere");
    model.component("comp1").geom("geom1").feature("sph30")
         .set("pos", new double[]{0.4839931161782384, 0.6424028744737967, 0.4246944582339947});
    model.component("comp1").geom("geom1").feature("sph30").set("r", 0.005511919437340321);
    model.component("comp1").geom("geom1").create("sph31", "Sphere");
    model.component("comp1").geom("geom1").feature("sph31")
         .set("pos", new double[]{0.2610079568540466, 0.3041374933654518, 0.6581048837857679});
    model.component("comp1").geom("geom1").feature("sph31").set("r", 0.00645753892715132);
    model.component("comp1").geom("geom1").create("sph32", "Sphere");
    model.component("comp1").geom("geom1").feature("sph32")
         .set("pos", new double[]{0.40365162099307056, 0.4292830904300612, 0.13810645069590233});
    model.component("comp1").geom("geom1").feature("sph32").set("r", 0.003610698464893997);
    model.component("comp1").geom("geom1").create("sph33", "Sphere");
    model.component("comp1").geom("geom1").feature("sph33")
         .set("pos", new double[]{0.39197565052052663, 0.5902031124310362, 0.5737775400060056});
    model.component("comp1").geom("geom1").feature("sph33").set("r", 0.0036845409336042773);
    model.component("comp1").geom("geom1").create("sph34", "Sphere");
    model.component("comp1").geom("geom1").feature("sph34")
         .set("pos", new double[]{0.41093323930839387, 0.432361954178735, 0.8910910605519744});
    model.component("comp1").geom("geom1").feature("sph34").set("r", 0.006878807378714203);
    model.component("comp1").geom("geom1").create("sph35", "Sphere");
    model.component("comp1").geom("geom1").feature("sph35")
         .set("pos", new double[]{0.35951882640996596, 0.8885464988425107, 0.8035557868341919});
    model.component("comp1").geom("geom1").feature("sph35").set("r", 0.004308056830431069);
    model.component("comp1").geom("geom1").create("sph36", "Sphere");
    model.component("comp1").geom("geom1").feature("sph36")
         .set("pos", new double[]{0.2809213911939415, 0.9133288061066303, 0.7110983808622546});
    model.component("comp1").geom("geom1").feature("sph36").set("r", 0.007334997251863298);
    model.component("comp1").geom("geom1").create("sph37", "Sphere");
    model.component("comp1").geom("geom1").feature("sph37")
         .set("pos", new double[]{0.2943658347628962, 0.8607711762655241, 0.16923607140111424});
    model.component("comp1").geom("geom1").feature("sph37").set("r", 0.0099896230591108);
    model.component("comp1").geom("geom1").create("sph38", "Sphere");
    model.component("comp1").geom("geom1").feature("sph38")
         .set("pos", new double[]{0.2858754574807522, 0.8434562565714318, 0.8032992045696399});
    model.component("comp1").geom("geom1").feature("sph38").set("r", 0.0065400360785545985);
    model.component("comp1").geom("geom1").create("sph39", "Sphere");
    model.component("comp1").geom("geom1").feature("sph39")
         .set("pos", new double[]{0.3529322546859281, 0.07444203432413624, 0.6950114921071083});
    model.component("comp1").geom("geom1").feature("sph39").set("r", 0.00612190664753134);
    model.component("comp1").geom("geom1").create("sph41", "Sphere");
    model.component("comp1").geom("geom1").feature("sph41")
         .set("pos", new double[]{0.2614268738162393, 0.3624150706771057, 0.7259877008424671});
    model.component("comp1").geom("geom1").feature("sph41").set("r", 0.0087022300815335);
    model.component("comp1").geom("geom1").create("sph42", "Sphere");
    model.component("comp1").geom("geom1").feature("sph42")
         .set("pos", new double[]{0.3801520892318212, 0.05660611125269745, 0.20152334283957543});
    model.component("comp1").geom("geom1").feature("sph42").set("r", 0.0025446670953529647);
    model.component("comp1").geom("geom1").create("sph43", "Sphere");
    model.component("comp1").geom("geom1").feature("sph43")
         .set("pos", new double[]{0.44773911387972776, 0.22456888006756048, 0.34571253589441747});
    model.component("comp1").geom("geom1").feature("sph43").set("r", 0.0011666961501455258);
    model.component("comp1").geom("geom1").create("sph44", "Sphere");
    model.component("comp1").geom("geom1").feature("sph44")
         .set("pos", new double[]{0.42227993439131273, 0.04059609924519998, 0.1709662076419087});
    model.component("comp1").geom("geom1").feature("sph44").set("r", 0.00935273164119032);
    model.component("comp1").geom("geom1").create("sph45", "Sphere");
    model.component("comp1").geom("geom1").feature("sph45")
         .set("pos", new double[]{0.39328876377750915, 0.24134912683884774, 0.92848818674484});
    model.component("comp1").geom("geom1").feature("sph45").set("r", 0.006593305613497872);
    model.component("comp1").geom("geom1").create("sph46", "Sphere");
    model.component("comp1").geom("geom1").feature("sph46")
         .set("pos", new double[]{0.3834431432466763, 0.5887365264393606, 0.7271186178045967});
    model.component("comp1").geom("geom1").feature("sph46").set("r", 0.006525693603693064);
    model.component("comp1").geom("geom1").create("sph47", "Sphere");
    model.component("comp1").geom("geom1").feature("sph47")
         .set("pos", new double[]{0.3503303131747553, 0.21205329170462991, 0.18858264925309376});
    model.component("comp1").geom("geom1").feature("sph47").set("r", 0.0038075049593164173);
    model.component("comp1").geom("geom1").create("sph48", "Sphere");
    model.component("comp1").geom("geom1").feature("sph48")
         .set("pos", new double[]{0.4303365443490449, 0.49064007887909616, 0.23259339650397542});
    model.component("comp1").geom("geom1").feature("sph48").set("r", 0.009499351509855404);
    model.component("comp1").geom("geom1").create("sph49", "Sphere");
    model.component("comp1").geom("geom1").feature("sph49")
         .set("pos", new double[]{0.2674147584211734, 0.4348480603219465, 0.3130339671017066});
    model.component("comp1").geom("geom1").feature("sph49").set("r", 0.0032892083359335367);
    model.component("comp1").geom("geom1").create("sph50", "Sphere");
    model.component("comp1").geom("geom1").feature("sph50")
         .set("pos", new double[]{0.3462147369376455, 0.18426037627800734, 0.031587134640991825});
    model.component("comp1").geom("geom1").feature("sph50").set("r", 0.007267091399339136);
    model.component("comp1").geom("geom1").create("sph51", "Sphere");
    model.component("comp1").geom("geom1").feature("sph51")
         .set("pos", new double[]{0.4192722540653556, 0.4538455005294387, 0.5364617737941116});
    model.component("comp1").geom("geom1").feature("sph51").set("r", 0.0016052466831692374);
    model.component("comp1").geom("geom1").create("sph52", "Sphere");
    model.component("comp1").geom("geom1").feature("sph52")
         .set("pos", new double[]{0.48868994751055833, 0.2220324966768117, 0.6601199509155722});
    model.component("comp1").geom("geom1").feature("sph52").set("r", 0.00907004163736308);
    model.component("comp1").geom("geom1").create("sph53", "Sphere");
    model.component("comp1").geom("geom1").feature("sph53")
         .set("pos", new double[]{0.25839346759343146, 0.756637232666396, 0.3212301997299353});
    model.component("comp1").geom("geom1").feature("sph53").set("r", 0.0033699013906343563);
    model.component("comp1").geom("geom1").create("sph54", "Sphere");
    model.component("comp1").geom("geom1").feature("sph54")
         .set("pos", new double[]{0.3962930485241591, 0.8281013459892377, 0.6278336020635896});
    model.component("comp1").geom("geom1").feature("sph54").set("r", 0.0044511750475470825);
    model.component("comp1").geom("geom1").create("sph55", "Sphere");
    model.component("comp1").geom("geom1").feature("sph55")
         .set("pos", new double[]{0.32239556108576717, 0.7927691064753178, 0.19120261240384953});
    model.component("comp1").geom("geom1").feature("sph55").set("r", 0.008853855899026559);
    model.component("comp1").geom("geom1").create("sph56", "Sphere");
    model.component("comp1").geom("geom1").feature("sph56")
         .set("pos", new double[]{0.4182816217647757, 0.2209557761702692, 0.9388033319164821});
    model.component("comp1").geom("geom1").feature("sph56").set("r", 0.009575124912747503);
    model.component("comp1").geom("geom1").create("sph57", "Sphere");
    model.component("comp1").geom("geom1").feature("sph57")
         .set("pos", new double[]{0.3172145245912139, 0.2176568503220508, 0.5179248747484574});
    model.component("comp1").geom("geom1").feature("sph57").set("r", 0.007577702260931421);
    model.component("comp1").geom("geom1").create("sph58", "Sphere");
    model.component("comp1").geom("geom1").feature("sph58")
         .set("pos", new double[]{0.30258770674297153, 0.42487088777445836, 0.3744797648992717});
    model.component("comp1").geom("geom1").feature("sph58").set("r", 0.0012309644624907841);
    model.component("comp1").geom("geom1").create("sph59", "Sphere");
    model.component("comp1").geom("geom1").feature("sph59")
         .set("pos", new double[]{0.321707464764321, 0.5858866181409763, 0.8600917534067642});
    model.component("comp1").geom("geom1").feature("sph59").set("r", 0.005172178819283297);
    model.component("comp1").geom("geom1").create("sph60", "Sphere");
    model.component("comp1").geom("geom1").feature("sph60")
         .set("pos", new double[]{0.37927325179728216, 0.13358235706238283, 0.7159671792555583});
    model.component("comp1").geom("geom1").feature("sph60").set("r", 0.002057786703658298);
    model.component("comp1").geom("geom1").create("sph61", "Sphere");
    model.component("comp1").geom("geom1").feature("sph61")
         .set("pos", new double[]{0.3907580919249352, 0.1861711982326088, 0.148089970660635});
    model.component("comp1").geom("geom1").feature("sph61").set("r", 0.004564537325265645);
    model.component("comp1").geom("geom1").create("sph62", "Sphere");
    model.component("comp1").geom("geom1").feature("sph62")
         .set("pos", new double[]{0.34046040296927366, 0.935681880974884, 0.7624637174817165});
    model.component("comp1").geom("geom1").feature("sph62").set("r", 0.005392506525840592);
    model.component("comp1").geom("geom1").create("sph63", "Sphere");
    model.component("comp1").geom("geom1").feature("sph63")
         .set("pos", new double[]{0.46968199038525194, 0.08986936698488357, 0.5513847421202629});
    model.component("comp1").geom("geom1").feature("sph63").set("r", 0.007737972578654926);
    model.component("comp1").geom("geom1").create("sph64", "Sphere");
    model.component("comp1").geom("geom1").feature("sph64")
         .set("pos", new double[]{0.4847003882241757, 0.2947499580752982, 0.24407375112184274});
    model.component("comp1").geom("geom1").feature("sph64").set("r", 0.00626028462060192);
    model.component("comp1").geom("geom1").create("sph65", "Sphere");
    model.component("comp1").geom("geom1").feature("sph65")
         .set("pos", new double[]{0.25594753335728465, 0.9278948327656116, 0.6692699646920808});
    model.component("comp1").geom("geom1").feature("sph65").set("r", 0.0019026454803894805);
    model.component("comp1").geom("geom1").create("sph66", "Sphere");
    model.component("comp1").geom("geom1").feature("sph66")
         .set("pos", new double[]{0.3239538206023162, 0.5850161323689813, 0.07098986785513356});
    model.component("comp1").geom("geom1").feature("sph66").set("r", 0.00806637620820824);
    model.component("comp1").geom("geom1").create("sph67", "Sphere");
    model.component("comp1").geom("geom1").feature("sph67")
         .set("pos", new double[]{0.4892448679545007, 0.8724610907574399, 0.3398973345577462});
    model.component("comp1").geom("geom1").feature("sph67").set("r", 0.005370648363411607);
    model.component("comp1").geom("geom1").create("sph68", "Sphere");
    model.component("comp1").geom("geom1").feature("sph68")
         .set("pos", new double[]{0.3131057821178104, 0.9406432565196943, 0.9328554679980211});
    model.component("comp1").geom("geom1").feature("sph68").set("r", 0.009654131390873486);
    model.component("comp1").geom("geom1").create("sph69", "Sphere");
    model.component("comp1").geom("geom1").feature("sph69")
         .set("pos", new double[]{0.40547451042710725, 0.8681550162875497, 0.2964117809734961});
    model.component("comp1").geom("geom1").feature("sph69").set("r", 0.008192823286171526);
    model.component("comp1").geom("geom1").create("sph70", "Sphere");
    model.component("comp1").geom("geom1").feature("sph70")
         .set("pos", new double[]{0.4024321477528961, 0.021648603829631748, 0.349873473063902});
    model.component("comp1").geom("geom1").feature("sph70").set("r", 0.008640491997816264);
    model.component("comp1").geom("geom1").create("sph71", "Sphere");
    model.component("comp1").geom("geom1").feature("sph71")
         .set("pos", new double[]{0.49320887350344633, 0.4784712427699766, 0.49740353878416205});
    model.component("comp1").geom("geom1").feature("sph71").set("r", 0.002333267748533485);
    model.component("comp1").geom("geom1").create("sph72", "Sphere");
    model.component("comp1").geom("geom1").feature("sph72")
         .set("pos", new double[]{0.34392163990715796, 0.14180593248766796, 0.8177657598542541});
    model.component("comp1").geom("geom1").feature("sph72").set("r", 0.006755252647588513);
    model.component("comp1").geom("geom1").create("sph73", "Sphere");
    model.component("comp1").geom("geom1").feature("sph73")
         .set("pos", new double[]{0.37776842773789754, 0.22581047597192308, 0.1000230664528677});
    model.component("comp1").geom("geom1").feature("sph73").set("r", 0.002708631207124822);
    model.component("comp1").geom("geom1").create("sph74", "Sphere");
    model.component("comp1").geom("geom1").feature("sph74")
         .set("pos", new double[]{0.48494458418427183, 0.952761089550789, 0.899432871572523});
    model.component("comp1").geom("geom1").feature("sph74").set("r", 0.00875972365679515);
    model.component("comp1").geom("geom1").create("sph75", "Sphere");
    model.component("comp1").geom("geom1").feature("sph75")
         .set("pos", new double[]{0.3359447616034644, 0.08777563953953801, 0.4087190841003048});
    model.component("comp1").geom("geom1").feature("sph75").set("r", 0.00796642599428775);
    model.component("comp1").geom("geom1").create("sph76", "Sphere");
    model.component("comp1").geom("geom1").feature("sph76")
         .set("pos", new double[]{0.2853932139598053, 0.056187097619634356, 0.7242001426364388});
    model.component("comp1").geom("geom1").feature("sph76").set("r", 0.0030901072795384847);
    model.component("comp1").geom("geom1").create("sph77", "Sphere");
    model.component("comp1").geom("geom1").feature("sph77")
         .set("pos", new double[]{0.4420483687231401, 0.1477253731564124, 0.08044952831365386});
    model.component("comp1").geom("geom1").feature("sph77").set("r", 0.0011028471276252794);
    model.component("comp1").geom("geom1").create("sph78", "Sphere");
    model.component("comp1").geom("geom1").feature("sph78")
         .set("pos", new double[]{0.4173903681234566, 0.24628716110418797, 0.42082654603471653});
    model.component("comp1").geom("geom1").feature("sph78").set("r", 0.0018064273081474485);
    model.component("comp1").geom("geom1").create("sph79", "Sphere");
    model.component("comp1").geom("geom1").feature("sph79")
         .set("pos", new double[]{0.46079941161412813, 0.7243123212327857, 0.27309146646967997});
    model.component("comp1").geom("geom1").feature("sph79").set("r", 0.006016319121915253);
    model.component("comp1").geom("geom1").create("sph80", "Sphere");
    model.component("comp1").geom("geom1").feature("sph80")
         .set("pos", new double[]{0.2657851227862364, 0.3024649918165699, 0.2631569056306923});
    model.component("comp1").geom("geom1").feature("sph80").set("r", 0.0021833451936201483);
    model.component("comp1").geom("geom1").create("sph81", "Sphere");
    model.component("comp1").geom("geom1").feature("sph81")
         .set("pos", new double[]{0.4189489342747727, 0.6936280061178021, 0.2857292339373917});
    model.component("comp1").geom("geom1").feature("sph81").set("r", 0.005105265101204317);
    model.component("comp1").geom("geom1").create("sph82", "Sphere");
    model.component("comp1").geom("geom1").feature("sph82")
         .set("pos", new double[]{0.29810594671173357, 0.785995149355579, 0.060764956784169856});
    model.component("comp1").geom("geom1").feature("sph82").set("r", 0.004419342603101084);
    model.component("comp1").geom("geom1").create("sph83", "Sphere");
    model.component("comp1").geom("geom1").feature("sph83")
         .set("pos", new double[]{0.4406199595928504, 0.7733724052270954, 0.2629219917799703});
    model.component("comp1").geom("geom1").feature("sph83").set("r", 0.007272975175524886);
    model.component("comp1").geom("geom1").create("sph84", "Sphere");
    model.component("comp1").geom("geom1").feature("sph84")
         .set("pos", new double[]{0.3961352834274433, 0.2748048574550548, 0.37198007818628515});
    model.component("comp1").geom("geom1").feature("sph84").set("r", 0.004364318241393054);
    model.component("comp1").geom("geom1").create("sph85", "Sphere");
    model.component("comp1").geom("geom1").feature("sph85")
         .set("pos", new double[]{0.3651866494302325, 0.047138326364877636, 0.7981329236812166});
    model.component("comp1").geom("geom1").feature("sph85").set("r", 0.002773488521670757);
    model.component("comp1").geom("geom1").create("sph86", "Sphere");
    model.component("comp1").geom("geom1").feature("sph86")
         .set("pos", new double[]{0.37964502615983275, 0.30746408909609435, 0.577280449196756});
    model.component("comp1").geom("geom1").feature("sph86").set("r", 0.0016926080228796946);
    model.component("comp1").geom("geom1").create("sph87", "Sphere");
    model.component("comp1").geom("geom1").feature("sph87")
         .set("pos", new double[]{0.4085874515977304, 0.0443159087536966, 0.43174357058862456});
    model.component("comp1").geom("geom1").feature("sph87").set("r", 0.009634900067500826);
    model.component("comp1").geom("geom1").create("sph88", "Sphere");
    model.component("comp1").geom("geom1").feature("sph88")
         .set("pos", new double[]{0.38363989831093465, 0.6793644873113693, 0.2800826408235091});
    model.component("comp1").geom("geom1").feature("sph88").set("r", 0.005590151670864253);
    model.component("comp1").geom("geom1").create("sph89", "Sphere");
    model.component("comp1").geom("geom1").feature("sph89")
         .set("pos", new double[]{0.34863250549783115, 0.9544342827589691, 0.1884823267910498});
    model.component("comp1").geom("geom1").feature("sph89").set("r", 0.002159745089196882);
    model.component("comp1").geom("geom1").create("sph90", "Sphere");
    model.component("comp1").geom("geom1").feature("sph90")
         .set("pos", new double[]{0.38515107785117175, 0.45769872370498643, 0.8750608599200422});
    model.component("comp1").geom("geom1").feature("sph90").set("r", 0.009135855594354134);
    model.component("comp1").geom("geom1").create("sph91", "Sphere");
    model.component("comp1").geom("geom1").feature("sph91")
         .set("pos", new double[]{0.42874309888715634, 0.4000608040347906, 0.89990096964749});
    model.component("comp1").geom("geom1").feature("sph91").set("r", 0.005127435655917273);
    model.component("comp1").geom("geom1").create("sph92", "Sphere");
    model.component("comp1").geom("geom1").feature("sph92")
         .set("pos", new double[]{0.42202687363786123, 0.3302047509550982, 0.75307577906491});
    model.component("comp1").geom("geom1").feature("sph92").set("r", 0.007210225181721047);
    model.component("comp1").geom("geom1").create("sph93", "Sphere");
    model.component("comp1").geom("geom1").feature("sph93")
         .set("pos", new double[]{0.31350156142572927, 0.1651042694676463, 0.7924052762343705});
    model.component("comp1").geom("geom1").feature("sph93").set("r", 0.006724549499024272);
    model.component("comp1").geom("geom1").create("sph94", "Sphere");
    model.component("comp1").geom("geom1").feature("sph94")
         .set("pos", new double[]{0.36534116225989965, 0.5892313554829343, 0.8508311178628891});
    model.component("comp1").geom("geom1").feature("sph94").set("r", 0.009632499427317004);
    model.component("comp1").geom("geom1").create("sph95", "Sphere");
    model.component("comp1").geom("geom1").feature("sph95")
         .set("pos", new double[]{0.4833459332964798, 0.5749762259784797, 0.8174856659482227});
    model.component("comp1").geom("geom1").feature("sph95").set("r", 0.005115011080184714);
    model.component("comp1").geom("geom1").create("sph96", "Sphere");
    model.component("comp1").geom("geom1").feature("sph96")
         .set("pos", new double[]{0.44808819392205157, 0.1656673369806377, 0.6265319685237972});
    model.component("comp1").geom("geom1").feature("sph96").set("r", 0.009179593465714647);

    return model;
  }

  public static Model run2(Model model) {
    model.component("comp1").geom("geom1").create("sph97", "Sphere");
    model.component("comp1").geom("geom1").feature("sph97")
         .set("pos", new double[]{0.2696889546355519, 0.42472901414721326, 0.2608973723838655});
    model.component("comp1").geom("geom1").feature("sph97").set("r", 0.004585908327577094);
    model.component("comp1").geom("geom1").create("sph98", "Sphere");
    model.component("comp1").geom("geom1").feature("sph98")
         .set("pos", new double[]{0.26639190789128836, 0.9510502659719069, 0.35786846376329606});
    model.component("comp1").geom("geom1").feature("sph98").set("r", 0.008641344775856598);
    model.component("comp1").geom("geom1").create("sph99", "Sphere");
    model.component("comp1").geom("geom1").feature("sph99")
         .set("pos", new double[]{0.2581549898696722, 0.18788289695806787, 0.40209096729765403});
    model.component("comp1").geom("geom1").feature("sph99").set("r", 0.004210362013622886);
    model.component("comp1").geom("geom1").create("sph100", "Sphere");
    model.component("comp1").geom("geom1").feature("sph100")
         .set("pos", new double[]{0.2824018420561827, 0.9369622623349921, 0.862569028121421});
    model.component("comp1").geom("geom1").feature("sph100").set("r", 0.009363622755724426);
    model.component("comp1").geom("geom1").create("sph101", "Sphere");
    model.component("comp1").geom("geom1").feature("sph101")
         .set("pos", new double[]{0.33343852565105414, 0.23546343722351504, 0.6133000368857332});
    model.component("comp1").geom("geom1").feature("sph101").set("r", 0.005087461572167966);
    model.component("comp1").geom("geom1").create("sph102", "Sphere");
    model.component("comp1").geom("geom1").feature("sph102")
         .set("pos", new double[]{0.2551586843503828, 0.4289805219962556, 0.06919506975068815});
    model.component("comp1").geom("geom1").feature("sph102").set("r", 0.0012976713232795507);
    model.component("comp1").geom("geom1").create("sph103", "Sphere");
    model.component("comp1").geom("geom1").feature("sph103")
         .set("pos", new double[]{0.30711242490771695, 0.25480407391750964, 0.1334662623266326});
    model.component("comp1").geom("geom1").feature("sph103").set("r", 0.0032674688942148362);
    model.component("comp1").geom("geom1").create("sph104", "Sphere");
    model.component("comp1").geom("geom1").feature("sph104")
         .set("pos", new double[]{0.2797234117911407, 0.618217630007098, 0.9732049518296289});
    model.component("comp1").geom("geom1").feature("sph104").set("r", 0.0011083260060788885);
    model.component("comp1").geom("geom1").create("sph105", "Sphere");
    model.component("comp1").geom("geom1").feature("sph105")
         .set("pos", new double[]{0.35406663644959424, 0.16963676238484557, 0.6360106376211128});
    model.component("comp1").geom("geom1").feature("sph105").set("r", 0.009913105014048046);
    model.component("comp1").geom("geom1").create("sph106", "Sphere");
    model.component("comp1").geom("geom1").feature("sph106")
         .set("pos", new double[]{0.492054340618335, 0.07001000482187968, 0.7801682849674096});
    model.component("comp1").geom("geom1").feature("sph106").set("r", 0.005412748118938635);
    model.component("comp1").geom("geom1").create("sph107", "Sphere");
    model.component("comp1").geom("geom1").feature("sph107")
         .set("pos", new double[]{0.31221415844433115, 0.6613359730532992, 0.24788928854656608});
    model.component("comp1").geom("geom1").feature("sph107").set("r", 0.003595586475983446);
    model.component("comp1").geom("geom1").create("sph108", "Sphere");
    model.component("comp1").geom("geom1").feature("sph108")
         .set("pos", new double[]{0.37908506165433725, 0.42515063916409396, 0.5539229742757984});
    model.component("comp1").geom("geom1").feature("sph108").set("r", 0.00699273205803269);
    model.component("comp1").geom("geom1").create("sph109", "Sphere");
    model.component("comp1").geom("geom1").feature("sph109")
         .set("pos", new double[]{0.4251631706542718, 0.4154670839661302, 0.36154502032371766});
    model.component("comp1").geom("geom1").feature("sph109").set("r", 0.003583463679276668);
    model.component("comp1").geom("geom1").create("sph110", "Sphere");
    model.component("comp1").geom("geom1").feature("sph110")
         .set("pos", new double[]{0.4740530623035382, 0.05368697152336024, 0.23714982768493517});
    model.component("comp1").geom("geom1").feature("sph110").set("r", 0.00845791223100164);
    model.component("comp1").geom("geom1").create("sph111", "Sphere");
    model.component("comp1").geom("geom1").feature("sph111")
         .set("pos", new double[]{0.4511357923453959, 0.9814747877953978, 0.9650917382502229});
    model.component("comp1").geom("geom1").feature("sph111").set("r", 0.004136674325433069);
    model.component("comp1").geom("geom1").create("sph112", "Sphere");
    model.component("comp1").geom("geom1").feature("sph112")
         .set("pos", new double[]{0.3278598630200499, 0.9830128152346872, 0.25400291552126913});
    model.component("comp1").geom("geom1").feature("sph112").set("r", 0.009144535109949344);
    model.component("comp1").geom("geom1").create("sph113", "Sphere");
    model.component("comp1").geom("geom1").feature("sph113")
         .set("pos", new double[]{0.4859765917144601, 0.23446159879999162, 0.68902697125668});
    model.component("comp1").geom("geom1").feature("sph113").set("r", 0.00195315539394009);
    model.component("comp1").geom("geom1").create("sph114", "Sphere");
    model.component("comp1").geom("geom1").feature("sph114")
         .set("pos", new double[]{0.43197351640945614, 0.8805558074778322, 0.27313105725097125});
    model.component("comp1").geom("geom1").feature("sph114").set("r", 0.0015252072308252979);
    model.component("comp1").geom("geom1").create("sph115", "Sphere");
    model.component("comp1").geom("geom1").feature("sph115")
         .set("pos", new double[]{0.3446831336379455, 0.7465931927407466, 0.24012057556466918});
    model.component("comp1").geom("geom1").feature("sph115").set("r", 0.0044115120646968575);
    model.component("comp1").geom("geom1").create("sph116", "Sphere");
    model.component("comp1").geom("geom1").feature("sph116")
         .set("pos", new double[]{0.36258118784633, 0.3054643193453356, 0.837461511381314});
    model.component("comp1").geom("geom1").feature("sph116").set("r", 0.0025466778914287874);
    model.component("comp1").geom("geom1").create("sph117", "Sphere");
    model.component("comp1").geom("geom1").feature("sph117")
         .set("pos", new double[]{0.37558236012557655, 0.9398044611017128, 0.6331562789169847});
    model.component("comp1").geom("geom1").feature("sph117").set("r", 0.003139676434140749);
    model.component("comp1").geom("geom1").create("sph118", "Sphere");
    model.component("comp1").geom("geom1").feature("sph118")
         .set("pos", new double[]{0.47729979736431466, 0.746348589419006, 0.6960603020684075});
    model.component("comp1").geom("geom1").feature("sph118").set("r", 0.008805604649162184);
    model.component("comp1").geom("geom1").create("sph119", "Sphere");
    model.component("comp1").geom("geom1").feature("sph119")
         .set("pos", new double[]{0.48899726290396844, 0.452757468444607, 0.07920493763736453});
    model.component("comp1").geom("geom1").feature("sph119").set("r", 0.009711690099438043);
    model.component("comp1").geom("geom1").create("sph120", "Sphere");
    model.component("comp1").geom("geom1").feature("sph120")
         .set("pos", new double[]{0.2906161594207514, 0.41808627299192025, 0.1339699629274357});
    model.component("comp1").geom("geom1").feature("sph120").set("r", 0.00363514628296467);
    model.component("comp1").geom("geom1").create("sph122", "Sphere");
    model.component("comp1").geom("geom1").feature("sph122")
         .set("pos", new double[]{0.32137286594448616, 0.5911380483013942, 0.8920619475419285});
    model.component("comp1").geom("geom1").feature("sph122").set("r", 0.0059219641150248005);
    model.component("comp1").geom("geom1").create("sph123", "Sphere");
    model.component("comp1").geom("geom1").feature("sph123")
         .set("pos", new double[]{0.3875341371285716, 0.27378123788012354, 0.45585946345420036});
    model.component("comp1").geom("geom1").feature("sph123").set("r", 0.004660600112521735);
    model.component("comp1").geom("geom1").create("sph124", "Sphere");
    model.component("comp1").geom("geom1").feature("sph124")
         .set("pos", new double[]{0.3144257222356944, 0.5058122321535032, 0.31213117092573717});
    model.component("comp1").geom("geom1").feature("sph124").set("r", 0.004615421818416388);
    model.component("comp1").geom("geom1").create("sph125", "Sphere");
    model.component("comp1").geom("geom1").feature("sph125")
         .set("pos", new double[]{0.381025002459565, 0.7484111806383145, 0.33495838621673557});
    model.component("comp1").geom("geom1").feature("sph125").set("r", 0.004357313774926728);
    model.component("comp1").geom("geom1").create("sph126", "Sphere");
    model.component("comp1").geom("geom1").feature("sph126")
         .set("pos", new double[]{0.45882788211068526, 0.057100388133411756, 0.25823336078506026});
    model.component("comp1").geom("geom1").feature("sph126").set("r", 0.009317428899586873);
    model.component("comp1").geom("geom1").create("sph127", "Sphere");
    model.component("comp1").geom("geom1").feature("sph127")
         .set("pos", new double[]{0.28012272811998007, 0.34999584141705903, 0.7376892419782134});
    model.component("comp1").geom("geom1").feature("sph127").set("r", 0.005015219613932818);
    model.component("comp1").geom("geom1").create("sph128", "Sphere");
    model.component("comp1").geom("geom1").feature("sph128")
         .set("pos", new double[]{0.40385221951806916, 0.7075285286355013, 0.20912830625897316});
    model.component("comp1").geom("geom1").feature("sph128").set("r", 0.007124630330285433);
    model.component("comp1").geom("geom1").create("sph129", "Sphere");
    model.component("comp1").geom("geom1").feature("sph129")
         .set("pos", new double[]{0.41762414457365155, 0.8761437850401228, 0.5433220529646666});
    model.component("comp1").geom("geom1").feature("sph129").set("r", 0.004075283033782589);
    model.component("comp1").geom("geom1").create("sph130", "Sphere");
    model.component("comp1").geom("geom1").feature("sph130")
         .set("pos", new double[]{0.2608887859000718, 0.708845836649889, 0.011372513160355943});
    model.component("comp1").geom("geom1").feature("sph130").set("r", 0.00354429685850983);
    model.component("comp1").geom("geom1").create("sph131", "Sphere");
    model.component("comp1").geom("geom1").feature("sph131")
         .set("pos", new double[]{0.3823683787586426, 0.9184356209188794, 0.09306931818287881});
    model.component("comp1").geom("geom1").feature("sph131").set("r", 0.00435411162838896);
    model.component("comp1").geom("geom1").create("sph132", "Sphere");
    model.component("comp1").geom("geom1").feature("sph132")
         .set("pos", new double[]{0.2605054988044269, 0.3440757978973433, 0.621093459044958});
    model.component("comp1").geom("geom1").feature("sph132").set("r", 0.0046534808977145535);
    model.component("comp1").geom("geom1").create("sph133", "Sphere");
    model.component("comp1").geom("geom1").feature("sph133")
         .set("pos", new double[]{0.3044759782630088, 0.11840223524379272, 0.5765984708790582});
    model.component("comp1").geom("geom1").feature("sph133").set("r", 0.0035116115340573855);
    model.component("comp1").geom("geom1").create("sph134", "Sphere");
    model.component("comp1").geom("geom1").feature("sph134")
         .set("pos", new double[]{0.4154933513089305, 0.9423458657975852, 0.009921407175143317});
    model.component("comp1").geom("geom1").feature("sph134").set("r", 0.007257430053142175);
    model.component("comp1").geom("geom1").create("sph135", "Sphere");
    model.component("comp1").geom("geom1").feature("sph135")
         .set("pos", new double[]{0.39872775144153705, 0.5875283551348163, 0.9564537179551645});
    model.component("comp1").geom("geom1").feature("sph135").set("r", 0.006824769885046325);
    model.component("comp1").geom("geom1").create("sph136", "Sphere");
    model.component("comp1").geom("geom1").feature("sph136")
         .set("pos", new double[]{0.42366797304087217, 0.8129560312954831, 0.5097846038796157});
    model.component("comp1").geom("geom1").feature("sph136").set("r", 0.0011518450603303573);
    model.component("comp1").geom("geom1").create("sph137", "Sphere");
    model.component("comp1").geom("geom1").feature("sph137")
         .set("pos", new double[]{0.4453800133310528, 0.10046956062992628, 0.4425000115468276});
    model.component("comp1").geom("geom1").feature("sph137").set("r", 0.004005683826371283);
    model.component("comp1").geom("geom1").create("sph138", "Sphere");
    model.component("comp1").geom("geom1").feature("sph138")
         .set("pos", new double[]{0.421285924176052, 0.0955329194001547, 0.2308519202201205});
    model.component("comp1").geom("geom1").feature("sph138").set("r", 0.005679571371137545);
    model.component("comp1").geom("geom1").create("sph139", "Sphere");
    model.component("comp1").geom("geom1").feature("sph139")
         .set("pos", new double[]{0.4046664949627849, 0.8833289886167833, 0.6177109337795712});
    model.component("comp1").geom("geom1").feature("sph139").set("r", 0.004692714064211131);
    model.component("comp1").geom("geom1").create("sph140", "Sphere");
    model.component("comp1").geom("geom1").feature("sph140")
         .set("pos", new double[]{0.49302937216561593, 0.8701490200073863, 0.5027087835209121});
    model.component("comp1").geom("geom1").feature("sph140").set("r", 0.00220115323841441);
    model.component("comp1").geom("geom1").create("sph141", "Sphere");
    model.component("comp1").geom("geom1").feature("sph141")
         .set("pos", new double[]{0.38457542200284306, 0.9154316168001877, 0.8237605307677728});
    model.component("comp1").geom("geom1").feature("sph141").set("r", 0.009301131836169697);
    model.component("comp1").geom("geom1").create("sph142", "Sphere");
    model.component("comp1").geom("geom1").feature("sph142")
         .set("pos", new double[]{0.47178967723585385, 0.045048288483273045, 0.18109090942774592});
    model.component("comp1").geom("geom1").feature("sph142").set("r", 0.009714577692648677);
    model.component("comp1").geom("geom1").create("sph143", "Sphere");
    model.component("comp1").geom("geom1").feature("sph143")
         .set("pos", new double[]{0.4839643896839815, 0.3018295439102653, 0.16352493724752748});
    model.component("comp1").geom("geom1").feature("sph143").set("r", 0.004502212093910673);
    model.component("comp1").geom("geom1").create("sph144", "Sphere");
    model.component("comp1").geom("geom1").feature("sph144")
         .set("pos", new double[]{0.3625610108741739, 0.9005528064013542, 0.1663305132032042});
    model.component("comp1").geom("geom1").feature("sph144").set("r", 0.00897674199477904);
    model.component("comp1").geom("geom1").create("sph146", "Sphere");
    model.component("comp1").geom("geom1").feature("sph146")
         .set("pos", new double[]{0.26287482344182106, 0.06278405584673148, 0.0639109752194176});
    model.component("comp1").geom("geom1").feature("sph146").set("r", 0.0032265887998523834);
    model.component("comp1").geom("geom1").create("sph147", "Sphere");
    model.component("comp1").geom("geom1").feature("sph147")
         .set("pos", new double[]{0.43057170193430316, 0.8907622147253199, 0.669417290940758});
    model.component("comp1").geom("geom1").feature("sph147").set("r", 0.009169596617365355);
    model.component("comp1").geom("geom1").create("sph148", "Sphere");
    model.component("comp1").geom("geom1").feature("sph148")
         .set("pos", new double[]{0.32836454862909875, 0.9922252687042149, 0.3637767675904276});
    model.component("comp1").geom("geom1").feature("sph148").set("r", 0.005760459361277949);
    model.component("comp1").geom("geom1").create("sph149", "Sphere");
    model.component("comp1").geom("geom1").feature("sph149")
         .set("pos", new double[]{0.34583627142973045, 0.9745054762593806, 0.17806525902710493});
    model.component("comp1").geom("geom1").feature("sph149").set("r", 0.005235840542925186);
    model.component("comp1").geom("geom1").create("sph150", "Sphere");
    model.component("comp1").geom("geom1").feature("sph150")
         .set("pos", new double[]{0.41866172959993175, 0.06665993098326722, 0.6064016981234656});
    model.component("comp1").geom("geom1").feature("sph150").set("r", 0.003951892008172718);
    model.component("comp1").geom("geom1").create("sph151", "Sphere");
    model.component("comp1").geom("geom1").feature("sph151")
         .set("pos", new double[]{0.3232890840399756, 0.24118548203038956, 0.5143589425126509});
    model.component("comp1").geom("geom1").feature("sph151").set("r", 0.005298818525887745);
    model.component("comp1").geom("geom1").create("sph152", "Sphere");
    model.component("comp1").geom("geom1").feature("sph152")
         .set("pos", new double[]{0.3645048885949045, 0.3388787649674919, 0.966436769294617});
    model.component("comp1").geom("geom1").feature("sph152").set("r", 0.004311348224833372);
    model.component("comp1").geom("geom1").create("sph153", "Sphere");
    model.component("comp1").geom("geom1").feature("sph153")
         .set("pos", new double[]{0.2759758209128959, 0.34408110427023664, 0.5906262086660874});
    model.component("comp1").geom("geom1").feature("sph153").set("r", 0.002200954885710436);
    model.component("comp1").geom("geom1").create("sph154", "Sphere");
    model.component("comp1").geom("geom1").feature("sph154")
         .set("pos", new double[]{0.3507387401260214, 0.9923554164172191, 0.35394652594072});
    model.component("comp1").geom("geom1").feature("sph154").set("r", 0.006932588246650255);
    model.component("comp1").geom("geom1").create("sph155", "Sphere");
    model.component("comp1").geom("geom1").feature("sph155")
         .set("pos", new double[]{0.4073339529254892, 0.8083626509221736, 0.9690892694836661});
    model.component("comp1").geom("geom1").feature("sph155").set("r", 0.007492660011639573);
    model.component("comp1").geom("geom1").create("sph156", "Sphere");
    model.component("comp1").geom("geom1").feature("sph156")
         .set("pos", new double[]{0.4363740694433482, 0.6946767765793254, 0.338461881668277});
    model.component("comp1").geom("geom1").feature("sph156").set("r", 0.009008142908009862);
    model.component("comp1").geom("geom1").create("sph157", "Sphere");
    model.component("comp1").geom("geom1").feature("sph157")
         .set("pos", new double[]{0.26769639114478117, 0.2431040139219669, 0.43259693709386277});
    model.component("comp1").geom("geom1").feature("sph157").set("r", 0.0023291702038603663);
    model.component("comp1").geom("geom1").create("sph158", "Sphere");
    model.component("comp1").geom("geom1").feature("sph158")
         .set("pos", new double[]{0.4401588466486952, 0.9535131422673316, 0.12168147052224693});
    model.component("comp1").geom("geom1").feature("sph158").set("r", 0.005697966462669843);
    model.component("comp1").geom("geom1").create("sph159", "Sphere");
    model.component("comp1").geom("geom1").feature("sph159")
         .set("pos", new double[]{0.3970715325864728, 0.7444346228210553, 0.8467835160083618});
    model.component("comp1").geom("geom1").feature("sph159").set("r", 0.001963037261744124);
    model.component("comp1").geom("geom1").create("sph160", "Sphere");
    model.component("comp1").geom("geom1").feature("sph160")
         .set("pos", new double[]{0.48674640393396834, 0.4016899270744719, 0.3825902642948247});
    model.component("comp1").geom("geom1").feature("sph160").set("r", 0.0094224887219511);
    model.component("comp1").geom("geom1").create("sph161", "Sphere");
    model.component("comp1").geom("geom1").feature("sph161")
         .set("pos", new double[]{0.4203717123296865, 0.6560313605265503, 0.8603751827823666});
    model.component("comp1").geom("geom1").feature("sph161").set("r", 0.002330278090275452);
    model.component("comp1").geom("geom1").create("sph162", "Sphere");
    model.component("comp1").geom("geom1").feature("sph162")
         .set("pos", new double[]{0.3744525649834532, 0.5807778202266375, 0.24252636755278717});
    model.component("comp1").geom("geom1").feature("sph162").set("r", 0.0018753219530887658);
    model.component("comp1").geom("geom1").create("sph163", "Sphere");
    model.component("comp1").geom("geom1").feature("sph163")
         .set("pos", new double[]{0.46308203808764853, 0.06076099104418524, 0.47076904675588194});
    model.component("comp1").geom("geom1").feature("sph163").set("r", 0.0025212286551624516);
    model.component("comp1").geom("geom1").create("sph164", "Sphere");
    model.component("comp1").geom("geom1").feature("sph164")
         .set("pos", new double[]{0.3644401058091036, 0.9780016744684142, 0.42401801391891747});
    model.component("comp1").geom("geom1").feature("sph164").set("r", 0.0020425060117079674);
    model.component("comp1").geom("geom1").create("sph165", "Sphere");
    model.component("comp1").geom("geom1").feature("sph165")
         .set("pos", new double[]{0.2859984104960678, 0.2752387524153673, 0.4054694646919392});
    model.component("comp1").geom("geom1").feature("sph165").set("r", 0.008714124257541107);
    model.component("comp1").geom("geom1").create("sph166", "Sphere");
    model.component("comp1").geom("geom1").feature("sph166")
         .set("pos", new double[]{0.41626972119354955, 0.34614619552113246, 0.7118009360689985});
    model.component("comp1").geom("geom1").feature("sph166").set("r", 0.004598309260083977);
    model.component("comp1").geom("geom1").create("sph167", "Sphere");
    model.component("comp1").geom("geom1").feature("sph167")
         .set("pos", new double[]{0.35115215177113246, 0.4326817319823577, 0.6129809615149909});
    model.component("comp1").geom("geom1").feature("sph167").set("r", 0.006752682093028533);
    model.component("comp1").geom("geom1").create("sph168", "Sphere");
    model.component("comp1").geom("geom1").feature("sph168")
         .set("pos", new double[]{0.4545503937789184, 0.6529208916169088, 0.7256044160942494});
    model.component("comp1").geom("geom1").feature("sph168").set("r", 0.0016303797113018017);
    model.component("comp1").geom("geom1").create("sph169", "Sphere");
    model.component("comp1").geom("geom1").feature("sph169")
         .set("pos", new double[]{0.2821629118999714, 0.40614333621343796, 0.40647736348067426});
    model.component("comp1").geom("geom1").feature("sph169").set("r", 0.005832307009741514);
    model.component("comp1").geom("geom1").create("sph170", "Sphere");
    model.component("comp1").geom("geom1").feature("sph170")
         .set("pos", new double[]{0.2611439913332834, 0.7354086955052994, 0.11281985650458479});
    model.component("comp1").geom("geom1").feature("sph170").set("r", 0.0038893869103889525);
    model.component("comp1").geom("geom1").create("sph171", "Sphere");
    model.component("comp1").geom("geom1").feature("sph171")
         .set("pos", new double[]{0.4231801155479371, 0.6330457534991044, 0.9532130972052392});
    model.component("comp1").geom("geom1").feature("sph171").set("r", 0.006456773197405767);
    model.component("comp1").geom("geom1").create("sph172", "Sphere");
    model.component("comp1").geom("geom1").feature("sph172")
         .set("pos", new double[]{0.4653747570355079, 0.03100726242166657, 0.5347820979767136});
    model.component("comp1").geom("geom1").feature("sph172").set("r", 0.0019296833957662476);
    model.component("comp1").geom("geom1").create("sph173", "Sphere");
    model.component("comp1").geom("geom1").feature("sph173")
         .set("pos", new double[]{0.38082162629566846, 0.36635126255352857, 0.19343733540685315});
    model.component("comp1").geom("geom1").feature("sph173").set("r", 0.004638192561453329);
    model.component("comp1").geom("geom1").create("sph174", "Sphere");
    model.component("comp1").geom("geom1").feature("sph174")
         .set("pos", new double[]{0.3794949064337101, 0.8419733209972003, 0.37351316444228017});
    model.component("comp1").geom("geom1").feature("sph174").set("r", 0.001172106077038208);
    model.component("comp1").geom("geom1").create("sph175", "Sphere");
    model.component("comp1").geom("geom1").feature("sph175")
         .set("pos", new double[]{0.2726546531673618, 0.08780384670979768, 0.22307128513063787});
    model.component("comp1").geom("geom1").feature("sph175").set("r", 0.0030057743621348222);
    model.component("comp1").geom("geom1").create("sph176", "Sphere");
    model.component("comp1").geom("geom1").feature("sph176")
         .set("pos", new double[]{0.31715283320498616, 0.06779820396700112, 0.06725567865845387});
    model.component("comp1").geom("geom1").feature("sph176").set("r", 0.0019001265482939968);
    model.component("comp1").geom("geom1").create("sph177", "Sphere");
    model.component("comp1").geom("geom1").feature("sph177")
         .set("pos", new double[]{0.2964135553577699, 0.5586431578077155, 0.7686938709199778});
    model.component("comp1").geom("geom1").feature("sph177").set("r", 0.008706485616605038);
    model.component("comp1").geom("geom1").create("sph178", "Sphere");
    model.component("comp1").geom("geom1").feature("sph178")
         .set("pos", new double[]{0.29188318538532354, 0.20266487933149457, 0.43366879755569543});
    model.component("comp1").geom("geom1").feature("sph178").set("r", 0.0051076860880516);
    model.component("comp1").geom("geom1").create("sph179", "Sphere");
    model.component("comp1").geom("geom1").feature("sph179")
         .set("pos", new double[]{0.3390927462915777, 0.7782402728696507, 0.7481328381018261});
    model.component("comp1").geom("geom1").feature("sph179").set("r", 0.005754106802606822);
    model.component("comp1").geom("geom1").create("sph180", "Sphere");
    model.component("comp1").geom("geom1").feature("sph180")
         .set("pos", new double[]{0.2660419258094401, 0.8882958951566563, 0.39457665766595595});
    model.component("comp1").geom("geom1").feature("sph180").set("r", 0.00934490626635806);
    model.component("comp1").geom("geom1").create("sph181", "Sphere");
    model.component("comp1").geom("geom1").feature("sph181")
         .set("pos", new double[]{0.4192981826883831, 0.9786687321701351, 0.7546644484790277});
    model.component("comp1").geom("geom1").feature("sph181").set("r", 0.008905352458419946);
    model.component("comp1").geom("geom1").create("sph182", "Sphere");
    model.component("comp1").geom("geom1").feature("sph182")
         .set("pos", new double[]{0.3752566905320371, 0.3774474869293613, 0.3660684343050518});
    model.component("comp1").geom("geom1").feature("sph182").set("r", 0.00428090163397108);
    model.component("comp1").geom("geom1").create("sph183", "Sphere");
    model.component("comp1").geom("geom1").feature("sph183")
         .set("pos", new double[]{0.3740195578778488, 0.680522963330277, 0.27883126341348674});
    model.component("comp1").geom("geom1").feature("sph183").set("r", 0.003348140494429538);
    model.component("comp1").geom("geom1").create("sph184", "Sphere");
    model.component("comp1").geom("geom1").feature("sph184")
         .set("pos", new double[]{0.2837217978373289, 0.16373626103637856, 0.051990362768517914});
    model.component("comp1").geom("geom1").feature("sph184").set("r", 0.00571941829969498);
    model.component("comp1").geom("geom1").create("sph185", "Sphere");
    model.component("comp1").geom("geom1").feature("sph185")
         .set("pos", new double[]{0.2606264975968396, 0.18483903368571092, 0.6106688801010647});
    model.component("comp1").geom("geom1").feature("sph185").set("r", 0.009736582984935696);
    model.component("comp1").geom("geom1").create("sph186", "Sphere");
    model.component("comp1").geom("geom1").feature("sph186")
         .set("pos", new double[]{0.46915098699332597, 0.7188592502520166, 0.9647740921270858});
    model.component("comp1").geom("geom1").feature("sph186").set("r", 0.0017323263896797478);
    model.component("comp1").geom("geom1").create("sph187", "Sphere");
    model.component("comp1").geom("geom1").feature("sph187")
         .set("pos", new double[]{0.3273239127627923, 0.5489492631432069, 0.926020499747669});
    model.component("comp1").geom("geom1").feature("sph187").set("r", 0.005568719925166885);
    model.component("comp1").geom("geom1").create("sph188", "Sphere");
    model.component("comp1").geom("geom1").feature("sph188")
         .set("pos", new double[]{0.3194494767138642, 0.8731063663502256, 0.3733755069943874});
    model.component("comp1").geom("geom1").feature("sph188").set("r", 0.005686852935176745);
    model.component("comp1").geom("geom1").create("sph189", "Sphere");
    model.component("comp1").geom("geom1").feature("sph189")
         .set("pos", new double[]{0.31243216829672427, 0.31860156819885643, 0.8580509796288526});
    model.component("comp1").geom("geom1").feature("sph189").set("r", 0.0010124501499909923);
    model.component("comp1").geom("geom1").create("sph190", "Sphere");
    model.component("comp1").geom("geom1").feature("sph190")
         .set("pos", new double[]{0.3617149716498193, 0.3377827192058396, 0.8767750085500855});
    model.component("comp1").geom("geom1").feature("sph190").set("r", 0.005126528503598005);
    model.component("comp1").geom("geom1").create("sph191", "Sphere");
    model.component("comp1").geom("geom1").feature("sph191")
         .set("pos", new double[]{0.48862151004770343, 0.37908447488490987, 0.9572857580097562});
    model.component("comp1").geom("geom1").feature("sph191").set("r", 0.009505240992463523);
    model.component("comp1").geom("geom1").create("sph192", "Sphere");
    model.component("comp1").geom("geom1").feature("sph192")
         .set("pos", new double[]{0.4160666649765216, 0.24903600302767154, 0.2210659170614798});
    model.component("comp1").geom("geom1").feature("sph192").set("r", 0.008126916126678114);
    model.component("comp1").geom("geom1").create("sph193", "Sphere");
    model.component("comp1").geom("geom1").feature("sph193")
         .set("pos", new double[]{0.47858007865815244, 0.2951039852585295, 0.453328251730994});
    model.component("comp1").geom("geom1").feature("sph193").set("r", 0.002494430420691211);
    model.component("comp1").geom("geom1").create("sph194", "Sphere");
    model.component("comp1").geom("geom1").feature("sph194")
         .set("pos", new double[]{0.4415132649738862, 0.8404858156220728, 0.14300364734813042});
    model.component("comp1").geom("geom1").feature("sph194").set("r", 0.005445620505885012);
    model.component("comp1").geom("geom1").create("sph195", "Sphere");
    model.component("comp1").geom("geom1").feature("sph195")
         .set("pos", new double[]{0.45739341974553394, 0.8149533826557755, 0.1062640943368903});
    model.component("comp1").geom("geom1").feature("sph195").set("r", 0.004842139241899664);
    model.component("comp1").geom("geom1").create("sph196", "Sphere");
    model.component("comp1").geom("geom1").feature("sph196")
         .set("pos", new double[]{0.3269924366744206, 0.07740367282035047, 0.4250257429692817});
    model.component("comp1").geom("geom1").feature("sph196").set("r", 0.0024074501398116672);
    model.component("comp1").geom("geom1").create("sph197", "Sphere");
    model.component("comp1").geom("geom1").feature("sph197")
         .set("pos", new double[]{0.3917858176542532, 0.2475547752209588, 0.5960533969254411});
    model.component("comp1").geom("geom1").feature("sph197").set("r", 0.001968559346346237);
    model.component("comp1").geom("geom1").create("sph198", "Sphere");
    model.component("comp1").geom("geom1").feature("sph198")
         .set("pos", new double[]{0.4920124853312959, 0.9307810148452126, 0.3922422441060044});
    model.component("comp1").geom("geom1").feature("sph198").set("r", 0.002057730786132739);
    model.component("comp1").geom("geom1").create("sph199", "Sphere");
    model.component("comp1").geom("geom1").feature("sph199")
         .set("pos", new double[]{0.3141868245659307, 0.48349913927735283, 0.04291808643433968});
    model.component("comp1").geom("geom1").feature("sph199").set("r", 0.0031796073471347694);
    model.component("comp1").geom("geom1").create("sph200", "Sphere");
    model.component("comp1").geom("geom1").feature("sph200")
         .set("pos", new double[]{0.3533149850277082, 0.37906338499046005, 0.8051839992119764});
    model.component("comp1").geom("geom1").feature("sph200").set("r", 0.006757345954676143);
    model.component("comp1").geom("geom1").create("sph201", "Sphere");
    model.component("comp1").geom("geom1").feature("sph201")
         .set("pos", new double[]{0.4818762880716595, 0.3541220522201183, 0.8916739846127436});

    return model;
  }

  public static Model run3(Model model) {
    model.component("comp1").geom("geom1").feature("sph201").set("r", 0.00738131914164961);
    model.component("comp1").geom("geom1").create("sph202", "Sphere");
    model.component("comp1").geom("geom1").feature("sph202")
         .set("pos", new double[]{0.3416173237126133, 0.6197358944924948, 0.2919231132427141});
    model.component("comp1").geom("geom1").feature("sph202").set("r", 0.007929704676250801);
    model.component("comp1").geom("geom1").create("sph203", "Sphere");
    model.component("comp1").geom("geom1").feature("sph203")
         .set("pos", new double[]{0.28498205805907373, 0.2175355452429381, 0.18865602743193574});
    model.component("comp1").geom("geom1").feature("sph203").set("r", 0.008869599253673581);
    model.component("comp1").geom("geom1").create("sph204", "Sphere");
    model.component("comp1").geom("geom1").feature("sph204")
         .set("pos", new double[]{0.43403873941625665, 0.5266584349248008, 0.4877903726081989});
    model.component("comp1").geom("geom1").feature("sph204").set("r", 0.004627234021638598);
    model.component("comp1").geom("geom1").create("sph205", "Sphere");
    model.component("comp1").geom("geom1").feature("sph205")
         .set("pos", new double[]{0.35650036099276156, 0.0644309564042167, 0.20883961271993765});
    model.component("comp1").geom("geom1").feature("sph205").set("r", 0.001004913684072961);
    model.component("comp1").geom("geom1").create("sph206", "Sphere");
    model.component("comp1").geom("geom1").feature("sph206")
         .set("pos", new double[]{0.3091952524843006, 0.8516069501944419, 0.7972040978298998});
    model.component("comp1").geom("geom1").feature("sph206").set("r", 0.00939154545064445);
    model.component("comp1").geom("geom1").create("sph207", "Sphere");
    model.component("comp1").geom("geom1").feature("sph207")
         .set("pos", new double[]{0.4009137395194406, 0.11753153556359866, 0.7267795662815048});
    model.component("comp1").geom("geom1").feature("sph207").set("r", 0.002432316132480186);
    model.component("comp1").geom("geom1").create("sph208", "Sphere");
    model.component("comp1").geom("geom1").feature("sph208")
         .set("pos", new double[]{0.448781480112529, 0.4796623285881273, 0.9092730894198933});
    model.component("comp1").geom("geom1").feature("sph208").set("r", 0.00673716049634986);
    model.component("comp1").geom("geom1").create("sph209", "Sphere");
    model.component("comp1").geom("geom1").feature("sph209")
         .set("pos", new double[]{0.3238203372880073, 0.7144314651248342, 0.41834573535923925});
    model.component("comp1").geom("geom1").feature("sph209").set("r", 0.0014441405210959574);
    model.component("comp1").geom("geom1").create("sph210", "Sphere");
    model.component("comp1").geom("geom1").feature("sph210")
         .set("pos", new double[]{0.27881106666966265, 0.8157165171150692, 0.473280301757142});
    model.component("comp1").geom("geom1").feature("sph210").set("r", 0.0025565621884404074);
    model.component("comp1").geom("geom1").create("sph211", "Sphere");
    model.component("comp1").geom("geom1").feature("sph211")
         .set("pos", new double[]{0.4291508158177598, 0.4113404009254173, 0.37577277713135715});
    model.component("comp1").geom("geom1").feature("sph211").set("r", 0.008940553047271968);
    model.component("comp1").geom("geom1").create("sph212", "Sphere");
    model.component("comp1").geom("geom1").feature("sph212")
         .set("pos", new double[]{0.46787581223285535, 0.7346017237330272, 0.010735576272777872});
    model.component("comp1").geom("geom1").feature("sph212").set("r", 0.005640745119861266);
    model.component("comp1").geom("geom1").create("sph213", "Sphere");
    model.component("comp1").geom("geom1").feature("sph213")
         .set("pos", new double[]{0.4737961584288423, 0.7074052366646164, 0.18168753151245254});
    model.component("comp1").geom("geom1").feature("sph213").set("r", 0.00724742066232213);
    model.component("comp1").geom("geom1").create("sph214", "Sphere");
    model.component("comp1").geom("geom1").feature("sph214")
         .set("pos", new double[]{0.2889288195036358, 0.36050449788451455, 0.9324384356120938});
    model.component("comp1").geom("geom1").feature("sph214").set("r", 0.005351663146847129);
    model.component("comp1").geom("geom1").create("sph215", "Sphere");
    model.component("comp1").geom("geom1").feature("sph215")
         .set("pos", new double[]{0.3247526813055242, 0.3426170332234687, 0.5983469550804679});
    model.component("comp1").geom("geom1").feature("sph215").set("r", 0.009309747768028377);
    model.component("comp1").geom("geom1").create("sph216", "Sphere");
    model.component("comp1").geom("geom1").feature("sph216")
         .set("pos", new double[]{0.29376099329182237, 0.26161728056312444, 0.8663331529740845});
    model.component("comp1").geom("geom1").feature("sph216").set("r", 0.00966877565734342);
    model.component("comp1").geom("geom1").create("sph217", "Sphere");
    model.component("comp1").geom("geom1").feature("sph217")
         .set("pos", new double[]{0.4704099253559375, 0.18893130518608375, 0.5323140006572532});
    model.component("comp1").geom("geom1").feature("sph217").set("r", 0.005427030085375101);
    model.component("comp1").geom("geom1").create("sph218", "Sphere");
    model.component("comp1").geom("geom1").feature("sph218")
         .set("pos", new double[]{0.3305799735019663, 0.4472951938205596, 0.43360432053282427});
    model.component("comp1").geom("geom1").feature("sph218").set("r", 0.003936426693844352);
    model.component("comp1").geom("geom1").create("sph219", "Sphere");
    model.component("comp1").geom("geom1").feature("sph219")
         .set("pos", new double[]{0.4752435578595362, 0.7297900619541638, 0.7256282596168829});
    model.component("comp1").geom("geom1").feature("sph219").set("r", 0.004216121917101591);
    model.component("comp1").geom("geom1").create("sph220", "Sphere");
    model.component("comp1").geom("geom1").feature("sph220")
         .set("pos", new double[]{0.39386641509972536, 0.7771641927290844, 0.7934566665847372});
    model.component("comp1").geom("geom1").feature("sph220").set("r", 0.003609221046327599);
    model.component("comp1").geom("geom1").create("sph221", "Sphere");
    model.component("comp1").geom("geom1").feature("sph221")
         .set("pos", new double[]{0.44049661314774974, 0.7339592016209041, 0.1444466874930066});
    model.component("comp1").geom("geom1").feature("sph221").set("r", 0.004100774146788811);
    model.component("comp1").geom("geom1").create("sph222", "Sphere");
    model.component("comp1").geom("geom1").feature("sph222")
         .set("pos", new double[]{0.3613623479307314, 0.486649448574573, 0.44927721110049096});
    model.component("comp1").geom("geom1").feature("sph222").set("r", 0.008793509217098296);
    model.component("comp1").geom("geom1").create("sph223", "Sphere");
    model.component("comp1").geom("geom1").feature("sph223")
         .set("pos", new double[]{0.40381147483987995, 0.4982018137048619, 0.8623059368343836});
    model.component("comp1").geom("geom1").feature("sph223").set("r", 0.006110614013297568);
    model.component("comp1").geom("geom1").create("sph224", "Sphere");
    model.component("comp1").geom("geom1").feature("sph224")
         .set("pos", new double[]{0.3516679192675556, 0.41779969202888095, 0.8067047022575806});
    model.component("comp1").geom("geom1").feature("sph224").set("r", 0.0066496128057575606);
    model.component("comp1").geom("geom1").create("sph225", "Sphere");
    model.component("comp1").geom("geom1").feature("sph225")
         .set("pos", new double[]{0.3052492334281194, 0.06302596765772842, 0.8729180628880913});
    model.component("comp1").geom("geom1").feature("sph225").set("r", 0.004133727484718681);
    model.component("comp1").geom("geom1").create("sph226", "Sphere");
    model.component("comp1").geom("geom1").feature("sph226")
         .set("pos", new double[]{0.28707067583048845, 0.3375415780450187, 0.1813886703792861});
    model.component("comp1").geom("geom1").feature("sph226").set("r", 0.009266918060713149);
    model.component("comp1").geom("geom1").create("sph227", "Sphere");
    model.component("comp1").geom("geom1").feature("sph227")
         .set("pos", new double[]{0.4733327612855418, 0.0586879350760704, 0.9785223161936696});
    model.component("comp1").geom("geom1").feature("sph227").set("r", 0.0020430862194329175);
    model.component("comp1").geom("geom1").create("sph228", "Sphere");
    model.component("comp1").geom("geom1").feature("sph228")
         .set("pos", new double[]{0.46450969397485603, 0.5662576324924911, 0.36841096333793233});
    model.component("comp1").geom("geom1").feature("sph228").set("r", 0.0018680577462764577);
    model.component("comp1").geom("geom1").create("sph229", "Sphere");
    model.component("comp1").geom("geom1").feature("sph229")
         .set("pos", new double[]{0.43724038777877805, 0.31608677795408274, 0.6560348540114569});
    model.component("comp1").geom("geom1").feature("sph229").set("r", 0.004081081389626422);
    model.component("comp1").geom("geom1").create("sph230", "Sphere");
    model.component("comp1").geom("geom1").feature("sph230")
         .set("pos", new double[]{0.37141147794955565, 0.896624276525122, 0.5540269208481476});
    model.component("comp1").geom("geom1").feature("sph230").set("r", 0.005655934751644722);
    model.component("comp1").geom("geom1").create("sph231", "Sphere");
    model.component("comp1").geom("geom1").feature("sph231")
         .set("pos", new double[]{0.4275849107649441, 0.046348018881179856, 0.7684989965155881});
    model.component("comp1").geom("geom1").feature("sph231").set("r", 0.008441754427438254);
    model.component("comp1").geom("geom1").create("sph232", "Sphere");
    model.component("comp1").geom("geom1").feature("sph232")
         .set("pos", new double[]{0.47340735145392704, 0.04562261283929245, 0.3340575211787235});
    model.component("comp1").geom("geom1").feature("sph232").set("r", 0.0029518322508193663);
    model.component("comp1").geom("geom1").create("sph233", "Sphere");
    model.component("comp1").geom("geom1").feature("sph233")
         .set("pos", new double[]{0.3689899232844004, 0.8188078889452226, 0.2989532775931185});
    model.component("comp1").geom("geom1").feature("sph233").set("r", 0.0018975965251127862);
    model.component("comp1").geom("geom1").create("sph234", "Sphere");
    model.component("comp1").geom("geom1").feature("sph234")
         .set("pos", new double[]{0.333367360148504, 0.8123996232309969, 0.14208020487096543});
    model.component("comp1").geom("geom1").feature("sph234").set("r", 0.0023584140757993742);
    model.component("comp1").geom("geom1").create("sph235", "Sphere");
    model.component("comp1").geom("geom1").feature("sph235")
         .set("pos", new double[]{0.26983977091317607, 0.7044567505924048, 0.39587153752323084});
    model.component("comp1").geom("geom1").feature("sph235").set("r", 0.0030462620416975166);
    model.component("comp1").geom("geom1").create("sph236", "Sphere");
    model.component("comp1").geom("geom1").feature("sph236")
         .set("pos", new double[]{0.4279961040054274, 0.33722331252139376, 0.7260413231555115});
    model.component("comp1").geom("geom1").feature("sph236").set("r", 0.0037975597942898447);
    model.component("comp1").geom("geom1").create("sph237", "Sphere");
    model.component("comp1").geom("geom1").feature("sph237")
         .set("pos", new double[]{0.3091232846047034, 0.9659184385794571, 0.16798765275733846});
    model.component("comp1").geom("geom1").feature("sph237").set("r", 0.008336794557828823);
    model.component("comp1").geom("geom1").create("sph238", "Sphere");
    model.component("comp1").geom("geom1").feature("sph238")
         .set("pos", new double[]{0.29726554742945344, 0.34662344399323775, 0.4802051500154687});
    model.component("comp1").geom("geom1").feature("sph238").set("r", 0.0036175681599106835);
    model.component("comp1").geom("geom1").create("sph239", "Sphere");
    model.component("comp1").geom("geom1").feature("sph239")
         .set("pos", new double[]{0.45937069672590725, 0.8850085275943291, 0.2232944432344318});
    model.component("comp1").geom("geom1").feature("sph239").set("r", 0.005699582821019072);
    model.component("comp1").geom("geom1").create("sph240", "Sphere");
    model.component("comp1").geom("geom1").feature("sph240")
         .set("pos", new double[]{0.28300696438308826, 0.45951195418788626, 0.3246808837901906});
    model.component("comp1").geom("geom1").feature("sph240").set("r", 0.006606046289671773);
    model.component("comp1").geom("geom1").create("sph241", "Sphere");
    model.component("comp1").geom("geom1").feature("sph241")
         .set("pos", new double[]{0.3707801097532547, 0.7280586491347337, 0.07249866564844261});
    model.component("comp1").geom("geom1").feature("sph241").set("r", 0.003848506709082458);
    model.component("comp1").geom("geom1").create("sph242", "Sphere");
    model.component("comp1").geom("geom1").feature("sph242")
         .set("pos", new double[]{0.42951785992879443, 0.18226582612753978, 0.9313328131491605});
    model.component("comp1").geom("geom1").feature("sph242").set("r", 0.00891256003918664);
    model.component("comp1").geom("geom1").create("sph243", "Sphere");
    model.component("comp1").geom("geom1").feature("sph243")
         .set("pos", new double[]{0.4943974619031048, 0.20062401747177463, 0.5345202419303541});
    model.component("comp1").geom("geom1").feature("sph243").set("r", 0.005556810016210498);
    model.component("comp1").geom("geom1").create("sph244", "Sphere");
    model.component("comp1").geom("geom1").feature("sph244")
         .set("pos", new double[]{0.32745813058221956, 0.5904074821987454, 0.9186723723310413});
    model.component("comp1").geom("geom1").feature("sph244").set("r", 0.0036122323830393563);
    model.component("comp1").geom("geom1").create("sph245", "Sphere");
    model.component("comp1").geom("geom1").feature("sph245")
         .set("pos", new double[]{0.42729149237667136, 0.5581977253948592, 0.9153327956772785});
    model.component("comp1").geom("geom1").feature("sph245").set("r", 0.008247374700212577);
    model.component("comp1").geom("geom1").create("sph246", "Sphere");
    model.component("comp1").geom("geom1").feature("sph246")
         .set("pos", new double[]{0.4643972905575685, 0.8303537664930939, 0.21694381186947503});
    model.component("comp1").geom("geom1").feature("sph246").set("r", 0.005431252660217958);
    model.component("comp1").geom("geom1").create("sph247", "Sphere");
    model.component("comp1").geom("geom1").feature("sph247")
         .set("pos", new double[]{0.2607905153779503, 0.3256433691677018, 0.23386247031059898});
    model.component("comp1").geom("geom1").feature("sph247").set("r", 0.007941029166693193);
    model.component("comp1").geom("geom1").create("sph248", "Sphere");
    model.component("comp1").geom("geom1").feature("sph248")
         .set("pos", new double[]{0.43157864640021604, 0.10215162775279525, 0.5147562143273202});
    model.component("comp1").geom("geom1").feature("sph248").set("r", 0.005561766626385822);
    model.component("comp1").geom("geom1").create("sph249", "Sphere");
    model.component("comp1").geom("geom1").feature("sph249")
         .set("pos", new double[]{0.3122878887401156, 0.6737946969981258, 0.5911256309113684});
    model.component("comp1").geom("geom1").feature("sph249").set("r", 0.009445708195249473);
    model.component("comp1").geom("geom1").create("sph250", "Sphere");
    model.component("comp1").geom("geom1").feature("sph250")
         .set("pos", new double[]{0.3690092755731306, 0.7083150321289908, 0.044970088424391014});
    model.component("comp1").geom("geom1").feature("sph250").set("r", 0.00109057326090484);
    model.component("comp1").geom("geom1").create("sph251", "Sphere");
    model.component("comp1").geom("geom1").feature("sph251")
         .set("pos", new double[]{0.3796622746535157, 0.0390300126637791, 0.22932769937440015});
    model.component("comp1").geom("geom1").feature("sph251").set("r", 0.008915693347213573);
    model.component("comp1").geom("geom1").create("sph252", "Sphere");
    model.component("comp1").geom("geom1").feature("sph252")
         .set("pos", new double[]{0.39400217987944336, 0.11499581233466533, 0.2916164588814535});
    model.component("comp1").geom("geom1").feature("sph252").set("r", 0.009583081267845819);
    model.component("comp1").geom("geom1").create("sph253", "Sphere");
    model.component("comp1").geom("geom1").feature("sph253")
         .set("pos", new double[]{0.2601337263044027, 0.41251886186377473, 0.4895663751933616});
    model.component("comp1").geom("geom1").feature("sph253").set("r", 0.005110332632744358);
    model.component("comp1").geom("geom1").create("sph254", "Sphere");
    model.component("comp1").geom("geom1").feature("sph254")
         .set("pos", new double[]{0.396593683533765, 0.7516228770959851, 0.23752124004727942});
    model.component("comp1").geom("geom1").feature("sph254").set("r", 0.00319310087753109);
    model.component("comp1").geom("geom1").create("sph255", "Sphere");
    model.component("comp1").geom("geom1").feature("sph255")
         .set("pos", new double[]{0.40806687567396227, 0.9426334747083873, 0.7746115489488116});
    model.component("comp1").geom("geom1").feature("sph255").set("r", 0.00658449910251989);
    model.component("comp1").geom("geom1").create("sph256", "Sphere");
    model.component("comp1").geom("geom1").feature("sph256")
         .set("pos", new double[]{0.3727704273487166, 0.19078268448706212, 0.9872524563212223});
    model.component("comp1").geom("geom1").feature("sph256").set("r", 0.008635107428110054);
    model.component("comp1").geom("geom1").create("sph257", "Sphere");
    model.component("comp1").geom("geom1").feature("sph257")
         .set("pos", new double[]{0.36798787408304406, 0.06996256666883964, 0.9419296916581926});
    model.component("comp1").geom("geom1").feature("sph257").set("r", 0.0021642018493482967);
    model.component("comp1").geom("geom1").create("sph258", "Sphere");
    model.component("comp1").geom("geom1").feature("sph258")
         .set("pos", new double[]{0.4255979957787998, 0.3528982795796746, 0.2591396821627015});
    model.component("comp1").geom("geom1").feature("sph258").set("r", 0.009684324467635959);
    model.component("comp1").geom("geom1").create("sph259", "Sphere");
    model.component("comp1").geom("geom1").feature("sph259")
         .set("pos", new double[]{0.28434876071853427, 0.5256340855515962, 0.14424412836594097});
    model.component("comp1").geom("geom1").feature("sph259").set("r", 0.0033877299208334272);
    model.component("comp1").geom("geom1").create("sph260", "Sphere");
    model.component("comp1").geom("geom1").feature("sph260")
         .set("pos", new double[]{0.405700833159289, 0.7257912616671265, 0.02793635283334619});
    model.component("comp1").geom("geom1").feature("sph260").set("r", 0.0038505759989811068);
    model.component("comp1").geom("geom1").create("sph261", "Sphere");
    model.component("comp1").geom("geom1").feature("sph261")
         .set("pos", new double[]{0.4115491375633985, 0.84980462287247, 0.47556517034825235});
    model.component("comp1").geom("geom1").feature("sph261").set("r", 0.00487104385939066);
    model.component("comp1").geom("geom1").create("sph262", "Sphere");
    model.component("comp1").geom("geom1").feature("sph262")
         .set("pos", new double[]{0.3209655773894011, 0.02296887313884992, 0.48406880171306677});
    model.component("comp1").geom("geom1").feature("sph262").set("r", 0.009722852845459169);
    model.component("comp1").geom("geom1").create("sph263", "Sphere");
    model.component("comp1").geom("geom1").feature("sph263")
         .set("pos", new double[]{0.4537896285548018, 0.23453905772784345, 0.31188096830697143});
    model.component("comp1").geom("geom1").feature("sph263").set("r", 0.003305024155180162);
    model.component("comp1").geom("geom1").create("sph264", "Sphere");
    model.component("comp1").geom("geom1").feature("sph264")
         .set("pos", new double[]{0.4252914361354691, 0.5571083630286875, 0.7016192762854191});
    model.component("comp1").geom("geom1").feature("sph264").set("r", 0.008121046879172013);
    model.component("comp1").geom("geom1").create("sph265", "Sphere");
    model.component("comp1").geom("geom1").feature("sph265")
         .set("pos", new double[]{0.2560446099103492, 0.01601458387035439, 0.5111147826273763});
    model.component("comp1").geom("geom1").feature("sph265").set("r", 0.004767731772130239);
    model.component("comp1").geom("geom1").create("sph266", "Sphere");
    model.component("comp1").geom("geom1").feature("sph266")
         .set("pos", new double[]{0.2643397636173542, 0.9638876857941119, 0.8577464041103237});
    model.component("comp1").geom("geom1").feature("sph266").set("r", 0.0017496188174709933);
    model.component("comp1").geom("geom1").create("sph267", "Sphere");
    model.component("comp1").geom("geom1").feature("sph267")
         .set("pos", new double[]{0.2525311536276673, 0.9395758402539213, 0.2793752583477743});
    model.component("comp1").geom("geom1").feature("sph267").set("r", 0.002368245044886126);
    model.component("comp1").geom("geom1").create("sph268", "Sphere");
    model.component("comp1").geom("geom1").feature("sph268")
         .set("pos", new double[]{0.4218531945751018, 0.11099460079747617, 0.2659078181669171});
    model.component("comp1").geom("geom1").feature("sph268").set("r", 0.002673078425699478);
    model.component("comp1").geom("geom1").create("sph269", "Sphere");
    model.component("comp1").geom("geom1").feature("sph269")
         .set("pos", new double[]{0.4071389586989646, 0.5202735054190714, 0.39991447988648415});
    model.component("comp1").geom("geom1").feature("sph269").set("r", 0.009775852121908419);
    model.component("comp1").geom("geom1").create("sph270", "Sphere");
    model.component("comp1").geom("geom1").feature("sph270")
         .set("pos", new double[]{0.2909628721688518, 0.959887962102148, 0.8553663399872582});
    model.component("comp1").geom("geom1").feature("sph270").set("r", 0.007970508593957818);
    model.component("comp1").geom("geom1").create("sph271", "Sphere");
    model.component("comp1").geom("geom1").feature("sph271")
         .set("pos", new double[]{0.2667226245172011, 0.6982208600501844, 0.9078629489428898});
    model.component("comp1").geom("geom1").feature("sph271").set("r", 0.00655891284312319);
    model.component("comp1").geom("geom1").create("sph272", "Sphere");
    model.component("comp1").geom("geom1").feature("sph272")
         .set("pos", new double[]{0.3402242214917477, 0.12462227863237631, 0.7519844270025933});
    model.component("comp1").geom("geom1").feature("sph272").set("r", 0.005721193607307634);
    model.component("comp1").geom("geom1").create("sph273", "Sphere");
    model.component("comp1").geom("geom1").feature("sph273")
         .set("pos", new double[]{0.2822305794773908, 0.7543408598213579, 0.02571978169111677});
    model.component("comp1").geom("geom1").feature("sph273").set("r", 0.008965196660906258);
    model.component("comp1").geom("geom1").create("sph274", "Sphere");
    model.component("comp1").geom("geom1").feature("sph274")
         .set("pos", new double[]{0.40153157547255464, 0.5514213747755004, 0.2999098328270714});
    model.component("comp1").geom("geom1").feature("sph274").set("r", 0.009703494262694977);
    model.component("comp1").geom("geom1").create("sph275", "Sphere");
    model.component("comp1").geom("geom1").feature("sph275")
         .set("pos", new double[]{0.3208603506953151, 0.8220013295253715, 0.9760239277792018});
    model.component("comp1").geom("geom1").feature("sph275").set("r", 0.009363625044128052);
    model.component("comp1").geom("geom1").create("sph276", "Sphere");
    model.component("comp1").geom("geom1").feature("sph276")
         .set("pos", new double[]{0.37944172073710725, 0.07306096271378916, 0.47285795860319607});
    model.component("comp1").geom("geom1").feature("sph276").set("r", 0.008050569809633253);
    model.component("comp1").geom("geom1").create("sph277", "Sphere");
    model.component("comp1").geom("geom1").feature("sph277")
         .set("pos", new double[]{0.3036379434578148, 0.42434324854825395, 0.35916446046998735});
    model.component("comp1").geom("geom1").feature("sph277").set("r", 0.004944303522745333);
    model.component("comp1").geom("geom1").create("sph278", "Sphere");
    model.component("comp1").geom("geom1").feature("sph278")
         .set("pos", new double[]{0.3606335178870506, 0.26397322286193503, 0.5219532929623852});
    model.component("comp1").geom("geom1").feature("sph278").set("r", 0.0024731583503648366);
    model.component("comp1").geom("geom1").create("sph279", "Sphere");
    model.component("comp1").geom("geom1").feature("sph279")
         .set("pos", new double[]{0.4754882959296368, 0.8155313559270817, 0.5524428921152451});
    model.component("comp1").geom("geom1").feature("sph279").set("r", 0.0013164405374457477);
    model.component("comp1").geom("geom1").create("sph280", "Sphere");
    model.component("comp1").geom("geom1").feature("sph280")
         .set("pos", new double[]{0.4825842806401377, 0.11727293761348906, 0.628564158961564});
    model.component("comp1").geom("geom1").feature("sph280").set("r", 0.008666277244815189);
    model.component("comp1").geom("geom1").create("sph281", "Sphere");
    model.component("comp1").geom("geom1").feature("sph281")
         .set("pos", new double[]{0.48723212564062035, 0.6012602632297952, 0.1354470216256554});
    model.component("comp1").geom("geom1").feature("sph281").set("r", 0.009981946008420929);
    model.component("comp1").geom("geom1").create("sph282", "Sphere");
    model.component("comp1").geom("geom1").feature("sph282")
         .set("pos", new double[]{0.25673909164939035, 0.20267418151759217, 0.950422773620166});
    model.component("comp1").geom("geom1").feature("sph282").set("r", 0.006248735478914754);
    model.component("comp1").geom("geom1").create("sph283", "Sphere");
    model.component("comp1").geom("geom1").feature("sph283")
         .set("pos", new double[]{0.40849761152836417, 0.2826012080963138, 0.9442626299629441});
    model.component("comp1").geom("geom1").feature("sph283").set("r", 0.003973965153425595);
    model.component("comp1").geom("geom1").create("sph284", "Sphere");
    model.component("comp1").geom("geom1").feature("sph284")
         .set("pos", new double[]{0.33498745153324566, 0.7873517223896684, 0.11408773312846794});
    model.component("comp1").geom("geom1").feature("sph284").set("r", 0.007557028569545382);
    model.component("comp1").geom("geom1").create("sph285", "Sphere");
    model.component("comp1").geom("geom1").feature("sph285")
         .set("pos", new double[]{0.3078307810329154, 0.6820615658104622, 0.10604881056876425});
    model.component("comp1").geom("geom1").feature("sph285").set("r", 0.004530870460589136);
    model.component("comp1").geom("geom1").create("sph286", "Sphere");
    model.component("comp1").geom("geom1").feature("sph286")
         .set("pos", new double[]{0.32120529797345565, 0.5062849040343311, 0.3512705861127303});
    model.component("comp1").geom("geom1").feature("sph286").set("r", 0.004573232490544067);
    model.component("comp1").geom("geom1").create("sph287", "Sphere");
    model.component("comp1").geom("geom1").feature("sph287")
         .set("pos", new double[]{0.2631402907682463, 0.6320152514506642, 0.23453603835040676});
    model.component("comp1").geom("geom1").feature("sph287").set("r", 0.0073576951990031);
    model.component("comp1").geom("geom1").create("sph288", "Sphere");
    model.component("comp1").geom("geom1").feature("sph288")
         .set("pos", new double[]{0.4480111246395947, 0.9524537810602416, 0.3178044126750393});
    model.component("comp1").geom("geom1").feature("sph288").set("r", 0.0034183812588116443);
    model.component("comp1").geom("geom1").create("sph289", "Sphere");
    model.component("comp1").geom("geom1").feature("sph289")
         .set("pos", new double[]{0.2826833321379027, 0.6317197084382616, 0.7467942480266588});
    model.component("comp1").geom("geom1").feature("sph289").set("r", 0.008441247433321683);
    model.component("comp1").geom("geom1").create("sph290", "Sphere");
    model.component("comp1").geom("geom1").feature("sph290")
         .set("pos", new double[]{0.3568563480385654, 0.8908191842240144, 0.1054843006996675});
    model.component("comp1").geom("geom1").feature("sph290").set("r", 0.0024038013523101087);
    model.component("comp1").geom("geom1").create("sph291", "Sphere");
    model.component("comp1").geom("geom1").feature("sph291")
         .set("pos", new double[]{0.39743566722548035, 0.4356814770479061, 0.7979945770086377});
    model.component("comp1").geom("geom1").feature("sph291").set("r", 0.0011628672238132764);
    model.component("comp1").geom("geom1").create("sph292", "Sphere");
    model.component("comp1").geom("geom1").feature("sph292")
         .set("pos", new double[]{0.3285286120738006, 0.39048227798350443, 0.48652773027898555});
    model.component("comp1").geom("geom1").feature("sph292").set("r", 0.009311099843836962);
    model.component("comp1").geom("geom1").create("sph293", "Sphere");
    model.component("comp1").geom("geom1").feature("sph293")
         .set("pos", new double[]{0.4898733217028808, 0.6948465089745437, 0.390938730051693});
    model.component("comp1").geom("geom1").feature("sph293").set("r", 0.006293363143917694);
    model.component("comp1").geom("geom1").create("sph294", "Sphere");
    model.component("comp1").geom("geom1").feature("sph294")
         .set("pos", new double[]{0.48315617602116434, 0.13800768608148925, 0.7187795385420026});
    model.component("comp1").geom("geom1").feature("sph294").set("r", 0.003373909178054159);
    model.component("comp1").geom("geom1").create("sph295", "Sphere");
    model.component("comp1").geom("geom1").feature("sph295")
         .set("pos", new double[]{0.4130942125974558, 0.4244900219749839, 0.2046068992073294});
    model.component("comp1").geom("geom1").feature("sph295").set("r", 0.009328555227631968);
    model.component("comp1").geom("geom1").create("sph296", "Sphere");
    model.component("comp1").geom("geom1").feature("sph296")
         .set("pos", new double[]{0.4249358436092233, 0.648246053257049, 0.9242893420298973});
    model.component("comp1").geom("geom1").feature("sph296").set("r", 0.004307277900267345);
    model.component("comp1").geom("geom1").create("sph297", "Sphere");
    model.component("comp1").geom("geom1").feature("sph297")
         .set("pos", new double[]{0.44847232942271237, 0.9042079013288755, 0.28027440087391564});
    model.component("comp1").geom("geom1").feature("sph297").set("r", 0.008801748222934374);
    model.component("comp1").geom("geom1").create("sph298", "Sphere");
    model.component("comp1").geom("geom1").feature("sph298")
         .set("pos", new double[]{0.34601256467650854, 0.5599276050525765, 0.6667629023611454});
    model.component("comp1").geom("geom1").feature("sph298").set("r", 0.0043257118612568465);
    model.component("comp1").geom("geom1").create("sph299", "Sphere");
    model.component("comp1").geom("geom1").feature("sph299")
         .set("pos", new double[]{0.2583066981867973, 0.39994404212047524, 0.3098990717452594});
    model.component("comp1").geom("geom1").feature("sph299").set("r", 0.003580450147363549);
    model.component("comp1").geom("geom1").create("sph300", "Sphere");
    model.component("comp1").geom("geom1").feature("sph300")
         .set("pos", new double[]{0.4647050170685914, 0.8534794311125171, 0.6500989887613841});
    model.component("comp1").geom("geom1").feature("sph300").set("r", 0.009479662471162432);
    model.component("comp1").geom("geom1").create("sph301", "Sphere");
    model.component("comp1").geom("geom1").feature("sph301")
         .set("pos", new double[]{0.3868118893925845, 0.8126410764476523, 0.10190064180104771});
    model.component("comp1").geom("geom1").feature("sph301").set("r", 0.00409860248229045);
    model.component("comp1").geom("geom1").create("sph302", "Sphere");
    model.component("comp1").geom("geom1").feature("sph302")
         .set("pos", new double[]{0.2678284764363439, 0.8112256042375016, 0.8025138070749654});
    model.component("comp1").geom("geom1").feature("sph302").set("r", 0.008209673922297742);
    model.component("comp1").geom("geom1").create("sph303", "Sphere");
    model.component("comp1").geom("geom1").feature("sph303")
         .set("pos", new double[]{0.4064191061802933, 0.5024459159193283, 0.1707830132996484});
    model.component("comp1").geom("geom1").feature("sph303").set("r", 0.0014590657794588025);
    model.component("comp1").geom("geom1").create("sph304", "Sphere");
    model.component("comp1").geom("geom1").feature("sph304")
         .set("pos", new double[]{0.4420384370855653, 0.5673765681322747, 0.9807431324730151});

    return model;
  }

  public static Model run4(Model model) {
    model.component("comp1").geom("geom1").feature("sph304").set("r", 0.0023354104390963812);
    model.component("comp1").geom("geom1").create("sph305", "Sphere");
    model.component("comp1").geom("geom1").feature("sph305")
         .set("pos", new double[]{0.48847083531221314, 0.12612134039782924, 0.9296310545945494});
    model.component("comp1").geom("geom1").feature("sph305").set("r", 0.009840229995595098);
    model.component("comp1").geom("geom1").create("sph306", "Sphere");
    model.component("comp1").geom("geom1").feature("sph306")
         .set("pos", new double[]{0.3648206006234042, 0.7557585739371827, 0.205518425842825});
    model.component("comp1").geom("geom1").feature("sph306").set("r", 0.0032011264811850656);
    model.component("comp1").geom("geom1").create("sph307", "Sphere");
    model.component("comp1").geom("geom1").feature("sph307")
         .set("pos", new double[]{0.3002852147515544, 0.10955580000870421, 0.12123414674569688});
    model.component("comp1").geom("geom1").feature("sph307").set("r", 0.00609680444998897);
    model.component("comp1").geom("geom1").create("sph308", "Sphere");
    model.component("comp1").geom("geom1").feature("sph308")
         .set("pos", new double[]{0.2553431853248866, 0.4254879664389791, 0.662811691575637});
    model.component("comp1").geom("geom1").feature("sph308").set("r", 0.004218751313633969);
    model.component("comp1").geom("geom1").create("sph309", "Sphere");
    model.component("comp1").geom("geom1").feature("sph309")
         .set("pos", new double[]{0.2752719264013678, 0.06672541321091682, 0.2801645832941891});
    model.component("comp1").geom("geom1").feature("sph309").set("r", 0.004615193665035899);
    model.component("comp1").geom("geom1").create("sph310", "Sphere");
    model.component("comp1").geom("geom1").feature("sph310")
         .set("pos", new double[]{0.4889261166951273, 0.15299068520595546, 0.8039205765217198});
    model.component("comp1").geom("geom1").feature("sph310").set("r", 0.002523814214892407);
    model.component("comp1").geom("geom1").create("sph311", "Sphere");
    model.component("comp1").geom("geom1").feature("sph311")
         .set("pos", new double[]{0.3914521831029966, 0.5119291036281298, 0.9658424764221721});
    model.component("comp1").geom("geom1").feature("sph311").set("r", 0.006274971475670303);
    model.component("comp1").geom("geom1").create("sph312", "Sphere");
    model.component("comp1").geom("geom1").feature("sph312")
         .set("pos", new double[]{0.44451748668684055, 0.5548213867543119, 0.3965259168956121});
    model.component("comp1").geom("geom1").feature("sph312").set("r", 0.004274602975824741);
    model.component("comp1").geom("geom1").create("sph313", "Sphere");
    model.component("comp1").geom("geom1").feature("sph313")
         .set("pos", new double[]{0.3976914843327403, 0.12623312209343218, 0.4191223153119151});
    model.component("comp1").geom("geom1").feature("sph313").set("r", 0.009599193399752029);
    model.component("comp1").geom("geom1").create("sph314", "Sphere");
    model.component("comp1").geom("geom1").feature("sph314")
         .set("pos", new double[]{0.42032353736650846, 0.9096503772795516, 0.2632438216900321});
    model.component("comp1").geom("geom1").feature("sph314").set("r", 0.00803423554913447);
    model.component("comp1").geom("geom1").create("sph315", "Sphere");
    model.component("comp1").geom("geom1").feature("sph315")
         .set("pos", new double[]{0.3655966540150637, 0.5724579394158544, 0.9479263440289112});
    model.component("comp1").geom("geom1").feature("sph315").set("r", 0.007823743447184416);
    model.component("comp1").geom("geom1").create("sph316", "Sphere");
    model.component("comp1").geom("geom1").feature("sph316")
         .set("pos", new double[]{0.45830073953426764, 0.36186261085461807, 0.8800913718116947});
    model.component("comp1").geom("geom1").feature("sph316").set("r", 0.009813576879902596);
    model.component("comp1").geom("geom1").create("sph317", "Sphere");
    model.component("comp1").geom("geom1").feature("sph317")
         .set("pos", new double[]{0.3584438861289421, 0.04200781884284551, 0.7664827545567384});
    model.component("comp1").geom("geom1").feature("sph317").set("r", 0.006747482598772718);
    model.component("comp1").geom("geom1").create("sph318", "Sphere");
    model.component("comp1").geom("geom1").feature("sph318")
         .set("pos", new double[]{0.44338820469836665, 0.7452851483740361, 0.7903270006635751});
    model.component("comp1").geom("geom1").feature("sph318").set("r", 0.005518950226517018);
    model.component("comp1").geom("geom1").create("sph319", "Sphere");
    model.component("comp1").geom("geom1").feature("sph319")
         .set("pos", new double[]{0.44797021451657965, 0.5484842931147091, 0.4735238992055975});
    model.component("comp1").geom("geom1").feature("sph319").set("r", 0.003705860428270902);
    model.component("comp1").geom("geom1").create("sph320", "Sphere");
    model.component("comp1").geom("geom1").feature("sph320")
         .set("pos", new double[]{0.26211353018703554, 0.10794493427134969, 0.29511852646975745});
    model.component("comp1").geom("geom1").feature("sph320").set("r", 0.007076133224386813);
    model.component("comp1").geom("geom1").create("sph321", "Sphere");
    model.component("comp1").geom("geom1").feature("sph321")
         .set("pos", new double[]{0.29203122721454244, 0.3339325070546833, 0.05989454571400675});
    model.component("comp1").geom("geom1").feature("sph321").set("r", 0.00984691098962056);
    model.component("comp1").geom("geom1").create("sph322", "Sphere");
    model.component("comp1").geom("geom1").feature("sph322")
         .set("pos", new double[]{0.3315122846326269, 0.9432493170005732, 0.8424056802790334});
    model.component("comp1").geom("geom1").feature("sph322").set("r", 0.003981419922634536);
    model.component("comp1").geom("geom1").create("sph323", "Sphere");
    model.component("comp1").geom("geom1").feature("sph323")
         .set("pos", new double[]{0.26041695160200673, 0.8280883281813044, 0.659109049709162});
    model.component("comp1").geom("geom1").feature("sph323").set("r", 0.004444877973184944);
    model.component("comp1").geom("geom1").create("sph324", "Sphere");
    model.component("comp1").geom("geom1").feature("sph324")
         .set("pos", new double[]{0.49666516963541557, 0.10212935461525759, 0.8653734785942011});
    model.component("comp1").geom("geom1").feature("sph324").set("r", 0.0023712803528617874);
    model.component("comp1").geom("geom1").create("sph325", "Sphere");
    model.component("comp1").geom("geom1").feature("sph325")
         .set("pos", new double[]{0.35931007882343696, 0.7933006422643342, 0.6762131146276744});
    model.component("comp1").geom("geom1").feature("sph325").set("r", 0.003648395477167201);
    model.component("comp1").geom("geom1").create("sph326", "Sphere");
    model.component("comp1").geom("geom1").feature("sph326")
         .set("pos", new double[]{0.4029977631941338, 0.10540413253971419, 0.8771030404660725});
    model.component("comp1").geom("geom1").feature("sph326").set("r", 0.009440779369996353);
    model.component("comp1").geom("geom1").create("sph327", "Sphere");
    model.component("comp1").geom("geom1").feature("sph327")
         .set("pos", new double[]{0.42461056791958823, 0.0608045497970867, 0.3978670744600288});
    model.component("comp1").geom("geom1").feature("sph327").set("r", 0.00792239972489732);
    model.component("comp1").geom("geom1").create("sph328", "Sphere");
    model.component("comp1").geom("geom1").feature("sph328")
         .set("pos", new double[]{0.4538620008807045, 0.6995232034350682, 0.8811569057188701});
    model.component("comp1").geom("geom1").feature("sph328").set("r", 0.002506922375135853);
    model.component("comp1").geom("geom1").create("sph329", "Sphere");
    model.component("comp1").geom("geom1").feature("sph329")
         .set("pos", new double[]{0.4383572526375647, 0.9846457759396484, 0.6125435395025215});
    model.component("comp1").geom("geom1").feature("sph329").set("r", 0.009699175962317477);
    model.component("comp1").geom("geom1").create("sph330", "Sphere");
    model.component("comp1").geom("geom1").feature("sph330")
         .set("pos", new double[]{0.25485901743627354, 0.34252519462363534, 0.8226085888470189});
    model.component("comp1").geom("geom1").feature("sph330").set("r", 0.0013341664350230305);
    model.component("comp1").geom("geom1").create("sph331", "Sphere");
    model.component("comp1").geom("geom1").feature("sph331")
         .set("pos", new double[]{0.4820972441102176, 0.07277116661597795, 0.05258229857234572});
    model.component("comp1").geom("geom1").feature("sph331").set("r", 0.00879521235692258);
    model.component("comp1").geom("geom1").create("sph332", "Sphere");
    model.component("comp1").geom("geom1").feature("sph332")
         .set("pos", new double[]{0.32985643893795996, 0.5569181648565041, 0.9735490312743847});
    model.component("comp1").geom("geom1").feature("sph332").set("r", 0.009219552367303305);
    model.component("comp1").geom("geom1").create("sph333", "Sphere");
    model.component("comp1").geom("geom1").feature("sph333")
         .set("pos", new double[]{0.41494049352950035, 0.40179227190782857, 0.7657251082465081});
    model.component("comp1").geom("geom1").feature("sph333").set("r", 0.00460403681262331);
    model.component("comp1").geom("geom1").create("sph334", "Sphere");
    model.component("comp1").geom("geom1").feature("sph334")
         .set("pos", new double[]{0.3123989705143364, 0.2739358215402117, 0.2608412570060136});
    model.component("comp1").geom("geom1").feature("sph334").set("r", 0.005749432530155793);
    model.component("comp1").geom("geom1").create("sph335", "Sphere");
    model.component("comp1").geom("geom1").feature("sph335")
         .set("pos", new double[]{0.42344396638521287, 0.9440764454133789, 0.6918395005389437});
    model.component("comp1").geom("geom1").feature("sph335").set("r", 0.005790882954327048);
    model.component("comp1").geom("geom1").create("sph336", "Sphere");
    model.component("comp1").geom("geom1").feature("sph336")
         .set("pos", new double[]{0.2975490626183821, 0.3760853645276814, 0.41516503637313473});
    model.component("comp1").geom("geom1").feature("sph336").set("r", 0.008030735595661517);
    model.component("comp1").geom("geom1").create("sph337", "Sphere");
    model.component("comp1").geom("geom1").feature("sph337")
         .set("pos", new double[]{0.32690293296105355, 0.30611563522876734, 0.35795784336488334});
    model.component("comp1").geom("geom1").feature("sph337").set("r", 0.007177422070004258);
    model.component("comp1").geom("geom1").create("sph338", "Sphere");
    model.component("comp1").geom("geom1").feature("sph338")
         .set("pos", new double[]{0.39311065692430397, 0.0823214919492133, 0.08524107263084409});
    model.component("comp1").geom("geom1").feature("sph338").set("r", 0.008292718733889091);
    model.component("comp1").geom("geom1").create("sph339", "Sphere");
    model.component("comp1").geom("geom1").feature("sph339")
         .set("pos", new double[]{0.43933290857238005, 0.6870450571543507, 0.7061764095492681});
    model.component("comp1").geom("geom1").feature("sph339").set("r", 0.004341582498542494);
    model.component("comp1").geom("geom1").create("sph340", "Sphere");
    model.component("comp1").geom("geom1").feature("sph340")
         .set("pos", new double[]{0.32515324725751615, 0.5474933606835901, 0.5426672445593972});
    model.component("comp1").geom("geom1").feature("sph340").set("r", 0.007904890594486874);
    model.component("comp1").geom("geom1").create("sph341", "Sphere");
    model.component("comp1").geom("geom1").feature("sph341")
         .set("pos", new double[]{0.4822214073468242, 0.2813896702493995, 0.7887905375824464});
    model.component("comp1").geom("geom1").feature("sph341").set("r", 0.007656692510619545);
    model.component("comp1").geom("geom1").create("sph342", "Sphere");
    model.component("comp1").geom("geom1").feature("sph342")
         .set("pos", new double[]{0.3939458086045084, 0.7710645937311378, 0.9378695311874908});
    model.component("comp1").geom("geom1").feature("sph342").set("r", 0.006939734936709362);
    model.component("comp1").geom("geom1").create("sph343", "Sphere");
    model.component("comp1").geom("geom1").feature("sph343")
         .set("pos", new double[]{0.28778809844650793, 0.7556053932838127, 0.08489865334130668});
    model.component("comp1").geom("geom1").feature("sph343").set("r", 0.0013302227608247169);
    model.component("comp1").geom("geom1").create("sph344", "Sphere");
    model.component("comp1").geom("geom1").feature("sph344")
         .set("pos", new double[]{0.30812802947540296, 0.27684395649397114, 0.6995616581522279});
    model.component("comp1").geom("geom1").feature("sph344").set("r", 0.005645113306669838);
    model.component("comp1").geom("geom1").create("sph345", "Sphere");
    model.component("comp1").geom("geom1").feature("sph345")
         .set("pos", new double[]{0.46738033024049, 0.4446201714591939, 0.5023872066360415});
    model.component("comp1").geom("geom1").feature("sph345").set("r", 0.0012717349594184046);
    model.component("comp1").geom("geom1").create("sph346", "Sphere");
    model.component("comp1").geom("geom1").feature("sph346")
         .set("pos", new double[]{0.40968016885724645, 0.3466750013700503, 0.1057828551565337});
    model.component("comp1").geom("geom1").feature("sph346").set("r", 0.005860431673243228);
    model.component("comp1").geom("geom1").create("sph347", "Sphere");
    model.component("comp1").geom("geom1").feature("sph347")
         .set("pos", new double[]{0.2946010633422468, 0.5556992238958405, 0.3194354190160791});
    model.component("comp1").geom("geom1").feature("sph347").set("r", 0.0038654104299955896);
    model.component("comp1").geom("geom1").create("sph348", "Sphere");
    model.component("comp1").geom("geom1").feature("sph348")
         .set("pos", new double[]{0.4824704158819208, 0.6178140328659051, 0.6152360081701445});
    model.component("comp1").geom("geom1").feature("sph348").set("r", 0.009622604601940914);
    model.component("comp1").geom("geom1").create("sph349", "Sphere");
    model.component("comp1").geom("geom1").feature("sph349")
         .set("pos", new double[]{0.4641770522247134, 0.7598383128316198, 0.3172697391968264});
    model.component("comp1").geom("geom1").feature("sph349").set("r", 0.009868407081103956);
    model.component("comp1").geom("geom1").create("sph350", "Sphere");
    model.component("comp1").geom("geom1").feature("sph350")
         .set("pos", new double[]{0.3028797337186808, 0.48725839216507005, 0.9861613061012536});
    model.component("comp1").geom("geom1").feature("sph350").set("r", 0.004289851253062688);
    model.component("comp1").geom("geom1").create("sph351", "Sphere");
    model.component("comp1").geom("geom1").feature("sph351")
         .set("pos", new double[]{0.2866168723314063, 0.03393567505413593, 0.891295273946841});
    model.component("comp1").geom("geom1").feature("sph351").set("r", 0.0092093585771043);
    model.component("comp1").geom("geom1").create("sph352", "Sphere");
    model.component("comp1").geom("geom1").feature("sph352")
         .set("pos", new double[]{0.30354597492570196, 0.6716268987627192, 0.6425402286810091});
    model.component("comp1").geom("geom1").feature("sph352").set("r", 0.005834531151538367);
    model.component("comp1").geom("geom1").create("sph353", "Sphere");
    model.component("comp1").geom("geom1").feature("sph353")
         .set("pos", new double[]{0.31590914623219185, 0.06192455506100734, 0.2110783464044682});
    model.component("comp1").geom("geom1").feature("sph353").set("r", 0.0020987704615282048);
    model.component("comp1").geom("geom1").create("sph354", "Sphere");
    model.component("comp1").geom("geom1").feature("sph354")
         .set("pos", new double[]{0.2996531589618924, 0.6846545212150349, 0.05147361209897191});
    model.component("comp1").geom("geom1").feature("sph354").set("r", 0.002190751073677566);
    model.component("comp1").geom("geom1").create("sph355", "Sphere");
    model.component("comp1").geom("geom1").feature("sph355")
         .set("pos", new double[]{0.28494576210355677, 0.317244389119914, 0.29952177800406304});
    model.component("comp1").geom("geom1").feature("sph355").set("r", 0.0019166915372339486);
    model.component("comp1").geom("geom1").create("sph356", "Sphere");
    model.component("comp1").geom("geom1").feature("sph356")
         .set("pos", new double[]{0.4359828391619086, 0.994740245789033, 0.5337539701008149});
    model.component("comp1").geom("geom1").feature("sph356").set("r", 0.0032955740678497552);
    model.component("comp1").geom("geom1").create("sph357", "Sphere");
    model.component("comp1").geom("geom1").feature("sph357")
         .set("pos", new double[]{0.35111648604370105, 0.11415376895828652, 0.4105067297777679});
    model.component("comp1").geom("geom1").feature("sph357").set("r", 0.00949782446122548);
    model.component("comp1").geom("geom1").create("sph358", "Sphere");
    model.component("comp1").geom("geom1").feature("sph358")
         .set("pos", new double[]{0.3734000695161084, 0.6558924996638562, 0.46133573272789635});
    model.component("comp1").geom("geom1").feature("sph358").set("r", 0.00366514996073224);
    model.component("comp1").geom("geom1").create("sph359", "Sphere");
    model.component("comp1").geom("geom1").feature("sph359")
         .set("pos", new double[]{0.4639449723017279, 0.6981737734920351, 0.4898791752672554});
    model.component("comp1").geom("geom1").feature("sph359").set("r", 0.00941644460870043);
    model.component("comp1").geom("geom1").create("sph360", "Sphere");
    model.component("comp1").geom("geom1").feature("sph360")
         .set("pos", new double[]{0.34970350518600274, 0.7035082288261675, 0.28582565065201354});
    model.component("comp1").geom("geom1").feature("sph360").set("r", 0.0021851855363301123);
    model.component("comp1").geom("geom1").create("sph361", "Sphere");
    model.component("comp1").geom("geom1").feature("sph361")
         .set("pos", new double[]{0.4753953190869056, 0.7082414099431243, 0.6148301010499735});
    model.component("comp1").geom("geom1").feature("sph361").set("r", 0.001935892697890784);
    model.component("comp1").geom("geom1").create("sph362", "Sphere");
    model.component("comp1").geom("geom1").feature("sph362")
         .set("pos", new double[]{0.4534522332064782, 0.4837280372399298, 0.8749882320093079});
    model.component("comp1").geom("geom1").feature("sph362").set("r", 0.008132490150480249);
    model.component("comp1").geom("geom1").create("sph363", "Sphere");
    model.component("comp1").geom("geom1").feature("sph363")
         .set("pos", new double[]{0.3221130602096241, 0.6055562500511631, 0.5260923427937703});
    model.component("comp1").geom("geom1").feature("sph363").set("r", 0.009247771096309951);
    model.component("comp1").geom("geom1").create("sph364", "Sphere");
    model.component("comp1").geom("geom1").feature("sph364")
         .set("pos", new double[]{0.47930254504961295, 0.307464687759756, 0.9777860074524889});
    model.component("comp1").geom("geom1").feature("sph364").set("r", 0.005841512012367123);
    model.component("comp1").geom("geom1").create("sph365", "Sphere");
    model.component("comp1").geom("geom1").feature("sph365")
         .set("pos", new double[]{0.36543354904764547, 0.8116634361206041, 0.764140017878642});
    model.component("comp1").geom("geom1").feature("sph365").set("r", 0.009119180933238089);
    model.component("comp1").geom("geom1").create("sph366", "Sphere");
    model.component("comp1").geom("geom1").feature("sph366")
         .set("pos", new double[]{0.33251721116851435, 0.20076202805950283, 0.669091641642047});
    model.component("comp1").geom("geom1").feature("sph366").set("r", 0.007101054726566692);
    model.component("comp1").geom("geom1").create("sph367", "Sphere");
    model.component("comp1").geom("geom1").feature("sph367")
         .set("pos", new double[]{0.26237083925635013, 0.6403509387815168, 0.4438540958384255});
    model.component("comp1").geom("geom1").feature("sph367").set("r", 0.008586759667609759);
    model.component("comp1").geom("geom1").create("sph368", "Sphere");
    model.component("comp1").geom("geom1").feature("sph368")
         .set("pos", new double[]{0.33361128039749677, 0.47465376011113675, 0.5144988510314876});
    model.component("comp1").geom("geom1").feature("sph368").set("r", 0.009082789796142854);
    model.component("comp1").geom("geom1").create("sph369", "Sphere");
    model.component("comp1").geom("geom1").feature("sph369")
         .set("pos", new double[]{0.4272591181936257, 0.8289799775155193, 0.05991102451446261});
    model.component("comp1").geom("geom1").feature("sph369").set("r", 0.002263955692339477);
    model.component("comp1").geom("geom1").create("sph370", "Sphere");
    model.component("comp1").geom("geom1").feature("sph370")
         .set("pos", new double[]{0.2628580360976828, 0.9532364432114786, 0.6659576828034982});
    model.component("comp1").geom("geom1").feature("sph370").set("r", 0.003622499384832125);
    model.component("comp1").geom("geom1").create("sph371", "Sphere");
    model.component("comp1").geom("geom1").feature("sph371")
         .set("pos", new double[]{0.3822639786913698, 0.7962218040938265, 0.3768447775215551});
    model.component("comp1").geom("geom1").feature("sph371").set("r", 0.009677803775093034);
    model.component("comp1").geom("geom1").create("sph372", "Sphere");
    model.component("comp1").geom("geom1").feature("sph372")
         .set("pos", new double[]{0.3455856995793996, 0.6565410261651465, 0.36062935142206864});
    model.component("comp1").geom("geom1").feature("sph372").set("r", 0.004184371293153769);
    model.component("comp1").geom("geom1").create("sph374", "Sphere");
    model.component("comp1").geom("geom1").feature("sph374")
         .set("pos", new double[]{0.26243093706046866, 0.228835610647207, 0.44700723781743806});
    model.component("comp1").geom("geom1").feature("sph374").set("r", 0.002010249933286474);
    model.component("comp1").geom("geom1").create("sph375", "Sphere");
    model.component("comp1").geom("geom1").feature("sph375")
         .set("pos", new double[]{0.3102033104802025, 0.4940485848790273, 0.9222869405459018});
    model.component("comp1").geom("geom1").feature("sph375").set("r", 0.008532913287598155);
    model.component("comp1").geom("geom1").create("sph376", "Sphere");
    model.component("comp1").geom("geom1").feature("sph376")
         .set("pos", new double[]{0.44534370819570374, 0.5502795515615417, 0.9737351887487375});
    model.component("comp1").geom("geom1").feature("sph376").set("r", 0.007004932361080075);
    model.component("comp1").geom("geom1").create("sph377", "Sphere");
    model.component("comp1").geom("geom1").feature("sph377")
         .set("pos", new double[]{0.2671023886258944, 0.20178698406320475, 0.4059730925929242});
    model.component("comp1").geom("geom1").feature("sph377").set("r", 0.006297959392133268);
    model.component("comp1").geom("geom1").create("sph378", "Sphere");
    model.component("comp1").geom("geom1").feature("sph378")
         .set("pos", new double[]{0.4394957503017805, 0.4142006215646095, 0.7073647296587788});
    model.component("comp1").geom("geom1").feature("sph378").set("r", 0.006411494553163988);
    model.component("comp1").geom("geom1").create("sph379", "Sphere");
    model.component("comp1").geom("geom1").feature("sph379")
         .set("pos", new double[]{0.33227865966753123, 0.9714976025214094, 0.6472294184178422});
    model.component("comp1").geom("geom1").feature("sph379").set("r", 0.008108825527982125);
    model.component("comp1").geom("geom1").create("sph380", "Sphere");
    model.component("comp1").geom("geom1").feature("sph380")
         .set("pos", new double[]{0.38798548890796014, 0.7372885672981592, 0.7657126952075907});
    model.component("comp1").geom("geom1").feature("sph380").set("r", 0.008928982547075182);
    model.component("comp1").geom("geom1").create("sph381", "Sphere");
    model.component("comp1").geom("geom1").feature("sph381")
         .set("pos", new double[]{0.2940029865032698, 0.5572140124612267, 0.4296926578686642});
    model.component("comp1").geom("geom1").feature("sph381").set("r", 0.009174235413111211);
    model.component("comp1").geom("geom1").create("sph383", "Sphere");
    model.component("comp1").geom("geom1").feature("sph383")
         .set("pos", new double[]{0.37277166814100104, 0.7168352722515469, 0.7373587694244657});
    model.component("comp1").geom("geom1").feature("sph383").set("r", 0.001664436534078237);
    model.component("comp1").geom("geom1").create("sph384", "Sphere");
    model.component("comp1").geom("geom1").feature("sph384")
         .set("pos", new double[]{0.4444737554215022, 0.31439354857402424, 0.4984634557242951});
    model.component("comp1").geom("geom1").feature("sph384").set("r", 0.009158447127141287);
    model.component("comp1").geom("geom1").create("sph385", "Sphere");
    model.component("comp1").geom("geom1").feature("sph385")
         .set("pos", new double[]{0.28989965444674626, 0.19846836823328462, 0.4813198377339518});
    model.component("comp1").geom("geom1").feature("sph385").set("r", 0.0073160718664226874);
    model.component("comp1").geom("geom1").create("sph386", "Sphere");
    model.component("comp1").geom("geom1").feature("sph386")
         .set("pos", new double[]{0.46296832203191685, 0.5856415936015691, 0.34978029676454264});
    model.component("comp1").geom("geom1").feature("sph386").set("r", 0.0036842121883496146);
    model.component("comp1").geom("geom1").create("sph387", "Sphere");
    model.component("comp1").geom("geom1").feature("sph387")
         .set("pos", new double[]{0.44595161911474945, 0.989743805938319, 0.8413065607107955});
    model.component("comp1").geom("geom1").feature("sph387").set("r", 0.008639497230439691);
    model.component("comp1").geom("geom1").create("sph388", "Sphere");
    model.component("comp1").geom("geom1").feature("sph388")
         .set("pos", new double[]{0.2853986620870685, 0.8374183710764119, 0.0639227038648331});
    model.component("comp1").geom("geom1").feature("sph388").set("r", 0.004730108813251118);
    model.component("comp1").geom("geom1").create("sph389", "Sphere");
    model.component("comp1").geom("geom1").feature("sph389")
         .set("pos", new double[]{0.4764486209039975, 0.9569398623769729, 0.639397221196289});
    model.component("comp1").geom("geom1").feature("sph389").set("r", 0.004152440866103687);
    model.component("comp1").geom("geom1").create("sph390", "Sphere");
    model.component("comp1").geom("geom1").feature("sph390")
         .set("pos", new double[]{0.26720029623701674, 0.5142718868819968, 0.5461934799845372});
    model.component("comp1").geom("geom1").feature("sph390").set("r", 0.007197834852853423);
    model.component("comp1").geom("geom1").create("sph391", "Sphere");
    model.component("comp1").geom("geom1").feature("sph391")
         .set("pos", new double[]{0.2706529847098124, 0.2311093616217868, 0.35913736483010605});
    model.component("comp1").geom("geom1").feature("sph391").set("r", 0.004060906715117);
    model.component("comp1").geom("geom1").create("sph392", "Sphere");
    model.component("comp1").geom("geom1").feature("sph392")
         .set("pos", new double[]{0.3968376392847553, 0.7202048416906868, 0.31942501804833334});
    model.component("comp1").geom("geom1").feature("sph392").set("r", 0.004916277878646967);
    model.component("comp1").geom("geom1").create("sph393", "Sphere");
    model.component("comp1").geom("geom1").feature("sph393")
         .set("pos", new double[]{0.25872751371631636, 0.0445116673126475, 0.25974002927602363});
    model.component("comp1").geom("geom1").feature("sph393").set("r", 0.003960583839270848);
    model.component("comp1").geom("geom1").create("sph394", "Sphere");
    model.component("comp1").geom("geom1").feature("sph394")
         .set("pos", new double[]{0.4051121238535278, 0.7656546631227601, 0.7647984045285515});
    model.component("comp1").geom("geom1").feature("sph394").set("r", 0.007662204979074611);
    model.component("comp1").geom("geom1").create("sph395", "Sphere");
    model.component("comp1").geom("geom1").feature("sph395")
         .set("pos", new double[]{0.42624224828133456, 0.9706674041050806, 0.8918783961166935});
    model.component("comp1").geom("geom1").feature("sph395").set("r", 0.008709107209023712);
    model.component("comp1").geom("geom1").create("sph396", "Sphere");
    model.component("comp1").geom("geom1").feature("sph396")
         .set("pos", new double[]{0.395932077146805, 0.04011706967294843, 0.9922646307356574});
    model.component("comp1").geom("geom1").feature("sph396").set("r", 0.006280454496009108);
    model.component("comp1").geom("geom1").create("sph397", "Sphere");
    model.component("comp1").geom("geom1").feature("sph397")
         .set("pos", new double[]{0.4340368741666376, 0.8196128826336332, 0.3736090738311129});
    model.component("comp1").geom("geom1").feature("sph397").set("r", 0.0021841839762952765);
    model.component("comp1").geom("geom1").create("sph398", "Sphere");
    model.component("comp1").geom("geom1").feature("sph398")
         .set("pos", new double[]{0.27691418085664726, 0.7472278989630242, 0.45291598664831045});
    model.component("comp1").geom("geom1").feature("sph398").set("r", 0.002771668491987824);
    model.component("comp1").geom("geom1").create("sph399", "Sphere");
    model.component("comp1").geom("geom1").feature("sph399")
         .set("pos", new double[]{0.47268438822345865, 0.15183087902767337, 0.9129476025514047});
    model.component("comp1").geom("geom1").feature("sph399").set("r", 0.007423459831010222);
    model.component("comp1").geom("geom1").create("sph400", "Sphere");
    model.component("comp1").geom("geom1").feature("sph400")
         .set("pos", new double[]{0.3281490489773061, 0.9388933653874465, 0.9860350152777576});
    model.component("comp1").geom("geom1").feature("sph400").set("r", 0.00470463813557593);
    model.component("comp1").geom("geom1").create("sph401", "Sphere");
    model.component("comp1").geom("geom1").feature("sph401")
         .set("pos", new double[]{0.4133344193642791, 0.10869109349894548, 0.6500718946732419});
    model.component("comp1").geom("geom1").feature("sph401").set("r", 0.0027900299599070335);
    model.component("comp1").geom("geom1").create("sph403", "Sphere");
    model.component("comp1").geom("geom1").feature("sph403")
         .set("pos", new double[]{0.39661371178410265, 0.8781040878902907, 0.92517186552158});
    model.component("comp1").geom("geom1").feature("sph403").set("r", 0.004538101737010754);
    model.component("comp1").geom("geom1").create("sph404", "Sphere");
    model.component("comp1").geom("geom1").feature("sph404")
         .set("pos", new double[]{0.29634912125347906, 0.11337350192842013, 0.19424345372916893});
    model.component("comp1").geom("geom1").feature("sph404").set("r", 0.001481766581865863);
    model.component("comp1").geom("geom1").create("sph405", "Sphere");
    model.component("comp1").geom("geom1").feature("sph405")
         .set("pos", new double[]{0.37657910651056914, 0.6283946036509903, 0.7302296131875546});
    model.component("comp1").geom("geom1").feature("sph405").set("r", 0.0041194702954825465);
    model.component("comp1").geom("geom1").create("sph406", "Sphere");
    model.component("comp1").geom("geom1").feature("sph406")
         .set("pos", new double[]{0.4884577537037296, 0.6599214778392489, 0.8391403566375034});
    model.component("comp1").geom("geom1").feature("sph406").set("r", 0.009011003872472265);
    model.component("comp1").geom("geom1").create("sph407", "Sphere");
    model.component("comp1").geom("geom1").feature("sph407")
         .set("pos", new double[]{0.3299634016312125, 0.8696794284412753, 0.05008107640850937});
    model.component("comp1").geom("geom1").feature("sph407").set("r", 0.008002349622322292);
    model.component("comp1").geom("geom1").create("sph408", "Sphere");
    model.component("comp1").geom("geom1").feature("sph408")
         .set("pos", new double[]{0.31888718821062473, 0.4621735851864368, 0.6380852543292675});
    model.component("comp1").geom("geom1").feature("sph408").set("r", 0.0010033060937631208);
    model.component("comp1").geom("geom1").create("sph409", "Sphere");
    model.component("comp1").geom("geom1").feature("sph409")
         .set("pos", new double[]{0.4175895820172053, 0.8006593494632904, 0.18651875792515363});
    model.component("comp1").geom("geom1").feature("sph409").set("r", 0.0019159323989009032);
    model.component("comp1").geom("geom1").create("sph410", "Sphere");
    model.component("comp1").geom("geom1").feature("sph410")
         .set("pos", new double[]{0.3798069445755716, 0.4522635142784898, 0.7969898654503007});

    return model;
  }

  public static Model run5(Model model) {
    model.component("comp1").geom("geom1").feature("sph410").set("r", 0.004736127293486145);
    model.component("comp1").geom("geom1").create("sph411", "Sphere");
    model.component("comp1").geom("geom1").feature("sph411")
         .set("pos", new double[]{0.4439716628936956, 0.08613308455082783, 0.7990535469680498});
    model.component("comp1").geom("geom1").feature("sph411").set("r", 0.00964470158307398);
    model.component("comp1").geom("geom1").create("sph412", "Sphere");
    model.component("comp1").geom("geom1").feature("sph412")
         .set("pos", new double[]{0.30983715681090995, 0.15420654757966504, 0.19848666275739016});
    model.component("comp1").geom("geom1").feature("sph412").set("r", 0.0015993669901199605);
    model.component("comp1").geom("geom1").create("sph413", "Sphere");
    model.component("comp1").geom("geom1").feature("sph413")
         .set("pos", new double[]{0.4159463704066052, 0.4706628746502526, 0.9544046928722392});
    model.component("comp1").geom("geom1").feature("sph413").set("r", 0.005754836143516157);
    model.component("comp1").geom("geom1").create("sph414", "Sphere");
    model.component("comp1").geom("geom1").feature("sph414")
         .set("pos", new double[]{0.43912062672760716, 0.8678406793290027, 0.5616735263577366});
    model.component("comp1").geom("geom1").feature("sph414").set("r", 0.0031626308802715003);
    model.component("comp1").geom("geom1").create("sph415", "Sphere");
    model.component("comp1").geom("geom1").feature("sph415")
         .set("pos", new double[]{0.39806387563998297, 0.42953676514593025, 0.554630242119165});
    model.component("comp1").geom("geom1").feature("sph415").set("r", 0.005106002517653979);
    model.component("comp1").geom("geom1").create("sph416", "Sphere");
    model.component("comp1").geom("geom1").feature("sph416")
         .set("pos", new double[]{0.3510634441797299, 0.693489736853326, 0.09672108539295235});
    model.component("comp1").geom("geom1").feature("sph416").set("r", 0.004752405569159214);
    model.component("comp1").geom("geom1").create("sph417", "Sphere");
    model.component("comp1").geom("geom1").feature("sph417")
         .set("pos", new double[]{0.461044413199786, 0.7697225680238058, 0.2825459685261889});
    model.component("comp1").geom("geom1").feature("sph417").set("r", 0.0024988786545593875);
    model.component("comp1").geom("geom1").create("sph418", "Sphere");
    model.component("comp1").geom("geom1").feature("sph418")
         .set("pos", new double[]{0.47776149546588825, 0.8152810589290743, 0.613341099861815});
    model.component("comp1").geom("geom1").feature("sph418").set("r", 0.004395420393991842);
    model.component("comp1").geom("geom1").create("sph419", "Sphere");
    model.component("comp1").geom("geom1").feature("sph419")
         .set("pos", new double[]{0.2637914757087114, 0.43166939396051157, 0.6715936510920202});
    model.component("comp1").geom("geom1").feature("sph419").set("r", 0.0029934116092266197);
    model.component("comp1").geom("geom1").create("sph421", "Sphere");
    model.component("comp1").geom("geom1").feature("sph421")
         .set("pos", new double[]{0.29970547432888567, 0.8005201560046988, 0.7652983000872011});
    model.component("comp1").geom("geom1").feature("sph421").set("r", 0.004051851296296628);
    model.component("comp1").geom("geom1").create("sph422", "Sphere");
    model.component("comp1").geom("geom1").feature("sph422")
         .set("pos", new double[]{0.4902731040647169, 0.14808174552396242, 0.8951344422323766});
    model.component("comp1").geom("geom1").feature("sph422").set("r", 0.005651497363428738);
    model.component("comp1").geom("geom1").create("sph423", "Sphere");
    model.component("comp1").geom("geom1").feature("sph423")
         .set("pos", new double[]{0.2921751481509696, 0.6954154199714933, 0.11116902677299467});
    model.component("comp1").geom("geom1").feature("sph423").set("r", 0.0020481692874572454);
    model.component("comp1").geom("geom1").create("sph424", "Sphere");
    model.component("comp1").geom("geom1").feature("sph424")
         .set("pos", new double[]{0.3560303553642033, 0.7256899618989523, 0.8957929261940044});
    model.component("comp1").geom("geom1").feature("sph424").set("r", 0.0060926058587683985);
    model.component("comp1").geom("geom1").create("sph425", "Sphere");
    model.component("comp1").geom("geom1").feature("sph425")
         .set("pos", new double[]{0.4568771964056081, 0.040351853543671976, 0.31320535867435406});
    model.component("comp1").geom("geom1").feature("sph425").set("r", 0.007928843632021499);
    model.component("comp1").geom("geom1").create("sph426", "Sphere");
    model.component("comp1").geom("geom1").feature("sph426")
         .set("pos", new double[]{0.3549361899925756, 0.23428580467784124, 0.31004085460507874});
    model.component("comp1").geom("geom1").feature("sph426").set("r", 0.005638897780176992);
    model.component("comp1").geom("geom1").create("sph427", "Sphere");
    model.component("comp1").geom("geom1").feature("sph427")
         .set("pos", new double[]{0.32745943807652594, 0.3566825263793193, 0.013148100906107657});
    model.component("comp1").geom("geom1").feature("sph427").set("r", 0.009508878733524451);
    model.component("comp1").geom("geom1").create("sph428", "Sphere");
    model.component("comp1").geom("geom1").feature("sph428")
         .set("pos", new double[]{0.29465084963283233, 0.20923636592867645, 0.2594767567195599});
    model.component("comp1").geom("geom1").feature("sph428").set("r", 0.008605698645500872);
    model.component("comp1").geom("geom1").create("sph429", "Sphere");
    model.component("comp1").geom("geom1").feature("sph429")
         .set("pos", new double[]{0.30687418200369543, 0.792193737282506, 0.8025281113034282});
    model.component("comp1").geom("geom1").feature("sph429").set("r", 0.008961598511603584);
    model.component("comp1").geom("geom1").create("sph430", "Sphere");
    model.component("comp1").geom("geom1").feature("sph430")
         .set("pos", new double[]{0.28607409202801304, 0.22256200213483832, 0.7383594046646855});
    model.component("comp1").geom("geom1").feature("sph430").set("r", 0.009343185119077564);
    model.component("comp1").geom("geom1").create("sph431", "Sphere");
    model.component("comp1").geom("geom1").feature("sph431")
         .set("pos", new double[]{0.322763559884261, 0.16858383718117434, 0.17450602331779871});
    model.component("comp1").geom("geom1").feature("sph431").set("r", 0.0027640067885266514);
    model.component("comp1").geom("geom1").create("sph432", "Sphere");
    model.component("comp1").geom("geom1").feature("sph432")
         .set("pos", new double[]{0.2815846511585526, 0.32359974120610174, 0.42737700286317165});
    model.component("comp1").geom("geom1").feature("sph432").set("r", 0.005333980191653852);
    model.component("comp1").geom("geom1").create("sph433", "Sphere");
    model.component("comp1").geom("geom1").feature("sph433")
         .set("pos", new double[]{0.3473559670736067, 0.09511353474854786, 0.49359421151326655});
    model.component("comp1").geom("geom1").feature("sph433").set("r", 0.0012209330487157983);
    model.component("comp1").geom("geom1").create("sph434", "Sphere");
    model.component("comp1").geom("geom1").feature("sph434")
         .set("pos", new double[]{0.44923589611194764, 0.08752353279648428, 0.5995207249046017});
    model.component("comp1").geom("geom1").feature("sph434").set("r", 0.00843164369701387);
    model.component("comp1").geom("geom1").create("sph435", "Sphere");
    model.component("comp1").geom("geom1").feature("sph435")
         .set("pos", new double[]{0.31395351250043707, 0.7574678530351048, 0.8841125389192647});
    model.component("comp1").geom("geom1").feature("sph435").set("r", 0.00851127743774113);
    model.component("comp1").geom("geom1").create("sph436", "Sphere");
    model.component("comp1").geom("geom1").feature("sph436")
         .set("pos", new double[]{0.28330881002518493, 0.01716553416661753, 0.19681381722738034});
    model.component("comp1").geom("geom1").feature("sph436").set("r", 0.008255117362963998);
    model.component("comp1").geom("geom1").create("sph437", "Sphere");
    model.component("comp1").geom("geom1").feature("sph437")
         .set("pos", new double[]{0.40324773407818737, 0.3850680556008935, 0.7020099107300537});
    model.component("comp1").geom("geom1").feature("sph437").set("r", 0.0034342960685196096);
    model.component("comp1").geom("geom1").create("sph438", "Sphere");
    model.component("comp1").geom("geom1").feature("sph438")
         .set("pos", new double[]{0.29149375244619313, 0.3142548852691594, 0.8811130632372796});
    model.component("comp1").geom("geom1").feature("sph438").set("r", 0.004177674644694478);
    model.component("comp1").geom("geom1").create("sph439", "Sphere");
    model.component("comp1").geom("geom1").feature("sph439")
         .set("pos", new double[]{0.3075096111328796, 0.7829143372238001, 0.2777125852708207});
    model.component("comp1").geom("geom1").feature("sph439").set("r", 0.009626791098205585);
    model.component("comp1").geom("geom1").create("sph440", "Sphere");
    model.component("comp1").geom("geom1").feature("sph440")
         .set("pos", new double[]{0.2973960026345657, 0.6629778898379302, 0.09168230962833113});
    model.component("comp1").geom("geom1").feature("sph440").set("r", 0.00898418389088267);
    model.component("comp1").geom("geom1").create("sph441", "Sphere");
    model.component("comp1").geom("geom1").feature("sph441")
         .set("pos", new double[]{0.4212399509224391, 0.8351400507268306, 0.5653672818429591});
    model.component("comp1").geom("geom1").feature("sph441").set("r", 0.009765039915764828);
    model.component("comp1").geom("geom1").create("sph442", "Sphere");
    model.component("comp1").geom("geom1").feature("sph442")
         .set("pos", new double[]{0.4041807866375991, 0.528437356820415, 0.469708342896901});
    model.component("comp1").geom("geom1").feature("sph442").set("r", 0.005291212275359742);
    model.component("comp1").geom("geom1").create("sph443", "Sphere");
    model.component("comp1").geom("geom1").feature("sph443")
         .set("pos", new double[]{0.29959286340736213, 0.1763248165317158, 0.43291068343825656});
    model.component("comp1").geom("geom1").feature("sph443").set("r", 0.007835052263118786);
    model.component("comp1").geom("geom1").create("sph444", "Sphere");
    model.component("comp1").geom("geom1").feature("sph444")
         .set("pos", new double[]{0.2718416565631626, 0.8417927639674158, 0.769491512464656});
    model.component("comp1").geom("geom1").feature("sph444").set("r", 0.0038867312444045145);
    model.component("comp1").geom("geom1").create("sph445", "Sphere");
    model.component("comp1").geom("geom1").feature("sph445")
         .set("pos", new double[]{0.48917961665994175, 0.0776393626452543, 0.7635251134348223});
    model.component("comp1").geom("geom1").feature("sph445").set("r", 0.005895293498226864);
    model.component("comp1").geom("geom1").create("sph446", "Sphere");
    model.component("comp1").geom("geom1").feature("sph446")
         .set("pos", new double[]{0.34304255657475147, 0.22118678831439315, 0.7870739752248473});
    model.component("comp1").geom("geom1").feature("sph446").set("r", 0.0033973335244818718);
    model.component("comp1").geom("geom1").create("sph447", "Sphere");
    model.component("comp1").geom("geom1").feature("sph447")
         .set("pos", new double[]{0.4584413482612822, 0.6608349853570029, 0.0610501163562239});
    model.component("comp1").geom("geom1").feature("sph447").set("r", 0.002298160918194094);
    model.component("comp1").geom("geom1").create("sph448", "Sphere");
    model.component("comp1").geom("geom1").feature("sph448")
         .set("pos", new double[]{0.4048184816739368, 0.8982605562088012, 0.7445940953545215});
    model.component("comp1").geom("geom1").feature("sph448").set("r", 0.008298835584401382);
    model.component("comp1").geom("geom1").create("sph449", "Sphere");
    model.component("comp1").geom("geom1").feature("sph449")
         .set("pos", new double[]{0.4550645148035285, 0.28073586963490993, 0.5463819578004625});
    model.component("comp1").geom("geom1").feature("sph449").set("r", 0.006050088346867974);
    model.component("comp1").geom("geom1").create("sph450", "Sphere");
    model.component("comp1").geom("geom1").feature("sph450")
         .set("pos", new double[]{0.4886401806725064, 0.22819098892547157, 0.01926613635548806});
    model.component("comp1").geom("geom1").feature("sph450").set("r", 0.0036425513782306915);
    model.component("comp1").geom("geom1").create("sph451", "Sphere");
    model.component("comp1").geom("geom1").feature("sph451")
         .set("pos", new double[]{0.3756076118637554, 0.0320725423495076, 0.5587822892158018});
    model.component("comp1").geom("geom1").feature("sph451").set("r", 0.003932693578034167);
    model.component("comp1").geom("geom1").create("sph453", "Sphere");
    model.component("comp1").geom("geom1").feature("sph453")
         .set("pos", new double[]{0.44982480306805894, 0.6056679215477624, 0.4880000798346397});
    model.component("comp1").geom("geom1").feature("sph453").set("r", 0.009624514004578952);
    model.component("comp1").geom("geom1").create("sph454", "Sphere");
    model.component("comp1").geom("geom1").feature("sph454")
         .set("pos", new double[]{0.4013274828237945, 0.987992669666559, 0.8173886022710741});
    model.component("comp1").geom("geom1").feature("sph454").set("r", 0.0011198450192182058);
    model.component("comp1").geom("geom1").create("sph455", "Sphere");
    model.component("comp1").geom("geom1").feature("sph455")
         .set("pos", new double[]{0.2908409213952351, 0.7817489669402081, 0.7419543906090065});
    model.component("comp1").geom("geom1").feature("sph455").set("r", 0.0040654417949591674);
    model.component("comp1").geom("geom1").create("sph456", "Sphere");
    model.component("comp1").geom("geom1").feature("sph456")
         .set("pos", new double[]{0.461436083895951, 0.5545823894842116, 0.10902206068873124});
    model.component("comp1").geom("geom1").feature("sph456").set("r", 0.009703421127813909);
    model.component("comp1").geom("geom1").create("sph457", "Sphere");
    model.component("comp1").geom("geom1").feature("sph457")
         .set("pos", new double[]{0.33041778755026174, 0.5122756738946761, 0.30382396503630205});
    model.component("comp1").geom("geom1").feature("sph457").set("r", 0.005351505925455641);
    model.component("comp1").geom("geom1").create("sph458", "Sphere");
    model.component("comp1").geom("geom1").feature("sph458")
         .set("pos", new double[]{0.4550516185943833, 0.3186968815194544, 0.5978373967914611});
    model.component("comp1").geom("geom1").feature("sph458").set("r", 0.008756406927780363);
    model.component("comp1").geom("geom1").create("sph459", "Sphere");
    model.component("comp1").geom("geom1").feature("sph459")
         .set("pos", new double[]{0.47328729402777914, 0.19040702402347678, 0.6958018834591192});
    model.component("comp1").geom("geom1").feature("sph459").set("r", 0.004871627718751487);
    model.component("comp1").geom("geom1").create("sph460", "Sphere");
    model.component("comp1").geom("geom1").feature("sph460")
         .set("pos", new double[]{0.3001402120865396, 0.20776817521239327, 0.6899521737259553});
    model.component("comp1").geom("geom1").feature("sph460").set("r", 0.00973337795053495);
    model.component("comp1").geom("geom1").create("sph461", "Sphere");
    model.component("comp1").geom("geom1").feature("sph461")
         .set("pos", new double[]{0.37278871292775534, 0.6079287647006675, 0.21728660731187266});
    model.component("comp1").geom("geom1").feature("sph461").set("r", 0.008012385320724225);
    model.component("comp1").geom("geom1").create("sph462", "Sphere");
    model.component("comp1").geom("geom1").feature("sph462")
         .set("pos", new double[]{0.28212188355923373, 0.32331111274894136, 0.28705653260834907});
    model.component("comp1").geom("geom1").feature("sph462").set("r", 0.005289528057105935);
    model.component("comp1").geom("geom1").create("sph463", "Sphere");
    model.component("comp1").geom("geom1").feature("sph463")
         .set("pos", new double[]{0.4782289262397982, 0.18445602347243517, 0.40237468528585774});
    model.component("comp1").geom("geom1").feature("sph463").set("r", 0.005001628240921781);
    model.component("comp1").geom("geom1").create("sph465", "Sphere");
    model.component("comp1").geom("geom1").feature("sph465")
         .set("pos", new double[]{0.37025196418477685, 0.45474693943548206, 0.21060720380204406});
    model.component("comp1").geom("geom1").feature("sph465").set("r", 0.001729484097706554);
    model.component("comp1").geom("geom1").create("sph466", "Sphere");
    model.component("comp1").geom("geom1").feature("sph466")
         .set("pos", new double[]{0.36391964952206396, 0.8621969074182975, 0.9513079212182002});
    model.component("comp1").geom("geom1").feature("sph466").set("r", 0.004127137013042628);
    model.component("comp1").geom("geom1").create("sph467", "Sphere");
    model.component("comp1").geom("geom1").feature("sph467")
         .set("pos", new double[]{0.46332777086586047, 0.6069448482623074, 0.3507987914662318});
    model.component("comp1").geom("geom1").feature("sph467").set("r", 0.005670331107734488);
    model.component("comp1").geom("geom1").create("sph468", "Sphere");
    model.component("comp1").geom("geom1").feature("sph468")
         .set("pos", new double[]{0.35376106043705624, 0.5226988521743388, 0.04694689767735729});
    model.component("comp1").geom("geom1").feature("sph468").set("r", 0.002747747868521222);
    model.component("comp1").geom("geom1").create("sph469", "Sphere");
    model.component("comp1").geom("geom1").feature("sph469")
         .set("pos", new double[]{0.3995827389098772, 0.22627350107261607, 0.8357661940337344});
    model.component("comp1").geom("geom1").feature("sph469").set("r", 0.002312570492837657);
    model.component("comp1").geom("geom1").create("sph470", "Sphere");
    model.component("comp1").geom("geom1").feature("sph470")
         .set("pos", new double[]{0.27932441847846584, 0.08681443341232384, 0.9336763227830226});
    model.component("comp1").geom("geom1").feature("sph470").set("r", 0.003942480247967716);
    model.component("comp1").geom("geom1").create("sph471", "Sphere");
    model.component("comp1").geom("geom1").feature("sph471")
         .set("pos", new double[]{0.28670846045734616, 0.8611702905182738, 0.25530153586091814});
    model.component("comp1").geom("geom1").feature("sph471").set("r", 0.0020621828011769127);
    model.component("comp1").geom("geom1").create("sph472", "Sphere");
    model.component("comp1").geom("geom1").feature("sph472")
         .set("pos", new double[]{0.44975133985761817, 0.605681491076927, 0.9510895938245183});
    model.component("comp1").geom("geom1").feature("sph472").set("r", 0.006993562696789746);
    model.component("comp1").geom("geom1").create("sph473", "Sphere");
    model.component("comp1").geom("geom1").feature("sph473")
         .set("pos", new double[]{0.28390362343919706, 0.5575479008514407, 0.714966116487518});
    model.component("comp1").geom("geom1").feature("sph473").set("r", 0.007379946093347573);
    model.component("comp1").geom("geom1").create("sph474", "Sphere");
    model.component("comp1").geom("geom1").feature("sph474")
         .set("pos", new double[]{0.26436535177648296, 0.7152815898852756, 0.820328181712999});
    model.component("comp1").geom("geom1").feature("sph474").set("r", 0.008217615163361006);
    model.component("comp1").geom("geom1").create("sph475", "Sphere");
    model.component("comp1").geom("geom1").feature("sph475")
         .set("pos", new double[]{0.37789657845137653, 0.4586692457167094, 0.5486554116930733});
    model.component("comp1").geom("geom1").feature("sph475").set("r", 0.007721504298418209);
    model.component("comp1").geom("geom1").create("sph476", "Sphere");
    model.component("comp1").geom("geom1").feature("sph476")
         .set("pos", new double[]{0.4745186740561741, 0.6153167139928987, 0.8821395076688969});
    model.component("comp1").geom("geom1").feature("sph476").set("r", 0.00734179328943942);
    model.component("comp1").geom("geom1").create("sph477", "Sphere");
    model.component("comp1").geom("geom1").feature("sph477")
         .set("pos", new double[]{0.27339614888489044, 0.5008160796912454, 0.28960847800341927});
    model.component("comp1").geom("geom1").feature("sph477").set("r", 0.007311311627011547);
    model.component("comp1").geom("geom1").create("sph478", "Sphere");
    model.component("comp1").geom("geom1").feature("sph478")
         .set("pos", new double[]{0.3400095780056656, 0.3160543106882164, 0.5780492434391189});
    model.component("comp1").geom("geom1").feature("sph478").set("r", 0.003566574353193151);
    model.component("comp1").geom("geom1").create("sph479", "Sphere");
    model.component("comp1").geom("geom1").feature("sph479")
         .set("pos", new double[]{0.3204953467821668, 0.13505880420383054, 0.0651198858582111});
    model.component("comp1").geom("geom1").feature("sph479").set("r", 0.007152413503182014);
    model.component("comp1").geom("geom1").create("sph480", "Sphere");
    model.component("comp1").geom("geom1").feature("sph480")
         .set("pos", new double[]{0.30041308734523936, 0.015315431778794766, 0.9224645322220151});
    model.component("comp1").geom("geom1").feature("sph480").set("r", 0.00618177560527497);
    model.component("comp1").geom("geom1").create("sph481", "Sphere");
    model.component("comp1").geom("geom1").feature("sph481")
         .set("pos", new double[]{0.27786757469593426, 0.8389197276853786, 0.9775644738292859});
    model.component("comp1").geom("geom1").feature("sph481").set("r", 0.005834263771749166);
    model.component("comp1").geom("geom1").create("sph482", "Sphere");
    model.component("comp1").geom("geom1").feature("sph482")
         .set("pos", new double[]{0.26523173320630145, 0.12139909346957885, 0.3828460628889805});
    model.component("comp1").geom("geom1").feature("sph482").set("r", 0.005037405958159455);
    model.component("comp1").geom("geom1").create("sph483", "Sphere");
    model.component("comp1").geom("geom1").feature("sph483")
         .set("pos", new double[]{0.293323647366992, 0.8181779036888157, 0.023677298721552484});
    model.component("comp1").geom("geom1").feature("sph483").set("r", 0.008969703737039893);
    model.component("comp1").geom("geom1").create("sph485", "Sphere");
    model.component("comp1").geom("geom1").feature("sph485")
         .set("pos", new double[]{0.2965197949636007, 0.7252489334127337, 0.6070211930644452});
    model.component("comp1").geom("geom1").feature("sph485").set("r", 0.009499637093226005);
    model.component("comp1").geom("geom1").create("sph486", "Sphere");
    model.component("comp1").geom("geom1").feature("sph486")
         .set("pos", new double[]{0.2541838239807009, 0.011900992433721367, 0.53192128939755});
    model.component("comp1").geom("geom1").feature("sph486").set("r", 0.002666047499913075);
    model.component("comp1").geom("geom1").create("sph487", "Sphere");
    model.component("comp1").geom("geom1").feature("sph487")
         .set("pos", new double[]{0.40833730766502646, 0.7102345719151145, 0.49398185881383805});
    model.component("comp1").geom("geom1").feature("sph487").set("r", 0.009485014686050744);
    model.component("comp1").geom("geom1").create("sph488", "Sphere");
    model.component("comp1").geom("geom1").feature("sph488")
         .set("pos", new double[]{0.2862525731831373, 0.8721201596172087, 0.7575395011645156});
    model.component("comp1").geom("geom1").feature("sph488").set("r", 0.006237000483711129);
    model.component("comp1").geom("geom1").create("sph489", "Sphere");
    model.component("comp1").geom("geom1").feature("sph489")
         .set("pos", new double[]{0.3284697203486146, 0.23246856659055626, 0.13264627297458217});
    model.component("comp1").geom("geom1").feature("sph489").set("r", 0.009983790575601486);
    model.component("comp1").geom("geom1").create("sph490", "Sphere");
    model.component("comp1").geom("geom1").feature("sph490")
         .set("pos", new double[]{0.43978454554861957, 0.17278315962609414, 0.5516666835952816});
    model.component("comp1").geom("geom1").feature("sph490").set("r", 0.009677887809544403);
    model.component("comp1").geom("geom1").create("sph491", "Sphere");
    model.component("comp1").geom("geom1").feature("sph491")
         .set("pos", new double[]{0.2911642021165911, 0.1652656612578557, 0.9590912100697593});
    model.component("comp1").geom("geom1").feature("sph491").set("r", 0.004723913872605491);
    model.component("comp1").geom("geom1").create("sph492", "Sphere");
    model.component("comp1").geom("geom1").feature("sph492")
         .set("pos", new double[]{0.482053727225169, 0.07878907551715854, 0.46109660223587096});
    model.component("comp1").geom("geom1").feature("sph492").set("r", 0.0037446776466195);
    model.component("comp1").geom("geom1").create("sph493", "Sphere");
    model.component("comp1").geom("geom1").feature("sph493")
         .set("pos", new double[]{0.2533426733227043, 0.5535330976269717, 0.11556715681943983});
    model.component("comp1").geom("geom1").feature("sph493").set("r", 0.0021665714366508413);
    model.component("comp1").geom("geom1").create("sph495", "Sphere");
    model.component("comp1").geom("geom1").feature("sph495")
         .set("pos", new double[]{0.3275187252789846, 0.7060996971491608, 0.7284562447632855});
    model.component("comp1").geom("geom1").feature("sph495").set("r", 0.007489390675892407);
    model.component("comp1").geom("geom1").create("sph496", "Sphere");
    model.component("comp1").geom("geom1").feature("sph496")
         .set("pos", new double[]{0.3449123471474624, 0.36025620897168653, 0.6156668284272956});
    model.component("comp1").geom("geom1").feature("sph496").set("r", 0.004080036981258646);
    model.component("comp1").geom("geom1").create("sph497", "Sphere");
    model.component("comp1").geom("geom1").feature("sph497")
         .set("pos", new double[]{0.29924860485372906, 0.868368206974504, 0.036253356222570504});
    model.component("comp1").geom("geom1").feature("sph497").set("r", 0.009103691318861615);
    model.component("comp1").geom("geom1").create("sph498", "Sphere");
    model.component("comp1").geom("geom1").feature("sph498")
         .set("pos", new double[]{0.3547978282093124, 0.7872367890057886, 0.7181265349811763});
    model.component("comp1").geom("geom1").feature("sph498").set("r", 0.0069430473638040025);
    model.component("comp1").geom("geom1").create("sph499", "Sphere");
    model.component("comp1").geom("geom1").feature("sph499")
         .set("pos", new double[]{0.4094350166576411, 0.5017542611484869, 0.8082033095839606});
    model.component("comp1").geom("geom1").feature("sph499").set("r", 0.005320970264306656);
    model.component("comp1").geom("geom1").create("sph500", "Sphere");
    model.component("comp1").geom("geom1").feature("sph500")
         .set("pos", new double[]{0.3805442499897744, 0.2531574620097837, 0.6039327634103088});
    model.component("comp1").geom("geom1").feature("sph500").set("r", 0.005284755873714088);
    model.component("comp1").geom("geom1").create("sph501", "Sphere");
    model.component("comp1").geom("geom1").feature("sph501")
         .set("pos", new double[]{0.3937450610131687, 0.17213976891254865, 0.16200682624622667});
    model.component("comp1").geom("geom1").feature("sph501").set("r", 0.003726143278028516);
    model.component("comp1").geom("geom1").create("sph502", "Sphere");
    model.component("comp1").geom("geom1").feature("sph502")
         .set("pos", new double[]{0.3574005716435417, 0.2703137423810042, 0.13509908792858275});
    model.component("comp1").geom("geom1").feature("sph502").set("r", 0.004753267670727942);
    model.component("comp1").geom("geom1").create("sph503", "Sphere");
    model.component("comp1").geom("geom1").feature("sph503")
         .set("pos", new double[]{0.2575925796563439, 0.2721684268800806, 0.461956658725449});
    model.component("comp1").geom("geom1").feature("sph503").set("r", 0.0013528948529250736);
    model.component("comp1").geom("geom1").create("sph504", "Sphere");
    model.component("comp1").geom("geom1").feature("sph504")
         .set("pos", new double[]{0.36909666843056205, 0.8979608123238312, 0.04222514786205893});
    model.component("comp1").geom("geom1").feature("sph504").set("r", 0.007536189531755144);
    model.component("comp1").geom("geom1").create("sph505", "Sphere");
    model.component("comp1").geom("geom1").feature("sph505")
         .set("pos", new double[]{0.3354767275049025, 0.5770891865179405, 0.850883625974705});
    model.component("comp1").geom("geom1").feature("sph505").set("r", 0.0026259455938657094);
    model.component("comp1").geom("geom1").create("sph506", "Sphere");
    model.component("comp1").geom("geom1").feature("sph506")
         .set("pos", new double[]{0.3189237079538296, 0.0655270813336116, 0.8186354908516222});
    model.component("comp1").geom("geom1").feature("sph506").set("r", 0.004151817567609188);
    model.component("comp1").geom("geom1").create("sph507", "Sphere");
    model.component("comp1").geom("geom1").feature("sph507")
         .set("pos", new double[]{0.3922554747157153, 0.979283691552091, 0.005997482162850158});
    model.component("comp1").geom("geom1").feature("sph507").set("r", 0.004416997988860111);
    model.component("comp1").geom("geom1").create("sph508", "Sphere");
    model.component("comp1").geom("geom1").feature("sph508")
         .set("pos", new double[]{0.4434887853164873, 0.8037183751956399, 0.7680037082304605});
    model.component("comp1").geom("geom1").feature("sph508").set("r", 0.002309051266289794);
    model.component("comp1").geom("geom1").create("sph509", "Sphere");
    model.component("comp1").geom("geom1").feature("sph509")
         .set("pos", new double[]{0.48912790927372296, 0.39739566884613137, 0.6007544249658462});
    model.component("comp1").geom("geom1").feature("sph509").set("r", 0.005832990019385464);
    model.component("comp1").geom("geom1").create("sph510", "Sphere");
    model.component("comp1").geom("geom1").feature("sph510")
         .set("pos", new double[]{0.3527474679630236, 0.7218012943718666, 0.23955936856173538});
    model.component("comp1").geom("geom1").feature("sph510").set("r", 0.0015703210409396349);
    model.component("comp1").geom("geom1").create("sph511", "Sphere");
    model.component("comp1").geom("geom1").feature("sph511")
         .set("pos", new double[]{0.41814903185542457, 0.29160909194848816, 0.7638909299761912});
    model.component("comp1").geom("geom1").feature("sph511").set("r", 0.009494448301658336);
    model.component("comp1").geom("geom1").create("sph512", "Sphere");
    model.component("comp1").geom("geom1").feature("sph512")
         .set("pos", new double[]{0.4920333356654419, 0.05086139314984597, 0.931940110681448});
    model.component("comp1").geom("geom1").feature("sph512").set("r", 0.001748482946272982);
    model.component("comp1").geom("geom1").create("sph513", "Sphere");
    model.component("comp1").geom("geom1").feature("sph513")
         .set("pos", new double[]{0.4377669258500215, 0.003348901500600151, 0.2558501532372686});
    model.component("comp1").geom("geom1").feature("sph513").set("r", 0.003275684899734351);
    model.component("comp1").geom("geom1").create("sph514", "Sphere");
    model.component("comp1").geom("geom1").feature("sph514")
         .set("pos", new double[]{0.38258333211667056, 0.12091415774716877, 0.3952767627402108});
    model.component("comp1").geom("geom1").feature("sph514").set("r", 0.00774190545984748);
    model.component("comp1").geom("geom1").create("sph515", "Sphere");
    model.component("comp1").geom("geom1").feature("sph515")
         .set("pos", new double[]{0.3914434673936967, 0.6665056120531317, 0.8378446075282635});
    model.component("comp1").geom("geom1").feature("sph515").set("r", 0.004379944195760883);
    model.component("comp1").geom("geom1").create("sph516", "Sphere");
    model.component("comp1").geom("geom1").feature("sph516")
         .set("pos", new double[]{0.3491878093539384, 0.14787504984274358, 0.8014851031829157});
    model.component("comp1").geom("geom1").feature("sph516").set("r", 0.005475082572796354);
    model.component("comp1").geom("geom1").create("sph517", "Sphere");
    model.component("comp1").geom("geom1").feature("sph517")
         .set("pos", new double[]{0.3535246377247847, 0.5181587621632866, 0.6627314207747236});
    model.component("comp1").geom("geom1").feature("sph517").set("r", 0.0074203336487310406);
    model.component("comp1").geom("geom1").create("sph518", "Sphere");
    model.component("comp1").geom("geom1").feature("sph518")
         .set("pos", new double[]{0.25914762104789296, 0.3184100671773216, 0.5951102965771397});

    return model;
  }

  public static Model run6(Model model) {
    model.component("comp1").geom("geom1").feature("sph518").set("r", 0.0024832503086278405);
    model.component("comp1").geom("geom1").create("sph519", "Sphere");
    model.component("comp1").geom("geom1").feature("sph519")
         .set("pos", new double[]{0.421066978884007, 0.8162502918425494, 0.4885668131864216});
    model.component("comp1").geom("geom1").feature("sph519").set("r", 0.0053794548215331285);
    model.component("comp1").geom("geom1").create("sph520", "Sphere");
    model.component("comp1").geom("geom1").feature("sph520")
         .set("pos", new double[]{0.46110834394677097, 0.5746591095146532, 0.7388777233756897});
    model.component("comp1").geom("geom1").feature("sph520").set("r", 0.0022084032134604237);
    model.component("comp1").geom("geom1").create("sph521", "Sphere");
    model.component("comp1").geom("geom1").feature("sph521")
         .set("pos", new double[]{0.48517773814825976, 0.29831302219758526, 0.7022920555670726});
    model.component("comp1").geom("geom1").feature("sph521").set("r", 0.007341981882474625);
    model.component("comp1").geom("geom1").create("sph522", "Sphere");
    model.component("comp1").geom("geom1").feature("sph522")
         .set("pos", new double[]{0.34975028362088073, 0.23290672036244375, 0.3453489074650653});
    model.component("comp1").geom("geom1").feature("sph522").set("r", 0.004291086998133265);
    model.component("comp1").geom("geom1").create("sph523", "Sphere");
    model.component("comp1").geom("geom1").feature("sph523")
         .set("pos", new double[]{0.3270982490997037, 0.2508343978433905, 0.5815525919682034});
    model.component("comp1").geom("geom1").feature("sph523").set("r", 0.009534670764924369);
    model.component("comp1").geom("geom1").create("sph524", "Sphere");
    model.component("comp1").geom("geom1").feature("sph524")
         .set("pos", new double[]{0.36852327386305195, 0.8319557732216688, 0.23219170910959164});
    model.component("comp1").geom("geom1").feature("sph524").set("r", 0.003322323610675792);
    model.component("comp1").geom("geom1").create("sph525", "Sphere");
    model.component("comp1").geom("geom1").feature("sph525")
         .set("pos", new double[]{0.40155284390575247, 0.54518721625961, 0.9701277050261606});
    model.component("comp1").geom("geom1").feature("sph525").set("r", 0.004840222709655281);
    model.component("comp1").geom("geom1").create("sph526", "Sphere");
    model.component("comp1").geom("geom1").feature("sph526")
         .set("pos", new double[]{0.4315681268846271, 0.9603033832028292, 0.41565699798381683});
    model.component("comp1").geom("geom1").feature("sph526").set("r", 0.007123332289556757);
    model.component("comp1").geom("geom1").create("sph527", "Sphere");
    model.component("comp1").geom("geom1").feature("sph527")
         .set("pos", new double[]{0.26479572011839925, 0.18685599137842496, 0.23939640778680935});
    model.component("comp1").geom("geom1").feature("sph527").set("r", 0.004198418335549461);
    model.component("comp1").geom("geom1").create("sph528", "Sphere");
    model.component("comp1").geom("geom1").feature("sph528")
         .set("pos", new double[]{0.43734483382703887, 0.5356926909411514, 0.6667448259303543});
    model.component("comp1").geom("geom1").feature("sph528").set("r", 0.0026515402036420468);
    model.component("comp1").geom("geom1").create("sph529", "Sphere");
    model.component("comp1").geom("geom1").feature("sph529")
         .set("pos", new double[]{0.31220795372886506, 0.32884290271057637, 0.7048664156338571});
    model.component("comp1").geom("geom1").feature("sph529").set("r", 0.008384159447554364);
    model.component("comp1").geom("geom1").create("sph530", "Sphere");
    model.component("comp1").geom("geom1").feature("sph530")
         .set("pos", new double[]{0.26158708803376424, 0.43554515314183284, 0.9045701879154732});
    model.component("comp1").geom("geom1").feature("sph530").set("r", 0.004534830513140256);
    model.component("comp1").geom("geom1").create("sph531", "Sphere");
    model.component("comp1").geom("geom1").feature("sph531")
         .set("pos", new double[]{0.334632779709624, 0.9849419595701386, 0.6430634898056674});
    model.component("comp1").geom("geom1").feature("sph531").set("r", 0.004681193604335873);
    model.component("comp1").geom("geom1").create("sph532", "Sphere");
    model.component("comp1").geom("geom1").feature("sph532")
         .set("pos", new double[]{0.2789227249679328, 0.7853774041386464, 0.7062879933505186});
    model.component("comp1").geom("geom1").feature("sph532").set("r", 0.004293982238240629);
    model.component("comp1").geom("geom1").create("sph533", "Sphere");
    model.component("comp1").geom("geom1").feature("sph533")
         .set("pos", new double[]{0.309576021390122, 0.1220846331499872, 0.7199060133153126});
    model.component("comp1").geom("geom1").feature("sph533").set("r", 0.009297242193237087);
    model.component("comp1").geom("geom1").create("sph534", "Sphere");
    model.component("comp1").geom("geom1").feature("sph534")
         .set("pos", new double[]{0.2958595761591882, 0.32082742862258384, 0.8150315546999684});
    model.component("comp1").geom("geom1").feature("sph534").set("r", 0.002830562577988261);
    model.component("comp1").geom("geom1").create("sph535", "Sphere");
    model.component("comp1").geom("geom1").feature("sph535")
         .set("pos", new double[]{0.2667814345025232, 0.464317527913891, 0.6818249049150733});
    model.component("comp1").geom("geom1").feature("sph535").set("r", 0.005855829445986677);
    model.component("comp1").geom("geom1").create("sph537", "Sphere");
    model.component("comp1").geom("geom1").feature("sph537")
         .set("pos", new double[]{0.4257301225455436, 0.9760311654165581, 0.4290678256262342});
    model.component("comp1").geom("geom1").feature("sph537").set("r", 0.006052588458320118);
    model.component("comp1").geom("geom1").create("sph538", "Sphere");
    model.component("comp1").geom("geom1").feature("sph538")
         .set("pos", new double[]{0.26061981992226835, 0.041740264641402694, 0.5886675946384138});
    model.component("comp1").geom("geom1").feature("sph538").set("r", 0.008929599514088577);
    model.component("comp1").geom("geom1").create("sph539", "Sphere");
    model.component("comp1").geom("geom1").feature("sph539")
         .set("pos", new double[]{0.31398377261970506, 0.2796244006723748, 0.31978417807382625});
    model.component("comp1").geom("geom1").feature("sph539").set("r", 0.003803044559879806);
    model.component("comp1").geom("geom1").create("sph540", "Sphere");
    model.component("comp1").geom("geom1").feature("sph540")
         .set("pos", new double[]{0.3912526767115515, 0.7846654427008202, 0.8252036580247682});
    model.component("comp1").geom("geom1").feature("sph540").set("r", 0.007560529265290807);
    model.component("comp1").geom("geom1").create("sph541", "Sphere");
    model.component("comp1").geom("geom1").feature("sph541")
         .set("pos", new double[]{0.35512683859327665, 0.42262535469856527, 0.9189456897256805});
    model.component("comp1").geom("geom1").feature("sph541").set("r", 0.00858641373371154);
    model.component("comp1").geom("geom1").create("sph542", "Sphere");
    model.component("comp1").geom("geom1").feature("sph542")
         .set("pos", new double[]{0.27595322942574696, 0.5416000599573418, 0.3580104498779341});
    model.component("comp1").geom("geom1").feature("sph542").set("r", 0.006955872351439695);
    model.component("comp1").geom("geom1").create("sph543", "Sphere");
    model.component("comp1").geom("geom1").feature("sph543")
         .set("pos", new double[]{0.26303074683958183, 0.6099626275779746, 0.7192012093875351});
    model.component("comp1").geom("geom1").feature("sph543").set("r", 0.00988691490744727);
    model.component("comp1").geom("geom1").create("sph544", "Sphere");
    model.component("comp1").geom("geom1").feature("sph544")
         .set("pos", new double[]{0.49000000817485473, 0.8569478475779118, 0.9126600067385358});
    model.component("comp1").geom("geom1").feature("sph544").set("r", 0.0036001609422161972);
    model.component("comp1").geom("geom1").create("sph545", "Sphere");
    model.component("comp1").geom("geom1").feature("sph545")
         .set("pos", new double[]{0.39230410538957267, 0.2951320288478596, 0.8482097519561872});
    model.component("comp1").geom("geom1").feature("sph545").set("r", 0.0011730885341639363);
    model.component("comp1").geom("geom1").create("sph546", "Sphere");
    model.component("comp1").geom("geom1").feature("sph546")
         .set("pos", new double[]{0.3841986376923983, 0.11974933273890617, 0.5396841693888547});
    model.component("comp1").geom("geom1").feature("sph546").set("r", 0.006695646912234662);
    model.component("comp1").geom("geom1").create("sph547", "Sphere");
    model.component("comp1").geom("geom1").feature("sph547")
         .set("pos", new double[]{0.4828805808936258, 0.5839135148525262, 0.9611494577336169});
    model.component("comp1").geom("geom1").feature("sph547").set("r", 0.006687137317207841);
    model.component("comp1").geom("geom1").create("sph548", "Sphere");
    model.component("comp1").geom("geom1").feature("sph548")
         .set("pos", new double[]{0.4096498791796645, 0.505793907383993, 0.4666778269192186});
    model.component("comp1").geom("geom1").feature("sph548").set("r", 0.009654455040459961);
    model.component("comp1").geom("geom1").create("sph549", "Sphere");
    model.component("comp1").geom("geom1").feature("sph549")
         .set("pos", new double[]{0.2655681998219644, 0.12077000584477712, 0.1092451080834888});
    model.component("comp1").geom("geom1").feature("sph549").set("r", 0.009013407050042044);
    model.component("comp1").geom("geom1").create("sph550", "Sphere");
    model.component("comp1").geom("geom1").feature("sph550")
         .set("pos", new double[]{0.3374181823945028, 0.6358128088763635, 0.602161313005763});
    model.component("comp1").geom("geom1").feature("sph550").set("r", 0.007812417926089494);
    model.component("comp1").geom("geom1").create("sph551", "Sphere");
    model.component("comp1").geom("geom1").feature("sph551")
         .set("pos", new double[]{0.3826095603328356, 0.6438402834012081, 0.9370060717487667});
    model.component("comp1").geom("geom1").feature("sph551").set("r", 0.004472451727682785);
    model.component("comp1").geom("geom1").create("sph552", "Sphere");
    model.component("comp1").geom("geom1").feature("sph552")
         .set("pos", new double[]{0.40217813385970286, 0.0731977305512983, 0.9466257881678666});
    model.component("comp1").geom("geom1").feature("sph552").set("r", 0.006180706655748834);
    model.component("comp1").geom("geom1").create("sph553", "Sphere");
    model.component("comp1").geom("geom1").feature("sph553")
         .set("pos", new double[]{0.44685206125428595, 0.05546517794377603, 0.4218201021695817});
    model.component("comp1").geom("geom1").feature("sph553").set("r", 0.005752737351184476);
    model.component("comp1").geom("geom1").create("sph554", "Sphere");
    model.component("comp1").geom("geom1").feature("sph554")
         .set("pos", new double[]{0.31828788943247693, 0.7895226862915949, 0.6230460390635211});
    model.component("comp1").geom("geom1").feature("sph554").set("r", 0.0033127791323743147);
    model.component("comp1").geom("geom1").create("sph555", "Sphere");
    model.component("comp1").geom("geom1").feature("sph555")
         .set("pos", new double[]{0.25749918069561206, 0.9603179891610483, 0.9574421007757523});
    model.component("comp1").geom("geom1").feature("sph555").set("r", 0.004957707806585633);
    model.component("comp1").geom("geom1").create("sph556", "Sphere");
    model.component("comp1").geom("geom1").feature("sph556")
         .set("pos", new double[]{0.2630499603227049, 0.5300207053987772, 0.9487402954188208});
    model.component("comp1").geom("geom1").feature("sph556").set("r", 0.0029579698925203462);
    model.component("comp1").geom("geom1").create("sph557", "Sphere");
    model.component("comp1").geom("geom1").feature("sph557")
         .set("pos", new double[]{0.3946090092922119, 0.30716102253709077, 0.33308741429227073});
    model.component("comp1").geom("geom1").feature("sph557").set("r", 0.009193562611884417);
    model.component("comp1").geom("geom1").create("sph558", "Sphere");
    model.component("comp1").geom("geom1").feature("sph558")
         .set("pos", new double[]{0.37309523090096725, 0.13781605977401734, 0.2529946841596351});
    model.component("comp1").geom("geom1").feature("sph558").set("r", 0.009081221963374249);
    model.component("comp1").geom("geom1").create("sph559", "Sphere");
    model.component("comp1").geom("geom1").feature("sph559")
         .set("pos", new double[]{0.28351518431163847, 0.46330241704020747, 0.9131459125955351});
    model.component("comp1").geom("geom1").feature("sph559").set("r", 0.003491154113207492);
    model.component("comp1").geom("geom1").create("sph560", "Sphere");
    model.component("comp1").geom("geom1").feature("sph560")
         .set("pos", new double[]{0.27412012878417064, 0.012436723972376308, 0.27938872190542235});
    model.component("comp1").geom("geom1").feature("sph560").set("r", 0.007019042886930349);
    model.component("comp1").geom("geom1").create("sph561", "Sphere");
    model.component("comp1").geom("geom1").feature("sph561")
         .set("pos", new double[]{0.44182716522954346, 0.9630226800097987, 0.388526053729784});
    model.component("comp1").geom("geom1").feature("sph561").set("r", 0.004264236413145463);
    model.component("comp1").geom("geom1").create("sph562", "Sphere");
    model.component("comp1").geom("geom1").feature("sph562")
         .set("pos", new double[]{0.4916184773242356, 0.7421387084187538, 0.6342338098882677});
    model.component("comp1").geom("geom1").feature("sph562").set("r", 0.007180210268351751);
    model.component("comp1").geom("geom1").create("sph563", "Sphere");
    model.component("comp1").geom("geom1").feature("sph563")
         .set("pos", new double[]{0.331405813949271, 0.9119844145554226, 0.20202366187906565});
    model.component("comp1").geom("geom1").feature("sph563").set("r", 0.0017026736876047388);
    model.component("comp1").geom("geom1").create("sph564", "Sphere");
    model.component("comp1").geom("geom1").feature("sph564")
         .set("pos", new double[]{0.4207071720754091, 0.36862153658575836, 0.5286729207851995});
    model.component("comp1").geom("geom1").feature("sph564").set("r", 0.008592313233458874);
    model.component("comp1").geom("geom1").create("sph565", "Sphere");
    model.component("comp1").geom("geom1").feature("sph565")
         .set("pos", new double[]{0.42599392267273944, 0.5163610691223488, 0.13739487527303554});
    model.component("comp1").geom("geom1").feature("sph565").set("r", 0.0058852582187753225);
    model.component("comp1").geom("geom1").create("sph566", "Sphere");
    model.component("comp1").geom("geom1").feature("sph566")
         .set("pos", new double[]{0.3530604707848423, 0.9557204240422253, 0.2869607157037484});
    model.component("comp1").geom("geom1").feature("sph566").set("r", 0.007961092043697215);
    model.component("comp1").geom("geom1").create("sph567", "Sphere");
    model.component("comp1").geom("geom1").feature("sph567")
         .set("pos", new double[]{0.33449824621038043, 0.5718299306243527, 0.8922101274272745});
    model.component("comp1").geom("geom1").feature("sph567").set("r", 0.003367709022669262);
    model.component("comp1").geom("geom1").create("sph568", "Sphere");
    model.component("comp1").geom("geom1").feature("sph568")
         .set("pos", new double[]{0.32105943629710954, 0.5812573076406694, 0.4545704743016121});
    model.component("comp1").geom("geom1").feature("sph568").set("r", 0.0025865347612601336);
    model.component("comp1").geom("geom1").create("sph569", "Sphere");
    model.component("comp1").geom("geom1").feature("sph569")
         .set("pos", new double[]{0.4519596050289784, 0.9196175575160985, 0.4814948649321075});
    model.component("comp1").geom("geom1").feature("sph569").set("r", 0.0050259059853015285);
    model.component("comp1").geom("geom1").create("sph570", "Sphere");
    model.component("comp1").geom("geom1").feature("sph570")
         .set("pos", new double[]{0.4459377619147187, 0.5181024422335899, 0.2972725618766223});
    model.component("comp1").geom("geom1").feature("sph570").set("r", 0.007186166159025465);
    model.component("comp1").geom("geom1").create("sph571", "Sphere");
    model.component("comp1").geom("geom1").feature("sph571")
         .set("pos", new double[]{0.3951295343673393, 0.8961475351948432, 0.05844306186226489});
    model.component("comp1").geom("geom1").feature("sph571").set("r", 0.006742761379500554);
    model.component("comp1").geom("geom1").create("sph572", "Sphere");
    model.component("comp1").geom("geom1").feature("sph572")
         .set("pos", new double[]{0.382975064933002, 0.02457913444759858, 0.3475569199964763});
    model.component("comp1").geom("geom1").feature("sph572").set("r", 0.009191182484201203);
    model.component("comp1").geom("geom1").create("sph574", "Sphere");
    model.component("comp1").geom("geom1").feature("sph574")
         .set("pos", new double[]{0.4528833907875333, 0.5475292216758975, 0.6808899487920913});
    model.component("comp1").geom("geom1").feature("sph574").set("r", 0.00393971706663407);
    model.component("comp1").geom("geom1").create("sph576", "Sphere");
    model.component("comp1").geom("geom1").feature("sph576")
         .set("pos", new double[]{0.4694124857638146, 0.4199017670399174, 0.9056139782124767});
    model.component("comp1").geom("geom1").feature("sph576").set("r", 0.006222233499141705);
    model.component("comp1").geom("geom1").create("sph577", "Sphere");
    model.component("comp1").geom("geom1").feature("sph577")
         .set("pos", new double[]{0.4038734598931705, 0.8293044577990343, 0.5638824394693707});
    model.component("comp1").geom("geom1").feature("sph577").set("r", 0.005531750378041619);
    model.component("comp1").geom("geom1").create("sph578", "Sphere");
    model.component("comp1").geom("geom1").feature("sph578")
         .set("pos", new double[]{0.4934953125889974, 0.24677376188856498, 0.7097396264209919});
    model.component("comp1").geom("geom1").feature("sph578").set("r", 0.0018187240536600715);
    model.component("comp1").geom("geom1").create("sph579", "Sphere");
    model.component("comp1").geom("geom1").feature("sph579")
         .set("pos", new double[]{0.3699286140061679, 0.24678103803164986, 0.7196866600999257});
    model.component("comp1").geom("geom1").feature("sph579").set("r", 0.005546020947559649);
    model.component("comp1").geom("geom1").create("sph580", "Sphere");
    model.component("comp1").geom("geom1").feature("sph580")
         .set("pos", new double[]{0.49563670792226544, 0.8439816165575499, 0.5343698624634211});
    model.component("comp1").geom("geom1").feature("sph580").set("r", 0.002015094383478885);
    model.component("comp1").geom("geom1").create("sph581", "Sphere");
    model.component("comp1").geom("geom1").feature("sph581")
         .set("pos", new double[]{0.3236750561372649, 0.5015761260524231, 0.8757591366086367});
    model.component("comp1").geom("geom1").feature("sph581").set("r", 0.004820976604522086);
    model.component("comp1").geom("geom1").create("sph582", "Sphere");
    model.component("comp1").geom("geom1").feature("sph582")
         .set("pos", new double[]{0.37513062930018015, 0.2363948108308642, 0.3382809460874561});
    model.component("comp1").geom("geom1").feature("sph582").set("r", 0.0034750576063061526);
    model.component("comp1").geom("geom1").create("sph583", "Sphere");
    model.component("comp1").geom("geom1").feature("sph583")
         .set("pos", new double[]{0.49497377583217345, 0.5711095950396187, 0.7315521743569052});
    model.component("comp1").geom("geom1").feature("sph583").set("r", 0.002712344580309992);
    model.component("comp1").geom("geom1").create("sph584", "Sphere");
    model.component("comp1").geom("geom1").feature("sph584")
         .set("pos", new double[]{0.34203392332255333, 0.8911601405612168, 0.08600436994343094});
    model.component("comp1").geom("geom1").feature("sph584").set("r", 0.0018842492210683305);
    model.component("comp1").geom("geom1").create("sph585", "Sphere");
    model.component("comp1").geom("geom1").feature("sph585")
         .set("pos", new double[]{0.4057299861681619, 0.6221776647713357, 0.8365431141069176});
    model.component("comp1").geom("geom1").feature("sph585").set("r", 0.0024893490550565184);
    model.component("comp1").geom("geom1").create("sph586", "Sphere");
    model.component("comp1").geom("geom1").feature("sph586")
         .set("pos", new double[]{0.29224118901440527, 0.26390694381813357, 0.4288279508232259});
    model.component("comp1").geom("geom1").feature("sph586").set("r", 0.009419434874842793);
    model.component("comp1").geom("geom1").create("sph587", "Sphere");
    model.component("comp1").geom("geom1").feature("sph587")
         .set("pos", new double[]{0.2683209415832129, 0.22704274240157385, 0.4811400673535812});
    model.component("comp1").geom("geom1").feature("sph587").set("r", 0.0010081295696912466);
    model.component("comp1").geom("geom1").create("sph588", "Sphere");
    model.component("comp1").geom("geom1").feature("sph588")
         .set("pos", new double[]{0.4667117161742073, 0.3254199184061822, 0.921851125255162});
    model.component("comp1").geom("geom1").feature("sph588").set("r", 0.0032637046435175154);
    model.component("comp1").geom("geom1").create("sph591", "Sphere");
    model.component("comp1").geom("geom1").feature("sph591")
         .set("pos", new double[]{0.49289727738885497, 0.23551750029364257, 0.3552342136797862});
    model.component("comp1").geom("geom1").feature("sph591").set("r", 0.006176000048229858);
    model.component("comp1").geom("geom1").create("sph592", "Sphere");
    model.component("comp1").geom("geom1").feature("sph592")
         .set("pos", new double[]{0.3412133492256504, 0.10349191732822666, 0.3607535336618819});
    model.component("comp1").geom("geom1").feature("sph592").set("r", 0.0033660205930945994);
    model.component("comp1").geom("geom1").create("sph593", "Sphere");
    model.component("comp1").geom("geom1").feature("sph593")
         .set("pos", new double[]{0.3282691328253424, 0.37423759364230913, 0.9364818208851705});
    model.component("comp1").geom("geom1").feature("sph593").set("r", 0.008990785283179498);
    model.component("comp1").geom("geom1").create("sph595", "Sphere");
    model.component("comp1").geom("geom1").feature("sph595")
         .set("pos", new double[]{0.28351442136388266, 0.23637808116394743, 0.14557781087519558});
    model.component("comp1").geom("geom1").feature("sph595").set("r", 0.005180413178987582);
    model.component("comp1").geom("geom1").create("sph596", "Sphere");
    model.component("comp1").geom("geom1").feature("sph596")
         .set("pos", new double[]{0.3464173661880834, 0.9435009022840057, 0.2661335925745546});
    model.component("comp1").geom("geom1").feature("sph596").set("r", 0.004256211152522255);
    model.component("comp1").geom("geom1").create("sph597", "Sphere");
    model.component("comp1").geom("geom1").feature("sph597")
         .set("pos", new double[]{0.449574209162088, 0.812302427929195, 0.7477136524908417});
    model.component("comp1").geom("geom1").feature("sph597").set("r", 0.005251859607848652);
    model.component("comp1").geom("geom1").create("sph598", "Sphere");
    model.component("comp1").geom("geom1").feature("sph598")
         .set("pos", new double[]{0.3737790136926579, 0.1884649121436699, 0.19063712821479586});
    model.component("comp1").geom("geom1").feature("sph598").set("r", 0.0035905038592606566);
    model.component("comp1").geom("geom1").create("sph599", "Sphere");
    model.component("comp1").geom("geom1").feature("sph599")
         .set("pos", new double[]{0.4322990810515154, 0.526322534187541, 0.8828762696924185});
    model.component("comp1").geom("geom1").feature("sph599").set("r", 0.004922570918244799);
    model.component("comp1").geom("geom1").create("sph600", "Sphere");
    model.component("comp1").geom("geom1").feature("sph600")
         .set("pos", new double[]{0.26584362667051037, 0.5672589050567285, 0.6073102868381985});
    model.component("comp1").geom("geom1").feature("sph600").set("r", 0.008478179179998184);
    model.component("comp1").geom("geom1").create("sph601", "Sphere");
    model.component("comp1").geom("geom1").feature("sph601")
         .set("pos", new double[]{0.2650146719942473, 0.5305032083916578, 0.2104815474929196});
    model.component("comp1").geom("geom1").feature("sph601").set("r", 0.009654176298700735);
    model.component("comp1").geom("geom1").create("sph602", "Sphere");
    model.component("comp1").geom("geom1").feature("sph602")
         .set("pos", new double[]{0.39661264614039055, 0.7717956181944765, 0.7740502169075353});
    model.component("comp1").geom("geom1").feature("sph602").set("r", 0.001482966156624302);
    model.component("comp1").geom("geom1").create("sph603", "Sphere");
    model.component("comp1").geom("geom1").feature("sph603")
         .set("pos", new double[]{0.3519734392880652, 0.04566893732055307, 0.24848044589352564});
    model.component("comp1").geom("geom1").feature("sph603").set("r", 0.001272595691403161);
    model.component("comp1").geom("geom1").create("sph604", "Sphere");
    model.component("comp1").geom("geom1").feature("sph604")
         .set("pos", new double[]{0.30535412376897764, 0.33999873436697253, 0.27863597751354074});
    model.component("comp1").geom("geom1").feature("sph604").set("r", 0.002735926324821535);
    model.component("comp1").geom("geom1").create("sph605", "Sphere");
    model.component("comp1").geom("geom1").feature("sph605")
         .set("pos", new double[]{0.340953427704786, 0.8865566929872359, 0.187204277634712});
    model.component("comp1").geom("geom1").feature("sph605").set("r", 0.009660519201948384);
    model.component("comp1").geom("geom1").create("sph606", "Sphere");
    model.component("comp1").geom("geom1").feature("sph606")
         .set("pos", new double[]{0.27224407044161886, 0.4633476449083558, 0.013297386693348021});
    model.component("comp1").geom("geom1").feature("sph606").set("r", 0.00787372180469393);
    model.component("comp1").geom("geom1").create("sph607", "Sphere");
    model.component("comp1").geom("geom1").feature("sph607")
         .set("pos", new double[]{0.48015009280729315, 0.042817723743772275, 0.9266509181630919});
    model.component("comp1").geom("geom1").feature("sph607").set("r", 0.008292616867624926);
    model.component("comp1").geom("geom1").create("sph608", "Sphere");
    model.component("comp1").geom("geom1").feature("sph608")
         .set("pos", new double[]{0.3419636408374358, 0.9023634053348997, 0.2995027645714992});
    model.component("comp1").geom("geom1").feature("sph608").set("r", 0.007964685023422177);
    model.component("comp1").geom("geom1").create("sph609", "Sphere");
    model.component("comp1").geom("geom1").feature("sph609")
         .set("pos", new double[]{0.27795554844113524, 0.6554688651109147, 0.03400720624693562});
    model.component("comp1").geom("geom1").feature("sph609").set("r", 0.004683657810112859);
    model.component("comp1").geom("geom1").create("sph610", "Sphere");
    model.component("comp1").geom("geom1").feature("sph610")
         .set("pos", new double[]{0.4188326263605317, 0.8177912692159476, 0.15369692164484225});
    model.component("comp1").geom("geom1").feature("sph610").set("r", 0.005364147476791336);
    model.component("comp1").geom("geom1").create("sph611", "Sphere");
    model.component("comp1").geom("geom1").feature("sph611")
         .set("pos", new double[]{0.42635743212892013, 0.5586428048654882, 0.5833263744288454});
    model.component("comp1").geom("geom1").feature("sph611").set("r", 0.0077868132962384574);
    model.component("comp1").geom("geom1").create("sph612", "Sphere");
    model.component("comp1").geom("geom1").feature("sph612")
         .set("pos", new double[]{0.3997517575618622, 0.3819538066208816, 0.866241800992012});
    model.component("comp1").geom("geom1").feature("sph612").set("r", 0.0018214364877110032);
    model.component("comp1").geom("geom1").create("sph613", "Sphere");
    model.component("comp1").geom("geom1").feature("sph613")
         .set("pos", new double[]{0.3935639061909121, 0.4271320843293299, 0.8733888849159046});
    model.component("comp1").geom("geom1").feature("sph613").set("r", 0.003817889935623912);
    model.component("comp1").geom("geom1").create("sph614", "Sphere");
    model.component("comp1").geom("geom1").feature("sph614")
         .set("pos", new double[]{0.272468069171397, 0.7470219285669764, 0.413468929687431});
    model.component("comp1").geom("geom1").feature("sph614").set("r", 0.0032852500029027015);
    model.component("comp1").geom("geom1").create("sph615", "Sphere");
    model.component("comp1").geom("geom1").feature("sph615")
         .set("pos", new double[]{0.2625666130808538, 0.9464115033619787, 0.8728589620333249});
    model.component("comp1").geom("geom1").feature("sph615").set("r", 0.006301885232136624);
    model.component("comp1").geom("geom1").create("sph616", "Sphere");
    model.component("comp1").geom("geom1").feature("sph616")
         .set("pos", new double[]{0.2606469732558975, 0.379590799132863, 0.972462240432177});
    model.component("comp1").geom("geom1").feature("sph616").set("r", 0.006614811105195498);
    model.component("comp1").geom("geom1").create("sph617", "Sphere");
    model.component("comp1").geom("geom1").feature("sph617")
         .set("pos", new double[]{0.2950826163229631, 0.4611587945219373, 0.9600802216556902});
    model.component("comp1").geom("geom1").feature("sph617").set("r", 0.0071319732286621125);
    model.component("comp1").geom("geom1").create("sph618", "Sphere");
    model.component("comp1").geom("geom1").feature("sph618")
         .set("pos", new double[]{0.26167986791290065, 0.6183797640818989, 0.2738760809087824});
    model.component("comp1").geom("geom1").feature("sph618").set("r", 0.005812373569749341);
    model.component("comp1").geom("geom1").create("sph619", "Sphere");
    model.component("comp1").geom("geom1").feature("sph619")
         .set("pos", new double[]{0.3510940422231038, 0.5583019253544758, 0.018865930870669432});
    model.component("comp1").geom("geom1").feature("sph619").set("r", 0.0018896135668921394);
    model.component("comp1").geom("geom1").create("sph620", "Sphere");
    model.component("comp1").geom("geom1").feature("sph620")
         .set("pos", new double[]{0.3776656449134573, 0.7903630125477137, 0.4244720233384881});
    model.component("comp1").geom("geom1").feature("sph620").set("r", 0.006031421277723528);
    model.component("comp1").geom("geom1").create("sph621", "Sphere");
    model.component("comp1").geom("geom1").feature("sph621")
         .set("pos", new double[]{0.43260738464650583, 0.8923951700775535, 0.38146961534965407});
    model.component("comp1").geom("geom1").feature("sph621").set("r", 0.0059810538670289765);
    model.component("comp1").geom("geom1").create("sph622", "Sphere");
    model.component("comp1").geom("geom1").feature("sph622")
         .set("pos", new double[]{0.42115598416074423, 0.049130240961369344, 0.7969019307391101});
    model.component("comp1").geom("geom1").feature("sph622").set("r", 0.006414701462048319);
    model.component("comp1").geom("geom1").create("sph623", "Sphere");
    model.component("comp1").geom("geom1").feature("sph623")
         .set("pos", new double[]{0.4160626978044164, 0.47191324513386845, 0.7005598242044797});
    model.component("comp1").geom("geom1").feature("sph623").set("r", 0.0043968716669385444);
    model.component("comp1").geom("geom1").create("sph624", "Sphere");
    model.component("comp1").geom("geom1").feature("sph624")
         .set("pos", new double[]{0.30253089540151273, 0.6597354650231823, 0.84604025091011});
    model.component("comp1").geom("geom1").feature("sph624").set("r", 0.0075189788131220115);
    model.component("comp1").geom("geom1").create("sph625", "Sphere");
    model.component("comp1").geom("geom1").feature("sph625")
         .set("pos", new double[]{0.4379347485037296, 0.6329900163981749, 0.9522859526189013});
    model.component("comp1").geom("geom1").feature("sph625").set("r", 0.0031201048045447735);
    model.component("comp1").geom("geom1").create("sph626", "Sphere");
    model.component("comp1").geom("geom1").feature("sph626")
         .set("pos", new double[]{0.29088040331023257, 0.31337688078006026, 0.259576687833198});
    model.component("comp1").geom("geom1").feature("sph626").set("r", 0.0033422191956258476);
    model.component("comp1").geom("geom1").create("sph627", "Sphere");
    model.component("comp1").geom("geom1").feature("sph627")
         .set("pos", new double[]{0.4296354617114022, 0.6670339153989728, 0.22081012062875263});

    return model;
  }

  public static Model run7(Model model) {
    model.component("comp1").geom("geom1").feature("sph627").set("r", 0.007811494844261617);
    model.component("comp1").geom("geom1").create("sph628", "Sphere");
    model.component("comp1").geom("geom1").feature("sph628")
         .set("pos", new double[]{0.48114716930441304, 0.5310523205068144, 0.646756837318288});
    model.component("comp1").geom("geom1").feature("sph628").set("r", 0.00875626126695181);
    model.component("comp1").geom("geom1").create("sph630", "Sphere");
    model.component("comp1").geom("geom1").feature("sph630")
         .set("pos", new double[]{0.4732963326067732, 0.8564501326418382, 0.4618478629011358});
    model.component("comp1").geom("geom1").feature("sph630").set("r", 0.002717650037477386);
    model.component("comp1").geom("geom1").create("sph631", "Sphere");
    model.component("comp1").geom("geom1").feature("sph631")
         .set("pos", new double[]{0.4809888937836831, 0.22476397953493624, 0.5530809350634505});
    model.component("comp1").geom("geom1").feature("sph631").set("r", 0.0043052627130415345);
    model.component("comp1").geom("geom1").create("sph632", "Sphere");
    model.component("comp1").geom("geom1").feature("sph632")
         .set("pos", new double[]{0.2987210652528917, 0.6037168325248843, 0.6617001887595776});
    model.component("comp1").geom("geom1").feature("sph632").set("r", 0.0014904833998794639);
    model.component("comp1").geom("geom1").create("sph633", "Sphere");
    model.component("comp1").geom("geom1").feature("sph633")
         .set("pos", new double[]{0.46279588737694055, 0.9872584157173293, 0.7605746711826367});
    model.component("comp1").geom("geom1").feature("sph633").set("r", 0.006228962368059158);
    model.component("comp1").geom("geom1").create("sph634", "Sphere");
    model.component("comp1").geom("geom1").feature("sph634")
         .set("pos", new double[]{0.4550202131429479, 0.12432460405202396, 0.6813698765395944});
    model.component("comp1").geom("geom1").feature("sph634").set("r", 0.00518582605729383);
    model.component("comp1").geom("geom1").create("sph635", "Sphere");
    model.component("comp1").geom("geom1").feature("sph635")
         .set("pos", new double[]{0.29816401088345, 0.9675752414793728, 0.34026793676579875});
    model.component("comp1").geom("geom1").feature("sph635").set("r", 0.005665040087080906);
    model.component("comp1").geom("geom1").create("sph636", "Sphere");
    model.component("comp1").geom("geom1").feature("sph636")
         .set("pos", new double[]{0.4646974473137452, 0.5066013697471187, 0.12017093162735358});
    model.component("comp1").geom("geom1").feature("sph636").set("r", 0.006538810653670451);
    model.component("comp1").geom("geom1").create("sph637", "Sphere");
    model.component("comp1").geom("geom1").feature("sph637")
         .set("pos", new double[]{0.3407602474977377, 0.9749816320875848, 0.8774012434493872});
    model.component("comp1").geom("geom1").feature("sph637").set("r", 0.00836865175912561);
    model.component("comp1").geom("geom1").create("sph638", "Sphere");
    model.component("comp1").geom("geom1").feature("sph638")
         .set("pos", new double[]{0.34155903936582266, 0.7526654679792518, 0.9778853750126608});
    model.component("comp1").geom("geom1").feature("sph638").set("r", 0.008681044000140616);
    model.component("comp1").geom("geom1").create("sph639", "Sphere");
    model.component("comp1").geom("geom1").feature("sph639")
         .set("pos", new double[]{0.36801885181777894, 0.02023444294406567, 0.6979066729324389});
    model.component("comp1").geom("geom1").feature("sph639").set("r", 0.005736894507561982);
    model.component("comp1").geom("geom1").create("sph640", "Sphere");
    model.component("comp1").geom("geom1").feature("sph640")
         .set("pos", new double[]{0.31627182428378, 0.31825287848364225, 0.5006652055463087});
    model.component("comp1").geom("geom1").feature("sph640").set("r", 0.008726298117416688);
    model.component("comp1").geom("geom1").create("sph642", "Sphere");
    model.component("comp1").geom("geom1").feature("sph642")
         .set("pos", new double[]{0.3640211774893892, 0.9718399241705986, 0.9401243514010231});
    model.component("comp1").geom("geom1").feature("sph642").set("r", 0.004654335722794917);
    model.component("comp1").geom("geom1").create("sph643", "Sphere");
    model.component("comp1").geom("geom1").feature("sph643")
         .set("pos", new double[]{0.46891906315603843, 0.08210208916580244, 0.5076009944821852});
    model.component("comp1").geom("geom1").feature("sph643").set("r", 0.002257571363857895);
    model.component("comp1").geom("geom1").create("sph644", "Sphere");
    model.component("comp1").geom("geom1").feature("sph644")
         .set("pos", new double[]{0.34213692093957226, 0.7421355994999497, 0.42487920578621036});
    model.component("comp1").geom("geom1").feature("sph644").set("r", 0.0024751891009878882);
    model.component("comp1").geom("geom1").create("sph645", "Sphere");
    model.component("comp1").geom("geom1").feature("sph645")
         .set("pos", new double[]{0.42608797118158387, 0.9355214698150618, 0.533591588138484});
    model.component("comp1").geom("geom1").feature("sph645").set("r", 0.008262561588142005);
    model.component("comp1").geom("geom1").create("sph646", "Sphere");
    model.component("comp1").geom("geom1").feature("sph646")
         .set("pos", new double[]{0.33363794701330407, 0.34828157718527997, 0.4021459385598056});
    model.component("comp1").geom("geom1").feature("sph646").set("r", 0.00821933158589016);
    model.component("comp1").geom("geom1").create("sph647", "Sphere");
    model.component("comp1").geom("geom1").feature("sph647")
         .set("pos", new double[]{0.2795413296200497, 0.5189194764689622, 0.10059185105246002});
    model.component("comp1").geom("geom1").feature("sph647").set("r", 0.004698241608682802);
    model.component("comp1").geom("geom1").create("sph648", "Sphere");
    model.component("comp1").geom("geom1").feature("sph648")
         .set("pos", new double[]{0.2733548768263734, 0.4506007212890593, 0.28857295746982575});
    model.component("comp1").geom("geom1").feature("sph648").set("r", 0.009007859222377877);
    model.component("comp1").geom("geom1").create("sph649", "Sphere");
    model.component("comp1").geom("geom1").feature("sph649")
         .set("pos", new double[]{0.444600262124732, 0.7139033779312207, 0.1476429675816089});
    model.component("comp1").geom("geom1").feature("sph649").set("r", 0.002393824740890312);
    model.component("comp1").geom("geom1").create("sph650", "Sphere");
    model.component("comp1").geom("geom1").feature("sph650")
         .set("pos", new double[]{0.44422154205368397, 0.7696723616513146, 0.09773888478001484});
    model.component("comp1").geom("geom1").feature("sph650").set("r", 0.006694890769956792);
    model.component("comp1").geom("geom1").create("sph651", "Sphere");
    model.component("comp1").geom("geom1").feature("sph651")
         .set("pos", new double[]{0.4259083637622182, 0.8569730820235436, 0.5079289892483079});
    model.component("comp1").geom("geom1").feature("sph651").set("r", 0.007169614471411987);
    model.component("comp1").geom("geom1").create("sph652", "Sphere");
    model.component("comp1").geom("geom1").feature("sph652")
         .set("pos", new double[]{0.48648852633648526, 0.7934582708287999, 0.5581260796900066});
    model.component("comp1").geom("geom1").feature("sph652").set("r", 0.005149846002730217);
    model.component("comp1").geom("geom1").create("sph653", "Sphere");
    model.component("comp1").geom("geom1").feature("sph653")
         .set("pos", new double[]{0.45856447465627764, 0.4557907195127179, 0.09592379589351124});
    model.component("comp1").geom("geom1").feature("sph653").set("r", 0.003975553641801516);
    model.component("comp1").geom("geom1").create("sph654", "Sphere");
    model.component("comp1").geom("geom1").feature("sph654")
         .set("pos", new double[]{0.4642023820162211, 0.4488090627030157, 0.019297093104186508});
    model.component("comp1").geom("geom1").feature("sph654").set("r", 0.005094138454420959);
    model.component("comp1").geom("geom1").create("sph655", "Sphere");
    model.component("comp1").geom("geom1").feature("sph655")
         .set("pos", new double[]{0.4925083709816435, 0.8131222155152977, 0.6157130636171757});
    model.component("comp1").geom("geom1").feature("sph655").set("r", 0.006503367915248227);
    model.component("comp1").geom("geom1").create("sph656", "Sphere");
    model.component("comp1").geom("geom1").feature("sph656")
         .set("pos", new double[]{0.4476069597182684, 0.4986644691726773, 0.5895364337428289});
    model.component("comp1").geom("geom1").feature("sph656").set("r", 0.009229589981180966);
    model.component("comp1").geom("geom1").create("sph657", "Sphere");
    model.component("comp1").geom("geom1").feature("sph657")
         .set("pos", new double[]{0.4563535873392829, 0.06487589312976412, 0.7706369319225311});
    model.component("comp1").geom("geom1").feature("sph657").set("r", 0.00758163528282718);
    model.component("comp1").geom("geom1").create("sph658", "Sphere");
    model.component("comp1").geom("geom1").feature("sph658")
         .set("pos", new double[]{0.41358280059496944, 0.7619721096476866, 0.5391047307253536});
    model.component("comp1").geom("geom1").feature("sph658").set("r", 0.0050275309598038186);
    model.component("comp1").geom("geom1").create("sph660", "Sphere");
    model.component("comp1").geom("geom1").feature("sph660")
         .set("pos", new double[]{0.4431541776509149, 0.3918988546001799, 0.5826759052385909});
    model.component("comp1").geom("geom1").feature("sph660").set("r", 0.00958335563766775);
    model.component("comp1").geom("geom1").create("sph661", "Sphere");
    model.component("comp1").geom("geom1").feature("sph661")
         .set("pos", new double[]{0.3849545589053784, 0.30221659415196234, 0.7365431333474076});
    model.component("comp1").geom("geom1").feature("sph661").set("r", 0.0037378060826218228);
    model.component("comp1").geom("geom1").create("sph662", "Sphere");
    model.component("comp1").geom("geom1").feature("sph662")
         .set("pos", new double[]{0.48791094136735247, 0.6608688341976519, 0.07165330044713956});
    model.component("comp1").geom("geom1").feature("sph662").set("r", 0.0033340735718832295);
    model.component("comp1").geom("geom1").create("sph663", "Sphere");
    model.component("comp1").geom("geom1").feature("sph663")
         .set("pos", new double[]{0.4981710664997791, 0.22111878890538664, 0.3129739857389104});
    model.component("comp1").geom("geom1").feature("sph663").set("r", 0.0010969998715512383);
    model.component("comp1").geom("geom1").create("sph664", "Sphere");
    model.component("comp1").geom("geom1").feature("sph664")
         .set("pos", new double[]{0.4795632362128736, 0.651138564963987, 0.5043610958256});
    model.component("comp1").geom("geom1").feature("sph664").set("r", 0.0028757261278189753);
    model.component("comp1").geom("geom1").create("sph665", "Sphere");
    model.component("comp1").geom("geom1").feature("sph665")
         .set("pos", new double[]{0.3316606065210052, 0.6128005962639818, 0.42056819133849876});
    model.component("comp1").geom("geom1").feature("sph665").set("r", 0.006018857330433134);
    model.component("comp1").geom("geom1").create("sph666", "Sphere");
    model.component("comp1").geom("geom1").feature("sph666")
         .set("pos", new double[]{0.41327646214080666, 0.37454530929242114, 0.7834739679251788});
    model.component("comp1").geom("geom1").feature("sph666").set("r", 0.0027930533178176127);
    model.component("comp1").geom("geom1").create("sph667", "Sphere");
    model.component("comp1").geom("geom1").feature("sph667")
         .set("pos", new double[]{0.3769894550367112, 0.7847421279562488, 0.4483720579266763});
    model.component("comp1").geom("geom1").feature("sph667").set("r", 0.004738554617585744);
    model.component("comp1").geom("geom1").create("sph668", "Sphere");
    model.component("comp1").geom("geom1").feature("sph668")
         .set("pos", new double[]{0.4425747606184464, 0.8201002732826239, 0.945118049895618});
    model.component("comp1").geom("geom1").feature("sph668").set("r", 0.009695990216117483);
    model.component("comp1").geom("geom1").create("sph669", "Sphere");
    model.component("comp1").geom("geom1").feature("sph669")
         .set("pos", new double[]{0.39429939881764536, 0.6918495484513623, 0.6718974766462962});
    model.component("comp1").geom("geom1").feature("sph669").set("r", 0.004499655659588868);
    model.component("comp1").geom("geom1").create("sph670", "Sphere");
    model.component("comp1").geom("geom1").feature("sph670")
         .set("pos", new double[]{0.3261408879409629, 0.29535755253913865, 0.90999842128522});
    model.component("comp1").geom("geom1").feature("sph670").set("r", 0.009576431151049176);
    model.component("comp1").geom("geom1").create("sph671", "Sphere");
    model.component("comp1").geom("geom1").feature("sph671")
         .set("pos", new double[]{0.30570039980057595, 0.5688989847693743, 0.741736280522626});
    model.component("comp1").geom("geom1").feature("sph671").set("r", 0.008193750775539037);
    model.component("comp1").geom("geom1").create("sph672", "Sphere");
    model.component("comp1").geom("geom1").feature("sph672")
         .set("pos", new double[]{0.3591437764601104, 0.5747666989801818, 0.4673833542032704});
    model.component("comp1").geom("geom1").feature("sph672").set("r", 0.004177327514027582);
    model.component("comp1").geom("geom1").create("sph673", "Sphere");
    model.component("comp1").geom("geom1").feature("sph673")
         .set("pos", new double[]{0.25916969402520706, 0.43564929998344454, 0.3401077585458671});
    model.component("comp1").geom("geom1").feature("sph673").set("r", 0.007777381510621296);
    model.component("comp1").geom("geom1").create("sph674", "Sphere");
    model.component("comp1").geom("geom1").feature("sph674")
         .set("pos", new double[]{0.44041182225493425, 0.08164042023161437, 0.16249297306708377});
    model.component("comp1").geom("geom1").feature("sph674").set("r", 0.006482476475468442);
    model.component("comp1").geom("geom1").create("sph675", "Sphere");
    model.component("comp1").geom("geom1").feature("sph675")
         .set("pos", new double[]{0.43126977788376414, 0.5869694686639452, 0.97605787683148});
    model.component("comp1").geom("geom1").feature("sph675").set("r", 0.006985734617278301);
    model.component("comp1").geom("geom1").create("sph676", "Sphere");
    model.component("comp1").geom("geom1").feature("sph676")
         .set("pos", new double[]{0.2880703425986245, 0.6842436644627745, 0.600953680888707});
    model.component("comp1").geom("geom1").feature("sph676").set("r", 0.005495153401959172);
    model.component("comp1").geom("geom1").create("sph677", "Sphere");
    model.component("comp1").geom("geom1").feature("sph677")
         .set("pos", new double[]{0.38588438806386854, 0.9335509904732292, 0.13383925652234652});
    model.component("comp1").geom("geom1").feature("sph677").set("r", 0.006313793275272372);
    model.component("comp1").geom("geom1").create("sph678", "Sphere");
    model.component("comp1").geom("geom1").feature("sph678")
         .set("pos", new double[]{0.2896767764041148, 0.24583621798432342, 0.5926379652467656});
    model.component("comp1").geom("geom1").feature("sph678").set("r", 0.0016587756867248054);
    model.component("comp1").geom("geom1").create("sph679", "Sphere");
    model.component("comp1").geom("geom1").feature("sph679")
         .set("pos", new double[]{0.3116329701218711, 0.48936582268514667, 0.4822954729993663});
    model.component("comp1").geom("geom1").feature("sph679").set("r", 0.00651182724187061);
    model.component("comp1").geom("geom1").create("sph680", "Sphere");
    model.component("comp1").geom("geom1").feature("sph680")
         .set("pos", new double[]{0.4478035195970965, 0.47198055488227764, 0.7557415375828752});
    model.component("comp1").geom("geom1").feature("sph680").set("r", 0.005077996896567025);
    model.component("comp1").geom("geom1").create("sph681", "Sphere");
    model.component("comp1").geom("geom1").feature("sph681")
         .set("pos", new double[]{0.382832106056948, 0.822485334572107, 0.17932692469011283});
    model.component("comp1").geom("geom1").feature("sph681").set("r", 0.0024983301862431828);
    model.component("comp1").geom("geom1").create("sph682", "Sphere");
    model.component("comp1").geom("geom1").feature("sph682")
         .set("pos", new double[]{0.40113882931777284, 0.18804302087692798, 0.7541033062973288});
    model.component("comp1").geom("geom1").feature("sph682").set("r", 0.005184299518278961);
    model.component("comp1").geom("geom1").create("sph683", "Sphere");
    model.component("comp1").geom("geom1").feature("sph683")
         .set("pos", new double[]{0.48507627350620197, 0.46833023811861163, 0.3366838620957418});
    model.component("comp1").geom("geom1").feature("sph683").set("r", 0.0017109662301668569);
    model.component("comp1").geom("geom1").create("sph684", "Sphere");
    model.component("comp1").geom("geom1").feature("sph684")
         .set("pos", new double[]{0.3584256847999577, 0.6591484291846883, 0.09615090567531495});
    model.component("comp1").geom("geom1").feature("sph684").set("r", 0.0020512630644637635);
    model.component("comp1").geom("geom1").create("sph685", "Sphere");
    model.component("comp1").geom("geom1").feature("sph685")
         .set("pos", new double[]{0.45647994810897985, 0.645082790399198, 0.2085789855294622});
    model.component("comp1").geom("geom1").feature("sph685").set("r", 0.0037564218565097375);
    model.component("comp1").geom("geom1").create("sph686", "Sphere");
    model.component("comp1").geom("geom1").feature("sph686")
         .set("pos", new double[]{0.4741407456444109, 0.28806305048675984, 0.18106945668356936});
    model.component("comp1").geom("geom1").feature("sph686").set("r", 0.0024481881621378028);
    model.component("comp1").geom("geom1").create("sph687", "Sphere");
    model.component("comp1").geom("geom1").feature("sph687")
         .set("pos", new double[]{0.3311139968089082, 0.1322451410100674, 0.4625224523895963});
    model.component("comp1").geom("geom1").feature("sph687").set("r", 0.009999676166883423);
    model.component("comp1").geom("geom1").create("sph688", "Sphere");
    model.component("comp1").geom("geom1").feature("sph688")
         .set("pos", new double[]{0.47751018177476695, 0.1377964008445245, 0.09515071556629469});
    model.component("comp1").geom("geom1").feature("sph688").set("r", 0.004909105991786339);
    model.component("comp1").geom("geom1").create("sph689", "Sphere");
    model.component("comp1").geom("geom1").feature("sph689")
         .set("pos", new double[]{0.47458666952165973, 0.4495551761628766, 0.15189006563035598});
    model.component("comp1").geom("geom1").feature("sph689").set("r", 0.001836808038160121);
    model.component("comp1").geom("geom1").create("sph690", "Sphere");
    model.component("comp1").geom("geom1").feature("sph690")
         .set("pos", new double[]{0.3839284383436315, 0.20223364696518795, 0.6017306944750153});
    model.component("comp1").geom("geom1").feature("sph690").set("r", 0.006344470885413616);
    model.component("comp1").geom("geom1").create("sph691", "Sphere");
    model.component("comp1").geom("geom1").feature("sph691")
         .set("pos", new double[]{0.31171821025656554, 0.5103161146489211, 0.2933419367140071});
    model.component("comp1").geom("geom1").feature("sph691").set("r", 0.004062081108852511);
    model.component("comp1").geom("geom1").create("sph692", "Sphere");
    model.component("comp1").geom("geom1").feature("sph692")
         .set("pos", new double[]{0.4676528301490472, 0.1578274911578012, 0.2819061123852951});
    model.component("comp1").geom("geom1").feature("sph692").set("r", 0.002999259295850919);
    model.component("comp1").geom("geom1").create("sph693", "Sphere");
    model.component("comp1").geom("geom1").feature("sph693")
         .set("pos", new double[]{0.32043562580458035, 0.2132999243207048, 0.7687192063973322});
    model.component("comp1").geom("geom1").feature("sph693").set("r", 0.004475245418648431);
    model.component("comp1").geom("geom1").create("sph694", "Sphere");
    model.component("comp1").geom("geom1").feature("sph694")
         .set("pos", new double[]{0.2811980244772686, 0.5405711790850686, 0.1284554862906048});
    model.component("comp1").geom("geom1").feature("sph694").set("r", 0.003961145428512234);
    model.component("comp1").geom("geom1").create("sph695", "Sphere");
    model.component("comp1").geom("geom1").feature("sph695")
         .set("pos", new double[]{0.46723584706868193, 0.3702648666029532, 0.6313912143232147});
    model.component("comp1").geom("geom1").feature("sph695").set("r", 0.004217676466968351);
    model.component("comp1").geom("geom1").create("sph696", "Sphere");
    model.component("comp1").geom("geom1").feature("sph696")
         .set("pos", new double[]{0.28851161057057206, 0.647390588205271, 0.8520248823195107});
    model.component("comp1").geom("geom1").feature("sph696").set("r", 0.005631629824077682);
    model.component("comp1").geom("geom1").create("sph697", "Sphere");
    model.component("comp1").geom("geom1").feature("sph697")
         .set("pos", new double[]{0.43748703142715933, 0.6895117178013892, 0.8653120617392049});
    model.component("comp1").geom("geom1").feature("sph697").set("r", 0.0018389122664080966);
    model.component("comp1").geom("geom1").create("sph698", "Sphere");
    model.component("comp1").geom("geom1").feature("sph698")
         .set("pos", new double[]{0.3271765138712354, 0.6935388690784767, 0.023869516226726416});
    model.component("comp1").geom("geom1").feature("sph698").set("r", 0.0019368273892012033);
    model.component("comp1").geom("geom1").create("sph699", "Sphere");
    model.component("comp1").geom("geom1").feature("sph699")
         .set("pos", new double[]{0.45904858696839956, 0.4540144547411824, 0.43532896639147556});
    model.component("comp1").geom("geom1").feature("sph699").set("r", 0.007606681099574399);
    model.component("comp1").geom("geom1").create("sph700", "Sphere");
    model.component("comp1").geom("geom1").feature("sph700")
         .set("pos", new double[]{0.2547337622179431, 0.18850329484716047, 0.9764990994516811});
    model.component("comp1").geom("geom1").feature("sph700").set("r", 0.0035062206586242944);
    model.component("comp1").geom("geom1").create("sph701", "Sphere");
    model.component("comp1").geom("geom1").feature("sph701")
         .set("pos", new double[]{0.3207382813756712, 0.9555817067196879, 0.37004234883590464});
    model.component("comp1").geom("geom1").feature("sph701").set("r", 0.00880557469409221);
    model.component("comp1").geom("geom1").create("sph702", "Sphere");
    model.component("comp1").geom("geom1").feature("sph702")
         .set("pos", new double[]{0.29075604225004864, 0.8986566029204107, 0.983409912911533});
    model.component("comp1").geom("geom1").feature("sph702").set("r", 0.003678268372760621);
    model.component("comp1").geom("geom1").create("sph703", "Sphere");
    model.component("comp1").geom("geom1").feature("sph703")
         .set("pos", new double[]{0.4242518470631912, 0.3366034267430005, 0.10810870748668495});
    model.component("comp1").geom("geom1").feature("sph703").set("r", 0.003946702636474142);
    model.component("comp1").geom("geom1").create("sph704", "Sphere");
    model.component("comp1").geom("geom1").feature("sph704")
         .set("pos", new double[]{0.3874248299853432, 0.12643541719105048, 0.8153865303774811});
    model.component("comp1").geom("geom1").feature("sph704").set("r", 0.004534230761940916);
    model.component("comp1").geom("geom1").create("sph705", "Sphere");
    model.component("comp1").geom("geom1").feature("sph705")
         .set("pos", new double[]{0.3115049184286958, 0.5917436259099526, 0.790047372916984});
    model.component("comp1").geom("geom1").feature("sph705").set("r", 0.0054762680520396055);
    model.component("comp1").geom("geom1").create("sph706", "Sphere");
    model.component("comp1").geom("geom1").feature("sph706")
         .set("pos", new double[]{0.4237779745579871, 0.42842889322630623, 0.9603864461897526});
    model.component("comp1").geom("geom1").feature("sph706").set("r", 0.003948619141467782);
    model.component("comp1").geom("geom1").create("sph707", "Sphere");
    model.component("comp1").geom("geom1").feature("sph707")
         .set("pos", new double[]{0.34136843108316256, 0.0254046368873334, 0.6550189643575148});
    model.component("comp1").geom("geom1").feature("sph707").set("r", 0.007938460779424585);
    model.component("comp1").geom("geom1").create("sph708", "Sphere");
    model.component("comp1").geom("geom1").feature("sph708")
         .set("pos", new double[]{0.2825727880679484, 0.9293750408016483, 0.9971684045999504});
    model.component("comp1").geom("geom1").feature("sph708").set("r", 0.002780849427263671);
    model.component("comp1").geom("geom1").create("sph709", "Sphere");
    model.component("comp1").geom("geom1").feature("sph709")
         .set("pos", new double[]{0.32680160906693734, 0.16728644468086298, 0.4579749736842574});
    model.component("comp1").geom("geom1").feature("sph709").set("r", 0.0034289993850794664);
    model.component("comp1").geom("geom1").create("sph710", "Sphere");
    model.component("comp1").geom("geom1").feature("sph710")
         .set("pos", new double[]{0.4218329680450621, 0.840241252629328, 0.2332563567163207});
    model.component("comp1").geom("geom1").feature("sph710").set("r", 0.008792593838521729);
    model.component("comp1").geom("geom1").create("sph712", "Sphere");
    model.component("comp1").geom("geom1").feature("sph712")
         .set("pos", new double[]{0.32448905848847104, 0.965297375594562, 0.3500275954376978});
    model.component("comp1").geom("geom1").feature("sph712").set("r", 0.004605916705208691);
    model.component("comp1").geom("geom1").create("sph713", "Sphere");
    model.component("comp1").geom("geom1").feature("sph713")
         .set("pos", new double[]{0.3475864051140093, 0.44788450621163606, 0.7512167884197088});
    model.component("comp1").geom("geom1").feature("sph713").set("r", 0.0019706471313461855);
    model.component("comp1").geom("geom1").create("sph715", "Sphere");
    model.component("comp1").geom("geom1").feature("sph715")
         .set("pos", new double[]{0.3301166654328954, 0.07602079053442669, 0.3674843864731317});
    model.component("comp1").geom("geom1").feature("sph715").set("r", 0.007473849114127909);
    model.component("comp1").geom("geom1").create("sph717", "Sphere");
    model.component("comp1").geom("geom1").feature("sph717")
         .set("pos", new double[]{0.33363836468274294, 0.8235158064290118, 0.2453442792855921});
    model.component("comp1").geom("geom1").feature("sph717").set("r", 0.0027463829426614267);
    model.component("comp1").geom("geom1").create("sph718", "Sphere");
    model.component("comp1").geom("geom1").feature("sph718")
         .set("pos", new double[]{0.3370173073957488, 0.7986430724875809, 0.04071959670528446});
    model.component("comp1").geom("geom1").feature("sph718").set("r", 0.003984419311004177);
    model.component("comp1").geom("geom1").create("sph719", "Sphere");
    model.component("comp1").geom("geom1").feature("sph719")
         .set("pos", new double[]{0.39435178728932585, 0.3974544193381824, 0.6324430552484526});
    model.component("comp1").geom("geom1").feature("sph719").set("r", 0.0016640828480927287);
    model.component("comp1").geom("geom1").create("sph720", "Sphere");
    model.component("comp1").geom("geom1").feature("sph720")
         .set("pos", new double[]{0.4746120214024584, 0.7591684470513342, 0.07068394819599429});
    model.component("comp1").geom("geom1").feature("sph720").set("r", 0.003398151485614446);
    model.component("comp1").geom("geom1").create("sph721", "Sphere");
    model.component("comp1").geom("geom1").feature("sph721")
         .set("pos", new double[]{0.48483048084698105, 0.9353078506324566, 0.7316900837258842});
    model.component("comp1").geom("geom1").feature("sph721").set("r", 0.008055149295565308);
    model.component("comp1").geom("geom1").create("sph722", "Sphere");
    model.component("comp1").geom("geom1").feature("sph722")
         .set("pos", new double[]{0.39369779089365986, 0.28514427814738585, 0.9682264408614645});
    model.component("comp1").geom("geom1").feature("sph722").set("r", 0.0021123437813309405);
    model.component("comp1").geom("geom1").create("sph723", "Sphere");
    model.component("comp1").geom("geom1").feature("sph723")
         .set("pos", new double[]{0.4010393571356728, 0.6921783545758794, 0.43890415446315056});
    model.component("comp1").geom("geom1").feature("sph723").set("r", 0.007457371528254485);
    model.component("comp1").geom("geom1").create("sph724", "Sphere");
    model.component("comp1").geom("geom1").feature("sph724")
         .set("pos", new double[]{0.4801544023497812, 0.3333909253311806, 0.045429884387776835});
    model.component("comp1").geom("geom1").feature("sph724").set("r", 0.004354630762938461);
    model.component("comp1").geom("geom1").create("sph725", "Sphere");
    model.component("comp1").geom("geom1").feature("sph725")
         .set("pos", new double[]{0.44490956615953636, 0.6471002039013287, 0.9579118150389307});
    model.component("comp1").geom("geom1").feature("sph725").set("r", 0.004607561387390117);
    model.component("comp1").geom("geom1").create("sph726", "Sphere");
    model.component("comp1").geom("geom1").feature("sph726")
         .set("pos", new double[]{0.47627675720653395, 0.3693622078160635, 0.4741042777827348});
    model.component("comp1").geom("geom1").feature("sph726").set("r", 0.0019558168085722387);
    model.component("comp1").geom("geom1").create("sph727", "Sphere");
    model.component("comp1").geom("geom1").feature("sph727")
         .set("pos", new double[]{0.2828383460639704, 0.2502460277381108, 0.7399184633001412});
    model.component("comp1").geom("geom1").feature("sph727").set("r", 0.00485633939040311);
    model.component("comp1").geom("geom1").create("sph728", "Sphere");
    model.component("comp1").geom("geom1").feature("sph728")
         .set("pos", new double[]{0.2843557882101146, 0.02635637589813736, 0.8565252740365897});
    model.component("comp1").geom("geom1").feature("sph728").set("r", 0.001207067876611257);
    model.component("comp1").geom("geom1").create("sph729", "Sphere");
    model.component("comp1").geom("geom1").feature("sph729")
         .set("pos", new double[]{0.2968100103780431, 0.7652481228140807, 0.9606799794849068});
    model.component("comp1").geom("geom1").feature("sph729").set("r", 0.006555923450036018);
    model.component("comp1").geom("geom1").create("sph730", "Sphere");
    model.component("comp1").geom("geom1").feature("sph730")
         .set("pos", new double[]{0.4724524824424371, 0.01707425422467638, 0.5873380693744304});
    model.component("comp1").geom("geom1").feature("sph730").set("r", 0.009411043370770165);
    model.component("comp1").geom("geom1").create("sph731", "Sphere");
    model.component("comp1").geom("geom1").feature("sph731")
         .set("pos", new double[]{0.3907338786410432, 0.3192348171169855, 0.1559590579915097});
    model.component("comp1").geom("geom1").feature("sph731").set("r", 0.0033096935497512634);
    model.component("comp1").geom("geom1").create("sph732", "Sphere");
    model.component("comp1").geom("geom1").feature("sph732")
         .set("pos", new double[]{0.3738231228719877, 0.9848674173471279, 0.046964411208459754});
    model.component("comp1").geom("geom1").feature("sph732").set("r", 0.005000443510225121);
    model.component("comp1").geom("geom1").create("sph733", "Sphere");
    model.component("comp1").geom("geom1").feature("sph733")
         .set("pos", new double[]{0.4603621296855546, 0.6585104307987699, 0.8242587845004296});
    model.component("comp1").geom("geom1").feature("sph733").set("r", 0.0037103967900754898);
    model.component("comp1").geom("geom1").create("sph734", "Sphere");
    model.component("comp1").geom("geom1").feature("sph734")
         .set("pos", new double[]{0.4362803542448581, 0.49302003317259546, 0.2089755359381966});
    model.component("comp1").geom("geom1").feature("sph734").set("r", 0.006942618267038001);
    model.component("comp1").geom("geom1").create("sph735", "Sphere");
    model.component("comp1").geom("geom1").feature("sph735")
         .set("pos", new double[]{0.3908306924984626, 0.14548222272645567, 0.7998388627167154});
    model.component("comp1").geom("geom1").feature("sph735").set("r", 0.0082900347475348);
    model.component("comp1").geom("geom1").create("sph736", "Sphere");
    model.component("comp1").geom("geom1").feature("sph736")
         .set("pos", new double[]{0.3395030130075153, 0.2974880800068945, 0.08982790743876523});

    return model;
  }

  public static Model run8(Model model) {
    model.component("comp1").geom("geom1").feature("sph736").set("r", 0.009627273193263206);
    model.component("comp1").geom("geom1").create("sph737", "Sphere");
    model.component("comp1").geom("geom1").feature("sph737")
         .set("pos", new double[]{0.48333291394930816, 0.14107453856117694, 0.4853668153628175});
    model.component("comp1").geom("geom1").feature("sph737").set("r", 0.0069804210380447415);
    model.component("comp1").geom("geom1").create("sph738", "Sphere");
    model.component("comp1").geom("geom1").feature("sph738")
         .set("pos", new double[]{0.2602830836715689, 0.6638811634436697, 0.8663016244215426});
    model.component("comp1").geom("geom1").feature("sph738").set("r", 0.0018841436618792307);
    model.component("comp1").geom("geom1").create("sph739", "Sphere");
    model.component("comp1").geom("geom1").feature("sph739")
         .set("pos", new double[]{0.4659065127288087, 0.12014588158402281, 0.24007698210928316});
    model.component("comp1").geom("geom1").feature("sph739").set("r", 0.004038134825134268);
    model.component("comp1").geom("geom1").create("sph740", "Sphere");
    model.component("comp1").geom("geom1").feature("sph740")
         .set("pos", new double[]{0.37697234724214435, 0.6062201533708635, 0.04643966172388564});
    model.component("comp1").geom("geom1").feature("sph740").set("r", 0.009114460542160467);
    model.component("comp1").geom("geom1").create("sph741", "Sphere");
    model.component("comp1").geom("geom1").feature("sph741")
         .set("pos", new double[]{0.2658626970982695, 0.9032547743147545, 0.1363693694951401});
    model.component("comp1").geom("geom1").feature("sph741").set("r", 0.0021555091913310004);
    model.component("comp1").geom("geom1").create("sph742", "Sphere");
    model.component("comp1").geom("geom1").feature("sph742")
         .set("pos", new double[]{0.34033489726928334, 0.7953989299336931, 0.36737749931086117});
    model.component("comp1").geom("geom1").feature("sph742").set("r", 0.008647055439478791);
    model.component("comp1").geom("geom1").create("sph743", "Sphere");
    model.component("comp1").geom("geom1").feature("sph743")
         .set("pos", new double[]{0.2761857237047365, 0.282201801615822, 0.4716741769274069});
    model.component("comp1").geom("geom1").feature("sph743").set("r", 0.0034091563572358884);
    model.component("comp1").geom("geom1").create("sph744", "Sphere");
    model.component("comp1").geom("geom1").feature("sph744")
         .set("pos", new double[]{0.36392245874390394, 0.9635554546365017, 0.5409371084845425});
    model.component("comp1").geom("geom1").feature("sph744").set("r", 0.00835757919007116);
    model.component("comp1").geom("geom1").create("sph745", "Sphere");
    model.component("comp1").geom("geom1").feature("sph745")
         .set("pos", new double[]{0.35404909233542425, 0.6884364894420584, 0.23494237167747342});
    model.component("comp1").geom("geom1").feature("sph745").set("r", 0.001224510668302991);
    model.component("comp1").geom("geom1").create("sph746", "Sphere");
    model.component("comp1").geom("geom1").feature("sph746")
         .set("pos", new double[]{0.3758704368185458, 0.03265030833355219, 0.770354162204258});
    model.component("comp1").geom("geom1").feature("sph746").set("r", 0.007287669557633429);
    model.component("comp1").geom("geom1").create("sph747", "Sphere");
    model.component("comp1").geom("geom1").feature("sph747")
         .set("pos", new double[]{0.27566966268091914, 0.4755136146650329, 0.28986381457321225});
    model.component("comp1").geom("geom1").feature("sph747").set("r", 0.006043363334326677);
    model.component("comp1").geom("geom1").create("sph748", "Sphere");
    model.component("comp1").geom("geom1").feature("sph748")
         .set("pos", new double[]{0.32506743173139585, 0.9338099054814074, 0.5453100055424475});
    model.component("comp1").geom("geom1").feature("sph748").set("r", 0.008917133883291399);
    model.component("comp1").geom("geom1").create("sph749", "Sphere");
    model.component("comp1").geom("geom1").feature("sph749")
         .set("pos", new double[]{0.4509327499280241, 0.6958557111722746, 0.41463574319119173});
    model.component("comp1").geom("geom1").feature("sph749").set("r", 0.003912523385920492);
    model.component("comp1").geom("geom1").create("sph750", "Sphere");
    model.component("comp1").geom("geom1").feature("sph750")
         .set("pos", new double[]{0.44093166595240524, 0.8468704287036015, 0.8121939420428936});
    model.component("comp1").geom("geom1").feature("sph750").set("r", 0.006666564724359339);
    model.component("comp1").geom("geom1").create("sph751", "Sphere");
    model.component("comp1").geom("geom1").feature("sph751")
         .set("pos", new double[]{0.45545892536641197, 0.06083122958203034, 0.20166664623256203});
    model.component("comp1").geom("geom1").feature("sph751").set("r", 0.002494693797340762);
    model.component("comp1").geom("geom1").create("sph752", "Sphere");
    model.component("comp1").geom("geom1").feature("sph752")
         .set("pos", new double[]{0.28376407609495713, 0.6019820962546165, 0.31050297941717925});
    model.component("comp1").geom("geom1").feature("sph752").set("r", 0.006606340480593903);
    model.component("comp1").geom("geom1").create("sph753", "Sphere");
    model.component("comp1").geom("geom1").feature("sph753")
         .set("pos", new double[]{0.3305865254010309, 0.07435595034950344, 0.5007513699536423});
    model.component("comp1").geom("geom1").feature("sph753").set("r", 0.004865199266391835);
    model.component("comp1").geom("geom1").create("sph754", "Sphere");
    model.component("comp1").geom("geom1").feature("sph754")
         .set("pos", new double[]{0.40078341164447695, 0.30390021306720666, 0.9473257113747621});
    model.component("comp1").geom("geom1").feature("sph754").set("r", 0.009672394999553989);
    model.component("comp1").geom("geom1").create("sph756", "Sphere");
    model.component("comp1").geom("geom1").feature("sph756")
         .set("pos", new double[]{0.293499861868051, 0.09333529365607897, 0.8039254484112116});
    model.component("comp1").geom("geom1").feature("sph756").set("r", 0.009231424250453535);
    model.component("comp1").geom("geom1").create("sph757", "Sphere");
    model.component("comp1").geom("geom1").feature("sph757")
         .set("pos", new double[]{0.3733719065828694, 0.6872724451240244, 0.07765641278846067});
    model.component("comp1").geom("geom1").feature("sph757").set("r", 0.009144488919671408);
    model.component("comp1").geom("geom1").create("sph758", "Sphere");
    model.component("comp1").geom("geom1").feature("sph758")
         .set("pos", new double[]{0.2894325320542041, 0.6005580226421614, 0.19934149108604915});
    model.component("comp1").geom("geom1").feature("sph758").set("r", 0.0029782395807082473);
    model.component("comp1").geom("geom1").create("sph759", "Sphere");
    model.component("comp1").geom("geom1").feature("sph759")
         .set("pos", new double[]{0.3261604750952094, 0.6766671050585837, 0.5776241193871123});
    model.component("comp1").geom("geom1").feature("sph759").set("r", 0.0015386168399576558);
    model.component("comp1").geom("geom1").create("sph760", "Sphere");
    model.component("comp1").geom("geom1").feature("sph760")
         .set("pos", new double[]{0.4557175449944405, 0.27804845084365554, 0.26245201482165537});
    model.component("comp1").geom("geom1").feature("sph760").set("r", 0.003976524689451723);
    model.component("comp1").geom("geom1").create("sph761", "Sphere");
    model.component("comp1").geom("geom1").feature("sph761")
         .set("pos", new double[]{0.3698170444109055, 0.44662525971771616, 0.15994340284177685});
    model.component("comp1").geom("geom1").feature("sph761").set("r", 0.0060395266971062945);
    model.component("comp1").geom("geom1").create("sph762", "Sphere");
    model.component("comp1").geom("geom1").feature("sph762")
         .set("pos", new double[]{0.31742567482605594, 0.39337492106289657, 0.7309816389111554});
    model.component("comp1").geom("geom1").feature("sph762").set("r", 0.00554181572469692);
    model.component("comp1").geom("geom1").create("sph764", "Sphere");
    model.component("comp1").geom("geom1").feature("sph764")
         .set("pos", new double[]{0.3548794288013086, 0.36240550249047854, 0.14087403085606096});
    model.component("comp1").geom("geom1").feature("sph764").set("r", 0.007718480342881337);
    model.component("comp1").geom("geom1").create("sph765", "Sphere");
    model.component("comp1").geom("geom1").feature("sph765")
         .set("pos", new double[]{0.45446397960555013, 0.31938199296158154, 0.7791835083256313});
    model.component("comp1").geom("geom1").feature("sph765").set("r", 0.007626347213282881);
    model.component("comp1").geom("geom1").create("sph766", "Sphere");
    model.component("comp1").geom("geom1").feature("sph766")
         .set("pos", new double[]{0.4423322741857911, 0.4124885639419563, 0.7443618729816851});
    model.component("comp1").geom("geom1").feature("sph766").set("r", 0.006491917525032888);
    model.component("comp1").geom("geom1").create("sph767", "Sphere");
    model.component("comp1").geom("geom1").feature("sph767")
         .set("pos", new double[]{0.27603591041116166, 0.5501058452125068, 0.4547558973064006});
    model.component("comp1").geom("geom1").feature("sph767").set("r", 0.004676582061078635);
    model.component("comp1").geom("geom1").create("sph768", "Sphere");
    model.component("comp1").geom("geom1").feature("sph768")
         .set("pos", new double[]{0.47045927070525945, 0.38362083169680683, 0.04214568247460966});
    model.component("comp1").geom("geom1").feature("sph768").set("r", 0.0032759189848141947);
    model.component("comp1").geom("geom1").create("sph769", "Sphere");
    model.component("comp1").geom("geom1").feature("sph769")
         .set("pos", new double[]{0.3567976873671402, 0.8584269431650879, 0.7965269269484961});
    model.component("comp1").geom("geom1").feature("sph769").set("r", 0.004439221661823313);
    model.component("comp1").geom("geom1").create("sph770", "Sphere");
    model.component("comp1").geom("geom1").feature("sph770")
         .set("pos", new double[]{0.4578589467347159, 0.24933868416535418, 0.3428192218652883});
    model.component("comp1").geom("geom1").feature("sph770").set("r", 0.0027996992731713186);
    model.component("comp1").geom("geom1").create("sph771", "Sphere");
    model.component("comp1").geom("geom1").feature("sph771")
         .set("pos", new double[]{0.26534318878804786, 0.6802483194619111, 0.9219090350155635});
    model.component("comp1").geom("geom1").feature("sph771").set("r", 0.0016913660857974218);
    model.component("comp1").geom("geom1").create("sph772", "Sphere");
    model.component("comp1").geom("geom1").feature("sph772")
         .set("pos", new double[]{0.4572816485759375, 0.7905569094863337, 0.662887956983662});
    model.component("comp1").geom("geom1").feature("sph772").set("r", 0.005437151688140459);
    model.component("comp1").geom("geom1").create("sph773", "Sphere");
    model.component("comp1").geom("geom1").feature("sph773")
         .set("pos", new double[]{0.44462164297430273, 0.2792592725223262, 0.7833472199798094});
    model.component("comp1").geom("geom1").feature("sph773").set("r", 0.009804060380060008);
    model.component("comp1").geom("geom1").create("sph774", "Sphere");
    model.component("comp1").geom("geom1").feature("sph774")
         .set("pos", new double[]{0.3513338407571285, 0.08292032618437278, 0.21849215013114412});
    model.component("comp1").geom("geom1").feature("sph774").set("r", 0.007233954816555133);
    model.component("comp1").geom("geom1").create("sph775", "Sphere");
    model.component("comp1").geom("geom1").feature("sph775")
         .set("pos", new double[]{0.3162336585126069, 0.9897178645802811, 0.6908163791854584});
    model.component("comp1").geom("geom1").feature("sph775").set("r", 0.008175141024790196);
    model.component("comp1").geom("geom1").create("sph776", "Sphere");
    model.component("comp1").geom("geom1").feature("sph776")
         .set("pos", new double[]{0.39186324767590136, 0.6096985808832509, 0.9639786922065166});
    model.component("comp1").geom("geom1").feature("sph776").set("r", 0.005295002326458471);
    model.component("comp1").geom("geom1").create("sph777", "Sphere");
    model.component("comp1").geom("geom1").feature("sph777")
         .set("pos", new double[]{0.3192167926059215, 0.7085616747586081, 0.24113562942772224});
    model.component("comp1").geom("geom1").feature("sph777").set("r", 0.0024556707516836754);
    model.component("comp1").geom("geom1").create("sph778", "Sphere");
    model.component("comp1").geom("geom1").feature("sph778")
         .set("pos", new double[]{0.3393473336336068, 0.18648322816850837, 0.05562034077971101});
    model.component("comp1").geom("geom1").feature("sph778").set("r", 0.008841674459818451);
    model.component("comp1").geom("geom1").create("sph779", "Sphere");
    model.component("comp1").geom("geom1").feature("sph779")
         .set("pos", new double[]{0.4521827267510847, 0.2766706235460333, 0.9122280872375548});
    model.component("comp1").geom("geom1").feature("sph779").set("r", 0.0063603553628615505);
    model.component("comp1").geom("geom1").create("sph780", "Sphere");
    model.component("comp1").geom("geom1").feature("sph780")
         .set("pos", new double[]{0.2721860843883635, 0.5714970734884075, 0.5663862168341333});
    model.component("comp1").geom("geom1").feature("sph780").set("r", 0.007819608431062042);
    model.component("comp1").geom("geom1").create("sph781", "Sphere");
    model.component("comp1").geom("geom1").feature("sph781")
         .set("pos", new double[]{0.3345697113472715, 0.45851431333305354, 0.05062788318836533});
    model.component("comp1").geom("geom1").feature("sph781").set("r", 0.0028213507444238223);
    model.component("comp1").geom("geom1").create("sph782", "Sphere");
    model.component("comp1").geom("geom1").feature("sph782")
         .set("pos", new double[]{0.2925789243898456, 0.37980286037869565, 0.7461958741437554});
    model.component("comp1").geom("geom1").feature("sph782").set("r", 0.002347987683572991);
    model.component("comp1").geom("geom1").create("sph783", "Sphere");
    model.component("comp1").geom("geom1").feature("sph783")
         .set("pos", new double[]{0.2964315102030806, 0.7476328365640963, 0.6678141258364494});
    model.component("comp1").geom("geom1").feature("sph783").set("r", 0.008481732931875331);
    model.component("comp1").geom("geom1").create("sph785", "Sphere");
    model.component("comp1").geom("geom1").feature("sph785")
         .set("pos", new double[]{0.2960814748874471, 0.1995820184005107, 0.8757723892042294});
    model.component("comp1").geom("geom1").feature("sph785").set("r", 0.008197571160568084);
    model.component("comp1").geom("geom1").create("sph786", "Sphere");
    model.component("comp1").geom("geom1").feature("sph786")
         .set("pos", new double[]{0.33304895282877583, 0.8357006552031664, 0.8520740230035903});
    model.component("comp1").geom("geom1").feature("sph786").set("r", 0.009450684073922726);
    model.component("comp1").geom("geom1").create("sph787", "Sphere");
    model.component("comp1").geom("geom1").feature("sph787")
         .set("pos", new double[]{0.3906697674077455, 0.5748603191088717, 0.303851966682568});
    model.component("comp1").geom("geom1").feature("sph787").set("r", 0.006448514324518327);
    model.component("comp1").geom("geom1").create("sph788", "Sphere");
    model.component("comp1").geom("geom1").feature("sph788")
         .set("pos", new double[]{0.3142643221651278, 0.18186807499708568, 0.4140942512163671});
    model.component("comp1").geom("geom1").feature("sph788").set("r", 0.006569803350450917);
    model.component("comp1").geom("geom1").create("sph789", "Sphere");
    model.component("comp1").geom("geom1").feature("sph789")
         .set("pos", new double[]{0.4035714433414262, 0.9580464311103265, 0.6443024166716902});
    model.component("comp1").geom("geom1").feature("sph789").set("r", 0.0073520238068599175);
    model.component("comp1").geom("geom1").create("sph790", "Sphere");
    model.component("comp1").geom("geom1").feature("sph790")
         .set("pos", new double[]{0.2918438601695256, 0.09491610174542794, 0.19257696421414597});
    model.component("comp1").geom("geom1").feature("sph790").set("r", 0.002271826448163284);
    model.component("comp1").geom("geom1").create("sph791", "Sphere");
    model.component("comp1").geom("geom1").feature("sph791")
         .set("pos", new double[]{0.4552540291600661, 0.8888406734518846, 0.4013196381754095});
    model.component("comp1").geom("geom1").feature("sph791").set("r", 0.00638155810611209);
    model.component("comp1").geom("geom1").create("sph793", "Sphere");
    model.component("comp1").geom("geom1").feature("sph793")
         .set("pos", new double[]{0.3692555149442468, 0.1747505390760239, 0.4626192738684166});
    model.component("comp1").geom("geom1").feature("sph793").set("r", 0.0025667425994829914);
    model.component("comp1").geom("geom1").create("sph794", "Sphere");
    model.component("comp1").geom("geom1").feature("sph794")
         .set("pos", new double[]{0.35892634920715694, 0.24605540229222875, 0.13937090873024327});
    model.component("comp1").geom("geom1").feature("sph794").set("r", 0.004571377225908217);
    model.component("comp1").geom("geom1").create("sph795", "Sphere");
    model.component("comp1").geom("geom1").feature("sph795")
         .set("pos", new double[]{0.3117080473023063, 0.7326650380679959, 0.7154644977519927});
    model.component("comp1").geom("geom1").feature("sph795").set("r", 0.003480987951278971);
    model.component("comp1").geom("geom1").create("sph796", "Sphere");
    model.component("comp1").geom("geom1").feature("sph796")
         .set("pos", new double[]{0.27795023395759483, 0.5654322098861575, 0.08450527033809775});
    model.component("comp1").geom("geom1").feature("sph796").set("r", 0.006260346943878452);
    model.component("comp1").geom("geom1").create("sph797", "Sphere");
    model.component("comp1").geom("geom1").feature("sph797")
         .set("pos", new double[]{0.33849205447967656, 0.24114870070514066, 0.5944274254556721});
    model.component("comp1").geom("geom1").feature("sph797").set("r", 0.0011635571734861403);
    model.component("comp1").geom("geom1").create("sph798", "Sphere");
    model.component("comp1").geom("geom1").feature("sph798")
         .set("pos", new double[]{0.42584835207387706, 0.762357052437728, 0.942454391152257});
    model.component("comp1").geom("geom1").feature("sph798").set("r", 0.009357782392626524);
    model.component("comp1").geom("geom1").create("sph799", "Sphere");
    model.component("comp1").geom("geom1").feature("sph799")
         .set("pos", new double[]{0.3933900805297988, 0.6005015556511523, 0.8608984767447097});
    model.component("comp1").geom("geom1").feature("sph799").set("r", 0.0067068197280691095);
    model.component("comp1").geom("geom1").create("sph800", "Sphere");
    model.component("comp1").geom("geom1").feature("sph800")
         .set("pos", new double[]{0.4461802292217994, 0.6508887872549792, 0.30632762834708277});
    model.component("comp1").geom("geom1").feature("sph800").set("r", 0.004492891316862866);
    model.component("comp1").geom("geom1").create("sph801", "Sphere");
    model.component("comp1").geom("geom1").feature("sph801")
         .set("pos", new double[]{0.3031316307606474, 0.6995395115863638, 0.579511294118942});
    model.component("comp1").geom("geom1").feature("sph801").set("r", 0.0011231956988568253);
    model.component("comp1").geom("geom1").create("sph802", "Sphere");
    model.component("comp1").geom("geom1").feature("sph802")
         .set("pos", new double[]{0.3590317363840562, 0.660029957305848, 0.1296751712565152});
    model.component("comp1").geom("geom1").feature("sph802").set("r", 0.0034713522983825748);
    model.component("comp1").geom("geom1").create("sph803", "Sphere");
    model.component("comp1").geom("geom1").feature("sph803")
         .set("pos", new double[]{0.3549715550047441, 0.5421843381598146, 0.5216993418010624});
    model.component("comp1").geom("geom1").feature("sph803").set("r", 0.004890516227660948);
    model.component("comp1").geom("geom1").create("sph804", "Sphere");
    model.component("comp1").geom("geom1").feature("sph804")
         .set("pos", new double[]{0.4384188849506879, 0.07095912766054926, 0.03954170375033427});
    model.component("comp1").geom("geom1").feature("sph804").set("r", 0.0043095401656106464);
    model.component("comp1").geom("geom1").create("sph805", "Sphere");
    model.component("comp1").geom("geom1").feature("sph805")
         .set("pos", new double[]{0.4703793136975753, 0.2796968258699609, 0.1754435772505698});
    model.component("comp1").geom("geom1").feature("sph805").set("r", 0.004782334056385378);
    model.component("comp1").geom("geom1").create("sph806", "Sphere");
    model.component("comp1").geom("geom1").feature("sph806")
         .set("pos", new double[]{0.2982626104189927, 0.3771819888002393, 0.7247311451715519});
    model.component("comp1").geom("geom1").feature("sph806").set("r", 0.009353875548964385);
    model.component("comp1").geom("geom1").create("sph807", "Sphere");
    model.component("comp1").geom("geom1").feature("sph807")
         .set("pos", new double[]{0.30927148028663637, 0.39835251882307227, 0.785440438139871});
    model.component("comp1").geom("geom1").feature("sph807").set("r", 0.0033483160762984164);
    model.component("comp1").geom("geom1").create("sph808", "Sphere");
    model.component("comp1").geom("geom1").feature("sph808")
         .set("pos", new double[]{0.26644627160401124, 0.1712693676965012, 0.9501640800458832});
    model.component("comp1").geom("geom1").feature("sph808").set("r", 0.009198850178462559);
    model.component("comp1").geom("geom1").create("sph809", "Sphere");
    model.component("comp1").geom("geom1").feature("sph809")
         .set("pos", new double[]{0.38720118667283704, 0.8095710045986306, 0.04561435558916219});
    model.component("comp1").geom("geom1").feature("sph809").set("r", 0.006335121623940716);
    model.component("comp1").geom("geom1").create("sph810", "Sphere");
    model.component("comp1").geom("geom1").feature("sph810")
         .set("pos", new double[]{0.490822093754311, 0.8278317128439299, 0.7468254069387775});
    model.component("comp1").geom("geom1").feature("sph810").set("r", 0.0011245262605567735);
    model.component("comp1").geom("geom1").create("sph811", "Sphere");
    model.component("comp1").geom("geom1").feature("sph811")
         .set("pos", new double[]{0.36926334308433806, 0.9351933865555024, 0.93151718419519});
    model.component("comp1").geom("geom1").feature("sph811").set("r", 0.0024013069313038003);
    model.component("comp1").geom("geom1").create("sph812", "Sphere");
    model.component("comp1").geom("geom1").feature("sph812")
         .set("pos", new double[]{0.43757584276225814, 0.007307476613347078, 0.983252513197265});
    model.component("comp1").geom("geom1").feature("sph812").set("r", 0.001083223962815759);
    model.component("comp1").geom("geom1").create("sph813", "Sphere");
    model.component("comp1").geom("geom1").feature("sph813")
         .set("pos", new double[]{0.48887869973013076, 0.3690039297864592, 0.29515313009443606});
    model.component("comp1").geom("geom1").feature("sph813").set("r", 0.004752704817961287);
    model.component("comp1").geom("geom1").create("sph814", "Sphere");
    model.component("comp1").geom("geom1").feature("sph814")
         .set("pos", new double[]{0.43089509369632256, 0.20198332750702036, 0.861256903007914});
    model.component("comp1").geom("geom1").feature("sph814").set("r", 0.0038466276745114446);
    model.component("comp1").geom("geom1").create("sph815", "Sphere");
    model.component("comp1").geom("geom1").feature("sph815")
         .set("pos", new double[]{0.4865426352689431, 0.9809328708965951, 0.18915824974241816});
    model.component("comp1").geom("geom1").feature("sph815").set("r", 0.006315154242640682);
    model.component("comp1").geom("geom1").create("sph816", "Sphere");
    model.component("comp1").geom("geom1").feature("sph816")
         .set("pos", new double[]{0.270342931402749, 0.03693066550271579, 0.9353405678237776});
    model.component("comp1").geom("geom1").feature("sph816").set("r", 0.009602038482184161);
    model.component("comp1").geom("geom1").create("sph817", "Sphere");
    model.component("comp1").geom("geom1").feature("sph817")
         .set("pos", new double[]{0.2936282012237241, 0.44352852272339033, 0.49420667890443964});
    model.component("comp1").geom("geom1").feature("sph817").set("r", 0.009661570637049942);
    model.component("comp1").geom("geom1").create("sph818", "Sphere");
    model.component("comp1").geom("geom1").feature("sph818")
         .set("pos", new double[]{0.40474266983797125, 0.7697656131806779, 0.4853574280167554});
    model.component("comp1").geom("geom1").feature("sph818").set("r", 0.00874253112866474);
    model.component("comp1").geom("geom1").create("sph819", "Sphere");
    model.component("comp1").geom("geom1").feature("sph819")
         .set("pos", new double[]{0.43063395350223155, 0.7346291026374873, 0.00854979149869201});
    model.component("comp1").geom("geom1").feature("sph819").set("r", 0.006835723320176455);
    model.component("comp1").geom("geom1").create("sph820", "Sphere");
    model.component("comp1").geom("geom1").feature("sph820")
         .set("pos", new double[]{0.3414329750025395, 0.06286417072987364, 0.383434147884956});
    model.component("comp1").geom("geom1").feature("sph820").set("r", 0.0018991726635705455);
    model.component("comp1").geom("geom1").create("sph821", "Sphere");
    model.component("comp1").geom("geom1").feature("sph821")
         .set("pos", new double[]{0.4762711542595664, 0.5664673897045165, 0.7044916008479485});
    model.component("comp1").geom("geom1").feature("sph821").set("r", 0.00450610163624973);
    model.component("comp1").geom("geom1").create("sph822", "Sphere");
    model.component("comp1").geom("geom1").feature("sph822")
         .set("pos", new double[]{0.3615722417491552, 0.01091167382914801, 0.28919344530494995});
    model.component("comp1").geom("geom1").feature("sph822").set("r", 0.008984788138776057);
    model.component("comp1").geom("geom1").create("sph823", "Sphere");
    model.component("comp1").geom("geom1").feature("sph823")
         .set("pos", new double[]{0.4687676853907511, 0.35398266775127124, 0.297422299119167});
    model.component("comp1").geom("geom1").feature("sph823").set("r", 0.008327428300337383);
    model.component("comp1").geom("geom1").create("sph824", "Sphere");
    model.component("comp1").geom("geom1").feature("sph824")
         .set("pos", new double[]{0.3405445824524099, 0.6494071712452388, 0.284404511206812});
    model.component("comp1").geom("geom1").feature("sph824").set("r", 0.0093205468996186);
    model.component("comp1").geom("geom1").create("sph825", "Sphere");
    model.component("comp1").geom("geom1").feature("sph825")
         .set("pos", new double[]{0.37530442627596106, 0.9216394110881203, 0.618194363537431});
    model.component("comp1").geom("geom1").feature("sph825").set("r", 0.0018812691891166738);
    model.component("comp1").geom("geom1").create("sph826", "Sphere");
    model.component("comp1").geom("geom1").feature("sph826")
         .set("pos", new double[]{0.4195568034579603, 0.7668156846744272, 0.3217927801950307});
    model.component("comp1").geom("geom1").feature("sph826").set("r", 0.0028794396230536097);
    model.component("comp1").geom("geom1").create("sph827", "Sphere");
    model.component("comp1").geom("geom1").feature("sph827")
         .set("pos", new double[]{0.4182928783726418, 0.164451245946582, 0.9585012049357101});
    model.component("comp1").geom("geom1").feature("sph827").set("r", 0.006032884612879348);
    model.component("comp1").geom("geom1").create("sph828", "Sphere");
    model.component("comp1").geom("geom1").feature("sph828")
         .set("pos", new double[]{0.49006067789038554, 0.19271616534741942, 0.4839377991600178});
    model.component("comp1").geom("geom1").feature("sph828").set("r", 0.005061267653048577);
    model.component("comp1").geom("geom1").create("sph829", "Sphere");
    model.component("comp1").geom("geom1").feature("sph829")
         .set("pos", new double[]{0.2549871333556829, 0.23918196071630826, 0.40366998360359546});
    model.component("comp1").geom("geom1").feature("sph829").set("r", 0.00249268288308254);
    model.component("comp1").geom("geom1").create("sph830", "Sphere");
    model.component("comp1").geom("geom1").feature("sph830")
         .set("pos", new double[]{0.46785386191806544, 0.6343530058534319, 0.4350815278239862});
    model.component("comp1").geom("geom1").feature("sph830").set("r", 0.0048801766395181224);
    model.component("comp1").geom("geom1").create("sph831", "Sphere");
    model.component("comp1").geom("geom1").feature("sph831")
         .set("pos", new double[]{0.4012962734594586, 0.3261713935427102, 0.6875259946585344});
    model.component("comp1").geom("geom1").feature("sph831").set("r", 0.009891979296488315);
    model.component("comp1").geom("geom1").create("sph832", "Sphere");
    model.component("comp1").geom("geom1").feature("sph832")
         .set("pos", new double[]{0.4661285817922874, 0.8921803287041354, 0.36879927845619687});
    model.component("comp1").geom("geom1").feature("sph832").set("r", 0.005461299304147046);
    model.component("comp1").geom("geom1").create("sph833", "Sphere");
    model.component("comp1").geom("geom1").feature("sph833")
         .set("pos", new double[]{0.31928267942838606, 0.6251016480050443, 0.9863786817723105});
    model.component("comp1").geom("geom1").feature("sph833").set("r", 0.006061051457741298);
    model.component("comp1").geom("geom1").create("sph834", "Sphere");
    model.component("comp1").geom("geom1").feature("sph834")
         .set("pos", new double[]{0.3438717157709473, 0.102253461403784, 0.9587546502438579});
    model.component("comp1").geom("geom1").feature("sph834").set("r", 0.008493296660399656);
    model.component("comp1").geom("geom1").create("sph836", "Sphere");
    model.component("comp1").geom("geom1").feature("sph836")
         .set("pos", new double[]{0.4873019571319364, 0.3000454825956071, 0.35432370572116073});
    model.component("comp1").geom("geom1").feature("sph836").set("r", 0.009610762588741006);
    model.component("comp1").geom("geom1").create("sph837", "Sphere");
    model.component("comp1").geom("geom1").feature("sph837")
         .set("pos", new double[]{0.2575612810762315, 0.178482464158076, 0.9311697008529308});
    model.component("comp1").geom("geom1").feature("sph837").set("r", 0.005606259040594333);
    model.component("comp1").geom("geom1").create("sph838", "Sphere");
    model.component("comp1").geom("geom1").feature("sph838")
         .set("pos", new double[]{0.2762535338110864, 0.4208477669292238, 0.7308647183875597});
    model.component("comp1").geom("geom1").feature("sph838").set("r", 0.0012649171335522508);
    model.component("comp1").geom("geom1").create("sph839", "Sphere");
    model.component("comp1").geom("geom1").feature("sph839")
         .set("pos", new double[]{0.32781855577300567, 0.30680350761974867, 0.8700534010593995});
    model.component("comp1").geom("geom1").feature("sph839").set("r", 0.003419904073513137);
    model.component("comp1").geom("geom1").create("sph840", "Sphere");
    model.component("comp1").geom("geom1").feature("sph840")
         .set("pos", new double[]{0.3902216925885268, 0.9968966864836278, 0.7270787648762164});
    model.component("comp1").geom("geom1").feature("sph840").set("r", 0.0030348784560467615);
    model.component("comp1").geom("geom1").create("sph841", "Sphere");
    model.component("comp1").geom("geom1").feature("sph841")
         .set("pos", new double[]{0.439226653267174, 0.9502597287495208, 0.37455637308410045});
    model.component("comp1").geom("geom1").feature("sph841").set("r", 0.004027155897672334);
    model.component("comp1").geom("geom1").create("sph842", "Sphere");
    model.component("comp1").geom("geom1").feature("sph842")
         .set("pos", new double[]{0.2752054935482259, 0.8894685002160893, 0.10220959716229448});
    model.component("comp1").geom("geom1").feature("sph842").set("r", 0.007372101160623976);
    model.component("comp1").geom("geom1").create("sph843", "Sphere");
    model.component("comp1").geom("geom1").feature("sph843")
         .set("pos", new double[]{0.385256122110095, 0.26563750811337605, 0.6479687943354752});
    model.component("comp1").geom("geom1").feature("sph843").set("r", 0.004356325866354352);
    model.component("comp1").geom("geom1").create("sph844", "Sphere");
    model.component("comp1").geom("geom1").feature("sph844")
         .set("pos", new double[]{0.4266944923389662, 0.355886734263012, 0.5454626562722829});

    return model;
  }

  public static Model run9(Model model) {
    model.component("comp1").geom("geom1").feature("sph844").set("r", 0.005989858546531703);
    model.component("comp1").geom("geom1").create("sph845", "Sphere");
    model.component("comp1").geom("geom1").feature("sph845")
         .set("pos", new double[]{0.44751051915834433, 0.7106794484673997, 0.5412389429245493});
    model.component("comp1").geom("geom1").feature("sph845").set("r", 0.008309668601631062);
    model.component("comp1").geom("geom1").create("sph846", "Sphere");
    model.component("comp1").geom("geom1").feature("sph846")
         .set("pos", new double[]{0.277552785699143, 0.47172216454372123, 0.8550587423339058});
    model.component("comp1").geom("geom1").feature("sph846").set("r", 0.007059349906970458);
    model.component("comp1").geom("geom1").create("sph847", "Sphere");
    model.component("comp1").geom("geom1").feature("sph847")
         .set("pos", new double[]{0.47970868018969803, 0.26525416345179853, 0.10152265601841629});
    model.component("comp1").geom("geom1").feature("sph847").set("r", 0.006466283395539781);
    model.component("comp1").geom("geom1").create("sph848", "Sphere");
    model.component("comp1").geom("geom1").feature("sph848")
         .set("pos", new double[]{0.27816359414902525, 0.7783888761287141, 0.25997263588935515});
    model.component("comp1").geom("geom1").feature("sph848").set("r", 0.00663952092043498);
    model.component("comp1").geom("geom1").create("sph849", "Sphere");
    model.component("comp1").geom("geom1").feature("sph849")
         .set("pos", new double[]{0.44920191673029464, 0.7846660653395732, 0.4960221093345929});
    model.component("comp1").geom("geom1").feature("sph849").set("r", 0.00584876672599291);
    model.component("comp1").geom("geom1").create("sph850", "Sphere");
    model.component("comp1").geom("geom1").feature("sph850")
         .set("pos", new double[]{0.3744545971114766, 0.2831194147047727, 0.3062967237675573});
    model.component("comp1").geom("geom1").feature("sph850").set("r", 0.009782617719839255);
    model.component("comp1").geom("geom1").create("sph851", "Sphere");
    model.component("comp1").geom("geom1").feature("sph851")
         .set("pos", new double[]{0.3602444037172851, 0.420037970158837, 0.02786418185911893});
    model.component("comp1").geom("geom1").feature("sph851").set("r", 0.007692784514895432);
    model.component("comp1").geom("geom1").create("sph852", "Sphere");
    model.component("comp1").geom("geom1").feature("sph852")
         .set("pos", new double[]{0.46239469629482194, 0.8012297299225233, 0.7446632593892272});
    model.component("comp1").geom("geom1").feature("sph852").set("r", 0.0037475034437894437);
    model.component("comp1").geom("geom1").create("sph853", "Sphere");
    model.component("comp1").geom("geom1").feature("sph853")
         .set("pos", new double[]{0.2578905114010004, 0.31192051867588116, 0.4745150010564689});
    model.component("comp1").geom("geom1").feature("sph853").set("r", 0.0012081554800814794);
    model.component("comp1").geom("geom1").create("sph854", "Sphere");
    model.component("comp1").geom("geom1").feature("sph854")
         .set("pos", new double[]{0.3482774206839225, 0.29241092843393923, 0.569845508119186});
    model.component("comp1").geom("geom1").feature("sph854").set("r", 0.00918767141187643);
    model.component("comp1").geom("geom1").create("sph855", "Sphere");
    model.component("comp1").geom("geom1").feature("sph855")
         .set("pos", new double[]{0.4302533340001627, 0.8500806183459269, 0.1880657056794895});
    model.component("comp1").geom("geom1").feature("sph855").set("r", 0.009232248695947253);
    model.component("comp1").geom("geom1").create("sph856", "Sphere");
    model.component("comp1").geom("geom1").feature("sph856")
         .set("pos", new double[]{0.38582995401259684, 0.6965296391497875, 0.9530489072936652});
    model.component("comp1").geom("geom1").feature("sph856").set("r", 0.0021309800078241317);
    model.component("comp1").geom("geom1").create("sph857", "Sphere");
    model.component("comp1").geom("geom1").feature("sph857")
         .set("pos", new double[]{0.33797226871118435, 0.515716561796319, 0.6833312663088166});
    model.component("comp1").geom("geom1").feature("sph857").set("r", 0.0043438096761083105);
    model.component("comp1").geom("geom1").create("sph858", "Sphere");
    model.component("comp1").geom("geom1").feature("sph858")
         .set("pos", new double[]{0.4280392797883341, 0.3817737098827431, 0.8577830104522772});
    model.component("comp1").geom("geom1").feature("sph858").set("r", 0.006094213994037729);
    model.component("comp1").geom("geom1").create("sph859", "Sphere");
    model.component("comp1").geom("geom1").feature("sph859")
         .set("pos", new double[]{0.329950680652007, 0.772228934449154, 0.3365421328751047});
    model.component("comp1").geom("geom1").feature("sph859").set("r", 0.0026467803422556384);
    model.component("comp1").geom("geom1").create("sph860", "Sphere");
    model.component("comp1").geom("geom1").feature("sph860")
         .set("pos", new double[]{0.3249259191716617, 0.1914932618743924, 0.30352764500619656});
    model.component("comp1").geom("geom1").feature("sph860").set("r", 0.007013391421330137);
    model.component("comp1").geom("geom1").create("sph862", "Sphere");
    model.component("comp1").geom("geom1").feature("sph862")
         .set("pos", new double[]{0.4384276963576855, 0.22623977997378988, 0.5977203141607654});
    model.component("comp1").geom("geom1").feature("sph862").set("r", 0.0010249386096311374);
    model.component("comp1").geom("geom1").create("sph863", "Sphere");
    model.component("comp1").geom("geom1").feature("sph863")
         .set("pos", new double[]{0.4578044273087713, 0.18821113025112107, 0.00598267168059245});
    model.component("comp1").geom("geom1").feature("sph863").set("r", 0.0012259858435942881);
    model.component("comp1").geom("geom1").create("sph864", "Sphere");
    model.component("comp1").geom("geom1").feature("sph864")
         .set("pos", new double[]{0.47700118478381054, 0.264375948269823, 0.5034530203363645});
    model.component("comp1").geom("geom1").feature("sph864").set("r", 0.0037106902752888304);
    model.component("comp1").geom("geom1").create("sph865", "Sphere");
    model.component("comp1").geom("geom1").feature("sph865")
         .set("pos", new double[]{0.3254819972314638, 0.9233663110809744, 0.7862985459119352});
    model.component("comp1").geom("geom1").feature("sph865").set("r", 0.0046650685992193405);
    model.component("comp1").geom("geom1").create("sph866", "Sphere");
    model.component("comp1").geom("geom1").feature("sph866")
         .set("pos", new double[]{0.3811165222875167, 0.8197566545547283, 0.45908192855407365});
    model.component("comp1").geom("geom1").feature("sph866").set("r", 0.007857219838364717);
    model.component("comp1").geom("geom1").create("sph867", "Sphere");
    model.component("comp1").geom("geom1").feature("sph867")
         .set("pos", new double[]{0.3735081000580942, 0.23963936382722784, 0.9192571441437718});
    model.component("comp1").geom("geom1").feature("sph867").set("r", 0.005186705954244001);
    model.component("comp1").geom("geom1").create("sph868", "Sphere");
    model.component("comp1").geom("geom1").feature("sph868")
         .set("pos", new double[]{0.3015493817807215, 0.24545776888033577, 0.8152393409947668});
    model.component("comp1").geom("geom1").feature("sph868").set("r", 0.003328756073906943);
    model.component("comp1").geom("geom1").create("sph869", "Sphere");
    model.component("comp1").geom("geom1").feature("sph869")
         .set("pos", new double[]{0.357930879895898, 0.0214805951462149, 0.9682023296634779});
    model.component("comp1").geom("geom1").feature("sph869").set("r", 0.007916910739087256);
    model.component("comp1").geom("geom1").create("sph870", "Sphere");
    model.component("comp1").geom("geom1").feature("sph870")
         .set("pos", new double[]{0.46131448475973647, 0.780487573808541, 0.9361545751397712});
    model.component("comp1").geom("geom1").feature("sph870").set("r", 0.0021927787974132702);
    model.component("comp1").geom("geom1").create("sph871", "Sphere");
    model.component("comp1").geom("geom1").feature("sph871")
         .set("pos", new double[]{0.33552765990055083, 0.23618228649645084, 0.3796381261002612});
    model.component("comp1").geom("geom1").feature("sph871").set("r", 0.0079605868517676);
    model.component("comp1").geom("geom1").create("sph872", "Sphere");
    model.component("comp1").geom("geom1").feature("sph872")
         .set("pos", new double[]{0.42865186678449196, 0.8246719838156267, 0.6456106971268636});
    model.component("comp1").geom("geom1").feature("sph872").set("r", 0.0028277845346500715);
    model.component("comp1").geom("geom1").create("sph873", "Sphere");
    model.component("comp1").geom("geom1").feature("sph873")
         .set("pos", new double[]{0.26182101650316464, 0.5799711466789483, 0.4628727916183408});
    model.component("comp1").geom("geom1").feature("sph873").set("r", 0.0026748345817819187);
    model.component("comp1").geom("geom1").create("sph874", "Sphere");
    model.component("comp1").geom("geom1").feature("sph874")
         .set("pos", new double[]{0.3427590026831795, 0.5412342655633448, 0.6321734848019893});
    model.component("comp1").geom("geom1").feature("sph874").set("r", 0.0027973353537912916);
    model.component("comp1").geom("geom1").create("sph875", "Sphere");
    model.component("comp1").geom("geom1").feature("sph875")
         .set("pos", new double[]{0.48786106359572756, 0.05102713819723223, 0.656534138489403});
    model.component("comp1").geom("geom1").feature("sph875").set("r", 0.005289793997885365);
    model.component("comp1").geom("geom1").create("sph877", "Sphere");
    model.component("comp1").geom("geom1").feature("sph877")
         .set("pos", new double[]{0.4927511413175684, 0.5881651201687557, 0.9188879305450881});
    model.component("comp1").geom("geom1").feature("sph877").set("r", 0.0053773641469471245);
    model.component("comp1").geom("geom1").create("sph878", "Sphere");
    model.component("comp1").geom("geom1").feature("sph878")
         .set("pos", new double[]{0.28940175439160293, 0.6840096733193859, 0.41665179696024374});
    model.component("comp1").geom("geom1").feature("sph878").set("r", 0.001109894676970797);
    model.component("comp1").geom("geom1").create("sph879", "Sphere");
    model.component("comp1").geom("geom1").feature("sph879")
         .set("pos", new double[]{0.3584366231119648, 0.7093656645142281, 0.5650321632566411});
    model.component("comp1").geom("geom1").feature("sph879").set("r", 0.008523681124860823);
    model.component("comp1").geom("geom1").create("sph880", "Sphere");
    model.component("comp1").geom("geom1").feature("sph880")
         .set("pos", new double[]{0.4285815029739645, 0.7055136528718053, 0.11731609667231341});
    model.component("comp1").geom("geom1").feature("sph880").set("r", 0.0020791321059576056);
    model.component("comp1").geom("geom1").create("sph881", "Sphere");
    model.component("comp1").geom("geom1").feature("sph881")
         .set("pos", new double[]{0.3359035068402199, 0.4593482925029597, 0.4236944256019513});
    model.component("comp1").geom("geom1").feature("sph881").set("r", 0.006057203120269561);
    model.component("comp1").geom("geom1").create("sph882", "Sphere");
    model.component("comp1").geom("geom1").feature("sph882")
         .set("pos", new double[]{0.2908346484820458, 0.08841425277088295, 0.19364214583280098});
    model.component("comp1").geom("geom1").feature("sph882").set("r", 0.0019429696382426975);
    model.component("comp1").geom("geom1").create("sph883", "Sphere");
    model.component("comp1").geom("geom1").feature("sph883")
         .set("pos", new double[]{0.2643773409909747, 0.4328032806265548, 0.7957169482913132});
    model.component("comp1").geom("geom1").feature("sph883").set("r", 0.00867199947847971);
    model.component("comp1").geom("geom1").create("sph884", "Sphere");
    model.component("comp1").geom("geom1").feature("sph884")
         .set("pos", new double[]{0.3079643513976449, 0.7265743796022458, 0.6469910475727877});
    model.component("comp1").geom("geom1").feature("sph884").set("r", 0.001902323840746511);
    model.component("comp1").geom("geom1").create("sph885", "Sphere");
    model.component("comp1").geom("geom1").feature("sph885")
         .set("pos", new double[]{0.2968946553741567, 0.7909570462949386, 0.14576534690290258});
    model.component("comp1").geom("geom1").feature("sph885").set("r", 0.0060672145304364955);
    model.component("comp1").geom("geom1").create("sph886", "Sphere");
    model.component("comp1").geom("geom1").feature("sph886")
         .set("pos", new double[]{0.44745282913608275, 0.36980219278974924, 0.3134465404205522});
    model.component("comp1").geom("geom1").feature("sph886").set("r", 0.0022131810525075784);
    model.component("comp1").geom("geom1").create("sph887", "Sphere");
    model.component("comp1").geom("geom1").feature("sph887")
         .set("pos", new double[]{0.33247103925795607, 0.34170605255887787, 0.6949899588355354});
    model.component("comp1").geom("geom1").feature("sph887").set("r", 0.003508048461792128);
    model.component("comp1").geom("geom1").create("sph888", "Sphere");
    model.component("comp1").geom("geom1").feature("sph888")
         .set("pos", new double[]{0.3324363745754111, 0.7744645481229762, 0.910537511776362});
    model.component("comp1").geom("geom1").feature("sph888").set("r", 0.003162359810361453);
    model.component("comp1").geom("geom1").create("sph889", "Sphere");
    model.component("comp1").geom("geom1").feature("sph889")
         .set("pos", new double[]{0.2814252804602844, 0.5410427690211498, 0.6261137816494773});
    model.component("comp1").geom("geom1").feature("sph889").set("r", 0.006515523732055891);
    model.component("comp1").geom("geom1").create("sph890", "Sphere");
    model.component("comp1").geom("geom1").feature("sph890")
         .set("pos", new double[]{0.45448992325460497, 0.7799200761325012, 0.5747303883685814});
    model.component("comp1").geom("geom1").feature("sph890").set("r", 0.0038264742730625277);
    model.component("comp1").geom("geom1").create("sph891", "Sphere");
    model.component("comp1").geom("geom1").feature("sph891")
         .set("pos", new double[]{0.42343538247706775, 0.8935259955625474, 0.2512532137812313});
    model.component("comp1").geom("geom1").feature("sph891").set("r", 0.0023051403048440075);
    model.component("comp1").geom("geom1").create("sph893", "Sphere");
    model.component("comp1").geom("geom1").feature("sph893")
         .set("pos", new double[]{0.27788748702066063, 0.8217041793241142, 0.6645566400914495});
    model.component("comp1").geom("geom1").feature("sph893").set("r", 0.003770631388726251);
    model.component("comp1").geom("geom1").create("sph894", "Sphere");
    model.component("comp1").geom("geom1").feature("sph894")
         .set("pos", new double[]{0.29021358393406554, 0.3789775885262195, 0.8717202214733623});
    model.component("comp1").geom("geom1").feature("sph894").set("r", 0.006526005861526497);
    model.component("comp1").geom("geom1").create("sph895", "Sphere");
    model.component("comp1").geom("geom1").feature("sph895")
         .set("pos", new double[]{0.26420884652992455, 0.19267702808390247, 0.25141398810646703});
    model.component("comp1").geom("geom1").feature("sph895").set("r", 0.002469740146992157);
    model.component("comp1").geom("geom1").create("sph896", "Sphere");
    model.component("comp1").geom("geom1").feature("sph896")
         .set("pos", new double[]{0.40964946564052457, 0.02511621477699564, 0.025063975821642562});
    model.component("comp1").geom("geom1").feature("sph896").set("r", 0.008052782713892951);
    model.component("comp1").geom("geom1").create("sph897", "Sphere");
    model.component("comp1").geom("geom1").feature("sph897")
         .set("pos", new double[]{0.4066963915375504, 0.1299932831180039, 0.6091140569877849});
    model.component("comp1").geom("geom1").feature("sph897").set("r", 0.006102067859200499);
    model.component("comp1").geom("geom1").create("sph898", "Sphere");
    model.component("comp1").geom("geom1").feature("sph898")
         .set("pos", new double[]{0.3352132910010819, 0.4094083422924146, 0.11862287629298401});
    model.component("comp1").geom("geom1").feature("sph898").set("r", 0.003163167193775861);
    model.component("comp1").geom("geom1").create("sph899", "Sphere");
    model.component("comp1").geom("geom1").feature("sph899")
         .set("pos", new double[]{0.48428055321567026, 0.44606511909909735, 0.2621560298373189});
    model.component("comp1").geom("geom1").feature("sph899").set("r", 0.009667842449004597);
    model.component("comp1").geom("geom1").create("sph900", "Sphere");
    model.component("comp1").geom("geom1").feature("sph900")
         .set("pos", new double[]{0.44839024937158745, 0.7199111510183913, 0.4625470898585749});
    model.component("comp1").geom("geom1").feature("sph900").set("r", 0.0096273500187278);
    model.component("comp1").geom("geom1").create("sph901", "Sphere");
    model.component("comp1").geom("geom1").feature("sph901")
         .set("pos", new double[]{0.44221411201837985, 0.5194294971588498, 0.659074205634596});
    model.component("comp1").geom("geom1").feature("sph901").set("r", 0.00469520831297055);
    model.component("comp1").geom("geom1").create("sph902", "Sphere");
    model.component("comp1").geom("geom1").feature("sph902")
         .set("pos", new double[]{0.4254594989836192, 0.09905346223353825, 0.37911307186255266});
    model.component("comp1").geom("geom1").feature("sph902").set("r", 0.006095736834475708);
    model.component("comp1").geom("geom1").create("sph903", "Sphere");
    model.component("comp1").geom("geom1").feature("sph903")
         .set("pos", new double[]{0.3118027173633291, 0.202322430504496, 0.5033056625399533});
    model.component("comp1").geom("geom1").feature("sph903").set("r", 0.002503802696588786);
    model.component("comp1").geom("geom1").create("sph904", "Sphere");
    model.component("comp1").geom("geom1").feature("sph904")
         .set("pos", new double[]{0.48990534693408355, 0.5189194155214842, 0.053619335249595286});
    model.component("comp1").geom("geom1").feature("sph904").set("r", 0.0011709368965892683);
    model.component("comp1").geom("geom1").create("sph905", "Sphere");
    model.component("comp1").geom("geom1").feature("sph905")
         .set("pos", new double[]{0.3205215906979897, 0.11238175952858867, 0.8255879504479569});
    model.component("comp1").geom("geom1").feature("sph905").set("r", 0.007138484563255834);
    model.component("comp1").geom("geom1").create("sph906", "Sphere");
    model.component("comp1").geom("geom1").feature("sph906")
         .set("pos", new double[]{0.2783870571110066, 0.05937108817159996, 0.7272864283743923});
    model.component("comp1").geom("geom1").feature("sph906").set("r", 0.002781168426228918);
    model.component("comp1").geom("geom1").create("sph907", "Sphere");
    model.component("comp1").geom("geom1").feature("sph907")
         .set("pos", new double[]{0.25883412019183266, 0.22532268365336092, 0.7018584665574964});
    model.component("comp1").geom("geom1").feature("sph907").set("r", 0.006897441225904913);
    model.component("comp1").geom("geom1").create("sph908", "Sphere");
    model.component("comp1").geom("geom1").feature("sph908")
         .set("pos", new double[]{0.3938240094798966, 0.2145156849842665, 0.44947483994853954});
    model.component("comp1").geom("geom1").feature("sph908").set("r", 0.0023692676923355712);
    model.component("comp1").geom("geom1").create("sph909", "Sphere");
    model.component("comp1").geom("geom1").feature("sph909")
         .set("pos", new double[]{0.32912609737658594, 0.682696743827549, 0.43936832339377874});
    model.component("comp1").geom("geom1").feature("sph909").set("r", 0.008806807556216031);
    model.component("comp1").geom("geom1").create("sph910", "Sphere");
    model.component("comp1").geom("geom1").feature("sph910")
         .set("pos", new double[]{0.3406786906229171, 0.8400068205271922, 0.9712814039127018});
    model.component("comp1").geom("geom1").feature("sph910").set("r", 0.0018653972887133947);
    model.component("comp1").geom("geom1").create("sph911", "Sphere");
    model.component("comp1").geom("geom1").feature("sph911")
         .set("pos", new double[]{0.296370643636452, 0.3481683105350896, 0.8254879235269912});
    model.component("comp1").geom("geom1").feature("sph911").set("r", 0.008605735035544048);
    model.component("comp1").geom("geom1").create("sph912", "Sphere");
    model.component("comp1").geom("geom1").feature("sph912")
         .set("pos", new double[]{0.4407404702615018, 0.7744581656871565, 0.07622203285383368});
    model.component("comp1").geom("geom1").feature("sph912").set("r", 0.005985063409561889);
    model.component("comp1").geom("geom1").create("sph913", "Sphere");
    model.component("comp1").geom("geom1").feature("sph913")
         .set("pos", new double[]{0.3699266304891838, 0.941590210516161, 0.8949779326045448});
    model.component("comp1").geom("geom1").feature("sph913").set("r", 0.004081659090409208);
    model.component("comp1").geom("geom1").create("sph914", "Sphere");
    model.component("comp1").geom("geom1").feature("sph914")
         .set("pos", new double[]{0.2778039824170685, 0.40546007228862824, 0.5355581373319788});
    model.component("comp1").geom("geom1").feature("sph914").set("r", 0.004807287846380979);
    model.component("comp1").geom("geom1").create("sph915", "Sphere");
    model.component("comp1").geom("geom1").feature("sph915")
         .set("pos", new double[]{0.32746924931553534, 0.31235794651463655, 0.6248584331966193});
    model.component("comp1").geom("geom1").feature("sph915").set("r", 0.009139574722591283);
    model.component("comp1").geom("geom1").create("sph916", "Sphere");
    model.component("comp1").geom("geom1").feature("sph916")
         .set("pos", new double[]{0.3023411016499181, 0.14866844863026488, 0.4896137219621344});
    model.component("comp1").geom("geom1").feature("sph916").set("r", 0.005546723995642412);
    model.component("comp1").geom("geom1").create("sph918", "Sphere");
    model.component("comp1").geom("geom1").feature("sph918")
         .set("pos", new double[]{0.2549663006412488, 0.8269296969191503, 0.6453006050484481});
    model.component("comp1").geom("geom1").feature("sph918").set("r", 0.004527903941292349);
    model.component("comp1").geom("geom1").create("sph919", "Sphere");
    model.component("comp1").geom("geom1").feature("sph919")
         .set("pos", new double[]{0.36812167485283226, 0.9135298089646521, 0.036581392881225465});
    model.component("comp1").geom("geom1").feature("sph919").set("r", 0.007929299068587019);
    model.component("comp1").geom("geom1").create("sph920", "Sphere");
    model.component("comp1").geom("geom1").feature("sph920")
         .set("pos", new double[]{0.3445095707016755, 0.08679662696657028, 0.08956726410412005});
    model.component("comp1").geom("geom1").feature("sph920").set("r", 0.002037530644640995);
    model.component("comp1").geom("geom1").create("sph921", "Sphere");
    model.component("comp1").geom("geom1").feature("sph921")
         .set("pos", new double[]{0.30749486893808997, 0.6249910117668824, 0.9241595520025092});
    model.component("comp1").geom("geom1").feature("sph921").set("r", 0.006101854114154906);
    model.component("comp1").geom("geom1").create("sph922", "Sphere");
    model.component("comp1").geom("geom1").feature("sph922")
         .set("pos", new double[]{0.31634148322087835, 0.09656884973195369, 0.9426157831003905});
    model.component("comp1").geom("geom1").feature("sph922").set("r", 0.008414939887328164);
    model.component("comp1").geom("geom1").create("sph923", "Sphere");
    model.component("comp1").geom("geom1").feature("sph923")
         .set("pos", new double[]{0.3461213926806371, 0.46145982008875114, 0.1523918501618482});
    model.component("comp1").geom("geom1").feature("sph923").set("r", 0.009950463382359925);
    model.component("comp1").geom("geom1").create("sph924", "Sphere");
    model.component("comp1").geom("geom1").feature("sph924")
         .set("pos", new double[]{0.35661395537847335, 0.7985355953144528, 0.5761540144853462});
    model.component("comp1").geom("geom1").feature("sph924").set("r", 0.007391627134999133);
    model.component("comp1").geom("geom1").create("sph925", "Sphere");
    model.component("comp1").geom("geom1").feature("sph925")
         .set("pos", new double[]{0.3341958289668646, 0.8077413257746543, 0.6875927855099099});
    model.component("comp1").geom("geom1").feature("sph925").set("r", 0.0013850542824997035);
    model.component("comp1").geom("geom1").create("sph926", "Sphere");
    model.component("comp1").geom("geom1").feature("sph926")
         .set("pos", new double[]{0.41581708674233775, 0.6036308966416247, 0.6392352963222577});
    model.component("comp1").geom("geom1").feature("sph926").set("r", 0.0066927875264102404);
    model.component("comp1").geom("geom1").create("sph927", "Sphere");
    model.component("comp1").geom("geom1").feature("sph927")
         .set("pos", new double[]{0.38291681981239495, 0.754353219563596, 0.3712110306164616});
    model.component("comp1").geom("geom1").feature("sph927").set("r", 0.0065837899417678395);
    model.component("comp1").geom("geom1").create("sph928", "Sphere");
    model.component("comp1").geom("geom1").feature("sph928")
         .set("pos", new double[]{0.35140251919523496, 0.21227956795536307, 0.32376879805887615});
    model.component("comp1").geom("geom1").feature("sph928").set("r", 0.005277145047764515);
    model.component("comp1").geom("geom1").create("sph929", "Sphere");
    model.component("comp1").geom("geom1").feature("sph929")
         .set("pos", new double[]{0.331903628206497, 0.390910279180677, 0.09459998955118104});
    model.component("comp1").geom("geom1").feature("sph929").set("r", 0.0014951356984891058);
    model.component("comp1").geom("geom1").create("sph930", "Sphere");
    model.component("comp1").geom("geom1").feature("sph930")
         .set("pos", new double[]{0.3138802198838137, 0.2290967184230672, 0.3511156072168361});
    model.component("comp1").geom("geom1").feature("sph930").set("r", 0.0029840961674088705);
    model.component("comp1").geom("geom1").create("sph931", "Sphere");
    model.component("comp1").geom("geom1").feature("sph931")
         .set("pos", new double[]{0.4318086342292588, 0.3433798655379559, 0.12410528812626562});
    model.component("comp1").geom("geom1").feature("sph931").set("r", 0.0023038849456297646);
    model.component("comp1").geom("geom1").create("sph932", "Sphere");
    model.component("comp1").geom("geom1").feature("sph932")
         .set("pos", new double[]{0.29897564134668364, 0.0636622861216189, 0.16756321253626558});
    model.component("comp1").geom("geom1").feature("sph932").set("r", 0.006342398031941047);
    model.component("comp1").geom("geom1").create("sph933", "Sphere");
    model.component("comp1").geom("geom1").feature("sph933")
         .set("pos", new double[]{0.4215273152807033, 0.6401481495266403, 0.009936163991738063});
    model.component("comp1").geom("geom1").feature("sph933").set("r", 0.004779953308442278);
    model.component("comp1").geom("geom1").create("sph934", "Sphere");
    model.component("comp1").geom("geom1").feature("sph934")
         .set("pos", new double[]{0.33659682134861, 0.6767900575742457, 0.040280893445490004});
    model.component("comp1").geom("geom1").feature("sph934").set("r", 0.008139615872626776);
    model.component("comp1").geom("geom1").create("sph935", "Sphere");
    model.component("comp1").geom("geom1").feature("sph935")
         .set("pos", new double[]{0.25926849558989856, 0.8134705273283226, 0.1898120817489756});
    model.component("comp1").geom("geom1").feature("sph935").set("r", 0.004544094190350798);
    model.component("comp1").geom("geom1").create("sph936", "Sphere");
    model.component("comp1").geom("geom1").feature("sph936")
         .set("pos", new double[]{0.3224192403181451, 0.14050792867942113, 0.9242101615982399});
    model.component("comp1").geom("geom1").feature("sph936").set("r", 0.007070931167671827);
    model.component("comp1").geom("geom1").create("sph937", "Sphere");
    model.component("comp1").geom("geom1").feature("sph937")
         .set("pos", new double[]{0.46769266813112526, 0.30905760894840106, 0.8256429804425305});
    model.component("comp1").geom("geom1").feature("sph937").set("r", 0.0063552215420796);
    model.component("comp1").geom("geom1").create("sph938", "Sphere");
    model.component("comp1").geom("geom1").feature("sph938")
         .set("pos", new double[]{0.3507822527373859, 0.8964726538127492, 0.33821091436137796});
    model.component("comp1").geom("geom1").feature("sph938").set("r", 0.009475141000656544);
    model.component("comp1").geom("geom1").create("sph939", "Sphere");
    model.component("comp1").geom("geom1").feature("sph939")
         .set("pos", new double[]{0.4950452358550696, 0.9488622835214937, 0.23074673800342685});
    model.component("comp1").geom("geom1").feature("sph939").set("r", 0.00392139999214562);
    model.component("comp1").geom("geom1").create("sph940", "Sphere");
    model.component("comp1").geom("geom1").feature("sph940")
         .set("pos", new double[]{0.33830365617023356, 0.9710628637955774, 0.8438463690005007});
    model.component("comp1").geom("geom1").feature("sph940").set("r", 0.00853481824333431);
    model.component("comp1").geom("geom1").create("sph941", "Sphere");
    model.component("comp1").geom("geom1").feature("sph941")
         .set("pos", new double[]{0.3920709963636478, 0.29791602507634374, 0.2030568346420504});
    model.component("comp1").geom("geom1").feature("sph941").set("r", 0.009144273711812846);
    model.component("comp1").geom("geom1").create("sph942", "Sphere");
    model.component("comp1").geom("geom1").feature("sph942")
         .set("pos", new double[]{0.4159062098226929, 0.7390076560920517, 0.17417436417715237});
    model.component("comp1").geom("geom1").feature("sph942").set("r", 0.005750847284915198);
    model.component("comp1").geom("geom1").create("sph943", "Sphere");
    model.component("comp1").geom("geom1").feature("sph943")
         .set("pos", new double[]{0.35977151902818927, 0.21162222710933523, 0.5523455190653422});
    model.component("comp1").geom("geom1").feature("sph943").set("r", 0.00582299193313956);
    model.component("comp1").geom("geom1").create("sph944", "Sphere");
    model.component("comp1").geom("geom1").feature("sph944")
         .set("pos", new double[]{0.3835194335634377, 0.2021985172531763, 0.8971563584323287});
    model.component("comp1").geom("geom1").feature("sph944").set("r", 0.0034832234962581176);
    model.component("comp1").geom("geom1").create("sph945", "Sphere");
    model.component("comp1").geom("geom1").feature("sph945")
         .set("pos", new double[]{0.401691501523923, 0.12498998089437648, 0.6289658929019345});
    model.component("comp1").geom("geom1").feature("sph945").set("r", 0.004042925424276315);
    model.component("comp1").geom("geom1").create("sph947", "Sphere");
    model.component("comp1").geom("geom1").feature("sph947")
         .set("pos", new double[]{0.46324189318624825, 0.8025420282800745, 0.24713215703976582});
    model.component("comp1").geom("geom1").feature("sph947").set("r", 0.0029423202909696676);
    model.component("comp1").geom("geom1").create("sph950", "Sphere");
    model.component("comp1").geom("geom1").feature("sph950")
         .set("pos", new double[]{0.3368440586258978, 0.16706471757752375, 0.7997451755703676});
    model.component("comp1").geom("geom1").feature("sph950").set("r", 0.009949373512452446);
    model.component("comp1").geom("geom1").create("sph951", "Sphere");
    model.component("comp1").geom("geom1").feature("sph951")
         .set("pos", new double[]{0.2678211242533811, 0.29808800618133396, 0.048673346765231176});
    model.component("comp1").geom("geom1").feature("sph951").set("r", 0.0014056284465145074);
    model.component("comp1").geom("geom1").create("sph952", "Sphere");
    model.component("comp1").geom("geom1").feature("sph952")
         .set("pos", new double[]{0.4189743935380255, 0.5191962235589508, 0.7990866123631637});
    model.component("comp1").geom("geom1").feature("sph952").set("r", 0.00996141415503075);
    model.component("comp1").geom("geom1").create("sph953", "Sphere");
    model.component("comp1").geom("geom1").feature("sph953")
         .set("pos", new double[]{0.2978659463103887, 0.22353783237685748, 0.8625742301527347});
    model.component("comp1").geom("geom1").feature("sph953").set("r", 0.006962381205507404);
    model.component("comp1").geom("geom1").create("sph954", "Sphere");
    model.component("comp1").geom("geom1").feature("sph954")
         .set("pos", new double[]{0.36233238220410363, 0.3920137356869615, 0.055642827701266516});

    return model;
  }

  public static Model run10(Model model) {
    model.component("comp1").geom("geom1").feature("sph954").set("r", 0.004032651940964393);
    model.component("comp1").geom("geom1").create("sph956", "Sphere");
    model.component("comp1").geom("geom1").feature("sph956")
         .set("pos", new double[]{0.30102831259963553, 0.4204315467525951, 0.6520601887485985});
    model.component("comp1").geom("geom1").feature("sph956").set("r", 0.004662225174942792);
    model.component("comp1").geom("geom1").create("sph958", "Sphere");
    model.component("comp1").geom("geom1").feature("sph958")
         .set("pos", new double[]{0.3693579820520988, 0.15645313514800158, 0.5818666617508946});
    model.component("comp1").geom("geom1").feature("sph958").set("r", 0.001949947158348823);
    model.component("comp1").geom("geom1").create("sph959", "Sphere");
    model.component("comp1").geom("geom1").feature("sph959")
         .set("pos", new double[]{0.47986197361784916, 0.29992941874711565, 0.3984668474027406});
    model.component("comp1").geom("geom1").feature("sph959").set("r", 0.007572223698495256);
    model.component("comp1").geom("geom1").create("sph960", "Sphere");
    model.component("comp1").geom("geom1").feature("sph960")
         .set("pos", new double[]{0.46748463736280654, 0.8223618399786817, 0.7735044948554908});
    model.component("comp1").geom("geom1").feature("sph960").set("r", 0.0026465674557279908);
    model.component("comp1").geom("geom1").create("sph961", "Sphere");
    model.component("comp1").geom("geom1").feature("sph961")
         .set("pos", new double[]{0.3890079313474697, 0.23581679440982953, 0.12083801482419809});
    model.component("comp1").geom("geom1").feature("sph961").set("r", 0.001515610346949112);
    model.component("comp1").geom("geom1").create("sph962", "Sphere");
    model.component("comp1").geom("geom1").feature("sph962")
         .set("pos", new double[]{0.307529952986654, 0.5007986550394663, 0.5256770052437572});
    model.component("comp1").geom("geom1").feature("sph962").set("r", 0.008034517901650506);
    model.component("comp1").geom("geom1").create("sph963", "Sphere");
    model.component("comp1").geom("geom1").feature("sph963")
         .set("pos", new double[]{0.3731104792191532, 0.05543101623610901, 0.002991564635892327});
    model.component("comp1").geom("geom1").feature("sph963").set("r", 0.0029195380363507446);
    model.component("comp1").geom("geom1").create("sph964", "Sphere");
    model.component("comp1").geom("geom1").feature("sph964")
         .set("pos", new double[]{0.3554035622203744, 0.9001490688360162, 0.49637325782870834});
    model.component("comp1").geom("geom1").feature("sph964").set("r", 0.008922897384979332);
    model.component("comp1").geom("geom1").create("sph965", "Sphere");
    model.component("comp1").geom("geom1").feature("sph965")
         .set("pos", new double[]{0.3259699223250973, 0.08577163235484199, 0.31155201983971115});
    model.component("comp1").geom("geom1").feature("sph965").set("r", 0.004879974651293483);
    model.component("comp1").geom("geom1").create("sph966", "Sphere");
    model.component("comp1").geom("geom1").feature("sph966")
         .set("pos", new double[]{0.4372928559004823, 0.5402967265745875, 0.7549107939784863});
    model.component("comp1").geom("geom1").feature("sph966").set("r", 0.006476232386564575);
    model.component("comp1").geom("geom1").create("sph967", "Sphere");
    model.component("comp1").geom("geom1").feature("sph967")
         .set("pos", new double[]{0.39540714088561957, 0.8807516077469898, 0.21932514729632674});
    model.component("comp1").geom("geom1").feature("sph967").set("r", 0.0024197643249308873);
    model.component("comp1").geom("geom1").create("sph968", "Sphere");
    model.component("comp1").geom("geom1").feature("sph968")
         .set("pos", new double[]{0.43559317664365144, 0.8101538498144505, 0.24958275347828077});
    model.component("comp1").geom("geom1").feature("sph968").set("r", 0.003049020445536913);
    model.component("comp1").geom("geom1").create("sph969", "Sphere");
    model.component("comp1").geom("geom1").feature("sph969")
         .set("pos", new double[]{0.40689237773425546, 0.3992410353482633, 0.6230228189135023});
    model.component("comp1").geom("geom1").feature("sph969").set("r", 0.003984128237690001);
    model.component("comp1").geom("geom1").create("sph970", "Sphere");
    model.component("comp1").geom("geom1").feature("sph970")
         .set("pos", new double[]{0.4404202475448371, 0.8421060984018942, 0.8598484893290754});
    model.component("comp1").geom("geom1").feature("sph970").set("r", 0.005467870288870526);
    model.component("comp1").geom("geom1").create("sph971", "Sphere");
    model.component("comp1").geom("geom1").feature("sph971")
         .set("pos", new double[]{0.40168159386196306, 0.4503018643358082, 0.03375858231508025});
    model.component("comp1").geom("geom1").feature("sph971").set("r", 0.006503725699568589);
    model.component("comp1").geom("geom1").create("sph972", "Sphere");
    model.component("comp1").geom("geom1").feature("sph972")
         .set("pos", new double[]{0.2691466284101466, 0.4382447199742335, 0.8469042151618328});
    model.component("comp1").geom("geom1").feature("sph972").set("r", 0.0036926219751693625);
    model.component("comp1").geom("geom1").create("sph973", "Sphere");
    model.component("comp1").geom("geom1").feature("sph973")
         .set("pos", new double[]{0.4166464366120858, 0.1919835103286435, 0.2649864465335704});
    model.component("comp1").geom("geom1").feature("sph973").set("r", 0.0063712181593433915);
    model.component("comp1").geom("geom1").create("sph974", "Sphere");
    model.component("comp1").geom("geom1").feature("sph974")
         .set("pos", new double[]{0.4589805490400179, 0.28139747116260416, 0.5620186434302353});
    model.component("comp1").geom("geom1").feature("sph974").set("r", 0.002468189376756051);
    model.component("comp1").geom("geom1").create("sph975", "Sphere");
    model.component("comp1").geom("geom1").feature("sph975")
         .set("pos", new double[]{0.28270443589442884, 0.3482753827634916, 0.3311234081670061});
    model.component("comp1").geom("geom1").feature("sph975").set("r", 0.0022701575171710764);
    model.component("comp1").geom("geom1").create("sph976", "Sphere");
    model.component("comp1").geom("geom1").feature("sph976")
         .set("pos", new double[]{0.3994338738595367, 0.3174473959086697, 0.7666076533648594});
    model.component("comp1").geom("geom1").feature("sph976").set("r", 0.003959679104302671);
    model.component("comp1").geom("geom1").create("sph977", "Sphere");
    model.component("comp1").geom("geom1").feature("sph977")
         .set("pos", new double[]{0.3318328551348908, 0.6685786065680784, 0.6025582534529585});
    model.component("comp1").geom("geom1").feature("sph977").set("r", 0.001816036914219772);
    model.component("comp1").geom("geom1").create("sph978", "Sphere");
    model.component("comp1").geom("geom1").feature("sph978")
         .set("pos", new double[]{0.3601196358295603, 0.31001343821583044, 0.6313230010774192});
    model.component("comp1").geom("geom1").feature("sph978").set("r", 0.0020756405653034986);
    model.component("comp1").geom("geom1").create("sph979", "Sphere");
    model.component("comp1").geom("geom1").feature("sph979")
         .set("pos", new double[]{0.4169016229060967, 0.463989413634208, 0.27586643974708264});
    model.component("comp1").geom("geom1").feature("sph979").set("r", 0.002168832516155233);
    model.component("comp1").geom("geom1").create("sph980", "Sphere");
    model.component("comp1").geom("geom1").feature("sph980")
         .set("pos", new double[]{0.3018005023919867, 0.1576122506387408, 0.022845621988452792});
    model.component("comp1").geom("geom1").feature("sph980").set("r", 0.007726995942976686);
    model.component("comp1").geom("geom1").create("sph981", "Sphere");
    model.component("comp1").geom("geom1").feature("sph981")
         .set("pos", new double[]{0.37322501422200044, 0.516423029218139, 0.1215055831913559});
    model.component("comp1").geom("geom1").feature("sph981").set("r", 0.008751703206814319);
    model.component("comp1").geom("geom1").create("sph982", "Sphere");
    model.component("comp1").geom("geom1").feature("sph982")
         .set("pos", new double[]{0.3341007396965003, 0.5161666957608121, 0.7000807884363223});
    model.component("comp1").geom("geom1").feature("sph982").set("r", 0.0019699852244286463);
    model.component("comp1").geom("geom1").create("sph983", "Sphere");
    model.component("comp1").geom("geom1").feature("sph983")
         .set("pos", new double[]{0.45424681956842694, 0.37873940581981325, 0.03327282614778321});
    model.component("comp1").geom("geom1").feature("sph983").set("r", 0.005493433208616356);
    model.component("comp1").geom("geom1").create("sph984", "Sphere");
    model.component("comp1").geom("geom1").feature("sph984")
         .set("pos", new double[]{0.27526398939633945, 0.3237752928999404, 0.9804628778570619});
    model.component("comp1").geom("geom1").feature("sph984").set("r", 0.004835370475235015);
    model.component("comp1").geom("geom1").create("sph985", "Sphere");
    model.component("comp1").geom("geom1").feature("sph985")
         .set("pos", new double[]{0.3137081315561529, 0.3781247009261092, 0.4323650863068409});
    model.component("comp1").geom("geom1").feature("sph985").set("r", 0.00871618831408939);
    model.component("comp1").geom("geom1").create("sph986", "Sphere");
    model.component("comp1").geom("geom1").feature("sph986")
         .set("pos", new double[]{0.26571215994368735, 0.045889291058846204, 0.12314811975452011});
    model.component("comp1").geom("geom1").feature("sph986").set("r", 0.007874815399301672);
    model.component("comp1").geom("geom1").create("sph987", "Sphere");
    model.component("comp1").geom("geom1").feature("sph987")
         .set("pos", new double[]{0.3547740259907939, 0.8442814810917288, 0.2869320472498972});
    model.component("comp1").geom("geom1").feature("sph987").set("r", 0.006654924843265669);
    model.component("comp1").geom("geom1").create("sph988", "Sphere");
    model.component("comp1").geom("geom1").feature("sph988")
         .set("pos", new double[]{0.4244617929274839, 0.5447127287763488, 0.31877973549082916});
    model.component("comp1").geom("geom1").feature("sph988").set("r", 0.005403268268284904);
    model.component("comp1").geom("geom1").create("sph989", "Sphere");
    model.component("comp1").geom("geom1").feature("sph989")
         .set("pos", new double[]{0.38495816017679574, 0.1438547451393779, 0.9372196218382434});
    model.component("comp1").geom("geom1").feature("sph989").set("r", 0.0023728849175201575);
    model.component("comp1").geom("geom1").create("sph990", "Sphere");
    model.component("comp1").geom("geom1").feature("sph990")
         .set("pos", new double[]{0.29753817874661515, 0.7180570507142038, 0.10819284058319867});
    model.component("comp1").geom("geom1").feature("sph990").set("r", 0.005859015495495764);
    model.component("comp1").geom("geom1").create("sph991", "Sphere");
    model.component("comp1").geom("geom1").feature("sph991")
         .set("pos", new double[]{0.3650009369760011, 0.13849881238889095, 0.04456457070460012});
    model.component("comp1").geom("geom1").feature("sph991").set("r", 0.007944803109766183);
    model.component("comp1").geom("geom1").create("sph992", "Sphere");
    model.component("comp1").geom("geom1").feature("sph992")
         .set("pos", new double[]{0.32307781229723287, 0.9432575559083956, 0.501799828886512});
    model.component("comp1").geom("geom1").feature("sph992").set("r", 0.009940401943209148);
    model.component("comp1").geom("geom1").create("sph993", "Sphere");
    model.component("comp1").geom("geom1").feature("sph993")
         .set("pos", new double[]{0.2772878581633014, 0.945723591911295, 0.730321369172003});
    model.component("comp1").geom("geom1").feature("sph993").set("r", 0.005527138455329334);
    model.component("comp1").geom("geom1").create("sph994", "Sphere");
    model.component("comp1").geom("geom1").feature("sph994")
         .set("pos", new double[]{0.2843694679698088, 0.17935345700483785, 0.432935639196357});
    model.component("comp1").geom("geom1").feature("sph994").set("r", 0.005668550543435961);
    model.component("comp1").geom("geom1").create("sph995", "Sphere");
    model.component("comp1").geom("geom1").feature("sph995")
         .set("pos", new double[]{0.38903912759952974, 0.0799538031855043, 0.04426257404146207});
    model.component("comp1").geom("geom1").feature("sph995").set("r", 0.004260329386589953);
    model.component("comp1").geom("geom1").create("sph996", "Sphere");
    model.component("comp1").geom("geom1").feature("sph996")
         .set("pos", new double[]{0.26240606166280045, 0.06448490850713177, 0.3777264159974861});
    model.component("comp1").geom("geom1").feature("sph996").set("r", 0.005599927780210488);
    model.component("comp1").geom("geom1").create("sph997", "Sphere");
    model.component("comp1").geom("geom1").feature("sph997")
         .set("pos", new double[]{0.3467238278394872, 0.24255419430957648, 0.1887419632054566});
    model.component("comp1").geom("geom1").feature("sph997").set("r", 0.0015560116276132178);
    model.component("comp1").geom("geom1").create("sph998", "Sphere");
    model.component("comp1").geom("geom1").feature("sph998")
         .set("pos", new double[]{0.2835048786180709, 0.3510353508654064, 0.4354782780243479});
    model.component("comp1").geom("geom1").feature("sph998").set("r", 0.004642118483376366);
    model.component("comp1").geom("geom1").create("sph999", "Sphere");
    model.component("comp1").geom("geom1").feature("sph999")
         .set("pos", new double[]{0.4758697859309805, 0.3115851915531164, 0.2961547044171943});
    model.component("comp1").geom("geom1").feature("sph999").set("r", 0.008470026522641241);
    model.component("comp1").geom("geom1").create("sph1000", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1000")
         .set("pos", new double[]{0.28877618210904427, 0.35154529464613465, 0.05866594594888071});
    model.component("comp1").geom("geom1").feature("sph1000").set("r", 0.006098664468440964);
    model.component("comp1").geom("geom1").create("sph1001", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1001")
         .set("pos", new double[]{0.2819422665361677, 0.5612675224753955, 0.6403444207936366});
    model.component("comp1").geom("geom1").feature("sph1001").set("r", 0.004411613294039149);
    model.component("comp1").geom("geom1").create("sph1002", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1002")
         .set("pos", new double[]{0.3048110570745267, 0.21299007356059474, 0.938575087189995});
    model.component("comp1").geom("geom1").feature("sph1002").set("r", 0.009883823830090264);
    model.component("comp1").geom("geom1").create("sph1003", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1003")
         .set("pos", new double[]{0.4019751929894195, 0.835410918766808, 0.2147909769252205});
    model.component("comp1").geom("geom1").feature("sph1003").set("r", 0.008781767546111367);
    model.component("comp1").geom("geom1").create("sph1004", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1004")
         .set("pos", new double[]{0.46031359009373396, 0.2525788527722869, 0.5082248343072515});
    model.component("comp1").geom("geom1").feature("sph1004").set("r", 0.008866259405770925);
    model.component("comp1").geom("geom1").create("sph1005", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1005")
         .set("pos", new double[]{0.4164309560449077, 0.6575116295162785, 0.5586448547883007});
    model.component("comp1").geom("geom1").feature("sph1005").set("r", 0.009367968375019041);
    model.component("comp1").geom("geom1").create("sph1006", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1006")
         .set("pos", new double[]{0.49133197538265205, 0.44786862548471496, 0.31273958334005364});
    model.component("comp1").geom("geom1").feature("sph1006").set("r", 0.0034194840822392523);
    model.component("comp1").geom("geom1").create("sph1007", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1007")
         .set("pos", new double[]{0.4002983040015298, 0.3446257445014849, 0.3067571735909437});
    model.component("comp1").geom("geom1").feature("sph1007").set("r", 0.007557226387135995);
    model.component("comp1").geom("geom1").create("sph1008", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1008")
         .set("pos", new double[]{0.27209215090129046, 0.6249740997689882, 0.5056602670454625});
    model.component("comp1").geom("geom1").feature("sph1008").set("r", 0.0029305601664627915);
    model.component("comp1").geom("geom1").create("sph1009", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1009")
         .set("pos", new double[]{0.26655149171136794, 0.02189700187883282, 0.7370107507848352});
    model.component("comp1").geom("geom1").feature("sph1009").set("r", 0.0031136356967756155);
    model.component("comp1").geom("geom1").create("sph1010", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1010")
         .set("pos", new double[]{0.31791835910007105, 0.016730428116698583, 0.15252160634020845});
    model.component("comp1").geom("geom1").feature("sph1010").set("r", 0.0026942787023965303);
    model.component("comp1").geom("geom1").create("sph1011", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1011")
         .set("pos", new double[]{0.3150910553882494, 0.9459049696390195, 0.1703013331787903});
    model.component("comp1").geom("geom1").feature("sph1011").set("r", 0.008870011458062464);
    model.component("comp1").geom("geom1").create("sph1012", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1012")
         .set("pos", new double[]{0.464515790448651, 0.427089693039972, 0.2693516809825496});
    model.component("comp1").geom("geom1").feature("sph1012").set("r", 0.0032793531279367992);
    model.component("comp1").geom("geom1").create("sph1013", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1013")
         .set("pos", new double[]{0.26930111667229756, 0.8849528666671276, 0.8366189285560431});
    model.component("comp1").geom("geom1").feature("sph1013").set("r", 0.007235323864481618);
    model.component("comp1").geom("geom1").create("sph1014", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1014")
         .set("pos", new double[]{0.4485962783071585, 0.959535893980552, 0.49209772717353534});
    model.component("comp1").geom("geom1").feature("sph1014").set("r", 0.0017721733161919228);
    model.component("comp1").geom("geom1").create("sph1015", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1015")
         .set("pos", new double[]{0.4177508534106102, 0.26957911696628634, 0.6478313866481883});
    model.component("comp1").geom("geom1").feature("sph1015").set("r", 0.006113380151134341);
    model.component("comp1").geom("geom1").create("sph1016", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1016")
         .set("pos", new double[]{0.35238175983210035, 0.8985529638148299, 0.7947609426368926});
    model.component("comp1").geom("geom1").feature("sph1016").set("r", 0.005273807500926479);
    model.component("comp1").geom("geom1").create("sph1017", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1017")
         .set("pos", new double[]{0.4528261800274154, 0.050435071482829635, 0.6045241950261795});
    model.component("comp1").geom("geom1").feature("sph1017").set("r", 0.009411468653832643);
    model.component("comp1").geom("geom1").create("sph1018", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1018")
         .set("pos", new double[]{0.41381446218308426, 0.27527617071952143, 0.4267129849363622});
    model.component("comp1").geom("geom1").feature("sph1018").set("r", 0.007278731933639239);
    model.component("comp1").geom("geom1").create("sph1019", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1019")
         .set("pos", new double[]{0.27462050248263087, 0.5603483657260961, 0.5821890446542184});
    model.component("comp1").geom("geom1").feature("sph1019").set("r", 0.001351262242752363);
    model.component("comp1").geom("geom1").create("sph1020", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1020")
         .set("pos", new double[]{0.3623418918127425, 0.47223424494699906, 0.01408410434509812});
    model.component("comp1").geom("geom1").feature("sph1020").set("r", 0.0028110636156127495);
    model.component("comp1").geom("geom1").create("sph1021", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1021")
         .set("pos", new double[]{0.40550753805859185, 0.9905701996417922, 0.6497051533466324});
    model.component("comp1").geom("geom1").feature("sph1021").set("r", 0.0022826870497224365);
    model.component("comp1").geom("geom1").create("sph1022", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1022")
         .set("pos", new double[]{0.4540216290186701, 0.43182279126499834, 0.08543363991720168});
    model.component("comp1").geom("geom1").feature("sph1022").set("r", 0.00208195000469074);
    model.component("comp1").geom("geom1").create("sph1023", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1023")
         .set("pos", new double[]{0.31049167579023795, 0.41784667825142785, 0.3206195097400297});
    model.component("comp1").geom("geom1").feature("sph1023").set("r", 0.006398421249934203);
    model.component("comp1").geom("geom1").create("sph1024", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1024")
         .set("pos", new double[]{0.35869462224693527, 0.10935659917391166, 0.21953423852411594});
    model.component("comp1").geom("geom1").feature("sph1024").set("r", 0.006785685527565156);
    model.component("comp1").geom("geom1").create("sph1025", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1025")
         .set("pos", new double[]{0.4441127124798801, 0.015140018691218952, 0.611189682769213});
    model.component("comp1").geom("geom1").feature("sph1025").set("r", 0.005504007462742554);
    model.component("comp1").geom("geom1").create("sph1026", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1026")
         .set("pos", new double[]{0.400587223350628, 0.8354314827068695, 0.22959235022837207});
    model.component("comp1").geom("geom1").feature("sph1026").set("r", 0.0020429358280809958);
    model.component("comp1").geom("geom1").create("sph1027", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1027")
         .set("pos", new double[]{0.44052077479056523, 0.17911993490728498, 0.15635491984530803});
    model.component("comp1").geom("geom1").feature("sph1027").set("r", 0.00545963277229541);
    model.component("comp1").geom("geom1").create("sph1028", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1028")
         .set("pos", new double[]{0.4201014148826589, 0.732246240908811, 0.837677157420304});
    model.component("comp1").geom("geom1").feature("sph1028").set("r", 0.009145412817753343);
    model.component("comp1").geom("geom1").create("sph1029", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1029")
         .set("pos", new double[]{0.3722371425074684, 0.5555985968956625, 0.7144767614218451});
    model.component("comp1").geom("geom1").feature("sph1029").set("r", 0.005854832027965103);
    model.component("comp1").geom("geom1").create("sph1030", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1030")
         .set("pos", new double[]{0.2774504742098455, 0.13888994870846347, 0.9696203579105447});
    model.component("comp1").geom("geom1").feature("sph1030").set("r", 0.004518435746370354);
    model.component("comp1").geom("geom1").create("sph1031", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1031")
         .set("pos", new double[]{0.42728459545348746, 0.9423811342776344, 0.13034615707803576});
    model.component("comp1").geom("geom1").feature("sph1031").set("r", 0.0014654589610670421);
    model.component("comp1").geom("geom1").create("sph1032", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1032")
         .set("pos", new double[]{0.32857745042157066, 0.2409107426277923, 0.8473330015193726});
    model.component("comp1").geom("geom1").feature("sph1032").set("r", 0.0075003794006687045);
    model.component("comp1").geom("geom1").create("sph1033", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1033")
         .set("pos", new double[]{0.3395720596396945, 0.6302110181464944, 0.1818901306191891});
    model.component("comp1").geom("geom1").feature("sph1033").set("r", 0.009184183224273855);
    model.component("comp1").geom("geom1").create("sph1034", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1034")
         .set("pos", new double[]{0.4641279118113205, 0.3216127014542587, 0.6504865221321067});
    model.component("comp1").geom("geom1").feature("sph1034").set("r", 0.008107834927836274);
    model.component("comp1").geom("geom1").create("sph1035", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1035")
         .set("pos", new double[]{0.26245818891203027, 0.8494118833254818, 0.5708324743086344});
    model.component("comp1").geom("geom1").feature("sph1035").set("r", 0.008887759281023432);
    model.component("comp1").geom("geom1").create("sph1036", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1036")
         .set("pos", new double[]{0.3804401904648585, 0.8209988842206097, 0.7200299195342456});
    model.component("comp1").geom("geom1").feature("sph1036").set("r", 0.00472613846297636);
    model.component("comp1").geom("geom1").create("sph1037", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1037")
         .set("pos", new double[]{0.3720491870223952, 0.8948567878307091, 0.23529253321260296});
    model.component("comp1").geom("geom1").feature("sph1037").set("r", 0.0055113836561402445);
    model.component("comp1").geom("geom1").create("sph1038", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1038")
         .set("pos", new double[]{0.4189945259603516, 0.7014589527134828, 0.5681314509100612});
    model.component("comp1").geom("geom1").feature("sph1038").set("r", 0.0018613152622822572);
    model.component("comp1").geom("geom1").create("sph1039", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1039")
         .set("pos", new double[]{0.3253606149943739, 0.616256036155241, 0.2744853468463341});
    model.component("comp1").geom("geom1").feature("sph1039").set("r", 0.0033628289057034046);
    model.component("comp1").geom("geom1").create("sph1040", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1040")
         .set("pos", new double[]{0.3348646246756474, 0.5103234273664984, 0.2323390515480749});
    model.component("comp1").geom("geom1").feature("sph1040").set("r", 0.0054965909116084675);
    model.component("comp1").geom("geom1").create("sph1041", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1041")
         .set("pos", new double[]{0.43219736345765164, 0.38636347374064167, 0.23405448400810572});
    model.component("comp1").geom("geom1").feature("sph1041").set("r", 0.002782544304837549);
    model.component("comp1").geom("geom1").create("sph1042", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1042")
         .set("pos", new double[]{0.35214059987240737, 0.12257383289527632, 0.7044172008181281});
    model.component("comp1").geom("geom1").feature("sph1042").set("r", 0.008725783613339443);
    model.component("comp1").geom("geom1").create("sph1043", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1043")
         .set("pos", new double[]{0.39085128882715847, 0.622822303623959, 0.9593180807464936});
    model.component("comp1").geom("geom1").feature("sph1043").set("r", 0.003519747903175338);
    model.component("comp1").geom("geom1").create("sph1044", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1044")
         .set("pos", new double[]{0.32221707982471887, 0.9298686332950465, 0.7171054318446899});
    model.component("comp1").geom("geom1").feature("sph1044").set("r", 0.002719910805536504);
    model.component("comp1").geom("geom1").create("sph1045", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1045")
         .set("pos", new double[]{0.4313249651493385, 0.41425889044415337, 0.4109589178485736});
    model.component("comp1").geom("geom1").feature("sph1045").set("r", 0.00504397897277691);
    model.component("comp1").geom("geom1").create("sph1046", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1046")
         .set("pos", new double[]{0.3804058882819794, 0.2638073040725688, 0.6329501165519186});
    model.component("comp1").geom("geom1").feature("sph1046").set("r", 0.0024077507880170246);
    model.component("comp1").geom("geom1").create("sph1047", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1047")
         .set("pos", new double[]{0.46018489908523397, 0.7688728634291757, 0.1511634145475556});
    model.component("comp1").geom("geom1").feature("sph1047").set("r", 0.004587455645554281);
    model.component("comp1").geom("geom1").create("sph1048", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1048")
         .set("pos", new double[]{0.4257335473464464, 0.5142583834643203, 0.11882685528850868});
    model.component("comp1").geom("geom1").feature("sph1048").set("r", 0.0063198276686705366);
    model.component("comp1").geom("geom1").create("sph1049", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1049")
         .set("pos", new double[]{0.35896678078953576, 0.32768132238294523, 0.5816228557995982});
    model.component("comp1").geom("geom1").feature("sph1049").set("r", 0.00552922654711542);
    model.component("comp1").geom("geom1").create("sph1050", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1050")
         .set("pos", new double[]{0.3109644440659523, 0.7340499924752124, 0.21562040018951292});
    model.component("comp1").geom("geom1").feature("sph1050").set("r", 0.003923850996888769);
    model.component("comp1").geom("geom1").create("sph1051", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1051")
         .set("pos", new double[]{0.48688640038832415, 0.4422079949075116, 0.8072394146684226});
    model.component("comp1").geom("geom1").feature("sph1051").set("r", 0.008247594298886529);
    model.component("comp1").geom("geom1").create("sph1052", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1052")
         .set("pos", new double[]{0.4478302548702574, 0.9601406624077963, 0.5169377559578575});
    model.component("comp1").geom("geom1").feature("sph1052").set("r", 0.0025153095555083688);
    model.component("comp1").geom("geom1").create("sph1053", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1053")
         .set("pos", new double[]{0.2924461164574414, 0.9138758604634764, 0.32573087857839605});
    model.component("comp1").geom("geom1").feature("sph1053").set("r", 0.003301478237871455);
    model.component("comp1").geom("geom1").create("sph1054", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1054")
         .set("pos", new double[]{0.3590865505042982, 0.4359246557201017, 0.7623547257186919});
    model.component("comp1").geom("geom1").feature("sph1054").set("r", 0.005473033577947594);
    model.component("comp1").geom("geom1").create("sph1055", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1055")
         .set("pos", new double[]{0.40661781236149447, 0.9485290069899476, 0.19627447765272904});
    model.component("comp1").geom("geom1").feature("sph1055").set("r", 0.00941642487383525);
    model.component("comp1").geom("geom1").create("sph1056", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1056")
         .set("pos", new double[]{0.419122674899504, 0.7123641799812636, 0.7527386817310068});
    model.component("comp1").geom("geom1").feature("sph1056").set("r", 0.006075435489655572);
    model.component("comp1").geom("geom1").create("sph1057", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1057")
         .set("pos", new double[]{0.46749234878254636, 0.13465070325440515, 0.2803066982072275});
    model.component("comp1").geom("geom1").feature("sph1057").set("r", 0.003998350914707481);
    model.component("comp1").geom("geom1").create("sph1058", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1058")
         .set("pos", new double[]{0.3970393526693864, 0.29742077034329306, 0.9035692290489643});

    return model;
  }

  public static Model run11(Model model) {
    model.component("comp1").geom("geom1").feature("sph1058").set("r", 0.005218426005189627);
    model.component("comp1").geom("geom1").create("sph1059", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1059")
         .set("pos", new double[]{0.27913421242729247, 0.8158187367244069, 0.960737338335061});
    model.component("comp1").geom("geom1").feature("sph1059").set("r", 0.005066621483658316);
    model.component("comp1").geom("geom1").create("sph1060", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1060")
         .set("pos", new double[]{0.388210966460784, 0.5823866079423917, 0.7991374030113245});
    model.component("comp1").geom("geom1").feature("sph1060").set("r", 0.004116948850772604);
    model.component("comp1").geom("geom1").create("sph1061", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1061")
         .set("pos", new double[]{0.45869833017490097, 0.7205606037742727, 0.03712136048645546});
    model.component("comp1").geom("geom1").feature("sph1061").set("r", 0.002366544464754179);
    model.component("comp1").geom("geom1").create("sph1062", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1062")
         .set("pos", new double[]{0.26276854096259694, 0.4964833959029508, 0.5981998330972981});
    model.component("comp1").geom("geom1").feature("sph1062").set("r", 0.0061022365414501005);
    model.component("comp1").geom("geom1").create("sph1063", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1063")
         .set("pos", new double[]{0.4759876109712674, 0.2997821036653154, 0.8399390863302071});
    model.component("comp1").geom("geom1").feature("sph1063").set("r", 0.0067139173506626255);
    model.component("comp1").geom("geom1").create("sph1064", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1064")
         .set("pos", new double[]{0.41504219775240175, 0.8048208822062447, 0.7217693925549348});
    model.component("comp1").geom("geom1").feature("sph1064").set("r", 0.005069990920333733);
    model.component("comp1").geom("geom1").create("sph1065", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1065")
         .set("pos", new double[]{0.4067968570713488, 0.7958721669599341, 0.9023387815106254});
    model.component("comp1").geom("geom1").feature("sph1065").set("r", 0.00815950530000044);
    model.component("comp1").geom("geom1").create("sph1066", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1066")
         .set("pos", new double[]{0.33511817890543666, 0.9633453815808556, 0.06575263976939881});
    model.component("comp1").geom("geom1").feature("sph1066").set("r", 0.009139769573964236);
    model.component("comp1").geom("geom1").create("sph1067", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1067")
         .set("pos", new double[]{0.3738686750289839, 0.23400555299255973, 0.534687776150087});
    model.component("comp1").geom("geom1").feature("sph1067").set("r", 0.006547624240889507);
    model.component("comp1").geom("geom1").create("sph1068", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1068")
         .set("pos", new double[]{0.388257342500659, 0.8533356953334033, 0.14211669950011746});
    model.component("comp1").geom("geom1").feature("sph1068").set("r", 0.0015935919373008048);
    model.component("comp1").geom("geom1").create("sph1069", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1069")
         .set("pos", new double[]{0.4067506688473986, 0.3604066555894694, 0.4156707922110964});
    model.component("comp1").geom("geom1").feature("sph1069").set("r", 0.0039281696806678455);
    model.component("comp1").geom("geom1").create("sph1070", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1070")
         .set("pos", new double[]{0.3708077111189471, 0.37422206680017417, 0.14712710714073218});
    model.component("comp1").geom("geom1").feature("sph1070").set("r", 0.004046058083440183);
    model.component("comp1").geom("geom1").create("sph1071", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1071")
         .set("pos", new double[]{0.272158875240826, 0.46783749698213456, 0.8434770536430377});
    model.component("comp1").geom("geom1").feature("sph1071").set("r", 0.002789315165788067);
    model.component("comp1").geom("geom1").create("sph1072", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1072")
         .set("pos", new double[]{0.41410521360006636, 0.42051274395909516, 0.8700329383821739});
    model.component("comp1").geom("geom1").feature("sph1072").set("r", 0.0018149597504667015);
    model.component("comp1").geom("geom1").create("sph1073", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1073")
         .set("pos", new double[]{0.4219503698991006, 0.3999737721877038, 0.5415902162427683});
    model.component("comp1").geom("geom1").feature("sph1073").set("r", 0.004269821912476472);
    model.component("comp1").geom("geom1").create("sph1074", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1074")
         .set("pos", new double[]{0.4845024081580002, 0.14071063553167446, 0.5286329912183207});
    model.component("comp1").geom("geom1").feature("sph1074").set("r", 0.007974510772980802);
    model.component("comp1").geom("geom1").create("sph1075", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1075")
         .set("pos", new double[]{0.2596827160350532, 0.7468643893581568, 0.9811541866639997});
    model.component("comp1").geom("geom1").feature("sph1075").set("r", 0.002190417781459576);
    model.component("comp1").geom("geom1").create("sph1076", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1076")
         .set("pos", new double[]{0.2735456460857917, 0.06730159775856363, 0.3169058128941661});
    model.component("comp1").geom("geom1").feature("sph1076").set("r", 0.006358629548226522);
    model.component("comp1").geom("geom1").create("sph1077", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1077")
         .set("pos", new double[]{0.25536033635571687, 0.8396481331257133, 0.4688580212408899});
    model.component("comp1").geom("geom1").feature("sph1077").set("r", 0.00442795654385526);
    model.component("comp1").geom("geom1").create("sph1078", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1078")
         .set("pos", new double[]{0.46338347492570936, 0.5007608416344965, 0.6245267818541681});
    model.component("comp1").geom("geom1").feature("sph1078").set("r", 0.009961369138724654);
    model.component("comp1").geom("geom1").create("sph1079", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1079")
         .set("pos", new double[]{0.32734569904349875, 0.13303830811838338, 0.5450523628037415});
    model.component("comp1").geom("geom1").feature("sph1079").set("r", 0.003830967993268775);
    model.component("comp1").geom("geom1").create("sph1080", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1080")
         .set("pos", new double[]{0.36189931618809285, 0.32234305094596793, 0.7895251606859913});
    model.component("comp1").geom("geom1").feature("sph1080").set("r", 0.001735041385751381);
    model.component("comp1").geom("geom1").create("sph1081", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1081")
         .set("pos", new double[]{0.4718141596655582, 0.1922830598323786, 0.926729339173341});
    model.component("comp1").geom("geom1").feature("sph1081").set("r", 0.004433010524062467);
    model.component("comp1").geom("geom1").create("sph1082", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1082")
         .set("pos", new double[]{0.28487541789237575, 0.5021229081449987, 0.2708607897337574});
    model.component("comp1").geom("geom1").feature("sph1082").set("r", 0.0063395798014364985);
    model.component("comp1").geom("geom1").create("sph1083", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1083")
         .set("pos", new double[]{0.4104846875691186, 0.0695065119078945, 0.41882282345991545});
    model.component("comp1").geom("geom1").feature("sph1083").set("r", 0.007741328472663697);
    model.component("comp1").geom("geom1").create("sph1084", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1084")
         .set("pos", new double[]{0.3536129543876767, 0.7392528976852126, 0.12032948780972201});
    model.component("comp1").geom("geom1").feature("sph1084").set("r", 0.008984225827969941);
    model.component("comp1").geom("geom1").create("sph1085", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1085")
         .set("pos", new double[]{0.37556513086948423, 0.9396928843148193, 0.5366641513589});
    model.component("comp1").geom("geom1").feature("sph1085").set("r", 0.008802249642134042);
    model.component("comp1").geom("geom1").create("sph1086", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1086")
         .set("pos", new double[]{0.4855473277687701, 0.7257127629199748, 0.5760488582579649});
    model.component("comp1").geom("geom1").feature("sph1086").set("r", 0.00792303115505477);
    model.component("comp1").geom("geom1").create("sph1087", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1087")
         .set("pos", new double[]{0.264565897639709, 0.4331258664147243, 0.4132331913267201});
    model.component("comp1").geom("geom1").feature("sph1087").set("r", 0.004300373256483948);
    model.component("comp1").geom("geom1").create("sph1088", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1088")
         .set("pos", new double[]{0.30253842978254264, 0.7385647494961821, 0.04533953652517557});
    model.component("comp1").geom("geom1").feature("sph1088").set("r", 0.008407560318737985);
    model.component("comp1").geom("geom1").create("sph1089", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1089")
         .set("pos", new double[]{0.41397031093853764, 0.4238362761790175, 0.2697179315362643});
    model.component("comp1").geom("geom1").feature("sph1089").set("r", 0.008977287952847798);
    model.component("comp1").geom("geom1").create("sph1090", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1090")
         .set("pos", new double[]{0.395955718710625, 0.4107161350873707, 0.7417302006134792});
    model.component("comp1").geom("geom1").feature("sph1090").set("r", 0.0026596093608580998);
    model.component("comp1").geom("geom1").create("sph1091", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1091")
         .set("pos", new double[]{0.3276569470191557, 0.6471538915638486, 0.4241380719915158});
    model.component("comp1").geom("geom1").feature("sph1091").set("r", 0.009160970963388075);
    model.component("comp1").geom("geom1").create("sph1092", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1092")
         .set("pos", new double[]{0.4035385003287512, 0.364080014566831, 0.015072684700516936});
    model.component("comp1").geom("geom1").feature("sph1092").set("r", 0.0013846509371872517);
    model.component("comp1").geom("geom1").create("sph1093", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1093")
         .set("pos", new double[]{0.2772051262840322, 0.6268237430715257, 0.5262181260253125});
    model.component("comp1").geom("geom1").feature("sph1093").set("r", 0.005250519829586823);
    model.component("comp1").geom("geom1").create("sph1094", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1094")
         .set("pos", new double[]{0.47941138837347763, 0.8762402894642624, 0.7115793500345786});
    model.component("comp1").geom("geom1").feature("sph1094").set("r", 0.005503138688465828);
    model.component("comp1").geom("geom1").create("sph1095", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1095")
         .set("pos", new double[]{0.31616189224431346, 0.014259450358986306, 0.12434964636808594});
    model.component("comp1").geom("geom1").feature("sph1095").set("r", 0.0061978663964965515);
    model.component("comp1").geom("geom1").create("sph1096", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1096")
         .set("pos", new double[]{0.3015369595645423, 0.5694602220664549, 0.5346784218119777});
    model.component("comp1").geom("geom1").feature("sph1096").set("r", 0.0038826480696627073);
    model.component("comp1").geom("geom1").create("sph1097", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1097")
         .set("pos", new double[]{0.4474263480038215, 0.7290729761579119, 0.6861888677838675});
    model.component("comp1").geom("geom1").feature("sph1097").set("r", 0.004508123004467138);
    model.component("comp1").geom("geom1").create("sph1098", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1098")
         .set("pos", new double[]{0.2659053949779455, 0.42882288984083294, 0.4991908737699373});
    model.component("comp1").geom("geom1").feature("sph1098").set("r", 0.0055240772269915285);
    model.component("comp1").geom("geom1").create("sph1099", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1099")
         .set("pos", new double[]{0.256104264676826, 0.6508952329033344, 0.2598337089037718});
    model.component("comp1").geom("geom1").feature("sph1099").set("r", 0.005030628367028547);
    model.component("comp1").geom("geom1").create("sph1101", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1101")
         .set("pos", new double[]{0.39673982116891304, 0.5428896322449177, 0.016794725208947696});
    model.component("comp1").geom("geom1").feature("sph1101").set("r", 0.0011236743376429896);
    model.component("comp1").geom("geom1").create("sph1102", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1102")
         .set("pos", new double[]{0.45780177932981625, 0.4528210365344383, 0.1258353429407095});
    model.component("comp1").geom("geom1").feature("sph1102").set("r", 0.0019276187560696193);
    model.component("comp1").geom("geom1").create("sph1103", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1103")
         .set("pos", new double[]{0.40232012296168174, 0.32948952344807186, 0.02798496244281643});
    model.component("comp1").geom("geom1").feature("sph1103").set("r", 0.002403284357447105);
    model.component("comp1").geom("geom1").create("sph1104", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1104")
         .set("pos", new double[]{0.2643773050583143, 0.11552103349580262, 0.16335724669282578});
    model.component("comp1").geom("geom1").feature("sph1104").set("r", 0.006724166465961359);
    model.component("comp1").geom("geom1").create("sph1105", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1105")
         .set("pos", new double[]{0.43919303922480957, 0.09530707011950079, 0.1502504623264573});
    model.component("comp1").geom("geom1").feature("sph1105").set("r", 0.0022895012033363835);
    model.component("comp1").geom("geom1").create("sph1106", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1106")
         .set("pos", new double[]{0.28863674282478197, 0.7444552389833378, 0.4878689592877862});
    model.component("comp1").geom("geom1").feature("sph1106").set("r", 0.0050231401208617596);
    model.component("comp1").geom("geom1").create("sph1107", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1107")
         .set("pos", new double[]{0.2677660168221628, 0.8488639290053296, 0.15998474492162712});
    model.component("comp1").geom("geom1").feature("sph1107").set("r", 0.008916790566161334);
    model.component("comp1").geom("geom1").create("sph1108", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1108")
         .set("pos", new double[]{0.3347565982002171, 0.5105818113332664, 0.032582623768488465});
    model.component("comp1").geom("geom1").feature("sph1108").set("r", 0.009330712622969538);
    model.component("comp1").geom("geom1").create("sph1109", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1109")
         .set("pos", new double[]{0.3077718876604405, 0.9103156224269019, 0.6593400974744331});
    model.component("comp1").geom("geom1").feature("sph1109").set("r", 0.0075622501932603265);
    model.component("comp1").geom("geom1").create("sph1111", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1111")
         .set("pos", new double[]{0.3214429865736662, 0.948339958199821, 0.799250890173157});
    model.component("comp1").geom("geom1").feature("sph1111").set("r", 0.00494629074095173);
    model.component("comp1").geom("geom1").create("sph1113", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1113")
         .set("pos", new double[]{0.42040816134236103, 0.9580401712309871, 0.7781630494740864});
    model.component("comp1").geom("geom1").feature("sph1113").set("r", 0.003917364174515511);
    model.component("comp1").geom("geom1").create("sph1114", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1114")
         .set("pos", new double[]{0.43339269307513323, 0.4687173890849339, 0.2826254593734401});
    model.component("comp1").geom("geom1").feature("sph1114").set("r", 0.006090029535240676);
    model.component("comp1").geom("geom1").create("sph1115", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1115")
         .set("pos", new double[]{0.41881674666308943, 0.14356766491271605, 0.45945899834107257});
    model.component("comp1").geom("geom1").feature("sph1115").set("r", 0.0013657063597453012);
    model.component("comp1").geom("geom1").create("sph1116", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1116")
         .set("pos", new double[]{0.467344766470651, 0.6078323733447881, 0.2216769803670222});
    model.component("comp1").geom("geom1").feature("sph1116").set("r", 0.0070007908861850305);
    model.component("comp1").geom("geom1").create("sph1117", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1117")
         .set("pos", new double[]{0.41513947473286866, 0.19852674346010285, 0.7297263296879929});
    model.component("comp1").geom("geom1").feature("sph1117").set("r", 0.005266500902792638);
    model.component("comp1").geom("geom1").create("sph1118", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1118")
         .set("pos", new double[]{0.3802775283102533, 0.8531505375234019, 0.22907486531263324});
    model.component("comp1").geom("geom1").feature("sph1118").set("r", 0.0078744181354383);
    model.component("comp1").geom("geom1").create("sph1119", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1119")
         .set("pos", new double[]{0.46893749408882546, 0.7017671692591891, 0.8032902441064206});
    model.component("comp1").geom("geom1").feature("sph1119").set("r", 0.00583963744228489);
    model.component("comp1").geom("geom1").create("sph1120", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1120")
         .set("pos", new double[]{0.39275863108995035, 0.32509804997297054, 0.6579633041609982});
    model.component("comp1").geom("geom1").feature("sph1120").set("r", 0.0029988372008516125);
    model.component("comp1").geom("geom1").create("sph1121", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1121")
         .set("pos", new double[]{0.4049407537728497, 0.616327765471023, 0.7337388035723947});
    model.component("comp1").geom("geom1").feature("sph1121").set("r", 0.005703486821939801);
    model.component("comp1").geom("geom1").create("sph1122", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1122")
         .set("pos", new double[]{0.2726458322017397, 0.9410324901680668, 0.4079773336178692});
    model.component("comp1").geom("geom1").feature("sph1122").set("r", 0.008189940581052097);
    model.component("comp1").geom("geom1").create("sph1123", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1123")
         .set("pos", new double[]{0.47835907340891737, 0.7825539229017897, 0.4207569582411757});
    model.component("comp1").geom("geom1").feature("sph1123").set("r", 0.0025308731096739157);
    model.component("comp1").geom("geom1").create("sph1124", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1124")
         .set("pos", new double[]{0.3100535691052539, 0.4142421258544236, 0.4022077811317388});
    model.component("comp1").geom("geom1").feature("sph1124").set("r", 0.0063992306302181855);
    model.component("comp1").geom("geom1").create("sph1125", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1125")
         .set("pos", new double[]{0.35899400807959025, 0.7509022472840146, 0.7855621002309927});
    model.component("comp1").geom("geom1").feature("sph1125").set("r", 0.007786363954753649);
    model.component("comp1").geom("geom1").create("sph1126", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1126")
         .set("pos", new double[]{0.3605517360343859, 0.5205307688549672, 0.007949885112720706});
    model.component("comp1").geom("geom1").feature("sph1126").set("r", 0.004470578754495859);
    model.component("comp1").geom("geom1").create("sph1127", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1127")
         .set("pos", new double[]{0.45987121745401516, 0.7595022631323964, 0.07948189388813794});
    model.component("comp1").geom("geom1").feature("sph1127").set("r", 0.0027554950016624854);
    model.component("comp1").geom("geom1").create("sph1128", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1128")
         .set("pos", new double[]{0.26161947967745797, 0.5337443768556648, 0.16602730635648225});
    model.component("comp1").geom("geom1").feature("sph1128").set("r", 0.00671407898571535);
    model.component("comp1").geom("geom1").create("sph1129", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1129")
         .set("pos", new double[]{0.4017103672694233, 0.07155246417242764, 0.6388013910203638});
    model.component("comp1").geom("geom1").feature("sph1129").set("r", 0.00868107112327942);
    model.component("comp1").geom("geom1").create("sph1130", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1130")
         .set("pos", new double[]{0.42920596394181215, 0.12215158768652741, 0.6621117510990067});
    model.component("comp1").geom("geom1").feature("sph1130").set("r", 0.009029783899832819);
    model.component("comp1").geom("geom1").create("sph1131", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1131")
         .set("pos", new double[]{0.406131357445799, 0.7913271929561926, 0.3069602525970801});
    model.component("comp1").geom("geom1").feature("sph1131").set("r", 0.006496324124127411);
    model.component("comp1").geom("geom1").create("sph1132", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1132")
         .set("pos", new double[]{0.30295831170380855, 0.4575357368972022, 0.41060053622255516});
    model.component("comp1").geom("geom1").feature("sph1132").set("r", 0.004199216746113562);
    model.component("comp1").geom("geom1").create("sph1133", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1133")
         .set("pos", new double[]{0.3115560663653876, 0.12126309411852448, 0.5543168638883599});
    model.component("comp1").geom("geom1").feature("sph1133").set("r", 0.00175691658927044);
    model.component("comp1").geom("geom1").create("sph1134", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1134")
         .set("pos", new double[]{0.33233720505133, 0.8153505065690501, 0.5714633326642768});
    model.component("comp1").geom("geom1").feature("sph1134").set("r", 0.0026853987363426807);
    model.component("comp1").geom("geom1").create("sph1135", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1135")
         .set("pos", new double[]{0.4810460583457958, 0.4380626090723996, 0.8792857994634469});
    model.component("comp1").geom("geom1").feature("sph1135").set("r", 0.005676249630837744);
    model.component("comp1").geom("geom1").create("sph1136", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1136")
         .set("pos", new double[]{0.3525078403242207, 0.3479809918116993, 0.8983755427492983});
    model.component("comp1").geom("geom1").feature("sph1136").set("r", 0.006200686046053087);
    model.component("comp1").geom("geom1").create("sph1137", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1137")
         .set("pos", new double[]{0.3159511335646, 0.5192318389157347, 0.2528172868724014});
    model.component("comp1").geom("geom1").feature("sph1137").set("r", 0.0060872082200479636);
    model.component("comp1").geom("geom1").create("sph1138", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1138")
         .set("pos", new double[]{0.28463362982481394, 0.6881105399880749, 0.7792640283190949});
    model.component("comp1").geom("geom1").feature("sph1138").set("r", 0.0031660200705989684);
    model.component("comp1").geom("geom1").create("sph1139", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1139")
         .set("pos", new double[]{0.35303391781232174, 0.7907748293643595, 0.020088134434061294});
    model.component("comp1").geom("geom1").feature("sph1139").set("r", 0.003912507756488781);
    model.component("comp1").geom("geom1").create("sph1140", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1140")
         .set("pos", new double[]{0.3284361010689342, 0.5431044744721051, 0.8917138564931948});
    model.component("comp1").geom("geom1").feature("sph1140").set("r", 0.003995478594683154);
    model.component("comp1").geom("geom1").create("sph1141", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1141")
         .set("pos", new double[]{0.45975731254756574, 0.5569718868097985, 0.587427657146229});
    model.component("comp1").geom("geom1").feature("sph1141").set("r", 0.0013646506253022698);
    model.component("comp1").geom("geom1").create("sph1142", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1142")
         .set("pos", new double[]{0.289217175683694, 0.2809376776419877, 0.23524166662821655});
    model.component("comp1").geom("geom1").feature("sph1142").set("r", 0.00961269073039317);
    model.component("comp1").geom("geom1").run();

    model.view().create("view2", 2);

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    model.component("comp1").physics("gop").create("relb1", "ReleaseFromBoundary", 2);
    model.component("comp1").physics("gop").feature("relb1").selection().set(1);
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().named("geom1_ps3_bnd");
    model.component("comp1").physics("gop").create("relg1", "ReleaseGrid", -1);

    model.result().table("tbl2").label("Ray Intensity");
    model.result().table("tbl2").comments("Ray Evaluation 1");
    model.result().table("tbl4").label("Ray s2");
    model.result().table("tbl5").label("Ray s3");
    model.result().table("tbl6").label("x");
    model.result().table("tbl7").label("y");
    model.result().table("tbl8").label("z");
    model.result().table("tbl9").label("Ray s0");
    model.result().table("tbl13").label("Ray s1");

    model.component("comp1").material("mat1").label("Bubble");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_bubble", "0", "0", "0", "n_bubble", "0", "0", "0", "n_bubble"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    model.component("comp1").physics("gop").prop("IntensityComputation")
         .set("IntensityComputation", "ComputeIntensityAndPower");
    model.component("comp1").physics("gop").prop("ExteriorUnmeshedProperties").set("next", 1.33);
    model.component("comp1").physics("gop").prop("MaximumSecondary").set("MaximumSecondary", 0);
    model.component("comp1").physics("gop").feature("matd1").set("ReleaseReflectedRays", "Never");
    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");
    model.component("comp1").physics("gop").feature("relb1").set("Nr", 200);
    model.component("comp1").physics("gop").feature("relb1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relb1").set("I0", "1007.9829860012198[W/m^2]");
    model.component("comp1").physics("gop").feature("relb1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("relb1").set("P0", 0.19376799157814023);
    model.component("comp1").physics("gop").feature("relb1").active(false);
    model.component("comp1").physics("gop").feature("relg1").set("GridType", "Cylindrical");
    model.component("comp1").physics("gop").feature("relg1")
         .set("qcc", new String[][]{{"0"}, {"height/2"}, {"depth/2"}});
    model.component("comp1").physics("gop").feature("relg1").set("Rc", 0.01);
    model.component("comp1").physics("gop").feature("relg1").set("Ncr", 10);
    model.component("comp1").physics("gop").feature("relg1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relg1").set("I0", 1000);
    model.component("comp1").physics("gop").feature("relg1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("relg1").set("InitialPolarization", "UserDefined");
    model.component("comp1").physics("gop").feature("relg1").set("a10", 0.45);
    model.component("comp1").physics("gop").feature("relg1").set("a20", -0.33);
    model.component("comp1").physics("gop").feature("relg1").set("delta0", "-pi/3");
    model.component("comp1").physics("gop").feature("relg1").set("P0", 0.4);

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
    model.result().export().create("tbl3", "Table");
    model.result().export().create("tbl4", "Table");
    model.result().export().create("tbl5", "Table");
    model.result().export().create("tbl6", "Table");
    model.result().export().create("tbl7", "Table");
    model.result().export().create("tbl8", "Table");

    model.study("std1").feature("rtrac").set("tlist", "range(0,0.01,15)");

    return model;
  }

  public static Model run12(Model model) {

    model.sol("sol1").attach("std1");
    model.sol("sol1").feature("st1").label("Compile Equations: Ray Tracing");
    model.sol("sol1").feature("v1").label("Dependent Variables 1.1");
    model.sol("sol1").feature("v1").set("clist", new String[]{"range(0,0.01,15)", "0.015000000000000003[ns]"});
    model.sol("sol1").feature("t1").label("Time-Dependent Solver 1.1");
    model.sol("sol1").feature("t1").set("control", "user");
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
    model.sol("sol1").runAll();

    model.result().dataset("cpl1").set("planetype", "general");
    model.result().dataset("cpl1")
         .set("genpoints", new double[][]{{0.7500000000000001, 0.500001, 0.500001}, {1.58759, 1.04628, 0.500001}, {0.632878, 0.6795750000000002, 1.47676}});
    model.result().numerical("ray1").label("Ray Intensity");
    model.result().numerical("ray1").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray1").set("looplevelindices", new String[]{"1, 1501"});
    model.result().numerical("ray1").set("table", "tbl2");
    model.result().numerical("ray1").set("expr", "gop.I");
    model.result().numerical("ray1").set("unit", "W/m^2");
    model.result().numerical("ray1").set("descr", "Intensity");
    model.result().numerical("ray2").label("Ray s1");
    model.result().numerical("ray2").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray2").set("looplevelindices", new String[]{"1, 1501"});
    model.result().numerical("ray2").set("table", "tbl13");
    model.result().numerical("ray2").set("expr", "gop.sn1");
    model.result().numerical("ray2").set("descr", "Normalized Stokes parameter 1");
    model.result().numerical("ray3").label("Ray s2");
    model.result().numerical("ray3").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray3").set("looplevelindices", new String[]{"1, 1501"});
    model.result().numerical("ray3").set("table", "tbl4");
    model.result().numerical("ray3").set("expr", "gop.sn2");
    model.result().numerical("ray3").set("descr", "Normalized Stokes parameter 2");
    model.result().numerical("ray4").label("Ray s3");
    model.result().numerical("ray4").set("looplevelinput", new String[]{"manualindices"});
    model.result().numerical("ray4").set("looplevelindices", new String[]{"1, 1501"});
    model.result().numerical("ray4").set("table", "tbl5");
    model.result().numerical("ray4").set("expr", "gop.sn3");
    model.result().numerical("ray4").set("descr", "Normalized Stokes parameter 3");
    model.result().numerical("ray5").set("table", "tbl10");
    model.result().numerical("ray6").set("table", "tbl11");
    model.result().numerical("ray7").set("table", "tbl12");
    model.result().numerical("ray8").label("Ray s0");
    model.result().numerical("ray8").set("looplevelinput", new String[]{"last"});
    model.result().numerical("ray8").set("table", "tbl9");
    model.result().numerical("ray8").set("expr", "gop.s0");
    model.result().numerical("ray8").set("unit", "W/m^2");
    model.result().numerical("ray8").set("descr", "Stokes parameter 0");
    model.result().numerical("ray1").setResult();
    model.result().numerical("ray2").setResult();
    model.result().numerical("ray3").setResult();
    model.result().numerical("ray4").setResult();
    model.result().numerical("ray5").setResult();
    model.result().numerical("ray6").setResult();
    model.result().numerical("ray7").setResult();
    model.result().numerical("ray8").setResult();
    model.result("pg1").label("Ray Trajectories (gop)");
    model.result().export("tbl1").label("Ray Intensity");
    model.result().export("tbl1").set("filename", "ray_convergence/Int/10.csv");
    model.result().export("tbl3").label("Ray s2");
    model.result().export("tbl3").set("table", "tbl4");
    model.result().export("tbl3").set("filename", "ray_convergence/s2/10.csv");
    model.result().export("tbl4").label("Ray s3");
    model.result().export("tbl4").set("table", "tbl5");
    model.result().export("tbl4").set("filename", "ray_convergence/s3/10.csv");
    model.result().export("tbl8").label("Ray s0");
    model.result().export("tbl8").set("filename", "ray_convergence/s0/10.csv");

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
    model = run8(model);
    model = run9(model);
    model = run10(model);
    model = run11(model);
    run12(model);
  }

}
