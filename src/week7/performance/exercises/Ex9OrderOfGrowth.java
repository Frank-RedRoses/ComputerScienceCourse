package week7.performance.exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/* Ex 4.1.9. Order of growth.
 * Determine the order of growth of the running time of this statement in 
 * ThreeSum as a function of the number of integers n on standard input:
 * 
 * int[] a = StdIn.readAllInts();
 */

/* Solution:
 * Linear. The bottlenecks are the array initialization and the input loop. 
 * Depending on your system, however, the cost of an input loop like this might
 * dominate in a linearithmic-time or even a quadratic-time program unless the 
 * input size is sufficiently large.
 */
public class Ex9OrderOfGrowth {

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int[] a = StdIn.readAllInts();
        StdOut.println("elapsed time = " + timer.elapsedTime());
        // int count = count(a);
        // StdOut.println(count);
    }

}
