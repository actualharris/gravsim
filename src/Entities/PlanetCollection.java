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
	public static Planet p0 = new Planet(100, 19, "Gallifrey", "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet1.png");
	public static Planet p1 = new Planet(200, 19, "Earth", "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet2.png");
	public static Planet p2 = new Planet(500, 43, "Mars", "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet3.png");
	public static Planet p3 = new Planet(100, 19, "Jupiter", "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet1.png");
	public static Planet p4 = new Planet(100, 19, "Neptune", "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet2.png");
}
