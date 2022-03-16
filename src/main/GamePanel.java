package main;

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

import Physics.Physics;

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

	// Fuel bar
	int fuelBarLen = 809;
	int fuelBarx = 13;
	int fuelBary = 670;
	int fuelBarHeight = 30;
	
	// Offsets
	//int 
	
	// behavior
	boolean planetsMove;
	boolean rocketMoves;
	
	// FPS
	int FPS = 60;

	// offset
	int offsetX = 0;
	int offsetY = 0;
	
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

	public GamePanel(boolean rocketMoves, boolean planetsMove) {
		// preferred size of game window
		this.planetsMove = planetsMove;
		this.rocketMoves = rocketMoves;
		this.player.rocket.velocity = this.level.rocketVel;
		this.player.rocket.position = this.level.rocketPos;
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		// add key event listener
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
		/*
			This method deals with updation of positions of objects every gameloop
			player.update() updates position and velocity of the rocket
			level.upadte() updates the position and velocity of planets
			Returns: nothing
		*/
		
		// Panning
		if (this.keyH.wPressed == true) {
			this.offsetY -= 10;
		}
		if (this.keyH.aPressed == true) {
			this.offsetX -= 10;
		}
		if (this.keyH.sPressed == true) {
			this.offsetY += 10;
		}
		if (this.keyH.dPressed == true) {
			this.offsetX += 10;
		}
		if (this.keyH.zInPressed == true) {
			Physics.scaleFactor += 10;
			Physics.updateScale();
		}
		if (this.keyH.zOutPressed == true) {
			Physics.scaleFactor -= 10;
			Physics.updateScale();
		}
		
		if (this.rocketMoves) {
			this.player.update(this.level.planets);
			//System.out.println(this.player.rocket.position[0]+"\t"+this.player.rocket.position[1]);
		}
		if (this.planetsMove) {
			this.level.update();
		}
	}

	public void paintComponent(Graphics g) {
		/*
			This method draws objects in the game window
			the background and play frame are drawn here, the planets and rocket
			are rendered using their respective class methods
		*/

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Drawing the starry background
		g.drawImage(this.background, 0, 0, this);

		// Drawing the planets
		for(int i = 0; i < level.planets.length; i++) {
			//System.out.println("DRAWING:"+level.planets[i].planet_name);
			this.level.planets[i].draw(g2, this.offsetX, this.offsetY, this.screenWidth, this.screenHeight);
		}

		// Drawing the player
		this.player.draw(g2, this.fuelBarx, this.fuelBary, this.fuelBarHeight, this.fuelBarLen, offsetX, offsetY);
		
		
		// Drawing the console skeleton
		g.drawImage(this.playFrame, 0, 0, this);

		g2.dispose();
	}

}
