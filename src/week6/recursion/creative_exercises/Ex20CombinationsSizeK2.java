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

public class Ex20CombinationsSizeK2 {

    // Entry method
    public static void generateComb(String alphabet, int combSizeK) {
        char[] letters = new char[combSizeK];
        generateComb(alphabet, letters, 0, 0, combSizeK, alphabet.length());
        StdOut.println();
    }
    
    /* private static char[] generateCharArr(String alphabet) {
    //     int n = alphabet.length();
    //     char[] letters = new char[n];
    //     for (int i = 0; i < n; i++) {
    //         letters[i] = alphabet.charAt(i);
    //     }
    //     return letters;
    // } */

    private static void generateComb(String alphabet, char[] letters, int positionInArray, int nextLetter, int sizeK, int alphabetLengthN) {
        // Base case: When position reach the combination's size (size k).
        if (positionInArray == sizeK) {
            showCombination(letters);
            return; // Be sure to end the recursion when a combination is completed.
        }
        // Reduction step: Increase position in the array (index) by 1 in every recursive call
        /* This for-loop will take chars in "alphabet" from equal and greater positions 
         * than the actual index "position in array" to fill "letters" and thus
         * creating every possible combination. */
        for (int i = nextLetter; i < alphabetLengthN; i++) {
            /* The "nextLetter" value increments means that when alphabetLenghtN - i < k 
             * there will be not enough letters remaining in "alphabet" to fill letters[],
             * in this case, next iterations of the value of nextLetter will increase until 
             * is greater than alphabetLengthN and then the for-loop will not be 
             * executed because i => alphabetLengthN and the recursion call is not made exiting
             * the loop and returning the control to the previous code.
             */
            letters[positionInArray] = alphabet.charAt(i);
            generateComb(alphabet, letters, positionInArray + 1, i + 1, sizeK, alphabetLengthN);
        }

    }

    private static void showCombination(char[] letters) {
        for (int i = 0; i < letters.length; i++) {
            StdOut.print(letters[i]);
        }
        StdOut.print(" ");
    }
    

    public static void main(String[] args) {
        // input values
        int n = 3;
        int k = 2;
        // String values
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String letters = alphabet.substring(0, n);

        // Combinations
        generateComb(letters, k);
    }
}
