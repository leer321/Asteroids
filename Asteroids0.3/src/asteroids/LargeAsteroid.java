package asteroids;

/**
 * class extending Asteroid that defines a large asteroid
 * 
 * @author lee Riley
 *
 */
@SuppressWarnings("serial")
public class LargeAsteroid extends Asteroid {

	/** X coordinates for the shape of the asteroid */
	private final static int[] LXARRAY = { 5, 75, 115, 145, 195, 195, 120, 95, 25, 35 };
	/** Y coordinates for the shape of the asteroid */
	private final static int[] LYARRAY = { 35, 35, 65, 50, 85, 135, 105, 155, 115, 65 };
	/** number of coordinates */
	private final static int POINTSINPOLY = 10;
	/** The score associated with destroying the asteroid */
	private final static int SCORE = 20;
	/** width of the asteroid */
	private final static int WIDTH = 190;
	/** height of the asteroid */
	private final static int HEIGHT = 120;

	/**
	 * Constructor to create an instance of a large asteroid
	 * 
	 * @param polyXArray
	 * @param polyYArray
	 *            translated arrays used to draw the asteroid in the correct
	 *            position on the screen
	 * @param randomStartXPos
	 * @param randomStartYPos
	 *            the random starting position of the asteroid
	 */
	public LargeAsteroid(int[] polyXArray, int[] polyYArray, int randomStartXPos, int randomStartYPos) {
		super(polyXArray, polyYArray, randomStartXPos, randomStartYPos, LXARRAY, LYARRAY, POINTSINPOLY, HEIGHT, WIDTH);
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

		int[] tempPolyXArray = (int[]) LXARRAY.clone();

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

		int[] tempPolyYArray = (int[]) LYARRAY.clone();

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
	@Override
	public AsteroidSize getSize() {
		return AsteroidSize.LARGE;
	}

}
