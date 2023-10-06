package week4.io.booksite;

import edu.princeton.cs.algs4.StdDraw;

/******************************************************************************
 *  Compilation:  javac-introcs BouncingBall.java
 *  Execution:    java-introcs BouncingBall
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
 *
 *  % java BouncingBall
 *
 ******************************************************************************/

public class BouncingBall {
    public static void main(String[] args) {
        
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // intial values
        double px = 0.480, py = 0.860;  // initial position
        double vx = 0.015, vy = 0.023;  // velocity
        double radius = 0.05;           // radius

        // main animation loop
        while (true) {

            // bounce off wall acording to the laws of elastic collision
            if (Math.abs(px + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(py + vy) > 1.0 - radius) vy = -vy;

            // update position
            px = px + vx;
            py = py + vy;

            // clear the background
            StdDraw.clear(StdDraw.LIGHT_GRAY);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(px, py, radius);

            // copy offscreen buffer to screen
            StdDraw.show();

            // pause for 20 ms
            StdDraw.pause(20);
        }
    }
}
