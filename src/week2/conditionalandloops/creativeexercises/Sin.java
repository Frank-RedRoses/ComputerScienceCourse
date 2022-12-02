package week2.conditionalandloops.creativeexercises;

/*********************************************************************
 * Trigonometric functions. Write two programs Sin.java and Cos.java 
 * that compute sin x and cos x using the Taylor series expansions
 * 
 * sinx = x − x^3/3! + x^5/5! − x^7/7! + ... 
 * cosx = 1 − x^2/2! + x^4/4! − x^6/6! + ...
 * 
 **********************************************************************/

/******************************************************************************
 *  Compilation:  javac Sin.java
 *  Execution:    java Sin x
 *
 *  Prints out sin(x) using Taylor expansion.
 *
 *     sin x = x - x^3/3! + x^5/5! - x^7/7! + ...
 *
 *  % java sin  java Sin 0.523598775598299
 *  0.5000000000000002
 *
 *
 ******************************************************************************/
public class Sin {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double sum = 0.0;
        double term = x;

        for (int i = 3; sum != sum + term; i += 2) {
            sum += term;
            term *= -1.0 * (x*x) / ((i - 1) * i);
        }
        System.out.printf("Java Math library: %.15f%n", Math.sin(x));
        System.out.printf("Taylor expansions: %.15f%n", sum);
    }

    /*
     *  // Note:  sin(pi/6) = sin(0.523598775598299...) = 1/2
     *
     *  // We use identity sin(x) = sin(x + 2 PI) to pre-process
     *  // x to be between -2 PI and 2 PI. Yes, % works with doubles!
     * 
     * // convert x to an angle between -2 PI and 2 PI
        x = x % (2 * Math.PI);

        // compute the Taylor series approximation
        double term = 1.0;      // ith term = x^i / i!
        double sum  = 0.0;      // sum of first i terms in taylor series

        for (int i = 1; term != 0.0; i++) { // x/i! will tend to zero, eventually the double is gonna be 0.0
            term *= (x / i);
            if (i % 4 == 1) sum += term;    // mod = 1 for i when multiple of 4 + 1 = 1, 5, 9, 13, 17...
            if (i % 4 == 3) sum -= term;    // mod = 3 for i when multiple of 4 + 3 = 3, 7, 11, 15, 19...
            
            i =   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
            mod = 0 1 2 3 0 1 2 3 0 1 2  3  0  1  2  3  0  1  2  3  0
        }
     */
    
}
