package edu.vtc.oop.bmoreinis.cards;

public class War {
	
	// Tracks whether there is a winner
	private static boolean winner = false;
	
	// Announces the winner
	private static String winningDeck = "Undefined";
	
	// Create new Player One Deck
	public static Deck playerOne = Deck.standardDeck();
	
	// Create empty Player One Discards Deck
	private static Deck playerOneDiscards = new Deck();
	
	// Create new Player Two Deck
	private static Deck playerTwo = Deck.standardDeck();
	
	// Create empty Player Two Discards Deck
	private static Deck playerTwoDiscards = new Deck();
	
	// Create empty Last Hand Deck
	private static Deck lastHand = new Deck();
	
	// Create empty Player One War Deck
	private static Deck warDeckOne = new Deck();
	
	// Create empty Player Two War Deck
	private static Deck warDeckTwo = new Deck();
	
	// Count the wars 
	private static int wars = 0;
	
	// Create values for multiple wars
	private static String[] duples = { "", "Double", "Triple", "Quadruple", "Quintuple", "Endless"};
	
	// Plays a new hand (recursive)
	public static boolean newHand() {
		if (!playerOne.isEmpty()) {
			System.out.println("Play One plays "+playerOne.seeTopCard().toString());			
			if (!playerTwo.isEmpty()) {
				System.out.println("Play Two plays "+playerTwo.seeTopCard().toString());
				String handWinner = callHand(playerOne.drawTopCard(),playerTwo.drawTopCard());
				if (!handWinner.equals("wasWar")){
					System.out.println(handWinner + " won that hand: "+lastHand.toString());
				}
				emptyLastHand();
			} 
			else {
				if (!playerTwoDiscards.isEmpty()) {
					useDiscards(playerTwo, playerTwoDiscards);
					newHand();
				}
				else {
					winningDeck="Player One";
					return true;
				}
			}
		}
		else {
			if (!playerOneDiscards.isEmpty()) {
				useDiscards(playerOne,playerOneDiscards);
				newHand();
			}
			else {
				winningDeck="Player Two";
				return true;
			}
		}
		return false;
	}
	
	// Calls the winner of a hand
	public static String callHand(Card cardOne, Card cardTwo) {
		lastHand.addCard(cardOne);
		lastHand.addCard(cardTwo);
		if (cardOne.getRank() > cardTwo.getRank()) {
			playerOneDiscards.addCard(cardOne);
			playerOneDiscards.addCard(cardTwo);
			return "Player One";
		}
		else if (cardOne.getRank() < cardTwo.getRank()) {
			playerTwoDiscards.addCard(cardOne);
			playerTwoDiscards.addCard(cardTwo);
			return "Player Two";
		}
		else {
			System.out.println("War!");
			return warWinner();
		}
	}
	
	// Processes a war - note, this is a bit buggy
	public static String warWinner() {
		if (playerOne.size()>3) {
			for (int dcard=0;dcard<3;dcard++) {
				warDeckOne.addCard(playerOne.drawTopCard());
			}			
			System.out.println("Player One shows "+warDeckOne.seeTopCard().toString());
			if (playerTwo.size()>3) {
				for (int dcard=0;dcard<3;dcard++) {
					warDeckTwo.addCard(playerTwo.drawTopCard());
				}	
				System.out.println("Player Two shows "+warDeckTwo.seeTopCard().toString());
				String handWinner = warHandWinner();
				System.out.println(handWinner + " won that war: "+lastHand.toString());
				emptyLastHand();
				return "wasWar";
			} 
			else {
				if (!playerTwoDiscards.isEmpty()) {
					useDiscards(playerTwo, playerTwoDiscards);
				}
				return warWinner();
			}
		}
		else {
			if (!playerOneDiscards.isEmpty()) {
				useDiscards(playerOne,playerOneDiscards);
				return warWinner();
			}
			else {
				return "Player Two";
			}
		}
	}
	
	// Calls the winner of a war
	public static String warHandWinner() {
		if (warDeckOne.seeTopCard().getRank() > warDeckTwo.seeTopCard().getRank()) {
			for (int dcard=0;dcard<3;dcard++) {
				lastHand.addCard(warDeckOne.seeTopCard());
				playerOneDiscards.addCard(warDeckOne.drawTopCard());
				lastHand.addCard(warDeckTwo.seeTopCard());
				playerOneDiscards.addCard(warDeckTwo.drawTopCard());
			}	
			return "Player One";
		}
		else if (warDeckOne.seeTopCard().getRank() < warDeckTwo.seeTopCard().getRank()) {
			for (int dcard=0;dcard<3;dcard++) {
				lastHand.addCard(warDeckOne.seeTopCard());
				playerTwoDiscards.addCard(warDeckOne.drawTopCard());
				lastHand.addCard(warDeckTwo.seeTopCard());
				playerTwoDiscards.addCard(warDeckTwo.drawTopCard());
			}	
			return "Player Two";
		}
		else {
			wars++;
			System.out.println(duples[wars]+" war!");
			return warWinner();
		}
	}
	
	// When playing deck is empty and discards deck is not, swap and shuffle
	public static void useDiscards(Deck deck, Deck discards) {
		while (!discards.isEmpty()) {
			Card c = discards.drawTopCard();
			deck.addCard(c);  
		}
		deck.shuffle();
	}
	
	
	// When after each turn, empty the lastHand deck
	public static void emptyLastHand() {
		while (!lastHand.isEmpty()) {
			Card c = lastHand.drawTopCard(); 
		}
	}
	
	// Manages game play
	public static void main(String[] args) {
		
		// Preparation
		System.out.println("Play War!");
		System.out.println("Shuffling decks for Player One and Player Two....");
		playerOne.shuffle();
		playerTwo.shuffle();
		
		// Play 
		while (winner==false) {
			winner = newHand();
		}
		System.out.println(winningDeck+" won the war game!");
	}

}
