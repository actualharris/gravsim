package Views;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.Entity;

public class gameplayScreen {
	int offsetX = 0;
	int offsetY = 0;
	
	int fuelBarLen = 809;
	int fuelBarx = 13;
	int fuelBary = 670;
	int fuelBarHeight = 30;
	
	Image background;
	Image playFrame;
	
	public gameplayScreen(String background_path, String playframe_path) {
		try {
			background = ImageIO.read(new File(background_path));
			playFrame = ImageIO.read(new File(playframe_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void renderFuelBar(float fuelBarPercent, Graphics2D g) {
		/*TODO: draw the fuel bar*/
		if (fuelBarPercent <= 10) {
			g.setColor(new Color(224, 0, 37));
		} else {
			g.setColor(new Color(82, 243, 255));
		}
		g.fillRect(fuelBarx, fuelBary, (int) (fuelBarPercent*fuelBarLen/100), fuelBarHeight);
	}
	
	public void renderBackground(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
	}
	
	public void renderOnScreen(Entity[] entities_list, Graphics2D g) {
		/*TODO: for each entity, find the pixel value; draw it*/
	}
	
	public void renderPlayFrame(Graphics2D g) {
		g.drawImage(playFrame, 0, 0, null);
	}
	
	public void renderPlayerName(String name, Graphics2D g) {
		/*TODO: Render name of player on screen*/
	}
	
}
