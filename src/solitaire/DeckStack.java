package solitaire;

import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import solitaire.Stack.StackType;

public class DeckStack extends Stack {

	public DeckStack(List<Card> cards, double x, double y) {
		super(cards, x, y);
		super.setType(StackType.DECK);
	}

	@Override
	public void draw(Graphics g) {
		if (super.size() == 0) {
			super.drawEmpty(g);
		} else {
			super.peek().draw(g, super.getX(), super.getY());
		}
	}

	@Override
	public int clickInBounds(int clickX, int clickY) {
		int x = super.getX(), y = super.getY();
		if (x <= clickX && clickX < x + Card.CARD_WIDTH) {
			if (y <= clickY && clickY < y + Card.CARD_HEIGHT) {
				// this doesn't actually matter, as long as it is >0
				if (super.size() == 0)
					return 0;
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
