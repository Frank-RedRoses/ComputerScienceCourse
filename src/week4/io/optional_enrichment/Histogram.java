package week4.io.optional_enrichment;
/* ************************************************************************************************
 * 1.5.30 Histogram. Suppose that the standard input stream is a sequence of double values.
 * Write a program that takes an integer n and two real numbers lo and hi as command-line 
 * arguments and uses StdDraw to plot a histogram of the count of the numbers in the standard 
 * input stream that fall in each of the n intervals defined by dividing (lo , hi) into n 
 * equal-sized intervals.
 * 
 * % java Histogram 5 0.0 100.0
 * 15 20 53 62 85 54 95 75 8 25 55 78 92 36 54 82 1 59 67 72 85 86 65 58 66 37 40 58 1
 * 
 * % java Histogram 6 0.0 500.0
 * 255 366 455 152 97 10 396 296 180 160 360 270 462 178 125 64 128 256 500 189 296 394 410
 * 
 ************************************************************************************************ */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class Histogram {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        double intervalLength = (hi - lo) / n;
        int[] nValuesInInterval = new int[n]; 
        int largestIndex = 0;

        // Read the values from Standard input and check every interval 
        // to count when a number fall inside an interval.
        while(!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            for (int i = 0; i < nValuesInInterval.length; i++) {
                if (value < intervalLength*(i+1)) {
                    // every index represents an interval id
                    nValuesInInterval[i]++;
                    // Holt a record with the index containing the largest count (for histogram)
                    if (nValuesInInterval[largestIndex] < nValuesInInterval[i]) 
                        largestIndex = i;
                    break;
                }
            } 
        }

        
        // Histogram on 80% of canvas size
        double histSize = 0.8;  // Histogram % scale ratio
        double origin = 0.1;    // Origin Histogram's coordinate in the canvas (0.1, 0.1)
        StdDraw.setPenRadius();
        for (int i = 0; i < nValuesInInterval.length; i++) {
            StdDraw.filledRectangle(origin + histSize * (intervalLength * i + (intervalLength / 2)) / hi, 
                                    origin + histSize * nValuesInInterval[i] / (2.0 * (nValuesInInterval[largestIndex])), 
                                    histSize * intervalLength / (4.0 * hi), 
                                    histSize * nValuesInInterval[i] / (2.0 * (nValuesInInterval[largestIndex])));
        }
        // X axis
        StdDraw.line(origin, origin, origin + histSize, origin);
        StdDraw.text(origin + histSize / 2.0, origin * 0.33, "Intervals");
        for (int i = 0; i < n; i++) {
            String intervalScale = (int) (intervalLength * i + 1) + "-" + (int) (intervalLength * (i + 1));
            StdDraw.text(origin + histSize * (intervalLength * i + (intervalLength / 2)) / hi , origin * 0.7, intervalScale);
        }
        // Y axis
        StdDraw.line(origin, origin, origin, origin + histSize);
        StdDraw.text(origin * 0.33, origin + histSize / 2.0, "Input count", 90);
        for (int i = 0; i <= nValuesInInterval[largestIndex]; i++) {
            StdDraw.text(origin * 0.7, origin + histSize * i / nValuesInInterval[largestIndex], "" + i);
        }
        
        
        
    }
    
}
