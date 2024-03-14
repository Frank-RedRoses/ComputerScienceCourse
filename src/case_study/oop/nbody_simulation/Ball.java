package case_study.oop.nbody_simulation;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac Ball.java
 *  Execution:    java Ball
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d Ball moving in square with coordinates
 *  between -1 and 1. Bounces off the walls upon collision.
 *
 *
 ******************************************************************************/

public class Ball {
    
    private double rx, ry;
    private double vx, vy;
    private final double radius;

    // constructor
    public Ball() {
        rx = 0.0;
        ry = 0.0;
        vx = StdRandom.uniform(-0.015, 0.015);
        vy = StdRandom.uniform(-0.015, 0.015);
        radius = StdRandom.uniform(0.025, 0.075);        
    }

    // bounce of vertical wall by reflecting x-velocity
    public void bounceOfVerticalWall() {
        vx = -vx;
    }

    // bounce of Horizontal wall by reflecting x-velocity
    public void bounceOfHorizontalWall() {
        vy = -vy;
    }

    // move the ball one step
    public void move() {
        if (Math.abs(rx + vx) + radius > 1.0) bounceOfVerticalWall();
        if (Math.abs(ry + vy) + radius > 1.0) bounceOfHorizontalWall();
        rx += vx;
        ry += vy;
    }

    // draw the ball
    public void draw() {
        StdDraw.filledCircle(rx, ry, radius);
    }

    // test client
    public static void main(String[] args) {
        
        // create and initialize two balls 
        Ball b1 = new Ball();
        Ball b2 = new Ball();

        // animate them
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        while (true) {
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            b1.move();
            b2.move();
            b1.draw();
            b2.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
