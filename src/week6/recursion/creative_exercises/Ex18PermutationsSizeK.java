package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* *
 * 2.3.18 Permutations of size k. 
 * Modify Permutations so that it takes two command-line arguments n and k, and 
 * prints out all P(n,k) = n! / (n-k)! permutations that contain exactly k of 
 * the n elements. Below is the desired output when k= 2 and n = 4.You need not
 * print them out in any particular order. 
 * 
 * ab ac ad ba be bd ca cb cd da db dc
 * */
public class Ex18PermutationsSizeK {

    // print n! permutations of the elements in the array chars
    public static void perm(String abc, int kSize) {
        int n = abc.length();
        char[] abcChars = abc.toCharArray();
        // Entry point of recursion
        perm(abcChars, n, kSize);  
    }

    /* Recursive method: use k in the redduction step and base case to know when to print the permutation
     * Base case:
     * When k == 0 print the indexes i >= n.
     * Those indexes are fix values in the array, this is because the way the method works
     * to find permutations.
     * Reduction step: decrease n and k.
     */
    private static void perm(char[] chars, int n, int k) {
        // Base case:
        if (k == 0) {
            for (int i = n; i < chars.length; i++) {
                StdOut.print(chars[i]);
            }
            // StdOut.println(new String (chars)); for debug
            // StdOut.println();
            return;
        }
        // Reduction step: 
        for (int i = 0; i < n; i++) {
            swap(chars, i, n-1);
            perm(chars, n-1, k-1);  // add k to the reduction step to know when to stop
            swap(chars, i, n-1);
        }
    }

    // auxiliar method to exchange array entries
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        // elements
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        
        // recursive method
        perm(elements, k);

    }


    
}
