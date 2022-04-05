package Views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class scoreboardView {
	Image background, frame;
	
	scoreboardView(String background_path, String frame_path) {
		try {
			background = ImageIO.read(new File(background_path));
			frame = ImageIO.read(new File(frame_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void displayScoreboard(String[] names, int[] scores, Graphics2D g) {
		/*TODO: Given names and scores of players, display them on the screen
		        Assume that the player names and scores correspond to each other and
		 		are already in the required order. 
		 		Index 0 displays on top, and index n at the bottom.
		 		In case more than 10 names are passed as argument, display only top 10
		*/ 
	}
	
}
