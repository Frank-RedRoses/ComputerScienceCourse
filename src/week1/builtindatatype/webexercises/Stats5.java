package week1.builtindatatype.webexercises;

public class Stats5 {

    public static void main(String[] args) {
        int n = 5;
        double val1 = Math.random();
        double val2 = Math.random();
        double val3 = Math.random();
        double val4 = Math.random();
        double val5 = Math.random();

        // Prints 5 values
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);
        System.out.println(val5);

        // Computes stats
        double average = (val1 + val2 + val3 + val4 + val5) / n;
        double minimum = Math.min(val1, Math.min(val2, Math.min(val3, Math.min(val4, val5))));
        double maximum = Math.max(val1, Math.max(val2, Math.max(val3, Math.max(val4, val5))));
        double sqrDiff = Math.pow(val1 - average, 2);
        sqrDiff += Math.pow(val2 - average, 2);
        sqrDiff += Math.pow(val3 - average, 2);
        sqrDiff += Math.pow(val4 - average, 2);
        sqrDiff += Math.pow(val5 - average, 2);
        double stdDev = Math.sqrt(sqrDiff/n);
        
        // Prints stats
        System.out.println("Average            = " + average);
        System.out.println("Min                = " + minimum);
        System.out.println("Max                = " + maximum);
        System.out.println("Standard deviation = " + stdDev);
    }
    
}
