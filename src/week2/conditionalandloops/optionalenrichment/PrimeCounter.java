package week2.conditionalandloops.optionalenrichment;
/**********************************************************************************
 * Counting primes. 
 **********************************************************************************
 * Write a program PrimeCounter that takes an integer command-line argument n and finds
 * the number of primes less than or equal to n. Use it to print out the number of primes 
 * less than or equal to 10 million. 
 * 
 * Note : If you are not  careful, your program may not finish in a reasonable amount of time!
 * 
 */
public class PrimeCounter {
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        long n = 10000000;
        long primeCounter; 
        // String primes = "2";

        if (n < 2) {
            // 1 and 0 are not considered prime numbers
            // primes = "none";
            primeCounter = 0;
        } else {
            primeCounter = 1; // it considers n=2 as initial value, 2 it's the first prime number.
            for (long i = 3; i <= n; i += 2) {
                boolean isPrime = true;
            
                /*
                * Try all possible factors of i
                * if i has a factor, then it has one less than or equal to sqrt(i)
                * so for efficiency we only need to check factor <= sqrt(i) or
                * equivalently factor*factor <= i
                */
                for (long factor = 2; factor*factor <= i; factor++) {
                // if factor divides evenly into n, n is not prime, so break out of loop
                    if (i % factor == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primeCounter++;
                    // primes += " " + i;
                }
            }

        }

        System.out.println("Primes less or equal to " + n + " = " + primeCounter);
        // System.out.println("Primes = " + primes);
    }
}
