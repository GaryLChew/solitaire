package solitaire;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.spi.CalendarDataProvider;

public abstract class Stack {

	private double x, y;

	private List<Card> cards = new ArrayList<>();

	private StackType type;

	private static Image emptyStackImage;

	public enum StackType {
		TABLEAU, FOUND, DECK, WASTE
	}

	public Stack() {
		// TOFIX, should all ArrayList initializations contain a parameter in
		// <>?
		cards = new ArrayList<>();
		if (emptyStackImage == null) {
			openEmptyStackImage();
		}
	}

	public Stack(List<Card> cards) {
		this.cards = cards;
	}

	public Stack(List<Card> cards, double x, double y) {
		this.cards = cards;
		this.x = x;
		this.y = y;
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

	// returns cardIndex that was selected

	public int clickInBounds(MouseEvent click) {
		int x = (int) Utility.inverseScaled(click.getX());
		int y = (int) Utility.inverseScaled(click.getY());
		return clickInBounds(x, y);
	}

	// This should never be used outside of the Stack class or its subclasses
	// Or at the very least, inverse scaled coordinates must be inputed
	public abstract int clickInBounds(int clickX, int clickY);

	public abstract boolean legalMove(Stack entry);

	// TOFIX Should this be static? It doesn't really matter though.
	private static void openEmptyStackImage() {
		emptyStackImage = Utility.openImagePath(Directories.cardEmptyFP);
	}

	public abstract void draw(Graphics g);

	public void drawEmpty(Graphics g) {
		double scale = .9;
		double xBorder = ((1 - scale) * Card.CARD_WIDTH) / 2;
		double yBorder = ((1 - scale) * Card.CARD_HEIGHT) / 2;
		Utility.drawScaled(g, emptyStackImage, x + xBorder, y + yBorder, Card.CARD_WIDTH * scale,
				Card.CARD_HEIGHT * scale);
	}

	// Getters

	public List<Card> getCards() {
		return cards;
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	// TOFIX remove this method?

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

	public void addCardsFromStack(Stack stackToAdd) {
		add(stackToAdd.getCards());
	}

	public Card remove(int index) {
		return cards.remove(index);
	}

	// TOFIX, add null checkers
	public Card peek() {
		if (size() == 0) {
			return null;
		}
		return cards.get(cards.size() - 1);
	}

	public Card pop() {
		if (size() == 0) {
			return null;
		}
		return remove(cards.size() - 1);
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
