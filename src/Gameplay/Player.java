package Gameplay;

import java.awt.Graphics;

import Entities.Rocket;
import Entities.RocketCollection;
import main.GamePanel;
import main.KeyHandler;

public class Player {
	/*
		Class player defining the behaviors of a player
	*/

	String playerName;
	int playerPoints;
	public Rocket rocket;
	KeyHandler handler;
	GamePanel panel;

	public void setPlayerName(String name) {
		/*
			Method to set player name
		*/
		this.playerName = name;
	}

	public Player(GamePanel gp, KeyHandler kh) {
		/*
			Default constructor to set default player values
		*/
		this.playerName = "USR";
		this.playerPoints = 0;
		this.rocket = RocketCollection.r0;
		this.panel = gp;
		this.handler = kh;
	}

	Player(String pName, Rocket r, GamePanel gp, KeyHandler kh) {
		/*
			Constructor
		*/
		this.playerName = pName;
		this.playerPoints = 0;
		this.rocket = r;
		this.panel = gp;
		this.handler = kh;
	}

	public void update() {
		/*
			Method to update the player's velocity based on
			the user's key input
		*/
		if (handler.upPressed == true) {
			// accelerate
			this.rocket.accelerate();
		} else if (handler.downPressed == true) {
			// decelerate
			this.rocket.decelerate();
		}
	}

	public void draw(Graphics g) {
		/*
			Draw the player's rocket on the screen
		*/
		this.rocket.draw(g);
	}
}
