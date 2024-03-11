package case_study.functions_and_modules.percolation;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*************************************************************************
 * Program 2.4.2 Vertical percolation detection.
 * Substituting the flow() stub method in Program 2.4.1  for this one here 
 * gives a solution to the vertical-only percolation problem that solves our
 * test case as expected.
 * 
 *********************************************************************/
public class PercolationVertical {

    public static boolean[][] flow(boolean[][] isOpen) {
        // Compute full sites for vertical percolation.
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        for(int j = 0; j < n; j++) 
            isFull[0][j] = isOpen[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isFull[i][j] = isOpen[i][j] && isFull[i-1][j];
            }
        }
        return isFull;
    }

    public static boolean percolates(boolean[][] isOpen) {
        boolean[][] isFull = flow(isOpen);
        int n = isOpen.length;
        for (int j = 0; j < n; j++) 
            if(isFull[n-1][j]) return true;
        return false;
    }

    public static void show(boolean[][] a, boolean which) {
        int n = a.length;
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) {
                if (a[i][j] == which) 
                    StdDraw.filledSquare(j, n-i-1, 0.49);
            }
    }

    public static boolean[][] random(int n, double p) {
        boolean[][] arr = new boolean[n][n];
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++)
                    arr[i][j] = StdRandom.bernoulli(p);
        return arr;
    }

    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(isOpen));
        StdOut.println(percolates(isOpen));
        show(flow(isOpen), true);
    }

}
