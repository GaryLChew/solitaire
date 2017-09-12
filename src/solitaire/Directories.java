package solitaire;

public class Directories {

	// TOFIX Pretty sure this isn't the optimal way to store filepaths, look up
	// a better way later.
	private static String resourceFP = "/res";

	private static String imagesFP = resourceFP + "/images";

	private static String cardsFP = imagesFP + "/cards";

	public static String cardEmptyFP = cardsFP + "/cardBack_empty.png";
	public static String cardBackFP = cardsFP + "/cardBack_blue4.png";

	public static String cardFront(String suit, String rank) {
		return "/res/images/cards/card" + suit + rank + ".png";
	}
	
	
	private static String soundsFP = resourceFP + "/sounds";
	
	public static String songFP = soundsFP + "/bgSong.wav";
	public static String cardPlaceFP = soundsFP + "/cardPlace1.wav";
}