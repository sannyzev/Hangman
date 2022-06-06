package main;

// The thread class that repaints the panel and receives signals from mouse all the time:
public class Renderer implements Runnable {

	Panel panel;
	
	public Renderer(Panel panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		while (true) {
			panel.repaint();
			try {Thread.sleep(20);} catch (Exception e) {}
			
			// Checking the x and y of the mouse to update the buttons from menues:
			if (panel.state == State.MAIN)
				panel.mainMenu.onEnter();
			else if (panel.state == State.SETTINGS)
				panel.settingsMenu.onEnter();
		}
	}
}
