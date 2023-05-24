package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Factorial.java
 *  Execution:    java Factorial n
 * 
 *  The HelloWorld for recursion is the factorial function, defined
 *  for positive integers N by the equation:
 * 
 *      N! = N * (N-l) * (N-2) * ... * 2 * 1
 * 
 *  In other words, N! is the product of the positive integers less 
 *  than or equal to N.
 * 
 *  This program reads an integer command-line argument n, and prints
 *  n! = 1 * 2 * ... * n to standard output.
 *
 *  % java Factorial 0
 *  1
 *
 *  % java Factorial 1
 *  1
 *
 *  % java Factorial 5
 *  120
 *
 *  % java Factorial 12
 *  479001600
 *
 *  % java Factorial 20
 *  2432902008176640000
 *
 *  % java Factorial -10
 *  java.lang.RuntimeException: Underflow error in factorial
 *
 *  % java Factorial 21
 *  java.lang.RuntimeException: Overflow error in factorial
 *
 *
 *  Remarks
 *  -------
 *   - Would overflow a long if n > 20
 *   - Need to use extended precision arithmetic to handle bigger factorials
 *
 ******************************************************************************/

public class Factorial {

    // return n!
    // precondition: n >= 0 and n <= 20
    public static long factorial(int n) {
        // runtime errors precautions
        if (n < 0) throw new RuntimeException("Underflow error in factorial");
        else if (n > 20) throw new RuntimeException("Overflow error in factorial");
        // base case: n == 0
        else if (n == 0) return 1;
        // reduction step: n - 1
        else return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(factorial(n));
    }
    
}
