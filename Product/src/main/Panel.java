package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.KeyHandler;
import control.MouseHandler;
import game.Alphabet;
import game.Levels;
import game.PopUp;
import game.Word;
import game.WordTable;
import menu.BackButton;
import menu.Button;
import menu.Menu;
import menu.SettingsMenu;

// The main class, which stores a lot of information about the game:
@SuppressWarnings("serial")
public class Panel extends JPanel {

	public JFrame frame;
	public Renderer renderer;
	
	public SettingsMenu settingsMenu;
	public Menu mainMenu;
	public State state;
	
	public WordTable wordTable;
	public Alphabet alphabet;
	public Levels levels;
	
	public BufferedImage menu;
	public BufferedImage mainBackGround;
	public BufferedImage gameBackGround;
	
	public BufferedImage mainButton;
	public BufferedImage mainButtonActive;
	public BufferedImage backButton;
	
	public BufferedImage cross;
	public BufferedImage crossActive;
	
	public Font font;
	public BackButton backButtonHelp;
	
	public PopUp youWin;
	public PopUp youLose;

	public int nrLevels; // the current number of levels passed
	public BufferedImage[] stickman;
	
	public static boolean mute = false;
	public static AudioInputStream audio;
	
	public Panel() {
		// In the constructor we load our resources (images).
		// The custom font:
		try {font = Font.createFont(Font.TRUETYPE_FONT, new File("res/upheavtt.ttf"));} catch (Exception e) {}
		
		// Cross signs:
		try {cross            = ImageIO.read(new File("res/cross.png"           ));} catch (Exception e) {}
		try {crossActive      = ImageIO.read(new File("res/crossActive.png"     ));} catch (Exception e) {}
		
		// Background and menu:
		try {menu             = ImageIO.read(new File("res/menu.png"            ));} catch (Exception e) {}
		try {mainBackGround   = ImageIO.read(new File("res/mainBackGround.png"  ));} catch (Exception e) {}
		try {gameBackGround   = ImageIO.read(new File("res/gameBackGround.png"  ));} catch (Exception e) {}		
		
		// Buttons:
		try {mainButton       = ImageIO.read(new File("res/mainButton.png"      ));} catch (Exception e) {}
		try {mainButtonActive = ImageIO.read(new File("res/mainButtonActive.png"));} catch (Exception e) {}
		try {backButton       = ImageIO.read(new File("res/backButton.png"      ));} catch (Exception e) {}
		
		// The stickman array:
		stickman = new BufferedImage[6];
		try {stickman[0] = ImageIO.read(new File("res/stickman0.png"));} catch (Exception e) {}
		try {stickman[1] = ImageIO.read(new File("res/stickman1.png"));} catch (Exception e) {}
		try {stickman[2] = ImageIO.read(new File("res/stickman2.png"));} catch (Exception e) {}
		try {stickman[3] = ImageIO.read(new File("res/stickman3.png"));} catch (Exception e) {}
		try {stickman[4] = ImageIO.read(new File("res/stickman4.png"));} catch (Exception e) {}
		try {stickman[5] = ImageIO.read(new File("res/stickman5.png"));} catch (Exception e) {}
		
		// Creating the back button:
		backButtonHelp = new BackButton(this, State.MAIN, 600, 325);
		
		// Creating the main menu and adding buttons to it:
		mainMenu = new Menu(this, 225, 120);
		mainMenu.addButton(new Button(mainMenu, State.GAME    , "PLAY"    ));
		mainMenu.addButton(new Button(mainMenu, State.SETTINGS, "SETTINGS"));
		mainMenu.addButton(new Button(mainMenu, State.ABOUT   , "ABOUT"   ));
		mainMenu.addButton(new Button(mainMenu, State.HELP    , "HELP"    ));
		mainMenu.addButton(new Button(mainMenu, null          , "EXIT"    ));

		// Adding keyboard and mouse listeners:
		addKeyListener(new KeyHandler(this));
		addMouseListener(new MouseHandler(this));
		setFocusable(true);
		
		// Initializing the dictionary and game state:
		Word.initWords();
		state = State.MAIN;
	}
	
