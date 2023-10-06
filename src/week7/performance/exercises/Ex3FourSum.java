package week7.performance.exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/* ****************************************************************************
 * Ex 4.1.3 Four Sum.
 * Write a program FourSum.java that takes an integer reads long integers from 
 * standard input, and counts the number of 4-tuples that sum to zero. Use a 
 * quadruple nested loop. What is the order of growth of the running time of 
 * your program? Estimate the largest input size that your program can handle 
 * in an hour. Then, run your program to validate your hypothesis.
 */
/* Answer:
 * The order of grow is N^4/24.
 * An estimation of the largest input that the problem can handle in an hour
 * is an array with a size between 3880 and 4000 values.
 */
public class Ex3FourSum {
    
    // return the number of distinc 4-tuples (i, j, k, l) such that 
    // a[i] + a[j] + a[k] + a[l] = 0
    public static int count(long[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            // StdOut.println(a[i] + "\t" + a[j] + "\t" + a[k] + "\t" + a[l]);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long[] a = StdIn.readAllLongs();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time: " + (timer.elapsedTime()*1000));
        StdOut.println(count);
    }
}
