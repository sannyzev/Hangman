package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Panel;

// Class about the alphabet of letters that you can click on:
public class Alphabet {

	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Panel panel;
	public int x, y;
	
	public int lives; // the number of remaining lives
	
	public Alphabet(Panel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		lives = 5;
	}
	
	public void paint(Graphics2D g2d) {		
		int x = panel.wordTable.x;
		int y = panel.wordTable.y;
		
		// Drawing every letter:
		g2d.setFont(panel.font.deriveFont(35f));
		for (int i = 0; i < 13; i++)
			if (!panel.wordTable.used[i]) {
				g2d.setColor(Color.BLACK);
				g2d.drawString(alphabet.substring(i, i + 1), x + 38 + i * 35 + (30 - g2d.getFontMetrics().stringWidth(alphabet.substring(i, i + 1))) / 2, y + 36);
			}
		for (int i = 13; i < 26; i++)
			if (!panel.wordTable.used[i]) {
				g2d.setColor(Color.BLACK);
				g2d.drawString(alphabet.substring(i, i + 1), x + 38 + (i - 13) * 35 + (30 - g2d.getFontMetrics().stringWidth(alphabet.substring(i, i + 1))) / 2, y + 80);
			}
	}
	
	// Handles clicks, just like the Menu class:
	public void onClick(MouseEvent e) {
		if (panel.youWin.visible || panel.youLose.visible)
			return;
		
		for (int i = 0; i < 13; i++)
			if (x + 38 + i * 35 <= e.getX() && e.getX() <= x + i * 35 + 83 &&
					y + 15 <= e.getY() && e.getY() <= y + 45) {
				Panel.playSound();
				if (!panel.wordTable.used[i]) {
					panel.wordTable.used[i] = true;
					if (panel.wordTable.needed[i])
						panel.wordTable.guessed[i] = true;
					else // wrong click
						lives--;
				}
				break;
			}
		
		for (int i = 13; i < 26; i++)
			if (x + 38 + (i - 13) * 35 <= e.getX() && e.getX() <= x + (i - 13) * 35 + 83 &&
					y + 55 <= e.getY() && e.getY() <= y + 85) {
				Panel.playSound();
				if (!panel.wordTable.used[i]) {
					panel.wordTable.used[i] = true;
					if (panel.wordTable.needed[i])
						panel.wordTable.guessed[i] = true;
					else
						lives--;
				}
				break;
			}
		check();
	}
	
