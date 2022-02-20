package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	// screen settings
	final int screenWidth = 1280;
	final int screenHeight = 720;
	
	Thread gameThread;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (gameThread != null) {
			//System.out.println("The game is on!");
			update();
			repaint();
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(100, 100, 10, 10);
		
		g2.dispose();
	}
	
}

/*
Menu:
	1. View scoreboard
	2. Play Game
	3. Exit
if (1):
	view_scoreboard();
		1. back to Menu
		2. exit
if (2):
	choose_playername();
	play_game();
		if (user_input) {
				if (fuel_available) {
					calculate_fuel_used();
					update_fuel_bar();
					update_velocity();
				}
		}
		for ( i in objects_in_play ) {
				for ( j in objects_in_play ) {
						tot_force = 0;
						if (i != j) {
								tot_force += i.getEffectiveForce(j);
								i.updateVel();
								i.updatePos();
						}
				}
				check_collision();
				if (collision) {
						if (velocity_of_rocket_wrt_collision_obj <= acceptable && collision_obj == goal_planet) {
								WIN!
						} else {
								LOSE :(
						}
				}
		}
*/

