package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import solitaire.Stack.StackType;

public class GameBoard {

	private Stack[] stacks;
	private MovingStack draggedStack;

	public GameBoard() {
		dealStacks();
		reservedCards = new ArrayList<>();
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
		stacks[12] = new WasteStack(fullDeck.dealRandomCards(1), wasteX, wasteY);

	}

	public void pressedAt(MouseEvent press) {
		System.out.println("Click");
		this.press = press;

		dragPressActions(press);
	}

	private void dragPressActions(MouseEvent press) {
		Stack stackClicked = stackClicked(press);
		if (stackClicked == null || stackClicked.size() == 0) {
			return;
		}

		draggedStack = new MovingStack(stackClicked.getX(), stackClicked.getY(), press.getX(), press.getY());

		StackType type = stackClicked.getType();

		System.out.println("GOT HERE!");
		if (type == StackType.TABLEAU) {
			int cardIndex = stackClicked.clickInBounds(press);
			draggedStack.add(stackClicked.removeCards(cardIndex));
			draggedStack.addY(stackClicked.size() * Card.CARD_SPACING);
			draggedStack.addYOffset(-stackClicked.size() * Card.CARD_SPACING);
		} else if (type == StackType.FOUND) {
			draggedStack.add(stackClicked.pop());
		} else if (type == StackType.WASTE) {
			draggedStack.add(stackClicked.pop());
		}
	}

	// TOFIX Maybe move this saved click somewhere else
	MouseEvent press;

	public void releasedAt(MouseEvent release) {
		System.out.println("Release");
		checkIfQuickClick(release);

		if (draggedStack != null && draggedStack.size() > 0) {
			dragReleaseActions(release);
		}
	}

	private void dragReleaseActions(MouseEvent release) {
		Stack stackReleased = stackClicked(release);
		if (stackReleased == null || !stackReleased.legalMove(draggedStack)) {
			returnDraggedStackToOriginal();
			return;
		}

		StackType type = stackReleased.getType();
		if (type == StackType.TABLEAU) {
			stackReleased.addCardsFromStack(draggedStack);
			draggedStack = null;
			// Maybe move this to another method so I don't have to repeat it
			// twice or make this better somehow
			Stack stackPressed = stackClicked(press);
			if (stackPressed.size() > 0) {
				stackPressed.peek().setFaceUp(true);
			}
		} else if (type == StackType.FOUND) {
			stackReleased.addCardsFromStack(draggedStack);
			draggedStack = null;
			Stack stackPressed = stackClicked(press);
			if (stackPressed.size() > 0) {
				stackPressed.peek().setFaceUp(true);
			}
		}
	}

	private void returnDraggedStackToOriginal() {
		stackClicked(press).addCardsFromStack(draggedStack);
		draggedStack = null;
	}

	private void checkIfQuickClick(MouseEvent release) {
		int distBtwnX = press.getX() - release.getX();
		int distBtwnY = press.getY() - release.getY();
		double distBtwn = Math.sqrt(distBtwnX ^ 2 + distBtwnY ^ 2);

		if (distBtwn < 10) {
			quickClick(press);
		}
	}

	public void draggedAt(MouseEvent drag) {
		// System.out.println("Dragged");

		if (draggedStack != null) {
			draggedStack.drag(drag, press);
		}
	}

	// called when the user clicks on a stack normally
	private void quickClick(MouseEvent click) {
		Stack stackClicked = stackClicked(click);
		if (stackClicked == null) {
			return;
		}
		if (stackClicked.getType() == StackType.DECK) {
			cycleWaste();
		}
	}

	private Stack stackClicked(MouseEvent click) {
		int clickX = click.getX(), clickY = click.getY();
		for (Stack s : stacks) {
			int cardIndexSelected = s.clickInBounds(clickX, clickY);
			if (cardIndexSelected >= 0)
				return s;
		}
		return null;
	}

	List<Card> reservedCards;

	private void cycleWaste() {
		Stack deck = stacks[11];
		Stack waste = stacks[12];
		if (deck.size() == 0) {
			while (waste.size() > 0) {
				reservedCards.add(0, waste.remove(0));
			}

			while (reservedCards.size() > 0) {
				Card transfer = reservedCards.remove(0);
				transfer.setFaceUp(false);
				deck.add(transfer);
			}
		} else {
			Card transfer = deck.pop();
			transfer.setFaceUp(true);
			waste.add(transfer);
		}

		if (waste.size() > 3) {
			reservedCards.add(0, waste.remove(0));
		}
	}

	public void draw(Graphics g) {
		for (Stack s : stacks) {
			s.draw(g);
		}
		if (draggedStack != null)
			draggedStack.draw(g);
	}

}
