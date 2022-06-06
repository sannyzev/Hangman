package menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import game.Alphabet;
import game.Levels;
import game.PopUp;
import game.WordTable;
import main.Panel;
import main.State;

public class Menu {

	public Panel panel;
	public int x, y; // at those coordinates the menu will be drawn
	
	public Button[] buttons; // array with buttons
	public int nrButtons; // number of buttons
	public int curButton; // current button
	
	public Menu(Panel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		buttons = new Button[10];
		nrButtons = 0;
		curButton = 0;
	}
	
	public void addButton(Button button) {
		buttons[nrButtons++] = button;
	}
	
	// This function paints the menu:
	public void paint(Graphics2D g2d) {
		// Preparing the font size:
		g2d.setFont(panel.font.deriveFont(45f));
		
		// Iterating through the buttons:
		for (int i = 0; i < nrButtons; i++) {
			if (i == curButton) { // the current button is painted a little bit different from the others
				g2d.setColor(new Color(200, 0, 0));
				g2d.drawImage(panel.mainButtonActive, x, y + i * 60, null);				
				g2d.drawString(
						buttons[i].str,
						(750 - g2d.getFontMetrics().stringWidth(buttons[i].str)) / 2,
						y + i * 60 + 50
				);
			}
			else {
				g2d.setColor(new Color(222, 222, 222));
				g2d.drawImage(panel.mainButton, x, y + i * 60, null); // draws the button image
				g2d.drawString(
						buttons[i].str,
						(750 - g2d.getFontMetrics().stringWidth(buttons[i].str)) / 2, // centering the text (x coordinate)
						y + i * 60 + 50 // current y
				);
			}
		}
	}
	
	// This method handles the key pressed events:
	public void onKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && curButton > 0) // updating the current button
			curButton--;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN && curButton < nrButtons - 1) // updating the current button
			curButton++;
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) { // clicks the current button
			Panel.playSound();
			if (buttons[curButton].state == State.GAME && this == panel.mainMenu) {
				// Creates a new game and initializes some things related to it...
				panel.levels = new Levels(panel, 20, 20);
				panel.alphabet = new Alphabet(panel, 200, 120);
				panel.wordTable = new WordTable(panel);
				panel.youWin = new PopUp(panel, 150, -150);
				panel.youLose = new PopUp(panel, 150, -150);
				panel.nrLevels = 0;
				panel.state = State.GAME;
			}
			else if (buttons[curButton].state == State.SETTINGS && this == panel.mainMenu) {
				// Creates the settings menu and changes the state:
				panel.settingsMenu = new SettingsMenu(panel, 225, 200);
				panel.state = State.SETTINGS;
			}
			else if (buttons[curButton].state == null) // that's the exit button - it closes the window
				panel.frame.dispatchEvent(new WindowEvent(panel.frame, WindowEvent.WINDOW_CLOSING));
			else // just changes the state
				panel.state = buttons[curButton].state;
		}
	}
	
	// Exactly the same thing, but with the mouse:
	public void onClick(MouseEvent e) {
		for (int i = 0; i < nrButtons; i++)
			// Tests if the cursor is between the bounds of the current button:
			if (y + i * 60 <= e.getY() && e.getY() <= y + i * 60 + 50 &&
					x <= e.getX() && e.getX() <= x + 300) {
				Panel.playSound();
				if (buttons[i].state == State.GAME && this == panel.mainMenu) {
					panel.levels = new Levels(panel, 20, 20);
					panel.alphabet = new Alphabet(panel, 200, 120);
					panel.wordTable = new WordTable(panel);
					panel.youWin = new PopUp(panel, 150, -150);
					panel.youLose = new PopUp(panel, 150, -150);
					panel.nrLevels = 0;
					panel.state = State.GAME;
				}
				else if (buttons[i].state == null)
					panel.frame.dispatchEvent(new WindowEvent(panel.frame, WindowEvent.WINDOW_CLOSING));
				else if (buttons[i].state == State.SETTINGS && this == panel.mainMenu) {
					panel.settingsMenu = new SettingsMenu(panel, 225, 200);
					panel.state = State.SETTINGS;
				}
				else
					panel.state = buttons[i].state;
				break;
			}
	}
	
	// Updates the current button according to the mouse coordinates:
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
