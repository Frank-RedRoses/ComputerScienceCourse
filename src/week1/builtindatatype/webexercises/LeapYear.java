package week1.builtindatatype.webexercises;
/*
 * What happens if you compile LeapYear.java and execute it with
 *  java LeapYear
 *  java LeapYear 1975.5
 *  java LeapYear -1975
 *  java LeapYear 1975 1976 1977
 * 
 * Solution:
 *  java LeapYear                   // Error: java.lang.ArrayIndexOutOfBoundsException: 0
 *  java LeapYear 1975.5            // Error :java.lang.NumberFormatException: For input string: "1975.5"
 *  java LeapYear -1975             // false
 *  java LeapYear 1975 1976 1977    // false
 */

public class LeapYear {

    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        boolean isLeapYear;

        // divisible by 4 but not 100
        isLeapYear = (year % 4 == 0) && (year % 100 != 0);
        // or divisible by 400
        isLeapYear = isLeapYear || (year % 400 == 0);

        System.out.println(isLeapYear);
    }
    
}
