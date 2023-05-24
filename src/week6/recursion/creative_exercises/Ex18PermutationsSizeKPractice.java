package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* *
 * 2.3.18 Permutations of size k. 
 * Modify Permutations so that it takes two command-line arguments n and k, and 
 * prints out all P(n,k) = n! / (n-k)! permutations that contain exactly k of 
 * the n elements. Below is the desired output when k= 2 and n = 4.You need not
 * print them out in any particular order. 
 * 
 * ab ac ad ba bc bd ca cb cd da db dc
 * */
public class Ex18PermutationsSizeKPractice {
    

    // public method to call the recursive method
    public static void permSizeK(String letters, int kSize) {
        char[] characters = lettersToCharArray(letters);
        permSizeK(characters, characters.length, kSize);
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

    
    private static void permSizeK(char[] characters, int sizeOfSwapping, int kSize) {
        // Base case: When the size of the permutation is equal to sizeK.
        // The reduction step will make kSize smaller per every character added to the permutation.
        if(kSize == 0) { 
            for (int i = sizeOfSwapping; i < characters.length; i++) {
                StdOut.print(characters[i]);
            }
            StdOut.print(" ");
            return;
        }

        // Reduction Step: make the size of the swapping characters and the kSize smaller.
        for (int i = 0; i < sizeOfSwapping; i++) {
            swap(characters, i, sizeOfSwapping - 1);    
            //  Every index swaps with the largest possible index, forming a different permutation each time.
            permSizeK(characters, sizeOfSwapping - 1, kSize - 1);
            /* On each recursive call the numbers of characters to swap will be smaller,
             * thus those characters saved on indexes greater than the size of the swapping 
             * remain the same forming the permutation. kSize keeps track of the number of 
             * fixed characters added to the permutation*/
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
        int n = 4;          // command-line argument
        int k = 1;          // command-line argument
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";    // 26 Letters alphabet
        String letters = alphabet.substring(0, n);                        // Letters to permutate

        // print out all P(n,k) = n! / (n-k)! permutations
        permSizeK(letters, k);
        StdOut.println();
    }
    
}
