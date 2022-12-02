package week2.conditionalandloops.webexercises;
/**
 * Number-to-English. 
 * Write a program to read in a command line integer between -999,999,999 and 
 * 999,999,999 and print the English equivalent. Here is an exhaustive list of 
 * words that your program should use: negative, zero, one, two, three, four, 
 * five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, 
 * sixteen, seventeen, eighteen, nineteen, twenty, thirty, forty, fifty, sixty, 
 * seventy, eighty, ninety, hundred, thousand, million. 
 * 
 * Don't use hundred, when you can use thousand, e.g., use one thousand five hundred 
 * instead of fifteen hundred.
 */

public class NumberToEnglish {
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        int n = 125151;
        boolean isNegative = false;
        int digits = 0;
        String numString = "";

        if (n == 0) {
            numString = "zero";
        } else if (n < 0) {
            isNegative = true;
            n = Math.abs(n);
        }

        while (n > 0) {
            int digitsMod3 = digits%3;
            int numMod10 = n%10;
            // Only add hundreds thousands and millions when they have a value. Ex: there is no hundred in 5000
            if (digitsMod3 == 2 && numMod10 != 0) numString = " hundred " + numString;   // add hundred
            else if (digits == 3 && numMod10 != 0) numString = " thousand " + numString; // add thousand
            else if (digits == 6) numString = " million " + numString;  // add million

            if (digitsMod3 == 1) {
                // add twenty-ninety string
                switch (numMod10) {
                    case 2:
                        numString = "twenty" + numString;
                        break;
                    case 3:
                        numString = "thirty" + numString;
                        break;
                    case 4:
                        numString = "forty" + numString;
                        break;
                    case 5:
                        numString = "fifty" + numString;
                        break;
                    case 6:
                        numString = "sixty" + numString;
                        break;
                    case 7:
                        numString = "seventy" + numString;
                        break;
                    case 8:
                        numString = "eighty" + numString;
                        break;
                    case 9:
                        numString = "ninety" + numString;
                        break;
                    default:
                        break; 
                }
            } else if (digitsMod3 == 0 && n%100 > 9 && n%100 < 20) {
                // add ten-nineteen string and fix the number for the next iteration
                switch (n%100) {
                    case 10:
                        numString = "ten" + numString;
                        break;
                    case 11:
                        numString = "eleven" + numString;
                        break;
                    case 12:
                        numString = "twelve" + numString;
                        break;
                    case 13:
                        numString = "thirteen" + numString;
                        break;
                    case 14:
                        numString = "fourteen" + numString;
                        break;
                    case 15:
                        numString = "fifteen" + numString;
                        break;
                    case 16:
                        numString = "sixteen" + numString;
                        break;
                    case 17:
                        numString = "seventeen" + numString;
                        break;
                    case 18:
                        numString = "eighteen" + numString;
                        break;
                    case 19:
                        numString = "nineteen" + numString;
                        break;
                    default:
                        break;
                }
                // ajust the number to a two digits value 
                n  = n/10;
                digits++;
            } else {
                // add one to nine
                switch (numMod10) {
                    case 1:
                        numString = "one" + numString;
                        break;
                    case 2:
                        numString = "two" + numString;
                        break;
                    case 3:
                        numString = "three" + numString;
                        break;
                    case 4:
                        numString = "four" + numString;
                        break;
                    case 5:
                        numString = "five" + numString;
                        break;
                    case 6:
                        numString = "six" + numString;
                        break;
                    case 7:
                        numString = "seven" + numString;
                        break;
                    case 8:
                        numString = "eight" + numString;
                        break;
                    case 9:
                        numString = "nine" + numString;
                        break;
                    default:
                        break;
                } 
            }

            n = n/10;
            digits++;
            // special case for a hyphen in 2 digits value. Ex: 36 Thirty-six
            if (digits%3 == 1 && n != 0 && n%10 != 0 && numMod10 != 0) numString = "-" + numString;
        }
        // Print the value string
        if (isNegative) {
            System.out.println("The number is: negative " + numString);
        } else {
            System.out.println("The number is: " + numString);
        }
    }
    
}
