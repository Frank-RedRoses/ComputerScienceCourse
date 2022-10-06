package week1.builtindatatype.webexercises;

/*
 * Write a program Swap.java that takes two integer command-line arguments
 * "a" and "b" and swaps their values using the swapping idiom described on p. 17. 
 * After each assignment statement, use System.out.println() to print a trace of the variables.
 */

public class Swap {
    

    public static void main(String[] args) {
        int integerA = Integer.parseInt(args[0]);
        int integerB = Integer.parseInt(args[1]);
        int temp =  0;
        
        System.out.println("a = " + integerA + ", b = " + integerB + ", t = " + temp);
        
        temp = integerA;
        System.out.println("a = " + integerA + ", b = " + integerB + ", t = " + temp);
        
        integerA = integerB;
        System.out.println("a = " + integerA + ", b = " + integerB + ", t = " + temp);
        
        integerB = temp;
        System.out.println("a = " + integerA + ", b = " + integerB + ", t = " + temp);
    }
}