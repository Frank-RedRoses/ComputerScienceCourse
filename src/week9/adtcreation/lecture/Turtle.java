package week9.adtcreation.lecture;

import edu.princeton.cs.algs4.StdDraw;

public class Turtle {
    // Instance Variables 
    // (not final because the turtle need to change position and orientation)
    private double x, y;
    private double angle;

    // Constructor
    public Turtle(double x0, double y0, double ang0) {
        x = x0;
        y = y0;
        angle = ang0;
    }

    // Methods (implementing APIs)
    // Rotate the turtle only to the left
    public void turnLeft(double delta) {
        angle += delta;
    }

    // Move the turtle forward and draw a line by d distance
    // Use pythagoras to compute the new x and y coordinates
    public void goForward(double d) {
        double oldx = x;
        double oldy = y;
        x += d * Math.cos(Math.toRadians(angle));
        y += d * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y); 
    }

    // Begin by implementing a simple test client
    public static void main(String[] args) {
        Turtle turtle = new Turtle(0.0, 0.0, 0.0);
        // draw a triangle
        turtle.goForward(1.0);
        turtle.turnLeft(120.0);
        turtle.goForward(1.0);
        turtle.turnLeft(120.0);
        turtle.goForward(1.0);
        turtle.turnLeft(120.0);
    }
}
