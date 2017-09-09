package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import solitaire.Stack.StackType;

public class WasteStack extends Stack {

	public WasteStack(List<Card> cards, double x, double y) {
		super(cards,x,y);
		super.setType(StackType.WASTE);
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

	@Override
	public int clickInBounds(int clickX, int clickY) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean legalMove(Stack entry) {
		return false;
	}
}
