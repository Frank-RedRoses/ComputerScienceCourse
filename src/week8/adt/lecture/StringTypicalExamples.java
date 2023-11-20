package week8.adt.lecture;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringTypicalExamples {

    // Is the string a palindrome
    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) 
            if (s.charAt(i) != s.charAt(N - 1 - i)) return false;
        return true;
    }

    // Find files containing a specified string in StdIn
    public static void inputContains(String query) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            if (s.contains(query))
                StdOut.println(s);
        }
    }
    

    // Search for *.edu hyperlinks in a text file on StdIn
    public static void containsHyperlink() {
        String s = StdIn.readString();
        if (s.startsWith("http://") && s.endsWith(".edu"))
            StdOut.println(s);
    }
}
