package week2.conditionalandloops.exercises;

/******************************************************************************
 *  Compilation:  javac Binary.java
 *  Execution:    java Binary n
 *
 *  Prints out n in binary.
 *
 *  % java Binary 5
 *  101
 *
 *  % java Binary 106
 *  1101010
 *
 *  % java Binary 0
 *  0
 *
 *  % java Binary 16
 *  10000
 *
 *  Limitations
 *  -----------
 *  Does not handle negative integers.
 *
 *  Remarks
 *  -------
 *  could use Integer.toBinaryString(N) instead.
 *
 ******************************************************************************/

public class binary {
    public static void main(String args[]) {
        // read in the command-line argument
        int n = Integer.parseInt(args[0]);

        // set power  to the largest power of 2 that is <= n
        int powerOf2 = 1;
        while (powerOf2 <= n/2) {
            powerOf2 *=2;
        }

        // check for the presence of powers of two in n, from largest to smallest
        while (powerOf2 > 0) {
            
            // if this power of 2 iteration is not present in n
            if (n < powerOf2) {
                System.out.print(0);
            }
            // else the power of two is present in n, substract the power of two  
            else {
                System.out.print(1);
                n -= powerOf2;
            }
            // next iteration, smallest power of 2
            powerOf2 /=2;
        }
        System.out.println();
    }
}
