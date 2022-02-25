package Entities;

import java.awt.Image;

public class Planet extends Entity{
	/*
		Class Planet defines a planet
	*/

	double planet_radius, planet_density;
	String planet_name;
	double[] pos;
	double[] velocity;
	Image planet_sprite;
	double mass;

	/*
		Constructor to define a planet
	*/
	Planet(double mass_, double radius, String name) {
		planet_radius = radius;
		planet_name = name;
		mass = mass_;
	}

	// get radius of planet
	public double getRadius() {
		return planet_radius;
	}

	// set sprite of planet
	public void set_planet_sprite(String sprite) {
		// TODO: load image of sprite into the variable
		//planet_sprite = sprite;
	}

}
