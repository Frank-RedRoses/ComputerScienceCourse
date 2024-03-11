package case_study.functions_and_modules.percolation;

import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

/* ***********************************************************************
 * Program 2.4.1 Percolation scaffolding.
 * To get started with percolation, we implement and debug this code, 
 * which handles all the straightforward tasks surrounding the 
 * computation. The primary function flow() returns a boolean matrix 
 * giving the full sites (none, in the placeholder code here). 
 * The helper function percolates() checks the bottom row of the returned 
 * matrix to decide whether the system percolates. The test client main()
 * reads a boolean matrix from standard input and prints the result of 
 * calling flow() and percolates() for that matrix.
 * 
 * This code does not perform any interesting computation, but after running 
 * and debugging this code we can start thinking about actually solving the 
 * problem. A method that performs no computation, such as flow(), is 
 * sometimes called a "stub".
**************************************************************************/
public class PercolationStub {

    public static boolean[][] flow(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        // The isFull[][] matrix computation goes here.
        return isFull;
    }

    public static boolean percolates(boolean[][] isOpen) {
        boolean[][] isFull = flow(isOpen);
        int n = isOpen.length;
        for (int j = 0; j < n; j++) 
            if(isFull[n-1][j]) return true;
        return false;
    }

    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(isOpen));
        StdOut.println(percolates(isOpen));
    }

}
