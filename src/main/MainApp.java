package main;

import java.io.IOException;

import javax.swing.JFrame;

public class MainApp {

	public static void main(String[] args) throws IOException {

		/*

		IDEAL GAME LOOP.
		NOT CODE, JUST IDEA.

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

		// Create new window
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("GravSim");

		// Create GamePanel object to handle game loop
		GamePanel gamePanel = new GamePanel(true, true);
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);

		// Start thread handling game
		gamePanel.startGameThread();
	}

}
