package case_study.functions_and_modules.percolation;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/************************************************************************
 * Program 2.4.6 Adaptive plot client.
 * This recursive program draws a plot of the percolation probability 
 * (experimental observations) against the site vacancy probability p 
 * (control variable) for random n-by-n systems.
 *************************************************************************/

public class PercolationPlot {

    // Stores the first computed point (x,y) where the  
    // percolation probability is greater than 50%
    static double xPercolates = 0.0;    
    static double yPercolates = 0.0;    
    /*
     * n = system size
     * x0, y0 = left point
     * x1, y1 = right point
     * 
     * xmid, ymid = midpoint
     * fxm = value at midpoint
     * gap = gap tolarence
     * error = error tolerance
     * trials = number of trials
     */
    public static void curve(int n, double x0, double y0, double x1, double y1) {
        // Performs experiments and plots result
        double gap = 0.01;
        double error = 0.0025;
        int trials = 10000;
        double xmid = (x0 + x1) / 2.0;  // x = site vacancy probability axis
        double ymid = (y0 + y1) / 2.0;  // y = percolation probability axis
        double fxmid = PercolationProbability.estimate(n, xmid, trials); // fxmid = percolation probability estimation
        // base case:
        if (x1 - x0 < gap || Math.abs(ymid - fxmid) < error) {
            StdDraw.line(x0, y0, x1, y1);
            // Saves the point where the percolation starts to be greater than 50%
        if (fxmid > 0.5 && xPercolates == 0.0) {
            if (y0 > 0.5) {
                xPercolates = x0;
                yPercolates = y0;
            } else {
                xPercolates = xmid;
                yPercolates = fxmid;
            } 
        }
            return;
        }
        // reduction step
        curve(n, x0, y0, xmid, fxmid);
        StdDraw.filledCircle(xmid, fxmid, 0.005);
        curve(n, xmid, fxmid, x1, y1);
    }

    public static void drawAxis() {
        StdDraw.setPenRadius(0.0005);
        // Draw x and y axis
        StdDraw.line(-0.01, 0, 1, 0);
        StdDraw.line(0, -0.01, 0, 1);
        StdDraw.line(1.0, 0, 1.0, -0.01);
        StdDraw.line(0, 1.0, -0.01, 1.0);
        StdDraw.line(0, 0.5, 1.0, 0.5);
        // Set axis legend
        StdDraw.text(0, -0.03, "0");
        StdDraw.text(1.0, -0.03, "1");
        StdDraw.text(-0.03, 1.0, "1");
        // Reset pen saize
        StdDraw.setPenRadius();
    }

    public static void drawPercolationPoint() {
        if (yPercolates == 0.0) {
            StdOut.println("The system does not percolates");
        } else {
            StdDraw.setPenRadius(0.0005);
            StdDraw.line(xPercolates, yPercolates, xPercolates, -0.01);
            StdDraw.text(xPercolates, -0.03, Double.toString(xPercolates));
            StdDraw.setPenRadius();
        }
    }

    public static void main(String[] args) {

        // Plot experimental curve for n-by-n percolation systems
        int n = Integer.parseInt(args[0]); 
        StdDraw.setScale(-0.05, 1.05);
        drawAxis();
        curve(n, 0.0, 0.0, 1.0, 1.0);
        drawPercolationPoint();
    }
}
