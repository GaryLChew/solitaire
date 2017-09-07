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
	 * stacks index numbering
	 * 0-6 Tableau, 7-10 = Foundation, 11 = Deck, 12 = Waste
	 * 
	 */
	
	private void dealStacks() {
		stacks = new Stack[13];

		FullDeckStack fullDeck = new FullDeckStack();
		
		//Deals Tableau
		for (int i = 0	; i <= 6; i++) {
			stacks[i] = (new TableauStack(fullDeck.dealRandomCards(i+1),
					Card.CARD_WIDTH / 2 + (Card.CARD_WIDTH + 10) * i, (int) (Card.CARD_HEIGHT / 1.2)));
		}
		
		//Creates empty Foundation
		for (int i = 7; i <= 10; i++) {
			stacks[i] = new FoundStack((int) (Card.CARD_WIDTH * 1.8) + 7 * (Card.CARD_WIDTH + 10),
					Card.CARD_HEIGHT / 2 + (Card.CARD_HEIGHT + 10) * i);
		}
		stacks[11] = new DeckStack(fullDeck.dealRandomCards(24), (int) (Card.CARD_WIDTH / 2.9),
				Card.CARD_HEIGHT / 2);
		stacks[12] = new WasteStack((int) (Card.CARD_WIDTH / 2.9),
				(int) (Card.CARD_HEIGHT * 1.5 + 10));
		
	}

	public void pressedAt(MouseEvent press) {
		System.out.println("Click");
	}

	public void releasedAt(MouseEvent release) {
		System.out.println("Release");
		
		//temporary bool
		
		/*
		boolean isDragRelease;
		if (isDragRelease) {
			if (legal) {
				if (stack1IsAPlayStack) {
					
				}
				else {
					
				}
			}
		}
		*/
		
	}

	public void draggedAt(MouseEvent drag) {
		System.out.println("Dragged");
	}
	
	private void autoClick() {
		
	}

	public void draw(Graphics g) {
		for (Stack s: stacks) {
			s.draw(g);
		}
	}

}
