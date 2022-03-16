package Gameplay;

import Entities.Planet;
import Entities.PlanetCollection;

public class LevelCatalogue {
	/*
	 	Class containing a collection of available levels
	*/

	public static Level l0;

	private static Level setLevel(Planet[] planets, double[][] positions, double[][] velocities, double[] rpos, double[] rvel) {
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
		l.rocketPos = rpos;
		l.rocketVel = rvel;
		return l;
	}

	public LevelCatalogue() {
		Planet[] plist = new Planet[] {PlanetCollection.p0, PlanetCollection.p1, PlanetCollection.p2};
		//Planet[] plist = new Planet[] {PlanetCollection.p1};
		double[][] positions = new double[][] {{2, 2},{1,2},{1,1.52}};
		double[][] velocities = new double[][] {{0,0},{0,-30000},{0,-24070}};
		double[] rvel = new double[] {0,7778};
		double[] rpos = new double[] {(1*148.6e6 * 1000),(2*149.6e6 * 1000)};
		LevelCatalogue.l0 = setLevel(plist, positions, velocities,rpos,rvel);
	}
}
