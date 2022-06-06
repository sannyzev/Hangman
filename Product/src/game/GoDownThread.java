package game;

import main.State;

// This thread makes a pop-up to "go down":
public class GoDownThread implements Runnable {
	
	public PopUp popUp;
	
	public GoDownThread(PopUp popUp) {
		this.popUp = popUp;
	}
	
	@Override
	public void run() {
		// Every 5 milliseconds the pop-up goes down with 1 pixel:
		for (int i = 0; i < 300; i++) {
			try {Thread.sleep(5);} catch (Exception e) {}
			popUp.y++;
		}
		
		// After 3 seconds it disappears:
		try {Thread.sleep(3000);} catch (Exception e) {}
		
		// It decides what to do next:
		if (popUp == popUp.panel.youWin && popUp.panel.nrLevels < 5) {
			// If you win, it generates the next level:
			popUp.panel.levels = new Levels(popUp.panel, 20, 20);
			popUp.panel.alphabet = new Alphabet(popUp.panel, 200, 120);
			popUp.panel.wordTable = new WordTable(popUp.panel);
			popUp.panel.youWin = new PopUp(popUp.panel, 150, -150);
			popUp.panel.youLose = new PopUp(popUp.panel, 150, -150);
		}
		else if (popUp == popUp.panel.youLose || popUp.panel.nrLevels >= 5) {
			// If you lose, it goes to the main menu:
			popUp.panel.nrLevels = 0;
			popUp.panel.state = State.MAIN;
		}
	}
}