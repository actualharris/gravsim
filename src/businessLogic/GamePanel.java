package businessLogic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import Controllers.keyHandler;
import Models.Level;
import Models.Player;
import Views.gameplayScreen;


public class GamePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	final int screenWidth = 1280;
	final int screenHeight = 720;
	
	keyHandler keyH = new keyHandler();

	Thread gameThread;

	private Player player;
	private Level level;
	private gameplayScreen screen = new gameplayScreen("C:\\Users\\sirdm\\Documents\\projects\\gravsim2\\assets\\images\\misc\\background.png","C:\\Users\\sirdm\\Documents\\projects\\gravsim2\\assets\\images\\misc\\play_frame.png");
	
	int FPS = 60;

	public GamePanel(Player player, Level level) {
		this.player = player;
		this.level = level;
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
		/* TODO: FILL THIS IN*/
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.screen.renderBackground(g2);
		this.screen.renderPlayFrame(g2);
		g2.dispose();
	}

}
