package week8.adt.lecture;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

// The monochrome luminance of a color quantifies its effective brightness.
public class Luminance {

    // Computes the luminance of a color c using the NTSC standard formula:  
    // luminance= 0.299r + 0.587g + 0.114b.
    public static double lum(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        return  .299*r + .587*g + .114*b;
    }

    public static boolean compatible(Color a, Color b) {
        return Math.abs(lum(a) - lum(b)) > 128.0;
    }

    public static Color toGray (Color c) {
        int y = (int) Math.round(lum(c));
        Color gray = new Color(y, y, y);
        return gray;
    }

    public static void main(String[] args) {
        // Create the first color
        int r1 = Integer.parseInt(args[0]);
        int g1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);
        Color c1 = new Color(r1, g1, b1);
        // Create the second color
        int r2 = Integer.parseInt(args[3]);
        int g2 = Integer.parseInt(args[4]);
        int b2 = Integer.parseInt(args[5]);
        Color c2 = new Color(r2, g2, b2);

        // Get the luminance value of both colors
        StdOut.println("Luminance of color 1: " + Math.round(lum(c1)));
        StdOut.println("Luminance of color 2: " + Math.round(lum(c2)));

        // Show if they are compatible
        StdOut.println("Compatible?: " + compatible(c1, c2));

        // Covert color to gray
        Color gray1 = toGray(c1);
        Color gray2 = toGray(c2);
        StdDraw.setPenColor(c1);
        StdDraw.filledSquare(.25, .5, .2);
        StdDraw.setPenColor(c2);
        StdDraw.filledSquare(.25, .5, .1);
        StdDraw.setPenColor(gray1);
        StdDraw.filledSquare(.75, .5, .2);
        StdDraw.setPenColor(gray2);
        StdDraw.filledSquare(.75, .5, .1);

    }
    
}
