package week7.performance.lecture;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* ***************************************************************************
 * Three-sum. 
 * Given N integers, enumerate the triples that sum to 0.
 *************************************************************************** */
public class ThreeSum {
     
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {   
                    // Keep i < j < k to avoid processing each triple 6 times.
                    // (N choose k possible combinantions)
                    if (a[i] + a[j] + a[k] == 0) 
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        double start = System.currentTimeMillis() / 1000.0;
        int cnt = count(a);
        double now = System.currentTimeMillis() / 1000.0;
        StdOut.printf("%d (%.0f seconds)\n", cnt, now - start);
    }
}
