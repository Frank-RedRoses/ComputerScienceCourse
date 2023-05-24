package week6.recursion.optional_enrichment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HammingRecursiveExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        // Read k and s from the user
        System.out.print("Enter an integer k: ");
        int k = input.nextInt();
    
        System.out.print("Enter a bit string s: ");
        String s = input.next();
    
        // Find all bit strings of length n with Hamming distance k from s
        int n = s.length();
        List<String> result = findStrings(n, k, s);
    
        // Print the result
        for (String str : result) {
            System.out.println(str);
        }

        input.close();
    }
    
    /**
     * Finds all bit strings of length n with Hamming distance k from a given bit string s.
     *
     * @param n the length of the bit strings
     * @param k the desired Hamming distance
     * @param s the reference bit string
     * @return a list of all bit strings with Hamming distance k from s
     */
    public static List<String> findStrings(int n, int k, String s) {
        // Base case: if k is 0, the Hamming distance is 0 and the only valid string is s
        if (k == 0) {
            List<String> result = new ArrayList<>();
            result.add(s);
            return result;
        }
    
        // Base case: if k is equal to n, the Hamming distance is n and the only valid string is the complement of s
        if (k == n) {
            List<String> result = new ArrayList<>();
            String complement = complement(s);
            result.add(complement);
            return result;
        }
    
        // Recursive case: find all bit strings of length n-1 with Hamming distance k-1 from s
        List<String> result = new ArrayList<>();
        List<String> substrings = findStrings(n-1, k-1, s.substring(0, n-1));
        for (String str : substrings) {
            String candidate = str + "1";
            result.add(candidate);
        }
    
        // Recursive case: find all bit strings of length n-1 with Hamming distance k from s
        substrings = findStrings(n-1, k, s.substring(0, n-1));
        for (String str : substrings) {
            String candidate = str + "0";
            result.add(candidate);
        }
    
        return result;
    }
    
    /**
     * Returns the complement of a bit string.
     *
     * @param s the bit string to complement
     * @return the complement of the bit string
     */
    public static String complement(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
    
}
