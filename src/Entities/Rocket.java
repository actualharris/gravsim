package Entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Physics.Physics;

public class Rocket extends Entity {
	/*
		Class Rocket defines a Rocket
	*/

	public float fuel_percentage;
	public Image rocket_sprite;
	Image[] rocket_sprite_accelerating = new Image[2];
	Image[] rocket_sprite_decelerating = new Image[2];
	float fuel_burned_per_time = (float) 0.5;
	float force_per_fuel_burnt = 2000000;

	/*
		Constructor
	*/
	public Rocket(double mass, int[] size, float fuel_percentage, String name) {
		/*
			set sprite based on rocketName
			TODO: Alternate sprites will be named '<rocketname>', '<rocketname_a1>', '<rocketname_a2>', '<rocketname_d1>', '<rocketname_d2>'
			send those strings to the set_rocket_sprite func
		*/
		this.mass = mass;
	    this.name = name;
	    this.velocity = new double[2];
	    this.position = new double[2];
	    this.size = new int[2];
	    this.size[0] = size[0]; this.size[1] = size[1];
	    this.fuel_percentage = fuel_percentage;
	    this.setRocketSprite(name,name,name);
	}

	public void setFuelPercentage(float percentage) {
		/*
			Set percentage of fuel in rocket
			Returns nothing
		*/
		this.fuel_percentage = percentage;
	}

	public void setRocketSprite(String sprite, String accelerating_sprite, String decelerating_sprite) {
		/*
			Rocket sprites include five images:
			sprite - idle rocket
			accelerating_sprite - two images animating accelerating rocket
			decelerating_sprite - two images animating decelerating rocket
		*/

		// TODO: Load sprite images into variables
		// accelerating_sprite -> accelerating_sprite1, accelerating_sprite2
		// decelerating_sprite -> decelerating_sprite1, decelerating_sprite2
		BufferedImage img0, img1, img2, img3, img4;
		try {
			img0 = ImageIO.read(new File(sprite));
			img1 = ImageIO.read(new File(accelerating_sprite));
			img2 = ImageIO.read(new File(decelerating_sprite));
			img3 = ImageIO.read(new File(accelerating_sprite));
			img4 = ImageIO.read(new File(decelerating_sprite));
			this.rocket_sprite = img0;
			this.rocket_sprite_accelerating[0] = img1;
			this.rocket_sprite_decelerating[0] = img2;
			this.rocket_sprite_accelerating[1] = img3;
			this.rocket_sprite_decelerating[1] = img4;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage rotate(BufferedImage image, double angle) {
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww - w) / 2, (newh - h) / 2);
	    g.rotate(angle, w / 2, h / 2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	}

	private static GraphicsConfiguration getDefaultConfiguration() {
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	}

	public void accelerate() {
		/*
			Burn fuel and increase velocity
			TODO: Debug this
		*/
		if (this.fuel_percentage > this.fuel_burned_per_time) {
			this.setFuelPercentage((float) (this.fuel_percentage - this.fuel_burned_per_time));

			double vel = Physics.newVel(this.force_per_fuel_burnt,this.mass);
			double theta = Physics.getAngle(this.velocity[0], this.velocity[1]);
			double[] velComponents = Physics.getComponents(vel,theta);
			this.velocity[0] += velComponents[0];
			this.velocity[1] += velComponents[1];
			//this.position[0] += Physics.newPos(this.velocity[0]);
			//this.position[1] += Physics.newPos(this.velocity[1]);
			//System.out.println(this.position[0]+"\t"+this.position[1]);
			//System.out.println(this.fuel_percentage);
			// The next line is only for debug.
			// This isn't how the actual rocket will move.
			//this.setPos(this.pos[0]+10, this.pos[1]+10);
		}
	}

	public void decelerate() {
		/*
			Burn fuel and decrease velocity
			TODO: Debug this
		*/
		if (this.fuel_percentage > this.fuel_burned_per_time) {
			this.setFuelPercentage((float) (this.fuel_percentage - this.fuel_burned_per_time));

			double vel = -Physics.newVel(this.force_per_fuel_burnt,this.mass);
			double theta = Physics.getAngle(this.velocity[0], this.velocity[1]);
			double[] velComponents = Physics.getComponents(vel,theta);
			this.velocity[0] += velComponents[0];
			this.velocity[1] += velComponents[1];
			//this.position[0] += Physics.newPos(this.velocity[0]);
			//this.position[1] += Physics.newPos(this.velocity[1]);
			// The next line is only for debug.
			// This isn't how the actual rocket will move.
			//this.setPos(this.pos[0]-10, this.pos[1]-10);
		}
	}

	public void draw(Graphics g, int offsetX, int offsetY) {
		/*
			Draws the rocket at its position
			TODO: change sprite when accelerating/decelerating
			TODO: set pos to middle of image if possible
		*/
		
		double theta = Physics.getAngle(this.velocity[0], this.velocity[1]);
		BufferedImage updatedSprite = this.rotate((BufferedImage) this.rocket_sprite, theta);
		
		int[] newPos = new int[2];
		newPos = Entity.getScaledPos(this.position);
		g.drawImage(updatedSprite, (newPos[0] - this.size[1]/2 - offsetX), (int)(newPos[1] - this.size[1]/2 - offsetY), (int)(this.size[0]), (int)(this.size[1]), null);
	}
}
