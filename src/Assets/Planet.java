package Assets;

import Physics.Physics;

public class Planet {
	
	double planet_radius, planet_density;
	String planet_name;
	
	Planet(double radius, double density, String name) {
		double planet_radius = radius;
		double planet_density = density;
		String planet_name = name;
	}
	
	double getforce(double dist_from_planet, double rocket_mass) {
		double planet_mass = Physics.getSphereMass(planet_radius, planet_density);
		return 0.0;
	}
}
