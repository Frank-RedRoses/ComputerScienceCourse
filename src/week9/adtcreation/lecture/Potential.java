package week9.adtcreation.lecture;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdIn;

import java.awt.Color;

public class Potential {

    /*
     * Reads point charges from Standard Input.
     * The first line in the input file is number of the charges.
     * Then, the every next line is a point charge with position (x y) 
     * and electric charge (q).
     */
    public static Charge[] readCharges() {
        int N = StdIn.readInt();
        Charge[] a = new Charge[N];
        for (int i = 0; i < N; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double q = StdIn.readDouble();
            a[i] = new Charge(x, y, q);
        }
        return a;
    }

    /*  
     * Conver potential values to a color.
     * Convert v to an 8-bit integer between 0 and 255.
     * Return a grayscale color.
     */
    public static Color toColor(double v) {
        v = 128 + v / 2.0e10;   // assume than potential won't be any bigger than 2.0e10
        int t = 0;              // Black (v < 0)
        if (v > 255) t = 255;   // White (v > 255)
        else if (v >= 0) t = (int) v;   // Grayscale
        return new Color(t, t, t);
    }

    public static Color toColorLines(double v) {
        v = 128 + v / 2.0e10;
        int t = 0;
        if (v > 255) t = 255;
        else if (v >= 0) t = (int) v;
        t = t*37 % 255;
        return new Color(t, t, t);
    }

    public static void main(String[] args) {
        Charge[] a = readCharges();             // read the point charges
        int SIZE = 800;
        Picture pic = new Picture(SIZE, SIZE);  // create a new picture
        // fill-in all the pixels
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                double v = 0.0;
                // for every charge compute potential at point (col,row)
                for (int i = 0; i < a.length; i++) {
                    double x = 1.0 * col / SIZE;
                    double y = 1.0 * row / SIZE;
                    v += a[i].potentialAt(x, y);    // sum the charges 1by1
                }
                // compute and set the colot in the pixel
                pic.set(col, SIZE - 1 - row, toColorLines(v)); 
            }
        }
        pic.show();
    }
}

/*
 * The Party decoration kit was almost perfect, the one thing that took away the
 *  perfect score was that two letters had small wrinkles on border, but nothing
 *  terrible, just small lines, could have happened during the shipping process.
 *  Everything else was perfect!
 */
