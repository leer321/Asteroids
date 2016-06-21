package asteroids;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * Base class for all objects in the game. Extends java.awt.Polygon.
 * 
 * @author Lee Riley
 *
 */

public abstract class GameObject extends Polygon {
	/** size of the frame */
	public Dimension frameSize;
	/** the X center of the object */
	private double centerX;
	/** the Y center of the object */
	private double centerY;
	/** how much the object will move on the x axis */
	private double velocityX;
	/** how much the object will move on the y axis */
	private double velocityY;
	/** width of the object */
	private int width;
	/** height of the object */
	private int height;
	/** track wether the object is on the screen */
	public boolean onScreen = false;

	/**
	 * constructor to initilize a game object.
	 * 
	 * @param polyXArray
	 * @param polyYArray
	 *            coordinates for the shape of the object
	 * @param pointsinPoly
	 * 
	 * @param frameSize
	 * @param centerX
	 * @param centerY
	 * @param width
	 * @param height
	 */
	public GameObject(int[] polyXArray, int[] polyYArray, int pointsinPoly, Dimension frameSize, double centerX,
			double centerY, int width, int height) {
		super(polyXArray, polyYArray, pointsinPoly);
		this.frameSize = frameSize;
		this.centerX = centerX;
		this.centerY = centerY;
		this.width = width;
		this.height = height;

	}

	/**
	 * getter for centerX
	 * 
	 * @return centerX
	 */
	public double getXCenter() {
		return centerX;
	}

	/**
	 * getter for centerY
	 * 
	 * @return centerY
	 */
	public double getYCenter() {
		return centerY;
	}

	/**
	 * setter for the centerX
	 * 
	 * @param xCent
	 *            new x coordinate
	 */
	public void setXCenter(double xCent) {
		this.centerX = xCent;
	}

	/**
	 * setter for the centerY
	 * 
	 * @param yCent
	 *            new y coordinate
	 */
	public void setYCenter(double yCent) {
		this.centerY = yCent;
	}

	/**
	 * increment the centerX
	 * 
	 * @param incAmt
	 *            amount to increase centerX by
	 */
	public void changeXPos(double incAmt) {
		this.centerX += incAmt;
	}

	/**
	 * increment the centerY
	 * 
	 * @param incAmt
	 *            amount to increase centerY by
	 */
	public void changeYPos(double incAmt) {
		this.centerY += incAmt;
	}

	/**
	 * getter for the velocity on the x axis
	 * 
	 * @return velocityX
	 */
	public double getXVelocity() {
		return velocityX;
	}

	/**
	 * getter for the velocity on the y axis
	 * 
	 * @return velocityY
	 */
	public double getYVelocity() {
		return velocityY;
	}

	/**
	 * setter for velocityX
	 * 
	 * @param xVel
	 *            new velocity
	 */
	public void setXVelocity(double xVel) {
		this.velocityX = xVel;
	}

	/**
	 * setter for velocityy
	 * 
	 * @param yVel
	 *            new velocity
	 */
	public void setYVelocity(double yVel) {
		this.velocityY = yVel;
	}

	/**
	 * increase velocityX by a specified amount
	 * 
	 * @param xVelInc
	 *            amount to increase velocityX by
	 */
	public void increaseXVelocity(double xVelInc) {
		this.velocityX += xVelInc;
	}

	/**
	 * increase velocityY by a specified amount
	 * 
	 * @param yVelInc
	 *            amount to increase velocityY by
	 */
	public void increaseYVelocity(double yVelInc) {
		this.velocityY += yVelInc;
	}

	/**
	 * decrease velocityX by a specified amount
	 * 
	 * @param xVelInc
	 *            amount to increase velocityX by
	 */
	public void decreaseXVelocity(double xVelDec) {
		this.velocityX -= xVelDec;
	}

	/**
	 * decrease velocityY by a specified amount
	 * 
	 * @param yVelInc
	 *            amount to increase velocityY by
	 */
	public void decreaseYVelocity(double yVelDec) {
		this.velocityY -= yVelDec;
	}

	/**
	 * getter for the width of the object
	 * 
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * getter for the height of the object
	 * 
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * works out the bounding box for the object
	 * 
	 * @return a Rectangle representing the bounding box
	 */
	public Rectangle getBounds() {

		return new Rectangle((int) (getXCenter() - 6), (int) (getXCenter() - 6), getWidth(), getHeight());

	}

	/**
	 * abstract method for moving the object
	 */
	public abstract void move();

}
