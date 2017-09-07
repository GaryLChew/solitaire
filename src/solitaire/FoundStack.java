package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class FoundStack extends Stack {

	public FoundStack(List<Card> cards, double x, double y) {
		super(cards,x,y);
	}
	
	public FoundStack(double x, double y) {
		super(new ArrayList<Card>(), x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		
		//TOFIX, usual individual card get method instead?
		System.out.println("X: "+super.getX()+" Y: "+super.getY());
		super.peek().draw(g, super.getX(), super.getY());
		System.out.println("DRAW");
	}

}
