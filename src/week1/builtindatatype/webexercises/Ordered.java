package week1.builtindatatype.webexercises;
/*
 * Write a program Ordered.java that reads in three integer command line arguments,
 *  x, y, and z. Create a boolean variable b that is true if the three values are 
 * either in ascending or in descending order, and false otherwise. 
 * 
 * Print the variable b.
 */

public class Ordered {
    public static void main(String[] args) {
        int valueX = Integer.parseInt(args[0]);
        int valueY = Integer.parseInt(args[1]);
        int valueZ = Integer.parseInt(args[2]);
        boolean b = (valueX > valueY && valueY > valueZ) || (valueX < valueY && valueY < valueZ);

        System.out.println(b);
    }
    
}
