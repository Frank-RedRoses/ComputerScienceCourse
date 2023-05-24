package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdDraw;

/* *****************************************************************
 * 2.3.33. Recursive tree.
 * Write a program Tree.java that takes a command-line argument n 
 * and produces the following recursive patterns for n equal to 
 * 1, 2, 3, 4, and 8.
 *  
 ******************************************************************* */
public class Ex33Tree {


    public static void tree(int n, double x, double y, double radians, double branchRadius) {
        // draw the main trunk
        StdDraw.setPenRadius(0.001 * Math.pow(n, 1.2));
        double cx = x + Math.cos(radians) * branchRadius;
        double cy = y + Math.sin(radians) * branchRadius;
        StdDraw.line(x, y, cx, cy);
        // base case:
        if (n == 0)  return;
        // Otherwise compute values for the branches
        double bendAngle = Math.toRadians(15);
        double branchAngle = Math.toRadians(37);
        double branchRation = 0.65;
        // Reduction step: draw the branches
        tree(n-1, cx, cy, radians + bendAngle, branchRadius * ( 1 - branchRation));     // small branch
        tree(n-1, cx, cy, radians + bendAngle + branchAngle, branchRadius * branchRation);  // left branch
        tree(n-1, cx, cy, radians + bendAngle - branchAngle, branchRadius * branchRation);  // right branch
    }

    public static void main(String[] args) {
        tree(3, 0.5, 0, Math.PI / 2, 0.3);
    }
    

    
}
