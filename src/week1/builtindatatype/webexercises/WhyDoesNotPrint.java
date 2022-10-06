package week1.builtindatatype.webexercises;

/*
 * Why doesn't the following program print 4294967296 = 2^32?
 * 
 *      int x = 65536;
 *      long y = x * x;
 *      System.out.println(y);
 * 
 *  Solution: The product of x is computed as an int, but it overflows the maximum 32 bit
 *  value of 2^31 - 1 for an integer (max positive int 2,147,483,647), before it gets 
 *  converted to long.
 */

public class WhyDoesNotPrint {

    public static void main(String[] args) {
        // int maxInt = 2147483647;
        // double y = Math.pow(2, 31);]
        int x = 65536;
        long y = x * x;
        System.out.println(y); // prints 0
    }
}
