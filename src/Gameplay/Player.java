package Gameplay;

import Entities.Rocket;

public class Player {
	String playerName;
	int playerPoints;
	Rocket rocket;
	
	public void setPlayerName(String name) {
		playerName = name;
	}
	
	Player() {
		playerName = "USR";
		playerPoints = 0;
	}
	
	Player(String pName) {
		playerName = pName;
		playerPoints = 0;
	}
	
}
