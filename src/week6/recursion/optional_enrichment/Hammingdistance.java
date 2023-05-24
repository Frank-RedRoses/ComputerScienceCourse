package week6.recursion.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;

/* *************************************************************************
 * 2.3.21 Hamming distance. The Hamming distance between two bit strings of 
 * length n is equal to the number of bits in which the two strings differ. 
 * Write a program that reads in an integer k and a bit string s from the 
 * command line, and prints all bit strings that have Hamming distance at 
 * most k from s. For example, if k is 2 and s is 0000, then your program 
 * should print
 * 
 * 0011 0101 0110 1001 1010 1100 
 * 
 * Hint : Choose k of the bits in s to flip.
 ************************************************************************** */

public class Hammingdistance {

    // Hamming distance without recursion
    private static int hammingDist(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) return 0;
        else if (a.isEmpty()) return b.length();
        else if (b.isEmpty()) return a.length();
        else {
            int hammingNumber = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    hammingNumber++;
                }
            }
            return hammingNumber;
        }
    }

    // Hamming distance with recursion
    private static int hammingDistRecursive(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) return 0;
        else if (a.isEmpty()) return b.length();
        else if (b.isEmpty()) return a.length();
        else { 
            if (a.charAt(0) == b.charAt(0)) 
                return hammingDistRecursive(a.substring(1), b.substring(1));
            else
                return 1 + hammingDistRecursive(a.substring(1), b.substring(1));
        }


    }

    private static void HammingDistanceTo(int k, String s) {
        String result = "";
        for (int i = 0; i < Math.pow(2, s.length()); i++) {
            String bitStringComb = Integer.toBinaryString(i);

            while (bitStringComb.length() < s.length()) {
                bitStringComb = "0" + bitStringComb;
            }

            if (hammingDistRecursive(s, bitStringComb) == 2) {
                result += bitStringComb + " ";
            }
        }
        StdOut.println(result);
    }


    public static int Q2(int n)
    {
        if (n <= 0) return 1;
        return 1 + Q2(n-2) + Q2(n-3);
    }

    public static void Q3(int n) {
        if (n <= 0) return;
        StdOut.println(n);
        Q3(n-2);
        Q3(n-3);
        StdOut.println(n);
    }

    public static void Q4(int n){
        if (n <= 0) return;
        StdOut.println(n);
        Q4(n-2);
        Q4(n-3);
        StdOut.println(n);
    }

    public static int Q5(int n) {
        int[] b = new int[n+1];
  	    b[0] = 1;
  	    for (int i = 2;	i <=n; i++) {
  	    b[i] = 0;
  	    for	(int j = 0; j <	i; j++)
            b[i] += b[j];
        }
        return b[n];
    }


   public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String s = args[1];
        StdOut.print(hammingDist("0000", "0001"));
        StdOut.println(hammingDistRecursive("1001", "0010"));
        HammingDistanceTo(k, s);
        StdOut.println(Q2(6));
        StdOut.println("------");
        Q3(6);
        StdOut.println("------");
        Q4(7);

   }
}
