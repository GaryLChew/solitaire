package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Stack {

	private double x, y;

	private List<Card> cards = new ArrayList<>();

	private StackType type;

	public enum StackType {
		TABLEAU, FOUND, DECK, WASTE
	}

	public Stack() {

	}

	public Stack(List<Card> cards) {
		this.cards = cards;
	}

	public Stack(List<Card> cards, double x, double y) {
		this.cards = cards;
		this.x = x;
		this.y = y;
	}

	public void add(Card cardToAdd) {
		cards.add(cardToAdd);
	}

	public void add(int index, Card cardToAdd) {
		cards.add(index, cardToAdd);
	}

	public void add(List<Card> cardsToAdd) {
		for (Card cardToAdd : cardsToAdd)
			add(cardToAdd);
	}

	public Card remove(int index) {
		return cards.remove(index);
	}

	// removes and returns cards after and including the index specified
	public List<Card> removeCards(int index) {
		List<Card> cardsToRemove = new ArrayList<>();
		// TOFIX May have to fix this < sign later
		while (index < size()) {
			cardsToRemove.add(remove(index));
		}
		return cardsToRemove;
	}

	public Card pop() {
		return remove(cards.size() - 1);
	}

	// returns cardIndex that was selected

	public int clickInBounds(MouseEvent click) {
		return clickInBounds(click.getX(), click.getY());
	}

	public abstract int clickInBounds(int clickX, int clickY);

	public abstract void draw(Graphics g);

	// Getters

	public List<Card> getCards() {
		return cards;
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	// TOFIX remove this method?
	public Card peek() {
		return cards.get(cards.size() - 1);
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	// for quick access
	public int size() {
		return cards.size();
	}

	public StackType getType() {
		return type;
	}

	public void setType(StackType type) {
		this.type = type;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void addY(double toAdd) {
		y += toAdd;
	}

}
