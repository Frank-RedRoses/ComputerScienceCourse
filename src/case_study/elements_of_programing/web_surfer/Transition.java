package case_study.elements_of_programing.web_surfer;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/* **************************************************************************** 
 * Computing the Transition Matrix.
 * The transition matrix is a 2D matrix used to specify the behavior of
 * the random surfer. An N by N matrix such that the entry in row [i] and
 * column [j] is the probablity that the random surfer moves to the page j 
 * when on page i.
 * 
 * This program is a filter that reads links from standard input and produces
 * the corresponding transition matrix on stadard output. First, it processes
 * the input to count the outlinks from each page, then it applies the 90-10
 * rule to compute the transition matrix. It assumes that there are no pages 
 * that have no outlinks in the input.
 * 
 * Input:
 * % more tiny.txt
 * 5                        <--- N web pages
 * 0 1                      <--- ordered pairs of links [from page] [to page]
 * 1 2  1 2  1 3  1 4
 * 2 3
 * 3 0
 * 4 0  4 2
 * 
 * Output:
 * % Java Transition < tiny.txt
 * 5 5
 * 0.02000 0.92000 0.02000 0.02000 0.02000
 * 0.02000 0.02000 0.38000 0.38000 0.20000
 * 0.92000 0.02000 0.02000 0.02000 0.02000
 * 0.47000 0.02000 0.47000 0.02000 0.02000
 * 0.02000 0.02000 0.47000 0.02000 0.02000
***************************************************************************** */
public class Transition {

    public static void main(String[] args) {
        // Print random-surfer probabilites.
        int N = StdIn.readInt();            // number of pages
        int[][] counts = new int[N][N];     // count of links from page i to page j
        int[] outDegree = new int[N];       // count of links from page i to anywhere
        while (!StdIn.isEmpty()) {
            // Accumulate link counts.
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            outDegree[i]++;
            counts[i][j]++;
        }

        StdOut.println(N + " " + N);
        for (int i = 0; i < N; i++) {
            // Print probability distribution for row i.
            for (int j = 0; j < N; j++) {
                // Print probability for column j.
                double prob = .90 * counts[i][j] / outDegree[i] + .10 / N; // 90-10 probalility rule 
                StdOut.printf("%8.5f", prob);
            }
            StdOut.println();
        }
    }
}
