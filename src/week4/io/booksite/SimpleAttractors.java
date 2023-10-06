package week4.io.booksite;
/* *****************************************************************************
 *  Compilation:  javac SimpleAttractors.java
 *  Execution:    java SimpleAttractors n
 *  Dependencies: StdDraw.java
 *
 *  n particles are attracted to the mouse; randomly rearrange when
 *  user clicks.
 *
 *  % java SimpleAttractors 20
 *
 *  Credits:  Jeff Traer-Bernstein
 *
 ***************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class SimpleAttractors {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] posx = new double[n];
        double[] posy = new double[n];
        double[] velx = new double[n];
        double[] vely = new double[n];
        double dt = 0.5;
        double mass = 1.0;
        double drag = 0.05;     // try changing this to 0.1 or 0.01 or even 0...
        double attactionStrength = 0.01;

        // initialize the drawing area
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-1, +1);

        // do the animation
        while (true) {
            // if the mouse is pressed add some random velocity to all particles
            if (StdDraw.isMousePressed()) {
                for (int i = 0; i < n; i++) {
                    velx[i] = 0.2 * Math.random() - 0.1;
                    vely[i] = 0.2 * Math.random() - 0.1;
                }
            }

            // clear all forces 
            double[] fx = new double[n];
            double[] fy = new double[n];

            // add attraction forces for attraction to the mouse
            for (int i = 0; i < n; i++) {
                double distx = StdDraw.mouseX() - posx[i];
                double disty = StdDraw.mouseY() - posy[i];
                fx[i] += attactionStrength * distx;
                fy[i] += attactionStrength * disty;
            }

            // add drag forces to all particles
            // drag is proportional to velocity in the opposite direction
            for (int i = 0; i < n; i++) {
                fx[i] += -drag * velx[i]; 
                fy[i] += -drag * vely[i]; 
            }

            // update positions
            // Euler step
            for (int i = 0; i < n; i++) {
                velx[i] += fx[i] * dt / mass; 
                vely[i] += fy[i] * dt / mass;
                posx[i] += velx[i] * dt; 
                posy[i] += vely[i] * dt; 
            }

            StdDraw.clear();

            // draw a filles circle for each particle
            for (int i = 0; i < n; i++) {
                StdDraw.filledCircle(posx[i], posy[i], 0.01);
            }

            StdDraw.show();
            StdDraw.pause(10);

        }


    }
    
}
