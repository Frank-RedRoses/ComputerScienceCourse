package week4.io.booksite;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/***********************************************************************
 * Compilation: javac AddInts.java
 * Execution: java AddInts
 * Dependencies: StdIn.java StdOut.java
 * 
 * This program takes a program-line argument n, read in n integers,
 * and prints out their sum.
 * 
 * % java AddInts 4
 * 144
 * 233
 * 377
 * 1024
 * Sum is 1778
 * 
 ***********************************************************************/

public class AddInts {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);      // Parse command line argument
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int value = StdIn.readInt();        // Read from standard input stream
            sum = sum + value; 
        }
        StdOut.println("Sum is " + sum);        // Print to standard output stream
    }
}
