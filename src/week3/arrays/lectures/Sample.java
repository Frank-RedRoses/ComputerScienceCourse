package week3.arrays.lectures;

public class Sample {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);     // choose this many elements
        int n = Integer.parseInt(args[1]);     // from 0, 1, ..., n-1

        // create a permutation 0, 1, ..., n-1
        int[] perm = new int[n];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }

        // create random  sample in perm[0], perm[1], ..., perm[m-1]
        for (int i = 0; i < m; i++) {
            // random integer between i and n-1
            int r = i + (int) (Math.random() * (n-i));

            // swap the elements at indices i and r 
            int t = perm[r];
            perm[r] = perm[i];
            perm[i] = t;
        }

        // print the results
        for (int i = 0; i < m; i++) 
            System.out.print(perm[i] + " ");
        System.out.println();
    }
    
}
