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

	//Update later to be dependent on resolution
	private static int width, height;
	
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
		g.drawImage(img, x, y, width, height, null);
	}

	private void openImage() {
		if (downImg == null) {
			downImg = Utility.openImagePath("res/images/cards/cardBack_blue4.png");
		}
		upImg = Utility.openImagePath("res/images/cards/card" + suit + rank + ".png");
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
