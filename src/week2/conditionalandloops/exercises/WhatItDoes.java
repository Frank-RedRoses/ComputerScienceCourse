package week2.conditionalandloops.exercises;
/*
 * What is the value of m and n after executing the following code?
 * 
 * Solution: It makes n equal 0 and inverts the order of the numbers from n
 * and assign the value to m. 
 * I.e. from n = 123456789 and m = 0 to n = 0 to m = 987654321. 
 */
public class WhatItDoes {
    public static void main(String[] args) {
        int n = 123456789;
        int m = 0;
        System.out.println("Input: n = " + n + " m = " + m);
        while (n != 0) {
            m = (10 * m) + (n % 10);
            n = n / 10;
        }
        System.out.println("m value = " + m);
        System.out.println("n value = " + n);
    }
}
