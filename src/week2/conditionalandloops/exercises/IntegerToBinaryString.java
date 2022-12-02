package week2.conditionalandloops.exercises;
/*
 * Write a program code fragment that puts the binary representation 
 * of a positive integer n into a String variable s.
 */

 /******************************************************************************
 *  Compilation:  javac IntegerToBinaryString.java
 *  Execution:    java IntegerToBinaryString n
 *
 *  Prints out n in binary.
 *
 *  % java IntegerToBinaryString 5
 *  101
 *
 *  % java IntegerToBinaryString 106
 *  1101010
 *
 *  % java IntegerToBinaryString 0
 *  0
 *
 *  % java IntegerToBinaryString 16
 *  10000
 *
 *  Limitations
 *  -----------
 *  Does not handle negative integers or 0.
 *
 *  Remarks
 *  -------
 *  could use Integer.toBinaryString(n) instead.
 *
 ******************************************************************************/
public class IntegerToBinaryString {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        String s = "";
        if (n == 0) {
            s = "0";
        } else {
            // find n mod of 2 and put the result in front of the String s (reverse order)
            for (int i = n; i > 0; i /= 2) { // divide n by 2 for the next iteration until n = 0
                s = (i % 2) + s;
            }
        }
        // Output
        System.out.println("binary of " + n + " = " + s);
    }
    
}
