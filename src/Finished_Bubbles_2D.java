

import com.comsol.model.Model;
import com.comsol.model.util.ModelUtil;

public class Finished_Bubbles_2D {

	public static void main(String[] args) {
		run();
	}
	
	public static void createGeom(Model model) {
		model.component("comp1").geom("geom1").lengthUnit("\u00b5m");
		model.component("comp1").geom("geom1").create("r1", "Rectangle");
    	model.component("comp1").geom("geom1").feature("r1").label("Channel");
    	model.component("comp1").geom("geom1").feature("r1").set("size", new String[]{"width", "height"});

		model.component("comp1").geom("geom1").feature().create("c0", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c0").set("pos", new double[]{6.109344480478375, 3.4615363423611867}); 
	 	model.component("comp1").geom("geom1").feature("c0").set("r", 1.1084542908190214); 
	 	model.component("comp1").geom("geom1").feature().create("c1", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c1").set("pos", new double[]{6.17243302422831, 2.0542709255604943}); 
	 	model.component("comp1").geom("geom1").feature("c1").set("r", 0.30545824714395825); 
	 	model.component("comp1").geom("geom1").feature().create("c2", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c2").set("pos", new double[]{9.088205946106717, 5.342846084526715}); 
	 	model.component("comp1").geom("geom1").feature("c2").set("r", 0.5837850178602668); 
	 	model.component("comp1").geom("geom1").feature().create("c3", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c3").set("pos", new double[]{11.59775070801309, 2.4505296352078627}); 
	 	model.component("comp1").geom("geom1").feature("c3").set("r", 0.6868723201646126); 
	 	model.component("comp1").geom("geom1").feature().create("c4", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c4").set("pos", new double[]{6.530424159528933, 6.251448219276085}); 
	 	model.component("comp1").geom("geom1").feature("c4").set("r", 1.3293644109473235); 
	 	model.component("comp1").geom("geom1").feature().create("c5", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c5").set("pos", new double[]{10.506583986438924, 1.8959831192841206}); 
	 	model.component("comp1").geom("geom1").feature("c5").set("r", 0.6842267233139777); 
	 	model.component("comp1").geom("geom1").feature().create("c6", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c6").set("pos", new double[]{12.780478521731581, 9.329226158842612}); 
	 	model.component("comp1").geom("geom1").feature("c6").set("r", 0.37734208471883024); 
	 	model.component("comp1").geom("geom1").feature().create("c7", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c7").set("pos", new double[]{11.715981671838023, 8.358299202467144}); 
	 	model.component("comp1").geom("geom1").feature("c7").set("r", 0.53879384942294); 
	 	model.component("comp1").geom("geom1").feature().create("c8", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c8").set("pos", new double[]{6.972855469414478, 1.6373579304864956}); 
	 	model.component("comp1").geom("geom1").feature("c8").set("r", 1.3524493289053863); 
	 	model.component("comp1").geom("geom1").feature().create("c9", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c9").set("pos", new double[]{13.525980253572932, 1.2547951636066887}); 
	 	model.component("comp1").geom("geom1").feature("c9").set("r", 0.33776258739039644); 
	 	model.component("comp1").geom("geom1").feature().create("c10", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c10").set("pos", new double[]{13.947419232317118, 5.285914560450279}); 
	 	model.component("comp1").geom("geom1").feature("c10").set("r", 0.689550675007073); 
	 	model.component("comp1").geom("geom1").feature().create("c11", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c11").set("pos", new double[]{8.549446619667215, 6.466409065217944}); 
	 	model.component("comp1").geom("geom1").feature("c11").set("r", 1.0686279595306627); 
	 	model.component("comp1").geom("geom1").feature().create("c12", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c12").set("pos", new double[]{6.404962234483926, 6.866839059050377}); 
	 	model.component("comp1").geom("geom1").feature("c12").set("r", 1.2684759406563222); 
	 	model.component("comp1").geom("geom1").feature().create("c13", "Circle"); 
	 	model.component("comp1").geom("geom1").feature("c13").set("pos", new double[]{11.744899607108552, 3.4562602228640054}); 
	 	model.component("comp1").geom("geom1").feature("c13").set("r", 1.4844055244690926); 
	}
	
	public static Model run() {
		// Create model with component 1 and 2D geometry
		Model model = ModelUtil.create("Model");
		model.modelPath("/home/jacob/PycharmProjects/DOP_Comm/src");

    	model.label("2Dbubbles.mph");
		
		// NOTE: Apparently the order that you do things here really matters
		// Set parameters of the variables for the model
		model.param().set("lda0", "795[nm]", "wavelength");
	    model.param().set("f0", "c_const / lda0", "frequency");
	    model.param().set("width", "20[um]", "length of channel");
	    model.param().set("height", "10[um]", "height of channel");
	    model.param().set("n_ch", "1.33", "refractive index of water in channel");
	    model.param().set("n_bu", "1.0", "refractive index of bubbles");
	    model.param().set("xmin", "5[um]", "min x pos for bubbles");
	    model.param().set("xmax", "15[um]", "max x pos for bubbles");
	    model.param().set("ymin", "0[um]", "min y pos for bubbles");
	    model.param().set("ymax", "height", "max y pos for bubbles");
	    model.param().set("rmin", "0.1[um]", "min radius for bubbles");
	    model.param().set("rmax", "0.5[um]", "max radius for bubbles");
	    
	    // Create component
		model.component().create("comp1", true);
		
		// Create geometry
		model.component("comp1").geom().create("geom1", 2);
		
		// Create random function and set seed
		model.func().create("rn1", "Random");
		model.func("rn1").set("mean", 0.5);
		model.func("rn1").set("seedactive", true);
		
		// Create mesh for model
		model.component("comp1").mesh().create("mesh1");
		
		createGeom(model);

		// Build the geometry
		model.component("comp1").geom("geom1").run();
		
		// Double check that setting the domains works properly
		// First create material for bubbles
		model.component("comp1").material().create("mat1", "Common");
		model.component("comp1").material("mat1").label("Bubbles");
		model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive Index");
		
		// Create material for channel
		model.component("comp1").material().create("mat2", "Common");
		model.component("comp1").material("mat2").label("Channel");
		model.component("comp1").material("mat2").selection().set(1);
		model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive Index");
		
		// Create physics module for model
		model.component("comp1").physics().create("ewfd", "ElectromagneticWavesFrequencyDomain", "geom1");
		
		// Set index of refraction (real and imaginary) for material 1 - the bubbles
		model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", "");
		model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("n", new String[] {"n_bu", "0", "0", "0", "n_bu", "0", "0", "0", "n_bu"});
		model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", "");
		model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").set("ki", new String [] {"0", "0", "0", "0", "0", "0", "0", "0", "0"});
		
		// Set index of refraction (real and imaginary) for material 2 - the channel
		model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
		model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", new String[] {"n_ch", "0", "0", "0", "n_ch", "0", "0", "0", "n_ch"});
		model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
		model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", new String [] {"0", "0", "0", "0", "0", "0", "0", "0", "0"});
		
		
		return model;
	}

}
