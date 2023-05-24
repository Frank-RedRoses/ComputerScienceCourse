package week6.recursion.exercises;

import edu.princeton.cs.algs4.StdDraw;

/* ********************************************************************
 * Ex. 2.3.9
 * Writer a recursive program Ruler to plot the subdivisions of a ruler 
 * using StdDraw as in program 1.2.1.
 * ********************************************************************/
public class Ex9Ruler {

    // Draw a ruler center in x
    public static void drawRuler(int n, double xCoordMeasureLine) {
        // base case: do nothing when n == 0 and return.
        if (n == 0) return;
        // Find the distance between the n line and the next n-1 line in the recursion call.
        /* Because the recursive call always make 2 calls, the number of times n == 0 is reached is
         * a power of two value that depends on the value of n (2^n). 
         * It is possible to think of these n == 0 as a blank space between measurement lines in a ruler,
         * with half on each side of the nth line. This means that n=1 will have 2^1 = 2 spaces, one 
         * space to each side, for n=2 is 2^2 = 4 spaces, 2 on one side and 2 on the other, and it is because 
         * the lower level n=1 have 2 spaces, and so on... n=3 will have 2^3 = 8 spaces, 4 on each side, 
         * because n=2 have 4 spaces. 
         * So, to know the distance between n and the closest line of a lower n is as easy as find 2^lower n,
         * dividing that by 2 and that gives the half of the blank spaces that separate those two n lines.
         * Next, only have to multiply that by the distance value of one blank space and that will give you the 
         * distance between the two n lines.   
         */
        // Blank spaces between lines n and n-1. 
        // Blank space distance is 2.0 units, which simplifies the equation.
        double distNextLine = Math.pow(2, n-1);    
        // recursive step (subtract the distace to find the xCoord of n-1 line on left side)
        drawRuler(n-1, xCoordMeasureLine - distNextLine); 
        // draw the measure line (center)
        drawMeasureLine(n, xCoordMeasureLine, 10);     
        // recursive step (add the distace to find the xCoord of n-1 line on right side)
        drawRuler(n-1, xCoordMeasureLine + distNextLine);
    }

    // draw a measure line that starts at (x0, y0) with numbers under the measure lines.
    private static void drawMeasureLine(int n, double x0, double y0) {
        double height = 5;      // 5 units
        if (n < 5) height *= n; // lines with low values  = n times the height
        else height *= 5;       // lines with high values = 5 times the height
        StdDraw.text(x0, y0 - 3.5, "" + n); 
        StdDraw.line(x0, y0, x0, y0 + height);
    }

    public static void main(String[] args) {
        // input:
        int n = 4;   
        // 2^6 = 64 blank spaces * 2 unit per blank space = 128 units.
        // set the canvas scale (in units) and center the ruler (hardcoded)
        double xMaxLength = 150;      // units
        // n > 6 will make the ruler go out of the canvas.
        // 2^7 = 128 blank spaces * 2 unit per blank space = 256 units.
        StdDraw.setCanvasSize(800, 200); // pixels
        StdDraw.setXscale(0, xMaxLength);     // 0 - 150 units
        StdDraw.setYscale(0, xMaxLength / 3);  // 0 - 50 units
        double xCenter = xMaxLength / 2;

        // Draw the ruler divisions
        drawRuler(n, xCenter);

    }
}
