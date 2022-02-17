package Assets;

import Physics.Physics;

public abstract class object {
	public double mass;     			// one double - mass of rocket
	public double volume;   			// one double - volume of rocket
	public double[] velocity; 			// array of 2 doubles - vx,vy
	public double[] pos;      			// array of 2 doubles - sx,sy
	public double max_acceleration; 	// one double - maximum acceleration of a rocket

	public void setPos(double x, double y) {
		/* set pos array values */
		pos[0] = x;
		pos[1] = y;
	}

	public void setVel(double x, double y) {
		/* set velocity array values */
		velocity[0] = x;
		velocity[1] = y;
	}

	public double[] getEffectiveForce(object o) {
		return Physics.gravForce(mass, o.mass, velocity[0], velocity[1], o.velocity[0], o.velocity[1]);
	}

	public void updateVel(double[] net_force) {
		// TODO: change 1 to some value of t
		double[] new_velocity = Physics.newVel(velocity[0], velocity[1], net_force, mass, 1);
		setVel(new_velocity[0],new_velocity[1]);
		// TODO: add collision check. Maybe not here though?
	}

	public void updatePos(double[] net_force) {
		// TODO: change 1 to some value of t
		double[] new_velocity = Physics.newVel(velocity[0], velocity[1], net_force, mass, 1);
		double[] new_position = Physics.newPos(velocity[0], velocity[1], new_velocity[0], new_velocity[1], net_force, mass);
		//setVel(new_velocity[0],new_velocity[1]);
		setPos(new_position[0],new_position[1]);
		// TODO: add collision check. Maybe not here though?
	}

}
