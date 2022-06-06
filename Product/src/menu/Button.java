package menu;

import main.State;

// A simple class with information about the buttons from the main menu:
public class Button {

	public Menu menu;
	public String str; // the string that is displayed on the button
	public State state; // the game state will be changed to this after the button is pressed
	
	public Button(Menu menu, State state, String str) {
		this.menu = menu;
		this.str = str;
		this.state = state;
	}
}
