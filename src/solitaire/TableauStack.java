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
		int x = super.getX(), y = super.getY();
		if (x <= clickX && clickX < x + Card.CARD_WIDTH) {
			if (y <= clickY) {
				//TOFIX Clean this up later
				if (super.size()==0) {
					return 0;
				}
				for (int i = 0; i < super.size()-1; i++) {
					if (clickY < y + Card.CARD_SPACING * (i + 1))
						return i;
				}
				
				if (clickY < y + Card.CARD_SPACING * (super.size())+ Card.CARD_HEIGHT) {
					return super.size()-1;
				}
				
				
			}
		}
		return -1;
	}

	@Override
	public boolean legalMove(Stack entry) {
		Card lastTabCard = super.peek();
		Card firstEntryCard = entry.getCard(0);
		
		if (lastTabCard.isRed()==firstEntryCard.isRed()) {
			return false;
		}

		if (lastTabCard.getValue()!=firstEntryCard.getValue()+1) {
			return false;
		}
		
		return true;
	}
}
