package week1.builtindatatype.webexercises;

public class DivideByZero {

    public static void main(String[] args) {

        // int i = 17;
        double d = 17.0;

        // int intDivByZero = i / 0;       // Error: Result in a java.lang.ArithmeticException: / by zero
        // int modByZero = i % 0;          // Error: Result in a java.lang.ArithmeticException: / by zero
        double douDivByZero = d / 0.0;     // Result in Infinity
        double douModOfZero = d % 0.0;     // Result in NaN

        System.out.println(douDivByZero);
        System.out.println(douModOfZero);
    }
    
}
