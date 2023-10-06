package week4.io.booksite;
/* *****************************************************************************
 *  Compilation:  javac Springs.java
 *  Execution:    java Springs N
 *  Dependencies: StdDraw.java
 *
 *  Simulates a system of springs.
 *
 *  % java Springs 15
 *
 *  Credits:  Jeff Traer-Bernstein
 *
 ***************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class Springs {
    public static void main(String[] args) {
        // mess around with this, try 7, 8, 9, 10, 11, 12, 15
        // probably have to turn down the spring force to keep it stable after that
        int n = Integer.parseInt(args[0]);
        
        double[] posx = new double[n];
        double[] posy = new double[n];
        double[] velx = new double[n];
        double[] vely = new double[n];
        double particleMass = 1.0;
        double drag = 0.1;
        double springStrength = 0.1;
        double springRelaxedLength = 30;
        double gravity = 1.0;
        double timeStep = 0.5;

        // set up the drawing area
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.0025);
        StdDraw.enableDoubleBuffering();

        // initialize the particle positions randomly
        for (int i = 0; i < n; i++) {
            posx[i] = 100 * Math.random();
            posy[i] = 100 * Math.random();
        }

        // do the animation
        while (true) {
            
            // clear all the forces
            double[] particleFx = new double[n];
            double[] particleFy = new double[n];

            // spring force act between every pairing of particles
            // spring force is proportional to the difference between the rest lenght of the spring
            // and the distance between the 2 particles it is acting on 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    
                    if (i == j) continue;
                    
                    // calculate distance between i and j
                    double distx = posx[j] - posx[i];
                    double disty = posy[j] - posy[i];
                    double lengthBetweenParticles = Math.sqrt(distx*distx + disty*disty);

                    // figure out the force 
                    double force = springStrength * (lengthBetweenParticles - springRelaxedLength);
                    double springForceX = force * distx / lengthBetweenParticles;
                    double springForceY = force * disty / lengthBetweenParticles;

                    // update the force
                    particleFx[i] += springForceX;
                    particleFy[i] += springForceY;
                }
            }

            // add drag force
            // drag is proportional to the velocity but in the opposite direction 
            for (int i = 0; i < n; i++) {
                particleFx[i] += -drag * velx[i];
                particleFy[i] += -drag * vely[i];
            }

            // add gravity forces
            // just add some force pointing down on all of them
            for (int i = 0; i < n; i++) {
                particleFy[i] += -gravity;
            }

            // fix particle 1 at the mouse position
            posx[0] = StdDraw.mouseX();
            posy[0] = StdDraw.mouseY();
            velx[0] = 0.0;
            vely[0] = 0.0;
            particleFx[0] = 0.0;
            particleFy[0] = 0.0;

            // update positions using approximation
            for (int i = 0; i < n; i++) {
                velx[i] += particleFx[i] * timeStep / particleMass;
                vely[i] += particleFy[i] * timeStep / particleMass;
                posx[i] += velx[i] * timeStep;
                posy[i] += vely[i] * timeStep;
            }

            // clear
            StdDraw.clear();

            // draw everything
            for (int i = 0; i < n; i++) {
                // draw a circle for each node
                StdDraw.filledCircle(posx[i], posy[i], 1.0);

                // draw a connection between every two nodes
                for (int j = 0; j < i; j++) {
                    StdDraw.line(posx[i], posy[i], posx[j], posy[j]);
                }
            }

            // show and wait
            StdDraw.show();
            StdDraw.pause(10);
            
        }

    }
}
