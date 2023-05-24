package week6.recursion.lectures;

/* ******************************************************************************
 * Ruler(n): create subdivisions of a ruler to 1/2n inches.
 * - Return one space for n = 0.
 * - Otherwise, sandwich n between two copies of ruler(n-1).
 * 
 * % java Ruler 3
 * 1 2 1 3 1 2 1
 * 
 * % java Ruler 50
 * Exception in thead "main" java.lang.OutOfMemoryError: Java heap space
 ***************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Ruler {

    public static String ruler(int n) {
        if (n == 0) return " ";
        return ruler(n-1) + n + ruler(n-1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(ruler(n));
    }
}