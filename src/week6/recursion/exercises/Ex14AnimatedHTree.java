package week6.recursion.exercises;

import edu.princeton.cs.algs4.StdDraw;

public class Ex14AnimatedHTree {

    // Plot an order n H-tree, centered on (x,y) of the given size length 
    public static void draw(int n, double size, double centerX, double centerY) {
        if (n == 0)  return;

        // compute x and y coordinates of the 4 half-size H-trees
        double x0 = centerX - size/2, x1 = centerX + size/2;
        double y0 = centerY - size/2, y1 = centerY + size/2;

        // modification 
        draw(n-1, size/2, x0, y0); // lower left
        draw(n-1, size/2, x0, y1); // upper left
        // draw the big H centered on (centerX, centerY)
        StdDraw.line(x0, centerY, x1, centerY);
        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);
        StdDraw.show();
        StdDraw.pause(100);

        // recursively draw four half-size H-trees of order n-1
        draw(n-1, size/2, x1, y1); // upper right
        draw(n-1, size/2, x1, y0); // lower right
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();
        draw(n, .5, .5, .5);
    }
    
}
