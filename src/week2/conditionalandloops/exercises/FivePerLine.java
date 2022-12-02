package week2.conditionalandloops.exercises;
/*
 * Write a program FivePerLine.java that, using one for loop and one
 * if statement, prints the integers from 1000 to 2000 with five 
 * integers per line. Hint: use the % operator.
 * 
 */
public class FivePerLine {
    public static void main(String[] args) {
        int start = 1000;
        int end = 2000;
        int perLine = 5;
        for (int i = start; i <= end; i++) {
            if (i % perLine == 4) System.out.println(i);
            else System.out.print(i + " ");
        }
    }
    
}
