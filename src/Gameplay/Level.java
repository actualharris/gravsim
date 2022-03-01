package Gameplay;

import Entities.Planet;
import Physics.Physics;

public class Level {
	/*
		Class level contains all planets (non playable objects)
			and their positions in a level
		It is also responsible for updating forces acting on them
			their velocities, etc.
	*/

	public Planet[] planets;
	int[] arenaDimensions = {(int) (Physics.AstronomicalUnit*20),(int) (Physics.AstronomicalUnit*20)};;

	public void addPlanets(Planet[] p) {
		/*
			Method to add planet to list of planets in plane
		*/
		this.planets = new Planet[p.length];
		for (int i = 0; i < p.length; i++) {
			this.planets[i] = p[i];
		}
	}

	public void setArenaDimensions(int height, int width) {
		/*
			Set dimensions of arena
			This ISN'T the screen width.
			// height and wodth in AU
		*/
		// TODO: Could also be {width, height}. Need to check that.
		this.arenaDimensions = new int[] {(int) (height*Physics.AstronomicalUnit),(int) (width*Physics.AstronomicalUnit)};
	}

	public void update() {
		/*
			Updates position and velocities of all planets in the level
			Based on all other planets in the level
		*/
		if (this.planets.length > 1) {
      for (int i = 0; i < this.planets.length; i++) {
      	double total_fx = 0;
      	double total_fy = 0;
      	for (int j = 0; j < this.planets.length; j++) {
	    		if (i != j) {		// If it isn't the same planet, cos that would mean distance = 0
	    			double[] force = Physics.gravForce(this.planets[i].mass, this.planets[j].mass, this.planets[i].position, this.planets[j].position);
	    			double force_x = force[0];
	    			double force_y = force[1];
	    			total_fx += force_x;
	    			total_fy += force_y;
	    		}
	    	}
	    	this.planets[i].velocity[0] += Physics.newVel(total_fx, this.planets[i].mass);
	    	this.planets[i].velocity[1] += Physics.newVel(total_fy, this.planets[i].mass);

	    	this.planets[i].position[0] += Physics.newPos(this.planets[i].velocity[0]);
	    	this.planets[i].position[1] += Physics.newPos(this.planets[i].velocity[1]);
    	}
  	}
	}
}
