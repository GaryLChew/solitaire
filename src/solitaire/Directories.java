package solitaire;

public class Directories {

	private static String resourceFP = "/res";

	private static String imagesFP = resourceFP + "/images";

	public static String cardsFP = imagesFP + "/cards";

	public static String cardBackFP = cardsFP+ "/cardBack_blue4.png";
	
	public static String cardFront(String suit, String rank) {
		return "/res/images/cards/card" + suit + rank + ".png";
	}
}
