package case_study.elements_of_programing.web_surfer;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* ****************************************************************************
 * 
 * Squaring a Markov chain.
 * The result of multiplying the transition matrix by itself is a metrix where
 * the entry in row i and column j is the probability that the random surfer
 * moves from page i to j in two moves, this means that the surfer goes to an 
 * intermediate page k between i and j.
 * 
 * The probability of going from page i to page j through a page k is the 
 * multiplication of the probability going from page i to a k by the 
 * probability from page k to j. And to get the probability of going 
 * from page i to j using two moves is to calculate each probability using
 * every possible value of k and then add those probabilities to get the 
 * total one. This is the same process as calculating the dot product
 * between row i and column j. 
 * 
 * The power method.
 * The vector giving the probabilities that the random surfer is at each page
 * after t steps is precisely the product of the corresponding vector for t-1 
 * steps and the transition matrix (previous vector-matrix calculation).
 * 
 * By the basic limit theorem for Markov chains, this process converges to the
 * same vector no matter where we start; in other words, after a sufficient 
 * number of moves, the probability that the surfer ends up on any given page
 * is independent of the starting point.
 * 
 * This program reads a transition matrix from standard input and computes the
 * probabilities that a random surfer lands on each pages (page ranks) after 
 * the number of steps specified as command-line argument.
 * 
 * % java Transition < tiny.txt | Java Markov 20
 * 0.27245 0.26515 0.14669 0.24764 0.06806
 * 
 * % Java Transition < tiny.txt | Java Markov 40
 * 0.27303 0.26573 0.14618 0.24723 0.06783
 * 
 **************************************************************************** */
public class Markov {
    
    // Compute page ranks after T moves.
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);  // number of iterations
        int N = StdIn.readInt();            // number of pages
        StdIn.readInt();

        // Read probabilities[][] from StdIn. (Transition matrix)
        double[][] probabilites = new double[N][N]; // transition matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                probabilites[i][j] = StdIn.readDouble();
            }
        }

        // Use the power method to compute page ranks
        double[] rank = new double[N];                      // page ranks
        // set the initial page, does not matter which page
        rank[0] = 1.0;  // [1.0, 0.0, 0.0, 0.0, ..., 0.0] Specifies random surfer starts on page 0
        for (int t = 0; t < T; t++) {
            // Compute effect of next move on page ranks 
            double[] newRank = new double[N];               // new page ranks
            for (int j = 0; j < N; j++) {
                // New rank page j is dot product
                // of old ranks and column j of probabilities[][].
                for (int k = 0; k < N; k++) {
                    newRank[j] += rank[k] * probabilites[k][j];
                }
            }
            // make rank[] values point to newRank[];
            for (int j = 0; j < N; j++) {
                rank[j] = newRank[j];
            }
        }
    
        // Print page ranks
        for (int i = 0; i < N; i++) 
            StdOut.printf("%8.5f", rank[i]);
        StdOut.println();
    }
}
