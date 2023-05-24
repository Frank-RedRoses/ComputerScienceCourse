package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * 2.3.15 Binary representation. 
 * Write a program that takes a positive integer N (in decimal) from the command 
 * line and prints out its binary representation. Recall, in Program 1.3.7,that 
 * we used the method of subtracting out powersof 2. Instead, usethe following 
 * simpler method: repeatedly divide 2 into N and read the remainders backwards. 
 * First, write a while loop to carry out this computation and print the bits in
 * the wrong order. Then, use recursion to print the bits in the correct order.
 */

public class Ex15BinaryRepresentation {

    // reverse the order of the characters in a given String using recursion.
    private static String reverseString(String s) {
        if (s.length() == 0) return "";
        else return reverseString(s.substring(1)) + s.charAt(0);
    }

    // Take a decimal number and returns the String binary of that number.
    public static String binary(int decimalN) {
        String inverseBinary = "";
        // loop that gives the inverse binary representation of a decimal number by
        // dividing the number by 2 and taking the remainders.
        while(decimalN > 0) {
            inverseBinary += decimalN % 2 + "";
            decimalN /= 2;
        }
        // for debug
        StdOut.println("Inverted Binary = " + inverseBinary);
        // recursively invert the computed String representing the binary in wrong order 
        // and returns the right order.
        return reverseString(inverseBinary);
    }

    // One-way method, method from the course.
    public static void convert(int n) {
        if (n == 0) return;     // base case
        convert(n / 2);         // reduction step to go deep and reach the lowest n possible
        StdOut.print(n % 2);    // this line is executed botton-up from the lower values to the large ones
    }

    public static void main(String[] args) {
        // int N =  Integer.parseInt(args[0]);
        int N =  8;
        StdOut.println("My binary of " + N  + " = " + binary(N));
        StdOut.print("Short method way = ");
        convert(N);
        StdOut.println();

    }
    
}
