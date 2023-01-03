package week4.io.optional_enrichment;
/* ****************************************************************************
 *
 * 1.5.7 Write a program that takes an integer command-line argument n, reads in
 *  n-1 distinct integers between 1 and n, and determines the missing value.
 * 
 ****************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MissingValue {
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] integersList = new boolean[n + 1]; 
        
        StdOut.println("Enter the sequence of numbers betweem 1 and " + n);
        while (!StdIn.isEmpty()) {
            // Read the number and set the array entry as true for that number
            int num = StdIn.readInt();
            integersList[num] = true;
        }

        StdOut.print("The missing values from 1 to " + n + " are: ");
        for (int i = 1; i < integersList.length; i++) {
            // Only indexes that remain false are missing in the given sequence
            if(integersList[i] ==  false) StdOut.print(i + " ");
        }
        
    }
    
}
