package Gameplay;

import java.awt.Color;
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
	Rocket rocket;
	KeyHandler handler;
	GamePanel panel;
	
	public void setPlayerName(String name) {
		playerName = name;
	}

	/*
		Default constructor to set default player values
	*/
	public Player(GamePanel gp, KeyHandler kh) {
		playerName = "USR";
		playerPoints = 0;
		rocket = RocketCollection.r0;
		panel = gp;
		handler = kh;
	}

	/*
		Constructor
	*/
	Player(String pName, Rocket r, GamePanel gp, KeyHandler kh) {
		playerName = pName;
		playerPoints = 0;
		rocket = r;
		panel = gp;
		handler = kh;
	}

	public void update() {
		if (handler.upPressed == true) {
			// accelerate
		} else if (handler.downPressed == true) {
			// decelerate
		}
		// update velocity
	}
	
	public void draw(Graphics g) {
		this.rocket.setPos(300.0, 600.0);
		System.out.println((int) rocket.pos[0]+"   "+(int) rocket.pos[1]);
		g.setColor(Color.white);
		g.fillRect((int) rocket.pos[0],(int) rocket.pos[1], 10, 10);
	}
}
