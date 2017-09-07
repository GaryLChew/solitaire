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
			super.peek().draw(g, super.getX(), super.getY());
		} 
	}

}
