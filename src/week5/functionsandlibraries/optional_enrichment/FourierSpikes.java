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

    public static double[] sinusoidsSum(int n) {
        double lo = -10.0;
        double hi = 10.0;
        int samples = 500;
        double[] valuesY = new double[samples + 1];
        for (int i = 0; i <= samples; i++) {
            double t = lo + (hi - lo) * i / samples;
            double sum = 0.0;
            for (int j = 1; j <= n; j++) {
                sum += Math.cos(j*t);
            }
            valuesY[i] = sum / n;
        }
        /* 
        while (lo <= hi) {
            double sum = 0.0;
            for (int i = 1; i <= n; i++) {
                 sum += Math.cos(i*lo);
            }
            valuesY[indx] = sum / n;
            indx++;
            lo += spaceT;
        }
        */
        return valuesY;
    } 

    public static void plotFunct(double[] valuesY) {
        double lo = -10.0;
        double hi = 10.0;
        int samples = 500;
        StdDraw.setXscale(lo, hi );
        StdDraw.setYscale(-1.5, 1.5);
        double spaceS = (hi - lo) / samples;
        for (int i = 0; i < valuesY.length - 1; i++) {
            StdDraw.line(lo + i * spaceS, valuesY[i], lo + (i + 1)*spaceS, valuesY[i + 1]);
        }
    }


    public static void main(String[] args) {
        int arg = Integer.parseInt(args[0]);
        double[] valuesY = sinusoidsSum(arg);
        plotFunct(valuesY);
    }
    
}
