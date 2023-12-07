package week9.adtcreation.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 3.2.11 Write a data type Point that implements the following API:
 * 
 * public class Point
 *      Point(double x, double y)
 *      double distanceTo(Point q)  // Euclidean distance between this point and q.
 *      String toString()           // string representation.
 * 
 */
public class Point {
    
    private final double coordx;
    private final double coordy;

    public Point(double x, double y) {
        coordx = x;
        coordy = y;
    }

    // Euclidean distance between this point and q
    public double distanceTo(Point q) {
        double deltax = q.coordx - coordx;
        double deltay = q.coordy - coordy;
        return Math.sqrt(deltax*deltax + deltay*deltay);
    }

    @Override
    public String toString() {
        return "(" + coordx + ", " + coordy + ")";
    }

    public static void main(String[] args) {
        double x0 = Double.parseDouble(args[0]);
        double y0 = Double.parseDouble(args[1]);
        Point p0 = new Point(x0, y0); 
        int N = StdIn.readInt();
        for (int i = 0; i < N; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point p = new Point(x, y);
            StdOut.println("distance between " + p + " and " + p0 + " = " + p.distanceTo(p0));
        }
    }
}
