package week4.io.lectures;
/* *****************************************************************************
 *  Compilation:  javac BouncingBallDeluxe.java
 *  Execution:    java BouncingBallDeluxe
 *  Dependencies: StdDraw.java StdAudio.java
 *                https://introcs.cs.princeton.edu/java/15inout/TennisBall.png
 *                https://introcs.cs.princeton.edu/java/15inout/pipebang.wav
 *
 *  Implementation of a bouncing tennis ball in the box from (-1, -1) to (1, 1),
 *  with sound effects.
 *
 *  % java BouncingBallDeluxe
 *
 ***************************************************************************** */

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class BouncingBallDeluxe {
    public static void main(String[] args) {
        
        // intial values
        double px = 0.480, py = 0.860;  // initial position
        double vx = 0.015, vy = 0.023;  // velocity
        double radius = 0.05;           // radius
        
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        while (true) {

            // bounce off wall acording to the laws of elastic collision
            if (Math.abs(px + vx) > 1.0 - radius) {
                vx = -vx;
                StdAudio.play("./resources/ball/sound/pipebang.wav");
            } 
            if (Math.abs(py + vy) > 1.0 - radius) {
                vy = -vy;
                StdAudio.play("./resources/ball/sound/pipebang.wav");
            }

            // update position
            px = px + vx;
            py = py + vy;

            // clear the background
            StdDraw.clear(StdDraw.LIGHT_GRAY);

            // draw ball on the screen
            StdDraw.picture(px, py, "./resources/ball/img/tennisball.png");

            // copy offscreen buffer to screen
            StdDraw.show();

            // pause for 20 ms
            StdDraw.pause(20);
        }
    }
    
}
