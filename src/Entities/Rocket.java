package Entities;

import java.awt.Graphics;
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
	float fuel_burned_per_time = (float) 0.5;
	float force_per_fuel_burnt = 2000;

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
			System.out.println("SOMETHING WRONG HERE.");
		}
	}

	public void accelerate() {
		/*
			Burn fuel and increase velocity
			TODO: Do this
		*/
		this.setFuelPercentage((float) (this.fuel_percentage - this.fuel_burned_per_time));
		// The next line is only for debug.
		// This isn't how the actual rocket will move.
		//this.setPos(this.pos[0]+10, this.pos[1]+10);
	}

	public void decelerate() {
		/*
			Burn fuel and decrease velocity
			TODO: Do this
		*/
		this.setFuelPercentage((float) (this.fuel_percentage - this.fuel_burned_per_time));
		// The next line is only for debug.
		// This isn't how the actual rocket will move.
		//this.setPos(this.pos[0]-10, this.pos[1]-10);
	}

	public void draw(Graphics g) {
		/*
			Draws the rocket at its position
			TODO: change sprite when accelerating/decelerating
			TODO: set pos to middle of image if possible
		*/
		g.drawImage(this.rocket_sprite, (int)this.position[0], (int) this.position[1],80,80,null);
	}
}
