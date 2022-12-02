package week2.conditionalandloops.webexercises;
/********************************************************************
 * Write a program using a loop and four conditionals to print
 *  12 midnight
 *  1am
 *  2am
 *  ...
 *  12 noon
 *  1pm
 *  ...
 *  11pm
 *
 ******************************************************************/

public class HoursOfTheDay {
    public static void main(String[] args) {
        String time = "";

        for (int i = 0; i < 24; i++) {
            int hour = i%12;

            if (i == 0) {
                time = "12 midnight";
            } else if (i == 12){
                time = "12 noon";
            } else if (i > 11) {
                time = hour + "pm";
            } else {
                time = hour + "am";
            }
            System.out.println(time);
        }
    }
    
}
