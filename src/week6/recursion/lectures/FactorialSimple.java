package week6.recursion.lectures;

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
 ************************************************************************* */

public class FactorialSimple {

    public static int factorial(int n) {
        // base case: n == 1
        if (n == 1) return 1;    
        // reduction step: n - 1       
        return n * factorial(n - 1);    
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n)); 
    }
    
}
