package week4.io.optional_enrichment;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/* **********************************************************************************
 * 1.5.5 Write a program that reads in a sequence of integers and prints both the integer
 * that appears in a longest consecutive run and the length of that run. 
 * 
 * For example, if the input is 1 2 2 1 5 1 1 7 7 7 7 1 1, then your program should print
 * Longest run: 4 consecutive 7s.
 *********************************************************************************** */
public class LongestConsecutiveInteger {

    public static void main(String[] args) {
        int longestCount = 1;
        int longestValue = -1;
        int consecutiveCounter = 1;
        int prevVal = -1;

        System.out.println("Enter a sequence of integer numbers:");
        while(!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            // Compare the previous vs actual value
            if (num == prevVal) {
                consecutiveCounter++;
            } else {
                // Check and update the longest count and value if a longer consecutive run is found.
                if (consecutiveCounter > longestCount) {
                    longestValue = prevVal;
                    longestCount = consecutiveCounter;
                }
                // Update previous value
                prevVal = num;
                // Restart the counter
                consecutiveCounter = 1;
            }
        }

        StdOut.println("Longest run: "+ longestCount + " consecutive " + longestValue + "s");
    }

    
}
