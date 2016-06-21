package asteroids;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utility class to read in text files
 * 
 * @author Lee Riley
 *
 */
public class FileHandeler {

	/**
	 * opens a txt file
	 * 
	 * @param file
	 *            the file to be opened
	 * @return textData an array of strings containing each line of text from
	 *         the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 *             both exceptions passed up to be handled in the GUI
	 * 
	 */
	public static String[] openFile(File file) throws FileNotFoundException, IOException {

		ArrayList<String> textdata = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		while (true) {

			String tempLine = br.readLine();
			System.out.print(tempLine);

			if (tempLine == null) {
				break;
			} else {
				textdata.add(tempLine);
			}
		}

		br.close();

		String[] textData = textdata.toArray(new String[0]);
		return textData;

	}

}
