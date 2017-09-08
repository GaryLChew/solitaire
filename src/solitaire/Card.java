package solitaire;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Card {

	private int value;
	private String suit;
	private String rank;
	private boolean faceUp;

	//Update later to be dependent on resolution and private
	public static final int CARD_WIDTH = 70, CARD_HEIGHT = 95;
	public static final int CARD_SPACING = 15;
	
	private Image img;
	private Image upImg;
	private static Image downImg;

	public Card(int cardvalue, String cardSuit, boolean cardFaceUp) {
		value = cardvalue;
		suit = cardSuit;
		faceUp = cardFaceUp;
		setRank();
		openImage();
	}

	private void setRank() {
		if (2 <= value && value <= 10)
			rank = "" + value;
		else if (value == 1)
			rank = "A";
		else if (value == 11)
			rank = "J";
		else if (value == 12)
			rank = "Q";
		else if (value == 13)
			rank = "K";
	}

	public void draw(Graphics g, int x, int y) {
		updateImage();
		Utility.drawScaled(g, img, x, y, CARD_WIDTH, CARD_HEIGHT);
	}

	private void openImage() {
		if (downImg == null) {
			//Why do I need to do utility.openImagePath? Why is it linked to the class?
			downImg = Utility.openImagePath(Directories.cardBackFP);
		}
		upImg = Utility.openImagePath("/res/images/cards/card" + suit + rank + ".png");
	}

	private void updateImage() {
		if (faceUp)
			img = upImg;
		else
			img = downImg;
	}

	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + value + ")";
	}
}
