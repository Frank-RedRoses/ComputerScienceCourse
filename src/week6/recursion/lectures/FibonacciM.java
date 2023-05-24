package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac BottomUpFibonacci.java
 *  Execution:    java BottomUpFibonacci n
 *
 *  Computes and prints the first n Fibonacci numbers.
 *  This program uses top-down dynamic programming.
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

public class FibonacciM {
    static long[] memo = new long[100];
    public static long F(int n) {
        // base cases: n == 0 and n == 1. n is an ordinal number (first, second, third)
        if (n == 0) return 0;
        if (n == 1) return 1;
        // compute and cache value (when not computed)
        if (memo[n] == 0) {
            // reduction step: if needed, only in the first calling of F(n)
            memo[n] = F(n - 1) + F(n - 2);
        }
        // return the cached value
        return memo[n];
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(F(n));
    }
}
