package week4.io.booksite;
/* *****************************************************************************
 *  Compilation:  javac OneSimpleAttractor.java
 *  Execution:    java OneSimpleAttractor
 *  Dependencies: StdDraw.java
 *
 *  A particle is attracted to the current location of the mouse.
 *  Incorporates drag.
 *
 *
 *  % java OneSimpleAttractor
 *
 *
 *  Credits:  Jeff Traer-Bernstein
 *
 ***************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class OneSimpleAttractor {
    public static void main(String[] args) {
        // particule properties
        double posx = 0.0, posy = 0.0;      // position
        double velx = 0.0, vely = 0.0;      // velocity
        double mass = 1.0;                  // mass
        double dt = 0.5;                    // time-quantum
        double drag = 0.1;                  // mess around with this a bit
        double attractionStrength = 0.01;

        // do the animation
        StdDraw.enableDoubleBuffering();
        while (true) {
            
            // compute the attractive force for the mouse, accounting for drag
            double diffx = StdDraw.mouseX() - posx;
            double diffy = StdDraw.mouseY() - posy;
            double forcex = (diffx * attractionStrength) - (drag * velx);
            double forcey = (diffy * attractionStrength) - (drag * vely);

            // Euler step: update the velocity, then position 
            velx += forcex * dt / mass;
            vely += forcey * dt / mass;
            posx += velx * dt;
            posy += vely * dt;

            // draw  particule 
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(posx, posy, 0.02);
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
    
}
