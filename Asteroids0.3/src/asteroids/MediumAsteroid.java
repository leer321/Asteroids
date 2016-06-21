package asteroids;

/**
 * class extending Asteroid that defines a medium asteroid
 * 
 * @author lee Riley
 *
 */

@SuppressWarnings("serial")
public class MediumAsteroid extends Asteroid {
	/** X coordinates for the shape of the asteroid */
	private final static int[] MXARRAY = { 5, 30, 90, 90, 95, 40, 15, 30, 5 };
	/** Y coordinates for the shape of the asteroid */
	private final static int[] MYARRAY = { 10, 25, 30, 40, 65, 90, 80, 55, 35 };
	/** number of coordinates */
	private final static int POINTSINPOLY = 9;
	/** The score associated with destroying the asteroid */
	private final static int SCORE = 50;
	/** width of the asteroid */
	private static final int WIDTH = 90;
	/** height of the asteroid */
	private static final int HEIGHT = 80;

	/**
	 * Constructor to create an instance of a Medium asteroid
	 * 
	 * @param polyXArray
	 * @param polyYArray
	 *            translated arrays used to draw the asteroid in the correct
	 *            position on the screen
	 * @param randomStartXPos
	 * @param randomStartYPos
	 *            the random starting position of the asteroid
	 */
	public MediumAsteroid(int[] polyXArray, int[] polyYArray, int randomStartXPos, int randomStartYPos) {
		super(polyXArray, polyYArray, randomStartXPos, randomStartYPos, MXARRAY, MYARRAY, POINTSINPOLY, HEIGHT, WIDTH);
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

		int[] tempPolyXArray = (int[]) MXARRAY.clone();

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

		int[] tempPolyYArray = (int[]) MYARRAY.clone();

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
		return AsteroidSize.MEDIUM;
	}

}
