package solitaire;

import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

public class DeckStack extends Stack{

	public DeckStack(List<Card> cards, double x, double y) {
		super(cards,x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		List<Card> cards = super.getCards();
		if (cards.size() > 0) {
			Card c = cards.get(cards.size() - 1);
			c.draw(g, super.getX(), super.getY());
		} else {
//			if (emptyImage == null) {
//				String filePath = "res/images/cards/cardBack_blue3.png";
//				try {
//					URL url = getClass().getResource(filePath);
//					System.out.println(filePath);
//					emptyImage = ImageIO.read(url);
//				} catch (IOException e) {
//					System.out.println("Problem opening the image at " + filePath);
//					e.printStackTrace();
//				}
//
//			}
//			g.drawImage(emptyImage, x, y, Card.getCardWidth(), Card.getCardHeight(), null);
		}
	}

}
