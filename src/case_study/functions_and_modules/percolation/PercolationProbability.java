package case_study.functions_and_modules.percolation;

import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 * Program 2.4.4 Percolation probability estimate.
 * The method estimate() generates trials random n-by-n systems with site
 * vacancy probability p and computes the fraction of them that percolate.
 * This is a Bernoulli process, like coinflipping (see Program 2.2.6). 
 * Increasing the number of trials increases the accuracy of theestimate. 
 * If p is close to 0 or to 1, not many trials are needed to achieve an 
 * accurate estimate.
 * The results below are for vertical percolation.
 ********************************************************/

public class PercolationProbability {
    public static double estimate(int n, double p, int trials) {
        // Generates "trials" random n-by-n systems; return empirical
        // percolation probability estimate.
        int count = 0;
        for (int t = 0; t < trials; t++) {
            // Generate one random n-by-n boolean matrix 
            boolean[][] isOpen = Percolation.random(n, p);
            if (Percolation.percolates(isOpen)) count++;
        } 
        return (double) count / trials;
    }

    public static void main(String[] args) {
        int gridSize = Integer.parseInt(args[0]);
        double probVancancy = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);

        double q = estimate(gridSize, probVancancy, trials);  // percolation probability
        StdOut.println("Percolation probability: " + q);
    }


}
