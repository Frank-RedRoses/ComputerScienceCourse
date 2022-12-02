package week2.conditionalandloops.exercises;
/*
 * Write a program RollLoadedDie.java that prints the result of rolling a 
 * loaded die such that the probability of getting a 1, 2, 3, 4, or 5 is 1/8 
 * and the probability of getting a 6 is 3/8.
 */


public class RollLoadedDie {
     /**
      * Simulate the roll of a loaded six-sided die, where the values
      *  1, 2, 3, 4, and 5 appear with probability 1/8 and the value 6
      *  appears with probablity 3/8, and print the resulting number.
      */
    public static void main(String[] args) {
        // Roll a dice for 8 sides, probability of 1/8 for each side.
        int diceSide = (int) (8.0*Math.random() + 1.0);
        // For any dice roll less than 6 is equal to its value
        if (diceSide < 6) {
            System.out.println("Roll a dice: "+ diceSide);
        } else {    // for any dice roll equal or greater than 6 the value is equal to 6.
            System.out.println("Roll a dice: 6 ");  // probability of 3/8
        }
        



    }
    
}
