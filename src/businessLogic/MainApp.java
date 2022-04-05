package businessLogic;

import java.io.IOException;

import javax.swing.JFrame;

public class MainApp {
	
	static boolean exitFlag = false;
	
	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("GravSim");
		
		while (!exitFlag) {
			// take input from user
			// store it in exitFlag
			// switch condition
			// switch (exitFlag)
			// case 1: scoreboard();
			// case 2: play_game();
		}
		
	}

}
