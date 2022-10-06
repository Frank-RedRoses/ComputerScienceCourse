package week1.builtindatatype.exercises;
/**
 * Write a program SumOfTwoDice.java that prints the sum of two random integers 
 * between 1 and 6 (such as you might get when rolling dice).
 */
public class SumOfTwoDice {

    public static void main(String[] args) {
        int sides = 6;
        int dice1 = (int) (Math.random() * sides) + 1;
        int dice2 = (int) (Math.random() * sides) + 1;
        int sum = dice1 + dice2;
        System.out.println("The sum of two random integers between 1 and 6 = " + sum);
    }
    
}
