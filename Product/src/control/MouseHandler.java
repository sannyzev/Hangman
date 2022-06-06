package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.Panel;

// This class handles the mouse events:
public class MouseHandler implements MouseListener {
	
	public Panel panel;
	
	public MouseHandler(Panel panel) {
		this.panel = panel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		switch (panel.state) {
		case MAIN:
			panel.mainMenu.onClick(e);
			break;
			
		case SETTINGS:
			panel.backButtonHelp.onClick(e);
			panel.settingsMenu.onClick(e);
			break;
			
		case GAME:
			panel.alphabet.onClick(e);
			break;
			
		case HELP: case ABOUT:
			panel.backButtonHelp.onClick(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {	
	}
}
