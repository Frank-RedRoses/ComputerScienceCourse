package week3.arrays.lectures;

/******************************************************************************
 *  Compilation:  javac CouponCollector.java
 *  Execution:    java CouponCollector n
 *
 *  Given n distinct card types, how many random cards do you need
 *  do collect before you have (at least) one of each type?
 *  This program simulates this random process.
 *
 *
 *  % java CouponCollector 1000
 *  6583
 *
 *  % java CouponCollector 1000
 *  6477
 *
 *  % java CouponCollector 1000000
 *  12782673
 *
 ******************************************************************************/

public class CouponCollector {
    
    public static void main(String[] args) {
        int nCardsType = Integer.parseInt(args[0]);         // number of cards to be collected
        boolean[] isCollected = new boolean[nCardsType];    // isCollected[i] = true if card i has been collected
        int count = 0;                                      // total cards obtained
        int distinct = 0;                                   // number of distinct cards

        // repeatedly choose a random card and check whether it is a new one
        while (distinct < nCardsType) {
            int value = (int) (Math.random()*nCardsType);
            count++;
            if (!isCollected[value]) {
                distinct++;
                isCollected[value] = true;
            }
        }

        // print the total number of cards collected
        System.out.println(count);
    }
}
