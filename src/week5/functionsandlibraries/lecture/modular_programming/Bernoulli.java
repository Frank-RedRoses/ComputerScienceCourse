package week5.functionsandlibraries.lecture.modular_programming;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import week5.functionsandlibraries.lecture.gaussian_distribution.Gaussian;

public class Bernoulli {
    /**
     * Flip N coins and gives the number of heads resulting from the N flips.
     * @param N number of coin tosses.
     * @return the number of times we get head from the N tosses. 
     */
    public static int binomial(int N) {
        int heads = 0;
        for (int j = 0; j < N; j++)
            if (StdRandom.bernoulli(0.5))
                heads++;
        return heads;
    }

    public static void main(String[] args) {
        // Get command-line argument (trial experiments of N flips)
        int N = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // Run the experiments. 
        // Keep track of the frequency of ocurrence of each return value.
        int[] freq = new int[N + 1];
        for (int t = 0; t < trials; t++)
            freq[binomial(N)]++;    // Add 1 to index array equal to the number of heads.

        // Normalize results to double values between 0 and 1 
        double[] normalized = new double[N + 1];
        for (int i = 0; i <= N; i++)
            normalized[i] = (double) freq[i] / trials;
        StdStats.plotBars(normalized);  // plots Histogram

        // Plot theoretical Bernoulli curve to campare with the histogram results
        double mean = N / 2.0;
        double stddev = Math.sqrt(N) / 2.0;
        double[] phi = new double[N + 1];
        for (int i = 0; i <= N; i++)
            phi[i] = Gaussian.pdf(i, mean, stddev); // Call to the Gaussian module
        StdStats.plotLines(phi);
    }
}
