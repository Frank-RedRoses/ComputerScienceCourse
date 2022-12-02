package week2.conditionalandloops.exercises;
/*
 * Modify Binary.java to get a program Modify Kary.java that takes a 
 * second command-line argument K and converts the first argument to 
 * base K. Assume the base is between 2 and 16. For bases greater than 
 * 10, use the letters A through F to represent the digits 10 through 
 * 15, respectively.
 */

public class Kary {
    public static void main(String args[]) {
        // read in the command-line argument
        int n = Integer.parseInt(args[0]);
        // int k = Integer.parseInt(args[1]);
        int k = 16;

        // set power to the largest power of k that is <= n
        int powerOfK = 1;
        while (powerOfK <= n/k) { // iterate until power of k > n/k
            powerOfK *= k;
        }

        // check for the presence of powers of k in n, from largest to smallest
        while (powerOfK > 0) {
            
            // the power of k iteration is not present in n
            if (n < powerOfK) {
                System.out.print(0);
            }
            // else the power of k is present in n, substract the power of k  
            else {
                // Get the digit for the kary number
                int digit = n/powerOfK;
                // Print letters for digits greater than 9
                switch (digit) {
                    case 10: System.out.print("A");
                    break;
                    case 11: System.out.print("B");
                    break;
                    case 12: System.out.print("C");
                    break;
                    case 13: System.out.print("D");
                    break;
                    case 14: System.out.print("E");
                    break;
                    case 15: System.out.print("F");
                    break;
                    default:System.out.print(digit);
                    break;
                }
                /* 
                if (digit == 10) System.out.print("A");
                else if (digit == 11) System.out.print("B");
                else if (digit == 12) System.out.print("C");
                else if (digit == 13) System.out.print("D");
                else if (digit == 14) System.out.print("E");
                else if (digit == 15) System.out.print("F");
                else System.out.print(digit);
                */
                // substract the powerOfK times the digit value
                n -= digit*powerOfK;
            }
            // next iteration, smallest power of k
            powerOfK /= k;
        }
        System.out.println();
    }
}
