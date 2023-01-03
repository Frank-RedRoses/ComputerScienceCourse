package week4.io.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* ***************************************************************************************
 * 1.5.6 Write a filter that reads in a sequence of integers and prints the integers, 
 * removing repeated values that appear consecutively. 
 * 
 * For example, if the input is 1 2 2 1 5 1 1 7 7 7 7 1 1 1 1 1 1 1 1 1, your program 
 * should print 1 2 1 5 1 7 1. 
 *************************************************************************************** */

public class FilterConsecutiveInteger {
    
    public static void main(String[] args) {
        System.out.println("Enter a sequence of integer numbers:");
        
        // Read the first value and add it to the output sequence
        int prevVal = StdIn.readInt();
        String outStr = "" + prevVal; 
        
        while(!StdIn.isEmpty()) {
            // If a number is not equal to the previous add it to the output sequence
            int num = StdIn.readInt();
            if (num != prevVal) {
                outStr += " " + num;
                prevVal = num;
            }
        }

        StdOut.println("Sequence without repetition: " + outStr);
    }
}
