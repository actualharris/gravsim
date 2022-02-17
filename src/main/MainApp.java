package main;

import gravSimRenderer.Window;

public class MainApp {

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(1280, 720, "test");
		while (!window.shouldClose()) {
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
			window.updateWindow();
		}
		window.closeWindow();
	}

}
