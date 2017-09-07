package solitaire;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class FullDeckStack extends Stack {
	
	public FullDeckStack() {
		//Creates an ordered deck of 52 cards
		for (int i = 1;i<=13;i++) {
			super.getCards().add(new Card(i,"Spades",false));
			super.getCards().add(new Card(i,"Clubs",false));
			super.getCards().add(new Card(i,"Diamonds",false));
			super.getCards().add(new Card(i,"Hearts",false));
		}
	}
	
	@Override
	public void draw(Graphics g) {

	}
	
	public Card dealRandom() {
		List<Card> cards = super.getCards();
		return cards.remove((int) (Math.random() * cards.size()));
	}
	
	public List<Card> dealRandomCards(int numCards) {
		List<Card> randomCards = new ArrayList<>();
		for (int i = 0; i < numCards; i++) {
			randomCards.add(dealRandom());
		}
		return randomCards;
	}

}
