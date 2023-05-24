package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* 2.3.19 Combinations. 
 * Write a program Combinations.java that takes an integer command-line argument n 
 * and prints all 2^n combinations of any size. A combination is a subset of the 
 * n elements, independent of order. As an example, when n = 3, you should get the following output:
 * 
 * a ab abc ac b bc c
 */

public class Ex19CombinationsPractice {

    // public method to call the recursive method
    public static void comb(String letters) {
        comb("", letters);
        StdOut.println();
    }

    private static void comb(String prefix, String letters) {
        // Base case: no more letters in the String letters, do not enter the block code
        if (letters.length() > 0) {
            StdOut.print(prefix + letters.charAt(0) + " ");
            // Reduction step: take one letter out of letters once is used
            // First recursive call make combinations with the character at index 0
            comb(prefix + letters.charAt(0), letters.substring(1));
            // Second recursive call make combinations without the character at index 0
            comb(prefix, letters.substring(1));
        }
    }

    // public method to call the recursive method
    public static void comb2(String letters) {
        comb2("", letters);
        StdOut.println();
    }

    private static void comb2(String prefix, String letters) {
        // Base case: no more letters in the String letters, do not enter the block code
        if (letters.length() > 0) {
            for (int i = 0; i < letters.length(); i++) {
                StdOut.print(prefix + letters.charAt(i) + " ");
                // Reduction step: take out the letters before the ith character (inclusive) 
                comb2(prefix + letters.charAt(i), letters.substring(i + 1));
            }

        }
    }

    public static void main(String[] args) {
        int n = 4;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        StdOut.println("Combinations of " + elements);
        StdOut.print("First method:  ");
        comb(elements);
        StdOut.print("Second method: ");
        comb2(elements);

    }
    
}
