package main;

import java.io.IOException;

import javax.swing.JFrame;

import Models.Level;
import Models.Player;
import businessLogic.GamePanel;
import businessLogic.LevelCatalogue;

public class MainApp {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("GravSim");
		
		// Implement menu logic here 
		// Menu returns level and player objects
		
		// These are sample values to test the rest of the code
		Player p = new Player();
		Level l = LevelCatalogue.levels[0];
		
		GamePanel gamepanel = new GamePanel(p,l);
		window.add(gamepanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamepanel.startGameThread();
		
	}

}
