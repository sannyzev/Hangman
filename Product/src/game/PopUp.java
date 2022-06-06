package game;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Panel;

// A class about the pop-ups (YOU LOSE and YOU WIN):
public class PopUp {
	
	public Panel panel;
	public int x, y;
	public boolean visible;
	
	public PopUp(Panel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.visible = false;
	}
	
	// Paints it:
	public void paint(Graphics2D g2d) {
		if (visible) {
			g2d.setColor(Color.BLACK);
			g2d.fillRoundRect(x - 5, y - 5, 410, 110, 40, 40);
			
			g2d.setColor(new Color(0, 204, 153));
			g2d.fillRoundRect(x, y, 400, 100, 30, 30);
			
			if (this == panel.youWin) {
				g2d.setColor(Color.BLACK);
				g2d.drawString("You win!", x + 130, y + 60);
			}
			else {
				g2d.setColor(Color.BLACK);
				g2d.drawString("You lose!", x + 120, y + 60);
			}
		}
	}
	
	// This starts the pop-up to go down:
	public void goDown() {
		(new Thread(new GoDownThread(this))).start();
	}
}
