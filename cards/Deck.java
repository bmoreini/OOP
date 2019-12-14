package edu.vtc.oop.bmoreinis.cards;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Deck{
	
	private Stack<Card> cards;
	
	private void repOK() {
		// Cards may not be null
		assert(cards !=null);
		
		// No null Cards in cards
		for (Card c : cards) {
			assert(c != null);
		}
		
	}
	
	@Override
	public String toString() {
		return cards.toString();
	}
	
	/* Constructor
	 * Creates an empty deck of cards
	 */
	public Deck() {
		cards = new Stack<>();
		repOK();
	}
	
	/**
	 * @return a standard 52-card deck
	 */
	public static Deck standardDeck() {
		Deck deck = new Deck();
		
		for (int suit : Card.SUITS) {
			for (int rank : Card.RANKS) {
				deck.addCard(new Card(rank,suit));
			}
		}
		
		return deck;
	}
	
	
	/**
	 * Checks if specified deck is empty.  
	 * @return true if there are zero cards in the deck.
	 */
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	/**
	 * Returns the size of a deck, since I am not apparently allowed to do so without doing this grumble grumble
	 * @return in 
	 * @throws NullPointerException
	 */
	public int size() throws NullPointerException {
		if (cards==null) {
			throw new IllegalOperationException("Can't size a null deck.");
		}
		else {
			return cards.size();
		}
	}
	

	/**
	 * Randomizes the order of the cards
	 * @throws IllegalOperationException if there are no cards in the deck.
	 */
	
	public void shuffle() throws IllegalOperationException {
		if (this.isEmpty()) {
			throw new IllegalOperationException("Can't shuffe an empty deck.");
		}
		Collections.shuffle(cards);
	}
	
	/**
	 * Shows the top card without modifying deck contents.
	 * @return the Card to the top of the deck
	 * @throws IllegalOperationException if the deck is empty.
	 */
	public Card seeTopCard() throws IllegalOperationException {
		if (cards.isEmpty()) {
			throw new IllegalOperationException("Empty deck: no cards to show.");
		}
		else return cards.peek();
	}
	
	
	/**
	 * Draw the top card from the deck.
	 * @throws IllegalOperationException if the deck is empty.
	 */
	public Card drawTopCard() throws IllegalOperationException {
		if (cards.isEmpty()) {
			throw new IllegalOperationException("Empty deck: no cards to show.");
		}
		else return cards.pop();
	}
	
	/**
	 * Adds a card to the top of the deck.
	 * @param c - the card added to the deck, never null
	 * @throws NullPointerException if c is null
	 * 
	 */
	public void addCard(Card c) throws NullPointerException {
		if (c==null) {
			throw new IllegalOperationException("Can't add a null card.");
		}
		else cards.push(c);
	}
	
	public static void main(String[] args) {
		Deck deck = Deck.standardDeck();
		deck.shuffle();
	}

}
