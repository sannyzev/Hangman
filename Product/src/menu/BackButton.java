package menu;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Panel;
import main.State;

// This class retains information about the back button:
public class BackButton {

	public Panel panel;
	public State backState; // the state to go back to
	
	public int x;
	public int y;
	
	public BackButton(Panel panel, State backState, int x, int y) {
		this.panel = panel;
		this.backState = backState;
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.drawImage(panel.backButton, x, y, null);
	}
	
	public void onKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE ||
			e.getKeyCode() == KeyEvent.VK_ENTER) {
				Panel.playSound();
				panel.state = backState;
		}
	}
	
	public void onClick(MouseEvent e) {
		if (x <= e.getX() && e.getX() <= x + 110 &&
			y <= e.getY() && e.getY() <= y + 110) {
				Panel.playSound();
				panel.state = backState;
		}
	}
}
