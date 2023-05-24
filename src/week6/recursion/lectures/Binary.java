package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;
/* ***********************************************
 * Converts an integer into binary using the mod 2 of the number to get a bit (0 or 1)
 * and dividing the number by two to get the next bit.
 * 
 * The binary number obtained is in inverse order, but by using recursion we can go from top N value
 * to bottom dividing the numbers by 2 and using a String to add the bit numbers starting at
 * the N/2 = 1 division, so the order of the binary digits can be inverted to the proper one. 
 * 
 */
public class Binary {
    
    public static String convert(int N) {
        // Base case
        if (N == 1) return "1";         // return the last bit as it was the first when forming the String.
        // Reduction step:
        return convert(N/2) + (N % 2);  // int 0 or 1 automatically converted to String "0" or "1".
    }   

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(convert(N));
    }
}