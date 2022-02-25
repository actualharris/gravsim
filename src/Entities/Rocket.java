package Entities;

import java.awt.Image;

//import Physics.Physics;

public class Rocket extends object {
	
	double fuel_percentage;
	Image rocket_sprite;
	Image[] rocket_sprite_accelerating;
	Image[] rocket_sprite_decelerating;
	double[] pos;
	double[] velocity;
	
	public Rocket(double mass_, double max_acceleration_, double fuel_percentage_) {
		mass=mass_;
		max_acceleration = max_acceleration_;
		fuel_percentage = fuel_percentage_;
	}
	
	public Rocket(Rocket r) {
		mass = r.mass;
		volume = r.volume;
		max_acceleration = r.max_acceleration;
	}
	
	public void setFuelPercentage(float percentage) {
		fuel_percentage = percentage;
	}
	
	public void set_rocket_sprite(String sprite, String accelerating_sprite, String decelerating_sprite) {
		
		// TODO: Load sprite images into variables
		
		//rocket_sprite = sprite;
		//rocket_sprite_accelerating = accelerating_sprite;
		//rocket_sprite_decelerating = decelerating_sprite;
	}

}
