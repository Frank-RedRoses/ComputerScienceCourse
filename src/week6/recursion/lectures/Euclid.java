package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/* ***************************************************************************************
 * Compilation: javac Euclid.java
 * Execution: java Euclid p q
 * 
 * Reads two command-line arguments p and q and computes the greatest 
 * common divisor of p and q using Euclid's algorithm.
 * 
 * Remarks
 * --------
 *  - may return the negative of the gdc if either p or q is negative
 ************************************************************************************** */

public class Euclid {

    // recursive implementation
    public static int gcd(int p, int q) {
        // Base case: when q equals 0 the gcd is equal to p
        if (q == 0)  return p;
        // Reduction step: The gcd between p and q (p > q) is the same
        // as the gcd between q and p%q. (p%q will always be lower than q)
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d = gcd(p, q);
        int d2 = gcd2(p, q);
        StdOut.println("gcd("+ p + ", " + q + ") = " + d);
        StdOut.println("gcd2("+ p + ", " + q + ") = " + d2);
    }
    
}
