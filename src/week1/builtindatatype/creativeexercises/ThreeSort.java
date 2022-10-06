package week1.builtindatatype.creativeexercises;

/*
 * Three-sort. Write a program ThreeSort.java that takes three int values
 * from the command line and prints them in ascending order. Use Math.min()
 * and Math.max().
 */

 /**
  * Read 3 integer values from the command line and print them
 *  in ascending order.
 *
 *  % java ThreeSort 17 50 33
 *  17
 *  33
 *  50
 *
 *  % java ThreeSort 50 33 17
 *  17
 *  33
 *  50
 *
 *  % java ThreeSort 17 50 17
 *  17
 *  17
 *  50
  */
public class ThreeSort {

    public static void main(String[] args) {
        int value0 = Integer.parseInt(args[0]);
        int value1 = Integer.parseInt(args[1]);
        int value2 = Integer.parseInt(args[2]);

        int min = Math.min(value0, Math.min(value1, value2));
        int max = Math.max(value0, Math.max(value1, value2));
        int middle = value0 + value1 + value2 - min - max;

        System.out.println("min    = " + min);
        System.out.println("middle = " + middle);
        System.out.println("max    = " + max);

    }
    
}
