package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* *
 * 2.3.17 Permutations. 
 * Write a program Permutations that takes a command-line argument n and prints out
 * all n! permutations of the n letters starting at "a" (assume that n is no greater
 * than 26). A permutation of n elements is one of the n! possible orderings of the
 * elements. As an example, when n= 3 you should get the following output. Do not 
 * worry about the order in which you enumerate them.
 * 
 * bca cba cab acb bac abc
 * */

public class Ex17PermutationsPractice {
    
    // public method to call the recursive method
    public static void perm(String letters) {
        perm("", letters);
    }

    private static void perm(String prefix, String letters) {
        // number of letters in letters
        int n = letters.length();
        // Base case: When there is no more letters print the prefix
        if (n == 0) StdOut.print(prefix + " ");
        
        // Reduction case: move one letter from letters to prefix.
        for (int i = 0; i < letters.length(); i++) {
            // The next recursive call adds a letter to prefix and the new
            // letters String is formed by concatenation of the subStrings that  
            // come before and after the letter passed to prefix
            perm(prefix + letters.charAt(i), letters.substring(0, i) + letters.substring(i + 1, n));
        }  
    }

    // public method to call the recursive method
    public static void permWithArray(String letters) {
        char[] characters = lettersToCharArray(letters);
        permWithArray(characters, characters.length);
    }

    // returns a char Array that contains the characters in the String letters 
    private static char[] lettersToCharArray(String letters) {
        int n = letters.length();
        char[] characters = new char[n];
        for (int i = 0; i < n; i++) {
            characters[i] = letters.charAt(i);
        }
        return characters;
    }

    
    private static void permWithArray(char[] characters, int sizeOfSwapping) {
        // Base case: When they size of the swapping elements is equal to 1.
        if(sizeOfSwapping == 1) { 
            // sizeOfSwapping == 0 also works but it makes an extra recursive call that does nothing. 
            StdOut.print(new String(characters) + " ");
            return;
        }

        // Reduction Step: make the size of the swapping characters smaller
        for (int i = 0; i < sizeOfSwapping; i++) {
            swap(characters, i, sizeOfSwapping - 1);    
            //  Every index swaps with the largest possible index, forming a different permutation each time.
            permWithArray(characters, sizeOfSwapping - 1);
            /* On each recursive call the numbers of characters to swap will be smaller,
             * thus those characters saved on indexes greater than the size of the swapping 
             * remain the same forming the permutation.*/
            swap(characters, sizeOfSwapping - 1, i);    
            // The character is swap back to its original position for the next iteration
        }

    }
    

    // Swap array values between two indexes (i and j);
    private static void swap(char[] characters, int i, int j) {
        char tempChar = characters[i];
        characters[i] =  characters[j];
        characters[j] = tempChar;
    }

    public static void main(String[] args) {
        int n = 3;          // command-line argument
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";    // 26 Letters alphabet
        String letters = alphabet.substring(0, n);                        // Letters to permutate

        // Print out all the n! permutations posibles with n letters
        perm(letters);

        StdOut.println();

        // print out all n! permutations (does not care about order) 
        permWithArray(letters);
    }
}
