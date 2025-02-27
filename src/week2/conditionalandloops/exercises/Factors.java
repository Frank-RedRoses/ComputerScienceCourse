package week2.conditionalandloops.exercises;

/******************************************************************************
 *  Compilation:  javac Factors.java
 *  Execution:    java Factors n
 *
 *  Computes the prime factorization of n using brute force.
 *
 *   % java Factors 81
 *   The prime factorization of 81 is: 3 3 3 3
 *
 *   % java Factors 168
 *   The prime factorization of 168 is: 2 2 2 3 7
 *
 *   % java Factors 4444444444
 *   The prime factorization of 4444444444 is: 2 2 11 41 271 9091
 *
 *   % java Factors 4444444444444463
 *   The prime factorization of 4444444444444463 is: 4444444444444463
 *
 *   % java Factors 10000001400000049
 *   The prime factorization of 10000001400000049 is: 100000007 100000007
 *
 *   % java Factors 1000000014000000049
 *   The prime factorization of 1000000014000000049 is: 1000000007 1000000007
 *
 *   % java Factors 9201111169755555649
 *   The prime factorization of 9201111169755555649 is: 3033333343 3033333343
 *
 *   Can use these for timing tests - biggest 3, 6, 9, 12, 15, and 18 digit primes
 *   % java Factors 997
 *   % java Factors 999983
 *   % java Factors 999999937
 *   % java Factors 999999999989
 *   % java Factors 999999999999989
 *   % java Factors 999999999999999989
 *
 *   Remarks
 *   -------
 *   - Tests factor*factor <= n instead of factor <= n for efficiency.
 *
 *   - The last two examples still take a few minutes.
 *
 ******************************************************************************/

public class Factors {

    public static void main(String[] args) {

        // command-line argument
        // long n = Long.parseLong(args[0]);
        long n = 999999937l;
        String str = "";
        // System.out.print("The prime factorization of " + n + " is: ");

        // for each potential factor
        long start = System.currentTimeMillis();
        for (long factor = 2; factor*factor <= n; factor++) {

            // if factor is a factor of n, repeatedly divide it out
            while (n % factor == 0) {
                str += factor + " ";
                // System.out.print(factor + " ");
                n = n / factor;
            }
        }
        long end = System.currentTimeMillis();
        // if biggest factor occurs only once, n > 1
        if (n > 1) str += n;
        double timeElapse = (end - start) / 1000.0;
        
        System.out.println("The prime factorization of " + n + " is: " + str);
        System.out.println("Time elapse: " + timeElapse);
        
    }
}
