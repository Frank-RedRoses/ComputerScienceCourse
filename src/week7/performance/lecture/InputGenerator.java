package week7.performance.lecture;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/* ****************************************************************************
 * Input generator for the ThreeSum problem.
 **************************************************************************** */
public class InputGenerator {
    // Generate N integers in [-M, M)
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        M = Integer.MAX_VALUE;
        int N = Integer.parseInt(args[1]);
        for (int i = 0; i < N; i++) {
            StdOut.println(StdRandom.uniform(-M, M));
        }
    }
}
