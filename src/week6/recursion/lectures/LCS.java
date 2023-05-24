package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 *  Compilation:  javac LongestCommonSubsequence.java
 *  Execution:    java LongestCommonSubsequence s t
 * 
 * Longest common subsequence (LCS) problem. Given two strings s and t, we wish 
 * to compute their LCS. If we delete some characters from s and some 
 * characters from t, and the resulting two strings are equal, we call the 
 * resulting string a common subsequence. The LCS problem is to find a common
 * subsequence of two strings that is as long as possible.
 * 
 * For example, the LCS of GGCACCACG and ACGGCGGATACG is GGCAACG, a string of length 7.
 * - - G G C - - A - C C A C G
 * A C G G C G G A T - - A C G
 * 
 * This program only compute the length of the LCS of two strings s and t.
 * Approach: 
 * Keep track of the length of the LCS of s[i... M) and t[j... N) using an array opt[i, j].
 * Use two loops starting in i = M-1 and j = N-1 through all the values and
 * check for three cases:
 *  - i == M or j == N  -->     opt[i][j] = 0;
 *  - s[i] == t[j]      -->     opt[i][j] = opt[i+1][j+1] + 1
 *  - otherwise         -->     opt[i][j] = max(opt[i][j+1], opt[i+1][j])
 * 
 ***************************************************************************** */

public class LCS {
    
    public static void main(String[] args) {
        String s = args[0];         // First String
        String t = args[1];         // Second String
        int M = s.length();         // First String length       
        int N = t.length();         // Second String length 

        int[][] opt = new int[M+1][N+1];    // Array to keep track of the LCS
        // The opt[M][...] and opt[...][N] values are equal to 0 
        
        for (int i = M - 1; i >= 0; i--) {  
            for (int j = N - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) 
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }
        StdOut.println(opt[0][0]);
    }
}
