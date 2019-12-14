package edu.vtc.oop.bmoreinis.cards;

/**
 * Represents a standard playing card
 * 
 * @author jeremy
 *
 */
public class Card implements Comparable<Card> {
	public static final int CLUBS = 1;
	public static final int DIAMONDS = 2;
	public static final int SPADES = 3;
	public static final int HEARTS = 4;
	public static final int[] SUITS = { CLUBS, DIAMONDS, SPADES, HEARTS };
	public static final int[] RANKS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	/** Card's rank, 1 - 13, 1 = Ace, 2 = 2, ... 11 = J, 12 = Q, 13 = K */
	private int rank;

	/** Card's suit */
	private int suit;
	
	private void repOK() {
		// Rank must be between 1 and 13
		assert (rank >= 1 && rank <= 13);

		// Suit must be one of the allowed values
		assert (suit == CLUBS || suit == DIAMONDS || suit == SPADES || suit == HEARTS);
	}

	/**
	 * 
	 * @param rank - >= 1, <= 13
	 * @param suit - must be one of {@link #CLUBS}, {@link #DIAMONDS},
	 *             {@link #SPADES}, {@link #HEARTS}
	 * @throws IllegalArgumentException if rank or suit are invalid
	 */
	public Card(int rank, int suit) throws IllegalArgumentException {
		if (rank < 1 || rank > 13) {
			throw new IllegalArgumentException("Invalid rank: " + rank);
		}

		if (suit != CLUBS && suit != DIAMONDS && suit != SPADES && suit != HEARTS) {
			throw new IllegalArgumentException("Invalid suit: " + suit);
		}

		this.rank = rank;
		this.suit = suit;
		repOK();
	}

	/**
	 * @return the card's rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @return the card's suit
	 */
	public int getSuit() {
		return suit;
	}

	@Override
	public String toString() throws IllegalStateException {
		String rankString;
		if (rank == 1) {
			rankString = "A";
		} else if (rank == 11) {
			rankString = "J";
		} else if (rank == 12) {
			rankString = "Q";
		} else if (rank == 13) {
			rankString = "K";
		} else {
			rankString = Integer.toString(rank);
		}

		String suitString;
		if (suit == CLUBS) {
			suitString = "C";
		} else if (suit == DIAMONDS) {
			suitString = "D";
		} else if (suit == SPADES) {
			suitString = "S";
		} else {
			suitString = "H";
		}

		return rankString + suitString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + suit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
	/**
	 * Compares this card instance to another. Cards are compared by rank first and
	 * then suit with the ordering {@link #CLUBS} < {@link #DIAMONDS} <
	 * {@link #SPADES} < {@link #HEARTS}. Aces are always high.
	 * 
	 * @param other, never null
	 * @return -1 if this card is less than other, 0 if cards are equal, 1 if
	 *         this card is larger than other
	 * 
	 * @throws NullPointerException if other is null
	 */
	@Override
	public int compareTo(Card other) {
		if (other == null) {
			throw new NullPointerException("other cannot be null");
		}

		if (this.rank < other.rank) {
			return -1;
		} else if (this.rank > other.rank) {
			return 1;
		} else {
			return suitCompare(other);
		}	
	}

	/**
	 * Compares the suits of two cards. Suit rank is defined so that {@link #CLUBS}
	 * < {@link #DIAMONDS} < {@link #SPADES} < {@link #HEARTS}.
	 * 
	 * @param other
	 * @return -1 if this card is of lower suit, 0 if suits are equal, +1 if this
	 *         card is of higher suit
	 * @throws NullPointerException if other is null
	 */
	private int suitCompare(Card other) throws NullPointerException {
		if (other == null) {
			throw new NullPointerException("other cannot be null");
		}

		// If suits are equal, return 0
		if (this.suit == other.suit) {
			return 0;
		}

		// Note that several branches here don't need to be included because by getting
		// to this line we know the suits aren't equal
		if (this.suit == CLUBS) {
			return -1;
		} else if (this.suit == DIAMONDS) {
			if (other.suit == CLUBS) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.suit == SPADES) {
			if (other.suit == HEARTS) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 1;
		}
	}
}
