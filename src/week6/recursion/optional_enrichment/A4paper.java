package week6.recursion.optional_enrichment;

import edu.princeton.cs.algs4.StdDraw;

/* *************************************************************************************
 * 2.3.16 A4 paper. The width-to-height ratio of paper in the ISO format is 
 * the square root of 2 to 1. Format A0 has an area of 1 square meter. Format A1
 * is A0 cut with a vertical line into two equal halves, A2 is A1 cut with 
 * a horizontal line into two halves, and so on. 
 * 
 * Write a program that takes an integer command-line argument n and uses StdDraw
 * to show how to cut a sheet of A0 paper into 2^n pieces.
 * 
 ************************************************************************************* */
public class A4paper {
    
    // Problem constants
    
    public static void formatA(int n, int aSize, double width, double height) {
        if (n == 0) return;
        aSize++;
        if (width > height) {
            width /= 2;
            StdDraw.line(width, 0, width, height);
            StdDraw.text(width + width / 2, height / 2, "A" + aSize);
            StdDraw.text(width + width / 2, height / 2 - 25, Math.round(width) + "x" + Math.round(height));

        } else {
            height /= 2;
            StdDraw.line(0, height, width, height);
            StdDraw.text(width / 2, height + height / 2, "A" + aSize);
            StdDraw.text(width / 2, height + height / 2 - 25, Math.round(width) + "x" + Math.round(height));
        }
        formatA(--n, aSize, width, height);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double ratioIso = Math.sqrt(2);
        double areaA0SqrMeters = 1;
        int aInitialSize = 0;
        StdDraw.setCanvasSize((int) (512 * ratioIso),  512);
        double xA0 = Math.sqrt(areaA0SqrMeters * ratioIso) * 1000;
        double yA0 = Math.sqrt(areaA0SqrMeters / ratioIso) * 1000;
        StdDraw.setXscale(0.0, xA0);
        StdDraw.setYscale(0.0, yA0);
        formatA(n, aInitialSize , xA0, yA0);
    }   
    
}
