package week10.programming_languages.lecture;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
        } 
        for (int i = 0; i < N; i++) 
            for (int j = i+1; j < N; j++) 
                for (int k = j+1; k < N; k++) 
                    if (a[i] + a[j] + a[k] == 0) 
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);        
    }
}