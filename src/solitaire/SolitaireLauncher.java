package solitaire;

import java.awt.EventQueue;

public class SolitaireLauncher {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// TOFIX maybe put this somewhere else
					createSettings();

					SolitaireFrame frame = new SolitaireFrame();
					frame.setVisible(true);
					Utility.playBGSong();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void createSettings() {
		fixScaling();
	}

	private static void fixScaling() {

		// ratios screen resolution / original window resolution
		double xRatio = Settings.screenWidth / Settings.windowWidth;
		double yRatio = Settings.screenHeight / Settings.windowHeight;
		
		Settings.setScale(Math.min(xRatio, yRatio)*1.1);
	}

}
