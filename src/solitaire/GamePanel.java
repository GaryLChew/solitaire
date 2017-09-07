package solitaire;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class GamePanel extends JPanel {

	Dimension dim = new Dimension(1060,700);
	Color backGround = new Color(0, 220, 235);
	GameBoard board = new GameBoard();
	
	
	public GamePanel() {
		this.setPreferredSize(dim);
		this.setBackground(backGround);
		setUpMouseListeners();
	}
	
	private void setUpMouseListeners() {
		setUpML();
		setUPMML();
	}

	private void setUPMML() {
		// MouseMotionListener allows for listening for dragging
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent drag) {
//				System.out.println("Dragged at X:" + drag.getX()+", Y:"+drag.getY());
				board.draggedAt(drag);
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}
			
		});
	}

	private void setUpML() {
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}

			@Override
			public void mousePressed(MouseEvent press) {
//				System.out.println("Pressed at X:" + press.getX()+", Y:"+press.getY());
				board.pressedAt(press);
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent release) {
//				System.out.println("Released at X:" + release.getX()+", Y:"+release.getY());
				board.releasedAt(release);
				repaint();
			}
			
		});
		this.requestFocusInWindow();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		board.draw(g);;
	}
	
}
