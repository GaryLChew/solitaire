package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameBoard {

	private Stack[] stacks;

	public GameBoard() {
		dealStacks();
	}

	/*
	 * stacks index numbering 0-6 Tableau, 7-10 = Foundation, 11 = Deck, 12 =
	 * Waste
	 * 
	 */

	// Initializes all stacks of cards and randomly deals cards to them.
	private void dealStacks() {
		stacks = new Stack[13];

		FullDeckStack fullDeck = new FullDeckStack();

		// Coordinates for stacks
		int leftPadding = (int) (Card.CARD_WIDTH / 2.9), topPadding = (int) (Card.CARD_HEIGHT / 1.2);

		int deckX = leftPadding, deckY = topPadding;

		int deckToWasteY = Card.CARD_HEIGHT + 10;
		int wasteX = deckX, wasteY = deckY + deckToWasteY;

		int deckToTableauX = Card.CARD_WIDTH + 10;
		int tableauX = deckX + deckToTableauX, tableauY = topPadding;
		int tableauToTableauX = Card.CARD_WIDTH + 10;

		int rightmostTableauX = tableauX + tableauToTableauX * 6;
		int rmTableauToFoundX = Card.CARD_WIDTH + 10;
		int foundX = rightmostTableauX + rmTableauToFoundX, foundY = topPadding;
		int foundToFoundY = Card.CARD_HEIGHT + 10;

		// Deals Tableau
		for (int i = 0; i <= 6; i++) {
			stacks[i] = new TableauStack(fullDeck.dealRandomCards(i + 1), tableauX + tableauToTableauX * i, tableauY);
		}

		// Creates empty Foundation
		for (int i = 7; i <= 10; i++) {
			stacks[i] = new FoundStack(fullDeck.dealRandomCards(1), foundX, foundY + foundToFoundY * (i - 7));
		}

		// Deals Deck
		stacks[11] = new DeckStack(fullDeck.dealRandomCards(1), deckX, deckY);

		// Creates empty Waste
		stacks[12] = new WasteStack(fullDeck.dealRandomCards(3), wasteX, wasteY);

	}

	public void pressedAt(MouseEvent press) {
		System.out.println("Click");
	}

	public void releasedAt(MouseEvent release) {
		System.out.println("Release");

		// temporary bool

		/*
		 * boolean isDragRelease; if (isDragRelease) { if (legal) { if
		 * (stack1IsAPlayStack) {
		 * 
		 * } else {
		 * 
		 * } } }
		 */

	}

	public void draggedAt(MouseEvent drag) {
		System.out.println("Dragged");
	}

	private void autoClick() {

	}

	public void draw(Graphics g) {
		for (Stack s : stacks) {
			s.draw(g);
		}
	}

}
