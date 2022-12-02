package week3.arrays.lessons;

/******************************************************************************
 *  Compilation:  javac PrimeSieve.java
 *  Execution:    java -Xmx1100m PrimeSieve n
 *
 *  Computes the number of primes less than or equal to n using
 *  the Sieve of Eratosthenes.
 *
 *  % java PrimeSieve 25
 *  The number of primes <= 25 is 9
 *
 *  % java PrimeSieve 100
 *  The number of primes <= 100 is 25
 *
 *  % java -Xmx100m PrimeSieve 100000000
 *  The number of primes <= 100000000 is 5761455
 *
 *  % java PrimeSieve -Xmx1100m 1000000000
 *  The number of primes <= 1000000000 is 50847534
 *
 *
 *  The 110MB and 1100MB is the amount of memory you want to allocate
 *  to the program. If your computer has less, make this number smaller,
 *  but it may prevent you from solving the problem for very large
 *  values of n.
 *
 *
 *                  n     Primes <= n
 *  ---------------------------------
 *                 10               4
 *                100              25
 *              1,000             168
 *             10,000           1,229
 *            100,000           9,592
 *          1,000,000          78,498
 *         10,000,000         664,579
 *        100,000,000       5,761,455
 *      1,000,000,000      50,847,534
 *
 ******************************************************************************/

public class PrimeSieve {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);  // find numbers of primes less than n

        // initially assume all numbers are prime
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < isPrime.length; i++) {   // 0 and 1 are not prime numbers
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Erastosthenes
        /*
         * The Sieve of Erastosthenes marks as nonprimes the multiples of a number.
         * So for example, to find primes less than 50 start with the first prime 2 (0 and 1 are not prime numbers)
         * and then check for every multiple of 2, multiply 2 by a sequence starting at 2 and stops when 2*i > 50.
         * 2*2 = 4; 2*3 = 6; 2*4 = 8;... 2*25 = 50. Mark every result as non-prime.
         * Go to the next prime number, in this case 3, and do the same
         * 3*3 = 9; 3*4 = 12; 3*5 = 15;... stops when 3*i > 50. Mark every result as non-prime.
         * There is no need to check a multiplication lower than 3*3 because the previous prime has already
         * checked the lower multiplications, in this example 2*3 = 3*2 = 6, is already marked. 
         * Go to the next prime number, in this case 5 (4 is a multiple of 2), and then do the same. 
         * 5*5 = 25; 5*6 = 30; ... stops when 5*i > 50. Mark every result as non-prime.
         * There is no need to check multiples of a non-prime number because every multiple is already 
         * marked as non-prime. Ex. 4*4 = 16, 6*7 = 42, all multiples of 2. 
         * Continue to prime 7, find 7*7 and stop there, 7*8 = 56 > 50. 
         * There is no need to check for any number greater than 7 because 7*7 = 49, the next number 8 
         * is a multiple of 2 and also 8*8 = 64 > 50.
         * The next prime is 11 so 11*11 = 121 > 50.
         */
        for (int factor = 2; factor*factor < n; factor++) {  // Check only for number less than sqrt(n).
            // if factor is a prime, then mark multiples of factor as nonprimes
            // suffices to consider multiples factors, factor+1, ..., n/factor
            if(isPrime[factor]) {
                for (int i = factor; factor*i < n; i++) {   // Checks for multiplications by i greater than factor. 
                    isPrime[factor*i] = false;              // Ex: It does not makes much sense to check 3*2 because the factor 2 already did that.
                }
            }
        }

        // count primes
        int nPrimes = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                nPrimes++;
            }
        }
        System.out.println("The number of primes <= " + n + " is " + nPrimes);
    }
}
