package asteroids;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

/**
 * custom panel to display the contents of the .txt file containing the help
 * information
 * 
 * @author Lee Riley
 *
 */
public class HelpPane extends JPanel {

	/** raw help information from file */
	private String[] helpData;
	/** proccesed helpData to be drawn to the screen */
	private String textData = "";
	/** URL containing the location of the help file */
	private static final String MAPS_URL = "/reasources/help.txt";
	/** contains the help file */
	private File file = new File(AsteroidsDriver.class.getResource(MAPS_URL).getFile());

	/**
	 * Create the panel. and handle the exceptions thrown by the file handler
	 * open method
	 */
	public HelpPane() {

		try {
			this.helpData = FileHandeler.openFile(file);
			helpDataToString();
		} catch (Exception e) {
			this.textData = "the help file has been corrupted";
		}

		setBackground(Color.BLACK);

		setBounds(new Rectangle(0, 0, 1000, 800));

		setLayout(null);

		JLabel lblTitleLabel = new JLabel("HELP");
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setForeground(Color.WHITE);
		lblTitleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTitleLabel.setBounds(333, 39, 336, 167);
		add(lblTitleLabel);

		JEditorPane helpPane = new JEditorPane();
		helpPane.setEditable(false);
		helpPane.setFont(new Font("Arial", Font.PLAIN, 20));
		helpPane.setForeground(Color.WHITE);
		helpPane.setBackground(Color.BLACK);
		helpPane.setBounds(94, 183, 813, 474);
		helpPane.setText(textData);
		add(helpPane);

		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("Click to return to main menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.loadMenu();
			}
		});
		btnBack.setBounds(139, 675, 123, 39);
		add(btnBack);
	}

	/**
	 * convert the raw help data string array to one string of formatted text
	 */
	private void helpDataToString() {
		for (int i = 0; i < helpData.length; i++) {
			textData = textData + "\n" + helpData[i];
		}
	}
}
