package week6.recursion.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;

/* ********************************************************************************
 * 2.3.19 Combinations. Write a program Combinations that takes an integer 
 * command-line argument n and prints all 2^n combinations of any size. 
 * A combination is a subset of the n elements, independent of order. 
 * As an example, when n = 3, you should get the following output:
 * 
 * a ab abc ac b bc c 
 * 
 * n = 4,
 * a ab abc abcd abd ac acd ad b bc bcd bd c cd d
 * 
 * Note that your program needs to print the empty string (subset of size 0).
 ********************************************************************************* */

public class Combinations {
    static String[] combinations;

    public static void myComb(String s) {
        int power2 = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = power2; j < power2 * 2; j++) {
                combinations[j] = combinations[j-power2] + s.charAt(i);
            }
            power2 *= 2;
        }
    }

    public static void myComb2(String s) {
        if (s.length() == 0) return;
        int power2 = (int) (Math.pow(2, s.length()));
        myComb2(s.substring(1));
        for (int j = power2/2; j < power2; j++) {
            combinations[j] = combinations[j - power2/2] + s.charAt(0);
        }
    }

    public static void printCombinations() {
        for (int i = 0; i < combinations.length; i++) {
            if (i < combinations.length - 1) 
            StdOut.print(combinations[i] + " ");
            else
            StdOut.print(combinations[i]);
        }
        StdOut.println();
    }

    /* Booksite answer:
    * This method recursevely cuts by one Char a substring from the original until it reach 
    * base case when the substring length = 0, and does nothing.
    */ 
    public static void comb(String prefix, String s) {
        if (s.length() > 0) {
            // Every time the method runs it prints the given prefix plus the first character 
            // of the given string s.
            StdOut.println(prefix + s.charAt(0));
            // Recursively: 
            // First creates a new prefix by adding the first character to the previous prefix 
            // and creates a new string with the rest of the characters.
            comb(prefix + s.charAt(0), s.substring(1));
            /* This step will add one by one the elements from the inital String 
             * to the Prefix until a 0 lenght substring is reached. */

            // After that, it only takes the prefix, discards the first character, and 
            // uses the rest of the Characters as the new string. 
            comb(prefix, s.substring(1));
            /* This step will discard the element at index 0 and continue to print combinations
             * of the prefix with first element in the string, and continue the recursion with a 
             * new string but the same prefix.
             * Because it starts in the last step of the previous recursive call it does the 
             * combination in reverse order, will use characters from right to left, 
             * from a lower level to a higher level.
             * And after this it will execute the first step recursion to add one by one the elements
             * to the index.
             */
        }
        // else do nothing
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // setup my method
        int arrSz =  (int) Math.pow(2, n);
        combinations = new String[arrSz];
        for (int i = 0; i < combinations.length; i++) {
            combinations[i] =  "";
        }
        // get the elements
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        // booksite code
        comb("", elements);
        // my code
        myComb2(elements);
        printCombinations();
    }

    
}
