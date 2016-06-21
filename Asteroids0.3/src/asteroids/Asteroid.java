package asteroids;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Base class for the asteroids extends polygon
 * 
 * @author Lee Riley
 *
 */
@SuppressWarnings("serial")
public abstract class Asteroid extends Polygon {
	/** holds upper left x coordinates of the asteroid */
	private int uLeftXPos;
	/** holds upper left y coordinates of the asteroid */
	private int uLeftYPos;
	/** holds the direction on the x axis */
	private int xDirection = 1;
	/** holds the direction on the y axis */
	private int yDirection = 1;
	/**
	 * hold the secondary array of x coordinates to allow it to keep its shape
	 */
	private int[] sPolyXArray;
	/**
	 * hold the secondary array of y coordinates to allow it to keep its shape
	 */
	private int[] sPolyYArray;
	/** height of asteroid */
	private int asteroidHeight;
	/** width of asteroid */
	private int asteroidWidth;
	/** width of frame */
	private int width = 1000;
	/** height of frame */
	private int height = 800;
	/**
	 * hold the array of x coordinates to allow it to move
	 */
	private int[] polyXArray;
	/**
	 * hold the array of y coordinates to allow it to move
	 */
	private int[] polyYArray;
	/** keeps track of wether the asteroid is on the screen */
	public boolean onScreen = true;

	/**
	 * Constructor to initilize a Asteroid.
	 * 
	 * @param polyXArray
	 * @param polyYArray
	 *            the arrays that transfor the asteroids position
	 * @param randomStartXPos
	 * @param randomStartYPos
	 *            random point on the screen for the Asteroid to start at
	 * @param sPolyXArray
	 * @param sPolyYArray
	 *            Original shape for asteroid
	 * @param pointsInPoly
	 *            number of points the asteroid consists of
	 * @param rockHeight
	 * @param rockWidth
	 *            dimensions of the asteroid
	 */
	public Asteroid(int[] polyXArray, int[] polyYArray, int randomStartXPos, int randomStartYPos, int[] sPolyXArray,
			int[] sPolyYArray, int pointsInPoly, int rockHeight, int rockWidth) {

		super(polyXArray, polyYArray, pointsInPoly);

		this.asteroidHeight = rockHeight;
		this.asteroidWidth = rockWidth;

		this.xDirection = (int) (Math.random() * 4 + 1);

		this.yDirection = (int) (Math.random() * 4 + 1);

		this.setuLeftXPos(randomStartXPos);

		this.setuLeftYPos(randomStartYPos);

	}

	/**
	 * get the direction of the Asteroid on the x axis
	 *
	 * @return xDirection
	 */
	public int getXDirection() {
		return xDirection;
	}

	/**
	 * get the direction of the Asteroid on the y axis
	 *
	 * @return yDirection
	 */
	public int getYDirection() {
		return yDirection;
	}

	/**
	 * set the direction of the Asteroid on the x axis
	 *
	 * @param xDirection
	 *            new direction
	 */
	public void setXDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	/**
	 * set the direction of the Asteroid on the y axis
	 *
	 * @param yDirection
	 *            new direction
	 */
	public void setYDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	/**
	 * works out the bounding box for the object
	 * 
	 * @return a Rectangle representing the bounding box
	 */
	public Rectangle getBounds() {

		return new Rectangle(super.xpoints[0], super.ypoints[0], asteroidWidth, asteroidHeight);

	}

	
	/**
	 * allows the asteroids to automatically move
	 * based on its direction
	 */
	public void move() {

		int uLeftXPos = super.xpoints[0];

		int uLeftYPos = super.ypoints[0];

		if (uLeftXPos < 0 || (uLeftXPos + 25) > width)
			xDirection = -xDirection;

		if (uLeftYPos < 0 || (uLeftYPos + 50) > height)
			yDirection = -yDirection;

		for (int i = 0; i < super.xpoints.length; i++) {

			super.xpoints[i] += xDirection;
			super.ypoints[i] += yDirection;

		}

	}

	/** abstract getter method to return a score assosiated with a super
	 * class of asteroid
	 * @return the score of the asteroid
	 */
	public abstract int getScore();
	
	/** abstract getter method to return the size 
	 * assosiated with a super class of asteroid
	 * @return an enum of the asteroids size
	 */
	public abstract AsteroidSize getSize();

	/**
	 * getter for the upper left X coordinate
	 * @return uLeftXpos
	 */
	public int getuLeftXPos() {
		return uLeftXPos;
	}

	/**
	 * setter for the upper left X coordinate
	 * @param uLeftXPos
	 * 		new coordinate
	 */
	public void setuLeftXPos(int uLeftXPos) {
		this.uLeftXPos = uLeftXPos;
	}

	/**
	 * getter for the upper left Y coordinate
	 * @return uLeftYpos
	 */
	public int getuLeftYPos() {
		return uLeftYPos;
	}
	/**
	 * setter for the upper left Y coordinate
	 * @param uLeftYPos
	 * 		new coordinate
	 */
	public void setuLeftYPos(int uLeftYPos) {
		this.uLeftYPos = uLeftYPos;
	}

}
