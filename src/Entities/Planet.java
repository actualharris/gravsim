package Entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		BufferedImage img;
		try {
			img = ImageIO.read(new File(sprite));
			planet_sprite = img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setPos(double x, double y) {
		/* set pos array values */
		this.pos[0] = x;
		this.pos[1] = y;
	}
	
	public void setVel(double x, double y) {
		/* set velocity array values */
		velocity[0] = x;
		velocity[1] = y;
	}
}
