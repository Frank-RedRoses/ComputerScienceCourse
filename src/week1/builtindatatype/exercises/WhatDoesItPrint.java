package week1.builtindatatype.exercises;

public class WhatDoesItPrint {

    public static void main(String[] args) {
        System.out.println(2 + "bc");           // prints: 2bc
        System.out.println(2 + 3 + "bc");       // prints: 5bc
        System.out.println((2+3) + "bc");       // prints: 5bc
        System.out.println("bc" + (2+3));       // prints: bc5
        System.out.println("bc" + 2 + 3);       // prints: bc23
    }
    
}
