package week6.recursion.exercises;
/* *********************************************************************
 * Ex.2.3.2
 * Write a recursive function that computes the value of ln(N!)
 * 
 * The factorial function, defined for positive integers N by the equation:
 * 
 *      N! = N * (N-l) * (N-2) * ... * 2 * 1
 * 
 ******************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Ex2LogNFactorial {
    
    public static int factorial(int n) {
        // Uncomment this code for Underflow and overflow handling
        // if (n < 0) throw new RuntimeException("Underflow error in factorial");
        // else if (n > 20) throw new RuntimeException("Overflow error in factorial");
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    public static double lnOfFactorial(int n) {
        return Math.log (factorial(n));
    }

    public static double lnOfFactorialRecursive(int n) {
        if (n == 1) return 0;
        else return Math.log(n) + lnOfFactorialRecursive(n-1);
    }

    public static void main(String[] args) {
        int n = 5;
        StdOut.println("The ln("+ n +"!) is: " + lnOfFactorial(n));
        StdOut.println("The recursive ln("+ n +"!) is: " + lnOfFactorialRecursive(n));
    }
}
