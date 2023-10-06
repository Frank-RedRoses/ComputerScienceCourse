package week5.functionsandlibraries.optional_enrichment;
/* ****************************************************************************************
 * 2.1.29 Fourier spikes. Write a program that takes a command-line argument n 
 * and plots the function (cos(t) + cos(2 t) + cos(3 t) + … + cos(n t)) / n for 
 * 500 equally spaced samples of t from -10 to 10 (in radians). Run your program 
 * for n = 5 and n = 500. Note : You will observe that the sum converges to a spike 
 * (0 everywhere except a single value). This property is the basis for a proof 
 * that any smooth function can be expressed as a sum of sinusoids.
 * 
 *************************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class FourierSpikes {

    /*
    * Gives 500 equally spaced samples starting at point 0.0 and ending 
    * at points xMax rad and -xMax rad.
    * Does not take point 0.0 as a sample, so it divides the sampling in 
    * 250 values < 0.0 and 250 values > 0.0. This allows us to see the peak 
    * value of the Fourier serie at value x = 0.0 rad.
    * Note: The Fourier peaks appear for values of 0.0 and Math.PI times 
    * multiples of 2 (2*PI, 4*PI, 6*PI,...).
    */
    public static double[] fValueSamples(double xMax, int nSamples) {
        double[] fValues = new double[nSamples + 1];            // nSamples + 0.0
        double distanceBetweenSamples = xMax / (nSamples / 2);  // from 0.0 to 10.0
        int midSample = nSamples / 2;
        for (int i = 1; i <= midSample; i++) {    
            // Computes both values at the same time, positive and negative (fValues[midSample] == 0.0).       
            fValues[midSample + i] = fValues[midSample + i - 1] + distanceBetweenSamples; // positive samples
            fValues[midSample - i] = fValues[midSample - i + 1] - distanceBetweenSamples; // negative samples
        }
        return fValues;
    }
    
    // Computes the t(x) function and return the value of y
    public static double tFunction(double x, int n) {
        double sum = Math.cos(x);
        for (int i = 2; i <= n; i++) {
            sum += Math.cos(i*x);
        }
        return sum / n;
    }

    // Compute the y values with an array of x values using the t(x) function.
    public static double[] computeYValues(double[] tValues, int n) {
        double[] yValues = new double[tValues.length];
        for (int i = 0; i < tValues.length; i++) {
            yValues[i] = tFunction(tValues[i], n);
        }
        return yValues;
    }

    // plots the given x's and y's values.
    public static void plot(double[] tValues, double[] yValues) {
        StdDraw.setXscale(-10.0, 10.0);
        StdDraw.setYscale(-1.5, 1.5);
        for (int i = 0; i < tValues.length - 1; i++) {
            StdDraw.line(tValues[i], yValues[i], tValues[i+1], yValues[i+1]);
        }
    }
    
/* Previous version. 
 * It works, but every time I needed to change the equation it was 
 * necessary to check both methods and verify that all the values were
 * correct and everything in order. 
 * Problem: too many hard coded values repeated on both methods. 
 * Needed to check hard coded variables everytime after any change.
 * Also the t samples array had -10 rad as index 0 value and from there 
 * the equally space values were added, this cause t=0 to appear only
 * when the interval was a multiple of 20, only then the spike was show.
 * 
    public static double[] sinusoidsSum(int n) {
        double lo = -10.0;
        double hi = 10.0;
        int samples = 500;
        double[] valuesY = new double[samples];
        for (int i = 0; i < samples; i++) {
            double t = lo + (hi - lo) * i / (samples - 1);
            double sum = 0.0;
            for (int j = 1; j <= n; j++) {
                sum += Math.cos(j*t);
            }
            valuesY[i] = sum / n;
        }
        return valuesY;
        
        // This was the first try to resolve the method with a while loop
        // while (lo <= hi) {
        //     double sum = 0.0;
        //     for (int i = 1; i <= n; i++) {
        //          sum += Math.cos(i*lo);
        //     }
        //     valuesY[indx] = sum / n;
        //     indx++;
        //     lo += spaceT;
        // }       
    } 

    public static void plotFunct(double[] valuesY) {
        double lo = -10.0;
        double hi = 10.0;
        int samples = 500;
        StdDraw.setXscale(lo, hi );
        StdDraw.setYscale(-1.5, 1.5);
        double spaceS = (hi - lo) / (samples - 1);
        for (int i = 0; i < valuesY.length - 1; i++) {
            StdDraw.line(lo + i * spaceS, valuesY[i], lo + (i + 1)*spaceS, valuesY[i + 1]);
        }
    }
*/

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double tmax = 10.0;
        int samples = 500;
        double[] fValues = fValueSamples(tmax, samples);
        double[] yValues = computeYValues(fValues, n);
        plot(fValues, yValues);


        // previous version. Read the text on the block comment
        // double[] valuesY = sinusoidsSum(n);
        // plotFunct(valuesY);
        
    }
    
}
