package week2.conditionalandloops.webexercises;
/******************************************************************
 * Write a program that takes three integer command-line arguments 
 * a, b, and c and print the number of distinct values (1, 2, or 3) 
 * among a, b, and c.
 ******************************************************************/
public class DistinctValues {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int distinctValues; 
        if (a == b) {
            if (a == c) distinctValues = 1;
            else distinctValues = 2;
        } else if (c == a) {
            distinctValues = 2;
        } else if (c == b) {
            distinctValues = 2;
        } else {
            distinctValues = 3;
        }


        System.out.println("Distinct Values: " + distinctValues);
    }
    
}
