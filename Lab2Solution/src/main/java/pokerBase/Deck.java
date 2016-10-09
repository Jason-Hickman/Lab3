package pokerBase;


import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;
import pokerExceptions.DeckException;

public class Deck {

	ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if ((eSuit != eSuit.JOKER) && (eRank != eRank.JOKER)){
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
				
			}
			 
		}
		Collections.shuffle(deckCards);
	}
	
	public Deck(int NbrOfJokers) {
		this();
		for (int i=0; i<NbrOfJokers; i++){
			deckCards.add(new Card(eSuit.JOKER,eRank.JOKER,0));
		}
		Collections.shuffle(deckCards);
	}
	
	
	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);
		for (Card card1 : Wilds){
			for (Card card2 : deckCards){
				if ((card1.geteRank()==card2.geteRank())&&(card1.geteSuit()==card2.geteSuit())){
					card2.setbWild(true);
				}
			}
		}
		
	}
	public Card Draw() throws DeckException{
		if (deckCards.size() != 0){
			return deckCards.remove(0);
		}
		else throw new DeckException();
	}
}

