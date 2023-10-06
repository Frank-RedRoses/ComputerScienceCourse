package week7.performance.q_and_a;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/* ************************************************************************
 * How do I find out how long it takes to add or multiply two double values 
 * on my computer?
 * 
 * How much time do functions such as Math.sqrt(), Math.log(), and Math.sin()
 * take?
 ************************************************************************ */
public class Timeprimitives {

    public static void main(String[] args) {
        int n = 100000;
        Stopwatch timer;
        double elapsedTime, freq;
        String str= "This is a test to measure the time it takes";
        int l = str.length();

        /* *****************************************************************
         * floating-point addition (double)
         ***************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n; i++) {
            double fi = i;
            double k;
            for (double j = 1; j <= n; j++) {
                k = fi + j;
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / n; // in nanoseconds   
        StdOut.println("double addition:" + "\t" + freq + " nanoseconds");


        /* *****************************************************************
         * floating-point multiplication (double)
         ***************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n; i++) {
            double fi = i;
            double k;
            for (double j = 1; j <= n; j++) {
                k = fi * j;
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / n; // in nanoseconds
        StdOut.println("double multiply: " + "\t" + freq + " nanoseconds");

        /* ******************************************************************
         * Math.sqrt() time
         ****************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n/10; i++) {
            double k;
            for (double j = 1; j <= n; j++) {
                k = Math.sqrt(j);
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / n * 10.0;
        StdOut.println("Math.sqrt(j) time: " + "\t" + freq + " nanoseconds");

        /* ******************************************************************
         * Math.log() time
         ****************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n/10; i++) {
            double k;
            for (double j = 1; j <= n; j++) {
                k = Math.log(j);
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / n * 10.0;
        StdOut.println("Math.log(j) time: " + "\t" + freq + " nanoseconds");

        /* ******************************************************************
         * Math.sin() time
         ****************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n/100; i++) {
            double k;
            for (double j = 0; j <= n; j++) {
                k = Math.sin(j);
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / n * 100.0;
        StdOut.println("Math.sin(j) time: " + "\t" + freq + " nanoseconds");

        /* *****************************************************************
         * String lenght() time
         ***************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                l = str.length();
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / n;
        StdOut.println("str.length() time: " + "\t" + freq + " nanoseconds");

        /* *****************************************************************
         * String charAt() time
         ***************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n; i++) {
            char c;
            for (int j = 0; j < l; j++) {
                c = str.charAt(j);
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / l;
        StdOut.println("str.charAt() time: " + "\t" + freq + " nanoseconds");

        /* *****************************************************************
         * String subString() time
         ***************************************************************** */
        timer = new Stopwatch();
        for (int i = 1; i <= n; i++) {
            String substr;
            for (int j = 0; j < l; j++) {
                substr = str.substring(j);
            }
        }
        elapsedTime = timer.elapsedTime();
        freq = 1.0E9 * elapsedTime / n / l;
        StdOut.println("str.substring() time: " + "\t" + freq + " nanoseconds");
    }   
    


}
