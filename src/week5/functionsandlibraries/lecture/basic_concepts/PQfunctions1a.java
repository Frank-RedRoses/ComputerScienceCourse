package week5.functionsandlibraries.lecture.basic_concepts;

import edu.princeton.cs.algs4.StdOut;

public class PQfunctions1a {
    // Q. What happens when you compile and run the following code?
    public static int cube(int i) {
        int j = i * i * i;
        return j;
    }
    // A. Takes N from the command line, then prints cubes of integers from 1 to N

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++)
            StdOut.println(i + " " + cube(i));
    }
    
    // Q. What happens when you compile and run the following code?
    public static int cube2(int i) {
        return i * i * i;
    }
    // A. Works fine. Preferred (compact) code.


}
