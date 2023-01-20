package week5.functionsandlibraries.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;

/* ***************************************************************************************
 * 2.1.10 Write a static method lg() that takes an int argument n and returns the largest
 * integer not larger than the base-2 logarithm of n. Do not use the Math library.
 * 
 *************************************************************************************** */

public class LargestNummberLessThanLogBase2 {

    public static int lg(int n) {
        int log = 0;
        for (int pow2 = 2; pow2 <= n; pow2 *= 2) {
            log++;
        }
        return log;
    }

    public static void main(String[] args) {
        int n = 17;
        StdOut.println("Largest integer not larger than base-2 logarithm of " + n + " = " + lg(n));
    }
    
}
