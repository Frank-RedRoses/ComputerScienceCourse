package week1.builtindatatype.exercises;

/* 
 * Suppose that a and b are int values. What does the following sequence of statements do?
 */ 

public class WhatItDoes {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int t = a;
        b = t;
        a = b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    
}

/**
 * Solution: Sets a, b and t  equal to the same original value of a. 
 */