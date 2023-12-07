package week9.adtcreation.lecture;

import edu.princeton.cs.algs4.StdOut;

/*
 * ADT for point charges.
 * A point charge is an idealized model of a particle that has an electric charge
 * Electric potential is a measure of the effect of a point charge on its surroundings.
 *      It increases in proportion to the charge value.
 *      It decreases in proportion to the inverse of the distance from the charge (2D).
 * Mathematically,
 *  • Suppose a point charge c is located at (rx, ry) and has charge q.
 *  • Let r be the distance between (x, y ) and (rx, ry)
 *  • Let Vc(x,y) be the potential at (x, y ) due to c.
 *  • Then Vc(x,y) = k*q/r where k = 8.99×109 is a normalizing factor.
 */

public class Charge {
    // Instance variables
    private final double rx, ry;    // position
    private final double q;         // charge

    // Constructor
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    // Methods (not static)
    // Electric potential at (x, y) due to charge
    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        // r = sqrt((rx - x)^2 + (ry - y)^2)
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    // String representation of this charge
    public String toString() {
        return q + " at (" + rx + ", " + ry + ")";
    }

    // test client (static)
    public static void main(String[] args) {
        Charge c = new Charge(.72, .31, 21.3);
        StdOut.println(c.toString());
        StdOut.printf("%6.2e\n", c.potentialAt(.42, .71));
    }
}
