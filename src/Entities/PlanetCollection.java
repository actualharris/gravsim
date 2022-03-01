package Entities;

public class PlanetCollection {
	/*
		Class holding a collection of all available planets.
		New planets could be defined here
	*/

	// TODO: make planets, assign sprites
	// PROBLEM: Scaling of actual distance and mass etc. to distance on screen isn't done
	// 					This makes all the planets fall in a pile lol
	//					TODO: Do something about it
	public static Planet p0 = new Planet("Sun", 1.9891e30, 0.265474539, "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet1.png");
	public static Planet p1 = new Planet("Earth", 5.97219e24, 0.2263496, "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet2.png");
}
