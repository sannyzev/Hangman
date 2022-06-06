package menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import game.WordTable;
import main.Panel;

// Almost the same thing with the Menu class:
public class SettingsMenu {

	// Those are the buttons for the settings menu:
	public SettingsButton[] buttons = {
			new SettingsButton(0, "EASY"),
			new SettingsButton(1, "MEDIUM"),
			new SettingsButton(2, "HARD"),
			new SettingsButton(-1, "SOUND ON")
	};
	
	public Panel panel;
	public int x, y;
	
	public int nrButtons;
	public int curButton;
	
	public SettingsMenu(Panel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		nrButtons = 4;
		curButton = 0;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.setFont(panel.font.deriveFont(45f));
		for (int i = 0; i < nrButtons; i++) {
			if (i == curButton) {
				g2d.setColor(new Color(200, 0, 0));
				g2d.drawImage(panel.mainButtonActive, x, y + i * 60, null);				
				g2d.drawString(
						buttons[i].name,
						(750 - g2d.getFontMetrics().stringWidth(buttons[i].name)) / 2,
						y + i * 60 + 50
				);
			}
			else {
				g2d.setColor(new Color(222, 222, 222));
				g2d.drawImage(panel.mainButton, x, y + i * 60, null);
				g2d.drawString(
						buttons[i].name,
						(750 - g2d.getFontMetrics().stringWidth(buttons[i].name)) / 2,
						y + i * 60 + 50
				);
			}
		}
	}
	
	public void onKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && curButton > 0)
			curButton--;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN && curButton < nrButtons - 1)
			curButton++;
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Panel.playSound();
			if (curButton == 3) { // turning on/off the sound:
				Panel.mute ^= true;
				if (Panel.mute)
					buttons[3].name = "SOUND OFF";
				else
					buttons[3].name = "SOUND ON";
			}
			else
				WordTable.difficulty = curButton;
		}
	}
	
	public void onClick(MouseEvent e) {
		for (int i = 0; i < nrButtons; i++)
			if (y + i * 60 <= e.getY() && e.getY() <= y + i * 60 + 50 &&
					x <= e.getX() && e.getX() <= x + 300) {
				Panel.playSound();
				if (curButton == 3) { // turning on/off the sound:
					Panel.mute ^= true;
					if (Panel.mute)
						buttons[3].name = "SOUND OFF";
					else
						buttons[3].name = "SOUND ON";
				}
				else
					WordTable.difficulty = curButton;
				break;
			}
	}
	
	public void onEnter() {
		int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX() - panel.frame.getX();
		int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY() - panel.frame.getY();

		for (int i = 0; i < nrButtons; i++)
			if (y + i * 60 + 40 <= mouseY && mouseY <= y + i * 60 + 90 &&
					x <= mouseX && mouseX <= x + 300) {
				curButton = i;
				break;
			}
	}
}
