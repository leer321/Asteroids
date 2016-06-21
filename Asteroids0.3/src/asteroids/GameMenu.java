package asteroids;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A custom panel for the start menu.
 * 
 * @author Lee Riley
 *
 */
@SuppressWarnings("serial")
public class GameMenu extends JPanel {

	/**
	 * Create the panel and set all the attributes and swing objects to it.
	 */
	public GameMenu() {
		setBackground(Color.BLACK);

		setBounds(0, 0, 1000, 800);
		setLayout(null);

		JLabel lblTitleLabel = new JLabel("ASTEROIDS");
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setForeground(Color.WHITE);
		lblTitleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTitleLabel.setBounds(333, 39, 336, 167);
		add(lblTitleLabel);

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.setToolTipText("click to start a new game");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 23));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.newGame();
			}
		});
		btnNewButton.setBounds(276, 217, 441, 76);
		add(btnNewButton);

		JButton btnOptions = new JButton("Options");
		btnOptions.setToolTipText("click to open options menu");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.options();
			}
		});
		btnOptions.setFont(new Font("Arial", Font.PLAIN, 23));
		btnOptions.setForeground(Color.WHITE);
		btnOptions.setContentAreaFilled(false);
		btnOptions.setBounds(276, 323, 441, 76);
		add(btnOptions);

		JButton btnHighScores = new JButton("High Scores");
		btnHighScores.setToolTipText("click to view high scores");
		btnHighScores.setFont(new Font("Arial", Font.PLAIN, 23));
		btnHighScores.setContentAreaFilled(false);
		btnHighScores.setForeground(Color.WHITE);
		btnHighScores.setBounds(276, 421, 441, 76);
		btnHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.highScores();
			}
		});
		add(btnHighScores);

		JButton btnHelp = new JButton("Help");
		btnHelp.setToolTipText("click to view help screen");
		btnHelp.setContentAreaFilled(false);
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Arial", Font.PLAIN, 23));
		btnHelp.setBounds(276, 521, 441, 76);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.help();
			}
		});
		add(btnHelp);

	}
}
