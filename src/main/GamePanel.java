package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	/*
		Class to handle game loop
	*/

	// idk what this does, just that it gives an error if this isn't there
	private static final long serialVersionUID = 1L;

	// screen settings
	// can change, but this looks g
	final int screenWidth = 1280;
	final int screenHeight = 720;

	// class to handle user input
	KeyHandler keyH = new KeyHandler();
	// game thread
	Thread gameThread;

	// Player Position
	// TODO: change this based on level, i guess
	// but that's for later
	int playerX = screenWidth/2;
	int playerY = screenHeight/2;

	// FPS
	int FPS = 60;

	public GamePanel() {
		// preferred size of game window
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		// background of game window
		// TODO: change it to image of stars from assets
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		// add key evvent listener
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		/*
			Game loop
			uses delta time: https://drewcampbell92.medium.com/understanding-delta-time-b53bf4781a03
		*/
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		double lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;

			lastTime = currentTime;

			if (delta > 1) {
				update();
				repaint();
				delta--;
			}
		}
	}

	public void update() {
		// TODO: add this in
		// This method deals with updating positions of objects every game loop

	}

	public void paintComponent(Graphics g) {
		/*
			show player on screen ig
			TODO: make this paint all planet and rocket images
		*/
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, 10, 10);

		g2.dispose();
	}

}
