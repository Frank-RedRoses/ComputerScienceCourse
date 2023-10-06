package week5.functionsandlibraries.lecture.gaussian_distribution;

import edu.princeton.cs.algs4.StdOut;

/**
 * Gaussian distribution.
 * A mathematical model used successfully for centuries.
 * "Bell curve" fits experimental observations in many contexts.
 */
public class Gaussian {

    // Gaussian probability density function (pdf)
    public static double pdf(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI); // call a function in another module (Math
    }

    // functions with different signatures are different (even if names match)
    public static double pdf(double x, double mu, double sigma) {
        return pdf((x - mu) / sigma) / sigma;
    }

    /** 
     * Gaussian cumulative distribution function (cdf).
     * Use the Taylor series to calculate the integral.<p>
     * 
     * 1/2 + pdf(z) * (z + z^3/3 + z^5/(3*5) + z^7/(3*5*7) + ...)
     * 
     * 
     **/
    public static double cdf(double z) {
        if (z < -8.0)
            return 0.0;
        if (z > 8.0)
            return 1.0;
        double sum = 0.0, term = z; // terms of summation, they don't start with 0.
        for (int i = 3; sum + term != sum; i += 2) {    // check and stops when sum + term == sum.
            sum = sum + term;                           // add the term to the sum.
            term = term * z * z / i;                    // compute the next summation term.
            /* The term variable starts equal to z.
             * So, if i == 3, term*z*z/i equals z^3/3,
             * Next iteration term = z^3/3,
             * then, i == 5 and term*z*z/i equals (z^3/3)*z*z/5
             * so, next iteration term = z^5/(3*5)
             */
        }
        return 0.5 + sum * pdf(z);  // accurate to 15 places
    }

    // functions with different signatures are different (even if names match)
    public static double cdf(double z, double mu, double sigma) {
        return cdf((z - mu) / sigma);
    }

    // Best practice: test all code at least one in main()
    public static void main(String[] args) {
        double z = Double.parseDouble(args[0]);
        double mu = Double.parseDouble(args[1]);
        double sigma = Double.parseDouble(args[2]);
        StdOut.println(cdf(z, mu, sigma));
    }
}
