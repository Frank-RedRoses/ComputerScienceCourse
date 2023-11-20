package week8.adt.optional_enrichment;

import java.awt.Color;
import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.StdStats;

/* ********************************************************************
 * 3.1.4. Write a program that takes the name of a grayscale image file
 * as a command-line argument and uses StdDraw to plot a histogram of 
 * the frequency of occurrence of each of the 256 grayscale intensities.
 ******************************************************************** */

public class GrayscaleHistogram {
    
    public static void histogram(Picture pic) {
        int n = 257;
        // Set an array to count the occurrence of a gray intesity
        int[] grayIntensities = new int[257];   // from 0 to 256
        int maxFreq = 0;                        // greatest value in the array
        // Go pixel by pixel
        for (int col = 0; col < pic.width(); col++) {
            for (int row = 0; row < pic.height(); row++) {
                // get the gray color
                Color gray = pic.get(col, row);
                int red = gray.getRed();        // get a value of any RGB color (Intensity)
                // check for gray color pixel
                if (red == gray.getGreen() && red == gray.getBlue()) {
                    grayIntensities[red]++;     // add +1 to the counter of gray intensities
                    // check and update the max count
                    if(maxFreq < grayIntensities[red]) maxFreq = grayIntensities[red];
                } else {
                // otherwise, it is not a gray image and the display a message and stop the method execution.
                    StdOut.println("Not a valid grayscale figure");
                    return;     
                }
            }
        }
        // Set a scale for the histogram
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(-20, grayIntensities.length + 10);
        StdDraw.setYscale(-.05*maxFreq , 1.1*maxFreq);
        // Draw the histogram
        StdDraw.setPenRadius(0.0005);
            // X-axis and legend
        StdDraw.line(0, 0, n, 0);
        StdDraw.text( 0, -.025 * maxFreq , "0");
        StdDraw.text( n / 2.0, -.025 * maxFreq , "Intensity");
        StdDraw.text( 1.0*n,  -.025 * maxFreq, "" + (n-1));
            // Y-axis and legend
        StdDraw.line(0, 0, 0, maxFreq);
        StdDraw.text( -5, maxFreq / 2.0, "freq", 90.0);
        StdDraw.text( -10, maxFreq, "" + maxFreq);
            // Histogram, where i represents a gray intensity
        StdDraw.setPenRadius();
        for (int i = 0; i < grayIntensities.length; i++) {
            StdDraw.filledRectangle(i, grayIntensities[i] / 2.0, .25, grayIntensities[i] / 2.0);
        }

        /* // optional: use the StdStats.plotBars() method to draw the histogram.
        for (int i = 0; i < grayIntensities.length; i++) {
            grayIntensities[i] /= maxValue;
        }
        StdStats.plotBars(grayIntensities);
        */
    }

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        histogram(pic);
    }
    
    
}
