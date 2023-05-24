package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Fibonacci.java
 *  Execution:    java Fibonacci n
 *
 *  Computes and prints the first n Fibonacci numbers.
 *
 *
 *  WARNING:  this program is spectacularly inefficient and is meant
 *            to illustrate a performance bug, e.g., set n = 45.
 *
 *
 *   % java Fibonacci 7
 *   1: 1
 *   2: 1
 *   3: 2
 *   4: 3
 *   5: 5
 *   6: 8
 *   7: 13
 *
 *   Remarks
 *   -------
 *    - The 93rd Fibonacci number would overflow a long, but this
 *      will take so long to compute with this function that we
 *      don't bother to check for overflow.
 *
 ******************************************************************************/

public class FibonacciR {
    public static long F(int n) {
        // base cases: n == 0 and n == 1. The value n stand for ordinal numbers (like 1st, 2nd, 3rd)
        if (n == 0) return 0;
        if (n == 1) return 1;
        // reduction step: n-1 and n-2
        return F(n-1) + F(n-2);
        
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(F(n));
    }
    
}
