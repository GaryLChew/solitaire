package solitaire;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Utility {

	public static Image openImagePath(String filePath) {
		Image img = null;
		if (filePath.substring(filePath.length() - 4).equals(".gif")) {
			try {
				URL url = Utility.class.getResource(filePath);
				img = new ImageIcon(url).getImage();
			} catch (Exception e) {
				System.out.println("Problem opening the image at " + filePath);
				e.printStackTrace();
			}
		} else {
			try {
				URL url = Utility.class.getResource(filePath);
				img = ImageIO.read(url);
			} catch (IOException e) {
				System.out.println("Problem opening the image at " + filePath);
				e.printStackTrace();
			}
		}
		return img;
	}

	public static void playVictorySound(String filePath) {
		AudioStream sound = null;
		try {
			URL url = Utility.class.getResource(filePath);
			sound = new AudioStream(url.openStream());
		} catch (Exception e) {
			System.out.println("Problem opening a sound");
			e.printStackTrace();
		}
		AudioPlayer.player.start(sound);
	}

	// Draws image scaled user's resolution
	public static void drawScaled(Graphics g, Image img, int x, int y, int width, int height) {
		// Temporary multiplier
		double scale = Settings.getScale();
		g.drawImage(img, (int) (x * scale), (int) (y * scale), (int) (width * scale), (int) (height * scale), null);
	}

	// TOFIX use this one more, think I had to parse some doubles earlier
	public static void drawScaled(Graphics g, Image img, double x, double y, double width, double height) {
		drawScaled(g, img, (int) x, (int) y, (int) (int) width, (int) height);
	}

	public static double scaled(double num) {
		return num * Settings.getScale();
	}

	public static double inverseScaled(double num) {
		double inverseScale = 1 / Settings.getScale();
		return num * inverseScale;
	}
}
