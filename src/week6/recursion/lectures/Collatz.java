package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/* **************************************************
 * Collatz Sequence:
 * Print a sequence of numbers, dividing by 2 the even numbers 
 * and multiplying by 3 and adding 1 to the odd numbers, repeating 
 * this until the value of 1 is get.
 * 
 * Amazing fact: No one knows whether or not this function terminates for all N.
 * Note. We usually ensure termination by only making recursive calls for smaller N.
 ************************************************* */

public class Collatz {

    public static void collatzSeq(int n) {
        StdOut.print (n + " ");                 // print the actual number before anything
        // Base case:
        if (n == 1) {                           // If N is 1, stop.
            StdOut.println();
            return;
        }
        // Reduction step:         
        if (n % 2 == 0) collatzSeq(n / 2);      // if N is even, divide by 2.
        else collatzSeq(3 * n + 1);             // else N is odd, multiply by 3 and add 1.
    }

    public static void main(String[] args) {
        int n = 5;
        collatzSeq(n);
    }
}