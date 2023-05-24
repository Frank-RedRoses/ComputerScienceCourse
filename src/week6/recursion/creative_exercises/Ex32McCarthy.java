package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdOut;

/* 2.3.32. A strange function..
 * 
 * Consider McCarthy's 91 function:
 *  public static int mcCarthy(int n) {
 *      if (n > 100) return n - 10;
 *      else return mcCarthy(mcCarthy(n+11));
 *  }
 * 
 * Determine the value of mcCarthy(50) without using a computer. Give the number
 * of recursive calls used by mcCarthy() to compute this result. Prove that the 
 * base case is reached for all positive integers n or find a value of n for which 
 * this function goes into a recursive loop.
 * */
 
  
/* Proof: M(n)=91 for all positive integers n with n ≤ 101
 *
 * M(n) = { n - 10       for n ≥ 101
 *          M(M(n+11))   for n < 101}
 * 
 * for 90 ≤ n < 101:
 * M(n) =M(M(n+11))
 *      =M(n+11−10), since n ≥ 90 hence M(n+11) ≥ M(101), therefore M(n+11) = n+11-10 
 *      =M(n+1) (only when n between 90 and 100)
 * hereby:
 * M(90) = M(90+1) = M(91) = … = M(99+1) = M(100) = M(100+1) = M(101) = 101−10 = 91
 * So M(n)=91 for 90 ≤ n < 101.
 * 
 * We can use this as a base case for induction on blocks of 11 numbers, like so:
 * 
 * Assume that M(n)=91 for i ≤ n < i + 11. Where i ≤ 90.
 * Then, for any value n such that i−11 ≤ n < i, 
 *   M(n) = M(M(n+11))
 *        = M(91), by hypothesis, since i ≤ n + 11 < i + 11  
 *        = 91, by the base case.
 * 
 * Now by induction M(n)=91 for any n in such a block. 
 * There are no holes between the blocks, so M(n)=91 for n<101. 
 * We can also add n=101 as a special case.
 * 
 * */
public class Ex32McCarthy {
    private static int nCall = 0;
    
    public static int mcCarthy(int n) {
        nCall++;
        if (n > 100) return n - 10;
        else return mcCarthy(mcCarthy(n+11));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // int n = 91; // for debug
        StdOut.println("The value of mcCarthy(" + n + ") is " + mcCarthy(n));
        StdOut.println("Done in " + nCall + " recursive calls.");
        
    }

}
