package Entities;

import Physics.Physics;

public class Rocket extends object {
	
	double fuel_percentage;
	
	public Rocket(double mass, double volume, double[] pos, double[] vel, double max_acceleration, double fuel_percentage) {
		mass=mass;
		volume=volume;
		vel = vel;
		pos = pos;
		max_acceleration = max_acceleration;
	}
	
	public Rocket(Rocket r) {
		mass = r.mass;
		volume = r.volume;
		max_acceleration = r.max_acceleration;
	}
	
	public void setFuelPercentage(float percentage) {
		fuel_percentage = percentage;
	}
	
	public void accelerate(boolean direction) {
		/* accelerate by max_acceleration */
		/* calculate velocity */
		/* call update_vel to update velocity */
		/* if direction == true, accelerate. Else, decelerate */
	}
	
	public boolean didCollide(Planet o) {
		double dist = Physics.getDistance(pos[0],pos[1],o.pos[0],o.pos[1]);
		if(dist < o.getRadius()) {
			return true;
		}
		return false;
	}
}
