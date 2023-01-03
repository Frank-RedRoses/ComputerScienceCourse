package week4.io.optional_enrichment;
/* ******************************************************************************
 * 1.5.31 Spirographs. Write a program that takes three double command-line 
 * arguments R, r, and a and draws the resulting spirograph. A spirograph 
 * (technically, an epicycloid) is a curve formed by rolling a circle of radius 
 * r around a larger fixed circle of radius R. If the pen offset from the center 
 * of the rolling circle is (r+a), then the equation of the resulting curve 
 * at time t is given by:
 * 
 * x(t)=(R+r)cos(t)−(r+a)cos((R+r)t/r) 
 * y(t)=(R+r)sin(t)−(r+a)sin((R+r)t/r)
 * 
 * Such curves were popularized by a best-selling toy that contains discs with 
 * gear teeth on the edges and small holes that you could put a pen in to trace 
 * spirographs.
 ****************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Spirographs {
    public static void main(String[] args) {
        double time = 60.0; 

        double largerR = Math.toRadians(Double.parseDouble(args[0]));
        double smallr = Math.toRadians(Double.parseDouble(args[1]));
        double a = Math.toRadians(Double.parseDouble(args[2]));

        // Set the coordinate system
        StdDraw.setScale(-4, 4);
        StdDraw.setPenRadius(0.005);

        for (double t = 0; t < time; t += 0.02) {
            if (smallr == 0.0) smallr = 0.01; // Avoid divide-by-zero
            // x(t)=(R+r)cos(t)−(r+a)cos((R+r)t/r)
            // y(t)=(R+r)sin(t)−(r+a)sin((R+r)t/r)
            double x = (largerR + smallr) * Math.cos(t) - (smallr + a) * Math.cos((largerR + smallr) * t / smallr);
            double y = (largerR + smallr) * Math.sin(t) - (smallr + a) * Math.sin((largerR + smallr)* t / smallr);
            // output
            StdDraw.point(x, y);
            // debug
            StdOut.println("(" + x + ", " + y + ")");
        }
    }
}
