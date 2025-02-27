package week4.io.booksite;
/* ****************************************************************************************
*  Compilation:  javac Triangle.java
 *  Execution:    java Triangle
 *  Dependencies: StdDraw.java
 *
 *  Hello World of the StdDraw Class: Plot a triangle.
 * 
 **************************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class Triangle {
    public static void main(String[] args) {
        // %5 border 
        StdDraw.setScale(-0.05, 1.05);

        // draw the triangle
        double c = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, c);
        StdDraw.line(0.5, c, 0.0, 0.0);

        // draw the pointl; make pen radius large enough to see it
        StdDraw.setPenRadius(0.01);
        StdDraw.point(0.5, c/3.0);
        StdDraw.text(0.5, 0.5, "Hello, World");
    }
}
