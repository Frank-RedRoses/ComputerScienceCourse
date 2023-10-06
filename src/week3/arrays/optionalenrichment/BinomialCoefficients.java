package week3.arrays.optionalenrichment;
/**************************************************************************************
 * Binomial coefficients. 
 * Write a program that takes an integer command-line argument n and 
 * creates a two-dimensional ragged array a[][] such that a[n][k] 
 * contains the probability that you get exactly k heads when you toss 
 * a fair coin n times. These numbers are known as the binomial distribution: 
 * if you multiply each element in row i by 2^n, you get the binomial coefficients
 * —the coefficients of x^k in (x+1)^n— arranged in Pascal’s triangle. 
 * 
 * To compute them, start with a[n][0] = 0.0 for all n and a[1][1] = 1.0, 
 * then compute values in successive rows, left to right, 
 * with a[n][k] = (a[n-1][k] + a[n-1][k-1]) / 2.0.
 **************************************************************************************/

public class BinomialCoefficients {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double[][] binomial =  new double[n+1][];

        // initial row
        binomial[1] = new double[1 + 2];    // a[1][0] and a[1][2] values = 0.0 are needed for the next row.
        binomial[1][1] = 1.0;

        // Fill in coefficients of binomial distribution.
        // Need to consider border values to compute values equal to 1 using a[i][0] and a[i][k+1]. Ex.
        // a[2][0] = 0 and a[2][1] = 1 to compute a[3][1] = 1; 
        // a[2][2] = 1 and a[2][3] = 0 to compute a[3][3] = 1; 
        for (int i = 2; i <= n; i++) {
            binomial[i] = new double[i + 2];                            // i values + 2 for the indexes with value 0
            for (int k = 1; k < binomial[i].length - 1; k++) {          // compute from a[i][1] to a[i][i]
                binomial[i][k] = (binomial[i-1][k] + binomial[i-1][k-1]) / 2.0;
            }
        }

        // print binomial coefficients
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k < binomial[i].length - 1; k++) {
                System.out.print(binomial[i][k] + " ");
            }
            System.out.println();
        }   






    }
    
}
