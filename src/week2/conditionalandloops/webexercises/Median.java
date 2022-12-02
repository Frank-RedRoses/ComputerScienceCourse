package week2.conditionalandloops.webexercises;
/*********************************************************************
 * Write a program that takes five integer command-line arguments and 
 * prints the median (the third largest one).
 * 
 ***********************************************************************/
public class Median {
    public static void main(String[] args) {
        int a = 26;
        int b = 26;
        int c = 26;
        int d = 12; 
        int e = 12;
        // By comparing the two initial values create and order minimum, medium and maximum values
        int min, min2nd, med, max2nd, max;
        // Compare any two values and get the min and max
        if (a > b) {
            min = b;
            max = a; 
        } else {
            min = a;
            max = b;
        }
        // Compare a third value and set a 2nd min position
        if (c > min) {
            if (c > max) {
                // make c the max
                min2nd = max;
                max = c;
            } else {
                min2nd = c;
            }
        } else {
            // make c the min value
            min2nd = min;
            min = c;
        }
        // Compare a fourth value and set a 2nd max position
        if (d > min2nd) {
            if (d > max) {
                // make d the max value
                max2nd = max;
                max = d;
            } else {
                max2nd = d;
            }
        } else {
            // check also for the min val
            if (d < min) {
                // make d the min and ajust the other value positions
                max2nd = min2nd;
                min2nd = min;
                min = d;
            } else {
                // make d the min2nd value
                max2nd = min2nd;
                min2nd = d;
            }
        }
        // Compare a fifth value and set the med position
        // The min and max position do not matter anymore, 
        // we are only looking for the mid position
        if (e > min2nd) {
            // check for a value between min2nd and max2nd
            if (e > max2nd) {
                med = max2nd;
            } else {
                med = e;
            }
        } else {
            med = min2nd;
        } 
        
        System.out.println("Median value = " + med);
    }
}
