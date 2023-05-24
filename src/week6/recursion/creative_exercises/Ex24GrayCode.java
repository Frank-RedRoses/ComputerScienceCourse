package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* 2.3.24. Gray code.
 * Modify Beckett.java to print the Gray code (not just the sequence of bit positions that change).
 * 
 * % java Ex24GrayCode 3
 *  000
 *  001
 *  011
 *  010
 *  110
 *  111
 *  101
 *  100
 */
public class Ex24GrayCode {

    // String representation of the binary
    private static String binary;

    public static void myGrayCode(int n) {
        // Initialize the binary String bitcode with the n value
        binary = "";
        for (int i = 0; i < n; i++) {
            binary = binary + "0";
        }
        // print the "empty" representation of binary.
        StdOut.println(binary);
        // start to switch bits in binary.
        switchBit(n, true);
        StdOut.println();
    }

    // This is a simple modification of Beckett.java to change the char value 
    // corresponding to the bit that is need to be changed.
    public static void switchBit(int n, boolean forward) {
        // Base case: no more bits to change
        if (n == 0)  return;

        // Reduction step: go to the next lower level bit
        // in the next recursion level, one bit will to change to 1.
        switchBit(n-1, true);   
        // Print the binary sequence with one bit changed.
        int position = binary.length() - n;
        if (forward) {
            binary = binary.substring(0, position) + "1" +  binary.substring(position + 1, binary.length());
            StdOut.println(binary);
        } else  {
            binary = binary.substring(0, position) + "0" + binary.substring(position + 1, binary.length());
            StdOut.println(binary);
        }
        // in the next recursion level, one bit will to change to 0
        switchBit(n-1, false);                                      
    }

    /* The gray code from the booksite:
     * The idea is that the first level of recursion will execute the gray order 
     * and then it reverse the order of the bits for the part of the code that 
     * starts with the opposite bit.
     * gray() will add bit to the prefix in order first 0 and then 1 on nth level.
     * yarg() will add bit to the prefix in order first 1 and then 0 on nth level.
     * The difference between the two methods is how the bits are added to the prefix.
     */
    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        // Base case:
        if (n == 0) {
            StdOut.println(prefix);
        } else {
            // Reduction step: Add one bit and go lower in the recursion level
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
    }

    // append reverse of order n gray code to prefix string, and print
    public static void yarg(String prefix, int n) {
        // Base case:
        if (n == 0) {
            StdOut.println(prefix);
        } else {
            // Reduction step: Add one bit in inverse order and go lower in the recursion level
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1); 
        }
    }

    /* The gray code with array from the booksite:
     * Again, the idea is that the first level of recursion will execute the gray order 
     * and then it reverse the order of the bits for the part of the code that starts
     * with the opposite bit.
     * grayWithArray() will assign the value to bits[n] in the order first 0, it will use that value, and then assign the value 1.
     * yargWithArray() will assign the value to bits[n] in the order first 1, it will use that value, and then assign the value 0.
     * The difference between the two methods is the order of how the bits are used in the array.
     * Notes: 
     * To be able to use bits[n] the array needs [n + 1] entries.
     * The array starts at the higher value of n, so the code is store from bits[n] to bits[0]
     * this means that the array needs to be printed from i = bits.length - 1 to i = 0.
     */
    public static void grayWithArray(int n, boolean[] bits) {
        // Base case:
        if (n == 0) {
            showBits(bits);
        } else {
            // Reduction step:
            bits[n] = false;    // first set the value to 0 and make the recursion call
            grayWithArray(n - 1, bits);
            bits[n] = true;     // then, set the value to 1 and make the second recursion call for the inverse order.
            yargWithArray(n - 1, bits);
        }
    }

    public static void yargWithArray(int n, boolean[] bits) {
        // Base case:
        if (n == 0) {
            showBits(bits);
        } else {
            // Reduction step:
            bits[n] = true;     // first set the value to 1 and make the recursion call for the proper order
            grayWithArray(n - 1, bits);
            bits[n] = false;    // then, set the value to 0 and make the second recursion call for the inverse order.
            yargWithArray(n - 1, bits);
        }
    }

    private static void showBits(boolean[] bits) {
        // The array starts at the higher value of n, so the code is store from bits[n] to bits[0]
        // this means that the array needs to be printed from i = bits.length - 1 to i = 1;
        for (int i = bits.length - 1; i > 0; i--) {
            if (bits[i]) StdOut.print(1);
            else StdOut.print(0);
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        int n = 3;
        myGrayCode(n);

        gray("", n);
        StdOut.println();

        boolean[] bits = new boolean[n + 1]; // to be able to use bits[n] the array needs [n + 1] entries.
        grayWithArray(n, bits);

    }
    
}
