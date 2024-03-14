package case_study.oop.nbody_simulation;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Vector;

/*
 * This data-driven program simulates motion in the universe defined 
 * by a file specified as the first command-line argument, increasing
 * time at the rate specified as the second commandline argument. See
 * the accompanying text for the implementation of the constructor.
 */
public class Universe {
    private final int n;            // number of bodies
    private final Body[] bodies;    // array of bodies

    public Universe(String filename) {
        In in = new In(filename);
        n = in.readInt();
        double radius = in.readDouble();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        bodies = new Body[n];
        for (int i = 0; i < n; i++) {
            double rx = in.readDouble();
            double ry = in.readDouble();
            double[] position = { rx, ry };
            double vx = in.readDouble();
            double vy = in.readDouble();
            double[] velocity = { vx, vy };
            double mass = in.readDouble();
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            bodies[i] = new Body(r, v, mass);
        }
    }

    /**
     * Calculates the forces for each body and uses that information
     * to update the acceleration, velocity, and position of each body
     * after a time interval dt.
     * 
     * @param dt time interval
     */
    public void increaseTime(double dt) {
        Vector[] forces = new Vector[n];
        // creates the force acting on each ith body
        for (int i = 0; i < n; i++) 
            forces[i] = new Vector(new double[2]);  // (fx, fy) vector
        // computes the force acting on the ith body from the other n-1 bodies
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if (i != j)
                    forces[i] =  forces[i].plus(bodies[i].forceFrom(bodies[j]));
        // updates the velocity and position of each body
        for (int i = 0; i < n; i++) 
            bodies[i].move(forces[i], dt);
    }

    public void draw() {
        for (int i = 0; i < n; i++) 
            bodies[i].draw();
    }

    /**
     * The main() test client invokes the constructor, then stays 
     * in a loop calling increaseTime() and draw() to simulate motion.
     */
    public static void main(String[] args) {
        Universe newton = new Universe(args[0]);
        double dt = Double.parseDouble(args[1]);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.GRAY);
        while (true) {
            StdDraw.setPenColor(StdDraw.BLACK);
            newton.increaseTime(dt);
            newton.draw();
            StdDraw.show();
            StdDraw.setPenColor(StdDraw.WHITE);
            newton.draw();
            StdDraw.pause(20);
        }
    }
}
