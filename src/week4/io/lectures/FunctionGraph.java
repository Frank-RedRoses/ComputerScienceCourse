package week4.io.lectures;
/******************************************************************************
 *  Compilation:  javac FunctionGraph.java
 *  Execution:    java FunctionGraph n
 *  Dependencies: StdDraw.java
 *
 *  Plots the function y = sin(4x) + sin(20x) between x = 0 and x = pi
 *  by drawing n line segments.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdDraw;

public class FunctionGraph {
    public static void main(String[] args) {
        
        // number of segments  to plot
        int n = Integer.parseInt(args[0]);

        // the function y= sin(4x) + sin(20x), sample at n+1 points
        // between x = 0 and x = pi
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        for (int i = 0; i <= n; i++) {
            x[i] = Math.PI * i / n;
            y[i] = Math.sin(4*x[i]) + Math.sin(20*x[i]);
        }

        // rescale the coordinate system
        StdDraw.setXscale(0, Math.PI);
        StdDraw.setYscale(-2.1, +2.1);

        // plot the aproximation of the function 
        for (int i = 0; i < n; i++) {
            StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
        }
    }
    
}
