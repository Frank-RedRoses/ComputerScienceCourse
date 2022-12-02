package week2.conditionalandloops.exercises;

/*
 * 1.3.21 Write a program Kary that takes two integer command line
 * arguments i and k and converts i to base k. Assume that i is an
 * integer in Java’s long data type and that k is an integer between
 * 2 and 16. For bases greater than 10, use the letters A through F 
 * to represent the 11th through 16th digits, respectively.
 */

/**
 * Prints out n in knary.
 *
 *  % java Kary 5 2
 *  101
 */
public class MyKary {
    public static void main(String[] args) {
        // read in the command-line argument
        int num = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.print("Kary base " + k + " of " + num + " is: ");
        
        // Save the base k number
        String kary = "";
        // Computes the mod of k and adds the base k digit to kary.
        // (The string kary have to be built in reverse order) 
        while(num > 0) {
            int modK = num % k;
            // For modK > 9 we use letters A through F. 
            switch (modK) {
                case 10:
                kary = "A" + kary;
                break;
                case 11:
                kary = "B" + kary;
                break;
                case 12:
                kary = "C" + kary;
                break;
                case 13:
                kary = "D" + kary;
                break;
                case 14:
                kary = "E" + kary;
                break;
                case 15:
                kary = "F" + kary;
                break;
                default:
                kary = modK + kary;     // Else use the value modK
                break;
            }
            // Divide by k to find the next base k digit
            num /= k; 
        }
        // Prints out the result
        if (kary.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(kary);
        }
    }
    
}
