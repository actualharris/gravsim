package main;

import gravSimRenderer.Window;

public class MainApp {

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(1280, 720, "test");
		while (!window.shouldClose()) {
			window.updateWindow();
		}
		window.closeWindow();
	}

}
