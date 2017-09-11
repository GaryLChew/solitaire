package solitaire;

import java.awt.Dimension;
import java.awt.Toolkit;

//TOFIX this class may be temporary
public class Settings {
	
	//scales everything for the correct resolution
	//maybe later I should have this be persistent
	private static double scale = 1;
	
	public static void setScale(double scale) {
		Settings.scale = scale;
	}
	
	public static double getScale() {
		return scale;
	}

	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int screenWidth = (int) screenSize.getWidth();
	public static final int screenHeight = (int) screenSize.getHeight();

	public static int windowWidth = 750, windowHeight = 550;

	public static Dimension scaledWindowSize() {
		return new Dimension(scaledWindowWidth(), scaledWindowHeight());
	}

	public static int scaledWindowWidth() {
		return (int) (windowWidth * Settings.getScale());
	}

	public static int scaledWindowHeight() {
		return (int) (windowHeight * Settings.getScale());
	}
	
}
