package week2.conditionalandloops.webexercises;
/**********************************************************************************************
 * Given two positive integers a and b, what result does the following code fragment leave in c.
 * 
 * c = 0;
 * while (b > 0) {
 *  if (b % 2 == 1) c = c + a;
 *  b = b / 2;
 *  a = a + a;
 * }
 * 
 * Solution: c = a*b
 * 
 * It uses the power of 2 to calculate "a" times "b".
 * Calculates the inverse binary representation (read from right to left) of "b" to know 
 * when to add values of "a" to the sum "c".
 * Every time a binary's 1 is calculated add the current value of "a" to "c".
 * Multiply "a" by 2 (a=a+a) for every calculated binary digit. 
 * Example: 
 * a = 1;
 * b = 53; Binary = 110101 (Inverse binary = 101011)
 * c = 1*53 = 53;
 * The computation is c=0+1+4+16+32=53.
 * 53mod2 = 1 -> Add "a" to "c". Multiply "a" by 2. Divide b / 2.  c=1, a=2, b=26.   
 * 26mod2 = 0 -> Multiply "a" by 2. Divide b / 2.                  a=4, b=13.        
 * 13mod2 = 1 -> Add "a" to "c". Multiply "a" by 2. Divide b / 2.  c=5, a=8, b=6. 
 * 6mod2  = 0 -> Multiply "a" by 2. Divide b / 2.                  a=16, b=3.
 * 3mod2  = 1 -> Add "a" to "c". Multiply "a" by 2. Divide b / 2.  c=21, a=32, b=1.
 * 1mod2  = 1 -> Add "a" to "c". Multiply "a" by 2. Divide b / 2.  c=53, a=64, b=0.
 * Ends at b < 1;
 * 
 * Works for any value of a.
 * a = 7;
 * b = 53; (Inverse binary = 101011)
 * c = 7*53 = 371;
 * Computation is c=0+7+28+112+224=371
 *********************************************************************************************/

public class WhatIsTheResult {

    public static void main(String[] args) {
        // int n = 0; //  for debugging
        int a = 7;
        int b = 53;

        int c = 0;
        //for debugging
        /* 
        System.out.println("b = " + Integer.toBinaryString(b));
        System.out.printf("n  | %-6s | %-6s | %-6s |%n", "a", "b", "c");
        System.out.printf("%-2d | %-6d | %-6d | %-6d |%n", n, a, b, c);
        */
        while (b > 0) {     
            if (b % 2 == 1) c = c + a;
            b = b / 2;
            a = a + a; // a * 2;
            // for debugging
            /* 
            n++;
            System.out.printf("%-2d | %-6d | %-6d | %-6d |%n", n, a, b, c);
            */
        }
        System.out.println("c= " + c);

       
    }    
}
