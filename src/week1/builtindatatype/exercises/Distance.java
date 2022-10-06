package week1.builtindatatype.exercises;

/*
 * Write a program Distance.java that takes two integer command-line arguments x and y 
 * and prints the Euclidean distance from the point (x, y) to the origin (0, 0).
 * 
 * Euclidean distance is the length of a line segment between the two points.
 *  Formula: (x1, y1) (x2, y2)
 *  d(p,q)^2 = (x2 - x1)^2 + (y2 - y1)^2
 *  % java Distance 3 4
 *  distance from (3, 4) to (0, 0) = 5.0
 *
 *  % java Distance 5 12
 *  distance from (5, 12) to (0, 0) = 13.0
 */
public class Distance {

    public static void main(String[] args) {

        // parse x and y coordinates from command-line arguments 
        int coordX = Integer.parseInt(args[0]);
        int coordY = Integer.parseInt(args[1]);

        // compute distance to (0, 0)
        double distance = Math.sqrt(coordX*coordX + coordY*coordY);

        // output the distance
        System.out.println("distance from (" + coordX + ", " + coordY + ") to (0, 0) = " + distance);



    }
    
}
