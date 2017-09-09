package solitaire;

public class Directories {

	// TOFIX Pretty sure this isn't the optimal way to store filepaths, look up
	// a better way later.
	private static String resourceFP = "/res";

	private static String imagesFP = resourceFP + "/images";

	public static String cardsFP = imagesFP + "/cards";

	public static String cardEmptyFP = cardsFP + "/cardBack_empty.png";
	public static String cardBackFP = cardsFP + "/cardBack_blue4.png";

	public static String cardFront(String suit, String rank) {
		return "/res/images/cards/card" + suit + rank + ".png";
	}
}
