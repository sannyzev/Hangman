package game;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Panel;

public class WordTable {

	public Panel panel;
	public Word word; // the current word
	public static int difficulty = 0; // the current game difficulty
	
	public int x;
	public int y;
	
	public boolean[] guessed = new boolean[26]; // guessed letters
	public boolean[] needed = new boolean[26]; // needed letters
	public boolean[] used = new boolean[26]; // used letters
	
	public WordTable(Panel panel) {
		this.panel = panel;
		this.word = Word.words[difficulty][(int) (Math.random() * 10000.0) % Word.nrWords]; // chooses a random word from the dictionary
		
		x = panel.alphabet.x;
		y = panel.alphabet.y;
		
		// Initializing the boolean arrays...
		for (int i = 0; i < 26; i++) {
			guessed[i] = false;
			needed[i] = false;
			used[i] = false;
		}
		
		// Initializing the needed array:
		for (int i = 0; i < word.str.length(); i++)
			if ('A' <= word.str.charAt(i) && word.str.charAt(i) <= 'Z')
				needed[word.str.charAt(i) - 'A'] = true;
	}
	
	// Paints the "word table":
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.setFont(panel.font.deriveFont(30f));
		g2d.drawImage(panel.menu, x, y, null);

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 14; j++) {
				int k = 14 * i + j; // the current letter position
				// Draws the letter if necessary:
				if (!('A' <= word.str.charAt(k) && word.str.charAt(k) <= 'Z') || guessed[word.str.charAt(k) - 'A'])
					g2d.drawString(word.str.substring(k, k + 1), x + 18 + (int) (j * 35.4) + (30 - g2d.getFontMetrics().stringWidth(word.str.substring(k, k + 1))) / 2, y + i * 43 + 160);
			}
		
		// Draws the hint:
		g2d.setColor(Color.RED);
		g2d.drawString(word.hint, x + 110 + (300 - g2d.getFontMetrics().stringWidth(word.hint)) / 2, y + 115);
	}
}
