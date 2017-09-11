package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MovingStack extends Stack {

	// offset between the original stack's and press's coordinates
	private double xOffset, yOffset;

	private int originalStackIndex = -1;

	public MovingStack(Stack stackClicked, MouseEvent press) {
		super(new ArrayList<Card>(), stackClicked.getX(), stackClicked.getY());

		double invScalPressX = Utility.inverseScaled(press.getX());
		double invScalPressY = Utility.inverseScaled(press.getY());

		xOffset = invScalPressX - super.getX();
		yOffset = invScalPressY - super.getY();
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

	public void drag(MouseEvent drag) {
		double inverseScale = 1 / Settings.getScale();
		int x = (int) (drag.getX() * inverseScale);
		int y = (int) (drag.getY() * inverseScale);
		super.setX(x);
		super.setY(y);
		correctOffset();
	}

	private void correctOffset() {
		super.setX(super.getX() - xOffset);
		super.setY(super.getY() - yOffset);
	}

	public void addYOffset(double toAdd) {
		yOffset += toAdd;
	}

	@Override
	public boolean legalMove(Stack entry) {
		return false;
	}
}
