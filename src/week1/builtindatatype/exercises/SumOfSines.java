package week1.builtindatatype.exercises;

/*
 * Write a program SumOfSines.java that takes a double command-line argument t
 * (in degrees) and prints the value of sin(2t) + sin(3t).
 * 
 * Read in an angle t (in degrees) and print sin(2t) + sin(3t).
 *
 *  % java SumOfSines 30
 *  1.8660254037844386
 */

public class SumOfSines {

    public static void main(String[] args) {
        double tDegrees = Double.parseDouble(args[0]);
        double tRads = Math.toRadians(tDegrees);
        double sum = Math.sin(2.0*tRads) + Math.sin(3.0*tRads);

        System.out.println("The sum of sin(2t) + sin(3t) = " + sum);
    }
    
}
