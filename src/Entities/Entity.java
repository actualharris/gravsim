package Entities;

import Physics.Physics;

public abstract class Entity {
	/*
		Class Entity defines any object in space that has a mass and some velocity.
	*/

	public double mass;     			// one double - mass of entity
	public double volume;   			// one double - volume of entity
	public double[] velocity = new double[2]; 			// array of 2 doubles - vx,vy
	public double[] pos = new double[2];      			// array of 2 doubles - sx,sy

	public void setPos(double x, double y) {
		/* set pos array values */
	}

	public void setVel(double x, double y) {
		/* set velocity array values */
	}
}
