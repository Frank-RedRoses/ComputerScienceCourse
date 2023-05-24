package week6.recursion.exercises;
/* ****************************************************************************
 * Ex.2.3.4.
 * Give the value of ex234(6):
 * 
 *************************************************************************** */

/* Answer:
 * 316142
 */

import edu.princeton.cs.algs4.StdOut;

public class Ex4ValueOfEx234 {
    
    public static String ex234(int n) {
        // Base case:
        if (n <= 0) return "";
        // Reduction step:
        return ex234(n-3) + n + ex234(n-2);
        // This code will print lowers n values on both sides of the bigger n values
    }

    public static void main(String[] args) {
        int n = 6;
        StdOut.println(ex234(n));
        
    }
}
