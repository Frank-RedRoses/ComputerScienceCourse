package week1.builtindatatype.webexercises;

/*
 * Body mass index. The body mass index (BMI) is the ratio of the weight of 
 * a person (in kilograms) to the square of the height (in meters). 
 * 
 * Write a program BMI.java that takes two command-line arguments, weight and 
 * height, and prints the BMI.
 */

public class BMI {
    
    public static void main(String[] args) {
        double weightKg = Double.parseDouble(args[0]); 
        double heightMts = Double.parseDouble(args[1]);

        double bodyMassIndex = weightKg / (heightMts*heightMts);

        System.out.println("BMI = " + bodyMassIndex);
    }
}
