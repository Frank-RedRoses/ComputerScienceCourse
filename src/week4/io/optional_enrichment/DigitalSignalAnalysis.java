package week4.io.optional_enrichment;
/* ****************************************************************************************
 * 1.5.17 Write a program that reads in a sequence of real numbers between -1 and +1 and 
 * prints their average magnitude, average power, and the number of zero crossings. 
 * The average magnitude is the average of the absolute values of the data values. 
 * The average power is the average of the squares of the data values. The number of 
 * zero crossings is the number of times a data value transitions from a strictly negative 
 * number to a strictly positive number, or vice versa. These three statistics are widely 
 * used to analyze digital signals.
 * 
 * Input: -0.1 0.5 -0.6 0.9 0.8 0.5 0.6 0.2 0.1 0.0002 -0.05 -0.3 -0.6 0.7 -0.6 -0.9 -1 1
 * Output: 
 * Average magnitude: 0.52501111111111
 * Average power: 0.38013889111111104
 * Zero crossing times: 7
 ***************************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DigitalSignalAnalysis {

    public static void main(String[] args) {
        int counter = 0;
        double aveMagnitude = 0;
        double avePower = 0.0;
        int crossingTime = 0;
        double prevVal = 0.0;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            counter++;
            aveMagnitude += Math.abs(value);
            avePower += value*value;
            if (prevVal*value < 0) crossingTime++;
            prevVal = value;
        }

        aveMagnitude /= counter;
        avePower /= counter;

        StdOut.println("Average magnitude: " + aveMagnitude);
        StdOut.println("Average power: " + avePower);
        StdOut.println("Zero crossing times: " + crossingTime);
    }
    
}
