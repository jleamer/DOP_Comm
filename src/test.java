/*
 * test.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Apr 28 2022, 16:09 by COMSOL 6.0.0.312. */
public class test {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src/output_class_files");

    model.label("Finished_Bubbles_3D_1_Model.mph");

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
    model.result().table().create("tbl3", "Table");
    model.result().table().create("tbl4", "Table");
    model.result().table().create("tbl5", "Table");

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").create("ps1", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps1").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("ps2", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps2").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ps2").set("pos", new String[]{"width", "0", "0"});
    model.component("comp1").geom("geom1").feature("ps2").set("parmax1", "height");
    model.component("comp1").geom("geom1").feature("ps2").set("parmax2", "depth");
    model.component("comp1").geom("geom1").feature("ps2").set("coord", new String[]{"0", "s1", "s2"});
    model.component("comp1").geom("geom1").create("sph0", "Sphere");
    model.component("comp1").geom("geom1").feature("sph0")
         .set("pos", new double[]{0.2695164254587199, 0.31395798303244393, 0.16753122945294324});
    model.component("comp1").geom("geom1").feature("sph0").set("r", 0.019406489868843163);
    model.component("comp1").geom("geom1").create("sph1", "Sphere");
    model.component("comp1").geom("geom1").feature("sph1")
         .set("pos", new double[]{0.44055642091207203, 0.3507643334494347, 0.4002457438583088});
    model.component("comp1").geom("geom1").feature("sph1").set("r", 0.006846771895375956);
    model.component("comp1").geom("geom1").create("sph2", "Sphere");
    model.component("comp1").geom("geom1").feature("sph2")
         .set("pos", new double[]{0.6717441431728127, 0.6756709407337561, 0.21968852518124007});
    model.component("comp1").geom("geom1").feature("sph2").set("r", 0.015776334680067138);
    model.component("comp1").geom("geom1").create("sph3", "Sphere");
    model.component("comp1").geom("geom1").feature("sph3")
         .set("pos", new double[]{0.2987140850686506, 0.6593658651520179, 0.422690302094002});
    model.component("comp1").geom("geom1").feature("sph3").set("r", 0.02256234872781891);
    model.component("comp1").geom("geom1").create("sph4", "Sphere");
    model.component("comp1").geom("geom1").feature("sph4")
         .set("pos", new double[]{0.40201955559260466, 0.21390514950318032, 0.7850013143560974});
    model.component("comp1").geom("geom1").feature("sph4").set("r", 0.016173796568915034);
    model.component("comp1").geom("geom1").create("sph5", "Sphere");
    model.component("comp1").geom("geom1").feature("sph5")
         .set("pos", new double[]{0.5725161043475173, 0.6791041932434568, 0.8505197515797231});
    model.component("comp1").geom("geom1").feature("sph5").set("r", 0.024365231514387953);
    model.component("comp1").geom("geom1").create("sph6", "Sphere");
    model.component("comp1").geom("geom1").feature("sph6")
         .set("pos", new double[]{0.3540426577988038, 0.06937772623309944, 0.19155038324738408});
    model.component("comp1").geom("geom1").feature("sph6").set("r", 0.02289213327007695);
    model.component("comp1").geom("geom1").create("sph7", "Sphere");
    model.component("comp1").geom("geom1").feature("sph7")
         .set("pos", new double[]{0.36647171416864743, 0.4262455461620828, 0.9280691539139677});
    model.component("comp1").geom("geom1").feature("sph7").set("r", 0.022562850068588262);
    model.component("comp1").geom("geom1").create("sph8", "Sphere");
    model.component("comp1").geom("geom1").feature("sph8")
         .set("pos", new double[]{0.9358662541654005, 0.3249845885225898, 0.6769284670409329});
    model.component("comp1").geom("geom1").feature("sph8").set("r", 0.015663305699460343);
    model.component("comp1").geom("geom1").create("sph9", "Sphere");
    model.component("comp1").geom("geom1").feature("sph9")
         .set("pos", new double[]{0.2891873533780477, 0.7342889108193283, 0.9578746156475773});
    model.component("comp1").geom("geom1").feature("sph9").set("r", 0.02169251343794746);
    model.component("comp1").geom("geom1").create("sph10", "Sphere");
    model.component("comp1").geom("geom1").feature("sph10")
         .set("pos", new double[]{0.5392101227177676, 0.7719437942751651, 0.12700333335750236});
    model.component("comp1").geom("geom1").feature("sph10").set("r", 0.019963313087596787);
    model.component("comp1").geom("geom1").create("sph11", "Sphere");
    model.component("comp1").geom("geom1").feature("sph11")
         .set("pos", new double[]{1.1471892568357651, 0.3035032793959783, 0.2979442405064402});
    model.component("comp1").geom("geom1").feature("sph11").set("r", 0.013957870523518105);
    model.component("comp1").geom("geom1").create("sph12", "Sphere");
    model.component("comp1").geom("geom1").feature("sph12")
         .set("pos", new double[]{0.27667312941883365, 0.6725403177920068, 0.22177913589268008});
    model.component("comp1").geom("geom1").feature("sph12").set("r", 0.0076005714423655535);
    model.component("comp1").geom("geom1").create("sph13", "Sphere");
    model.component("comp1").geom("geom1").feature("sph13")
         .set("pos", new double[]{0.7417469364636216, 0.07150579212735488, 0.5711068100256897});
    model.component("comp1").geom("geom1").feature("sph13").set("r", 0.010310933187444525);
    model.component("comp1").geom("geom1").create("sph14", "Sphere");
    model.component("comp1").geom("geom1").feature("sph14")
         .set("pos", new double[]{0.8378883345678106, 0.6925931988406474, 0.11659835206487898});
    model.component("comp1").geom("geom1").feature("sph14").set("r", 0.007934571498116202);
    model.component("comp1").geom("geom1").create("sph15", "Sphere");
    model.component("comp1").geom("geom1").feature("sph15")
         .set("pos", new double[]{0.939236454176858, 0.41817527493435297, 0.07090863378253887});
    model.component("comp1").geom("geom1").feature("sph15").set("r", 0.013281119756391367);
    model.component("comp1").geom("geom1").create("sph16", "Sphere");
    model.component("comp1").geom("geom1").feature("sph16")
         .set("pos", new double[]{0.9086456203003312, 0.5141232778309864, 0.9217266440381144});
    model.component("comp1").geom("geom1").feature("sph16").set("r", 0.015717928118310232);
    model.component("comp1").geom("geom1").create("sph17", "Sphere");
    model.component("comp1").geom("geom1").feature("sph17")
         .set("pos", new double[]{1.139903199064594, 0.15685610460555044, 0.15856142790317013});
    model.component("comp1").geom("geom1").feature("sph17").set("r", 0.01673110081003986);
    model.component("comp1").geom("geom1").create("sph18", "Sphere");
    model.component("comp1").geom("geom1").feature("sph18")
         .set("pos", new double[]{0.6520046618337216, 0.1862011754454645, 0.9008766548377395});
    model.component("comp1").geom("geom1").feature("sph18").set("r", 0.021147825774190478);
    model.component("comp1").geom("geom1").create("sph19", "Sphere");
    model.component("comp1").geom("geom1").feature("sph19")
         .set("pos", new double[]{0.9948150266375251, 0.7160742704428918, 0.8664748775754805});
    model.component("comp1").geom("geom1").feature("sph19").set("r", 0.011955317194910131);
    model.component("comp1").geom("geom1").create("sph20", "Sphere");
    model.component("comp1").geom("geom1").feature("sph20")
         .set("pos", new double[]{0.9921727768201144, 0.3572009079004449, 0.282569638193069});
    model.component("comp1").geom("geom1").feature("sph20").set("r", 0.01747344414111218);
    model.component("comp1").geom("geom1").create("sph21", "Sphere");
    model.component("comp1").geom("geom1").feature("sph21")
         .set("pos", new double[]{0.6813871624510294, 0.9342370940577001, 0.6526812534688198});
    model.component("comp1").geom("geom1").feature("sph21").set("r", 0.022917724363921338);
    model.component("comp1").geom("geom1").create("sph22", "Sphere");
    model.component("comp1").geom("geom1").feature("sph22")
         .set("pos", new double[]{0.3781789444161701, 0.9248267590091327, 0.4526603459655394});
    model.component("comp1").geom("geom1").feature("sph22").set("r", 0.017433914404182436);
    model.component("comp1").geom("geom1").create("sph23", "Sphere");
    model.component("comp1").geom("geom1").feature("sph23")
         .set("pos", new double[]{0.6611807435027592, 0.2510002053753951, 0.8819457139313994});
    model.component("comp1").geom("geom1").feature("sph23").set("r", 0.016567792287742637);
    model.component("comp1").geom("geom1").create("sph24", "Sphere");
    model.component("comp1").geom("geom1").feature("sph24")
         .set("pos", new double[]{0.2692493475847804, 0.6109424208556139, 0.33582356526946955});
    model.component("comp1").geom("geom1").feature("sph24").set("r", 0.016473589733445718);
    model.component("comp1").geom("geom1").create("sph25", "Sphere");
    model.component("comp1").geom("geom1").feature("sph25")
         .set("pos", new double[]{1.1239461218999045, 0.364560752379539, 0.8876662259382325});
    model.component("comp1").geom("geom1").feature("sph25").set("r", 0.015541162045152185);
    model.component("comp1").geom("geom1").create("sph26", "Sphere");
    model.component("comp1").geom("geom1").feature("sph26")
         .set("pos", new double[]{0.2827357394630148, 0.9058463549813757, 0.6804101090071104});
    model.component("comp1").geom("geom1").feature("sph26").set("r", 0.017467202315836056);
    model.component("comp1").geom("geom1").create("sph27", "Sphere");
    model.component("comp1").geom("geom1").feature("sph27")
         .set("pos", new double[]{0.438688395189656, 0.16249738948029413, 0.9023601055345046});
    model.component("comp1").geom("geom1").feature("sph27").set("r", 0.024946457009029612);
    model.component("comp1").geom("geom1").create("sph28", "Sphere");
    model.component("comp1").geom("geom1").feature("sph28")
         .set("pos", new double[]{0.3324369294640717, 0.7406787092386704, 0.7391836812518238});
    model.component("comp1").geom("geom1").feature("sph28").set("r", 0.018936363229798005);
    model.component("comp1").geom("geom1").create("sph29", "Sphere");
    model.component("comp1").geom("geom1").feature("sph29")
         .set("pos", new double[]{0.951599809358602, 0.14941511794567855, 0.05201022648336822});
    model.component("comp1").geom("geom1").feature("sph29").set("r", 0.02346049071092967);
    model.component("comp1").geom("geom1").create("sph30", "Sphere");
    model.component("comp1").geom("geom1").feature("sph30")
         .set("pos", new double[]{0.2835179652386984, 0.2540908179100252, 0.8488496427088598});
    model.component("comp1").geom("geom1").feature("sph30").set("r", 0.005524219737554386);
    model.component("comp1").geom("geom1").create("sph31", "Sphere");
    model.component("comp1").geom("geom1").feature("sph31")
         .set("pos", new double[]{0.8011552739790729, 0.8243980907981036, 0.14354839937119113});
    model.component("comp1").geom("geom1").feature("sph31").set("r", 0.01577662128683306);
    model.component("comp1").geom("geom1").create("sph32", "Sphere");
    model.component("comp1").geom("geom1").feature("sph32")
         .set("pos", new double[]{0.8339439751871035, 0.9502637371235293, 0.5585177670323321});
    model.component("comp1").geom("geom1").feature("sph32").set("r", 0.01058367358022279);
    model.component("comp1").geom("geom1").create("sph33", "Sphere");
    model.component("comp1").geom("geom1").feature("sph33")
         .set("pos", new double[]{1.0474021065761128, 0.2411842178652181, 0.7976629725721902});
    model.component("comp1").geom("geom1").feature("sph33").set("r", 0.005372945787458861);
    model.component("comp1").geom("geom1").create("sph34", "Sphere");
    model.component("comp1").geom("geom1").feature("sph34")
         .set("pos", new double[]{1.1042662928996863, 0.7358740430744994, 0.5536804920355926});
    model.component("comp1").geom("geom1").feature("sph34").set("r", 0.012757212881283436);
    model.component("comp1").geom("geom1").create("sph35", "Sphere");
    model.component("comp1").geom("geom1").feature("sph35")
         .set("pos", new double[]{0.316720573856565, 0.13476993863630696, 0.06070125323601526});
    model.component("comp1").geom("geom1").feature("sph35").set("r", 0.0077291045132137);
    model.component("comp1").geom("geom1").create("sph36", "Sphere");
    model.component("comp1").geom("geom1").feature("sph36")
         .set("pos", new double[]{0.47963163065250747, 0.7056835083729792, 0.5576687035933681});
    model.component("comp1").geom("geom1").feature("sph36").set("r", 0.007149882582121858);
    model.component("comp1").geom("geom1").create("sph37", "Sphere");
    model.component("comp1").geom("geom1").feature("sph37")
         .set("pos", new double[]{0.3264695081906643, 0.9530233556071316, 0.5660232453403962});
    model.component("comp1").geom("geom1").feature("sph37").set("r", 0.005251119603182317);
    model.component("comp1").geom("geom1").create("sph38", "Sphere");
    model.component("comp1").geom("geom1").feature("sph38")
         .set("pos", new double[]{0.5068165071457622, 0.734528352590084, 0.20704328171474576});
    model.component("comp1").geom("geom1").feature("sph38").set("r", 0.00906586469321981);
    model.component("comp1").geom("geom1").create("sph39", "Sphere");
    model.component("comp1").geom("geom1").feature("sph39")
         .set("pos", new double[]{1.2043897765312945, 0.8283586566460656, 0.2537019994799463});
    model.component("comp1").geom("geom1").feature("sph39").set("r", 0.016627178545465155);
    model.component("comp1").geom("geom1").create("sph40", "Sphere");
    model.component("comp1").geom("geom1").feature("sph40")
         .set("pos", new double[]{0.866386941165963, 0.8126138403728429, 0.17386629340670864});
    model.component("comp1").geom("geom1").feature("sph40").set("r", 0.014875394285374599);
    model.component("comp1").geom("geom1").create("sph41", "Sphere");
    model.component("comp1").geom("geom1").feature("sph41")
         .set("pos", new double[]{0.32464141650563333, 0.4867649038481186, 0.603060569900647});
    model.component("comp1").geom("geom1").feature("sph41").set("r", 0.00537152404354819);
    model.component("comp1").geom("geom1").create("sph42", "Sphere");
    model.component("comp1").geom("geom1").feature("sph42")
         .set("pos", new double[]{0.5733445314658633, 0.9628396697152277, 0.5755383353656731});
    model.component("comp1").geom("geom1").feature("sph42").set("r", 0.016377028741729627);
    model.component("comp1").geom("geom1").create("sph43", "Sphere");
    model.component("comp1").geom("geom1").feature("sph43")
         .set("pos", new double[]{0.7996640362963755, 0.7342439292493179, 0.6615826110270383});
    model.component("comp1").geom("geom1").feature("sph43").set("r", 0.012602823452471008);
    model.component("comp1").geom("geom1").create("sph44", "Sphere");
    model.component("comp1").geom("geom1").feature("sph44")
         .set("pos", new double[]{0.3252669414376366, 0.37535836144956325, 0.6244513936276664});
    model.component("comp1").geom("geom1").feature("sph44").set("r", 0.010298391153256188);
    model.component("comp1").geom("geom1").create("sph45", "Sphere");
    model.component("comp1").geom("geom1").feature("sph45")
         .set("pos", new double[]{0.9981030922711244, 0.08318449754811555, 0.26952066709509637});
    model.component("comp1").geom("geom1").feature("sph45").set("r", 0.009203480198296792);
    model.component("comp1").geom("geom1").create("sph46", "Sphere");
    model.component("comp1").geom("geom1").feature("sph46")
         .set("pos", new double[]{0.45636834620293965, 0.6307877832394699, 0.5231360580957702});
    model.component("comp1").geom("geom1").feature("sph46").set("r", 0.02109509127486691);
    model.component("comp1").geom("geom1").create("sph47", "Sphere");
    model.component("comp1").geom("geom1").feature("sph47")
         .set("pos", new double[]{0.5244200041131513, 0.09503836367545729, 0.7193183493332509});
    model.component("comp1").geom("geom1").feature("sph47").set("r", 0.023496159407987015);
    model.component("comp1").geom("geom1").create("sph48", "Sphere");
    model.component("comp1").geom("geom1").feature("sph48")
         .set("pos", new double[]{1.1411414363223817, 0.9056705334725268, 0.04354566245202103});
    model.component("comp1").geom("geom1").feature("sph48").set("r", 0.020443560590864936);
    model.component("comp1").geom("geom1").create("sph49", "Sphere");
    model.component("comp1").geom("geom1").feature("sph49")
         .set("pos", new double[]{0.8645158366572114, 0.9313365350022313, 0.9324506670925157});
    model.component("comp1").geom("geom1").feature("sph49").set("r", 0.009687241722428411);
    model.component("comp1").geom("geom1").create("sph50", "Sphere");
    model.component("comp1").geom("geom1").feature("sph50")
         .set("pos", new double[]{1.1521963422833499, 0.6341670914159202, 0.3957565849810148});
    model.component("comp1").geom("geom1").feature("sph50").set("r", 0.016133063763903128);
    model.component("comp1").geom("geom1").create("sph51", "Sphere");
    model.component("comp1").geom("geom1").feature("sph51")
         .set("pos", new double[]{0.8512396212435944, 0.5470982907662172, 0.9051111760704847});
    model.component("comp1").geom("geom1").feature("sph51").set("r", 0.014719813341938195);
    model.component("comp1").geom("geom1").create("sph52", "Sphere");
    model.component("comp1").geom("geom1").feature("sph52")
         .set("pos", new double[]{0.6497901083666241, 0.9323400616133046, 0.19571890990083146});
    model.component("comp1").geom("geom1").feature("sph52").set("r", 0.023374668712672124);
    model.component("comp1").geom("geom1").create("sph53", "Sphere");
    model.component("comp1").geom("geom1").feature("sph53")
         .set("pos", new double[]{0.39057237745016254, 0.5054636887598318, 0.03829688277251194});
    model.component("comp1").geom("geom1").feature("sph53").set("r", 0.007526590388792747);
    model.component("comp1").geom("geom1").create("sph54", "Sphere");
    model.component("comp1").geom("geom1").feature("sph54")
         .set("pos", new double[]{1.0614404875670935, 0.04795831369035697, 0.19818862006762722});
    model.component("comp1").geom("geom1").feature("sph54").set("r", 0.023959404224353623);
    model.component("comp1").geom("geom1").create("sph55", "Sphere");
    model.component("comp1").geom("geom1").feature("sph55")
         .set("pos", new double[]{0.3895881766293968, 0.7960951479443519, 0.35145684518592046});
    model.component("comp1").geom("geom1").feature("sph55").set("r", 0.011641271487336739);
    model.component("comp1").geom("geom1").create("sph56", "Sphere");
    model.component("comp1").geom("geom1").feature("sph56")
         .set("pos", new double[]{0.8281099523785819, 0.8532213135557779, 0.8214289147692044});
    model.component("comp1").geom("geom1").feature("sph56").set("r", 0.023802149646667346);
    model.component("comp1").geom("geom1").create("sph57", "Sphere");
    model.component("comp1").geom("geom1").feature("sph57")
         .set("pos", new double[]{0.7117344271249627, 0.5432779294909041, 0.7788313475067632});
    model.component("comp1").geom("geom1").feature("sph57").set("r", 0.023107846374172986);
    model.component("comp1").geom("geom1").create("sph58", "Sphere");
    model.component("comp1").geom("geom1").feature("sph58")
         .set("pos", new double[]{0.7404623774867478, 0.595004291084678, 0.03560412833283141});
    model.component("comp1").geom("geom1").feature("sph58").set("r", 0.010714377034682952);
    model.component("comp1").geom("geom1").create("sph59", "Sphere");
    model.component("comp1").geom("geom1").feature("sph59")
         .set("pos", new double[]{0.6859140596515029, 0.7908432026380307, 0.325173409979736});
    model.component("comp1").geom("geom1").feature("sph59").set("r", 0.016869628163932743);
    model.component("comp1").geom("geom1").create("sph60", "Sphere");
    model.component("comp1").geom("geom1").feature("sph60")
         .set("pos", new double[]{0.8242979299954992, 0.20477564449768013, 0.7690078063412555});
    model.component("comp1").geom("geom1").feature("sph60").set("r", 0.02285777417050303);
    model.component("comp1").geom("geom1").create("sph61", "Sphere");
    model.component("comp1").geom("geom1").feature("sph61")
         .set("pos", new double[]{0.3192910366842767, 0.4245416278396795, 0.6693129430358585});
    model.component("comp1").geom("geom1").feature("sph61").set("r", 0.01724062354089868);
    model.component("comp1").geom("geom1").create("sph62", "Sphere");
    model.component("comp1").geom("geom1").feature("sph62")
         .set("pos", new double[]{0.2737552681707947, 0.9449383024814484, 0.38481784699587956});
    model.component("comp1").geom("geom1").feature("sph62").set("r", 0.02337203555955052);
    model.component("comp1").geom("geom1").create("sph63", "Sphere");
    model.component("comp1").geom("geom1").feature("sph63")
         .set("pos", new double[]{0.8495901073511285, 0.8061714483624826, 0.5695600462304301});
    model.component("comp1").geom("geom1").feature("sph63").set("r", 0.024475670767166453);
    model.component("comp1").geom("geom1").create("sph64", "Sphere");
    model.component("comp1").geom("geom1").feature("sph64")
         .set("pos", new double[]{0.5431074962315167, 0.5820468222569765, 0.7362398020379615});
    model.component("comp1").geom("geom1").feature("sph64").set("r", 0.01756152396614701);
    model.component("comp1").geom("geom1").create("sph66", "Sphere");
    model.component("comp1").geom("geom1").feature("sph66")
         .set("pos", new double[]{0.9168764909893161, 0.4529818002077009, 0.38716139753052287});
    model.component("comp1").geom("geom1").feature("sph66").set("r", 0.01145361993673493);
    model.component("comp1").geom("geom1").create("sph67", "Sphere");
    model.component("comp1").geom("geom1").feature("sph67")
         .set("pos", new double[]{0.6540837198472362, 0.32586325748666234, 0.6162583524780124});
    model.component("comp1").geom("geom1").feature("sph67").set("r", 0.01321622699844371);
    model.component("comp1").geom("geom1").create("sph68", "Sphere");
    model.component("comp1").geom("geom1").feature("sph68")
         .set("pos", new double[]{1.210909975110474, 0.6694069307597138, 0.21280037108820096});
    model.component("comp1").geom("geom1").feature("sph68").set("r", 0.013604945416425287);
    model.component("comp1").geom("geom1").create("sph69", "Sphere");
    model.component("comp1").geom("geom1").feature("sph69")
         .set("pos", new double[]{0.5975865500809356, 0.7836295287169992, 0.8621125137753072});
    model.component("comp1").geom("geom1").feature("sph69").set("r", 0.013534020186960656);
    model.component("comp1").geom("geom1").create("sph70", "Sphere");
    model.component("comp1").geom("geom1").feature("sph70")
         .set("pos", new double[]{0.9052096945127514, 0.2854098307240556, 0.2687485550530451});
    model.component("comp1").geom("geom1").feature("sph70").set("r", 0.02307683911652744);
    model.component("comp1").geom("geom1").create("sph71", "Sphere");
    model.component("comp1").geom("geom1").feature("sph71")
         .set("pos", new double[]{0.7764897720811819, 0.7827635759213102, 0.5678350503072065});
    model.component("comp1").geom("geom1").feature("sph71").set("r", 0.02209795885394805);
    model.component("comp1").geom("geom1").create("sph73", "Sphere");
    model.component("comp1").geom("geom1").feature("sph73")
         .set("pos", new double[]{0.597192472056879, 0.08920663484124336, 0.38386053057322195});
    model.component("comp1").geom("geom1").feature("sph73").set("r", 0.014314197571839618);
    model.component("comp1").geom("geom1").create("sph74", "Sphere");
    model.component("comp1").geom("geom1").feature("sph74")
         .set("pos", new double[]{1.2264511492726626, 0.19217854258436334, 0.8015096533931007});
    model.component("comp1").geom("geom1").feature("sph74").set("r", 0.006592521553965047);
    model.component("comp1").geom("geom1").create("sph75", "Sphere");
    model.component("comp1").geom("geom1").feature("sph75")
         .set("pos", new double[]{0.92993494509252, 0.5649773825353769, 0.18300777328437448});
    model.component("comp1").geom("geom1").feature("sph75").set("r", 0.022499232899117965);
    model.component("comp1").geom("geom1").create("sph76", "Sphere");
    model.component("comp1").geom("geom1").feature("sph76")
         .set("pos", new double[]{0.5996117736949048, 0.23842369310985248, 0.5880088349670128});
    model.component("comp1").geom("geom1").feature("sph76").set("r", 0.014337600455266126);
    model.component("comp1").geom("geom1").create("sph77", "Sphere");
    model.component("comp1").geom("geom1").feature("sph77")
         .set("pos", new double[]{1.1569425112290284, 0.8922297864472679, 0.26743853020798625});
    model.component("comp1").geom("geom1").feature("sph77").set("r", 0.01124539675403834);
    model.component("comp1").geom("geom1").create("sph78", "Sphere");
    model.component("comp1").geom("geom1").feature("sph78")
         .set("pos", new double[]{0.4473950151798535, 0.4995984900326917, 0.7207141714532326});
    model.component("comp1").geom("geom1").feature("sph78").set("r", 0.007217826014880585);
    model.component("comp1").geom("geom1").create("sph79", "Sphere");
    model.component("comp1").geom("geom1").feature("sph79")
         .set("pos", new double[]{0.502651543265919, 0.8381930735480143, 0.41907404987316843});
    model.component("comp1").geom("geom1").feature("sph79").set("r", 0.00916388876817583);
    model.component("comp1").geom("geom1").create("sph80", "Sphere");
    model.component("comp1").geom("geom1").feature("sph80")
         .set("pos", new double[]{0.4928992424392158, 0.1237266755370629, 0.5149901550365091});
    model.component("comp1").geom("geom1").feature("sph80").set("r", 0.017333701343104725);
    model.component("comp1").geom("geom1").create("sph81", "Sphere");
    model.component("comp1").geom("geom1").feature("sph81")
         .set("pos", new double[]{0.4127739114349423, 0.6158272949625456, 0.5418498539882776});
    model.component("comp1").geom("geom1").feature("sph81").set("r", 0.014542819740995649);
    model.component("comp1").geom("geom1").create("sph82", "Sphere");
    model.component("comp1").geom("geom1").feature("sph82")
         .set("pos", new double[]{0.4074007262174842, 0.737400633061579, 0.23766038713710563});
    model.component("comp1").geom("geom1").feature("sph82").set("r", 0.018082746939414886);
    model.component("comp1").geom("geom1").create("sph83", "Sphere");
    model.component("comp1").geom("geom1").feature("sph83")
         .set("pos", new double[]{1.0265163074297516, 0.046583657698715905, 0.3332802930131356});
    model.component("comp1").geom("geom1").feature("sph83").set("r", 0.01538703648732066);
    model.component("comp1").geom("geom1").create("sph84", "Sphere");
    model.component("comp1").geom("geom1").feature("sph84")
         .set("pos", new double[]{1.0792263223326108, 0.535945148679193, 0.8428092033057825});
    model.component("comp1").geom("geom1").feature("sph84").set("r", 0.02245844752800222);
    model.component("comp1").geom("geom1").create("sph85", "Sphere");
    model.component("comp1").geom("geom1").feature("sph85")
         .set("pos", new double[]{1.0607419947743242, 0.8300383417139708, 0.12602573660658623});
    model.component("comp1").geom("geom1").feature("sph85").set("r", 0.023996119827072532);
    model.component("comp1").geom("geom1").create("sph86", "Sphere");
    model.component("comp1").geom("geom1").feature("sph86")
         .set("pos", new double[]{0.946179758427574, 0.6040615755121291, 0.782821175163781});
    model.component("comp1").geom("geom1").feature("sph86").set("r", 0.01802608664681982);
    model.component("comp1").geom("geom1").create("sph87", "Sphere");
    model.component("comp1").geom("geom1").feature("sph87")
         .set("pos", new double[]{1.0171626479010247, 0.7244562971010726, 0.2672397422866341});
    model.component("comp1").geom("geom1").feature("sph87").set("r", 0.005691424397432685);
    model.component("comp1").geom("geom1").create("sph88", "Sphere");
    model.component("comp1").geom("geom1").feature("sph88")
         .set("pos", new double[]{0.8796198394140823, 0.3515293086663406, 0.784641263927312});
    model.component("comp1").geom("geom1").feature("sph88").set("r", 0.010141385976442933);
    model.component("comp1").geom("geom1").create("sph89", "Sphere");
    model.component("comp1").geom("geom1").feature("sph89")
         .set("pos", new double[]{1.0248760171960447, 0.9670047445884138, 0.30980562737401846});
    model.component("comp1").geom("geom1").feature("sph89").set("r", 0.013922924640069147);
    model.component("comp1").geom("geom1").create("sph90", "Sphere");
    model.component("comp1").geom("geom1").feature("sph90")
         .set("pos", new double[]{1.1449997741726974, 0.5400748681847648, 0.9577825341317622});
    model.component("comp1").geom("geom1").feature("sph90").set("r", 0.007860116565161987);
    model.component("comp1").geom("geom1").create("sph91", "Sphere");
    model.component("comp1").geom("geom1").feature("sph91")
         .set("pos", new double[]{1.2263968061769632, 0.5435155249535019, 0.524960241256419});
    model.component("comp1").geom("geom1").feature("sph91").set("r", 0.017732088000037945);
    model.component("comp1").geom("geom1").create("sph92", "Sphere");
    model.component("comp1").geom("geom1").feature("sph92")
         .set("pos", new double[]{0.6079297811187547, 0.042998539315305305, 0.17242300288249385});
    model.component("comp1").geom("geom1").feature("sph92").set("r", 0.007708558061443398);
    model.component("comp1").geom("geom1").create("sph93", "Sphere");
    model.component("comp1").geom("geom1").feature("sph93")
         .set("pos", new double[]{0.29910175130534367, 0.3745272215391765, 0.8406687115427331});
    model.component("comp1").geom("geom1").feature("sph93").set("r", 0.01991274385414992);
    model.component("comp1").geom("geom1").create("sph94", "Sphere");
    model.component("comp1").geom("geom1").feature("sph94")
         .set("pos", new double[]{0.9337422659598126, 0.20660467092785412, 0.44525681673429585});
    model.component("comp1").geom("geom1").feature("sph94").set("r", 0.018853554350147086);
    model.component("comp1").geom("geom1").create("sph95", "Sphere");
    model.component("comp1").geom("geom1").feature("sph95")
         .set("pos", new double[]{1.2234610494516482, 0.21967709647051642, 0.2611694285075369});
    model.component("comp1").geom("geom1").feature("sph95").set("r", 0.016631548146885826);
    model.component("comp1").geom("geom1").create("sph96", "Sphere");
    model.component("comp1").geom("geom1").feature("sph96")
         .set("pos", new double[]{0.995047150242243, 0.4587172640560022, 0.07486800227719251});
    model.component("comp1").geom("geom1").feature("sph96").set("r", 0.010243461675458239);
    model.component("comp1").geom("geom1").create("sph97", "Sphere");
    model.component("comp1").geom("geom1").feature("sph97")
         .set("pos", new double[]{0.4706994803660948, 0.7835723130983749, 0.3075338514206778});
    model.component("comp1").geom("geom1").feature("sph97").set("r", 0.015170324812204792);
    model.component("comp1").geom("geom1").create("sph98", "Sphere");
    model.component("comp1").geom("geom1").feature("sph98")
         .set("pos", new double[]{0.8423949530773004, 0.8331455335435924, 0.384717027152409});
    model.component("comp1").geom("geom1").feature("sph98").set("r", 0.005552120239090073);
    model.component("comp1").geom("geom1").create("sph99", "Sphere");
    model.component("comp1").geom("geom1").feature("sph99")
         .set("pos", new double[]{0.7606958823103618, 0.5384949287617177, 0.9318708656746607});
    model.component("comp1").geom("geom1").feature("sph99").set("r", 0.01999716621452287);
    model.component("comp1").geom("geom1").create("sph100", "Sphere");
    model.component("comp1").geom("geom1").feature("sph100")
         .set("pos", new double[]{0.30203959452896484, 0.6963720672476217, 0.4671769347199343});

    return model;
  }

  public static Model run2(Model model) {
    model.component("comp1").geom("geom1").feature("sph100").set("r", 0.02107921782997294);
    model.component("comp1").geom("geom1").create("sph101", "Sphere");
    model.component("comp1").geom("geom1").feature("sph101")
         .set("pos", new double[]{0.4847766516882177, 0.2828882855406099, 0.10989270199201769});
    model.component("comp1").geom("geom1").feature("sph101").set("r", 0.023950978827901998);
    model.component("comp1").geom("geom1").create("sph102", "Sphere");
    model.component("comp1").geom("geom1").feature("sph102")
         .set("pos", new double[]{0.36963185315470426, 0.6274794168085922, 0.788680110335273});
    model.component("comp1").geom("geom1").feature("sph102").set("r", 0.01357237657327573);
    model.component("comp1").geom("geom1").create("sph103", "Sphere");
    model.component("comp1").geom("geom1").feature("sph103")
         .set("pos", new double[]{1.0061294183687555, 0.35157161814640325, 0.8258363591385438});
    model.component("comp1").geom("geom1").feature("sph103").set("r", 0.01893600992240357);
    model.component("comp1").geom("geom1").create("sph104", "Sphere");
    model.component("comp1").geom("geom1").feature("sph104")
         .set("pos", new double[]{1.0652127590992189, 0.620531769746546, 0.1602359197147254});
    model.component("comp1").geom("geom1").feature("sph104").set("r", 0.01357537549998885);
    model.component("comp1").geom("geom1").create("sph105", "Sphere");
    model.component("comp1").geom("geom1").feature("sph105")
         .set("pos", new double[]{0.2746595729192123, 0.08108177107896361, 0.4599561587550673});
    model.component("comp1").geom("geom1").feature("sph105").set("r", 0.0065677379970989595);
    model.component("comp1").geom("geom1").create("sph106", "Sphere");
    model.component("comp1").geom("geom1").feature("sph106")
         .set("pos", new double[]{0.2846463930883578, 0.7460601773351456, 0.3984816799957274});
    model.component("comp1").geom("geom1").feature("sph106").set("r", 0.0072668384553518095);
    model.component("comp1").geom("geom1").create("sph107", "Sphere");
    model.component("comp1").geom("geom1").feature("sph107")
         .set("pos", new double[]{0.7043028051633144, 0.45307542979498344, 0.4793854710700811});
    model.component("comp1").geom("geom1").feature("sph107").set("r", 0.019938769912150503);
    model.component("comp1").geom("geom1").create("sph108", "Sphere");
    model.component("comp1").geom("geom1").feature("sph108")
         .set("pos", new double[]{1.0443836841109544, 0.40717139741597475, 0.8848726623721841});
    model.component("comp1").geom("geom1").feature("sph108").set("r", 0.014480078531243883);
    model.component("comp1").geom("geom1").create("sph109", "Sphere");
    model.component("comp1").geom("geom1").feature("sph109")
         .set("pos", new double[]{1.020729596487257, 0.1374271046126331, 0.6147824704252616});
    model.component("comp1").geom("geom1").feature("sph109").set("r", 0.005741220959080718);
    model.component("comp1").geom("geom1").create("sph110", "Sphere");
    model.component("comp1").geom("geom1").feature("sph110")
         .set("pos", new double[]{0.7882249960205319, 0.018133451992068957, 0.9374709203132722});
    model.component("comp1").geom("geom1").feature("sph110").set("r", 0.005207285226704639);
    model.component("comp1").geom("geom1").create("sph111", "Sphere");
    model.component("comp1").geom("geom1").feature("sph111")
         .set("pos", new double[]{1.0322885096771137, 0.8877764817655284, 0.16902797615718104});
    model.component("comp1").geom("geom1").feature("sph111").set("r", 0.02310804067405556);
    model.component("comp1").geom("geom1").create("sph112", "Sphere");
    model.component("comp1").geom("geom1").feature("sph112")
         .set("pos", new double[]{0.44272615129574727, 0.6180481737417787, 0.8910748767216722});
    model.component("comp1").geom("geom1").feature("sph112").set("r", 0.008154601397410666);
    model.component("comp1").geom("geom1").create("sph114", "Sphere");
    model.component("comp1").geom("geom1").feature("sph114")
         .set("pos", new double[]{0.5063633050815178, 0.1884637963161638, 0.13697532572612647});
    model.component("comp1").geom("geom1").feature("sph114").set("r", 0.013017474647422419);
    model.component("comp1").geom("geom1").create("sph115", "Sphere");
    model.component("comp1").geom("geom1").feature("sph115")
         .set("pos", new double[]{0.41180525996847445, 0.2790299326915781, 0.7991446934711527});
    model.component("comp1").geom("geom1").feature("sph115").set("r", 0.021252211760656576);
    model.component("comp1").geom("geom1").create("sph116", "Sphere");
    model.component("comp1").geom("geom1").feature("sph116")
         .set("pos", new double[]{1.2215999664082748, 0.2765387028540403, 0.5322256526249435});
    model.component("comp1").geom("geom1").feature("sph116").set("r", 0.0112117450358842);
    model.component("comp1").geom("geom1").create("sph117", "Sphere");
    model.component("comp1").geom("geom1").feature("sph117")
         .set("pos", new double[]{1.1514981226822758, 0.3722384858705258, 0.4364198783494582});
    model.component("comp1").geom("geom1").feature("sph117").set("r", 0.011289340223716993);
    model.component("comp1").geom("geom1").create("sph118", "Sphere");
    model.component("comp1").geom("geom1").feature("sph118")
         .set("pos", new double[]{1.1755040791921645, 0.05463219193874391, 0.705928089543154});
    model.component("comp1").geom("geom1").feature("sph118").set("r", 0.015245853845567228);
    model.component("comp1").geom("geom1").create("sph119", "Sphere");
    model.component("comp1").geom("geom1").feature("sph119")
         .set("pos", new double[]{0.29886219303357786, 0.5206037866642245, 0.33741197245503995});
    model.component("comp1").geom("geom1").feature("sph119").set("r", 0.02282037908584678);
    model.component("comp1").geom("geom1").create("sph120", "Sphere");
    model.component("comp1").geom("geom1").feature("sph120")
         .set("pos", new double[]{0.805919611388821, 0.677981079269189, 0.45588877148530504});
    model.component("comp1").geom("geom1").feature("sph120").set("r", 0.02218978641731172);
    model.component("comp1").geom("geom1").create("sph121", "Sphere");
    model.component("comp1").geom("geom1").feature("sph121")
         .set("pos", new double[]{0.5474712449741106, 0.03639934953697406, 0.5725241990320464});
    model.component("comp1").geom("geom1").feature("sph121").set("r", 0.017566180750427145);
    model.component("comp1").geom("geom1").create("sph122", "Sphere");
    model.component("comp1").geom("geom1").feature("sph122")
         .set("pos", new double[]{0.766879806770313, 0.8987261897156997, 0.42959650491491835});
    model.component("comp1").geom("geom1").feature("sph122").set("r", 0.011228884282649256);
    model.component("comp1").geom("geom1").create("sph123", "Sphere");
    model.component("comp1").geom("geom1").feature("sph123")
         .set("pos", new double[]{0.6238544802000864, 0.914631653992702, 0.9194391496277101});
    model.component("comp1").geom("geom1").feature("sph123").set("r", 0.009947920732047708);
    model.component("comp1").geom("geom1").create("sph124", "Sphere");
    model.component("comp1").geom("geom1").feature("sph124")
         .set("pos", new double[]{1.1518127313781767, 0.24525295862038343, 0.11378978825858546});
    model.component("comp1").geom("geom1").feature("sph124").set("r", 0.021886598971314265);
    model.component("comp1").geom("geom1").create("sph125", "Sphere");
    model.component("comp1").geom("geom1").feature("sph125")
         .set("pos", new double[]{0.5679206100504853, 0.18748005538067136, 0.602907595284663});
    model.component("comp1").geom("geom1").feature("sph125").set("r", 0.009546194725693775);
    model.component("comp1").geom("geom1").create("sph126", "Sphere");
    model.component("comp1").geom("geom1").feature("sph126")
         .set("pos", new double[]{1.0579544492026693, 0.19978551791186996, 0.6924804982550297});
    model.component("comp1").geom("geom1").feature("sph126").set("r", 0.013271728300023228);
    model.component("comp1").geom("geom1").create("sph127", "Sphere");
    model.component("comp1").geom("geom1").feature("sph127")
         .set("pos", new double[]{0.8227633389334879, 0.3549698365213639, 0.07451491144205642});
    model.component("comp1").geom("geom1").feature("sph127").set("r", 0.009807112496982778);
    model.component("comp1").geom("geom1").create("sph128", "Sphere");
    model.component("comp1").geom("geom1").feature("sph128")
         .set("pos", new double[]{0.9109595734770571, 0.49735775920903436, 0.5182714598665554});
    model.component("comp1").geom("geom1").feature("sph128").set("r", 0.009576273419207517);
    model.component("comp1").geom("geom1").create("sph129", "Sphere");
    model.component("comp1").geom("geom1").feature("sph129")
         .set("pos", new double[]{0.8195144736629041, 0.9783791091311836, 0.8051157564171593});
    model.component("comp1").geom("geom1").feature("sph129").set("r", 0.00849440300217845);
    model.component("comp1").geom("geom1").create("sph130", "Sphere");
    model.component("comp1").geom("geom1").feature("sph130")
         .set("pos", new double[]{1.2099125827892478, 0.8799685948459516, 0.5904666260603877});
    model.component("comp1").geom("geom1").feature("sph130").set("r", 0.016887452476619557);
    model.component("comp1").geom("geom1").create("sph131", "Sphere");
    model.component("comp1").geom("geom1").feature("sph131")
         .set("pos", new double[]{0.3481684769115567, 0.0789742995173158, 0.4532437588956284});
    model.component("comp1").geom("geom1").feature("sph131").set("r", 0.005648526506289142);
    model.component("comp1").geom("geom1").create("sph132", "Sphere");
    model.component("comp1").geom("geom1").feature("sph132")
         .set("pos", new double[]{1.2134580154950796, 0.18292981988068824, 0.9515039269466328});
    model.component("comp1").geom("geom1").feature("sph132").set("r", 0.012508696663357155);
    model.component("comp1").geom("geom1").create("sph133", "Sphere");
    model.component("comp1").geom("geom1").feature("sph133")
         .set("pos", new double[]{1.0610416854904032, 0.6245661700110231, 0.6584908606730379});
    model.component("comp1").geom("geom1").feature("sph133").set("r", 0.020349497377260262);
    model.component("comp1").geom("geom1").create("sph134", "Sphere");
    model.component("comp1").geom("geom1").feature("sph134")
         .set("pos", new double[]{0.27729206016252766, 0.3602198550131792, 0.49246088016092654});
    model.component("comp1").geom("geom1").feature("sph134").set("r", 0.014537646670423867);
    model.component("comp1").geom("geom1").create("sph135", "Sphere");
    model.component("comp1").geom("geom1").feature("sph135")
         .set("pos", new double[]{0.7198582261681841, 0.4599267004626988, 0.1591144286486788});
    model.component("comp1").geom("geom1").feature("sph135").set("r", 0.019601824221802087);
    model.component("comp1").geom("geom1").create("sph136", "Sphere");
    model.component("comp1").geom("geom1").feature("sph136")
         .set("pos", new double[]{1.0055829849432039, 0.3254326723600778, 0.9696409737897865});
    model.component("comp1").geom("geom1").feature("sph136").set("r", 0.00521777467606958);
    model.component("comp1").geom("geom1").create("sph137", "Sphere");
    model.component("comp1").geom("geom1").feature("sph137")
         .set("pos", new double[]{0.5917418257546119, 0.5229687417182828, 0.7449992804367045});
    model.component("comp1").geom("geom1").feature("sph137").set("r", 0.00940468452318312);
    model.component("comp1").geom("geom1").create("sph138", "Sphere");
    model.component("comp1").geom("geom1").feature("sph138")
         .set("pos", new double[]{0.3855354770294222, 0.32160524493956955, 0.5042997445282619});
    model.component("comp1").geom("geom1").feature("sph138").set("r", 0.014277155678005912);
    model.component("comp1").geom("geom1").create("sph139", "Sphere");
    model.component("comp1").geom("geom1").feature("sph139")
         .set("pos", new double[]{1.0101668455459032, 0.15138962221785318, 0.05008700400264114});
    model.component("comp1").geom("geom1").feature("sph139").set("r", 0.018476980160337355);
    model.component("comp1").geom("geom1").create("sph140", "Sphere");
    model.component("comp1").geom("geom1").feature("sph140")
         .set("pos", new double[]{1.0504524371641863, 0.03734560475688033, 0.6637147074151458});
    model.component("comp1").geom("geom1").feature("sph140").set("r", 0.01538164644423979);
    model.component("comp1").geom("geom1").create("sph141", "Sphere");
    model.component("comp1").geom("geom1").feature("sph141")
         .set("pos", new double[]{0.7011485959374211, 0.8909498148445317, 0.636064316989474});
    model.component("comp1").geom("geom1").feature("sph141").set("r", 0.018736164533139837);
    model.component("comp1").geom("geom1").create("sph142", "Sphere");
    model.component("comp1").geom("geom1").feature("sph142")
         .set("pos", new double[]{0.7345874247559312, 0.8484629612359027, 0.8204183333319348});
    model.component("comp1").geom("geom1").feature("sph142").set("r", 0.005104796753029317);
    model.component("comp1").geom("geom1").create("sph143", "Sphere");
    model.component("comp1").geom("geom1").feature("sph143")
         .set("pos", new double[]{0.9174511572234205, 0.5741062591278555, 0.28676142575165253});
    model.component("comp1").geom("geom1").feature("sph143").set("r", 0.01798308394224956);
    model.component("comp1").geom("geom1").create("sph144", "Sphere");
    model.component("comp1").geom("geom1").feature("sph144")
         .set("pos", new double[]{0.9161620991829074, 0.36016544602904454, 0.8371754173831377});
    model.component("comp1").geom("geom1").feature("sph144").set("r", 0.016210599810721177);
    model.component("comp1").geom("geom1").create("sph145", "Sphere");
    model.component("comp1").geom("geom1").feature("sph145")
         .set("pos", new double[]{0.992918129065213, 0.297556077859145, 0.7634492636406534});
    model.component("comp1").geom("geom1").feature("sph145").set("r", 0.008900749720174145);
    model.component("comp1").geom("geom1").create("sph146", "Sphere");
    model.component("comp1").geom("geom1").feature("sph146")
         .set("pos", new double[]{1.0493568611909028, 0.3604347610552801, 0.227181004096981});
    model.component("comp1").geom("geom1").feature("sph146").set("r", 0.013554746586721525);
    model.component("comp1").geom("geom1").create("sph147", "Sphere");
    model.component("comp1").geom("geom1").feature("sph147")
         .set("pos", new double[]{0.5664285709201351, 0.7190891026093437, 0.7296357399621375});
    model.component("comp1").geom("geom1").feature("sph147").set("r", 0.02034569016843533);
    model.component("comp1").geom("geom1").create("sph148", "Sphere");
    model.component("comp1").geom("geom1").feature("sph148")
         .set("pos", new double[]{0.4695028006419461, 0.21064556318644712, 0.1564085980590222});
    model.component("comp1").geom("geom1").feature("sph148").set("r", 0.009427934018164021);
    model.component("comp1").geom("geom1").create("sph149", "Sphere");
    model.component("comp1").geom("geom1").feature("sph149")
         .set("pos", new double[]{0.28850162135001556, 0.12846136430494137, 0.6666941008181563});
    model.component("comp1").geom("geom1").feature("sph149").set("r", 0.012541651984146682);
    model.component("comp1").geom("geom1").create("sph150", "Sphere");
    model.component("comp1").geom("geom1").feature("sph150")
         .set("pos", new double[]{0.3481435375420608, 0.248334369050308, 0.22575025737690835});
    model.component("comp1").geom("geom1").feature("sph150").set("r", 0.020995530737947726);
    model.component("comp1").geom("geom1").create("sph153", "Sphere");
    model.component("comp1").geom("geom1").feature("sph153")
         .set("pos", new double[]{0.38709533363222115, 0.9526596951105738, 0.17654304743584215});
    model.component("comp1").geom("geom1").feature("sph153").set("r", 0.014560626159305666);
    model.component("comp1").geom("geom1").create("sph154", "Sphere");
    model.component("comp1").geom("geom1").feature("sph154")
         .set("pos", new double[]{0.6824276465151031, 0.40785220450117077, 0.16021169237047944});
    model.component("comp1").geom("geom1").feature("sph154").set("r", 0.009052042504393253);
    model.component("comp1").geom("geom1").create("sph155", "Sphere");
    model.component("comp1").geom("geom1").feature("sph155")
         .set("pos", new double[]{0.4509377806672521, 0.6353809423499067, 0.7392579664165533});
    model.component("comp1").geom("geom1").feature("sph155").set("r", 0.019586378387222467);
    model.component("comp1").geom("geom1").create("sph156", "Sphere");
    model.component("comp1").geom("geom1").feature("sph156")
         .set("pos", new double[]{0.8490937324187757, 0.7393622331095425, 0.6329070629209356});
    model.component("comp1").geom("geom1").feature("sph156").set("r", 0.009214647841666415);
    model.component("comp1").geom("geom1").create("sph157", "Sphere");
    model.component("comp1").geom("geom1").feature("sph157")
         .set("pos", new double[]{0.552412387245796, 0.7191263352035662, 0.9213129536896892});
    model.component("comp1").geom("geom1").feature("sph157").set("r", 0.016942546058932983);
    model.component("comp1").geom("geom1").create("sph158", "Sphere");
    model.component("comp1").geom("geom1").feature("sph158")
         .set("pos", new double[]{1.024556571211999, 0.07701237792171865, 0.8195063084444331});
    model.component("comp1").geom("geom1").feature("sph158").set("r", 0.013511227805230938);
    model.component("comp1").geom("geom1").create("sph159", "Sphere");
    model.component("comp1").geom("geom1").feature("sph159")
         .set("pos", new double[]{0.6469526053498974, 0.3076159914389524, 0.09592953775354161});
    model.component("comp1").geom("geom1").feature("sph159").set("r", 0.008845000336442954);
    model.component("comp1").geom("geom1").create("sph160", "Sphere");
    model.component("comp1").geom("geom1").feature("sph160")
         .set("pos", new double[]{0.6261511380416666, 0.5286657211396054, 0.494505682250764});
    model.component("comp1").geom("geom1").feature("sph160").set("r", 0.02309262005872486);
    model.component("comp1").geom("geom1").create("sph161", "Sphere");
    model.component("comp1").geom("geom1").feature("sph161")
         .set("pos", new double[]{0.4609413329721342, 0.09114359960001094, 0.5076421713104928});
    model.component("comp1").geom("geom1").feature("sph161").set("r", 0.0076432228388587636);
    model.component("comp1").geom("geom1").create("sph162", "Sphere");
    model.component("comp1").geom("geom1").feature("sph162")
         .set("pos", new double[]{0.6099864116794212, 0.1239237823414016, 0.7759169222713374});
    model.component("comp1").geom("geom1").feature("sph162").set("r", 0.010230991036659743);
    model.component("comp1").geom("geom1").create("sph163", "Sphere");
    model.component("comp1").geom("geom1").feature("sph163")
         .set("pos", new double[]{1.2287809862991808, 0.18822270609215025, 0.5699242703583053});
    model.component("comp1").geom("geom1").feature("sph163").set("r", 0.007131677535776022);
    model.component("comp1").geom("geom1").create("sph164", "Sphere");
    model.component("comp1").geom("geom1").feature("sph164")
         .set("pos", new double[]{1.0337300937162521, 0.19947455838872968, 0.5270168045259597});
    model.component("comp1").geom("geom1").feature("sph164").set("r", 0.0058969066917817625);
    model.component("comp1").geom("geom1").create("sph165", "Sphere");
    model.component("comp1").geom("geom1").feature("sph165")
         .set("pos", new double[]{0.4137952839312746, 0.5480422201469933, 0.23350770168825988});
    model.component("comp1").geom("geom1").feature("sph165").set("r", 0.019801550863181434);
    model.component("comp1").geom("geom1").create("sph166", "Sphere");
    model.component("comp1").geom("geom1").feature("sph166")
         .set("pos", new double[]{0.9639165882494258, 0.19607507106175667, 0.8401154177144304});
    model.component("comp1").geom("geom1").feature("sph166").set("r", 0.020183920986342894);
    model.component("comp1").geom("geom1").create("sph167", "Sphere");
    model.component("comp1").geom("geom1").feature("sph167")
         .set("pos", new double[]{1.1063496785499436, 0.5570901036770062, 0.40620041093448384});
    model.component("comp1").geom("geom1").feature("sph167").set("r", 0.005395501990326885);
    model.component("comp1").geom("geom1").create("sph168", "Sphere");
    model.component("comp1").geom("geom1").feature("sph168")
         .set("pos", new double[]{0.9581759431041892, 0.9579160999824639, 0.2914775886871081});
    model.component("comp1").geom("geom1").feature("sph168").set("r", 0.020174938620446732);
    model.component("comp1").geom("geom1").create("sph169", "Sphere");
    model.component("comp1").geom("geom1").feature("sph169")
         .set("pos", new double[]{1.1794977388575987, 0.8471058816269222, 0.7219506237832823});
    model.component("comp1").geom("geom1").feature("sph169").set("r", 0.005075873448186852);
    model.component("comp1").geom("geom1").create("sph170", "Sphere");
    model.component("comp1").geom("geom1").feature("sph170")
         .set("pos", new double[]{0.9506094039772497, 0.766315811157794, 0.38121567308867943});
    model.component("comp1").geom("geom1").feature("sph170").set("r", 0.015333775658430769);
    model.component("comp1").geom("geom1").create("sph171", "Sphere");
    model.component("comp1").geom("geom1").feature("sph171")
         .set("pos", new double[]{0.9903956136451787, 0.6063265093430344, 0.40783374181960297});
    model.component("comp1").geom("geom1").feature("sph171").set("r", 0.02040645050659915);
    model.component("comp1").geom("geom1").create("sph172", "Sphere");
    model.component("comp1").geom("geom1").feature("sph172")
         .set("pos", new double[]{0.27194106480325353, 0.7589822418736623, 0.8734671253486341});
    model.component("comp1").geom("geom1").feature("sph172").set("r", 0.01894616038528682);
    model.component("comp1").geom("geom1").create("sph173", "Sphere");
    model.component("comp1").geom("geom1").feature("sph173")
         .set("pos", new double[]{0.3781897672489596, 0.23135308557362544, 0.3099282837816155});
    model.component("comp1").geom("geom1").feature("sph173").set("r", 0.009786314148750093);
    model.component("comp1").geom("geom1").create("sph174", "Sphere");
    model.component("comp1").geom("geom1").feature("sph174")
         .set("pos", new double[]{0.7912100783951868, 0.30064388787592067, 0.1619777738552077});
    model.component("comp1").geom("geom1").feature("sph174").set("r", 0.022660570171276685);
    model.component("comp1").geom("geom1").create("sph175", "Sphere");
    model.component("comp1").geom("geom1").feature("sph175")
         .set("pos", new double[]{0.8614108161959959, 0.33145538327347046, 0.4591342445278741});
    model.component("comp1").geom("geom1").feature("sph175").set("r", 0.010802889262090835);
    model.component("comp1").geom("geom1").create("sph176", "Sphere");
    model.component("comp1").geom("geom1").feature("sph176")
         .set("pos", new double[]{1.0690247860394795, 0.42986611139582526, 0.35306896826618883});
    model.component("comp1").geom("geom1").feature("sph176").set("r", 0.01388234214033229);
    model.component("comp1").geom("geom1").create("sph177", "Sphere");
    model.component("comp1").geom("geom1").feature("sph177")
         .set("pos", new double[]{0.4817869033285804, 0.46911277476029695, 0.32532383275600074});
    model.component("comp1").geom("geom1").feature("sph177").set("r", 0.018499432096182104);
    model.component("comp1").geom("geom1").create("sph178", "Sphere");
    model.component("comp1").geom("geom1").feature("sph178")
         .set("pos", new double[]{1.1141248488439734, 0.45056998787379776, 0.7687911471663056});
    model.component("comp1").geom("geom1").feature("sph178").set("r", 0.017537112043256694);
    model.component("comp1").geom("geom1").create("sph179", "Sphere");
    model.component("comp1").geom("geom1").feature("sph179")
         .set("pos", new double[]{0.9018113805593048, 0.14961518764726167, 0.43621706786338305});
    model.component("comp1").geom("geom1").feature("sph179").set("r", 0.01413931401123101);
    model.component("comp1").geom("geom1").create("sph180", "Sphere");
    model.component("comp1").geom("geom1").feature("sph180")
         .set("pos", new double[]{0.8505876782130743, 0.7490680964022622, 0.5043886170811949});
    model.component("comp1").geom("geom1").feature("sph180").set("r", 0.023186239773098735);
    model.component("comp1").geom("geom1").create("sph181", "Sphere");
    model.component("comp1").geom("geom1").feature("sph181")
         .set("pos", new double[]{1.0826395140244944, 0.08938297380525108, 0.5696143567236244});
    model.component("comp1").geom("geom1").feature("sph181").set("r", 0.01496111249656015);
    model.component("comp1").geom("geom1").create("sph182", "Sphere");
    model.component("comp1").geom("geom1").feature("sph182")
         .set("pos", new double[]{0.7670079362901069, 0.2151536832537405, 0.8243802411615884});
    model.component("comp1").geom("geom1").feature("sph182").set("r", 0.023855251508658987);
    model.component("comp1").geom("geom1").create("sph183", "Sphere");
    model.component("comp1").geom("geom1").feature("sph183")
         .set("pos", new double[]{0.9466983550109543, 0.5386478630445163, 0.9308534084861723});
    model.component("comp1").geom("geom1").feature("sph183").set("r", 0.010032782847117058);
    model.component("comp1").geom("geom1").create("sph184", "Sphere");
    model.component("comp1").geom("geom1").feature("sph184")
         .set("pos", new double[]{1.0761577005748657, 0.03498351252618663, 0.9624393362008141});
    model.component("comp1").geom("geom1").feature("sph184").set("r", 0.01748673404805352);
    model.component("comp1").geom("geom1").create("sph185", "Sphere");
    model.component("comp1").geom("geom1").feature("sph185")
         .set("pos", new double[]{0.5744611436155916, 0.9313809219244349, 0.025197432766757902});
    model.component("comp1").geom("geom1").feature("sph185").set("r", 0.00655429140664773);
    model.component("comp1").geom("geom1").create("sph186", "Sphere");
    model.component("comp1").geom("geom1").feature("sph186")
         .set("pos", new double[]{1.0957123358554473, 0.44361600956441194, 0.27111106831272846});
    model.component("comp1").geom("geom1").feature("sph186").set("r", 0.02145460010843871);
    model.component("comp1").geom("geom1").create("sph187", "Sphere");
    model.component("comp1").geom("geom1").feature("sph187")
         .set("pos", new double[]{0.7287941818690167, 0.15704895305868938, 0.9012763269392084});
    model.component("comp1").geom("geom1").feature("sph187").set("r", 0.021053790392665972);
    model.component("comp1").geom("geom1").create("sph188", "Sphere");
    model.component("comp1").geom("geom1").feature("sph188")
         .set("pos", new double[]{0.7419327101831809, 0.833217632660809, 0.423938750733966});
    model.component("comp1").geom("geom1").feature("sph188").set("r", 0.02291939934013297);
    model.component("comp1").geom("geom1").create("sph189", "Sphere");
    model.component("comp1").geom("geom1").feature("sph189")
         .set("pos", new double[]{0.651799525711967, 0.5054127782319352, 0.20735237232608583});
    model.component("comp1").geom("geom1").feature("sph189").set("r", 0.018669298003326024);
    model.component("comp1").geom("geom1").create("sph190", "Sphere");
    model.component("comp1").geom("geom1").feature("sph190")
         .set("pos", new double[]{0.5542167146258155, 0.13066205488529722, 0.16871520619240835});
    model.component("comp1").geom("geom1").feature("sph190").set("r", 0.02429977848221828);
    model.component("comp1").geom("geom1").create("sph191", "Sphere");
    model.component("comp1").geom("geom1").feature("sph191")
         .set("pos", new double[]{0.9636645156547139, 0.5625270134614978, 0.7855749492577048});
    model.component("comp1").geom("geom1").feature("sph191").set("r", 0.005281845883848859);
    model.component("comp1").geom("geom1").create("sph192", "Sphere");
    model.component("comp1").geom("geom1").feature("sph192")
         .set("pos", new double[]{1.0329837654961338, 0.6859205637334945, 0.7638773671801855});
    model.component("comp1").geom("geom1").feature("sph192").set("r", 0.015141598465682728);
    model.component("comp1").geom("geom1").create("sph193", "Sphere");
    model.component("comp1").geom("geom1").feature("sph193")
         .set("pos", new double[]{0.8938902776184621, 0.19460679406364845, 0.33006244978532795});
    model.component("comp1").geom("geom1").feature("sph193").set("r", 0.013129657379541727);
    model.component("comp1").geom("geom1").create("sph194", "Sphere");
    model.component("comp1").geom("geom1").feature("sph194")
         .set("pos", new double[]{0.6601816382459168, 0.25096147827773074, 0.4103569620592696});
    model.component("comp1").geom("geom1").feature("sph194").set("r", 0.00845209240239585);
    model.component("comp1").geom("geom1").create("sph195", "Sphere");
    model.component("comp1").geom("geom1").feature("sph195")
         .set("pos", new double[]{0.5791252768823131, 0.94919477864312, 0.6268997909064709});
    model.component("comp1").geom("geom1").feature("sph195").set("r", 0.024504446848746243);
    model.component("comp1").geom("geom1").create("sph196", "Sphere");
    model.component("comp1").geom("geom1").feature("sph196")
         .set("pos", new double[]{1.0985460850999085, 0.6142049007132699, 0.26319249430698316});
    model.component("comp1").geom("geom1").feature("sph196").set("r", 0.012501820367878221);
    model.component("comp1").geom("geom1").create("sph197", "Sphere");
    model.component("comp1").geom("geom1").feature("sph197")
         .set("pos", new double[]{0.6857359270117701, 0.3663047555117425, 0.34075126421171736});
    model.component("comp1").geom("geom1").feature("sph197").set("r", 0.020857113559537753);
    model.component("comp1").geom("geom1").create("sph198", "Sphere");
    model.component("comp1").geom("geom1").feature("sph198")
         .set("pos", new double[]{0.5274170707857545, 0.7904303336224598, 0.30714049949884387});
    model.component("comp1").geom("geom1").feature("sph198").set("r", 0.01894737751226279);
    model.component("comp1").geom("geom1").create("sph199", "Sphere");
    model.component("comp1").geom("geom1").feature("sph199")
         .set("pos", new double[]{0.7383051638707743, 0.8369614393020157, 0.8682816668015642});
    model.component("comp1").geom("geom1").feature("sph199").set("r", 0.015882427671707146);
    model.component("comp1").geom("geom1").create("sph200", "Sphere");
    model.component("comp1").geom("geom1").feature("sph200")
         .set("pos", new double[]{0.8338654972285375, 0.883321982022307, 0.44813110832425923});
    model.component("comp1").geom("geom1").feature("sph200").set("r", 0.008687688847355334);
    model.component("comp1").geom("geom1").create("sph201", "Sphere");
    model.component("comp1").geom("geom1").feature("sph201")
         .set("pos", new double[]{0.5393506332848379, 0.601553118562468, 0.6702521667837321});
    model.component("comp1").geom("geom1").feature("sph201").set("r", 0.023437366109676307);
    model.component("comp1").geom("geom1").create("sph202", "Sphere");
    model.component("comp1").geom("geom1").feature("sph202")
         .set("pos", new double[]{0.27306827908716347, 0.4199824062690839, 0.9213248718333491});
    model.component("comp1").geom("geom1").feature("sph202").set("r", 0.009564114667009682);
    model.component("comp1").geom("geom1").create("sph203", "Sphere");
    model.component("comp1").geom("geom1").feature("sph203")
         .set("pos", new double[]{1.0231084462511644, 0.18895720695487653, 0.34886283600646795});
    model.component("comp1").geom("geom1").feature("sph203").set("r", 0.01186056219660813);
    model.component("comp1").geom("geom1").create("sph204", "Sphere");
    model.component("comp1").geom("geom1").feature("sph204")
         .set("pos", new double[]{0.9633493233781208, 0.6921756178606211, 0.6817521471080709});
    model.component("comp1").geom("geom1").feature("sph204").set("r", 0.007891954416761935);
    model.component("comp1").geom("geom1").create("sph205", "Sphere");
    model.component("comp1").geom("geom1").feature("sph205")
         .set("pos", new double[]{0.9384867887266678, 0.23824268355753347, 0.42767338706212094});
    model.component("comp1").geom("geom1").feature("sph205").set("r", 0.010067920689725993);
    model.component("comp1").geom("geom1").create("sph206", "Sphere");
    model.component("comp1").geom("geom1").feature("sph206")
         .set("pos", new double[]{0.608907400043872, 0.07750588152803205, 0.6257387363489865});

    return model;
  }

  public static Model run3(Model model) {
    model.component("comp1").geom("geom1").feature("sph206").set("r", 0.012438442433353746);
    model.component("comp1").geom("geom1").create("sph207", "Sphere");
    model.component("comp1").geom("geom1").feature("sph207")
         .set("pos", new double[]{0.8592390807778555, 0.6396672104852844, 0.18918074929887593});
    model.component("comp1").geom("geom1").feature("sph207").set("r", 0.01914633205363399);
    model.component("comp1").geom("geom1").create("sph208", "Sphere");
    model.component("comp1").geom("geom1").feature("sph208")
         .set("pos", new double[]{0.7639485564954335, 0.8618290535842756, 0.19532412415986186});
    model.component("comp1").geom("geom1").feature("sph208").set("r", 0.00798893597877725);
    model.component("comp1").geom("geom1").create("sph210", "Sphere");
    model.component("comp1").geom("geom1").feature("sph210")
         .set("pos", new double[]{0.5175232731459071, 0.8294719338394858, 0.7872084397312246});
    model.component("comp1").geom("geom1").feature("sph210").set("r", 0.01184881282269621);
    model.component("comp1").geom("geom1").create("sph211", "Sphere");
    model.component("comp1").geom("geom1").feature("sph211")
         .set("pos", new double[]{0.85411902673664, 0.16215197210275856, 0.5091608390809054});
    model.component("comp1").geom("geom1").feature("sph211").set("r", 0.013532783165362872);
    model.component("comp1").geom("geom1").create("sph212", "Sphere");
    model.component("comp1").geom("geom1").feature("sph212")
         .set("pos", new double[]{1.1017825519309947, 0.664412203913762, 0.6278844034806877});
    model.component("comp1").geom("geom1").feature("sph212").set("r", 0.010938941715738091);
    model.component("comp1").geom("geom1").create("sph213", "Sphere");
    model.component("comp1").geom("geom1").feature("sph213")
         .set("pos", new double[]{0.7210287687147091, 0.9695475727260056, 0.932613162659065});
    model.component("comp1").geom("geom1").feature("sph213").set("r", 0.007495026001383584);
    model.component("comp1").geom("geom1").create("sph215", "Sphere");
    model.component("comp1").geom("geom1").feature("sph215")
         .set("pos", new double[]{0.6801061499596625, 0.5944306892606932, 0.8329100346221845});
    model.component("comp1").geom("geom1").feature("sph215").set("r", 0.014373316753225042);
    model.component("comp1").geom("geom1").create("sph216", "Sphere");
    model.component("comp1").geom("geom1").feature("sph216")
         .set("pos", new double[]{0.8261825600305592, 0.8992028862225211, 0.09087510219709});
    model.component("comp1").geom("geom1").feature("sph216").set("r", 0.020022420807438747);
    model.component("comp1").geom("geom1").create("sph217", "Sphere");
    model.component("comp1").geom("geom1").feature("sph217")
         .set("pos", new double[]{0.3251900892217158, 0.22042684140216037, 0.42813323696272365});
    model.component("comp1").geom("geom1").feature("sph217").set("r", 0.024826930174636185);
    model.component("comp1").geom("geom1").create("sph218", "Sphere");
    model.component("comp1").geom("geom1").feature("sph218")
         .set("pos", new double[]{0.871901880211576, 0.06349657958605912, 0.29201135835713654});
    model.component("comp1").geom("geom1").feature("sph218").set("r", 0.007150177523703354);
    model.component("comp1").geom("geom1").create("sph219", "Sphere");
    model.component("comp1").geom("geom1").feature("sph219")
         .set("pos", new double[]{0.9509872520134562, 0.6629912023464455, 0.3825196169575443});
    model.component("comp1").geom("geom1").feature("sph219").set("r", 0.006220733622393422);
    model.component("comp1").geom("geom1").create("sph220", "Sphere");
    model.component("comp1").geom("geom1").feature("sph220")
         .set("pos", new double[]{0.9926753850987224, 0.34636950009289635, 0.7842191729960397});
    model.component("comp1").geom("geom1").feature("sph220").set("r", 0.008763885200596424);
    model.component("comp1").geom("geom1").create("sph221", "Sphere");
    model.component("comp1").geom("geom1").feature("sph221")
         .set("pos", new double[]{0.7749117840671871, 0.051838114301414176, 0.6370902217643107});
    model.component("comp1").geom("geom1").feature("sph221").set("r", 0.014758018783592407);
    model.component("comp1").geom("geom1").create("sph222", "Sphere");
    model.component("comp1").geom("geom1").feature("sph222")
         .set("pos", new double[]{0.4857112177393842, 0.4367942438873587, 0.38764197556700364});
    model.component("comp1").geom("geom1").feature("sph222").set("r", 0.012013130048643348);
    model.component("comp1").geom("geom1").create("sph223", "Sphere");
    model.component("comp1").geom("geom1").feature("sph223")
         .set("pos", new double[]{1.2156782796501076, 0.37099527610263827, 0.761021234410762});
    model.component("comp1").geom("geom1").feature("sph223").set("r", 0.014395780801727206);
    model.component("comp1").geom("geom1").create("sph224", "Sphere");
    model.component("comp1").geom("geom1").feature("sph224")
         .set("pos", new double[]{1.1266358159416567, 0.36251136016934343, 0.2587798808817182});
    model.component("comp1").geom("geom1").feature("sph224").set("r", 0.01605535193099785);
    model.component("comp1").geom("geom1").create("sph225", "Sphere");
    model.component("comp1").geom("geom1").feature("sph225")
         .set("pos", new double[]{0.3147328838386221, 0.9208050234069759, 0.5526591967837606});
    model.component("comp1").geom("geom1").feature("sph225").set("r", 0.023220384793139367);
    model.component("comp1").geom("geom1").create("sph226", "Sphere");
    model.component("comp1").geom("geom1").feature("sph226")
         .set("pos", new double[]{1.2326490197371616, 0.07826040896740473, 0.515953662602533});
    model.component("comp1").geom("geom1").feature("sph226").set("r", 0.01252726433374175);
    model.component("comp1").geom("geom1").create("sph227", "Sphere");
    model.component("comp1").geom("geom1").feature("sph227")
         .set("pos", new double[]{0.820375447501088, 0.19045191352071023, 0.6268675264039624});
    model.component("comp1").geom("geom1").feature("sph227").set("r", 0.0056219415091109575);
    model.component("comp1").geom("geom1").create("sph228", "Sphere");
    model.component("comp1").geom("geom1").feature("sph228")
         .set("pos", new double[]{1.1064434941569166, 0.4551709604684851, 0.694027675834114});
    model.component("comp1").geom("geom1").feature("sph228").set("r", 0.024618473515011632);
    model.component("comp1").geom("geom1").create("sph229", "Sphere");
    model.component("comp1").geom("geom1").feature("sph229")
         .set("pos", new double[]{0.7450550269765162, 0.526790129594575, 0.17212103511219415});
    model.component("comp1").geom("geom1").feature("sph229").set("r", 0.020549375000063787);
    model.component("comp1").geom("geom1").create("sph230", "Sphere");
    model.component("comp1").geom("geom1").feature("sph230")
         .set("pos", new double[]{0.40108557824207614, 0.7167343593199342, 0.47804226049650905});
    model.component("comp1").geom("geom1").feature("sph230").set("r", 0.012387998512238126);
    model.component("comp1").geom("geom1").create("sph231", "Sphere");
    model.component("comp1").geom("geom1").feature("sph231")
         .set("pos", new double[]{1.1252073386429826, 0.5262943098467553, 0.4134503950239597});
    model.component("comp1").geom("geom1").feature("sph231").set("r", 0.01397757673413531);
    model.component("comp1").geom("geom1").create("sph232", "Sphere");
    model.component("comp1").geom("geom1").feature("sph232")
         .set("pos", new double[]{0.33089521679190725, 0.4214725513355061, 0.04508172214010583});
    model.component("comp1").geom("geom1").feature("sph232").set("r", 0.010377840444252918);
    model.component("comp1").geom("geom1").create("sph233", "Sphere");
    model.component("comp1").geom("geom1").feature("sph233")
         .set("pos", new double[]{0.7534335424450418, 0.9465287431525642, 0.1256506149189628});
    model.component("comp1").geom("geom1").feature("sph233").set("r", 0.010823078811048562);
    model.component("comp1").geom("geom1").create("sph234", "Sphere");
    model.component("comp1").geom("geom1").feature("sph234")
         .set("pos", new double[]{0.7499348680692756, 0.7613253430233762, 0.16389347281262975});
    model.component("comp1").geom("geom1").feature("sph234").set("r", 0.01846082108433244);
    model.component("comp1").geom("geom1").create("sph235", "Sphere");
    model.component("comp1").geom("geom1").feature("sph235")
         .set("pos", new double[]{0.6505618304084636, 0.7870650627290366, 0.201951602398587});
    model.component("comp1").geom("geom1").feature("sph235").set("r", 0.006664052728717511);
    model.component("comp1").geom("geom1").create("sph236", "Sphere");
    model.component("comp1").geom("geom1").feature("sph236")
         .set("pos", new double[]{0.5488351936913894, 0.23407931333201776, 0.04605631132577646});
    model.component("comp1").geom("geom1").feature("sph236").set("r", 0.02035554384294548);
    model.component("comp1").geom("geom1").create("sph237", "Sphere");
    model.component("comp1").geom("geom1").feature("sph237")
         .set("pos", new double[]{0.6341669940160508, 0.6520236160108224, 0.09063313914021424});
    model.component("comp1").geom("geom1").feature("sph237").set("r", 0.012973181198447575);
    model.component("comp1").geom("geom1").create("sph239", "Sphere");
    model.component("comp1").geom("geom1").feature("sph239")
         .set("pos", new double[]{0.575698650264024, 0.5552418879642446, 0.970708839737072});
    model.component("comp1").geom("geom1").feature("sph239").set("r", 0.013053137043498385);
    model.component("comp1").geom("geom1").create("sph240", "Sphere");
    model.component("comp1").geom("geom1").feature("sph240")
         .set("pos", new double[]{0.9409636364316755, 0.8917495853779798, 0.06890045296509636});
    model.component("comp1").geom("geom1").feature("sph240").set("r", 0.021689730280360593);
    model.component("comp1").geom("geom1").create("sph241", "Sphere");
    model.component("comp1").geom("geom1").feature("sph241")
         .set("pos", new double[]{0.724339356171594, 0.3541167335665451, 0.9229043625692763});
    model.component("comp1").geom("geom1").feature("sph241").set("r", 0.006406668832310505);
    model.component("comp1").geom("geom1").create("sph243", "Sphere");
    model.component("comp1").geom("geom1").feature("sph243")
         .set("pos", new double[]{0.514690623075709, 0.28853047975226825, 0.33953186692175213});
    model.component("comp1").geom("geom1").feature("sph243").set("r", 0.02254068778540704);
    model.component("comp1").geom("geom1").create("sph244", "Sphere");
    model.component("comp1").geom("geom1").feature("sph244")
         .set("pos", new double[]{0.4790572888241096, 0.6625315563887442, 0.16133322973942524});
    model.component("comp1").geom("geom1").feature("sph244").set("r", 0.01595128540961907);
    model.component("comp1").geom("geom1").create("sph245", "Sphere");
    model.component("comp1").geom("geom1").feature("sph245")
         .set("pos", new double[]{1.1150964229459068, 0.24575307153927786, 0.38985297284610293});
    model.component("comp1").geom("geom1").feature("sph245").set("r", 0.006882005489992789);
    model.component("comp1").geom("geom1").create("sph246", "Sphere");
    model.component("comp1").geom("geom1").feature("sph246")
         .set("pos", new double[]{0.7749540737758552, 0.0984359710272127, 0.8543490087231066});
    model.component("comp1").geom("geom1").feature("sph246").set("r", 0.016430841854506648);
    model.component("comp1").geom("geom1").create("sph247", "Sphere");
    model.component("comp1").geom("geom1").feature("sph247")
         .set("pos", new double[]{1.0474927580122637, 0.2985131309152197, 0.5259519490485552});
    model.component("comp1").geom("geom1").feature("sph247").set("r", 0.024022712368373843);
    model.component("comp1").geom("geom1").create("sph248", "Sphere");
    model.component("comp1").geom("geom1").feature("sph248")
         .set("pos", new double[]{0.803378437698254, 0.9537305459943708, 0.31990827733980787});
    model.component("comp1").geom("geom1").feature("sph248").set("r", 0.01178833448035219);
    model.component("comp1").geom("geom1").create("sph249", "Sphere");
    model.component("comp1").geom("geom1").feature("sph249")
         .set("pos", new double[]{0.582363236878737, 0.7589001694780722, 0.3356955757393959});
    model.component("comp1").geom("geom1").feature("sph249").set("r", 0.018375932118457394);
    model.component("comp1").geom("geom1").create("sph250", "Sphere");
    model.component("comp1").geom("geom1").feature("sph250")
         .set("pos", new double[]{0.9902315872249794, 0.7454052438110104, 0.47148099349812445});
    model.component("comp1").geom("geom1").feature("sph250").set("r", 0.022796546828947502);
    model.component("comp1").geom("geom1").create("sph251", "Sphere");
    model.component("comp1").geom("geom1").feature("sph251")
         .set("pos", new double[]{0.2999259598496364, 0.3286760225442781, 0.054901693317854106});
    model.component("comp1").geom("geom1").feature("sph251").set("r", 0.009215290049374106);
    model.component("comp1").geom("geom1").create("sph252", "Sphere");
    model.component("comp1").geom("geom1").feature("sph252")
         .set("pos", new double[]{0.9139185999573416, 0.4344873304540489, 0.7523230350782515});
    model.component("comp1").geom("geom1").feature("sph252").set("r", 0.018877108227477995);
    model.component("comp1").geom("geom1").create("sph253", "Sphere");
    model.component("comp1").geom("geom1").feature("sph253")
         .set("pos", new double[]{0.3043268868928374, 0.15357948406627572, 0.20918716362350476});
    model.component("comp1").geom("geom1").feature("sph253").set("r", 0.015720169894791275);
    model.component("comp1").geom("geom1").create("sph254", "Sphere");
    model.component("comp1").geom("geom1").feature("sph254")
         .set("pos", new double[]{0.3128007104983419, 0.6005519211609975, 0.511537258684416});
    model.component("comp1").geom("geom1").feature("sph254").set("r", 0.011713276023292996);
    model.component("comp1").geom("geom1").create("sph255", "Sphere");
    model.component("comp1").geom("geom1").feature("sph255")
         .set("pos", new double[]{0.6847027501332649, 0.8286817948704455, 0.45657195404692635});
    model.component("comp1").geom("geom1").feature("sph255").set("r", 0.017349220240343122);
    model.component("comp1").geom("geom1").create("sph256", "Sphere");
    model.component("comp1").geom("geom1").feature("sph256")
         .set("pos", new double[]{1.1191076044582948, 0.6514192591664878, 0.8131139340798377});
    model.component("comp1").geom("geom1").feature("sph256").set("r", 0.005308070395838418);
    model.component("comp1").geom("geom1").create("sph257", "Sphere");
    model.component("comp1").geom("geom1").feature("sph257")
         .set("pos", new double[]{0.32250048677816373, 0.2531057945746418, 0.0930671040215343});
    model.component("comp1").geom("geom1").feature("sph257").set("r", 0.024035513860677035);
    model.component("comp1").geom("geom1").create("sph258", "Sphere");
    model.component("comp1").geom("geom1").feature("sph258")
         .set("pos", new double[]{1.104054396911672, 0.10123172511421767, 0.4743720965835294});
    model.component("comp1").geom("geom1").feature("sph258").set("r", 0.013433157720649017);
    model.component("comp1").geom("geom1").create("sph259", "Sphere");
    model.component("comp1").geom("geom1").feature("sph259")
         .set("pos", new double[]{1.0187863898607232, 0.8294649641190981, 0.059285677076491204});
    model.component("comp1").geom("geom1").feature("sph259").set("r", 0.007510862196174473);
    model.component("comp1").geom("geom1").create("sph260", "Sphere");
    model.component("comp1").geom("geom1").feature("sph260")
         .set("pos", new double[]{0.49708737711044343, 0.930095500937182, 0.921938750560402});
    model.component("comp1").geom("geom1").feature("sph260").set("r", 0.014728814863407897);
    model.component("comp1").geom("geom1").create("sph261", "Sphere");
    model.component("comp1").geom("geom1").feature("sph261")
         .set("pos", new double[]{1.2071249228352015, 0.35332529925183814, 0.8761450327996776});
    model.component("comp1").geom("geom1").feature("sph261").set("r", 0.017278680047694017);
    model.component("comp1").geom("geom1").create("sph262", "Sphere");
    model.component("comp1").geom("geom1").feature("sph262")
         .set("pos", new double[]{0.4930490360057903, 0.9199398596275479, 0.6754890998949937});
    model.component("comp1").geom("geom1").feature("sph262").set("r", 0.01369189946817019);
    model.component("comp1").geom("geom1").create("sph263", "Sphere");
    model.component("comp1").geom("geom1").feature("sph263")
         .set("pos", new double[]{1.1157588136666192, 0.6948160092271174, 0.6015066279982757});
    model.component("comp1").geom("geom1").feature("sph263").set("r", 0.006298231706782587);
    model.component("comp1").geom("geom1").create("sph264", "Sphere");
    model.component("comp1").geom("geom1").feature("sph264")
         .set("pos", new double[]{0.5131276543304142, 0.5945304630767948, 0.7959638381775501});
    model.component("comp1").geom("geom1").feature("sph264").set("r", 0.01964749798358661);
    model.component("comp1").geom("geom1").create("sph265", "Sphere");
    model.component("comp1").geom("geom1").feature("sph265")
         .set("pos", new double[]{0.3850053414268529, 0.831431195808147, 0.6145393281211067});
    model.component("comp1").geom("geom1").feature("sph265").set("r", 0.006082273206479998);
    model.component("comp1").geom("geom1").create("sph266", "Sphere");
    model.component("comp1").geom("geom1").feature("sph266")
         .set("pos", new double[]{0.5061570244058842, 0.3055811081950652, 0.8535854353096124});
    model.component("comp1").geom("geom1").feature("sph266").set("r", 0.015625756209621162);
    model.component("comp1").geom("geom1").create("sph267", "Sphere");
    model.component("comp1").geom("geom1").feature("sph267")
         .set("pos", new double[]{0.32613254996274166, 0.8783797142041434, 0.21728237577619308});
    model.component("comp1").geom("geom1").feature("sph267").set("r", 0.013433318696994184);
    model.component("comp1").geom("geom1").create("sph268", "Sphere");
    model.component("comp1").geom("geom1").feature("sph268")
         .set("pos", new double[]{1.115335740810655, 0.48758609845202217, 0.5922565826828229});
    model.component("comp1").geom("geom1").feature("sph268").set("r", 0.02152455070984783);
    model.component("comp1").geom("geom1").create("sph269", "Sphere");
    model.component("comp1").geom("geom1").feature("sph269")
         .set("pos", new double[]{0.8709405129916278, 0.8369023918924899, 0.293270096109038});
    model.component("comp1").geom("geom1").feature("sph269").set("r", 0.015545349129708338);
    model.component("comp1").geom("geom1").create("sph270", "Sphere");
    model.component("comp1").geom("geom1").feature("sph270")
         .set("pos", new double[]{0.8146205587342233, 0.14025614204299477, 0.2448416992169555});
    model.component("comp1").geom("geom1").feature("sph270").set("r", 0.022675110163612018);
    model.component("comp1").geom("geom1").create("sph271", "Sphere");
    model.component("comp1").geom("geom1").feature("sph271")
         .set("pos", new double[]{0.49826319266803343, 0.15125998167863597, 0.1800535949415989});
    model.component("comp1").geom("geom1").feature("sph271").set("r", 0.016919647712260275);
    model.component("comp1").geom("geom1").create("sph272", "Sphere");
    model.component("comp1").geom("geom1").feature("sph272")
         .set("pos", new double[]{0.8477085309143091, 0.9339938708797308, 0.355524092564293});
    model.component("comp1").geom("geom1").feature("sph272").set("r", 0.02189745036471478);
    model.component("comp1").geom("geom1").create("sph273", "Sphere");
    model.component("comp1").geom("geom1").feature("sph273")
         .set("pos", new double[]{0.8456371111853371, 0.6094765034910108, 0.0829044957393558});
    model.component("comp1").geom("geom1").feature("sph273").set("r", 0.016912501962698993);
    model.component("comp1").geom("geom1").create("sph274", "Sphere");
    model.component("comp1").geom("geom1").feature("sph274")
         .set("pos", new double[]{1.180275431654558, 0.5325978737623333, 0.2110065603572736});
    model.component("comp1").geom("geom1").feature("sph274").set("r", 0.02000634369149372);
    model.component("comp1").geom("geom1").create("sph275", "Sphere");
    model.component("comp1").geom("geom1").feature("sph275")
         .set("pos", new double[]{0.2770838722670683, 0.3385808377532957, 0.8925010915589979});
    model.component("comp1").geom("geom1").feature("sph275").set("r", 0.020058518299598843);
    model.component("comp1").geom("geom1").create("sph276", "Sphere");
    model.component("comp1").geom("geom1").feature("sph276")
         .set("pos", new double[]{1.0932790866646742, 0.5990684661279433, 0.8053090300581427});
    model.component("comp1").geom("geom1").feature("sph276").set("r", 0.016767346657877536);
    model.component("comp1").geom("geom1").create("sph277", "Sphere");
    model.component("comp1").geom("geom1").feature("sph277")
         .set("pos", new double[]{0.5790740921422123, 0.1475303310459132, 0.7068789380652978});
    model.component("comp1").geom("geom1").feature("sph277").set("r", 0.02258967046858634);
    model.component("comp1").geom("geom1").create("sph278", "Sphere");
    model.component("comp1").geom("geom1").feature("sph278")
         .set("pos", new double[]{0.3870429857744863, 0.5855467953956427, 0.058157903779478874});
    model.component("comp1").geom("geom1").feature("sph278").set("r", 0.013806941736624764);
    model.component("comp1").geom("geom1").create("sph280", "Sphere");
    model.component("comp1").geom("geom1").feature("sph280")
         .set("pos", new double[]{1.2420847740071876, 0.579498938269863, 0.2997516613567131});
    model.component("comp1").geom("geom1").feature("sph280").set("r", 0.005427519221761414);
    model.component("comp1").geom("geom1").create("sph281", "Sphere");
    model.component("comp1").geom("geom1").feature("sph281")
         .set("pos", new double[]{0.7567836859257586, 0.4577350059592254, 0.5819702335677176});
    model.component("comp1").geom("geom1").feature("sph281").set("r", 0.023578989237862315);
    model.component("comp1").geom("geom1").create("sph282", "Sphere");
    model.component("comp1").geom("geom1").feature("sph282")
         .set("pos", new double[]{0.559292643950383, 0.3768609737324283, 0.2548145955272338});
    model.component("comp1").geom("geom1").feature("sph282").set("r", 0.010282752884211393);
    model.component("comp1").geom("geom1").create("sph283", "Sphere");
    model.component("comp1").geom("geom1").feature("sph283")
         .set("pos", new double[]{0.939308419706217, 0.09479748684735134, 0.9459360013726914});
    model.component("comp1").geom("geom1").feature("sph283").set("r", 0.016690945322332597);
    model.component("comp1").geom("geom1").create("sph284", "Sphere");
    model.component("comp1").geom("geom1").feature("sph284")
         .set("pos", new double[]{1.0438790315667388, 0.7365110717930617, 0.10530889816394248});
    model.component("comp1").geom("geom1").feature("sph284").set("r", 0.0200614131173891);
    model.component("comp1").geom("geom1").create("sph285", "Sphere");
    model.component("comp1").geom("geom1").feature("sph285")
         .set("pos", new double[]{0.6972629922363935, 0.6639752936219552, 0.4512628639348643});
    model.component("comp1").geom("geom1").feature("sph285").set("r", 0.014633925660423541);
    model.component("comp1").geom("geom1").create("sph286", "Sphere");
    model.component("comp1").geom("geom1").feature("sph286")
         .set("pos", new double[]{0.9247114744254968, 0.6856798988792838, 0.6117014366029154});
    model.component("comp1").geom("geom1").feature("sph286").set("r", 0.01908626796767819);
    model.component("comp1").geom("geom1").create("sph287", "Sphere");
    model.component("comp1").geom("geom1").feature("sph287")
         .set("pos", new double[]{1.0066193858989314, 0.7709171473553372, 0.8895394257310403});
    model.component("comp1").geom("geom1").feature("sph287").set("r", 0.008019614665592915);
    model.component("comp1").geom("geom1").create("sph288", "Sphere");
    model.component("comp1").geom("geom1").feature("sph288")
         .set("pos", new double[]{0.4329353982399296, 0.3953844540381505, 0.32762556902500606});
    model.component("comp1").geom("geom1").feature("sph288").set("r", 0.009675373852082118);
    model.component("comp1").geom("geom1").create("sph289", "Sphere");
    model.component("comp1").geom("geom1").feature("sph289")
         .set("pos", new double[]{0.8586875305907787, 0.7437206825575662, 0.4321946444004172});
    model.component("comp1").geom("geom1").feature("sph289").set("r", 0.021309538580112523);
    model.component("comp1").geom("geom1").create("sph290", "Sphere");
    model.component("comp1").geom("geom1").feature("sph290")
         .set("pos", new double[]{0.37041590733392443, 0.37770845642832557, 0.2042500924976907});
    model.component("comp1").geom("geom1").feature("sph290").set("r", 0.0069888112583117844);
    model.component("comp1").geom("geom1").create("sph292", "Sphere");
    model.component("comp1").geom("geom1").feature("sph292")
         .set("pos", new double[]{0.488661227519979, 0.46288944590006637, 0.20869680983164476});
    model.component("comp1").geom("geom1").feature("sph292").set("r", 0.006763473624843621);
    model.component("comp1").geom("geom1").create("sph293", "Sphere");
    model.component("comp1").geom("geom1").feature("sph293")
         .set("pos", new double[]{0.9768699536796754, 0.7179400435192351, 0.33565283316524064});
    model.component("comp1").geom("geom1").feature("sph293").set("r", 0.005509524715576406);
    model.component("comp1").geom("geom1").create("sph294", "Sphere");
    model.component("comp1").geom("geom1").feature("sph294")
         .set("pos", new double[]{0.6815723852399997, 0.8414411355820347, 0.6470541113611188});
    model.component("comp1").geom("geom1").feature("sph294").set("r", 0.02186988252127311);
    model.component("comp1").geom("geom1").create("sph295", "Sphere");
    model.component("comp1").geom("geom1").feature("sph295")
         .set("pos", new double[]{0.46067573318420785, 0.5279735067942914, 0.8734322738928223});
    model.component("comp1").geom("geom1").feature("sph295").set("r", 0.016620713148361804);
    model.component("comp1").geom("geom1").create("sph296", "Sphere");
    model.component("comp1").geom("geom1").feature("sph296")
         .set("pos", new double[]{1.112710706023177, 0.8914963208377192, 0.3370250811349312});
    model.component("comp1").geom("geom1").feature("sph296").set("r", 0.011099879516704322);
    model.component("comp1").geom("geom1").create("sph297", "Sphere");
    model.component("comp1").geom("geom1").feature("sph297")
         .set("pos", new double[]{1.1343208361841868, 0.10001919865065725, 0.8568860807181747});
    model.component("comp1").geom("geom1").feature("sph297").set("r", 0.018661487326731282);
    model.component("comp1").geom("geom1").create("sph298", "Sphere");
    model.component("comp1").geom("geom1").feature("sph298")
         .set("pos", new double[]{1.0936012338745942, 0.6608295113092055, 0.3501972679395991});
    model.component("comp1").geom("geom1").feature("sph298").set("r", 0.008816787265369613);
    model.component("comp1").geom("geom1").create("sph299", "Sphere");
    model.component("comp1").geom("geom1").feature("sph299")
         .set("pos", new double[]{0.8831975776153375, 0.8352485378691394, 0.8102450882188211});
    model.component("comp1").geom("geom1").feature("sph299").set("r", 0.00802751139985598);
    model.component("comp1").geom("geom1").create("sph300", "Sphere");
    model.component("comp1").geom("geom1").feature("sph300")
         .set("pos", new double[]{1.1902718275913302, 0.5849657024984243, 0.2144911374940371});
    model.component("comp1").geom("geom1").feature("sph300").set("r", 0.017564791942613157);
    model.component("comp1").geom("geom1").create("sph301", "Sphere");
    model.component("comp1").geom("geom1").feature("sph301")
         .set("pos", new double[]{0.5911821370480621, 0.9687383772520733, 0.3858861273003491});
    model.component("comp1").geom("geom1").feature("sph301").set("r", 0.013586614452329848);
    model.component("comp1").geom("geom1").create("sph302", "Sphere");
    model.component("comp1").geom("geom1").feature("sph302")
         .set("pos", new double[]{0.7678695283808131, 0.1951244394992658, 0.10422967675986836});
    model.component("comp1").geom("geom1").feature("sph302").set("r", 0.02485401747329636);
    model.component("comp1").geom("geom1").create("sph303", "Sphere");
    model.component("comp1").geom("geom1").feature("sph303")
         .set("pos", new double[]{0.38276267683172127, 0.6284906329406055, 0.41777728920741997});
    model.component("comp1").geom("geom1").feature("sph303").set("r", 0.012406113875477753);
    model.component("comp1").geom("geom1").create("sph304", "Sphere");
    model.component("comp1").geom("geom1").feature("sph304")
         .set("pos", new double[]{1.1586140774659726, 0.17366205129689438, 0.40220230703301607});
    model.component("comp1").geom("geom1").feature("sph304").set("r", 0.024818312650509003);
    model.component("comp1").geom("geom1").create("sph305", "Sphere");
    model.component("comp1").geom("geom1").feature("sph305")
         .set("pos", new double[]{0.8092139592198175, 0.7667762130288202, 0.4878145330711589});
    model.component("comp1").geom("geom1").feature("sph305").set("r", 0.014231594219247724);
    model.component("comp1").geom("geom1").create("sph306", "Sphere");
    model.component("comp1").geom("geom1").feature("sph306")
         .set("pos", new double[]{0.5183780512479188, 0.8915805177324493, 0.04462908157753287});
    model.component("comp1").geom("geom1").feature("sph306").set("r", 0.013399871040204816);
    model.component("comp1").geom("geom1").create("sph307", "Sphere");
    model.component("comp1").geom("geom1").feature("sph307")
         .set("pos", new double[]{0.4518159324305984, 0.6740830298911376, 0.36430873730224306});
    model.component("comp1").geom("geom1").feature("sph307").set("r", 0.021422437964379294);
    model.component("comp1").geom("geom1").create("sph309", "Sphere");
    model.component("comp1").geom("geom1").feature("sph309")
         .set("pos", new double[]{0.5656053953611685, 0.02739174231341615, 0.24212665415563986});
    model.component("comp1").geom("geom1").feature("sph309").set("r", 0.01666812629216456);
    model.component("comp1").geom("geom1").create("sph310", "Sphere");
    model.component("comp1").geom("geom1").feature("sph310")
         .set("pos", new double[]{0.45812435811474383, 0.882127810497351, 0.8597315757819809});
    model.component("comp1").geom("geom1").feature("sph310").set("r", 0.007908072683424715);
    model.component("comp1").geom("geom1").create("sph311", "Sphere");
    model.component("comp1").geom("geom1").feature("sph311")
         .set("pos", new double[]{0.721619106021737, 0.8081583267782023, 0.4960685143741801});
    model.component("comp1").geom("geom1").feature("sph311").set("r", 0.019005788752668996);
    model.component("comp1").geom("geom1").create("sph312", "Sphere");
    model.component("comp1").geom("geom1").feature("sph312")
         .set("pos", new double[]{0.5311097010416771, 0.9058230499702037, 0.39202268260609135});
    model.component("comp1").geom("geom1").feature("sph312").set("r", 0.012269773665698105);
    model.component("comp1").geom("geom1").create("sph313", "Sphere");
    model.component("comp1").geom("geom1").feature("sph313")
         .set("pos", new double[]{0.5117350317957867, 0.8658278179110526, 0.38906704147597465});
    model.component("comp1").geom("geom1").feature("sph313").set("r", 0.014857617468626405);
    model.component("comp1").geom("geom1").create("sph314", "Sphere");
    model.component("comp1").geom("geom1").feature("sph314")
         .set("pos", new double[]{0.9628289822156534, 0.20382341642335672, 0.13419149925169904});
    model.component("comp1").geom("geom1").feature("sph314").set("r", 0.010951494306277506);
    model.component("comp1").geom("geom1").create("sph315", "Sphere");
    model.component("comp1").geom("geom1").feature("sph315")
         .set("pos", new double[]{0.9835209131660417, 0.5847743113126881, 0.25921279497763705});
    model.component("comp1").geom("geom1").feature("sph315").set("r", 0.021739955644270247);
    model.component("comp1").geom("geom1").create("sph316", "Sphere");
    model.component("comp1").geom("geom1").feature("sph316")
         .set("pos", new double[]{0.8835225851868233, 0.33704103485695946, 0.09124710406337044});

    return model;
  }

  public static Model run4(Model model) {
    model.component("comp1").geom("geom1").feature("sph316").set("r", 0.017464942903751682);
    model.component("comp1").geom("geom1").create("sph317", "Sphere");
    model.component("comp1").geom("geom1").feature("sph317")
         .set("pos", new double[]{0.7117675495179864, 0.746662532000369, 0.2699403850568456});
    model.component("comp1").geom("geom1").feature("sph317").set("r", 0.022610771951286537);
    model.component("comp1").geom("geom1").create("sph319", "Sphere");
    model.component("comp1").geom("geom1").feature("sph319")
         .set("pos", new double[]{0.3376582802439974, 0.31069876133949115, 0.7320920392232425});
    model.component("comp1").geom("geom1").feature("sph319").set("r", 0.009885333264179516);
    model.component("comp1").geom("geom1").create("sph320", "Sphere");
    model.component("comp1").geom("geom1").feature("sph320")
         .set("pos", new double[]{0.9164455664644303, 0.03522567260943853, 0.6686374773674888});
    model.component("comp1").geom("geom1").feature("sph320").set("r", 0.017300314499420977);
    model.component("comp1").geom("geom1").create("sph321", "Sphere");
    model.component("comp1").geom("geom1").feature("sph321")
         .set("pos", new double[]{0.48901543284752247, 0.19119304567679973, 0.20077389614138116});
    model.component("comp1").geom("geom1").feature("sph321").set("r", 0.015063613810857742);
    model.component("comp1").geom("geom1").create("sph322", "Sphere");
    model.component("comp1").geom("geom1").feature("sph322")
         .set("pos", new double[]{1.2114666410933184, 0.8873552833856401, 0.357102733518855});
    model.component("comp1").geom("geom1").feature("sph322").set("r", 0.02188520010150197);
    model.component("comp1").geom("geom1").create("sph324", "Sphere");
    model.component("comp1").geom("geom1").feature("sph324")
         .set("pos", new double[]{1.0276119552961827, 0.12166128746269564, 0.5350236074702687});
    model.component("comp1").geom("geom1").feature("sph324").set("r", 0.016799025965988076);
    model.component("comp1").geom("geom1").create("sph325", "Sphere");
    model.component("comp1").geom("geom1").feature("sph325")
         .set("pos", new double[]{0.8517367925231242, 0.938321876962559, 0.397607257338102});
    model.component("comp1").geom("geom1").feature("sph325").set("r", 0.012319666933393085);
    model.component("comp1").geom("geom1").create("sph326", "Sphere");
    model.component("comp1").geom("geom1").feature("sph326")
         .set("pos", new double[]{1.033162124026357, 0.6384455713758568, 0.39873551640222005});
    model.component("comp1").geom("geom1").feature("sph326").set("r", 0.01285945995883233);
    model.component("comp1").geom("geom1").create("sph327", "Sphere");
    model.component("comp1").geom("geom1").feature("sph327")
         .set("pos", new double[]{0.6576071360063939, 0.157057826795292, 0.45348415338046955});
    model.component("comp1").geom("geom1").feature("sph327").set("r", 0.018779100964605028);
    model.component("comp1").geom("geom1").create("sph329", "Sphere");
    model.component("comp1").geom("geom1").feature("sph329")
         .set("pos", new double[]{0.9882827515163501, 0.5397066039746827, 0.6897137447150989});
    model.component("comp1").geom("geom1").feature("sph329").set("r", 0.01697641781246844);
    model.component("comp1").geom("geom1").create("sph330", "Sphere");
    model.component("comp1").geom("geom1").feature("sph330")
         .set("pos", new double[]{1.0954930665323395, 0.18979721158007748, 0.2790613854895477});
    model.component("comp1").geom("geom1").feature("sph330").set("r", 0.023611196384996903);
    model.component("comp1").geom("geom1").create("sph331", "Sphere");
    model.component("comp1").geom("geom1").feature("sph331")
         .set("pos", new double[]{1.2225149613732202, 0.24504768003497365, 0.655320385524903});
    model.component("comp1").geom("geom1").feature("sph331").set("r", 0.006432205588836091);
    model.component("comp1").geom("geom1").create("sph332", "Sphere");
    model.component("comp1").geom("geom1").feature("sph332")
         .set("pos", new double[]{0.46470018477058345, 0.5027295259541006, 0.11822138943268293});
    model.component("comp1").geom("geom1").feature("sph332").set("r", 0.00679261397854924);
    model.component("comp1").geom("geom1").create("sph333", "Sphere");
    model.component("comp1").geom("geom1").feature("sph333")
         .set("pos", new double[]{0.7870169463786307, 0.3465292279690591, 0.5533536805802924});
    model.component("comp1").geom("geom1").feature("sph333").set("r", 0.012777468053894488);
    model.component("comp1").geom("geom1").create("sph334", "Sphere");
    model.component("comp1").geom("geom1").feature("sph334")
         .set("pos", new double[]{0.6440530665107813, 0.6861679180819225, 0.6692958312848408});
    model.component("comp1").geom("geom1").feature("sph334").set("r", 0.01573536643884928);
    model.component("comp1").geom("geom1").create("sph335", "Sphere");
    model.component("comp1").geom("geom1").feature("sph335")
         .set("pos", new double[]{0.8091858207781083, 0.3662392014748835, 0.6066092667327683});
    model.component("comp1").geom("geom1").feature("sph335").set("r", 0.018746062987487797);
    model.component("comp1").geom("geom1").create("sph336", "Sphere");
    model.component("comp1").geom("geom1").feature("sph336")
         .set("pos", new double[]{0.8422931554321086, 0.9472516723583598, 0.44498451158753316});
    model.component("comp1").geom("geom1").feature("sph336").set("r", 0.023714725332163997);
    model.component("comp1").geom("geom1").create("sph337", "Sphere");
    model.component("comp1").geom("geom1").feature("sph337")
         .set("pos", new double[]{0.305907587973818, 0.7489530402705045, 0.5171922818968778});
    model.component("comp1").geom("geom1").feature("sph337").set("r", 0.019792239250150934);
    model.component("comp1").geom("geom1").create("sph338", "Sphere");
    model.component("comp1").geom("geom1").feature("sph338")
         .set("pos", new double[]{0.5294754846542387, 0.5337798580757251, 0.7598670065938828});
    model.component("comp1").geom("geom1").feature("sph338").set("r", 0.005106330659222065);
    model.component("comp1").geom("geom1").create("sph339", "Sphere");
    model.component("comp1").geom("geom1").feature("sph339")
         .set("pos", new double[]{0.7984587344260181, 0.7913254958370287, 0.6447778931273559});
    model.component("comp1").geom("geom1").feature("sph339").set("r", 0.006061851909050502);
    model.component("comp1").geom("geom1").create("sph340", "Sphere");
    model.component("comp1").geom("geom1").feature("sph340")
         .set("pos", new double[]{0.3448287356090675, 0.29181798688962474, 0.8910404782519876});
    model.component("comp1").geom("geom1").feature("sph340").set("r", 0.023628940299858216);
    model.component("comp1").geom("geom1").create("sph341", "Sphere");
    model.component("comp1").geom("geom1").feature("sph341")
         .set("pos", new double[]{0.8456908659468103, 0.8127902057517729, 0.872043174427558});
    model.component("comp1").geom("geom1").feature("sph341").set("r", 0.02030010296596286);
    model.component("comp1").geom("geom1").create("sph342", "Sphere");
    model.component("comp1").geom("geom1").feature("sph342")
         .set("pos", new double[]{1.2241384602764773, 0.16448067076516237, 0.10013548315228267});
    model.component("comp1").geom("geom1").feature("sph342").set("r", 0.0244544070570565);
    model.component("comp1").geom("geom1").create("sph343", "Sphere");
    model.component("comp1").geom("geom1").feature("sph343")
         .set("pos", new double[]{0.27102235899854976, 0.9562789490997227, 0.10811475371886918});
    model.component("comp1").geom("geom1").feature("sph343").set("r", 0.0064693330872024665);
    model.component("comp1").geom("geom1").create("sph344", "Sphere");
    model.component("comp1").geom("geom1").feature("sph344")
         .set("pos", new double[]{0.9270865897101264, 0.48834939607249817, 0.35645573747795184});
    model.component("comp1").geom("geom1").feature("sph344").set("r", 0.021834736523716994);
    model.component("comp1").geom("geom1").create("sph345", "Sphere");
    model.component("comp1").geom("geom1").feature("sph345")
         .set("pos", new double[]{0.5097826669045097, 0.8928732106139364, 0.7156813496547259});
    model.component("comp1").geom("geom1").feature("sph345").set("r", 0.0120729557413401);
    model.component("comp1").geom("geom1").create("sph346", "Sphere");
    model.component("comp1").geom("geom1").feature("sph346")
         .set("pos", new double[]{0.71194594439524, 0.2880890318763228, 0.04358567759462297});
    model.component("comp1").geom("geom1").feature("sph346").set("r", 0.005518515855685397);
    model.component("comp1").geom("geom1").create("sph348", "Sphere");
    model.component("comp1").geom("geom1").feature("sph348")
         .set("pos", new double[]{0.5622983682236614, 0.9097065816271306, 0.9564156665816509});
    model.component("comp1").geom("geom1").feature("sph348").set("r", 0.011492766444059933);
    model.component("comp1").geom("geom1").create("sph349", "Sphere");
    model.component("comp1").geom("geom1").feature("sph349")
         .set("pos", new double[]{1.1879512937175134, 0.8682310942044004, 0.517113943015361});
    model.component("comp1").geom("geom1").feature("sph349").set("r", 0.015471106094337855);
    model.component("comp1").geom("geom1").create("sph350", "Sphere");
    model.component("comp1").geom("geom1").feature("sph350")
         .set("pos", new double[]{0.955114655853039, 0.4576354763159852, 0.600487789044621});
    model.component("comp1").geom("geom1").feature("sph350").set("r", 0.012454976041949712);
    model.component("comp1").geom("geom1").create("sph351", "Sphere");
    model.component("comp1").geom("geom1").feature("sph351")
         .set("pos", new double[]{1.0103255534014741, 0.34581345986261125, 0.11761062255891903});
    model.component("comp1").geom("geom1").feature("sph351").set("r", 0.024808123937798934);
    model.component("comp1").geom("geom1").create("sph352", "Sphere");
    model.component("comp1").geom("geom1").feature("sph352")
         .set("pos", new double[]{0.7763847546544415, 0.42020247461615645, 0.7894161223229907});
    model.component("comp1").geom("geom1").feature("sph352").set("r", 0.008698111805568167);
    model.component("comp1").geom("geom1").create("sph353", "Sphere");
    model.component("comp1").geom("geom1").feature("sph353")
         .set("pos", new double[]{0.4431107952888013, 0.8358241616505292, 0.9265993979479579});
    model.component("comp1").geom("geom1").feature("sph353").set("r", 0.023664046763733636);
    model.component("comp1").geom("geom1").create("sph354", "Sphere");
    model.component("comp1").geom("geom1").feature("sph354")
         .set("pos", new double[]{0.3102202523795409, 0.08783542533410765, 0.0395903861431187});
    model.component("comp1").geom("geom1").feature("sph354").set("r", 0.024189412136995644);
    model.component("comp1").geom("geom1").create("sph355", "Sphere");
    model.component("comp1").geom("geom1").feature("sph355")
         .set("pos", new double[]{0.31569841794477926, 0.3026248235612313, 0.3621368287148548});
    model.component("comp1").geom("geom1").feature("sph355").set("r", 0.011253623123109529);
    model.component("comp1").geom("geom1").create("sph356", "Sphere");
    model.component("comp1").geom("geom1").feature("sph356")
         .set("pos", new double[]{0.7280606682827655, 0.2933508451904408, 0.502800399781181});
    model.component("comp1").geom("geom1").feature("sph356").set("r", 0.02407354036947844);
    model.component("comp1").geom("geom1").create("sph357", "Sphere");
    model.component("comp1").geom("geom1").feature("sph357")
         .set("pos", new double[]{0.37513754293357604, 0.743678767876794, 0.8323303141084993});
    model.component("comp1").geom("geom1").feature("sph357").set("r", 0.01786715849298271);
    model.component("comp1").geom("geom1").create("sph359", "Sphere");
    model.component("comp1").geom("geom1").feature("sph359")
         .set("pos", new double[]{0.47966297070746905, 0.9552657580385182, 0.2919603785042967});
    model.component("comp1").geom("geom1").feature("sph359").set("r", 0.007031629518923324);
    model.component("comp1").geom("geom1").create("sph360", "Sphere");
    model.component("comp1").geom("geom1").feature("sph360")
         .set("pos", new double[]{1.122471337994405, 0.8944942043068395, 0.17894541985694332});
    model.component("comp1").geom("geom1").feature("sph360").set("r", 0.023147922844819948);
    model.component("comp1").geom("geom1").create("sph362", "Sphere");
    model.component("comp1").geom("geom1").feature("sph362")
         .set("pos", new double[]{0.695260666881425, 0.09892419343655878, 0.17749981022845795});
    model.component("comp1").geom("geom1").feature("sph362").set("r", 0.008198375771785664);
    model.component("comp1").geom("geom1").create("sph363", "Sphere");
    model.component("comp1").geom("geom1").feature("sph363")
         .set("pos", new double[]{0.9376102723879283, 0.5710066368440658, 0.859178721692289});
    model.component("comp1").geom("geom1").feature("sph363").set("r", 0.008943926929333386);
    model.component("comp1").geom("geom1").create("sph364", "Sphere");
    model.component("comp1").geom("geom1").feature("sph364")
         .set("pos", new double[]{0.8770436162956557, 0.052954086245469656, 0.5155539994290899});
    model.component("comp1").geom("geom1").feature("sph364").set("r", 0.009892681314384161);
    model.component("comp1").geom("geom1").create("sph365", "Sphere");
    model.component("comp1").geom("geom1").feature("sph365")
         .set("pos", new double[]{1.212568844318785, 0.04150041118110288, 0.2687903887286083});
    model.component("comp1").geom("geom1").feature("sph365").set("r", 0.02226452963427699);
    model.component("comp1").geom("geom1").create("sph366", "Sphere");
    model.component("comp1").geom("geom1").feature("sph366")
         .set("pos", new double[]{0.30611356070019147, 0.029253191941248105, 0.4905772439217765});
    model.component("comp1").geom("geom1").feature("sph366").set("r", 0.009476993406550508);
    model.component("comp1").geom("geom1").create("sph367", "Sphere");
    model.component("comp1").geom("geom1").feature("sph367")
         .set("pos", new double[]{0.5309481340281861, 0.6355206782859509, 0.301224794172997});
    model.component("comp1").geom("geom1").feature("sph367").set("r", 0.005909642913405882);
    model.component("comp1").geom("geom1").create("sph368", "Sphere");
    model.component("comp1").geom("geom1").feature("sph368")
         .set("pos", new double[]{0.8386644052052682, 0.38540663680169984, 0.6942628914145315});
    model.component("comp1").geom("geom1").feature("sph368").set("r", 0.010393094023181029);
    model.component("comp1").geom("geom1").create("sph369", "Sphere");
    model.component("comp1").geom("geom1").feature("sph369")
         .set("pos", new double[]{0.8792336408566126, 0.36070189962522525, 0.2976587317258797});
    model.component("comp1").geom("geom1").feature("sph369").set("r", 0.014922479024997222);
    model.component("comp1").geom("geom1").create("sph370", "Sphere");
    model.component("comp1").geom("geom1").feature("sph370")
         .set("pos", new double[]{1.180380692289523, 0.7940665185066952, 0.9225537461426835});
    model.component("comp1").geom("geom1").feature("sph370").set("r", 0.007664142275022039);
    model.component("comp1").geom("geom1").create("sph371", "Sphere");
    model.component("comp1").geom("geom1").feature("sph371")
         .set("pos", new double[]{1.1756122594923377, 0.9194494051310119, 0.29164324346078685});
    model.component("comp1").geom("geom1").feature("sph371").set("r", 0.008707610492956047);
    model.component("comp1").geom("geom1").create("sph372", "Sphere");
    model.component("comp1").geom("geom1").feature("sph372")
         .set("pos", new double[]{0.800352263073397, 0.19818777631617257, 0.44447411802666664});
    model.component("comp1").geom("geom1").feature("sph372").set("r", 0.010492684968477259);
    model.component("comp1").geom("geom1").create("sph373", "Sphere");
    model.component("comp1").geom("geom1").feature("sph373")
         .set("pos", new double[]{1.189585892695842, 0.49405569376381747, 0.9465613484585705});
    model.component("comp1").geom("geom1").feature("sph373").set("r", 0.008706352918753688);
    model.component("comp1").geom("geom1").create("sph374", "Sphere");
    model.component("comp1").geom("geom1").feature("sph374")
         .set("pos", new double[]{0.734877231764964, 0.9415989424161125, 0.16309895941566788});
    model.component("comp1").geom("geom1").feature("sph374").set("r", 0.017898833450244237);
    model.component("comp1").geom("geom1").create("sph375", "Sphere");
    model.component("comp1").geom("geom1").feature("sph375")
         .set("pos", new double[]{0.9061748101046615, 0.4374980344903214, 0.08372177219775333});
    model.component("comp1").geom("geom1").feature("sph375").set("r", 0.017646597493329932);
    model.component("comp1").geom("geom1").create("sph376", "Sphere");
    model.component("comp1").geom("geom1").feature("sph376")
         .set("pos", new double[]{0.7161697758445837, 0.7914987629914426, 0.26875710545420844});
    model.component("comp1").geom("geom1").feature("sph376").set("r", 0.014854452023320665);
    model.component("comp1").geom("geom1").create("sph377", "Sphere");
    model.component("comp1").geom("geom1").feature("sph377")
         .set("pos", new double[]{0.49683866463879295, 0.6779309281701154, 0.9675167394186126});
    model.component("comp1").geom("geom1").feature("sph377").set("r", 0.012828607259685373);
    model.component("comp1").geom("geom1").create("sph378", "Sphere");
    model.component("comp1").geom("geom1").feature("sph378")
         .set("pos", new double[]{1.0659509069741877, 0.24096812551674127, 0.07437366484029762});
    model.component("comp1").geom("geom1").feature("sph378").set("r", 0.008548590737365238);
    model.component("comp1").geom("geom1").create("sph379", "Sphere");
    model.component("comp1").geom("geom1").feature("sph379")
         .set("pos", new double[]{1.178385326774312, 0.8747283977794591, 0.296752845587692});
    model.component("comp1").geom("geom1").feature("sph379").set("r", 0.007776330360913472);
    model.component("comp1").geom("geom1").create("sph380", "Sphere");
    model.component("comp1").geom("geom1").feature("sph380")
         .set("pos", new double[]{1.083165166402143, 0.4390924237723584, 0.47021932757221896});
    model.component("comp1").geom("geom1").feature("sph380").set("r", 0.02395528132203214);
    model.component("comp1").geom("geom1").create("sph381", "Sphere");
    model.component("comp1").geom("geom1").feature("sph381")
         .set("pos", new double[]{0.4200671038955098, 0.04156326289150596, 0.27845437552101504});
    model.component("comp1").geom("geom1").feature("sph381").set("r", 0.017597060431668456);
    model.component("comp1").geom("geom1").create("sph382", "Sphere");
    model.component("comp1").geom("geom1").feature("sph382")
         .set("pos", new double[]{0.9226460598836878, 0.5498929761081207, 0.3271088772505191});
    model.component("comp1").geom("geom1").feature("sph382").set("r", 0.005308872638855218);
    model.component("comp1").geom("geom1").create("sph383", "Sphere");
    model.component("comp1").geom("geom1").feature("sph383")
         .set("pos", new double[]{0.41038193827895325, 0.26049600847432625, 0.3050258407078877});
    model.component("comp1").geom("geom1").feature("sph383").set("r", 0.020604046742395174);
    model.component("comp1").geom("geom1").create("sph384", "Sphere");
    model.component("comp1").geom("geom1").feature("sph384")
         .set("pos", new double[]{0.34528873596352777, 0.8559772887371041, 0.10377046621490718});
    model.component("comp1").geom("geom1").feature("sph384").set("r", 0.008918638929979843);
    model.component("comp1").geom("geom1").create("sph385", "Sphere");
    model.component("comp1").geom("geom1").feature("sph385")
         .set("pos", new double[]{0.3845783018475944, 0.03875963900497529, 0.5539839879400091});
    model.component("comp1").geom("geom1").feature("sph385").set("r", 0.01867420671643276);
    model.component("comp1").geom("geom1").create("sph386", "Sphere");
    model.component("comp1").geom("geom1").feature("sph386")
         .set("pos", new double[]{1.0937731603852825, 0.34915953108768866, 0.058500804750066804});
    model.component("comp1").geom("geom1").feature("sph386").set("r", 0.023142181104407415);
    model.component("comp1").geom("geom1").create("sph387", "Sphere");
    model.component("comp1").geom("geom1").feature("sph387")
         .set("pos", new double[]{1.0431230471446489, 0.8456291866058763, 0.6591226792162143});
    model.component("comp1").geom("geom1").feature("sph387").set("r", 0.021017187102600664);
    model.component("comp1").geom("geom1").create("sph389", "Sphere");
    model.component("comp1").geom("geom1").feature("sph389")
         .set("pos", new double[]{0.9361773042664288, 0.6737166672256207, 0.5192929722494127});
    model.component("comp1").geom("geom1").feature("sph389").set("r", 0.015122622576564694);
    model.component("comp1").geom("geom1").create("sph390", "Sphere");
    model.component("comp1").geom("geom1").feature("sph390")
         .set("pos", new double[]{0.755530071407133, 0.8043474066509149, 0.29561911133181434});
    model.component("comp1").geom("geom1").feature("sph390").set("r", 0.02156936296170943);
    model.component("comp1").geom("geom1").create("sph391", "Sphere");
    model.component("comp1").geom("geom1").feature("sph391")
         .set("pos", new double[]{1.211817085882278, 0.7329539414849171, 0.26871298016861944});
    model.component("comp1").geom("geom1").feature("sph391").set("r", 0.008569896659549766);
    model.component("comp1").geom("geom1").create("sph392", "Sphere");
    model.component("comp1").geom("geom1").feature("sph392")
         .set("pos", new double[]{1.1901250505321042, 0.10307851641359975, 0.10571076635833015});
    model.component("comp1").geom("geom1").feature("sph392").set("r", 0.016624706845823435);
    model.component("comp1").geom("geom1").create("sph393", "Sphere");
    model.component("comp1").geom("geom1").feature("sph393")
         .set("pos", new double[]{0.4840715713890375, 0.7506610530576043, 0.5644201421330467});
    model.component("comp1").geom("geom1").feature("sph393").set("r", 0.017382696628398146);
    model.component("comp1").geom("geom1").create("sph394", "Sphere");
    model.component("comp1").geom("geom1").feature("sph394")
         .set("pos", new double[]{0.3721865501243206, 0.10783238709494083, 0.6180332696346786});
    model.component("comp1").geom("geom1").feature("sph394").set("r", 0.018323761804469905);
    model.component("comp1").geom("geom1").create("sph395", "Sphere");
    model.component("comp1").geom("geom1").feature("sph395")
         .set("pos", new double[]{0.3481446203902146, 0.37704519196226993, 0.6641587595245083});
    model.component("comp1").geom("geom1").feature("sph395").set("r", 0.01319462522268041);
    model.component("comp1").geom("geom1").create("sph396", "Sphere");
    model.component("comp1").geom("geom1").feature("sph396")
         .set("pos", new double[]{1.1387708073287737, 0.9329395889195508, 0.9442250326286985});
    model.component("comp1").geom("geom1").feature("sph396").set("r", 0.008791748003831715);
    model.component("comp1").geom("geom1").create("sph397", "Sphere");
    model.component("comp1").geom("geom1").feature("sph397")
         .set("pos", new double[]{0.659962230787559, 0.7293184389919137, 0.30053875615465236});
    model.component("comp1").geom("geom1").feature("sph397").set("r", 0.019601651154805205);
    model.component("comp1").geom("geom1").create("sph398", "Sphere");
    model.component("comp1").geom("geom1").feature("sph398")
         .set("pos", new double[]{0.8535055720154632, 0.5908088565161664, 0.8625388457302974});
    model.component("comp1").geom("geom1").feature("sph398").set("r", 0.011288344447814925);
    model.component("comp1").geom("geom1").create("sph399", "Sphere");
    model.component("comp1").geom("geom1").feature("sph399")
         .set("pos", new double[]{1.0108156111936457, 0.923291576374797, 0.021083440373805905});
    model.component("comp1").geom("geom1").feature("sph399").set("r", 0.01009201511321154);
    model.component("comp1").geom("geom1").create("sph400", "Sphere");
    model.component("comp1").geom("geom1").feature("sph400")
         .set("pos", new double[]{0.9024793180650362, 0.826485419657753, 0.19924995849807295});
    model.component("comp1").geom("geom1").feature("sph400").set("r", 0.014521782360042097);
    model.component("comp1").geom("geom1").create("sph401", "Sphere");
    model.component("comp1").geom("geom1").feature("sph401")
         .set("pos", new double[]{0.6203668149548732, 0.8670717534630312, 0.05805454618618276});
    model.component("comp1").geom("geom1").feature("sph401").set("r", 0.02212318475974744);
    model.component("comp1").geom("geom1").create("sph402", "Sphere");
    model.component("comp1").geom("geom1").feature("sph402")
         .set("pos", new double[]{1.2249520528307276, 0.6058428526132495, 0.4203847118243492});
    model.component("comp1").geom("geom1").feature("sph402").set("r", 0.006707802782463412);
    model.component("comp1").geom("geom1").create("sph403", "Sphere");
    model.component("comp1").geom("geom1").feature("sph403")
         .set("pos", new double[]{0.8973875255026045, 0.053999831760594016, 0.3185405999785388});
    model.component("comp1").geom("geom1").feature("sph403").set("r", 0.008384283693873812);
    model.component("comp1").geom("geom1").create("sph404", "Sphere");
    model.component("comp1").geom("geom1").feature("sph404")
         .set("pos", new double[]{0.8549772658819251, 0.6443546880238139, 0.8311953027043597});
    model.component("comp1").geom("geom1").feature("sph404").set("r", 0.011469583939781508);
    model.component("comp1").geom("geom1").create("sph405", "Sphere");
    model.component("comp1").geom("geom1").feature("sph405")
         .set("pos", new double[]{0.9028996491260061, 0.5729281953793246, 0.40551205858058154});
    model.component("comp1").geom("geom1").feature("sph405").set("r", 0.02355161885195087);
    model.component("comp1").geom("geom1").create("sph406", "Sphere");
    model.component("comp1").geom("geom1").feature("sph406")
         .set("pos", new double[]{0.42091323587291224, 0.867958370592473, 0.32398976102944127});
    model.component("comp1").geom("geom1").feature("sph406").set("r", 0.02433224985284284);
    model.component("comp1").geom("geom1").create("sph407", "Sphere");
    model.component("comp1").geom("geom1").feature("sph407")
         .set("pos", new double[]{0.9262511415946176, 0.25015730262811103, 0.18499429662461223});
    model.component("comp1").geom("geom1").feature("sph407").set("r", 0.01596978179332208);
    model.component("comp1").geom("geom1").create("sph408", "Sphere");
    model.component("comp1").geom("geom1").feature("sph408")
         .set("pos", new double[]{1.0330089355846384, 0.6827284565766357, 0.1381539452452097});
    model.component("comp1").geom("geom1").feature("sph408").set("r", 0.01516964026859232);
    model.component("comp1").geom("geom1").create("sph409", "Sphere");
    model.component("comp1").geom("geom1").feature("sph409")
         .set("pos", new double[]{0.7306702405282189, 0.9171827572032899, 0.5499054952637955});
    model.component("comp1").geom("geom1").feature("sph409").set("r", 0.02301484430143466);
    model.component("comp1").geom("geom1").create("sph410", "Sphere");
    model.component("comp1").geom("geom1").feature("sph410")
         .set("pos", new double[]{0.45644767238123385, 0.8424092327127081, 0.6990510251285228});
    model.component("comp1").geom("geom1").feature("sph410").set("r", 0.006696036433207058);
    model.component("comp1").geom("geom1").create("sph411", "Sphere");
    model.component("comp1").geom("geom1").feature("sph411")
         .set("pos", new double[]{0.5869707015831735, 0.5261589724796778, 0.6405022992089069});
    model.component("comp1").geom("geom1").feature("sph411").set("r", 0.022898790403058485);
    model.component("comp1").geom("geom1").create("sph412", "Sphere");
    model.component("comp1").geom("geom1").feature("sph412")
         .set("pos", new double[]{0.4905318710293457, 0.43075628507281766, 0.26165592225966455});
    model.component("comp1").geom("geom1").feature("sph412").set("r", 0.01688581707173329);
    model.component("comp1").geom("geom1").create("sph413", "Sphere");
    model.component("comp1").geom("geom1").feature("sph413")
         .set("pos", new double[]{1.2153490013485844, 0.09423424759597146, 0.7002741615019281});
    model.component("comp1").geom("geom1").feature("sph413").set("r", 0.02191229924462291);
    model.component("comp1").geom("geom1").create("sph414", "Sphere");
    model.component("comp1").geom("geom1").feature("sph414")
         .set("pos", new double[]{0.8725246977612554, 0.26857956637893077, 0.6444833826159149});
    model.component("comp1").geom("geom1").feature("sph414").set("r", 0.011602311043981486);
    model.component("comp1").geom("geom1").create("sph415", "Sphere");
    model.component("comp1").geom("geom1").feature("sph415")
         .set("pos", new double[]{0.5499187368564098, 0.8932972887835298, 0.9226546195475418});
    model.component("comp1").geom("geom1").feature("sph415").set("r", 0.012422943689254591);
    model.component("comp1").geom("geom1").create("sph416", "Sphere");
    model.component("comp1").geom("geom1").feature("sph416")
         .set("pos", new double[]{0.4743306350485898, 0.9154520863823545, 0.7367933091118573});
    model.component("comp1").geom("geom1").feature("sph416").set("r", 0.01727100053120271);
    model.component("comp1").geom("geom1").create("sph417", "Sphere");
    model.component("comp1").geom("geom1").feature("sph417")
         .set("pos", new double[]{0.4732650481825584, 0.810332742312566, 0.2557007747597066});
    model.component("comp1").geom("geom1").feature("sph417").set("r", 0.020021796146456123);
    model.component("comp1").geom("geom1").create("sph418", "Sphere");
    model.component("comp1").geom("geom1").feature("sph418")
         .set("pos", new double[]{0.9533078748328434, 0.7289881507155731, 0.3963292070240359});
    model.component("comp1").geom("geom1").feature("sph418").set("r", 0.017632414905003203);
    model.component("comp1").geom("geom1").create("sph419", "Sphere");
    model.component("comp1").geom("geom1").feature("sph419")
         .set("pos", new double[]{1.1366601058332615, 0.5821404606285248, 0.11514610823448501});
    model.component("comp1").geom("geom1").feature("sph419").set("r", 0.02019650793432195);
    model.component("comp1").geom("geom1").create("sph420", "Sphere");
    model.component("comp1").geom("geom1").feature("sph420")
         .set("pos", new double[]{0.36124636756021916, 0.18423405132322043, 0.13956522132379612});
    model.component("comp1").geom("geom1").feature("sph420").set("r", 0.007579519682845521);
    model.component("comp1").geom("geom1").create("sph423", "Sphere");
    model.component("comp1").geom("geom1").feature("sph423")
         .set("pos", new double[]{0.5703430975303234, 0.7786597553567037, 0.789524057999703});
    model.component("comp1").geom("geom1").feature("sph423").set("r", 0.023971455367520152);
    model.component("comp1").geom("geom1").create("sph424", "Sphere");
    model.component("comp1").geom("geom1").feature("sph424")
         .set("pos", new double[]{0.710391152563316, 0.9029109175711146, 0.2734846625904073});
    model.component("comp1").geom("geom1").feature("sph424").set("r", 0.0221999718316069);
    model.component("comp1").geom("geom1").create("sph426", "Sphere");
    model.component("comp1").geom("geom1").feature("sph426")
         .set("pos", new double[]{0.8129971831928524, 0.4928710791057954, 0.2734258613743881});
    model.component("comp1").geom("geom1").feature("sph426").set("r", 0.019503333176654168);
    model.component("comp1").geom("geom1").create("sph427", "Sphere");
    model.component("comp1").geom("geom1").feature("sph427")
         .set("pos", new double[]{0.5052429221771217, 0.23135994746060612, 0.7867534781288587});
    model.component("comp1").geom("geom1").feature("sph427").set("r", 0.011536613697327502);
    model.component("comp1").geom("geom1").create("sph428", "Sphere");
    model.component("comp1").geom("geom1").feature("sph428")
         .set("pos", new double[]{0.3457341225430888, 0.7631084472750661, 0.5319633986901167});
    model.component("comp1").geom("geom1").feature("sph428").set("r", 0.015047900117965168);
    model.component("comp1").geom("geom1").create("sph429", "Sphere");
    model.component("comp1").geom("geom1").feature("sph429")
         .set("pos", new double[]{0.7647844798632027, 0.4059066967407626, 0.9572783816604113});

    return model;
  }

  public static Model run5(Model model) {
    model.component("comp1").geom("geom1").feature("sph429").set("r", 0.019787755746927642);
    model.component("comp1").geom("geom1").create("sph430", "Sphere");
    model.component("comp1").geom("geom1").feature("sph430")
         .set("pos", new double[]{1.177947373418295, 0.917442579799179, 0.39431437981233214});
    model.component("comp1").geom("geom1").feature("sph430").set("r", 0.0055648524032582535);
    model.component("comp1").geom("geom1").create("sph431", "Sphere");
    model.component("comp1").geom("geom1").feature("sph431")
         .set("pos", new double[]{0.8669984823707614, 0.19039571026905455, 0.7915108482452432});
    model.component("comp1").geom("geom1").feature("sph431").set("r", 0.009289297422666397);
    model.component("comp1").geom("geom1").create("sph432", "Sphere");
    model.component("comp1").geom("geom1").feature("sph432")
         .set("pos", new double[]{0.5450229494694888, 0.8992137122985518, 0.8867367594652885});
    model.component("comp1").geom("geom1").feature("sph432").set("r", 0.010078677117554703);
    model.component("comp1").geom("geom1").create("sph433", "Sphere");
    model.component("comp1").geom("geom1").feature("sph433")
         .set("pos", new double[]{1.1014403084937587, 0.36011464153348416, 0.9722854407239689});
    model.component("comp1").geom("geom1").feature("sph433").set("r", 0.015707617834610436);
    model.component("comp1").geom("geom1").create("sph434", "Sphere");
    model.component("comp1").geom("geom1").feature("sph434")
         .set("pos", new double[]{0.5504234086857961, 0.06327958897129675, 0.9665205099262364});
    model.component("comp1").geom("geom1").feature("sph434").set("r", 0.01367379478809954);
    model.component("comp1").geom("geom1").create("sph435", "Sphere");
    model.component("comp1").geom("geom1").feature("sph435")
         .set("pos", new double[]{0.9778769370526952, 0.6339650064142179, 0.7122520631943176});
    model.component("comp1").geom("geom1").feature("sph435").set("r", 0.014297752618236449);
    model.component("comp1").geom("geom1").create("sph436", "Sphere");
    model.component("comp1").geom("geom1").feature("sph436")
         .set("pos", new double[]{1.1649861953428768, 0.9131633317476854, 0.5503288758262787});
    model.component("comp1").geom("geom1").feature("sph436").set("r", 0.006022218076522326);
    model.component("comp1").geom("geom1").create("sph437", "Sphere");
    model.component("comp1").geom("geom1").feature("sph437")
         .set("pos", new double[]{0.5415915991493981, 0.5951437980475508, 0.40356085967624244});
    model.component("comp1").geom("geom1").feature("sph437").set("r", 0.02427831777369102);
    model.component("comp1").geom("geom1").create("sph439", "Sphere");
    model.component("comp1").geom("geom1").feature("sph439")
         .set("pos", new double[]{0.3046572281701792, 0.16152690128153527, 0.3986652582964706});
    model.component("comp1").geom("geom1").feature("sph439").set("r", 0.005837551405999925);
    model.component("comp1").geom("geom1").create("sph441", "Sphere");
    model.component("comp1").geom("geom1").feature("sph441")
         .set("pos", new double[]{0.455481590241489, 0.2329241801428818, 0.0639525279338006});
    model.component("comp1").geom("geom1").feature("sph441").set("r", 0.01206484811966118);
    model.component("comp1").geom("geom1").create("sph442", "Sphere");
    model.component("comp1").geom("geom1").feature("sph442")
         .set("pos", new double[]{0.8979132656966724, 0.4470607532642622, 0.7061257132388392});
    model.component("comp1").geom("geom1").feature("sph442").set("r", 0.01926327946319629);
    model.component("comp1").geom("geom1").create("sph443", "Sphere");
    model.component("comp1").geom("geom1").feature("sph443")
         .set("pos", new double[]{1.1824020389263756, 0.8356686845463431, 0.6535649858228972});
    model.component("comp1").geom("geom1").feature("sph443").set("r", 0.007199519448906408);
    model.component("comp1").geom("geom1").create("sph444", "Sphere");
    model.component("comp1").geom("geom1").feature("sph444")
         .set("pos", new double[]{0.6686653466667045, 0.482959730513748, 0.9156292945349502});
    model.component("comp1").geom("geom1").feature("sph444").set("r", 0.012576623373234636);
    model.component("comp1").geom("geom1").create("sph445", "Sphere");
    model.component("comp1").geom("geom1").feature("sph445")
         .set("pos", new double[]{0.7289072030559254, 0.5509996716887924, 0.8511739011824034});
    model.component("comp1").geom("geom1").feature("sph445").set("r", 0.022271859098362053);
    model.component("comp1").geom("geom1").create("sph446", "Sphere");
    model.component("comp1").geom("geom1").feature("sph446")
         .set("pos", new double[]{0.8825079827708033, 0.7316282504498247, 0.36171004713961596});
    model.component("comp1").geom("geom1").feature("sph446").set("r", 0.023985288675445804);
    model.component("comp1").geom("geom1").create("sph449", "Sphere");
    model.component("comp1").geom("geom1").feature("sph449")
         .set("pos", new double[]{1.00836508265277, 0.42594861151592545, 0.9463253179916405});
    model.component("comp1").geom("geom1").feature("sph449").set("r", 0.02301566229413832);
    model.component("comp1").geom("geom1").create("sph450", "Sphere");
    model.component("comp1").geom("geom1").feature("sph450")
         .set("pos", new double[]{0.5869431700854152, 0.9360184404062774, 0.7963571868446178});
    model.component("comp1").geom("geom1").feature("sph450").set("r", 0.010015463133460046);
    model.component("comp1").geom("geom1").create("sph451", "Sphere");
    model.component("comp1").geom("geom1").feature("sph451")
         .set("pos", new double[]{0.2840631107667462, 0.3877016156791555, 0.25298110442272687});
    model.component("comp1").geom("geom1").feature("sph451").set("r", 0.02300680009021324);
    model.component("comp1").geom("geom1").create("sph453", "Sphere");
    model.component("comp1").geom("geom1").feature("sph453")
         .set("pos", new double[]{0.8326072695421209, 0.5322040187187466, 0.5483231553910386});
    model.component("comp1").geom("geom1").feature("sph453").set("r", 0.012305489224141875);
    model.component("comp1").geom("geom1").create("sph456", "Sphere");
    model.component("comp1").geom("geom1").feature("sph456")
         .set("pos", new double[]{0.7931587119816033, 0.622555207558153, 0.25177941146761007});
    model.component("comp1").geom("geom1").feature("sph456").set("r", 0.007179900678592874);
    model.component("comp1").geom("geom1").create("sph458", "Sphere");
    model.component("comp1").geom("geom1").feature("sph458")
         .set("pos", new double[]{0.8044399988620244, 0.10881678780224807, 0.5782127747733996});
    model.component("comp1").geom("geom1").feature("sph458").set("r", 0.007110141599946695);
    model.component("comp1").geom("geom1").create("sph459", "Sphere");
    model.component("comp1").geom("geom1").feature("sph459")
         .set("pos", new double[]{0.8964596546782261, 0.7071681471979498, 0.5232153069516098});
    model.component("comp1").geom("geom1").feature("sph459").set("r", 0.010059602254403768);
    model.component("comp1").geom("geom1").create("sph460", "Sphere");
    model.component("comp1").geom("geom1").feature("sph460")
         .set("pos", new double[]{1.051921010463691, 0.7901990674242728, 0.6129437934165681});
    model.component("comp1").geom("geom1").feature("sph460").set("r", 0.0181504281540622);
    model.component("comp1").geom("geom1").create("sph461", "Sphere");
    model.component("comp1").geom("geom1").feature("sph461")
         .set("pos", new double[]{0.6605314486200529, 0.8567432083467221, 0.693182059990971});
    model.component("comp1").geom("geom1").feature("sph461").set("r", 0.014022049242415499);
    model.component("comp1").geom("geom1").create("sph462", "Sphere");
    model.component("comp1").geom("geom1").feature("sph462")
         .set("pos", new double[]{0.8145885781226693, 0.8935196744270617, 0.16375327864477582});
    model.component("comp1").geom("geom1").feature("sph462").set("r", 0.008698700447468033);
    model.component("comp1").geom("geom1").create("sph463", "Sphere");
    model.component("comp1").geom("geom1").feature("sph463")
         .set("pos", new double[]{1.0561709678514704, 0.4993831526788621, 0.06709557702191891});
    model.component("comp1").geom("geom1").feature("sph463").set("r", 0.02191035351061413);
    model.component("comp1").geom("geom1").create("sph464", "Sphere");
    model.component("comp1").geom("geom1").feature("sph464")
         .set("pos", new double[]{1.165918697088014, 0.060519684537245676, 0.3770760734690551});
    model.component("comp1").geom("geom1").feature("sph464").set("r", 0.007950050107938708);
    model.component("comp1").geom("geom1").create("sph465", "Sphere");
    model.component("comp1").geom("geom1").feature("sph465")
         .set("pos", new double[]{0.4574826055366167, 0.9547350670352542, 0.17481457469505238});
    model.component("comp1").geom("geom1").feature("sph465").set("r", 0.017380792694509418);
    model.component("comp1").geom("geom1").create("sph466", "Sphere");
    model.component("comp1").geom("geom1").feature("sph466")
         .set("pos", new double[]{0.8642836808414457, 0.2448674153293019, 0.46804701303656804});
    model.component("comp1").geom("geom1").feature("sph466").set("r", 0.015793583903225487);
    model.component("comp1").geom("geom1").create("sph467", "Sphere");
    model.component("comp1").geom("geom1").feature("sph467")
         .set("pos", new double[]{1.008952484448036, 0.6276150103942427, 0.46916087950197255});
    model.component("comp1").geom("geom1").feature("sph467").set("r", 0.014820170582658585);
    model.component("comp1").geom("geom1").create("sph468", "Sphere");
    model.component("comp1").geom("geom1").feature("sph468")
         .set("pos", new double[]{0.7050874353659977, 0.5242543174364153, 0.6495807693953622});
    model.component("comp1").geom("geom1").feature("sph468").set("r", 0.018338850863879503);
    model.component("comp1").geom("geom1").create("sph469", "Sphere");
    model.component("comp1").geom("geom1").feature("sph469")
         .set("pos", new double[]{1.033081325722732, 0.5990338284472422, 0.9624415345597096});
    model.component("comp1").geom("geom1").feature("sph469").set("r", 0.008623907639077232);
    model.component("comp1").geom("geom1").create("sph470", "Sphere");
    model.component("comp1").geom("geom1").feature("sph470")
         .set("pos", new double[]{0.7169038801930641, 0.8802531850192034, 0.5974881239846416});
    model.component("comp1").geom("geom1").feature("sph470").set("r", 0.009447663870623516);
    model.component("comp1").geom("geom1").create("sph471", "Sphere");
    model.component("comp1").geom("geom1").feature("sph471")
         .set("pos", new double[]{0.6670403388776946, 0.6734282851626403, 0.9197206751660085});
    model.component("comp1").geom("geom1").feature("sph471").set("r", 0.0195191769169763);
    model.component("comp1").geom("geom1").create("sph472", "Sphere");
    model.component("comp1").geom("geom1").feature("sph472")
         .set("pos", new double[]{1.051830401521726, 0.951692073042606, 0.033018732841437706});
    model.component("comp1").geom("geom1").feature("sph472").set("r", 0.009003721314786443);
    model.component("comp1").geom("geom1").create("sph473", "Sphere");
    model.component("comp1").geom("geom1").feature("sph473")
         .set("pos", new double[]{0.3744969173020344, 0.757098728021259, 0.09738513658092597});
    model.component("comp1").geom("geom1").feature("sph473").set("r", 0.009304191731888551);
    model.component("comp1").geom("geom1").create("sph474", "Sphere");
    model.component("comp1").geom("geom1").feature("sph474")
         .set("pos", new double[]{0.6451244101225768, 0.8768642855356057, 0.21035740911908402});
    model.component("comp1").geom("geom1").feature("sph474").set("r", 0.02496827117181815);
    model.component("comp1").geom("geom1").create("ps3", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps3").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ps3").set("parmax1", "width");
    model.component("comp1").geom("geom1").feature("ps3").set("parmax2", "depth");
    model.component("comp1").geom("geom1").feature("ps3").set("coord", new String[]{"s1", "0", "s2"});
    model.component("comp1").geom("geom1").create("ps4", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps4").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ps4").set("parmax1", "width");
    model.component("comp1").geom("geom1").feature("ps4").set("parmax2", "depth");
    model.component("comp1").geom("geom1").feature("ps4").set("coord", new String[]{"s1", "height", "s2"});
    model.component("comp1").geom("geom1").create("ps5", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps5").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ps5").set("parmax1", "width");
    model.component("comp1").geom("geom1").feature("ps5").set("parmax2", "height");
    model.component("comp1").geom("geom1").feature("ps5").set("coord", new String[]{"s1", "s2", "0"});
    model.component("comp1").geom("geom1").create("ps6", "ParametricSurface");
    model.component("comp1").geom("geom1").feature("ps6").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ps6").set("parmax1", "width");
    model.component("comp1").geom("geom1").feature("ps6").set("parmax2", "height");
    model.component("comp1").geom("geom1").feature("ps6").set("coord", new String[]{"s1", "s2", "depth"});
    model.component("comp1").geom("geom1").run();

    model.view().create("view2", 2);

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat2").selection().set(2);
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");

    model.component("comp1").physics().create("gop", "GeometricalOptics", "geom1");
    model.component("comp1").physics("gop").create("relb1", "ReleaseFromBoundary", 2);
    model.component("comp1").physics("gop").feature("relb1").selection().set(1);
    model.component("comp1").physics("gop").create("wall1", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall1").selection().named("geom1_ps2_bnd");
    model.component("comp1").physics("gop").create("wall2", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall2").selection().named("geom1_ps3_bnd");
    model.component("comp1").physics("gop").create("wall3", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall3").selection().named("geom1_ps4_bnd");
    model.component("comp1").physics("gop").create("wall4", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall4").selection().named("geom1_ps5_bnd");
    model.component("comp1").physics("gop").create("wall5", "Wall", 2);
    model.component("comp1").physics("gop").feature("wall5").selection().named("geom1_ps6_bnd");

    model.result().table("tbl2").label("Ray Intensity");
    model.result().table("tbl2").comments("Ray Evaluation 1");
    model.result().table("tbl3").label("Ray s1");
    model.result().table("tbl4").label("Ray s2");
    model.result().table("tbl5").label("Ray s3");

    model.component("comp1").material("mat1").label("Bubble");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_bubble", "0", "0", "0", "n_bubble", "0", "0", "0", "n_bubble"});
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    model.component("comp1").material("mat2").label("Channel");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"n_channel", "0", "0", "0", "n_channel", "0", "0", "0", "n_channel"});
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});

    model.component("comp1").physics("gop").prop("IntensityComputation")
         .set("IntensityComputation", "ComputeIntensityAndPower");
    model.component("comp1").physics("gop").prop("ExteriorUnmeshedProperties").set("next", 1.33);
    model.component("comp1").physics("gop").prop("MaximumSecondary").set("MaximumSecondary", 0);
    model.component("comp1").physics("gop").feature("matd1").set("ReleaseReflectedRays", "Never");
    model.component("comp1").physics("gop").feature("op1").set("lambda0", "lda0");
    model.component("comp1").physics("gop").feature("relb1").set("L0", new int[][]{{1}, {0}, {0}});
    model.component("comp1").physics("gop").feature("relb1").set("InitialPolarizationType", "PartiallyPolarized");
    model.component("comp1").physics("gop").feature("wall2").set("WallCondition", "Disappear");
    model.component("comp1").physics("gop").feature("wall3").set("WallCondition", "Disappear");
    model.component("comp1").physics("gop").feature("wall4").set("WallCondition", "Disappear");
    model.component("comp1").physics("gop").feature("wall5").set("WallCondition", "Disappear");

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
    model.sol("sol1").feature("t1").set("control", "user");
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
    model.result().export("tbl1").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/Int/ray_intensity_1.csv");
    model.result().export("tbl2").label("Ray s1");
    model.result().export("tbl2").set("table", "tbl3");
    model.result().export("tbl2").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/s1/ray_s1_1.csv");
    model.result().export("tbl3").label("Ray s2");
    model.result().export("tbl3").set("table", "tbl4");
    model.result().export("tbl3").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/s2/ray_s2_1.csv");
    model.result().export("tbl4").label("Ray s3");
    model.result().export("tbl4").set("table", "tbl5");
    model.result().export("tbl4").set("filename", "/home/jacob/PycharmProjects/DOP_Comm/src/s3/ray_s3_1.csv");

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    model = run2(model);
    model = run3(model);
    model = run4(model);
    run5(model);
  }

}
