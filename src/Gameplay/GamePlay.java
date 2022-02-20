package Gameplay;

import Assets.object;

public class GamePlay {
	String playerName;
	int playerPoints;
	public static object[] objectsOnScreen;
	
	public void setPlayerName(String name) {
		playerName = name;
	}
	
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
