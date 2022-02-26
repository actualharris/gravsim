package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Gameplay.Level;
import Gameplay.LevelCatalogue;
import Gameplay.Player;

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

	// Instantiate a player.
	// A player contains the rocket, score and all that.
	Player player = new Player(this, keyH);

	// Select a level from the level catalogue.
	LevelCatalogue n = new LevelCatalogue();
	Level level = LevelCatalogue.l0;

	// FPS
	int FPS = 60;

	// Background graphics
	Image background;
	Image playFrame;
	{
		try {
			background = ImageIO.read(new File("C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\misc\\background.png"));
			playFrame = ImageIO.read(new File("C:\\Users\\sirdm\\Documents\\projects\\gravsim\\assets\\images\\misc\\play_frame.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GamePanel() {
		// preferred size of game window
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		// background of game window
		// TODO: change it to image of stars from assets
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		// add key event listener
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	/*
	Game loop
	uses delta time: https://drewcampbell92.medium.com/understanding-delta-time-b53bf4781a03
	*/
	@Override
	public void run() {

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

	/*
		This method deals with updation of positions of objects every gameloop
		player.update() updates position and velocity of the rocket
		level.upadte() updates the position and velocity of planets
		Returns: nothing
	*/
	public void update() {
		// This method deals with updating positions of objects every game loop
		this.player.update();
		//System.out.println(this.player.rocket.velocity[0]+"\t"+this.player.rocket.velocity[1]);
		this.level.update();
		for (int i = 0; i < level.planets.length; i++) {
			System.out.println(level.planets[i].planet_name+": "+level.planets[i].pos[0]+"\t"+level.planets[i].pos[1]);
		}
		System.out.println();
	}

	/*
		This method draws objects in the game window
		the background and play frame are drawn here, the planets and rocket
		are rendered using their respective class methods
	*/
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Drawing the starry background
		g.drawImage(this.background, 0, 0, this);

		// Drawing the planets
		for(int i = 0; i < level.planets.length; i++) {
			level.planets[i].draw(g2);
		}

		// Drawing the players
		player.draw(g2);

		// Drawing the console skeleton
		g.drawImage(this.playFrame, 0, 0, this);

		g2.dispose();
	}

}
