package case_study.elements_of_programing.web_surfer;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 * Simulating the random surfer.
 * Consider the web to be a fixed set of pages, with each page containing a 
 * fixed set of hyperlinks, and each link a reference ro some other page.
 * Then study what happens to a person (random surfer) who randomly moves
 * from page to page, either by typing a page name on the address bar or by
 * clickling a link on the current page.
 * 
 * The random surfer follows a 90-10 rule:
 *  - 90% time cliks a random link on the page
 *  - 10% time goes directly to a random page.
 * Each link and page chosen with equal probability.
 * 
 * This program uses a transition matrix to simulate the behavior of a random 
 * surfer. It takes the number of moves as a command-line argument, reads the
 * transition matrix, performs the indicated number of moves as prescribed by 
 * the matrix, and prints the relative frequency of hitting each page. The key
 * to the computation is the random move to the next page. 
 * 
 * * % Java Transition < tiny.txt
 * 5 5
 * 0.02000 0.92000 0.02000 0.02000 0.02000
 * 0.02000 0.02000 0.38000 0.38000 0.20000
 * 0.92000 0.02000 0.02000 0.02000 0.02000
 * 0.47000 0.02000 0.47000 0.02000 0.02000
 * 0.02000 0.02000 0.47000 0.02000 0.02000 
 * 
 * 
 * % java Transition < tiny.txt | java RandomSurfer 100
 * 0.24000 0.23000 0.16000 0.25000 0.12000
 * 
 * % java Transition < tiny.txt | java RandomSurfer 1000000
 * 0.27324 0.26568 0.14581 0.24737 0.06790
 * 
 **************************************************************************** */
public class RandomSurfer {
    public static void main(String[] args) {
        int totalMoves = Integer. parseInt(args[0]);    // number of moves.
        int N = StdIn.readInt();                        // number of pages.
        StdIn.readInt();                                // consume the second N from the input, does nothing with it.

        // Read and store the transition matrix
        double[][] probs = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                probs[i][j] = StdIn.readDouble();
            }
        }

        int page = 0;               // Start at page 0.
        int[] freq = new int[N];    // Number of times the surfer hits page i
        for (int t = 0; t < totalMoves; t++) {
            // Make one random move 
            double r = Math.random();
            double sum = 0.0;
            for (int j = 0; j < N; j++) {
                // find the interval containing r.
                sum += probs[page][j];
                if (r < sum) {
                    page = j;
                    break;
                }
            }
            freq[page]++;
        }
        // Print page ranks.
        for (int i = 0; i < N; i++) 
            StdOut.printf("%8.5f", (double) freq[i] / totalMoves);
        StdOut.println();
    }
}
