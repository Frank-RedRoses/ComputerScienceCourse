package week6.recursion.exercises;
/* Ex. 2.3.8.
 * Consider the following recursive function:
 */

import edu.princeton.cs.algs4.StdOut;

public class Ex8MysteryRecursion {

    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b/2);
        return mystery(a + a, b/2) + a;
    } 
    /* What are the values of mystery(2, 25) and mystery(3, 11)? 
     * Given positive integers a and b, describe what value 
     * mystery(a, b) computes. 
     * 
     * Answer the same question, but replace + with *.
     * 
     */

    public static int mysteryMultiplition(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a * a, b/2);
        return mystery(a * a, b/2) * a;
    } 
    public static void main(String[] args) {
        int a = 2, b = 4;
        StdOut.println("a = " + a + " and b = " + b + " gives mystery equals to: " + mystery(a, b));
        StdOut.println("a = " + a + " and b = " + b + " gives mysteryMult equals to: " + mysteryMultiplition(a, b));
        a = 3; 
        b = 3;
        StdOut.println("a = " + a + " and b = " + b + " gives mystery equals to: " + mystery(a, b));
        StdOut.println("a = " + a + " and b = " + b + " gives mysteryMult equals to: " + mysteryMultiplition(a, b));
        /* Answer:
         * mystery(2, 25) = 50 
         * mystery(3, 11) = 33
         * mystery(a, b) computes the multiplication between a and b.
         * 1) Computes the binary representation of "b".
         * 2) Computes the power of "a", increasing the value of "a" as much as 
         * digits have the binary of "b".
         * 3) Uses the binary representation of "b" together with the power of "a" to compute
         * the multiplication between both numbers.
         * 4) Everytime a 1 is present in the binary of b add the corresponding value of 
         * power of "a". This is like calculating the value of b from binary, but making the 
         * value "a" correspond to the first digit and the powers of "a" 
         * to the following digits of the binary number.
         * 
         * If + is replace with *. 
         * Makes 2 computations:
         * 1) For even values of b, mystery(a, b) gives the multiples of a^2.
         * 2) For odd values of b, mystery(a, b) gives the multiples of a^3.
         */
     }
}
