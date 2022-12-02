package week2.conditionalandloops.creativeexercises;
/*********************************************************************
 * Trigonometric functions. Write two programs Sin.java and Cos.java 
 * that compute sin x and cos x using the Taylor series expansions
 * 
 * sinx = x − x^3/3! + x^5/5! − x^7/7! + ... 
 * cosx = 1 − x^2/2! + x^4/4! − x^6/6! + ...
 * 
 **********************************************************************/

public class Cos {

    public static void main(String[] args) {
        // double x = Double.parseDouble(args[0]);
        double x = Math.PI;

        // transform x to an angle between 0.00 and 2*PI, both positive and negative. 
        x = x % (2*Math.PI);

        double term = 1.00;
        double sum = 1.00;

        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 0) sum += term;     // multiples of 4 gonna add the term
            if (i % 4 == 2) sum -= term;     // mod = 2 for multiples of two that substract the term
        }

        System.out.printf("Java Math library: %.15f%n", Math.cos(x));
        System.out.printf("Taylor expansions: %.15f%n", sum);





    }
    
}
