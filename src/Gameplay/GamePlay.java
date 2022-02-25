package Gameplay;

import Entities.Entity;

public class GamePlay {
	public static Entity[] objectsOnScreen;
	
	public void addObject(Entity o) {
		int len = objectsOnScreen.length;
		Entity[] objectsOnScreenNew = new Entity[len+1];
		for (int i = 0; i < len; i++) {
			objectsOnScreenNew[i] = objectsOnScreen[i];
		}
		objectsOnScreenNew[len] = o;
		objectsOnScreen = objectsOnScreenNew;
	}
	
}
