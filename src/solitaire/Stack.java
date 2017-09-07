package solitaire;

import java.util.ArrayList;
import java.util.List;

public abstract class Stack {
	
	private double x,y;
	
	List<Card> cards = new ArrayList<>();
	
	public Stack() {
		
	}
	
	public Stack(List<Card> cards) {
		this.cards = cards;
	}
	
	public abstract void draw();
	
}
