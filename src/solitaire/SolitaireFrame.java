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

		// TOFIX Really, I'm not sure if the size really even matters cause it's
		// changed in GamePanel later anyways
		double scale = Settings.getScale();
		// setBounds(100 * scale, 50 * scale, 450 * scale, 300 * scale);
		int leftBorder = (Settings.screenWidth - Settings.scaledWindowWidth())/2;
		int topBorder = (Settings.screenHeight - Settings.scaledWindowHeight())/2;
		setBounds(leftBorder, topBorder, Settings.scaledWindowWidth(), Settings.scaledWindowHeight());

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
