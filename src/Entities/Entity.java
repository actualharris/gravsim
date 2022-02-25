package Entities;

import Physics.Physics;

public abstract class Entity {
	/*
		Class Entity defines any object in space that has a mass and some velocity.
	*/

	public double mass;     			// one double - mass of entity
	public double volume;   			// one double - volume of entity
	public double[] velocity; 			// array of 2 doubles - vx,vy
	public double[] pos;      			// array of 2 doubles - sx,sy

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

	public double[] getEffectiveForce(Entity o) {
		/*
			Get effective force acting on an object
		*/
		return Physics.gravForce(mass, o.mass, velocity[0], velocity[1], o.velocity[0], o.velocity[1]);
	}

	public void updateVel(double[] net_force, double t) {
		/*
			Calls the physics newVel method
			Updates the velocity of the object.
			Doesn't return anything.
		*/
		double[] new_velocity = Physics.newVel(velocity[0], velocity[1], net_force, mass, t);
		setVel(new_velocity[0],new_velocity[1]);
	}

	public void updatePos(double[] net_force, double t) {
		/*
			Calls the physics newVel and newPos methods
			Updates the position of the object.
			Doesn't return anything.
		*/
		double[] new_velocity = Physics.newVel(velocity[0], velocity[1], net_force, mass, t);
		double[] new_position = Physics.newPos(velocity[0], velocity[1], new_velocity[0], new_velocity[1], net_force, mass);
		setPos(new_position[0],new_position[1]);
	}

}
