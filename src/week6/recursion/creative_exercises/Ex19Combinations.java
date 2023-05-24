package week6.recursion.creative_exercises;
/* 2.3.19 Combinations. 
 * Write a program Combinations.java that takes an integer command-line argument n 
 * and prints all 2^n combinations of any size. A combination is a subset of the 
 * n elements, independent of order. As an example, when n = 3, you should get the following output:
 * 
 * a ab abc ac b bc c
 */

import edu.princeton.cs.algs4.StdOut;

public class Ex19Combinations {
    static String[] combinations;

    // Entry method:
    public static void comb(String abc) {
        comb("", abc);
    }

    // Recursive method:
    private static void comb(String prefix, String abc) {
        // Base case: abc.length() == 0 do nothing.
        if (abc.length() > 0) {
            StdOut.println(prefix + abc.charAt(0));
            // Reduction step: The next recursive call uses a trim version of abc without the char at index 0. 
            // First recursion call creates combinations with the charAt(0).
            comb(prefix + abc.charAt(0), abc.substring(1));
            // Second recursion call to makes a combination without the charAt(0).
            comb(prefix, abc.substring(1));
        } 
    }

    // alternate implementation from the website
    public static void comb2(String s) { 
        comb2("", s); 
    }
    // recursive method
    private static void comb2(String prefix, String s) {
        StdOut.println(prefix);
        for (int i = 0; i < s.length(); i++)
            // take every character from abc and pass it to the prefix
            // creates a different prefix and abc strings in every iteration 
            comb2(prefix + s.charAt(i), s.substring(i + 1));
            // repeat the previous loop for the new prefix and abc strings
    }

    public static void myCombNoRecursion(String abc) {
        initializeCombinationsArray(abc);
        myCombLoop(abc);
        printCombinations();
    }

    public static void myComb(String abc) {
        initializeCombinationsArray(abc);
        myCombRecursive(abc);
        printCombinations();
    }

    // Initialize the array storing the n^2 combinations
    private static void initializeCombinationsArray (String abc) {
        int arrSz =  (int) Math.pow(2, abc.length());
        combinations = new String[arrSz];
        for (int i = 0; i < combinations.length; i++) {
            combinations[i] =  "";
        }
    }

    private static void myCombLoop(String abc) {
        /* For loop without recursion:
         * This for-loop adds character to the end of string in order, first "a", then "b", and so on...
         */ 
        int power2 = 1; //  The first entry in the array (0) is a empty String ("")
        for (int i = 0; i < abc.length(); i++) { 
            // this loop only takes characters on abc one at the time  
            // and increase the value of power of 2 at the end of the loop
            for (int j = power2; j < power2 * 2; j++) { // this loop makes the magic
                /* 1) Takes the power of two to start the loop.
                 * 2) Loop for the values between power2 and the next power2 (non-inclusive)
                 * 3) To form combinations takes the values at indexes less than power2
                 *    and add the current ith character.
                 *    Ex. i = 2; power2 = 4; j = 5; 
                 *        array[j] = array[j-power2] + abc.charAt(i);
                 *        array[5] = array[1] + abc.charAt(2); array[5] = "a" + "c";
                 *        array[5] = "ac";        
                */
                combinations[j] = combinations[j-power2] + abc.charAt(i); 
            }
            // next power of 2
            power2 *= 2;
        }
    }

    // Alternative to my implementation with a recursive call
    // This method will return the combination in a reverse order. Ex. abc -> cba
    public static void myCombRecursive(String s) {
        if (s.length() > 0) {
            // reductive step: the size of the string
            myCombRecursive(s.substring(1));  
            // Recursively goes to the last char and then goes out back to the first char.
            /* For this reason why you need to the highest value of powerOf2 and divide by 2 in every iteration, 
            this is a inverse insight compare to the no-recursion method, and that's why is in reverse order*/
            int powerOf2 = (int) (Math.pow(2, s.length()));
            for (int j = powerOf2/2; j < powerOf2; j++) {
                combinations[j] = combinations[j - powerOf2/2] + s.charAt(0); 
                // What the reductive step does is only to put the next character at the charAt(0) position.
            }
        }
    }

    private static void printCombinations() {
        for (int i = 0; i < combinations.length; i++) {
            if (i < combinations.length - 1) 
            StdOut.print(combinations[i] + " ");
            else
            StdOut.print(combinations[i]);
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int n = 4;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        
        // Website solutions
        comb(elements);
        comb2(elements);

        // my solutions
        myCombNoRecursion(elements);
        myComb(elements);
    }
    
}
