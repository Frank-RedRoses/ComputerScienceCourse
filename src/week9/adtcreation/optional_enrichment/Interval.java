package week9.adtcreation.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/** 
 * 3.2.8 Write a data type Interval.
 * An interval is defined to be the set of all points on the line greater
 * than or equal to left and less than or equal to right. In particular,
 * an interval with right less than left is empty. Write a client that is
 * a filter that takes a floating-point command-line argument x and prints
 * all of the intervals on standard input (each defined by a pair of double
 * values) that contain x.
 */
public class Interval {
    
    private final double leftPoint;
    private final double rightPoint;

    public Interval(double left, double right) {
        leftPoint = left;
        rightPoint = right;
    }

    // is x in this interval?
    public boolean contains(double x) {
        return leftPoint <= x && x <= rightPoint;
    }

    // do this interval and b intersect?
    public boolean intersects(Interval b) {
        return this.contains(b.leftPoint) || this.contains(b.rightPoint);
    }

    // String representation
    public String toString() {
        return "(" + leftPoint + ", " + rightPoint + ")";
    }

    public static void main(String[] args) {
        double x = -1.0;
        int N = StdIn.readInt();
        Interval interval = new Interval(2.0, 4.9);
        for (int i = 0; i < N; i++) {
            double left = StdIn.readDouble();
            double right = StdIn.readDouble();
            Interval stdInInterval = new Interval(left, right);
            if (stdInInterval.contains(x))
                StdOut.println(stdInInterval + " contains point " + x );
            if (stdInInterval.intersects(interval)) {
                StdOut.println(stdInInterval + " intersects " + interval);
            }
        }
    }
}
