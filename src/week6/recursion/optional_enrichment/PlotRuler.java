package week6.recursion.optional_enrichment;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/*
 * 2.3.9 Ruler. Write a recursive program Ruler to plot the subdivisions of a ruler using StdDraw.
 */

public class PlotRuler {
    
    public static String ruler(int n) {
        if (n == 0) return "";
        return ruler(n - 1) + n + ruler(n - 1);
    }

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
        // countinue to subdivisions
        
        for (int i = 0; i < s.length(); i++) {
            double x = 0.25 + i*(0.25);

            // let's play a little, all these code lines get an int from a char:
            subDiv = s.charAt(i) - '0';                             // this uses the difference in the numerical representation of chars.
            // subDiv = Character.getNumericValue(s.charAt(i));        // this returns char numbers as a numeric value, but also letters as numeric values.
            // subDiv = Integer.parseInt(String.valueOf(s.charAt(i))); // this option gives a NumberFormatException, this is better for error handling.

            if (subDiv > 3) {
                nDiv++;
                StdDraw.line(x, 0, x, yMaxHeightSubdiv);
                StdDraw.text(x, yNDiv, "" + nDiv);
            } else {
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
        rulerPlotter(divisions);
    }
}
