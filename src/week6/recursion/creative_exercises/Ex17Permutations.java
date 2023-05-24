package week6.recursion.creative_exercises;
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

import edu.princeton.cs.algs4.StdOut;

public class Ex17Permutations {

    // print n! permutation of the characters of the string s (in order)
    public static void perm1(String abc) {
        // Takes an empty String "prefix" to create every posible permutation 
        // of abc by using recursion
        perm1("", abc);
    } 

    /* The perm1 recursive method: 
     * Uses a prefix as storage variable and adds letters to create a permutation
     *
     * Base case: 
     * abc.length() == 0
     * 
     * Recursive step:
     * It uses a for-loop to take one letter from abc and then it does two things
     * in the next recusive step:
     *      1) pass a new prefix holding the ith letter (prefix + abc.charAt(i)), 
     *      thus creating n "prefix" strings, one for each iteration, each one holding 
     *      the ith letter.
     *      2) pass a new "abc" string that does not contain the ith letter.
     * 
     * The recursive call is repeated for every previously passed prefix + abc.charAt(i).
     * It will for-loop n items (being n equal to the length of the abc string without 
     * the letters that already have been added to prefix) looking and adding for every
     * letter in abc to the prefix. 
     * This will create a function call tree that increase the lenght of prefix by 1 char at 
     * every level of the recursion call, and decrease the number of calls on the next level
     * by n - 1 times, starting by 1 * n from the first call until the value of n - 1 == 1.
     */ 
    private static void perm1(String prefix, String abc) {
        int n = abc.length();
        // base case: 
        if (n == 0) StdOut.println(prefix);
        // Recursive step:
        for (int i = 0; i < n; i++) {
            perm1(prefix + abc.charAt(i), abc.substring(0, i) + abc.substring(i + 1, n));
        }
    }

    // print n! permutation of the elements of array chars (not in order). 
    // Entry method:
    public static void perm2(String abc) {
        int n = abc.length();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = abc.charAt(i);
        }
        // Pass an array with the letters on abc and the number of entries in the array
        perm2(chars, n);
    }

    /* The perm2 recursive method:  
     * Does a for-loop of the array indexes less than n  
     * (n = index until the for-loop will look up inside the array, it changes in every recursive call)
     * and does three things inside the loop:
     *      1) Swaps the value chars[i] with chars[n-1].
     *      2) Recursively call this method but everytime will decrease the value of n by 1 (n-1).
     *      The recursion will repeat the for-loop, but because the n value decrease on every call,
     *      those values with an index >= n will remain in the same position, because they are outside the loop.
     *      3) Swaps back chars[i] with chars[n-1] after the recursive call is completed. 
     *      At the end of each iteration the array's order is be the same before the step 1.
     * 
     * base case: 
     * When n == 1 print the array with swapped letters
     * 
     * recursive step: n-1
     * For-loop take every letter and swap it with the index at n-1.
     * Note that when swaping in the last iteration it will swap with 
     * itself, because i is equal to n-1, so the array will remain the same.
     * Next recursion will decrease n by 1 so the for-loop will swap every letter 
     * with a lower value of n, as .
    */ 
    private static void perm2(char[] chars, int n) {
        // base case:
        if (n == 1) {
            StdOut.println(new String(chars));
            return;
        }
        // recursive step: n-1 
        for (int i = 0; i < n; i++) {
            swap(chars, i, n-1);    // take the char at i to the n-1 position
            perm2(chars, n-1);      // recursive call 
            swap(chars, n-1, i);    // swaps back the character at n-1 to i
        }
    }
    
    // auxiliar swapping method for array entries
    private static void swap(char[] a, int i, int j) {
        char tempChar = a[i];
        a[i] = a[j];
        a[j] = tempChar;
    }
    

    public static void main(String[] args) {
        // input:
        // int n = Integer.parseInt(args[0]);
        int n = 4;

        // elements
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        perm2(elements);



        

    }
    
}
