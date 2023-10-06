package week6.recursion.optional_enrichment;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/*
 * 2.3.9 Ruler. Write a recursive program Ruler to plot the subdivisions of a ruler using StdDraw.
 */

public class PlotRuler {
    
    /** 
     * Plot the subdivisions of a ruler using recursion.
     * 
     * @param n level of recursion calls
     * @param x0 x point of the subdivision in the previous {@code n} value 
     * @param x1 x point of the actual subdivision
     * @param y0 base or lower point {@code y} of the subdivisions
     * 
     */
    public static void plotRuler(int n, double x0, double x1, double y0) {
        // Base case: if n = 0 do nothing
        if (n == 0) return; 
        // Plot the suddivision with variable height y, if n > 3 height is fixed.
        double y1;
        if (n > 3) y1 = 0.4;
        else y1 = n * 0.1;
        StdDraw.line(x1, y0, x1, y1);
        // reduction step: compute the offset for the next x-coord using 
        // the mid point between the actual subdivision x-coord (x1) 
        // and the previous one (x0).
        double xMid = Math.abs(x1 - x0) / 2;
        // recursive calls
        plotRuler(n - 1, x1, x1 - xMid, y0);
        plotRuler(n - 1, x1, x1 + xMid, y0);
    } 

    // Subdivisions of a ruler, recursive solution.
    public static String ruler(int n) {
        if (n == 0) return "";
        return ruler(n - 1) + n + ruler(n - 1);
    }

    // alternative plotter using a for loop instead of recursion
    public static void rulerPlotter(String s) {
        // set the number and max division height
        int nDiv = 0;
        int subDiv = 0;
        double yMaxHeightSubdiv = 4.0;
        double yNDiv = yMaxHeightSubdiv + 0.5;
        // set the canvas
        StdDraw.setYscale(-1, 15);
        StdDraw.setXscale(-1, 0.25 * s.length() + 1);
        // Draw the 0 division line
        StdDraw.line(0, 0, 0, yMaxHeightSubdiv);
        StdDraw.text(0, yMaxHeightSubdiv + 0.5, "" + nDiv);
        
        // countinue with the subdivisions
        for (int i = 0; i < s.length(); i++) {
            double x = 0.25 + i*(0.25);     // compute the x point of the subdivision
            // let's try different codes, all these code lines get an int from a char:
            subDiv = s.charAt(i) - '0';    // this uses the difference in the numerical representation of chars.
            // subDiv = Character.getNumericValue(s.charAt(i));        // this returns char numbers as a numeric value, but also letters as numeric values.
            // subDiv = Integer.parseInt(String.valueOf(s.charAt(i))); // this option gives a NumberFormatException, this is better for error handling.

            // draw the subdivision with a variable height
            if (subDiv > 3) {   // all subdivisions with a level greater than 3 have equal height of 4.0
                nDiv++;
                StdDraw.line(x, 0, x, yMaxHeightSubdiv);
                StdDraw.text(x, yNDiv, "" + nDiv);
            } else {            // otherwise variable height
                StdDraw.line(x, 0, x, subDiv);
            }
        }
        // Draw the final division
        if (nDiv > 0) {
            nDiv++;
            StdDraw.line(0.25 + s.length()*0.25, 0, 0.25 + s.length()*0.25, yMaxHeightSubdiv);
            StdDraw.text(0.25 + s.length()*0.25, yNDiv, "" + nDiv);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String divisions = ruler(n);
        StdOut.println(divisions);
        // rulerPlotter(divisions);
        plotRuler(n, 0.0, 0.5, 0.05);
    }
}