	// Handles key pressed events:
	public void onKeyPressed(KeyEvent e) {
		if (panel.youWin.visible || panel.youLose.visible)
			return;
		
		Panel.playSound();
		// yeah...
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			if (!panel.wordTable.used     [0]) {
				panel.wordTable.used      [0] = true;
				if (panel.wordTable.needed[0])
					panel.wordTable.guessed[0] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_B:
			if (!panel.wordTable.used     [1]) {
				panel.wordTable.used      [1] = true;
				if (panel.wordTable.needed[1])
					panel.wordTable.guessed  [1] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_C:
			if (!panel.wordTable.used     [2]) {
				panel.wordTable.used      [2] = true;
				if (panel.wordTable.needed[2])
					panel.wordTable.guessed  [2] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_D:
			if (!panel.wordTable.used     [3]) {
				panel.wordTable.used      [3] = true;
				if (panel.wordTable.needed[3])
					panel.wordTable.guessed  [3] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_E:
			if (!panel.wordTable.used     [4]) {
				panel.wordTable.used      [4] = true;
				if (panel.wordTable.needed[4])
					panel.wordTable.guessed  [4] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_F:
			if (!panel.wordTable.used     [5]) {
				panel.wordTable.used      [5] = true;
				if (panel.wordTable.needed[5])
					panel.wordTable.guessed  [5] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_G:
			if (!panel.wordTable.used     [6]) {
				panel.wordTable.used      [6] = true;
				if (panel.wordTable.needed[6])
					panel.wordTable.guessed  [6] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_H:
			if (!panel.wordTable.used     [7]) {
				panel.wordTable.used      [7] = true;
				if (panel.wordTable.needed[7])
					panel.wordTable.guessed  [7] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_I:
			if (!panel.wordTable.used     [8]) {
				panel.wordTable.used      [8] = true;
				if (panel.wordTable.needed[8])
					panel.wordTable.guessed  [8] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_J:
			if (!panel.wordTable.used     [9]) {
				panel.wordTable.used      [9] = true;
				if (panel.wordTable.needed[9])
					panel.wordTable.guessed  [9] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_K:
			if (!panel.wordTable.used     [10]) {
				panel.wordTable.used      [10] = true;
				if (panel.wordTable.needed[10])
					panel.wordTable.guessed  [10] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_L:
			if (!panel.wordTable.used     [11]) {
				panel.wordTable.used      [11] = true;
				if (panel.wordTable.needed[11])
					panel.wordTable.guessed  [11] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_M:
			if (!panel.wordTable.used     [12]) {
				panel.wordTable.used      [12] = true;
				if (panel.wordTable.needed[12])
					panel.wordTable.guessed  [12] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_N:
			if (!panel.wordTable.used     [13]) {
				panel.wordTable.used      [13] = true;
				if (panel.wordTable.needed[13])
					panel.wordTable.guessed  [13] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_O:
			if (!panel.wordTable.used     [14]) {
				panel.wordTable.used      [14] = true;
				if (panel.wordTable.needed[14])
					panel.wordTable.guessed  [14] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_P:
			if (!panel.wordTable.used     [15]) {
				panel.wordTable.used      [15] = true;
				if (panel.wordTable.needed[15])
					panel.wordTable.guessed  [15] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_Q:
			if (!panel.wordTable.used     [16]) {
				panel.wordTable.used      [16] = true;
				if (panel.wordTable.needed[16])
					panel.wordTable.guessed  [16] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_R:
			if (!panel.wordTable.used     [17]) {
				panel.wordTable.used      [17] = true;
				if (panel.wordTable.needed[17])
					panel.wordTable.guessed  [17] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_S:
			if (!panel.wordTable.used     [18]) {
				panel.wordTable.used      [18] = true;
				if (panel.wordTable.needed[18])
					panel.wordTable.guessed  [18] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_T:
			if (!panel.wordTable.used     [19]) {
				panel.wordTable.used      [19] = true;
				if (panel.wordTable.needed[19])
					panel.wordTable.guessed  [19] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_U:
			if (!panel.wordTable.used     [20]) {
				panel.wordTable.used      [20] = true;
				if (panel.wordTable.needed[20])
					panel.wordTable.guessed  [20] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_V:
			if (!panel.wordTable.used     [21]) {
				panel.wordTable.used      [21] = true;
				if (panel.wordTable.needed[21])
					panel.wordTable.guessed  [21] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_W:
			if (!panel.wordTable.used     [22]) {
				panel.wordTable.used      [22] = true;
				if (panel.wordTable.needed[22])
					panel.wordTable.guessed  [22] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_X:
			if (!panel.wordTable.used     [23]) {
				panel.wordTable.used      [23] = true;
				if (panel.wordTable.needed[23])
					panel.wordTable.guessed  [23] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_Y:
			if (!panel.wordTable.used     [24]) {
				panel.wordTable.used      [24] = true;
				if (panel.wordTable.needed[24])
					panel.wordTable.guessed  [24] = true;
				else
					lives--;
			}
			break;
		case KeyEvent.VK_Z:
			if (!panel.wordTable.used     [25]) {
				panel.wordTable.used      [25] = true;
				if (panel.wordTable.needed[25])
					panel.wordTable.guessed[25] = true;
				else
					lives--;
			}
		}
		check();
	}
	
	// Checks if it's game over or not:
	public void check() {
		boolean ok = true;
		for (int i = 0; i < 26; i++)
			if (!panel.wordTable.guessed[i] && panel.wordTable.needed[i]) {
				ok = false;
				break;
			}
		
		if (ok) {
			panel.nrLevels++;
			panel.youWin.visible = true;
			panel.youWin.goDown();
		}
		else if (lives == 0) {
			panel.youLose.visible = true;
			panel.youLose.goDown();
		}
	}
}
