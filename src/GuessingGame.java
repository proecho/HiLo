import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numberOfTries;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is too low. Try again.";
				numberOfTries += 1;
			}else if (guess > theNumber) {
				message = guess + " is too high. Try again.";
				numberOfTries += 1;
			} else {
				numberOfTries += 1;
				message = guess + " is correct. You win! Let's play again! It took you " + numberOfTries + " Tries!";
				newGame();
				
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		numberOfTries = 0;
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Echo's Hi-Lo Guessing Game");
		
		
		JLabel lblNewLabel = new JLabel("Echo's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Droid Sans Mono", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setFont(new Font("Droid Sans Mono", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Droid Sans Mono", Font.BOLD, 12));
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Droid Sans Mono", Font.BOLD, 12));
		lblOutput.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGuess, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnGuess, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOutput, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGuess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnGuess, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblOutput, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(796))
		);
		getContentPane().setLayout(groupLayout);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
