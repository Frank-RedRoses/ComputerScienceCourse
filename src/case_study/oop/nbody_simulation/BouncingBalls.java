package case_study.oop.nbody_simulation;

import edu.princeton.cs.algs4.StdDraw;

/******************************************************************************
 *  Compilation:  javac BouncingBalls.java
 *  Execution:    java BouncingBalls n
 *  Dependencies: Ball.java StdDraw.java
 *
 *  Creates an array of n bouncing balls and animates them.
 *
 *  % java BouncingBalls 10
 *
 ******************************************************************************/

public class BouncingBalls {

    public static void main(String[] args) {
        // number of balls 
        int n = Integer.parseInt(args[0]);

        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // create ana array containing n balls
        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            balls[i] =  new Ball();
        }

        // do the animation loop
        while (true) {
            
            // move the balls
            for (int i = 0; i < n; i++) {
                balls[i].move();
            }
            
            // draw the balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            for (int i = 0; i < n; i++) {
                balls[i].draw();
            }            
            StdDraw.show();
            StdDraw.pause(10);
        }
    }

}
