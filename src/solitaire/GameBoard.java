package solitaire;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class GameBoard {
	
	private Stack[] cards = new Stack[5];
	
	public GameBoard() {
		initializeStacks();
	}
	
	private void initializeStacks() {
		
	}

	public void pressedAt(MouseEvent press) {
		System.out.println("Click");
	}

	public void releasedAt(MouseEvent release) {
		System.out.println("Release");
		
		//temporary bool
		boolean isDragRelease;
		if (isDragRelease) {
			if (legal) {
				if (stack1IsAPlayStack) {
					
				}
				else {
					
				}
			}
		}
		
	}

	public void draggedAt(MouseEvent drag) {
		System.out.println("Dragged");
	}
	
	private void autoClick() {
		
	}

	public void draw(Graphics g) {
		for (Stack s: cards) {
			s.draw(g);
		}
	}

}
