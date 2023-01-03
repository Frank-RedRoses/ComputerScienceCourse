package week3.arrays.lectures;

public class Deck {
    public static void main(String[] args) {
        
        String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "Ace"
        };

        // Initialize the deck
        int deckSize = SUITS.length * RANKS.length; 
        String[] deck = new String[deckSize];

        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length; j++) {
                deck[i*RANKS.length + j] = RANKS[j] + " of " + SUITS[i];  
            }   
        }
     
        // shuffle
        for (int i = 0; i < deckSize; i++) {
            int r = i + (int) (Math.random()*(deckSize - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // print shuffled deck
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
        
    }

    
    
}
