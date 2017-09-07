package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Stack {

	private double x, y;

	List<Card> cards = new ArrayList<>();

	public Stack() {

	}

	public Stack(List<Card> cards) {
		this.cards = cards;
	}

	public void add(Card cardToAdd) {
		cards.add(cardToAdd);
	}

	public void add(List<Card> cardsToAdd) {
		for (Card cardToAdd : cardsToAdd)
			add(cardToAdd);
	}

	public abstract void draw(Graphics g);

}
