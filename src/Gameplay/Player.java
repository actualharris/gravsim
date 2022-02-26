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

	//player.updatePos()

	public void update() {
		if (handler.upPressed == true) {
			// accelerate
			this.rocket.accelerate();
		} else if (handler.downPressed == true) {
			// decelerate
			this.rocket.decelerate();
		}
	}

	public void draw(Graphics g) {
		//g.setColor(Color.white);
		//g.fillRect((int) rocket.pos[0],(int) rocket.pos[1], 10, 10);
		//g.drawImage(rocket.rocket_sprite, (int)rocket.pos[0], (int)rocket.pos[1], 80, 80, null);
		this.rocket.draw(g);
	}
}
