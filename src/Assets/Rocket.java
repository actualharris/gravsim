package Assets;

public class Rocket extends object {
	
	double fuel_percentage;
	
	public Rocket(double mass, double volume, double pos, double vel, double max_acceleration, double fuel_percentage) {
		mass=mass;
		volume=volume;
		vel = vel;
		pos = pos;
		max_acceleration = max_acceleration;
	}
	
	public void accelerate(boolean direction) {
		/* accelerate by max_acceleration */
		/* calculate velocity */
		/* call update_vel to update velocity */
		/* if direction == true, accelerate. Else, decelerate */
	}
}
