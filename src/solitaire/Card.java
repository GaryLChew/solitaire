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

	private Image img;

	private boolean faceUp;

	public Card(int cardvalue, String cardSuit, boolean cardFaceUp) {
		value = cardvalue;
		suit = cardSuit;
		faceUp = cardFaceUp;
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
		openImage();
	}

	public void draw(Graphics g, int x, int y) {
		g.drawImage(img, x, y, 0, 0, null);
	}

	private void openImage() {
		
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + value + ")";
	}
}
