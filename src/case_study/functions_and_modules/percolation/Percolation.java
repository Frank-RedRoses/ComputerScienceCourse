package case_study.functions_and_modules.percolation;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/************************************************************************
 * Program 2.4.5 Percolation detection.
 * Substituting these methods for the stub in Program 2.4.1 gives a 
 * depth-first-search-based solution to the percolation problem. 
 * The recursive flow() sets to true the element in isFull[][]
 * corresponding to any site that can be reached from isOpen[i][j] 
 * via a chain of neighboringopen sites. The one-argument flow() 
 * calls the recursive method for every site on the top row
 ************************************************************************/
public class Percolation {

    public static boolean[][] flow(boolean[][] isOpen) {
        // Fill every site reachable from the top row.
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        for (int j = 0; j < n; j++)
            flow(isOpen, isFull, 0, j);
        return isFull;
    }

    public static void flow(boolean[][] isOpen, boolean[][] isFull,
                                    int i, int j) {
        // Fill every site reachable from (i, j).
        int n = isFull.length;
        if (i < 0 || i >= n) return;
        if (j < 0 || j >= n) return;
        if (!isOpen[i][j]) return;
        if (isFull[i][j]) return;
        isFull[i][j] = true;
        // Check nearby sites.
        flow(isOpen, isFull, i + 1, j); // Down.
        flow(isOpen, isFull, i, j + 1); // Right.
        flow(isOpen, isFull, i, j - 1); // Left.
        flow(isOpen, isFull, i - 1, j); // Up.
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
        show(flow(isOpen), false);
    }
}
