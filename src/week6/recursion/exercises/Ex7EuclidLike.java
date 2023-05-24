package week6.recursion.exercises;

import edu.princeton.cs.algs4.StdOut;

/* 
 * Explain in terms of integers and divisors the effect of the following Euclid
 * like function:
 */
/* Answer:
 * Return if p and q are relatively prime numbers.
 * (Two numbers are Relatively prime numbers when there is no integer 
 * greater than 1 that divides them both, that means their gcd is equal to 1).
 */

public class Ex7EuclidLike {

    public static boolean gcdlike(int p, int q) {
        // Base case: return true only when p % q == 1 in the previous recursive call to p % q = 0 
        if (q == 0) return (p == 1);
        // Reduction step: p % q is always lower than q
        return gcdlike(q, p % q);
    }

    public static void main(String[] args) {
        int p = 19;
        int q = 7;
        StdOut.println(gcdlike(p, q));
    }


    
}
