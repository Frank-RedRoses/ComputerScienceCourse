package week1.builtindatatype.webexercises;

/*
 * Fibonacci word. Write a program FibonacciWord.java that prints the Fibonacci word 
 * of order 0 through 10. f(0) = "a", f(1) = "b", f(2) = "ba", f(3) = "bab", 
 * f(4) = "babba", and in general f(n) = f(n-1) followed by f(n-2). 
 * 
 * Use string concatenation.
 */

public class FibonacciWord {

    public static void main(String[] args) {
        String order0 = "a";
        String order1 = "b";
        String order2 = order1 + order0;
        String order3 = order2 + order1;
        String order4 = order3 + order2;
        String order5 = order4 + order3;
        String order6 = order5 + order4;
        String order7 = order6 + order5;
        String order8 = order7 + order6;
        String order9 = order8 + order7;
        String order10 = order9 + order8;

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println(order4);
        System.out.println(order5);
        System.out.println(order6);
        System.out.println(order7);
        System.out.println(order8);
        System.out.println(order9);
        System.out.println(order10);
    }
    
}
