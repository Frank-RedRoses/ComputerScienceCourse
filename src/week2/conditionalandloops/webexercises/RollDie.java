package week2.conditionalandloops.webexercises;

/********************************************************************
 * Write a program RollDie.java that generates the result of rolling 
 * a fair six-sided die (an integer between 1 and 6).
 *********************************************************************/

 /**********************************************************************
 *  Compilation:  javac RollDie.java
 *  Execution:    java RollDie
 *
 *  Simulate the roll of a fair six-sided die
 *  and print the resulting number.
 *
 *  % java RollDie
 *  4
 *
 *  % java RollDie
 *  1
 *
 ******************************************************************************/
public class RollDie {
    
    public static void main(String[] args) {
        int SIDES = 6;
        int die = (int) (SIDES*Math.random()) + 1;
        System.out.println("d6 dice = " + die);

    }
}
