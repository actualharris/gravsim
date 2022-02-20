package Entities;

public class Planet extends object{
	
	double planet_radius, planet_density;
	String planet_name;
	double[] pos;
	double[] velocity;
	String planet_sprite;
	double mass;
	
	Planet(double mass, double radius, String name) {
		planet_radius = radius;
		planet_name = name;
		mass = mass;
	}
	
	public double getRadius() {
		return planet_radius;
	}
	
	public void set_planet_sprite(String sprite) {
		planet_sprite = sprite;
	}
	
}
