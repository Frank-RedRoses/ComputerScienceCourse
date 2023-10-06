package week5.functionsandlibraries.booksite.staticmethods;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Coupon.java
 *  Execution:    java Coupon n
 * 
 * Coupon.java is a version of CouponCollector.java that better separates the 
 * individual components of the computation
 *
 *  % java Coupon 1000
 *  6522
 *
 *  % java Coupon 1000
 *  6481
 *
 *  % java Coupon 1000000
 *  12783771
 *
 ******************************************************************************/

public class Coupon {

    // return a random coupon between 0 and n-1
    public static int getCoupon(int n) {
        return (int) (Math.random() * n);
    }

    // return the number of card you collect before obtaining one of each of the n types
    public static int collect(int n) {
        boolean[] isCollected = new boolean[n]; // true if a card type i already collected
        int count = 0;                          // number of cards collected
        int distinct = 0;                        // number of distinct card types collected

        // repeat until you've colleted all n types
        while (distinct < n) {
            int value = getCoupon(n);           // pick a random card
            count++;                            // keep the count
            if (!isCollected[value]) {          // discover a new card type
                distinct++;
                isCollected[value] = true;
            }
        }
        return count; 
    }

    // test client
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = collect(n);
        StdOut.println(count);
    }
    
}
