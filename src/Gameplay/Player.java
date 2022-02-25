package Gameplay;

import Entities.Rocket;
import Entities.RocketCollection;

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
		rocket = RocketCollection.r0;
	}
	
	Player(String pName, Rocket r) {
		playerName = pName;
		playerPoints = 0;
		rocket = r;
	}
	
}
