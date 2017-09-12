package solitaire;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.Timer;

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

	public static void playSound(String filePath) {
		try {
			URL url = Utility.class.getResource(filePath);
			AudioStream sound = new AudioStream(url.openStream());
			AudioPlayer.player.start(sound);
		} catch (Exception e) {
			System.out.println("Problem opening a sound");
			e.printStackTrace();
		}
	}

	// TOFIX move this somewhere else later
	private static Timer songTimer;

	public static void playBGSong() {
		playSound(Directories.songFP);
		try {
			songTimer = new Timer(190 * 1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					playSound(Directories.songFP);
				}
			});
		} catch (Exception e) {

			System.out.println("Problem opening the background song");
			e.printStackTrace();
		}
		songTimer.start();
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
