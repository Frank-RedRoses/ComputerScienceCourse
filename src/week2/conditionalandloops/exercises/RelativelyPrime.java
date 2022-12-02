package week2.conditionalandloops.exercises;
/*
 * Write a program RelativelyPrime that takes an integer command-line argument
 * n and prints an n-by-n table such that there is an * in row i and column j 
 * if the gcd of i and j is 1 (i and j are relatively prime) and a space in that
 * position otherwise.
 */

public class RelativelyPrime {

    public static void main(String[] args) {
        int num = 10;
        String firstLine = "   ";
        for (int i = 1; i <= num; i++) {
            if (i < 10 ) firstLine += i + "  ";
            else firstLine += i + " ";
        }

        System.out.println(firstLine);

        for (int i = 1; i <= num; i++) {
            System.out.printf("%-3d", i);
            for (int j = 1; j <= num; j++) {
                // Use Euclidean algorithm to find the GCD of two numbers:
                // If "d" divides "a" and "d" divides "b", then d also divides "a - b".
                int a = i;
                int b = j;
                // GCD of "a" and "b" is the same as the GCD of "a - b" and "b" 
                // repeat subtraction until (a == b), the GCD is a == b.
                while (a != b) {
                    if (a > b) a -= b;
                    else b -= a;
                }
                // only if the GCD is equal to 1 the numbers are relative primes
                if (a == 1) System.out.printf("%-3s","*");
                // otherwise print a white space.
                else System.out.printf("%-3s"," ");
            }
            System.out.println();
        }
        
    }
    
}
