package week2.conditionalandloops.webexercises;
/******************************************************************************
 *  Compilation:  javac DayOfWeek.java
 *  Execution:    java DayOfWeek m d y
 *
 *  Read in the month (m), day (d), and year (y) and print out what
 *  day of the week it falls on according to the Gregorian calendar.
 *  For M use 1 for January, 2 for February, and so forth. Outputs
 *  0 for Sunday, 1 for Monday, and so forth.
 *
 *        y0 = y - (14 - m) / 12
 *        x = y0 + y0/4 - y0/100 + y0/400
 *        m0 = m + 12 * ((14 - m) / 12) - 2
 *        d = (d + x + (31*m0)/12) mod 7
 *
 *
 *  % java DayOfWeek 8 2 1953      // August 2, 1953
 *  0                              // Sunday
 *
 *  % java DayOfWeek 1 1 2000      // January 1, 2000
 *  6                              // Saturday
 *
 ******************************************************************************/

public class DayOfTheWeek {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        String dayOfTheWeek = "";

        int year0 = year - (14 - month) / 12;
        int x = year0 + year0/4 - year0/100 + year0/400;
        int month0 = month + 12 * ((14 -month) / 12) - 2;
        int day0 = (day + x + (31 * month0) / 12) % 7;

        switch (day0) {
            case 0:
                dayOfTheWeek ="Sunday";
                break;
            case 1:
                dayOfTheWeek ="Monday";
                break;
            case 2:
                dayOfTheWeek ="Tuesday";
                break;
            case 3:
                dayOfTheWeek ="Wednesday";
                break;
            case 4:
                dayOfTheWeek ="Thursday";
                break;
            case 5:
                dayOfTheWeek ="Friday";
                break;
            case 6:
                dayOfTheWeek ="Saturday";
                break;
            default:
                dayOfTheWeek = "Error";
                break;
        }
        
        System.out.println(dayOfTheWeek);
    }
    
}
