package week5.functionsandlibraries.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;

/* ********************************************************************************************
 * Write a static method histogram() that takes an int array a[] and an integer m as arguments 
 * and returns an array of length m whose ith element is the number of times the integer i 
 * appeared in a[]. Assuming the values in a[] are all between 0 and m-1, the sum of the values 
 * in the returned array should equal a.length.
 *  
 ******************************************************************************************* */

public class HistogramArray {
    public static int[] histogram(int[] a, int m) {
        int[] values = new int[m];
        for (int i = 0; i < a.length; i++) {
            values[a[i]]++;
        }
        return values;
    }

    public static void main(String[] args)  {
        int m = 7;
        int[] input = { 5, 6, 1, 5, 3, 0, 5, 4, 6, 2, 1, 3, 1, 3, 2, 3, 0, 5, 4, 0 };
        
        int[] hist = histogram(input, m);
        int sum = 0;
        StdOut.print("Returned array = {");
        for (int i = 0; i < hist.length; i++) {
            int value = hist[i];
            sum += value;
            StdOut.print(" " + value);
        }
        StdOut.println(" }");
        StdOut.println("The sum of the values in the returned array should equal input.length.");
        StdOut.println(sum + " = " + input.length);


    }
    

}
