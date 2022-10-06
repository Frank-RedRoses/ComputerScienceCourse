package week1.builtindatatype.creativeexercises;
/*
 * Polar coordinates. Write a program CartesianToPolar.java that converts 
 * from Cartesian to polar coordinates. Your program should take two real 
 * numbers x and y on the command line and print the polar coordinates r 
 * and θ. Use the Java method Math.atan2(y, x), which computes the arctangent
 *  value of y/x that is in the range from -π to π.
 * 
 * To convert from cartesian (x, y) to polar (r, theta):
 * r^2 = x^2 + y^2
 * theta = arctan(y/x)
 * 
 */

 /**************************************************************************
  * Read in Cartesian coordinates (x, y) and print out polar coordinates
 *  (r, theta).
 *
 *  %  java CartesianToPolar 3.0 4.0
 *  r     = 5.0
 *  theta = 0.9272952180016122
 * 
  **************************************************************************/

public class CartesianToPolar {

    public static void main(String[] args) {
        double coorX = Double.parseDouble(args[0]);
        double coorY = Double.parseDouble(args[1]);

        double radio = Math.sqrt(coorX*coorX + coorY*coorY);
        double theta = Math.atan2(coorY, coorX);

        System.out.println("Polar coordinates from (" + coorX + ", " + coorY + "):");
        System.out.println("r     = " + radio);
        System.out.println("theta = " + theta);
    }
    
}
