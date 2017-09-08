package solitaire;

import java.awt.Graphics;
import java.util.List;

public class TableauStack extends Stack {

	// vertical spacing between individual cards in stack, change later to be
	// dependent on the user's resolution

	public TableauStack(List<Card> cards, double x, double y) {
		super(cards, x, y);
		super.setType(StackType.TABLEAU);
		super.peek().setFaceUp(true);
	}

	@Override
	public void draw(Graphics g) {
		List<Card> cards = super.getCards();
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			c.draw(g, super.getX(), super.getY() + Card.CARD_SPACING * i);
		}
	}

	@Override
	public int clickInBounds(int clickX, int clickY) {
		// TODO Auto-generated method stub
		return -1;
	}

}
