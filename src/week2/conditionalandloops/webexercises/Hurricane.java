package week2.conditionalandloops.webexercises;
/*
 * Write a program Hurricane.java that that takes the wind speed (in miles per hour)
 * as an integer command-line argument and prints whether it qualifies as a hurricane,
 * and if so, whether it is a Category 1, 2, 3, 4, or 5 hurricane. 
 * 
 * Below is a table of the wind speeds according to the Saffir-Simpson scale.
 * 
 * Category	Wind Speed (mph)
 *    1	      74 - 95
 *    2	      96 - 110
 *    3	      111 - 130
 *    4	      131 - 155
 *    5	      155 and above
 * 
 */

public class Hurricane {
    public static void main(String[] args) {
        int windSpeed = 160;

        if (windSpeed > 154) System.out.println("Category 5");
        else if (windSpeed > 130) System.out.println("Category 4");
        else if (windSpeed > 110) System.out.println("Category 3");
        else if (windSpeed > 95) System.out.println("Category 2");
        else if (windSpeed > 73) System.out.println("Category 1");
        else System.out.println("Normal wind speed");
    }
    
}
