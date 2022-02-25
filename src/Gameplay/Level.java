package Gameplay;

import Entities.Planet;
import Entities.Rocket;

public class Level {
	Planet[] planets;
	Rocket rocket;
	int[] arenaDimensions = {1280,720};
	
	/*
	  Method to add planet to list of planets in plane
	*/
	public void addPlanet(Planet p) {
		// TODO: Add planet to array planets
	}
	
	public void addRocket(Rocket r) {
		rocket = r;
	}
	
	public void setArenaDimensions(int height, int width) {
		// TODO: Could also be {width, height}. Need to check that.
		arenaDimensions = new int[] {height, width};
	}
}
