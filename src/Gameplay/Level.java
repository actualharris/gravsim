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
	int[] arenaDimensions = {1280,720};

	public void addPlanets(Planet[] p) {
		/*
			Method to add planet to list of planets in plane
		*/
		this.planets = new Planet[p.length];
		for (int i = 0; i < p.length; i++) {
			planets[i] = p[i];
		}
	}

	public void setArenaDimensions(int height, int width) {
		/*
			Set dimensions of arena
			This ISN'T the screen width.
		*/
		// TODO: Could also be {width, height}. Need to check that.
		arenaDimensions = new int[] {height, width};
	}

	public void update() {
		double[][] new_positions = new double[this.planets.length][2];
		double[][] new_velocities = new double[this.planets.length][2];
		for (int i = 0; i < this.planets.length; i++) {
			for (int j = 0; j < this.planets.length; j++) {
				if (i != j) {
					double[] force = new double[2];
					force = Physics.gravForce(this.planets[i].mass,this.planets[j].mass,this.planets[i].velocity[0],this.planets[i].velocity[1],this.planets[j].velocity[0],this.planets[j].velocity[1]);
					double[] newVelocity = new double[2];
					newVelocity = Physics.newVel(this.planets[i].velocity[0], this.planets[i].velocity[1], force, this.planets[i].mass, 1);
					double[] newPosition = new double[2];
					newPosition = Physics.newPos(this.planets[i].velocity[0], this.planets[i].velocity[1], newVelocity[0], newVelocity[1], force, this.planets[i].mass);
					new_positions[i] = newPosition;
					new_velocities[i] = newVelocity;
				}
			}
		}
		for (int i = 0; i < this.planets.length; i++) {
			this.planets[i].setPos(new_positions[i][0], new_positions[i][1]);
			this.planets[i].setVel(new_velocities[i][0], new_velocities[i][1]);
		}
	}
}
