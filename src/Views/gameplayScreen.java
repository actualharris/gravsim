package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Models.Entity;
import Models.Physics;
import Models.Planet;
import Models.Rocket;
import businessLogic.GamePanel;

public class gameplayScreen {
	private int offsetX = 0;
	private int offsetY = 0;

	private int fuelBarLen = 809;
	private int fuelBarx = 13;
	private int fuelBary = 670;
	private int fuelBarHeight = 30;

	private Color cyan = new Color(84,244,252);
	private Color red = new Color(224, 0, 37);
	
	Image background;
	Image playFrame;
	
	screenTranslator st_instance = new screenTranslator();
	public Physics physics = Physics.getInstance();

	public gameplayScreen(String background_path, String playframe_path) {
		try {
			background = ImageIO.read(new File(background_path));
			playFrame = ImageIO.read(new File(playframe_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateScale(double scaleFactor) {
		physics.updateScale(physics.scaleFactor+scaleFactor);
	}
	
	public void renderFuelBar(float fuelBarPercent, Graphics2D g) {
		/*TODO: draw the fuel bar*/
		if (fuelBarPercent <= 10) {
			g.setColor(red);
		} else {
			g.setColor(cyan);
		}
		g.fillRect(fuelBarx, fuelBary, (int) (fuelBarPercent*fuelBarLen/100), fuelBarHeight);
	}
	
	public int getOffetX() {
		return offsetX;
	}
	
	public int getOffetY() {
		return offsetY;
	}
	
	public void updateOffsetX(int val) {
		offsetX += val;
	}
	
	public void updateOffsetY(int val) {
		offsetY += val;
	}

	public void renderBackground(Graphics2D g, GamePanel observer) {
		g.drawImage(background, 0, 0, observer);
	}

	public void renderEntities(Entity[] entities_list, boolean rocket_exists, Graphics2D g, GamePanel observer) {
		/*TODO: for each entity, find the pixel value; draw it*/
		if (rocket_exists) {
			for (int i = 1; i < entities_list.length; i++) {
				Planet p = (Planet) entities_list[i];
				Image image_to_render = p.getPlanetSprite();
				int[] position = st_instance.convertPosToPixel(p.getPos()[0], p.getPos()[1], p.radius, offsetX, offsetY);
				//g.drawImage(image_to_render,position[0],position[1],null);
				g.drawImage(image_to_render, position[0], position[1], position[2]*2, position[2]*2, observer);
			}
			Rocket r = (Rocket) entities_list[0];
			Image rocket_img = rotate((BufferedImage) r.rocketSprite,physics.getAngle(r.getVel()[0], r.getVel()[1])+Math.PI/2);
			int[] rocket_pos = st_instance.convertPosToPixel(r.getPos()[0], r.getPos()[1], r.radius, offsetX, offsetY);
			//TODO: rocket acceleration animation 
			g.drawImage(rocket_img, rocket_pos[0], rocket_pos[1], rocket_pos[2]*2, rocket_pos[2]*2, observer);	
			//g.drawImage(rocket_img,rocket_pos[0],rocket_pos[1],null);
		} else {
			for (int i = 0; i < entities_list.length; i++) {
				Planet p = (Planet) entities_list[i];
				Image image_to_render = p.getPlanetSprite();
				int[] position = st_instance.convertPosToPixel(p.getPos()[0], p.getPos()[1], p.radius, offsetX, offsetY);
				g.drawImage(image_to_render, position[0], position[1], position[2]*2, position[2]*2, observer);
			}
		}
	}

	public void renderPlayFrame(Graphics2D g, GamePanel observer) {
		g.drawImage(playFrame, 0, 0, observer);
	}

	public void renderPlayerName(String name, Graphics2D g) {
		/*TODO: Render name of player on screen*/
		String name_to_print = name.substring(0, 3).toUpperCase();
		g.setColor(cyan);
		g.setFont(new Font("Agency FB", Font.PLAIN, 100));
		g.drawString(name_to_print, 1100, 700);
	}
	
	public void renderPlayDetails(double vel, double dist_travelled, double dist_togo, float time, int points, Graphics2D g) {
		String velString = String.format("%.2f",vel/1000);// + "km/s";
		String toGoString = String.format("%.0f",dist_togo/1e9);
		String travelledString = String.format("%04.0f",dist_travelled/1e9);
		time = (float)((Physics.timestep * 60 * time) / (3600*365.25*1000 * 25));
		String timeString = String.format("%.2f", time);
		String pointString = String.format("%05d", points);
		String velUnits = "km/s";
		String distUnits = "M km";
		String timeUnits = "yrs";
		g.setColor(cyan);
		g.setFont(new Font("Agency FB", Font.PLAIN, 50));
		g.drawString(velString, 15, 80);
		g.drawString(toGoString, 1110, 80);
		g.drawString(timeString,533,80);
		g.drawString(travelledString, 275, 80);
		g.drawString(pointString, 943, 660);
		g.setFont(new Font("Agency FB", Font.PLAIN, 20));
		g.drawString(velUnits, 100, 80);
		g.drawString(distUnits, 380, 80);
		g.drawString(timeUnits, 613, 80);
		g.drawString(distUnits, 1180, 80);
	}
	
	public BufferedImage rotate(BufferedImage image, double angle) {
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww - w) / 2, (newh - h) / 2);
	    g.rotate(angle, w / 2, h / 2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	}
	
	private static GraphicsConfiguration getDefaultConfiguration() {
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    return gd.getDefaultConfiguration();
	}

}
