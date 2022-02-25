package Entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import Physics.Physics;

public class Rocket extends Entity {
	/*
		Class Rocket defines a Rocket
	*/

	float fuel_percentage;
	public Image rocket_sprite;
	Image[] rocket_sprite_accelerating = new Image[2];
	Image[] rocket_sprite_decelerating = new Image[2];
	double max_acceleration;
	public double[] pos = new double[2];
	double[] velocity = new double[2];
	String rocketName = "";

	/*
		Constructor
	*/
	public Rocket(double mass_, double max_acceleration_, float fuel_percentage_, String name) {
		mass=mass_;
		max_acceleration = max_acceleration_;
		fuel_percentage = fuel_percentage_;
		rocketName = name;
		this.set_rocket_sprite(rocketName, rocketName, rocketName);
	}

	/*
		Constructor
	*/
	public Rocket(Rocket r) {
		mass = r.mass;
		volume = r.volume;
		max_acceleration = r.max_acceleration;
		rocketName = "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\rockets\\rocket1.png";
		this.set_rocket_sprite(rocketName, rocketName, rocketName);
	}

	/*
		Set percentage of fuel in rocket
		Returns nothing
	*/
	public void setFuelPercentage(float percentage) {
		fuel_percentage = percentage;
	}

	/*
		Rocket sprites include five images:
		sprite - idle rocket
		accelerating_sprite - two images animating accelerating rocket
		decelerating_sprite - two images animating decelerating rocket
	*/
	public void set_rocket_sprite(String sprite, String accelerating_sprite, String decelerating_sprite) {

		// TODO: Load sprite images into variables
		//rocket_sprite = sprite;
		BufferedImage img0, img1, img2, img3, img4;
		try {
			img0 = ImageIO.read(new File(sprite));
			img1 = ImageIO.read(new File(accelerating_sprite));
			img2 = ImageIO.read(new File(decelerating_sprite));
			img3 = ImageIO.read(new File(accelerating_sprite));
			img4 = ImageIO.read(new File(decelerating_sprite));
			rocket_sprite = img0;
			rocket_sprite_accelerating[0] = img1;
			rocket_sprite_decelerating[0] = img2;
			rocket_sprite_accelerating[1] = img3;
			rocket_sprite_decelerating[1] = img4;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("SOMETHING WRONG HERE.");
		}
		System.out.println("DONE!");
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

	public void accelerate() {
		this.setFuelPercentage(this.fuel_percentage-1);
		double[] force = {2,3};
		this.updateVel(force, 1);
		// The next line is only for debug.
		// This isn't how the actual rocket will move.
		this.setPos(this.pos[0]+10, this.pos[1]+10);
	}
	public void decelerate() {
		this.setFuelPercentage(this.fuel_percentage-1);
		double[] force = {-2,-3};
		this.updateVel(force, 1);
		// The next line is only for debug.
		// This isn't how the actual rocket will move.
		this.setPos(this.pos[0]-10, this.pos[1]-10);
	}
}
