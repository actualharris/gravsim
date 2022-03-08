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
	public static Planet p0 = new Planet("Sun", 1.9891e30, 0.004654745387385894, "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet1.png");
	public static Planet p1 = new Planet("Earth", 5.97219e24, 4.25875044705683e-05, "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet2.png");
	public static Planet p2 = new Planet("NotEarth", 6.41693e24, 2.265740800549227e-05, "C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\planets\\planet3.png");
}
