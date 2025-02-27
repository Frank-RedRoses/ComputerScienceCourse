package week2.conditionalandloops.exercises;
/*
 * Rewrite TenHellos.java to make a program Hellos.java that takes the number
 * of lines to print as a command-line argument. You may assume that the argument
 * is less than 1000. Hint: consider using i % 10 and i % 100 to determine 
 * whether to use "st", "nd", "rd", or "th" for printing the ith Hello.
 */

public class Hellos {
    public static void main(String[] args) {
        int linesToPrint = Integer.parseInt(args[0]); 
        for (int i = 1; i <= linesToPrint; i++) {
            // print the line number
            System.out.print(i);    
            // add ordinal number suffix 
            if (i != 11 && i % 10 == 1)         System.out.print("st");
            else if (i != 12 && i % 10 == 2)    System.out.print("nd");
            else if (i != 13 && i % 10 == 3)    System.out.print("rd");
            else                                System.out.print("th");
            // print Hello and end of line
            System.out.println(" Hello");
        }
    }
}
