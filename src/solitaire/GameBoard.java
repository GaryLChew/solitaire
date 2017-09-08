package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import solitaire.Stack.StackType;

public class GameBoard {

	private Stack[] stacks;

	public GameBoard() {
		dealStacks();
		reserveStack = new ArrayList<>();
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
		int tableauX = deckX + deckToTableauX, tableauY = topPadding + 20;
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
			stacks[i] = new FoundStack(foundX, foundY + foundToFoundY * (i - 7));
		}

		// Deals Deck
		stacks[11] = new DeckStack(fullDeck.dealRandomCards(10), deckX, deckY);

		// Creates empty Waste
		stacks[12] = new WasteStack(wasteX, wasteY);

	}

	public void pressedAt(MouseEvent press) {
		System.out.println("Click");
		this.press = press;
	}

	// TOFIX Maybe move this saved click somewhere else
	MouseEvent press;

	public void releasedAt(MouseEvent release) {
		System.out.println("Release");

		int distBtwnX = press.getX() - release.getX();
		int distBtwnY = press.getY() - release.getY();
		double distBtwn = Math.sqrt(distBtwnX ^ 2 + distBtwnY ^ 2);

		if (distBtwn < 10) {
			quickClick(press);
		}

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

	// called when the user clicks on a stack normally
	private void quickClick(MouseEvent click) {
		int clickX = click.getX(), clickY = click.getY();
		for (Stack s : stacks) {
			int cardIndexSelected = s.clickInBounds(clickX, clickY);
			if (cardIndexSelected >= 0) {
				if (s.getType() == StackType.DECK) {
					cycleWaste();
				}
			}
		}
	}
	
	List<Card> reserveStack;

	private void cycleWaste() {
		Stack deck = stacks[11];
		Stack waste = stacks[12];
		if (deck.size() == 0) {
			while (waste.size()>0) {
				reserveStack.add(waste.remove(0));
			}
			
			while (reserveStack.size()>0) {
				Card transfer = reserveStack.remove(0);
				transfer.setFaceUp(false);
				deck.add(transfer);
			}
		} else {
			Card transfer = deck.pop();
			transfer.setFaceUp(true);
			waste.add(transfer);
		}

		if (waste.size() > 3) {
			reserveStack.add(waste.remove(0));
		}
	}

	public void draw(Graphics g) {
		for (Stack s : stacks) {
			s.draw(g);
		}
	}

}
