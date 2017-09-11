package solitaire;

//TOFIX this class may be temporary
public class Settings {
	
	//scales everything for the correct resolution
	//maybe later I should have this be persistent
	private static double scale = 2;
	
	public static void setScale(double scale) {
		Settings.scale = scale;
	}
	
	public static double getScale() {
		return scale;
	}
	
}
