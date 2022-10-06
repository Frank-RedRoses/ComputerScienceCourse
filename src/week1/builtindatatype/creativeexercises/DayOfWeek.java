package week1.builtindatatype.creativeexercises;
/*
 * Day of the week. Write a program DayOfWeek.java that takes a date as input 
 * and prints the day of the week that date falls on. Your program should take 
 * three command-line arguments: m (month), d (day), and y (year). 
 * For m use 1 for January, 2 for February, and so forth. 
 * For output print 0 for Sunday, 1 for Monday, 2 for Tuesday, and so forth. 
 * Use the following formulas, for the Gregorian calendar (where / denotes integer division):
 * 
 *      y0 = y − (14 − m) / 12
 *      x = y0 + y0 / 4 − y0 / 100 + y0 / 400
 *      m0 = m + 12 × ((14 − m) / 12) − 2
 *      d0 = (d + x + 31m0 / 12) mod 7
 * 
 * For example, on which day of the week did February 14, 2000 fall?
 *      y0 = 2000 - 0 = 1999
 *      x = 1999 + 1999/4 - 1999/100 + 1999/400 = 2483
 *      m0 = 2 + 12*1 - 2 = 12
 *      d0 = (13 + 2483 + (31*12) / 12) mod 7 = 2528 mod 7 = 1  (Monday)
 *
 */

 /**
 * Read in the month (m), day (d), and year (y) and print out what
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
  */

public class DayOfWeek {

    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 /400;
        int m0 = month +12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;

        System.out.println("Day of the week = " + d0);
    }
    
}
