package week7.performance.optional_enrichment;

import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import week7.performance.lecture.ThreeSum;

public class ThreeSumAnalysis {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        n = 500;
        int trials = Integer.parseInt(args[1]);
        trials = 5000; 
        // int M = 10000;
        int noTripleCtn = 0;
        int[] rdmInts = new int[n];
        Random rnd = new Random();

        double start = System.currentTimeMillis()/1000;
        for (int i = 0; i < trials; i++) {
            for (int j = 0; j < rdmInts.length; j++) {
                // rdmInts[j] = StdRandom.uniform(-M, M);
                rdmInts[j] = rnd.nextInt();
            }
            
            if (ThreeSum.count(rdmInts) == 0) {
                noTripleCtn++;
            }
        }
        double end = System.currentTimeMillis()/1000;

        StdOut.printf("Time = %.0f seconds\n", end - start);
        StdOut.println("trials = " + trials);
        StdOut.println("n = " + n + ", integers that don't triple-sum to 0 = " + noTripleCtn + " times.");
        StdOut.printf("Probability of getting no triples equal to 0: %.5f %%\n", (noTripleCtn * 100.0) / trials);

    }
    
}
