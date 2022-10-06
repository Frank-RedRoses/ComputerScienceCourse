package week1.builtindatatype.webexercises;
/*
 * Write a program that takes four real-valued command line parameters x1, y1, x2, and y2 
 * and prints the Euclidean distance between the points (x1, y1) and (x2, y2). Use Math.sqrt().
 */

public class EuclideanDistance {

    public static void main(String[] args) {
        int xInitial = Integer.parseInt(args[0]);
        int yInitial = Integer.parseInt(args[1]);
        int xFinal = Integer.parseInt(args[2]);
        int yFinal = Integer.parseInt(args[3]);

        int xDiff = (xFinal - xInitial);
        int yDiff = (yFinal - yInitial);


        double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

        System.out.println(distance);
    }
    
}
