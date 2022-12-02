package week2.conditionalandloops.exercises;
/*
 * Write a program FunctionGrowth.java that prints a table of the values of
 * ln(n), n, n*ln(n), n^2, n^3, and 2^n for n = 16, 32, 64, ..., 2048. 
 * Use tabs ('\t' characters) to line up columns.
 */
public class FunctionGrowth {
    public static void main(String[] args) {
        System.out.println("log(n) \tn \tn*log(n) \tn^2 \t\tn^3 \t\t2^n");
        for (long i = 16; i <= 2048; i *= 2) {
            double logN = Math.log(i);
            double twoPowerofI = Math.pow(2, i);
            System.out.printf("%.2f", logN);
            System.out.printf("\t%d", i);
            System.out.printf("\t%-8.1f", i*logN);
            System.out.printf("\t%-8d", i*i);
            System.out.printf("\t%-8d", i*i*i);
            System.out.printf("\t%-8d", (long) twoPowerofI);
            System.out.println();
        }
    }
}
