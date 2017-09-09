package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MovingStack extends Stack {

	// offset between the original stack's and press's coordinates
	private double xOffset, yOffset;

	public MovingStack(double x, double y, double pressX, double pressY) {
		super(new ArrayList<Card>(), x, y);
		xOffset = pressX - x;
		yOffset = pressY - y;
	}

	@Override
	public int clickInBounds(int clickX, int clickY) {
		return -1;
	}

	@Override
	public void draw(Graphics g) {
		List<Card> cards = super.getCards();
		for (int i = 0; i < cards.size(); i++) {
			Card c = cards.get(i);
			c.draw(g, super.getX(), super.getY() + Card.CARD_SPACING * i);
		}
	}

	public void drag(MouseEvent drag, MouseEvent press) {
		super.setX(drag.getX());
		super.setY(drag.getY());
		correctOffset();
	}

	private void correctOffset() {
		super.setX(super.getX() - xOffset);
		super.setY(super.getY() - yOffset);
	}
	
	public void addYOffset(double toAdd) {
		yOffset+= toAdd;
	}

	@Override
	public boolean legalMove(Stack entry) {
		return false;
	}
}
