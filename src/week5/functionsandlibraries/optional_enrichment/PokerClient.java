package week5.functionsandlibraries.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

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


    /** 
     * Creates, shuffles and return a deck of "size" cards
     */
    public static int[] shuffledDeck(int size) {
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

    // Returns the first 5 cards in a given deck
    public static int[] handFiveCards(int[] deck) {
        // pick the first 5 cards in the deck
        int[] hand = new int[5];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = deck[i];
        }
        return hand;
    }

    // return only the card values of the hand, not the suits
    private static int[] cardValues(int[] hand) {
        int[] values = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            values[i] = hand[i] % 13;
        }
        return values;
    }

    // Sort the hand keeping cards of equal value together.
    public static void sortByValue(int[] hand) {
        // Sort by card value in ascending order
        // (4 Aces, 4 2s, 4 3s, ..., 4 Kings)
        for (int i = 1; i < hand.length; i++) {
            // Sorting by comparinson to put the lower %13 values 
            // in the first positions of the hand.
            for (int j = i; j > 0 && hand[j] % 13 < hand[j - 1] % 13; j--)
            swap(hand, j, j - 1);
        }
        /* *******************************************************************
         * Note: The suit order doesn't matter in the hand ranking.
         * To sort keeping the suit order do next:
         * First sort by suit in ascending order using the deck index values
         * 0 - 12   Ace to K clubs,
         * 13 - 25  Ace to K spades,
         * 26 - 38  Ace to K diamond,
         * 39 - 51  Ace to K heart.
         * 
         * for (int i = 1; i < hand.length; i++) {
         *    // sorting by comparinson against lower indexes already sorted  
         *    for (int j = i; j > 0 && hand[j] < hand[j - 1]; j--) {
         *        swap(hand, j, j - 1);
         *    }
         * }
         * 
         * Then, sort by card value using the previous for loop with %13.
         * 
         * for (int i = 1; i < hand.length; i++) {
         *    for (int j = i; j > 0 && hand[j] % 13 < hand[j - 1] % 13; j--)
         *    swap(hand, j, j - 1);
         * }
         ******************************************************************* */
    }

    /**
     * Returns the rank of the outcome hand from 0 (worse) to 7 (better).
     * The hand array must be sorted before calling this method.
     * <pre>
     * hand outcome values:
     * i - hand
     * 0 - one high Card
     * 1 - one pair
     * 2 - two pairs
     * 3 - three of a kind
     * 4 - straight
     * 5 - flush
     * 6 - full house
     * 7 - straight flush
     * </pre>
     */
    public static int handRanking(int[] sortedHand) {
        int pairsInHand = pairsIn(sortedHand);
        if (pairsInHand < 2 && hasThreeOfAKind(sortedHand)) {
            if (pairsInHand == 1) return 6;     // Full house
            else return 3;                      // Three of a kind
        } else if (pairsInHand == 0 && hasStraight(sortedHand)) {
            if (hasFlush(sortedHand)) return 7;       // Straight Flush
            else return 4;                      // Straight        
        } else if (hasFlush(sortedHand)) {
            return 5;                           // Flush           
        } else return pairsInHand;              // Two, one or no pairs.
    }

    // Check for a flush in hand (5 cards same suit). Includes royal flush
    public static boolean hasFlush(int[] hand) {
        int suit = hand[0] / 13;
        for (int i = 1; i < hand.length; i++) {
            if (hand[i] / 13 != suit)
                return false;
        }
        return true;
    }

    // Looks for two pairs in a sorted hand (includes full house)
    public static boolean hasTwoPairs(int[] sortedHand) {
        int[] cards = cardValues(sortedHand);
        int nPair = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i] == cards[i + 1]) {
                nPair++;
                i++;
            }
        }
        return nPair == 2;
    }

    // Look for any kind of pair in a sorted hand (includes two-pairs and 
    // three of a kind)
    public static boolean hasOnePair(int[] sortedHand) {
        int[] cards = cardValues(sortedHand);
        for (int i = 0; i < sortedHand.length - 1; i++) {
            if (cards[i] == cards[i + 1])
                return true;
        }
        return false;
    }

    // Another way is to count the numbers of pairs in a sorted hand
    public static int pairsIn(int[] sortedHand) {
        int[] cards = cardValues(sortedHand);                   // Get the card value
        int nPair = 0;                                          // To count the pairs in the hand
        for (int i = 0; i < cards.length - 1; i++) {
            if (i < 2 && cards[i] == cards[i + 3]) return 2;    // Two equal pairs
            else if (i < 3 && cards[i] == cards[i + 2]) 
                i += 2;                                         // Discard Three of a kind cards
            else if (cards[i] == cards[i + 1]) {       // Check for a pair
                nPair++;                                        // Count the pair
                i++;                                            // Increase to avoid checking the next card (the card is part of the pair) 
            }
        }
        return nPair;
    }

    // Look for three of a kind cards in a sorted hand (inclusive two pairs of the same value)
    public static boolean hasThreeOfAKind(int[] sortedHand) {
        int[] cards = cardValues(sortedHand);
        for (int i = 0; i < cards.length - 2; i++) {
            if (cards[i] == cards[i + 2])
                return true;
        }
        return false;
    }

    // return true for a three of a kind and one pair in a sorted hand (Full House)
    public static boolean isFullHouse(int[] sortedHand) {
        int[] cards = cardValues(sortedHand);
        return (cards[0] == cards[1] && cards[2] == cards[4])
                || (cards[0] == cards[2] && cards[3] == cards[4]);
    }

    // Check for a Straigth in a sorted hand
    public static boolean hasStraight(int[] sortedHand) {
        int[] cards = cardValues(sortedHand);
        // possible 10 to Ace case
        if (cards[0] == 0 && cards[1] == 9) {
            // put Ace card on the last position in the hand
            cards[0] = 13;                     
            for (int i = 0; i < cards.length - 1; i++) {
                swap(cards, i, i + 1);  // prepare card values to check ascending order.
                swap(sortedHand, i, i + 1);   // prepare hand to order from 10 to Ace.
            }
        }
        // check for consecutive values 
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] != cards[i - 1] + 1) return false;
        }
        /*    
        if (cards[0] == 0 && cards[1] == 9) {  // possible 10 to Ace case
            for (int i = 2; i < cards.length; i++) {
                if (cards[i - 1] != cards[i] - 1)
                    return false;
            }
            // Move Ace card to end position
            for (int i = 0; i < cards.length - 1; i++) {
                swap(hand, i, i + 1);
            }
        } else {    // check for normal consecutive values 
            for (int i = 1; i < cards.length; i++) {
                if (cards[i - 1] != cards[i] - 1)
                    return false;
            }
        }
        */
        return true;
    }

    // swap two cards positions
    public static void swap(int[] hand, int indexA, int indexB) {
        int temp = hand[indexA];
        hand[indexA] = hand[indexB];
        hand[indexB] = temp;
    }

    // (Debug) Print cards of the given deck (card value and suit). 
    private static void printHand(int[] deck) {
        StdOut.print("hand = { ");
        for (int i = 0; i < deck.length; i++) {
            // print the value
            switch (deck[i] % 13) {
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
            switch (deck[i] / 13) {
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

    // (Debug) Print the index value representing the card in a the given deck (from 0 to 51)
    private static void printCardInternalValue(int[] deck) {
        StdOut.print("Cards = { ");
        for (int i = 0; i < deck.length; i++) {
            StdOut.print(deck[i] + " ");
        }
        StdOut.print("} ");
    }

    /** Print theoretical curve
     * The Probability of drawing a given hand is calculated by dividing the 
     * number of ways of drawing the hand (Frequency) by the total number of 
     * 5-card hands (the sample space (52 choose 5) = 2,598,960 ).
     * 
     * <pre>hand outcome values:
     * i - hand
     * 0 - one high Card
     * 1 - one pair
     * 2 - two pairs
     * 3 - three of a kind
     * 4 - straight
     * 5 - flush
     * 6 - full house
     * 7 - straight flush
     * </pre>
     */
    public static void theoryCurve() {
        int totalPossibleHands = 2598960;
        double[] theoreticalValues = new double[8];
        theoreticalValues[0] = 1302540.0 / totalPossibleHands;  // One high Card
        theoreticalValues[1] = 1098240.0 / totalPossibleHands;  // one pair
        theoreticalValues[2] = 123552.0 / totalPossibleHands;   // two pairs
        theoreticalValues[3] = 54912.0 / totalPossibleHands;    // three of a kind
        theoreticalValues[4] = 10200.0 / totalPossibleHands;    // stright
        theoreticalValues[5] = 5108.0 / totalPossibleHands;     // flush
        theoreticalValues[6] = 3744.0 / totalPossibleHands;     // full house
        theoreticalValues[7] = 36.0 / totalPossibleHands;       // straight flush
        StdStats.plotLines(theoreticalValues);
    }

    public static void main(String[] args) {
        /*
         * Array to store the frequency of hands
         * i - Hand
         * 0 - one high Card
         * 1 - one pair
         * 2 - two pairs
         * 3 - three of a kind
         * 4 - straiht
         * 5 - flush
         * 6 - full house
         * 7 - straight flush
         */
        int[] handsFreq = new int[8];
        int totalTrials = 500000;

        for (int trials = 0; trials < totalTrials; trials++) {
            // Initialize the deck, get a 5 card hand and sort the hand
            int[] deck = shuffledDeck(52);
            int[] hand = handFiveCards(deck);
            sortByValue(hand);
            // add dealed hand to count
            handsFreq[handRanking(hand)]++;
        }

        /* Plot the outcome values of the simulation.
         * Normalize outcomes between 0 and 1.
         * i - Hand
         * 0 - one high Card
         * 1 - one pair
         * 2 - two pairs
         * 3 - three of a kind
         * 4 - straight
         * 5 - flush
         * 6 - full house
         * 7 - straight flush
         */
        double[] normalized = new double[handsFreq.length];
        for (int i = 0; i < normalized.length; i++) {
            normalized[i] = (double) handsFreq[i] / totalTrials;
        }
        // StdStats.plotBars(normalized);

        // plot theoretical values of outcomes
        // theoryCurve();

        // print the outcomes
        StdOut.println("Estimated probabilities of " + totalTrials + " dealed hands:");
        StdOut.println("High card hand = " + 100.0 * normalized[0] + "%");
        StdOut.println("One pair hand = " + 100.0 * normalized[1] + "%");
        StdOut.println("Two pairs hand = " + 100.0 * normalized[2] + "%");
        StdOut.println("Three of a kind = " + 100.0 * normalized[3] + "%");
        StdOut.println("Straight hand = " + 100.0 * normalized[4] + "% (" + handsFreq[4] + ")");
        StdOut.println("Flush = " + 100.0 * normalized[5] + "% (" + handsFreq[5] + ")");
        StdOut.println("Full house = " + 100.0 * normalized[6] + "% (" + handsFreq[6] + ")");
        StdOut.println("Straight flush hand = " + 100.00 * normalized[7] + "% (" + handsFreq[7] + ")");

        int[] ex = {3,42,29,0,43};
        sortByValue(ex);
        printHand(ex);
        StdOut.println("pairs = " + pairsIn(ex));
    }
}
