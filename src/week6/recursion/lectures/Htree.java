package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdDraw;
/* ******************************************************************************
 *  Compilation:  javac Htree.java
 *  Execution:    java Htree n
 *  Dependencies: StdDraw.java
 *
 *  Plot an order n H-tree.
 *
 *  % java Htree 5
 *
 ***************************************************************************** */ 

public class Htree {
    
    // Plot an order n H-tree, centered on (x,y) of the given size length 
    public static void draw(int n, double size, double centerX, double centerY) {
        // Base case: n reach the 0 value
        if (n == 0)  return;
        // compute x and y coordinates of the 4 half-size H-trees
        double x0 = centerX - size/2, x1 = centerX + size/2;
        double y0 = centerY - size/2, y1 = centerY + size/2;
        // draw the big H centered on (centerX, centerY)
        StdDraw.line(x0, centerY, x1, centerY);
        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);
        // Reduction Step:
        // recursively draw four half-size H-trees of order n-1 in the 4 tips of the big H
        draw(n-1, size/2, x0, y0);
        draw(n-1, size/2, x0, y1);
        draw(n-1, size/2, x1, y1);
        draw(n-1, size/2, x1, y0);
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, .5, .5, .5);
    }
}
