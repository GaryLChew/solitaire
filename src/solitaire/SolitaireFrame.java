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
		setBounds(100, 50, 450, 300);
		
		//TOFIX, maybe move this somewhere else later
		setResizable(false);
		
		contentPane = new GamePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pack();
	}

}
