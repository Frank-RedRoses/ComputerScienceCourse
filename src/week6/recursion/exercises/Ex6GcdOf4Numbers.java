package week6.recursion.exercises;

/* *******************************************************************************
 * 2.3.6 Given four positive integers a, b, c and d explain what value is computed
 * by gcd(gcd(a, b), gcd(c, d)).
 * 
 ******************************************************************************* */

 /* Answer:
  * Computes the gcd of 4 numbers: a, b, c and d.
  */

public class Ex6GcdOf4Numbers {

    public static int gcd(int p, int q) {
        // Base case: returns the last p % q operation before p % q == 0.
        if (q == 0) return p;
        // Reduction step: gcd with Euclid's algorithm
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        int a = 250;
        int b = 150;
        int c = 355; 
        int d = 550;

        System.out.println(
            "The gcd of " + a + ", " + b +  ", " + c +  " and " + d + " is: " 
            + gcd(gcd(a, b), gcd(c, d))
        );
        
    }
    
}
