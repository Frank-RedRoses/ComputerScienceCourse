package week6.recursion.optional_enrichment;
import java.util.Scanner;

public class HummingExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read k and s from the user
        System.out.print("Enter an integer k: ");
        int k = input.nextInt();

        System.out.print("Enter a bit string s: ");
        String s = input.next();

        // Iterate through all possible bit strings of the same length as s
        for (int i = 0; i < Math.pow(2, s.length()); i++) {
            String candidate = Integer.toBinaryString(i);

            // Pad the candidate bit string with leading zeros if necessary
            while (candidate.length() < s.length()) {
                candidate = "0" + candidate;
            }

            // Check if the candidate has Hamming distance k from s
            int hammingDistance = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != candidate.charAt(j)) {
                    hammingDistance++;
                }
            }

            // Print the candidate if it has Hamming distance k from s
            if (hammingDistance == k) {
                System.out.println(candidate);
            }
        }

        input.close();
    }
}


