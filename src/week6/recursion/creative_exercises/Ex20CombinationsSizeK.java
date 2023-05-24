package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* 2.3.20 Combinations of size k. 
 * Modify Combinations so that it takes two command-line arguments n and k, 
 * and prints out all C(n, k) = n! / (k!(n—k)!) combinations of size k. 
 * For example, when n = 5 and k = 3, you should get the following output:
 *
 * abc abd abe acd ace ade bed bee bde cde
 *
 */

public class Ex20CombinationsSizeK {
    
    // Simple modification of Ex19 comb() method.
    public static void myComb(String abc, int k) {
        myComb("", abc, k);
    }
    // My recursive method, simple modification
    private static void myComb(String prefix, String abc, int k) {
        if (abc.length() > 0) {
            // The k argument was added to print only combinations of size k.
            if (prefix.length() == k - 1)
                StdOut.println(prefix + abc.charAt(0));
            // Reduction step: The next recursive call uses a trim version of abc without
            // the char at index 0.
            // First recursion call makes a combination with the charAt(0).
            myComb(prefix + abc.charAt(0), abc.substring(1), k);
            // Second recursion call to makes a combination without the charAt(0).
            myComb(prefix, abc.substring(1), k);
        }
    }

    // Entry point to recursive method
    // print all subsets that take k of the remaining elements, with given prefix
    public static void comb( String abc, int k) {
        comb("", abc, k);
    }
    // Better implementation of comb()
    private static void comb(String prefix, String abc, int k) {
        if (abc.length() < k)       
            // Base case: If abc is shorter than k discard next recursive calls
            return;
        else if (k == 0)
            // when prefix length == initial k, print prefix
            StdOut.println(prefix);
        else {
            // Reduction step: k will decrease by 1 only when prefix gets larger
            // This recursive call will handle all possible combinations with the first char at abc.
            comb(prefix + abc.charAt(0), abc.substring(1), k - 1);
            // This recursive call makes the following prefixes discarting the first char at abc.
            comb(prefix, abc.substring(1), k);
        }
    }

    // Entry point to recursive method
    // print all subsets that take k of the remaining elements, with given prefix
    public static void comb2( String abc, int k) {
        comb2("", abc, k);
    }
    // alternative implementation
    private static void comb2(String prefix, String abc, int k) {
        // base case: k == 0 means prefix is the size of k initial value.
        if (k == 0)
            StdOut.println(prefix);
        // Reduction step: k will decrease by 1 when prefix gets larger by 1.
        else {
            for (int i = 0; i < abc.length(); i++) {
                /* 
                 * Creates every possible combination.
                 * It takes one char per iteration and on the next recursive
                 * call iterates through the rest of the remaining chars in abc
                 * to combine them (one at the time) and create different prefixes
                 * for each done iteration.
                 */ 
                comb2(prefix + abc.charAt(i), abc.substring(i + 1), k - 1);
            }
        }
    }
    

    public static void main(String[] args) {
        int n = 3;
        int k = 2;

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        myComb(elements, k);
        StdOut.println();
        comb("", elements, k);
    }

}
