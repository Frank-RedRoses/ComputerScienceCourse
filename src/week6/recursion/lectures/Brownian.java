package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/* *****************************************************************************
 *  Compilation:  javac Brownian.java
 *  Execution:    java Brownian var
 *  Dependencies: StdDraw.java
 *
 *  Plots Brownian motion trajectory using the midpoint displacement
 *  method, which is a recursive plan for drawing the plot within the
 *  interval [x0, x1].
 *  
 *  Produces a function graph that approximates a simple example of 
 *  fractional Brownian motion known as a Brownian bridge and closely
 *  related functions. You can think of this graph as a random walk 
 *  that connects two points, from (x0, y0) to (x1, y1), controlled by a 
 *  few parameters. 
 * 
 *  The base case (when the size of the interval is smaller than a given
 *  tolerance) is to draw a straightline connecting the two endpoints.
 *  The reduction case is to divide the interval into two halves, proceeding 
 *  as follows:
     - Compute the midpoint (xm, ym) of the interval.
     - Add to the y-coordinate (ym) of the midpoint a random value delta, chosen 
       from the Gaussian distribution with mean 0 and a given variance.
     - Recur on the subintervals, dividing the variance by a given scaling 
       factor s.
 *   
 *  The variance a measure of dispersion that takes into account the spread 
 *  of all data points in a data set. It is the average squared difference between 
 *  each data point and the center of the distribution, which is measured by the mean.
 *  
 * The standard deviation is derived from variance and tells you, on average, how 
 * far each value lies from the mean. It is the square root of variance. 
 * 
 * Both measures reflect variability in a distribution, but their units differ:
     - Standard deviation is expressed in the same units as the original values (e.g., meters).
     - Variance is expressed in much larger units (e.g., meters squared)
 * 
 *  The shape of the curve is controlled by two parameters: the volatility 
 *  (initial value of the variance) controls the distance the graph strays 
 *  from the straight line connecting the points, and the Hurst exponent 
 *  controls the smoothness of the curve.
 * 
 *  We denote the Hurst exponent by H and divide the variance by 2^(2H) at 
 *  each recursivelevel. When H is 1/2 (divide by 2 at each level) the curve
 *  is a Brownian bridge: a continuous version of the gambler's ruin problem.
 *
 *  % java Brownian 1
 *
 *  % java Brownian 0.5
 *
 ***************************************************************************** */

public class Brownian {

    // Midpoint displacement method.
    // The variance is variance is a measure of dispersion that takes into account 
    // the spread of all data points in a data set.
    public static void curve(double x0, double y0, double x1, double y1, double variance, double s) {      
        // Base case: stops when interval is sufficiently small
        if (x1 - x0 < .01) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }

        // Reduction step: halve the interval size
        double xmid = (x0 + x1) / 2;
        double ymid = (y0 + y1) / 2;
        double stddev = Math.sqrt(variance);           // on average, how far each value lies from the mean.
        double delta = StdRandom.gaussian(0, stddev);  // the mean (mu) is 0, delta gives random positive and negative values from 0 to stddev.
        // because s is dividing the variance it affects the midpoint displacement size
        curve(x0, y0, xmid, ymid + delta, variance / s, s); // 
        curve(xmid, ymid + delta, x1, y1, variance / s, s);
    } 
    
    public static void main(String[] args) {
        /* When hurst < 1 the displacement (delta) will increase
        // the opposite case (hurst > 1) the displacement (delta) will decrease
        // and the curve will be smoother */
        double hurst = Double.parseDouble(args[0]);
        double s = Math.pow(2, 2*hurst);
        curve(0, .5, 1.0, .5, 0.01, s);    
    }
}
