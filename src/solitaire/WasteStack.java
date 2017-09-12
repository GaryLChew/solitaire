package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import solitaire.Stack.StackType;

public class WasteStack extends Stack {

	public WasteStack(double x, double y) {
		super(new ArrayList<Card>(), x, y);
		super.setType(StackType.WASTE);
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
			//TOFIX account for size = 0?
			int lastCardY = y + Card.CARD_SPACING * (super.size() - 1);
			if (lastCardY <= clickY && clickY < lastCardY + Card.CARD_HEIGHT) {
				//Necessary for returning draggedStack
				if (super.size()==0) {
					return 0;
				}
				return super.size() - 1;
			}

		}
		return -1;
	}

	@Override
	public boolean legalMove(Stack entry) {
		return false;
	}
}
