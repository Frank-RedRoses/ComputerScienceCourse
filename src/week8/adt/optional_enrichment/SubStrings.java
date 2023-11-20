package week8.adt.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 * 3.1.22 Write a program that takes a start string and a stop string as 
 * command-line arguments and prints all substrings of a given string that 
 * start with the first, end with the second, and otherwise contain neither. 
 * Note: Be especially careful of overlaps!
 **************************************************************************** */
public class SubStrings {
    
    // Prints sub-strings between start and end 
    public static void subStringsBetween(String start, String end, String str) {
        int startMarker = -1;                           // stores the value of the beginning of a sub-string
        for (int i = 0; i <= str.length(); i++) {
            String subStr = str.substring(i);           // make a sub-string between i and the end of the string
            if (subStr.startsWith(start)) {
                startMarker = i; 
                i += start.length() - 1;                // move the index to the last character of the start string
            } else if (startMarker > -1 && subStr.startsWith(end)) {
                // only prints out if the start String has been found
                StdOut.println(str.substring(startMarker, i + end.length()));
                startMarker = -1;                       // resets the beginning of the sub-string
                i += end.length() - 1;                  // move the index to the last character of the end string
            }
        }
    }

    // Prints sub-strings without and outside start and end  
    public static void subStringsWithout(String start, String end, String str) {
        boolean startMarker = false;                    // marks start sub-string founded
        int startIndex = 0;                             // stores the begin value of a sub-string
        for (int i = 0; i <= str.length(); i++) {
            String subStr = str.substring(i);           // make a sub-string between i and the end of the string
            if (subStr.startsWith(start)) {
                // print everything between startIndex and the i index and outside 
                StdOut.println(str.substring(startIndex, i));
                // start string is found
                startMarker = true;
                startIndex = i + start.length();        // set the startIndex after the start string
                i += start.length() - 1;                // move the index to the last character of the start string
            } else if (subStr.startsWith(end)) {
                // only prints out if there is no start String to create a subString between start and end
                if (startMarker) StdOut.println(str.substring(startIndex, i));
                // reset the market and set the start index to the last index of the end String
                startMarker = false;
                startIndex = i + end.length();
                i += end.length() - 1;                  // move the index to the last character of the end string
            } else if (subStr.length() == 0) {
                // print the end of the string
                StdOut.println(str.substring(startIndex, i));
            }
        }
    }

    /* This program take in consideration the difference between 
    lower and upper case letters (case-sensitive)*/
    public static void main(String[] args) {
        String startStr = args[0];
        String endStr = args[1];
        String str = "Dialogue is typically a conversation between two or more " +  
        "people in a narrative work. As a literary technique, dialogue serves " + 
        "several purposes. It can advance the plot, reveal a character's " + 
        "thoughts or feeligns, or show how characters react in the moment.";

        StdOut.println("Between " + startStr + " and " + endStr + ":");
        subStringsBetween(startStr, endStr, str);

        StdOut.println("Without " + startStr + " and " + endStr + ":");
        subStringsWithout(startStr, endStr, str);
    }
}
