package asteroids;

/**
 * class extending Asteroid that defines a small asteroid
 * 
 * @author lee Riley
 *
 */

@SuppressWarnings("serial")
public class SmallAsteroid extends Asteroid {
	/** X coordinates for the shape of the asteroid */
	private final static int[] SXARRAY = { 5, 40, 50, 70, 50, 20, 5 };
	/** Y coordinates for the shape of the asteroid */
	private final static int[] SYARRAY = { 40, 60, 50, 60, 100, 95, 75 };
	/** number of coordinates */
	private final static int POINTSINPOLY = 7;
	/** The score associated with destroying the asteroid */
	private final static int SCORE = 100;
	/** width of the asteroid */
	private final static int WIDTH = 65;
	/** height of the asteroid */
	private final static int HEIGHT = 60;

	/**
	 * Constructor to create an instance of a small asteroid
	 * 
	 * @param polyXArray
	 * @param polyYArray
	 *            translated arrays used to draw the asteroid in the correct
	 *            position on the screen
	 * @param randomStartXPos
	 * @param randomStartYPos
	 *            the random starting position of the asteroid
	 */
	public SmallAsteroid(int[] polyXArray, int[] polyYArray, int randomStartXPos, int randomStartYPos) {
		super(polyXArray, polyYArray, randomStartXPos, randomStartYPos, SXARRAY, SYARRAY, POINTSINPOLY, HEIGHT, WIDTH);
	}

	/**
	 * work out the translated array of X coordinates based on a random starting
	 * position.
	 * 
	 * @param randomStartXPos
	 *            the position to start at
	 * @return tempPolyXArray the translated array
	 */
	public static int[] getpolyXArray(int randomStartXPos) {

		int[] tempPolyXArray = (int[]) SXARRAY.clone();

		for (int i = 0; i < tempPolyXArray.length; i++) {

			tempPolyXArray[i] += randomStartXPos;

		}

		return tempPolyXArray;

	}

	/**
	 * work out the translated array of Y coordinates based on a random starting
	 * position.
	 * 
	 * @param randomStartYPos
	 *            the position to start at
	 * @return tempPolyYArray the translated array
	 */
	public static int[] getpolyYArray(int randomStartYPos) {

		int[] tempPolyYArray = (int[]) SYARRAY.clone();

		for (int i = 0; i < tempPolyYArray.length; i++) {

			tempPolyYArray[i] += randomStartYPos;

		}

		return tempPolyYArray;

	}

	/**
	 * getter for this instances score
	 * 
	 * @return SCORE
	 */
	@Override
	public int getScore() {

		return SCORE;
	}

	/**
	 * getter for this instances size
	 * 
	 * @return a enum of AsteroidSize
	 */
	public AsteroidSize getSize() {
		return AsteroidSize.SMALL;
	}

}
