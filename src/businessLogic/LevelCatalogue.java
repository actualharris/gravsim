package businessLogic;

import Models.Entity;
import Models.Level;
import Models.Planet;

public class LevelCatalogue {
	public static Level[] levels = new Level[10];
	public static int levCount = 0;
	
	private static void addLevel(String name, Entity[] objects, boolean rocket_move, boolean planets_move) {
		if (levCount < 10) {
			Level l = new Level(name, objects, rocket_move, planets_move);
			levels[levCount] = l;
			levCount += 1;
		}
	}
	
	{
		Planet p1 = new Planet("Sun", 1.9891e30, 696340, "C:\\Users\\sirdm\\Documents\\projects\\gravsim2\\assets\\images\\planets\\planet1.png", 200);
		Entity[] eList = new Entity[1];
		eList[0] = p1;
		addLevel("Basic", eList, true, false);
	}
	
}
