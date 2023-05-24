package week6.recursion.exercises;
/* ********************************************************************
 * Ex.2.3.3
 * Give the value of ex234(6):
 * 
 ******************************************************************** */
/* Answer: 
 * 6 
 * 4 
 * 2 
 * 2 
 * 1 
 * 1 
 * 4 
 * 3 
 * 1 
 * 1 
 * 3 
 * 6
 */

import edu.princeton.cs.algs4.StdOut;

public class Ex3printEx233 {

    public static void ex233(int n) {
        if (n <= 0)
            return;
        StdOut.println(n);
        ex233(n - 2);
        ex233(n - 3);
        StdOut.println(n);
    }

    public static void main(String[] args) {
        int n = 6;
        ex233(n);
    }
}
