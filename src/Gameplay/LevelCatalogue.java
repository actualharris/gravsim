package Gameplay;

import Entities.Planet;
import Entities.PlanetCollection;

public class LevelCatalogue {
	/*
	 	Class containing a collection of available levels
	*/

	public static Level l0;

	private static Level setLevel(Planet[] planets, double[][] positions, double[][] velocities) {
		/*
			Create a new levvel object
			Initiallze it with the provided planets and their initial positions and velocities
			Returns: Level object
		*/
		Level l = new Level();
		for (int i = 0; i < planets.length; i++) {
			planets[i].setPos(positions[i][0], positions[i][1]);
			planets[i].setVel(velocities[i][0], velocities[i][1]);
		}
		l.addPlanets(planets);
		return l;
	}

	public LevelCatalogue() {
		Planet[] plist = new Planet[] {PlanetCollection.p0, PlanetCollection.p1};
		double[][] positions = new double[][] {{2, 2},{1,2}};
		double[][] velocities = new double[][] {{0,0},{0,-30000}};
		this.l0 = setLevel(plist, positions, velocities);
	}
}
