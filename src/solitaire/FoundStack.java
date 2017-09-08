package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import solitaire.Stack.StackType;

public class FoundStack extends Stack {

	public FoundStack(List<Card> cards, double x, double y) {
		super(cards, x, y);
		super.setType(StackType.FOUND);
	}

	public FoundStack(double x, double y) {
		super(new ArrayList<Card>(), x, y);
		super.setType(StackType.FOUND);
	}

	@Override
	public void draw(Graphics g) {
		if (super.getCards().size() > 0)
			super.peek().draw(g, super.getX(), super.getY());
	}

	@Override
	public int clickInBounds(int clickX, int clickY) {
		// TODO Auto-generated method stub
		return -1;
	}

}
