

import com.comsol.model.Model;
import com.comsol.model.util.ModelUtil;

public class $name {

	public static void main(String[] args) {
		run();
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
		
		// Create water channel
		model.component("comp1").geom("geom1").lengthUnit("\u00b5m");
		model.component("comp1").geom("geom1").create("r1", "Rectangle");
    	model.component("comp1").geom("geom1").feature("r1").label("Channel");
    	model.component("comp1").geom("geom1").feature("r1").set("size", new String[]{"width", "height"});

$what
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
