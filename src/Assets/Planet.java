package Assets;

import Physics.Physics;

public class Planet extends object{
	
	double planet_radius, planet_density;
	String planet_name;
	
	Planet(double mass, double[] pos, double[] vel, double radius, String name) {
		double planet_radius = radius;
		String planet_name = name;
		mass=mass;
		vel = vel;
		pos = pos;
	}
	
	public double getRadius() {
		return planet_radius;
	}
	
}
