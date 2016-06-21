package asteroids;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JButton;

/**
 * custom JPanel for the game options menu.
 * 
 * @author Lee Riley
 *
 */

public class OptionsMenu extends JPanel {

	/**
	 * Create the panel. Set all its attributes and events.
	 */
	public OptionsMenu() {
		setBackground(Color.BLACK);

		setBounds(new Rectangle(0, 0, 1000, 800));

		setLayout(null);

		JLabel lblTitleLabel = new JLabel("OPTIONS");
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setForeground(Color.WHITE);
		lblTitleLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblTitleLabel.setBounds(333, 39, 336, 167);
		add(lblTitleLabel);

		JLabel lblColour = new JLabel("Colour");
		lblColour.setToolTipText("select a colour for the game");
		lblColour.setForeground(Color.WHITE);
		lblColour.setFont(new Font("Arial", Font.PLAIN, 30));
		lblColour.setBounds(158, 230, 172, 54);
		add(lblColour);

		JRadioButton rdbtnWhite = new JRadioButton("     White", true);
		rdbtnWhite.setToolTipText("select a colour for the game");
		rdbtnWhite.setFont(new Font("Arial", Font.PLAIN, 25));
		rdbtnWhite.setOpaque(false);
		rdbtnWhite.setForeground(Color.WHITE);
		rdbtnWhite.setBounds(405, 253, 172, 23);
		add(rdbtnWhite);

		JRadioButton rdbtnGreen = new JRadioButton("     Green");
		rdbtnGreen.setToolTipText("select a colour for the game");
		rdbtnGreen.setOpaque(false);
		rdbtnGreen.setForeground(Color.GREEN);
		rdbtnGreen.setFont(new Font("Arial", Font.PLAIN, 25));
		rdbtnGreen.setBounds(652, 253, 172, 23);
		add(rdbtnGreen);

		ButtonGroup btngrpColour = new ButtonGroup();
		btngrpColour.add(rdbtnWhite);
		btngrpColour.add(rdbtnGreen);

		JButton btnBack = new JButton("Back");
		btnBack.setToolTipText("click to return to main menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsteroidsDriver.loadMenu();
			}
		});
		btnBack.setBounds(139, 675, 123, 39);
		add(btnBack);

		JButton btnSave = new JButton("Save");
		btnSave.setToolTipText("click to make changes permenant");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean gameSound;
				Color gameColour;

				if (rdbtnWhite.isSelected()) {
					gameColour = Color.WHITE;
				} else {
					gameColour = Color.GREEN;
				}

				AsteroidsDriver.updateOptions(gameColour);
			}
		});
		btnSave.setBounds(346, 675, 123, 39);
		add(btnSave);

	}
}
