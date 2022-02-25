package Gameplay;

import Entities.Rocket;
import Entities.RocketCollection;

public class Player {
	/*
		Class player defining the behaviors of a player
	*/

	String playerName;
	int playerPoints;
	Rocket rocket;

	public void setPlayerName(String name) {
		playerName = name;
	}

	/*
		Default constructor to set default player values
	*/
	Player() {
		playerName = "USR";
		playerPoints = 0;
		rocket = RocketCollection.r0;
	}

	/*
		Constructor
	*/
	Player(String pName, Rocket r) {
		playerName = pName;
		playerPoints = 0;
		rocket = r;
	}

	/*
		Method to handle player input
	*/
	public void playerInput() {
		
	}
}
