package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/* ****************************************************************************
 * 2.3.30. Brownian island.
 * B. Mandelbrot asked the famous question How long is the coast of Britain? 
 * Modify Brownian.java to get a program BrownianIsland.java that plots Brownian
 * islands, whose coastlines resemble that of Great Britain. The modifications 
 * are simple: first, change curve() to add a random Gaussian to the x-coordinate
 * as well as to the y-coordinate; second, change main() to draw a curve from 
 * the point at the center of the canvas back to itself. Experiment with various
 * values of the arguments to get your program to produce islands with a realistic
 * look.
 * 
 * % Ex30BrownianIsland.java 0.5 11
 **************************************************************************** */
public class Ex30BrownianIsland {

    public static void curve(double x0, double y0, double x1, double y1, double variance, double n) {
        // base case: 
        if (n == 0) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }

        // Reduction step: halve the interval size and lower the variance dividing by 3.
        double xmid = (x1 + x0) / 2;
        double ymid = (y1 + y0) / 2;
        // Add a random value delta to ymid, chosen from the Gaussian distributtion
        // with mean 0 and the given variance.
        double stdDev = Math.sqrt(variance);
        double deltaX = StdRandom.gaussian(0, stdDev);
        double deltaY = StdRandom.gaussian(0, stdDev);
        // Make the recursion call for the halve intervals, every call make 2 new calls, 
        // so at the end the recursion will create 2^n halves.
        curve(x0, y0, xmid + deltaX, ymid + deltaY, variance / 3, n-1);   // 3.0 seens to be a good value
        curve(xmid + deltaX, ymid + deltaY, x1, y1, variance / 3, n-1);
    }

    public static void main(String[] args) {
        // double variance = Integer.parseInt(args[0]);
        // int n = Integer.parseInt(args[1]);
        double variance = 0.5;      // the variance gives the size of the delta values (offset values). 
        int n = 11;                 // 2^n is the number of strokes that will form the island.
        // Set the canvas
        StdDraw.setCanvasSize(800,600);
        StdDraw.setXscale(-1, +1);
        StdDraw.setYscale(-1, +1);
        // First use a lower value than the initial variance 0.5, divided by 1,414 = 0.3535.
        // This initial variance will give us a size of the first halve that will fit inside the canvas.
        curve(0, 0, 0, 0, variance / Math.sqrt(2), n);
    }
}
