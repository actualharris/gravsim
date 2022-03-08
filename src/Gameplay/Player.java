package Gameplay;

import java.awt.Color;
import java.awt.Graphics;

import Entities.Planet;
import Entities.Rocket;
import Entities.RocketCollection;
import Physics.Physics;
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

	public void update(Planet[] p) {
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
		//System.out.println(this.rocket.position[0]+"\t"+this.rocket.position[1]);
		double total_fx = 0;
		double total_fy = 0;
		for (int i = 0; i < p.length; i++) {
			double[] force = Physics.gravForce(p[i].mass,this.rocket.mass,p[i].position, this.rocket.position);
			double force_x = force[0];
			double force_y = force[1];
			//System.out.println(force_x+"\t"+force_y);
			total_fx += force_x;
			total_fy += force_y;
		}
		//System.out.println();
		//System.out.println(total_fx+"\t"+total_fy);
		//System.out.println(Physics.newVel(total_fx,this.rocket.mass)+"\t"+Physics.newVel(total_fy,this.rocket.mass));
		this.rocket.velocity[0] += Physics.newVel(total_fx,this.rocket.mass);
		this.rocket.velocity[1] += Physics.newVel(total_fy,this.rocket.mass);
		//System.out.println(this.rocket.velocity[0]+"\t"+this.rocket.velocity[1]);

		this.rocket.position[0] += Physics.newPos(this.rocket.velocity[0]);
		this.rocket.position[1] += Physics.newPos(this.rocket.velocity[1]);

	}

	public void draw(Graphics g, int fuelBarx, int fuelBary, int fuelBarHeight, int fuelBarLen, int offsetX, int offsetY) {
		/*
			Draw the player's rocket on the screen
		*/
		this.rocket.draw(g, offsetX, offsetY);
		if (this.rocket.fuel_percentage <= 10) {
			g.setColor(new Color(224, 0, 37));
		} else {
			g.setColor(new Color(82, 243, 255));
		}
		g.fillRect(fuelBarx, fuelBary, (int) (this.rocket.fuel_percentage*fuelBarLen/100), fuelBarHeight);

	}
}
