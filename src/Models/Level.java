package Models;

public class Level {
	String levelName;
	Entity[] entities;
	boolean rocketMove;
	boolean planetsMove;
	
	public Level(String name, Entity[] objects, boolean rocket_move, boolean planets_move) {
		this.levelName = name;
		this.entities = objects;
		this.rocketMove = rocket_move;
		this.planetsMove = planets_move;
	}
}	

