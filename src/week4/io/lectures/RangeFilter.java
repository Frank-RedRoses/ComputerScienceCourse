package week4.io.lectures;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac RangeFilter.java
 *  Execution:    java RangeFilter lo hi < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Read in a sequence of integers from standard input and print
 *  out those values between lo and hi.
 *
 ******************************************************************************/

public class RangeFilter {
    public static void main(String[] args) {
        
        // Read in two command-line arguments
        int lo = Integer.parseInt(args[0]);
        int hi = Integer.parseInt(args[1]);

        // repeat as long as there's more input to rean in
        while (!StdIn.isEmpty()) {

            // read the next integer
            int t = StdIn.readInt();

            // print out the given integer if it's between lo and hi
            if (t >= lo && t <= hi) {
                StdOut.print(t + " ");
            }
            StdOut.println();
        }

    }
    
}
