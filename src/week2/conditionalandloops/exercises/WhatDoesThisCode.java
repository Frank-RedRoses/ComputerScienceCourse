package week2.conditionalandloops.exercises;
/*
 * What does the following code print out?
 * 
 * Solution: the Fibonacci sequence until the 16th digit 
 */
public class WhatDoesThisCode {
    public static void main(String[] args) {
        int f = 0, g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
