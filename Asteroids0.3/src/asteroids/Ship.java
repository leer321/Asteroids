package asteroids;

import java.awt.*;

/**
 * class defines the player controled ship. extends the GameObject class.
 * 
 * @author Lee Riley
 *
 */
@SuppressWarnings("serial")
public class Ship extends GameObject {

	/** x coordinates for the shape of the ship */
	private final static int[] SHIPXARRAY = { -13, 14, -13, -5, -13 };
	/** y coordinates for the shape of the ship */
	private final static int[] SHIPYARRAY = { -15, 0, 15, 0, -15 };
	/** upper left x coordinate */
	private double uLeftXPos = getXCenter() + this.SHIPXARRAY[0];
	/** upper left x coordinate */
	private double uLeftYPos = getYCenter() + this.SHIPYARRAY[0];
	/** hold the factor by which the ship rotates */
	private double rotationAngle = 0;
	/** hold the factor which defines the direction the ship should move in */
	private double movingAngle = 0;
	/** number of points in the polygon */
	private final static int POINTS = 5;
	/** width of the ship */
	private final static int WIDTH = 27;
	/** height of the ship */
	private final static int HEIGHT = 30;

	/**
	 * constructor to initilize a ship
	 * 
	 * @param frameSize
	 *            the size of the current frame
	 */
	public Ship(Dimension frameSize) {
		super(SHIPXARRAY, SHIPYARRAY, POINTS, frameSize, frameSize.width / 2, frameSize.height / 2, WIDTH, HEIGHT);

		onScreen = true;

	}

	/**
	 * getter for the upper left x coordinate of the ship
	 * 
	 * @return uLeftXPos
	 */
	public double getuLeftXPos() {
		return uLeftXPos;
	}

	/**
	 * getter for the upper left Y coordinate of the ship
	 * 
	 * @return uLeftYPos
	 */
	public double getuLeftYPos() {
		return uLeftYPos;
	}

	/**
	 * setter for the upper left Y coordinate of the ship
	 * 
	 * @param xULPos
	 *            new x coordinate
	 */
	public void setuLeftXPos(double xULPos) {
		this.uLeftXPos = xULPos;
	}

	/**
	 * setter for the upper left y coordinate of the ship
	 * 
	 * @param yULPos
	 *            new y coordinate
	 */
	public void setuLeftYPos(double yULPos) {
		this.uLeftYPos = yULPos;
	}

	/**
	 * setter for movingAngle
	 * 
	 * @param moveAngle
	 *            new moving angle
	 */

	public void setMovingAngle(double moveAngle) {
		this.movingAngle = moveAngle;
	}

	/**
	 * getter for moving Angle
	 * 
	 * @return movingAngle
	 */
	public double getMovingAngle() {
		return movingAngle;
	}

	/**
	 * increments the current movingAngle by the new angle.
	 * 
	 * @param moveAngle
	 *            angle to add to current movingAngle
	 */
	public void increaseMovingAngle(double moveAngle) {
		this.movingAngle += moveAngle;
	}

	/**
	 * work out the movement angle for the x axis in radians
	 * 
	 * @param xMoveAngle
	 *            the move angle factor
	 * @return the angle in radians
	 */
	public double shipXMoveAngle(double xMoveAngle) {

		return (double) (Math.cos(xMoveAngle * Math.PI / 180));

	}

	/**
	 * work out the movement angle for the y axis in radians
	 * 
	 * @param yMoveAngle
	 *            the move angle factor
	 * @return the angle in radians
	 */
	public double shipYMoveAngle(double yMoveAngle) {

		return (double) (Math.sin(yMoveAngle * Math.PI / 180));

	}

	/**
	 * getter for the current rotationAngle
	 * 
	 * @return rotationAngle
	 */

	public double getRotationAngle() {
		return rotationAngle;
	}

	/**
	 * increase the rotationAngle by five degrees
	 */
	public void increaseRotationAngle() {

		if (getRotationAngle() >= 355) {
			rotationAngle = 0;
		}

		else {
			rotationAngle += 5;
		}

	}

	/**
	 * decrease the rotationAngle by five degrees
	 */

	public void decreaseRotationAngle() {

		if (getRotationAngle() < 0) {
			rotationAngle = 355;
		}

		else {
			rotationAngle -= 5;
		}

	}

	/**
	 * works out the x coordinates of the ship nose
	 * 
	 * @return the x coordinates of the ships nose
	 */

	public double getShipNoseX() {
		return this.getXCenter() + Math.cos(rotationAngle) * 14;

	}

	/**
	 * works out the y coordinates of the ship nose
	 * 
	 * @return the y coordinates of the ships nose
	 */

	public double getShipNoseY() {

		return this.getYCenter() + Math.sin(rotationAngle) * 14;

	}

	/**
	 * allow the ship to move on the screen and allows it to leave the screen
	 * and flip to the other side.
	 */
	public void move() {

		this.changeXPos(this.getXVelocity());

		if (this.getXCenter() < 0) {

			this.setXCenter(frameSize.width);

		} else if (this.getXCenter() > frameSize.width) {

			this.setXCenter(0);

		}

		this.changeYPos(this.getYVelocity());

		if (this.getYCenter() < 0) {

			this.setYCenter(frameSize.height);

		} else if (this.getYCenter() > frameSize.height) {

			this.setYCenter(0);

		}

	}

}
