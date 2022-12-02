package week2.conditionalandloops.creativeexercises;


/******************************************************************************
 *  Compilation:  javac ISBN.java
 *  Execution:    java ISBN n
 *
 *  Determines the check digit of an ISBN-10 number given the first 9 digits.
 *
 *  An ISBN-10 number is valid if it consists of 10 digits and
 *  d_1 + 2*d_2 + 3*d_3 + ... + 10*d_10 is a multiple of 11.
 * (The d_i position denotes the ith digit from right to left)
 *  For example, 0-201-31452-5 is valid since
 *  1*5 + 2*2 + 3*5 + 4*4 + 5*1 + 6*3 + 7*1 + 8*0 + 9*2 + 10*0 = 88
 *  and 88 is a multiple of 11.
 *
 *  % java ISBN 013407642
 *  The full ISBN number is 0134076427
 *
 *  % java ISBN 067233784
 *  The full ISBN number is 0672337843
 *
 *  % java ISBN 032157351
 *  The full ISBN number is 032157351X
 *
 ******************************************************************************/
public class ISBN {
    public static void main(String[] args) {
        // String num9digit = "032157351";
        String num9digit = args[0];
        String isbn = "";
        int checksum = 0;
    
        for (int i = 0; i < num9digit.length(); i++) {
            int digit = Character.getNumericValue(num9digit.charAt(i)); // It does the sum in reverse order from left to right
            checksum += (num9digit.length() - i + 1)*digit;             // starts at 10*d_10
            isbn += (i == 0 || i == 4) ? digit + "-" : digit;           // Creates a string isbn number with dashes
        }
        checksum = 11 - checksum%11;        // mod 11 of the sum and substract that to 11 give us the difference to the next multiple of 11.

        System.out.print("The full ISBN10 number is: " + isbn);
        if (checksum == 10) {
            System.out.println("-X");
        } else if (checksum == 11) {
            System.out.println("-0");
        }
        else {
            System.out.println("-" + checksum);
        }

        /* Another way to do it
        // read in one command-line argument
        int n = Integer.parseInt(args[0]);

        // compute the weighted sum of the digits, from right to left
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
            int digit = n % 10;                // rightmost digit
            sum = sum + i * digit;
            n = n / 10;
        }
        // print out check digit, use X for 10
        System.out.print("The full ISBN number is " + args[0]);
        if      (sum % 11 == 1) System.out.println("X");
        else if (sum % 11 == 0) System.out.println("0");
        else                    System.out.println(11 - (sum % 11));
        */

    }
}
