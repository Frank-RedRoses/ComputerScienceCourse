package week2.conditionalandloops.creativeexercises;


/*
 * Ramanujan's taxi. S. Ramanujan was an Indian mathematician who became famous for 
 * his intuition for numbers. When the English mathematician G. H. Hardy came to visit 
 * him in the hospital one day, Hardy remarked that the number of his taxi was 1729, 
 * a rather dull number. To which Ramanujan replied, "No, Hardy! No, Hardy! It is a 
 * very interesting number. It is the smallest number expressible as the sum of two 
 * cubes in two different ways." Verify this claim by writing a program Ramanujan.java 
 * that takes an integer command-line argument n and prints all integers less than or 
 * equal to n that can be expressed as the sum of two cubes in two different ways - find 
 * distinct positive integers a, b, c, and d such that a3 + b3 = c3 + d3. Use four nested for loops.
 * 
 * Now, the license plate 87539319 seems like a rather dull number. Determine why it's not.
 * 
 * Solution: is the smallest number expressible as the sum of two cubes in three different ways.
 * 
 *  87539319 = 167^3 + 436^3 = 228^3 + 423^3
 *  87539319 = 167^3 + 436^3 = 255^3 + 414^3
 *  87539319 = 228^3 + 423^3 = 255^3 + 414^3
 */
/******************************************************************************
 *  Compilation:  javac Ramanujan.java
 *  Execution:    java Ramanujan n
 *
 *  Prints out any number between 1 and n that can be expressed as the
 *  sum of two cubes in two (or more) different ways.
 *
 *  % java Ramanujan 1728
 *
 *  % java Ramanujan 1729
 *  1729 = 1^3 + 12^3 = 9^3 + 10^3
 *
 *  % java Ramanujan 10000
 *  1729 = 1^3 + 12^3 = 9^3 + 10^3
 *  4104 = 2^3 + 16^3 = 9^3 + 15^3
 *
 *  % java Ramanujan 100000
 *  1729 = 1^3 + 12^3 = 9^3 + 10^3
 *  4104 = 2^3 + 16^3 = 9^3 + 15^3
 *  13832 = 2^3 + 24^3 = 18^3 + 20^3
 *  39312 = 2^3 + 34^3 = 15^3 + 33^3
 *  46683 = 3^3 + 36^3 = 27^3 + 30^3
 *  32832 = 4^3 + 32^3 = 18^3 + 30^3
 *  40033 = 9^3 + 34^3 = 16^3 + 33^3
 *  20683 = 10^3 + 27^3 = 19^3 + 24^3
 *  65728 = 12^3 + 40^3 = 31^3 + 33^3
 *  64232 = 17^3 + 39^3 = 26^3 + 36^3
 *
 *  % java Ramanujan 100000000 | sort -n   // sort results numerically in Unix
 *  1729 = 1^3 + 12^3 = 9^3 + 10^3
 *  ...
 *  87539319 = 167^3 + 436^3 = 228^3 + 423^3
 *  87539319 = 167^3 + 436^3 = 255^3 + 414^3
 *  87539319 = 228^3 + 423^3 = 255^3 + 414^3
 *  ...
 *
 *  Bugs
 *  ----
 *  If a number can be expressed as a sum of cubes in more than two
 *  different ways, the program prints some duplicates.
 *
 ******************************************************************************/

public class Ramanujan {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);

        // increase i, stops when i^3 is greater than num
        for (int i = 1; i <= num; i++) {
            int a3 = i*i*i;
            if (a3 > num) break;
            // increase j, stops when i^3 + j^3 is greater than num
            for (int j = i; j <= num ; j++) {
                int b3 = j*j*j;
                if (a3 + b3 > num) break;
                // initialize k to i+1 to avoid doing a previous sum on right side
                // increase k until k^3 is greater than the sum of the left side (a^3 + b^3)
                for (int k = i + 1; k <= num; k++) {
                    int c3 = k*k*k;
                    if (c3 > a3 + b3) break;
                    // increase l until k^3 + l^3 is greater than a^3 + b^3
                    for (int l = k; l <= num; l++) {
                        int d3 = l*l*l;
                        if (c3 + d3 > a3 + b3) break;

                        if (a3 + b3 == c3 + d3) {
                            System.out.print((a3 + b3) + " equals "); 
                            System.out.println(i + "^3 + " + j + "^3 = " + k + "^3 + " + l + "^3");
                        }
                    }
                }
            }
        }
    }
}
