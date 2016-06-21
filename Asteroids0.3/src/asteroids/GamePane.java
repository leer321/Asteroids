package asteroids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * A custom panel for the game objects to be drawn to contains the algorithm for
 * the game play.
 * 
 * @author Lee Riley
 *
 */

@SuppressWarnings("serial")
public class GamePane extends JPanel {

	/** an instance of the players ship */
	private Ship player;
	/** array list containing instances of lasers */
	private static ArrayList<Laser> lasers = new ArrayList<Laser>();
	/** size of the current frame */
	private Dimension frameSize;
	/** contains all the asteroids that will be on the screen */
	private static ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	/** keeps track of the users score */
	private int score;
	/** keeps track of the users lives */
	private int life;
	/** keeps track of the current level */
	private int level;
	/** keeps track of how many asteroids are left in the level */
	private int asteroidCount;
	/** manages the focus for the key events */
	private static KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	/** the colour objects should be drawn to the screen in */
	private Color gameColour;

	/**
	 * constructer for the panel, handles the key events.
	 * 
	 * @param frameSize
	 *            dimension containing the size of the frame
	 */
	public GamePane(Dimension frameSize, Color gameColour) {
		super();

		this.gameColour = gameColour;
		this.frameSize = frameSize;
		this.setBackground(Color.BLACK);
		this.setBounds(0, 0, frameSize.width, frameSize.height);
		this.score = 0;
		this.life = 3;
		this.level = 1;
		player = new Ship(frameSize);
		addAsteroids();

		kfm.addKeyEventDispatcher(new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					if (e.getKeyCode() == 87) {
						// W
						player.setMovingAngle(player.getRotationAngle());

						player.increaseXVelocity(player.shipXMoveAngle(player.getMovingAngle()) * 0.1);
						player.increaseYVelocity(player.shipYMoveAngle(player.getMovingAngle()) * 0.1);

						return true;
					}

					else if (e.getKeyCode() == 83) {
						// S
						player.decreaseXVelocity(player.shipXMoveAngle(player.getMovingAngle()) * 0.1);
						player.decreaseYVelocity(player.shipYMoveAngle(player.getMovingAngle()) * 0.1);
						return true;
					}

					if (e.getKeyCode() == 68) {
						// d
						player.increaseRotationAngle();
						return true;
					}

					else if (e.getKeyCode() == 65) {
						// a
						player.decreaseRotationAngle();
						return true;
					}

					if (e.getKeyCode() == KeyEvent.VK_SPACE) {

						lasers.add(new Laser(player.getShipNoseX(), player.getShipNoseY(), player.getRotationAngle(),
								frameSize));
						return true;

					}
				}
				return false;
			}
		});
	}

	/**
	 * add Large asteroids to the asteroids ArrayList based on the current
	 * level.
	 */

	public void addAsteroids() {

		asteroids.clear();
		asteroidCount = 0;
		for (int i = 0; i < ((int) level * 1.5); i++) {

			// Find a random x & y starting point
			// The -40 part is on there to keep the Rock on the screen

			int randomStartXPos = (int) (Math.random() * (frameSize.width - 40) + 1);
			int randomStartYPos = (int) (Math.random() * (frameSize.height - 40) + 1);

			// Add the Rock object to the ArrayList based on the attributes sent

			asteroids.add(new LargeAsteroid(LargeAsteroid.getpolyXArray(randomStartXPos),
					LargeAsteroid.getpolyYArray(randomStartYPos), randomStartXPos, randomStartYPos));

			asteroidCount++;

		}
		System.out.print(asteroidCount);
	}

	/**
	 * called every time the repaint method is called on the panel this handles
	 * the main algorithm for each step of the gameplay.
	 * 
	 * @param g
	 *            the current graphics context.
	 */
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		AffineTransform identity = new AffineTransform();

		g2d.setColor(gameColour);

		g2d.drawString("score: " + score, 25, 25);
		g2d.drawString("life: " + life, 25, 45);
		g2d.drawString("level: " + level, 25, 65);

		player.move();

		g2d.setTransform(identity);
		//ArrayList<Asteroid> asteroidsClone = (ArrayList<Asteroid>) asteroids.clone();
		for (Asteroid asteroid1 : asteroids) {

			if (asteroid1.onScreen) {

				Rectangle rockToCheck = asteroid1.getBounds();

				for (Asteroid asteroid : asteroids) {

					if (asteroid.onScreen) {

						Rectangle otherRock = asteroid.getBounds();

						if (asteroid != asteroid1 && otherRock.intersects(rockToCheck)) {

							int tempXDirection = asteroid1.getXDirection();
							int tempYDirection = asteroid1.getYDirection();

							asteroid1.setXDirection(asteroid.getXDirection());
							asteroid1.setYDirection(asteroid.getYDirection());

							asteroid.setXDirection(tempXDirection);
							asteroid.setYDirection(tempYDirection);
						}

						Rectangle shipBox = player.getBounds();

						if (otherRock.intersects(shipBox)) {

							player.setXCenter(player.frameSize.width / 2);
							player.setYCenter(player.frameSize.height / 2);

							player.setXVelocity(0);
							player.setYVelocity(0);

							life--;

						}

						for (Laser laser : lasers) {

							if (laser.onScreen) {

								if (otherRock.contains(laser.getXCenter(), laser.getYCenter())) {

									asteroid.onScreen = false;
									laser.onScreen = false;
									score += asteroid.getScore();
									asteroidCount--;

									if (asteroid.getSize() == AsteroidSize.LARGE) {

										asteroids.add(new MediumAsteroid(
												MediumAsteroid.getpolyXArray(asteroid.getuLeftXPos()),
												MediumAsteroid.getpolyYArray(asteroid.getuLeftYPos()),
												asteroid.getuLeftXPos(), asteroid.getuLeftYPos()));

										asteroidCount++;

									} else if (asteroid.getSize() == AsteroidSize.MEDIUM) {

										asteroids.add(
												new SmallAsteroid(SmallAsteroid.getpolyXArray(asteroid.getuLeftXPos()),
														SmallAsteroid.getpolyYArray(asteroid.getuLeftYPos()),
														asteroid.getuLeftXPos(), asteroid.getuLeftYPos()));

										asteroidCount++;

									}

								}

							}

						}

					}

				}

				asteroid1.move();

				g2d.draw(asteroid1);

			}

		}

		g2d.translate(player.getXCenter(), player.getYCenter());

		g2d.rotate(Math.toRadians(player.getRotationAngle()));

		g2d.draw(player);

		for (Laser laser : lasers) {

			laser.move();

			if (laser.onScreen) {

				g2d.setTransform(identity);

				g2d.translate(laser.getXCenter(), laser.getYCenter());

				g2d.draw(laser);

			}

		}

		if (life <= 0) {
			AsteroidsDriver.endGame(score);

		}

		if (asteroidCount == 0) {
			level++;
			addAsteroids();
		}

		if (score >= 1000) {
			life++;
		}

	}

}
