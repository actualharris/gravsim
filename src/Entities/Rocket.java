package Entities;

import Physics.Physics;

public class Rocket extends object {
	
	double fuel_percentage;
	String rocket_sprite;
	String rocket_sprite_accelerating;
	String rocket_sprite_decelerating;
	double[] pos;
	double[] velocity;
	
	public Rocket(double mass, double max_acceleration, double fuel_percentage) {
		mass=mass;
		max_acceleration = max_acceleration;
		fuel_percentage = fuel_percentage;
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
		rocket_sprite = sprite;
		rocket_sprite_accelerating = accelerating_sprite;
		rocket_sprite_decelerating = decelerating_sprite;
	}
	
	public boolean didCollide(Planet o) {
		double dist = Physics.getDistance(pos[0],pos[1],o.pos[0],o.pos[1]);
		if(dist < o.getRadius()) {
			return true;
		}
		return false;
	}
}
