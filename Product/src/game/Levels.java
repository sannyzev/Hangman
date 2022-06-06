package game;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Panel;

// That's the bar with 5 circles which shows how many levels have you passed:
public class Levels {
	
	public Panel panel;
	public int x, y;
	
	public Levels(Panel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
	}
	
	// Just paints it:
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRoundRect(x - 5, y - 5, 210, 60, 40, 40);
		
		g2d.setColor(Color.GRAY);
		g2d.fillRoundRect(x, y, 200, 50, 30, 30);
		
		for (int i = 0; i < 5; i++)
			if (panel.nrLevels <= i) {
				g2d.setColor(Color.WHITE);
				g2d.fillOval(x + i * 40 + 5, y + 12, 30, 30);
			}
			else {
				g2d.setColor(Color.YELLOW);
				g2d.fillOval(x + i * 40 + 5, y + 12, 30, 30);
			}
	}
}
