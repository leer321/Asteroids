package asteroids;

import java.awt.Dimension;

/**
 * class defines lasers to be fired by the ship extends the GameObject class.
 * 
 * @author Lee Riley
 *
 */

@SuppressWarnings("serial")
public class Laser extends GameObject {

	/** contains X coordinates for the laser shape */
	private final static int[] LASERXARRAY = { -3, 3, 3, -3, -3 };
	/** contains Y coordinates for the laser shape */
	private final static int[] LASERYARRAY = { -3, -3, 3, 3, -3 };
	/** factor by wich the angle of the laser is worked out from */
	private double movingAngle = 0;
	/** number of points in the polygon */
	private final static int POINTS = 5;
	/** width of the laser */
	private final static int WIDTH = 6;
	/** height of the laser */
	private final static int HEIGHT = 6;

	/**
	 * constructer to initilize a laser works out the inital movement of the
	 * laser
	 * 
	 * @param centerX
	 * @param centerY
	 *            new center coordinates of the laser
	 * @param movingAngle
	 *            new moving angle
	 * @param frameSize
	 *            size of the frame
	 */
	public Laser(double centerX, double centerY, double movingAngle, Dimension frameSize) {

		super(LASERXARRAY, LASERYARRAY, POINTS, frameSize, centerX, centerY, HEIGHT, WIDTH);

		this.movingAngle = movingAngle;

		onScreen = true;

		this.setXVelocity(this.torpedoXMoveAngle(movingAngle) * 10);
		this.setYVelocity(this.torpedoYMoveAngle(movingAngle) * 10);

	}

	/**
	 * setter for movingAngle
	 * 
	 * @param moveAngle
	 *            the new moving angle
	 */
	public void setMovingAngle(double moveAngle) {
		this.movingAngle = moveAngle;
	}

	/**
	 * getter for movingAngle
	 * 
	 * @return movingAngle
	 */
	public double getMovingAngle() {
		return movingAngle;
	}

	/**
	 * works out the direction to move on the x axis in radians.
	 * 
	 * @param xMoveAngle
	 *            factor used to work out the angle
	 * @return angle in radians
	 * 
	 */
	public double torpedoXMoveAngle(double xMoveAngle) {

		return (double) (Math.cos(xMoveAngle * Math.PI / 180));

	}

	/**
	 * works out the direction to move on the y axis in radians.
	 * 
	 * @param yMoveAngle
	 *            factor used to work out the angle
	 * @return angle in radians
	 * 
	 */
	public double torpedoYMoveAngle(double yMoveAngle) {

		return (double) (Math.sin(yMoveAngle * Math.PI / 180));

	}

	/**
	 * allow the object to move on the screen and deletes it if it leaves the
	 * screen.
	 */

	public void move() {

		if (this.onScreen) {

			this.changeXPos(this.getXVelocity());

			if (this.getXCenter() < 0) {

				this.onScreen = false;

			} else if (this.getXCenter() > frameSize.width) {

				this.onScreen = false;

			}

			this.changeYPos(this.getYVelocity());

			if (this.getYCenter() < 0) {

				this.onScreen = false;

			} else if (this.getYCenter() > frameSize.height) {

				this.onScreen = false;

			}

		}
	}

}
