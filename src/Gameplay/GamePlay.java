package Gameplay;

import Entities.object;

public class GamePlay {
	public static object[] objectsOnScreen;
	
	public void addObject(object o) {
		int len = objectsOnScreen.length;
		object[] objectsOnScreenNew = new object[len+1];
		for (int i = 0; i < len; i++) {
			objectsOnScreenNew[i] = objectsOnScreen[i];
		}
		objectsOnScreenNew[len] = o;
		objectsOnScreen = objectsOnScreenNew;
	}
	
}
