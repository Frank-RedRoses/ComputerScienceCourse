package week7.performance.exercises;

import edu.princeton.cs.algs4.StdOut;

/*
 * What is the value of the variable count, as a function of n, 
 * after running the following code fragment?
 *      int count = 0;
 *      for (int i = 0; i < n; i++)
 *          for (int j = i+1; j < n; j++)
 *              for (int k = j+1; k < n; k++)
 *                  count++;
 */

/* Solution:
 * (N choose K) = (n 3) = n(n-1)(n-2) / 3*(3-1)*(3-2)
 * (n 3) = n(n-1)(n-2) / 6
 */
public class Ex7ValueOfCount {

    public static int countValue(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    count++;
        return count;
    }

    public static void main(String[] args) {
        int n = 60;
        StdOut.println("count value by method: " + countValue(n));
        int value = n * (n-1) * (n-2) / 6;
        StdOut.println("count value by formula: " + value);
    }
}
