package week6.recursion.exercises;
/* *******************************************************************
 * Ex.2.3.1
 * What happens if you call factorial () with a negative value of n? 
 * With a large value, say, 35?
 *
 ******************************************************************* */

public class Ex1NegativeFactorial {

    public static int factorial(int n) {
        // Base case:
        if (n == 1) return 1;
        // Reduction step:
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(-23)); 
        /* Answer:
         * The program keep sustracting -1 to -35 until it finally 
         * underflows and results in a StackOverflowError
         */
    }
    
}
