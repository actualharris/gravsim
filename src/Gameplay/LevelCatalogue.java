package Gameplay;

import Entities.Planet;
import Entities.PlanetCollection;

public class LevelCatalogue {
	/*
	 	Class containing a collection of available levels
	*/
	
	public static Level l0, l1, l2, l3, l4;
	
	private static Level setLevel(Planet[] planets, double[][] positions, double[][] velocities) {
		Level l = new Level();
		for (int i = 0; i < planets.length; i++) {
			planets[i].setPos(positions[i][0], positions[i][1]);
			planets[i].setVel(velocities[i][0], velocities[i][1]);
		}
		l.addPlanets(planets);
		return l;
	}
	
	public LevelCatalogue() {
		Planet[] plist = new Planet[] {PlanetCollection.p0,PlanetCollection.p1};
		double[][] positions = new double[][] {{640, 360},{0,0}};
		double[][] velocities = new double[][] {{0,0},{0,0}};
		l0 = setLevel(plist, positions, velocities);
		
		plist = new Planet[] {PlanetCollection.p1,PlanetCollection.p2,PlanetCollection.p3,PlanetCollection.p0};
		positions = new double[][] {{0,0},{800,800},{40,800},{800,400}};
		velocities = new double[][] {{20,4},{50,32},{0,4},{5,21}};
		l1 = setLevel(plist, positions, velocities);
		
		plist = new Planet[] {PlanetCollection.p0,PlanetCollection.p1,PlanetCollection.p3,PlanetCollection.p1};
		positions = new double[][] {{0,0},{800,800},{40,800},{800,400}};
		velocities = new double[][] {{20,4},{50,32},{0,4},{5,21}};
		l2 = setLevel(plist, positions, velocities);
		
		plist = new Planet[] {PlanetCollection.p0,PlanetCollection.p1,PlanetCollection.p3,PlanetCollection.p1};
		positions = new double[][] {{0,0},{800,800},{40,800},{800,400}};
		velocities = new double[][] {{20,4},{50,32},{0,4},{5,21}};
		l3 = setLevel(plist, positions, velocities);
		
		plist = new Planet[] {PlanetCollection.p2,PlanetCollection.p1,PlanetCollection.p2,PlanetCollection.p1};
		positions = new double[][] {{0,0},{800,800},{40,800},{800,400}};
		velocities = new double[][] {{20,4},{50,32},{0,4},{5,21}};
		l4 = setLevel(plist, positions, velocities);
		
	}	
}
