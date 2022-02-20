package main;

import javax.swing.JFrame;

public class MainApp {

	public static void main(String[] args) {
		
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

		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("GravSim");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
