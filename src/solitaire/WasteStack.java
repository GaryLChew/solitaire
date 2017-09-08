package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class WasteStack extends Stack {

	public WasteStack(List<Card> cards, double x, double y) {
		super(cards,x,y);
	}
	
	public WasteStack(double x, double y) {
		super(new ArrayList<Card>(), x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		List<Card> cards = super.getCards();
		for (int i = 0;i<cards.size();i++) {
			Card c = cards.get(i);
			c.draw(g, super.getX(), super.getY()+Card.CARD_SPACING*i);
		}
		
	}

}
