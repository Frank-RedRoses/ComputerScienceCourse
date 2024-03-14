package case_study.oop.nbody_simulation;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Vector;

/** **************************************************************
 * This data type provides the operations that we need to simulate
 * the motion of physical bodies such as planets or atomic particles.
 * It is a mutable type whose instance variables are the position and
 * velocity of the body, which change in the move() method in response
 * to external forces (the body's mass is not mutable). The forceFrom()
 * method returns a force vector.
 ****************************************************************/
public class Body {
    private Vector position;
    private Vector velocity;
    private final double mass;

    /**
     * Body constructor
     * @param r0 position
     * @param v0 velocity
     * @param m0 mass
     */
    public Body(Vector r0, Vector v0, double m0) {
        position = r0;
        velocity = v0;
        mass = m0;
    }

    /**
     * Change the state of the body according to the given external force 
     * applied by dtime.
     * 
     * @param force force of this body
     * @param dtime time decrement
     */
    public void move (Vector force, double dtime) {
        // Update position and velocity.
        Vector acceleration = force.scale(1/mass); // a = F/m --> F = m*a.
        velocity = velocity.plus(acceleration.scale(dtime));
        position = position.plus(velocity.scale(dtime));
    }

    /**
     * Returs the force vector created by the action of that body 
     * on this body.
     * 
     * deltaDist = distance vector from b to a.
     * dist = distance vector's magnitude from b to a.
     * @param that another body.
     * @return the force vector acting on this body.
     */
    public Vector forceFrom(Body that) {
        // Compute force on this body from b.
        Body currentBody = this;
        double G = 6.67e-11;    // Gravitational constant 
        Vector deltaDist = that.position.minus(currentBody.position);
        double dist = deltaDist.magnitude();
        //Newton’s law of universal gravitation
        double forceMagnitude = (G * currentBody.mass * that.mass) 
                            / (dist * dist);
        Vector force = deltaDist.direction().scale(forceMagnitude);
        return force;
    }

    
    public void draw() {
        StdDraw.setPenRadius(0.0125);
        StdDraw.point(position.cartesian(0), position.cartesian(1));
    }
}
