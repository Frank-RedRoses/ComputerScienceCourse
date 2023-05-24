package week6.recursion.exercises;

/* ******************************************************************
 * Ex.2.3.5
 * Criticize the following recursive function:
 * 
 ******************************************************************* */
public class Ex5CritizeRecursion {
    
    public static String ex235(int n) {
        // Reduction step:
        String s = ex235(n-3) + n + ex235(n-2) + n;
        // base case:
        if (n <= 0) return "";
        return s;
    }
    /* Answer:
     * The base case will never be reached. A call to the method will result 
     * in to ex235(0), ex235(n-3), ex235(n-2) and so forth until a StackOverflowError.
     */
}
