package case_study.functions_and_modules.percolation;

import edu.princeton.cs.algs4.StdDraw;
/****************************************************************************
 * Program 2.4.3 Visualization client.
 * This client takes two command-line argument n and p, generates an n-by-n
 * random system with site vacancy probability p, determines which sites
 * are full, and draws the result on standard drawing. The diagrams below 
 * show the results for vertical percolation.
 ****************************************************************************/
public class PercolationVisualizer {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);      // system size (n-by-n)
        double p = Double.parseDouble(args[1]); // site vacancy probability
        StdDraw.enableDoubleBuffering();
        // Create a random open site n-by-n lattice
        boolean[][] isOpen = PercolationVertical.random(n, p);
        // Draw blocked sites in black.
        StdDraw.setPenColor(StdDraw.BLACK);
        PercolationVertical.show(isOpen, false);

        /* Draw full sites in blue in vertical percolation
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        boolean[][] isFull = PercolationVertical.flow(isOpen);
        PercolationVertical.show(isFull, true);
        */

        // Draw full sites in blue in normal percolation
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        boolean[][] isFull = Percolation.flow(isOpen);
        Percolation.show(isFull, true);

        StdDraw.show();
    }
}
