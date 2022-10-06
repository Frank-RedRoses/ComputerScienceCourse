package week1.builtindatatype.webexercises;

/*
 * Write a program Divisibility.java that reads in two command line inputs 
 * and prints true if both are divisible by 7, and false otherwise.
 */
public class Divisibility {
    public static void main(String[] args) {
        int val0 = Integer.parseInt(args[0]);
        int val1 = Integer.parseInt(args[1]);

        boolean isDivisibleBy7 = val0 % 7 == 0 && val1 % 7 == 0;

        System.out.println(isDivisibleBy7);
    }
    
}
