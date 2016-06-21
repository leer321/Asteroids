package asteroids;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * custom JPanel to display the array of top scores
 * 
 * @author Lee Riley
 *
 */
public class HighScoresPane extends JPanel {

	/** Processed score string to be displayed */
	private String scoreString = "";
	/** array of high scores */
	private int[] scores = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	/** container for the scores string */
	JEditorPane ScoresPane;

	/**
	 * Create the panel.
	 */
	public HighScoresPane() {

		setBackground(Color.BLACK);

		setBounds(new Rectangle(0, 0, 1000, 800));

		setLayout(null);

		JLabel lblTitleLabel = new JLabel("High Scores");
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setForeground(Color.WHITE);
		lblTitleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTitleLabel.setBounds(333, 39, 336, 167);
		add(lblTitleLabel);

		ScoresPane = new JEditorPane();
		ScoresPane.setEditable(false);
		ScoresPane.setFont(new Font("Arial", Font.PLAIN, 20));
		ScoresPane.setForeground(Color.WHITE);
		ScoresPane.setBackground(Color.BLACK);
		ScoresPane.setBounds(94, 183, 813, 474);
		add(ScoresPane);
		scoresToString();

		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("click to return to main menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.loadMenu();
			}
		});
		btnBack.setBounds(139, 675, 123, 39);
		add(btnBack);

	}

	/**
	 * convert the scores Array to a formatted string and add it to the
	 * scoresPane
	 */
	private void scoresToString() {
		scoreString = "";
		int j = 1;
		for (int i = 9; i > -1; i--) {

			scoreString = scoreString + j + "." + "\t" + scores[i] + "\n";
			j++;
		}
		ScoresPane.setText(scoreString);
	}

	/**
	 * update the High scores panel when a new score is added and is in the top
	 * ten.
	 * 
	 * @param score
	 *            new score to be added to the array
	 */
	public void update(int score) {
		if (score > scores[9]) {
			scores[9] = score;
			Arrays.sort(scores);
			scoresToString();
			this.repaint();
		}

	}

}
