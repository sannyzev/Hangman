package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Panel;
import main.State;

// This class handles the keyboard events:
public class KeyHandler implements KeyListener {

	public Panel panel;
	
	public KeyHandler(Panel panel) {
		this.panel = panel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (panel.state) {
		case MAIN:
			panel.mainMenu.onKeyPressed(e);
			break;
			
		case SETTINGS:
			panel.settingsMenu.onKeyPressed(e);
			panel.backButtonHelp.onKeyPressed(e);
			break;
			
		case GAME:
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				panel.state = State.MAIN;
			else
				panel.alphabet.onKeyPressed(e);
			break;
			
		case HELP: case ABOUT:
			panel.backButtonHelp.onKeyPressed(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
}
