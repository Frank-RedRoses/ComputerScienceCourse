package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* ******************************************************************************
 * 2.3.29. Collatz function.
 * Consider the following recursive function in Collatz.java, which is related 
 * to a famous unsolved problem in number theory, known as the Collatz problem 
 * or the 3n + 1 problem. 
 * 
 *      public static void collatz(int n) {
 *          StdOut.print(n + " ");
 *          if (n == 1) return;
 *          if (n % 2 == 0) collatz(n / 2);
 *          else            collatz(3*n + 1);
 *      }
 * 
 * For example, a call to collatz(7) prints the sequence
 * 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * as a consequence of 17 recursive calls. Write a program that takes a command-line 
 * argument n and returns the value of i < n for which the number of recursive 
 * calls for collatz(i) is maximized. Hint: use memoization. The unsolved problem 
 * is that no one knows whether the function terminates for all integers (mathematical 
 * induction is no help because one of the recursive calls is for a larger value of 
 * the argument).
 * 
 * Note: this class have only been tested for i < 100.
 * 
 * % Ex29MaximumCollatz.java 7
 * 
 * The i < 7 value that maximized the number of recursive calls is collatz(6) with 9 calls.
 * 6 3 10 5 16 8 4 2 1
 * 
 ******************************************************************************** */

public class Ex29MaximumCollatz {

    private static int[] memo = new int[10000];     // stores values to form the collatz sequence
    private static int recursiveCallsCounter = 0;   // number of recursive calls per i value
    
    // Recursive solution for the Collatz problem
    public static void collatz(int n) {
        StdOut.print(n + " ");
        if (n == 1) return;
        if (n %  2 == 0) collatz(n / 2);
        else collatz(3*n + 1);     
    }

    // my solution for the i < n Collatz problem using memoization.
    public static void collatzMemo(int n) {
        // StdOut.print(n + " "); // for debug
        recursiveCallsCounter++;    // increase by 1 with every call
        // Base case: Compute values of memo[n] until n == 1
        if (n == 1) {
            memo[n] = 1;
            return;
        }
        // when value 0 for memo[n] compute the value.
        if (memo[n] == 0) {
            if (n %  2 == 0) memo[n] = n / 2;
            else memo[n] = 3*n + 1; 
        }
        // Reduction step:
        collatzMemo(memo[n]);
    }

    // print out the sequence using the computed array values
    public static void printSequence(int n) {
        StdOut.print(n + " ");  // print the initial n value.
        while (n != 1) {        // print the subsequent values using the array entries.
            StdOut.print(memo[n] + " ");
            n = memo[n];
        }
        StdOut.println();
    }
    
    public static void main(String[] args) {
        // int n = Integer.parseInteger(args[0]);
        int n = 7;        // input for debug
        // keep the record of the maximum number of recursion calls
        int maxCount = 1;   
        int iWithMaxCalls = 1;
        // calculate the collatz sequence for every i value < n
        for (int i = 1; i < n; i++) {
            recursiveCallsCounter = 0;  // reset the counter in every iteration
            collatzMemo(i);             // collatz sequence using memoization
            /* for debugging:
            // StdOut.println();
            // StdOut.println("Number of recursive calls: " + recursiveCallsCounter);
            */
            if (maxCount < recursiveCallsCounter) {
                // update the number of recursive calls when is greater than the prevoius one.
                maxCount = recursiveCallsCounter;
                iWithMaxCalls = i;  // i value with the greatest number of recursive calls
            }
        }
        // Output with the answer
        StdOut.println("The i < " + n + " value that maximized the number "+
                        "of recursive calls is collatz(" + iWithMaxCalls + ") with "
                         + maxCount + " calls.");
        // print the sequence with the greatest number of recursive calls
        printSequence(iWithMaxCalls);
    }
}
