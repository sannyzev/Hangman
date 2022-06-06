package menu;

// A simple class with information about the buttons from the settings menu:
public class SettingsButton {

	public int difficulty; // after the button is pressed, the difficulty changed to that
	public String name;
	
	public SettingsButton(int difficulty, String name) {
		this.difficulty = difficulty;
		this.name = name;
	}
}
