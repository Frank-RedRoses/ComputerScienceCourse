package week5.functionsandlibraries.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/* ***************************************************************************************
 * Poker analysis. Write a StdRandom and StdStats client (with appropriate static methods 
 * of its own) to estimate the probabilities of getting one pair, two pair, three of a 
 * kind, a full house, and a flush in a five-card poker hand via simulation. Divide your 
 * program into appropriate static methods and defend your design decisions. 
 * 
 * Extra credit : Add straight and straight flush to the list of possibilities.
 *
 **************************************************************************************** */
public class PokerClient {

    public static int[] shuffleDeck(int size) {
        // create and initialize the deck
        int[] deck = new int[size];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        // Shuffle the deck
        for (int i = 0; i < deck.length; i++) {
            int rnd = i + StdRandom.uniform(0, deck.length - i);
            swap(deck, i, rnd);
        }
        return deck;
    }

    public static int[] handFiveCard(int[] deck) {
        // pick the first 5 cards in the deck
        int[] hand = new int[5];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = deck[i];
        }
        return hand;
    }

    // return only the card values of the hand, not the suits
    public static int[] cardValues(int[] hand) {
        int[] values = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            values[i] = hand[i] % 13;
        }
        return values;
    }

    public static void sortBySuitAndValue(int[] hand) {
        // sorting by ascending order (Ace-12 clubs, Ace-12 spades, Ace-12 diamond, Ace-12 heart)
        for (int i = 1; i < hand.length; i++) {
            for (int j = i; j > 0 && hand[j] < hand[j - 1]; j--) {
                swap(hand, j, j - 1);
            }
        }
        // Sort only by value (equal value side by side in suit order)
        // ( aceC aceS aceD aceH, 2c 2s 2d 2h, ...., kingC kingS kingD kingH)
        for (int i = 1; i < hand.length; i++) {
            for (int j = i; j > 0 && hand[j] % 13 < hand[j - 1] % 13; j--) {
                swap(hand, j, j - 1);
            }
            // int actual = i;
            // while(actual > 0 && hand[actual] % 13 < hand[actual - 1] %13) {
            //     swap(hand, actual, actual - 1);
            //     actual--;
            // }
        }
    }

    // Check for a flush hand (5 hand same suit)
    public static boolean isFlush(int[] hand) {
        int suit = hand[0] / 13;
        for (int i = 1; i < hand.length; i++) {
            if (hand[i] / 13 != suit) return false;
        }
        return true;
    }

    // look for two pairs (includes a full house)
    public static boolean hasTwoPairs(int[] hand) {
        int[] cards = cardValues(hand);
        int nPair = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i] == cards[i + 1]) {
                nPair++;
                i++;
            }
            if (nPair == 2) return true;
        }
        return false;
    } 

    // Look for any kind of pair in the hand (inclusive two-pairs and Three of a kind)
    public static boolean hasOnePair(int[] hand) {
        int[] cards = cardValues(hand);
        for (int i = 0; i < hand.length - 1; i++) {
            if(cards[i] == cards[i + 1]) return true;
        }
        return false;
    }
    // Look for three of a kind card (inclusive two pairs of the same value)
    public static boolean hasThreeOfAKind(int[] hand) {
        int[] cards = cardValues(hand);
        for (int i = 0; i < cards.length - 2; i++) {
            if (cards[i] ==  cards[i + 2]) return true;
        }
        return false;
    }

    // return true for a three of a kind and one pair hand (Full House)
    public static boolean hasFullHouse(int[] hand) {
        int[] cards = cardValues(hand);
        return (cards[0] == cards[1] && cards[2] == cards[4]) 
            ||  (cards[0] == cards[2] && cards[3] == cards[4]);
    }

    public static boolean isStraight(int[] hand) {
        int[] cards = cardValues(hand);
        if (cards[0] == 0 && cards[1] == 9) {
            for (int i = 2; i < cards.length; i++) {
                if (cards[i - 1] != cards[i] - 1) return false; 
            }
            for (int i = 0; i < cards.length - 1; i++) {
                swap(hand, i, i + 1);
            }
        } else {
            for (int i = 1; i < cards.length; i++) {
                if (cards[i - 1] != cards[i] - 1) return false; 
            }
        }
        return true;
    }

    public static void swap(int[] hand, int indexA, int indexB) {
        int temp = hand[indexA];
        hand[indexA] = hand[indexB];
        hand[indexB] = temp;
    }
    
    public static void printHand(int [] deck) {
        StdOut.print("hand = { ");
        for (int i = 0; i < deck.length; i++) {
            // print the value
            switch(deck[i] % 13) {
                case 0:
                    StdOut.print("Ace ");
                    break;
                case 10:
                    StdOut.print("J ");
                    break;
                case 11:
                    StdOut.print("Q ");
                    break;
                case 12:
                    StdOut.print("K ");
                    break;
                default:
                    StdOut.print((deck[i] % 13 + 1) + " ");
                    break;
            }
            // print the suit
            switch(deck[i] / 13) {
                case 0:
                    StdOut.print("clubs ");
                    break;
                case 1: 
                    StdOut.print("spades ");
                    break;
                case 2: 
                    StdOut.print("diamonds ");
                    break;
                case 3: 
                    StdOut.print("hearts ");
                    break;
                default:
                    StdOut.print("Error ");
                    break;
            } 
        }
        StdOut.println("}");
    }

    public static void printCardsInternalValue(int [] deck) {
        StdOut.print("Cards = { ");
        for (int i = 0; i < deck.length; i++) {
            StdOut.print(deck[i] + " ");
        }
        StdOut.print("} ");
    }
    
    public static void main(String[] args) {
        // Counters
        int onePair = 0;
        int twoPairs = 0;
        int threeOfAKind = 0;
        int fullHouse = 0;
        int flush = 0;
        int straight = 0;
        int straightFlush = 0;
        int highCard = 0;
        int totalTrials = 500000;

        for (int  trials = 0; trials < totalTrials; trials++) {

            // Initialize the deck, get a 5 card hand and sort the hand
            int[] deck = shuffleDeck(52);
            int[] hand = handFiveCard(deck);
            sortBySuitAndValue(hand);

            // count every dealed hand
            if (hasFullHouse(hand)) {
                fullHouse++;
                // StdOut.print("Full house ");
                // printHand(hand);
            } else if (hasTwoPairs(hand)) {
                twoPairs++;
                // StdOut.print("2 pairs ");
                // printHand(hand);
            } else if (hasThreeOfAKind(hand)) {
                threeOfAKind++;
                // StdOut.print("3 of a kind ");
                // printHand(hand);
            } else if (hasOnePair(hand)) {
                onePair++;
                // StdOut.print("1 pair ");
                // printHand(hand);
            } else if (isFlush(hand) && isStraight(hand)) {
                straightFlush++;
                // StdOut.print("!!!Straight Flush!!! ");
                // printHand(hand);
            } else if (isFlush(hand)) {
                flush++;
                // StdOut.print("**Flush** ");
                // printHand(hand);
            } else if (isStraight(hand)) {
                straight++;
                // StdOut.print("**Straight** ");
                // printHand(hand);
            } else {
                highCard++;
            }
        }
         
        StdOut.println("Estimated probabilities of " + totalTrials + " dealed hands:");
        StdOut.println("High card hand = " + (100.0 * highCard) / totalTrials + "%");
        StdOut.println("One pair hand = " + (100.0 * onePair) / totalTrials + "%");
        StdOut.println("Two pairs hand = " + (100.0 * twoPairs) / totalTrials + "%");
        StdOut.println("Three of a kind = " + (100.0 * threeOfAKind) / totalTrials + "%");
        StdOut.println("Straight hand = " + (100.0 * straight) / totalTrials + "% (" + straight + ")");
        StdOut.println("Flush = " + (100.0 * flush) / totalTrials + "% (" + flush + ")");
        StdOut.println("Full house = " + (100.0 * fullHouse) / totalTrials + "% (" + fullHouse + ")");
        StdOut.println("Straight flush hand = " + (100.00 * straightFlush) / totalTrials + "% (" + straightFlush + ")");
    }


}
