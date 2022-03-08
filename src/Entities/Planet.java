package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

import Physics.Physics;

public class Planet extends Entity{
	/*
		Class Planet defines a planet
	*/

	double planet_radius;		// Radius of planet, in AU
	Image planet_sprite;		// png
	/*
		Constructor to define a planet
	*/
	Planet(String name, double mass, double radius, String sprite_path) {
		this.name = name;
	    this.mass = mass;
	    this.planet_radius = radius*Physics.AstronomicalUnit;
	    this.velocity = new double[2];
	    this.position = new double[2];
	    this.size = new int[2];
	    double[] temp = new double[] {this.planet_radius*2,this.planet_radius*2};
	    
	    size = Entity.getScaledPos(temp);
	    size[0] = Math.max(size[0],10);
	    size[1] = Math.max(size[1],10);
	    this.setPlanetSprite(sprite_path);
	}

	public void setPlanetSprite(String sprite) {
		/*
			Takes the image from 'sprite' path string and loads
			it into the object
		*/
		Image img;
		try {
			img = ImageIO.read(new File(sprite));
			planet_sprite = img;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics g, int offsetX, int offsetY) {
		/*
			Draws the planet graphic at the planet's position
		*/
		// drawing trail
		
		int[] newPos = new int[2];
		newPos = Entity.getScaledPos(this.position);
		g.drawImage(this.planet_sprite, (int)(newPos[0] - this.size[1]/2 - offsetX), (int)(newPos[1] - this.size[1]/2 - offsetY), (int)(this.size[0]), (int)(this.size[1]), null);
	}

}
