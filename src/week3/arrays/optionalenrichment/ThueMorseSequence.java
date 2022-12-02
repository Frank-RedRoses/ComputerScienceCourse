package week3.arrays.optionalenrichment;

/*****************************************************************************
 * Thue–Morse sequence.
 * Write a program ThueMorseSequence.java that takes an integer command-line 
 * argument n and prints the Thue–Morse sequence until the n value.
 * 
 * The Thue–Morse sequence is an infinite sequence of 0s and 1s that is constructed 
 * by starting with 0 and successively appending the bitwise negation (interchange 0s and 1s) 
 * of the existing sequence. Here are the first few steps of this construction:
 * 0
 * 01
 * 0110
 * 01101001
 * 0110100110010110
 * 
 ********************************************************************************/

public class ThueMorseSequence {

    public static void main(String[] args) {
        int n = 12;
        int level = 1;
        int power2 = 2;
        while (power2 < n) {
            level++;
            power2 *= 2;
        }

        // String complete sequence
        String seq = "0";
        String reverse = "1";
        for (int i = 0; i < level; i++) {
            String s = seq;
            String r = reverse;
            seq += r;
            reverse += s;
        }
        System.out.println(seq);

        // Array boolean complete sequence
        boolean[] thueMorse = new boolean[power2];
        for (int base2 = 1; base2 < power2; base2 *= 2) {
            for (int i = 0; i < base2; i++) {
                if (!thueMorse[i]) thueMorse[base2 + i] = true;
                else thueMorse[base2 + i] = false;
            }
        }
        // print values inside array complete sequence
        for (int i = 0; i < thueMorse.length; i++) {
            if (thueMorse[i]) System.out.print("1");
            else System.out.print("0");
        }
        System.out.println();

        // Boolean array until the nth value
        boolean[] thueMorseLengthN = new boolean[n];
        for (int base2 = 1; base2 < n; base2 *= 2) {
            for (int i = 0; i < base2 && base2 + i < n; i++) {
                if (!thueMorseLengthN[i]) thueMorseLengthN[base2 + i] = true;
                else thueMorseLengthN[base2 + i] = false;
            }
        }
        // print array's contend
        for (int i = 0; i < thueMorseLengthN.length; i++) {
            if (thueMorseLengthN[i]) System.out.print("1");
            else System.out.print("0");
        }
        System.out.println();
    }
}