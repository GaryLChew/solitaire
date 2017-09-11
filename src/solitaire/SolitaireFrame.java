package solitaire;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SolitaireFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SolitaireFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TOFIX need to change this later cause scale needs to be defined
		// earlier
		double scale = Settings.getScale();
//		setBounds(100 * scale, 50 * scale, 450 * scale, 300 * scale);
		setBounds(100,50,1000,1000);

		// TOFIX, maybe move this somewhere else later
		setResizable(false);

		contentPane = new GamePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pack();
	}

	// TOFIX temporary method to make things look nice

	private void setBounds(double x, double y, double width, double height) {
		setBounds((int) x, (int) y, (int) width, (int) height);
	}

}
