package Entities;

import java.awt.Graphics;
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
	public double[] pos = new double[2];
	public double[] velocity = new double[2];
	Image planet_sprite;
	public double mass;

	/*
		Constructor to define a planet
	*/
	Planet(double mass_, double radius, String name, String sprite) {
		planet_radius = radius;
		planet_name = name;
		mass = mass_;
		this.set_planet_sprite(sprite);
	}

	public double getRadius() {
		/*
			Method to get radius of the planet
			Used when calculating gravitational force
		*/
		return planet_radius;
	}

	public void set_planet_sprite(String sprite) {
		/*
			Takes the image from 'sprite' path string and loads
			it into the object
		*/
		BufferedImage img;
		try {
			img = ImageIO.read(new File(sprite));
			planet_sprite = img;
		} catch (IOException e) {
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

	public void draw(Graphics g) {
		/*
			Draws the planet graphic at the planet's position
		*/
		//TODO: tweak this so it accounts for the radius of the planet as well
		g.drawImage(this.planet_sprite, (int)this.pos[0], (int)this.pos[1], 150, 150, null);
	}

}