	// This method initializes the frame object:
	public void setFrame() {
		frame = new JFrame("HANGMAN");
		frame.add(this);
		frame.setSize(750, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Starting the rendering thread:
		renderer = new Renderer(this);
		renderer.run();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		// For sharpness:
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Drawing things according to the state:
		switch (state) {
		case MAIN:
			g2d.drawImage(mainBackGround, 0, 0, null);
			g2d.setColor(Color.WHITE);
			g2d.setFont(font.deriveFont(100f));
			g2d.drawString("HANGMAN", (750 - g2d.getFontMetrics().stringWidth("HANGMAN")) / 2, 80);
			
			mainMenu.paint(g2d);
			break;
			
		case HELP:
			g2d.drawImage(mainBackGround, 0, 0, null);
			g2d.setColor(Color.WHITE);
			g2d.setFont(font.deriveFont(100f));
			g2d.drawString("HOW TO PLAY", (750 - g2d.getFontMetrics().stringWidth("HOW TO PLAY")) / 2, 80);
			
			g2d.setFont(font.deriveFont(20f));
			g2d.drawString("Guess the hidden phrase to complete a level. You can", (750 - g2d.getFontMetrics().stringWidth("Guess the hidden phrase to complete a level. You can")) / 2, 150);
			g2d.drawString("select letters by either clicking on the letter buttons", (750 - g2d.getFontMetrics().stringWidth("select letters by either clicking on the letter buttons")) / 2, 175);
			g2d.drawString("above the puzzle or by using your keyboard. You are only", (750 - g2d.getFontMetrics().stringWidth("above the puzzle or by using your keyboard. You are only")) / 2, 200);
			g2d.drawString("allowed 5 wrong guesses per puzzle. The indicator on the", (750 - g2d.getFontMetrics().stringWidth("allowed 5 wrong guesses per puzzle. The indicator on the")) / 2, 225);
			g2d.drawString("top left corner of the screen will show you how many puzzles", (750 - g2d.getFontMetrics().stringWidth("top left corner of the screen will show you how many puzzles")) / 2, 250);
			g2d.drawString("you have completed. Complete 5 and You'll be victorious!", (750 - g2d.getFontMetrics().stringWidth("you have completed. Complete 5 and You'll be victorious!")) / 2, 275);
			
			backButtonHelp.paint(g2d);
			break;
			
		case ABOUT:
			g2d.drawImage(mainBackGround, 0, 0, null);
			g2d.setColor(Color.WHITE);
			g2d.setFont(font.deriveFont(100f));
			g2d.drawString("ABOUT", (750 - g2d.getFontMetrics().stringWidth("ABOUT")) / 2, 80);
			
			g2d.setFont(font.deriveFont(25f));
			g2d.drawString("This game was created for students to get used to", (750 - g2d.getFontMetrics().stringWidth("This game was created for students to get used to")) / 2, 150);
			g2d.drawString("their vocabulary in a more efficient and joyful way.", (750 - g2d.getFontMetrics().stringWidth("their vocabulary in a more efficient and joyful way.")) / 2, 175);
			g2d.drawString("This game is made up of Vocabulary words from the", (750 - g2d.getFontMetrics().stringWidth("This game is made up of Vocabulary words from the")) / 2, 200);
			g2d.drawString("Primary, Middle and High School Levels. This game", (750 - g2d.getFontMetrics().stringWidth("Primary, Middle and High School Levels. This game")) / 2, 225);
			g2d.drawString("was created to make it easier for your teachers to", (750 - g2d.getFontMetrics().stringWidth("was created to make it easier for your teachers to")) / 2, 250);
			g2d.drawString("make sure you know your vocabulary words.", (750 - g2d.getFontMetrics().stringWidth("make sure you know your vocabulary words.")) / 2, 275);
			
			backButtonHelp.paint(g2d);
			break;
			
		case GAME:
			g2d.drawImage(gameBackGround, 0, 0, null);
			g2d.drawImage(stickman[5 - alphabet.lives], 0, 110, null);

			wordTable.paint(g2d);
			alphabet.paint(g2d);
			levels.paint(g2d);
			
			int x = 290;
			int y = 10;
			for (int i = 1; i <= 5; i++)
				if (alphabet.lives < 6 - i)
					g2d.drawImage(cross      , x + (i - 1) * 70, y, null);
				else
					g2d.drawImage(crossActive, x + (i - 1) * 70, y, null);
			
			youWin.paint(g2d);
			youLose.paint(g2d);
			break;
			
		case SETTINGS:
			g2d.drawImage(mainBackGround, 0, 0, null);
			g2d.setColor(Color.WHITE);
			
			g2d.setFont(font.deriveFont(100f));
			g2d.drawString("SETTINGS", (750 - g2d.getFontMetrics().stringWidth("SETTINGS")) / 2, 80);
			
			g2d.setFont(font.deriveFont(30f));
			g2d.drawString("Choose the game difficulty.", (750 - g2d.getFontMetrics().stringWidth("Choose the game difficulty.")) / 2, 150);
			
			backButtonHelp.paint(g2d);
			settingsMenu.paint(g2d);
		}
	}
	
	public static void playSound() {
		if (!mute) {
			try { // The audio system:
				audio = AudioSystem.getAudioInputStream(new File("res/sound.wav"));
				Clip clip = AudioSystem.getClip();
		        clip.open(audio);
		        clip.start();
			} catch (Exception e) {
			}
		}
	}
	
	// The main method:
	public static void main(String args[]) {
		Panel panel = new Panel();
		panel.setFrame();
	}
}
