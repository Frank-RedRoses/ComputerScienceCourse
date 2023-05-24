package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac BottomUpFibonacci.java
 *  Execution:    java BottomUpFibonacci n
 *
 *  Computes and prints the first n Fibonacci numbers.
 *  This program uses bottom-up dynamic programming.
 *
 *   % java BottomUpFibonacci 7
 *   1: 1
 *   2: 1
 *   3: 2
 *   4: 3
 *   5: 5
 *   6: 8
 *   7: 13
 *
 *   Remark: The 93rd Fibonacci number would overflow a long.
 *
 ******************************************************************************/

public class Fibonacci {
    public static void main(String[] args) {
        // Input for the desired nth numbers.
        int n = Integer.parseInt(args[0]);  
        // Array for store the values of every Fibonacci number lower than nth.
        long[] F = new long[n + 1];         
        // Initial values to start the computation for the following numbers.
        F[0] = 0;
        F[1] = 1;
        // Computes every Fibonacci number in sequence from F[2] to F[n];
        for (int i = 2; i <= n; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        // Print to the terminal the value of F[n]
        StdOut.println(F[n]);
    } 
}
