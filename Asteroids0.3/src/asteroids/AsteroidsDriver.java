package asteroids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Driver class for the game. Acts as an entry point for the application and
 * controls the GUI.
 * 
 * @author Lee Riley
 *
 */
public class AsteroidsDriver {
	/** the frame which will contain the content */
	private static JFrame frmAsteroids;
	/** the game menu panel */
	private static GameMenu menu = new GameMenu();
	/** the option menu panel */
	private static OptionsMenu options = new OptionsMenu();
	/** the help panel */
	private static HelpPane help = new HelpPane();
	/** the high scores panel */
	private static HighScoresPane scores = new HighScoresPane();
	/** stores the dimensions of the frame */
	private final static Dimension FRAME = new Dimension(1000, 800);
	/** timer for the main game loop */
	private static Timer timer;
	/** the current selected colour the game objects will be */
	private static Color gameColour = Color.WHITE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsteroidsDriver window = new AsteroidsDriver();
					AsteroidsDriver.frmAsteroids.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for AsteroidsDriver creates frame and add the start menu to
	 * it.
	 */
	public AsteroidsDriver() {
		initialize();
		frmAsteroids.getContentPane().add(menu);

	}

	/**
	 * Set the attributes for the frame.
	 */
	private void initialize() {
		frmAsteroids = new JFrame();
		frmAsteroids.setTitle("Asteroids");
		frmAsteroids.setBounds(100, 50, FRAME.width, FRAME.height);
		frmAsteroids.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsteroids.getContentPane().setLayout(null);
	}

	/**
	 * starts a new game of asteroids. adds the game pane to the frame and
	 * starts the game timer.
	 * 
	 */

	public static void newGame() {

		GamePane gameBoard = new GamePane(FRAME, gameColour);
		frmAsteroids.getContentPane().remove(menu);
		frmAsteroids.getContentPane().add(gameBoard);

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameBoard.repaint();
			}
		};

		timer = new Timer(25, taskPerformer);
		timer.start();

	}

	/**
	 * called when the game ends returns the app to the main menu. and ends the
	 * game timer.
	 * 
	 * @param score
	 *            the new score set by the player
	 */
	public static void endGame(int score) {
		loadMenu();
		timer.stop();
		scores.update(score);

	}

	/**
	 * clear the frame and add the menu to it
	 */
	public static void loadMenu() {
		frmAsteroids.getContentPane().removeAll();
		frmAsteroids.getContentPane().add(menu);
		menu.repaint();
	}

	/**
	 * clear the screen and add the options panel to it.
	 */
	public static void options() {
		frmAsteroids.getContentPane().removeAll();
		frmAsteroids.getContentPane().add(options);
		options.repaint();

	}

	/**
	 * clear the screen and add the high scores panel to it.
	 */
	public static void highScores() {
		frmAsteroids.getContentPane().removeAll();
		frmAsteroids.getContentPane().add(scores);
		scores.repaint();
	}

	/**
	 * clear the screen and add the help panel to it.
	 */
	public static void help() {
		frmAsteroids.getContentPane().removeAll();
		frmAsteroids.getContentPane().add(help);
		help.repaint();

	}

	/**
	 * changes the value of gameColour to the new color.
	 * 
	 * @param gameColour
	 *            the new colour
	 */
	public static void updateOptions(Color gameColour) {
		AsteroidsDriver.gameColour = gameColour;
	}
}
