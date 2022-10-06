package week1.builtindatatype.creativeexercises;

/*
 * Uniform random numbers. Write a program Stats5.java that prints five 
 * uniform random values between 0 and 1, their average value, and their 
 * minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
 */

 /**********************************************************************************
 *  Generate and print 5 random values between 0.0 and 1.0, and print
 *  their average value, min value, and max value.
 *
 *  % java Stats5
 *
 *  0.7203537279117841
 *  0.09574435157738448
 *  0.8979741693231866
 *  0.11949032184355113
 *  0.23425519545397544
 *  Average = 0.4135635532219763
 *  Min     = 0.09574435157738448
 *  Max     = 0.8979741693231866
 *
 *  % java Stats5
 *  0.25523821773554134
 *  0.6577131932424987
 *  0.14170223533941984
 *  0.2653444869526621
 *  0.895374957216799
 *  Average = 0.44307461809738424
 *  Min     = 0.14170223533941984
 *  Max     = 0.895374957216799
  ************************************************************************************/

public class Stats5 {

    public static void main(String[] args) {
        int n = 5;
        double value1 = Math.random();
        double value2 = Math.random();
        double value3 = Math.random();
        double value4 = Math.random();
        double value5 = Math.random();

        System.out.println("Value 1 = " + value1);
        System.out.println("Value 2 = " + value2);
        System.out.println("Value 3 = " + value3);
        System.out.println("Value 4 = " + value4);
        System.out.println("Value 5 = " + value5);

        double average =  (value1 + value2 + value3 + value4 + value5) / n;
        double min = Math.min(value1, Math.min(value2, Math.min(value3, Math.min(value4, value5))));
        double max = Math.max(value1, Math.max(value2, Math.max(value3, Math.max(value4, value5))));

        System.out.println("Average = " + average);
        System.out.println("Minimum = " + min);
        System.out.println("Maximum = " + max);
    }
    
}
