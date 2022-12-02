package week2.conditionalandloops.creativeexercises;
/****************************************************************************
 * Exponential function. Assume that x is a positive variable of type double. 
 * Write a program Exp.java that computes e^x using the Taylor series expansion
 * 
 * e^x = 1 + x + x^2/2! + x^3/3! + x^4/4! + ...
 * 
 ****************************************************************************/

/******************************************************************************
 *  Compilation:  javac Exp.java
 *  Execution:    java Exp x
 *
 *  Prints out e^x using Taylor expansion.
 *
 *     e^x = 1 + x + x^2/2! + x^3/3! + x^4/4! + ..
 *
 *  % java Exp 1.0
 *  1.0
 *  1.0
 *
 *  % java Exp 1
 *  2.7182818284590455
 *  2.7182818284590455
 *
 *  % java Exp 10
 *  22026.465794806718
 *  22026.465794806714
 *
 *  % java Exp -10
 *  4.539992976248485E-5
 *  4.5399929762484854E-5
 *
 ******************************************************************************/
public class Exp {

    public static void main(String[] args) {
        double x = Integer.parseInt(args[0]);
        // double x = 9;

        double sum = 0.0;
        double term = 1.0;

        /*
         * x^3 = x*x*x;
         * 3! = 1*2*3;
         * x^3/3! = x/1 * x/2 * x/3 is the same as x^2/2! * x/3;
         * Compute in a continuous way by multiplying the factor x/i to the term in every iteration. 
         * 
         */
        
        for (int i = 1; sum != sum + term; i++) { 
            sum = sum + term;
            term *= x/i; 
        }
        

        System.out.println("Math java library: " + Math.exp(x));
        System.out.println("Taylor expansion:  " + sum);
    }
    
}
