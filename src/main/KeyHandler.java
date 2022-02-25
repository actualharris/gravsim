package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	/*
		Class to handle user keypresses
	*/

	public boolean upPressed, downPressed;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			upPressed = true;
			// TODO: gotta handle player movements here, dk how.
			System.out.println("PRESSED UP");
		}
		if (code == KeyEvent.VK_DOWN) {
			downPressed = true;
			// TODO: gotta handle player movements here, dk how.
			System.out.println("PRESSED DOWN");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
	}

}
