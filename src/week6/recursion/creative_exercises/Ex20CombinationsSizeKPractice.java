package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* 2.3.20 Combinations of size k. 
 * Modify Combinations so that it takes two command-line arguments n and k, 
 * and prints out all C(n, k) = n! / (k!(n—k)!) combinations of size k. 
 * For example, when n = 5 and k = 3, you should get the following output:
 *
 * abc abd abe acd ace ade bcd bce bde cde 
 *
 */
public class Ex20CombinationsSizeKPractice {

    // public method to call the recursive method
    public static void comb(String letters, int k) {
        comb("", letters, k);
        StdOut.println();
    }

    private static void comb(String prefix, String letters, int k) {
        if (letters.length() < k) {
            // Base case 1: letters length small than k, not enough letters to form a combination.
            return;
        } else if (k == 0) {
            // Base case 2: prefix size is equal to k, keep track of the prefix's length with the k value.
            StdOut.print(prefix + " ");
        }
        else {
            // Reduction step: take out a letter from "letters" once it is passed to the prefix.
            // First recursive call make combinations with the character at index 0
            // keep track of the prefix size by lower the value of k by 1 when a letter is passed to prefix.
            comb(prefix + letters.charAt(0), letters.substring(1), k - 1);
            // Second recursive call make combinations without the character at index 0
            // prefix size and k remain the same.
            comb(prefix, letters.substring(1), k);
        }
    }

    // public method to call the recursive method
    public static void comb2(String letters, int k) {
        comb2("", letters, k);
        StdOut.println();
    }

    private static void comb2(String prefix, String letters, int k) {
        // Base case: keep track of the prefix's length with the k value.
        if (k == 0) {
            StdOut.print(prefix + " ");
        } else {
            // when letters is an empty string the for-loop is not executed, so not making the recursive call.
            for (int i = 0; i < letters.length(); i++) { 
                // Reduction step: take out the letters before the ith character (inclusive)
                // Every time a letter is added to prefix lower the value of k by 1.
                comb2(prefix + letters.charAt(i), letters.substring(i + 1), k - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        StdOut.println("Combinations size " + k + " of " + elements);
        StdOut.print("First method:  ");
        comb(elements, k);
        StdOut.print("Second method: ");
        comb2(elements, k);
    }
    
}
