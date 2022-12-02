package week3.arrays.assigment;

public class ThueMorse {

    public static void main(String[] args) {
        int n = 5;
        // Boolean array until the nth value
        boolean[] thueMorseN = new boolean[n];
        // Works with sequences of size equals to the powers of 2
        int power2 = 1;
        while (power2 < n) {
            // Checks the array values in the existing sequence
            // and sets the bitwise negation sequence starting at the
            // index of power2 value.
            for (int i = 0; i < power2 && (power2 + i) < n; i++) {
                if (!thueMorseN[i]) thueMorseN[power2 + i] = true;
                else thueMorseN[power2 + i] = false;
            }
            power2 *= 2;
        }

        /* print array contends for debug
        String sequence = "";
        for (int i = 0; i < thueMorseN.length; i++) {
            if (thueMorseN[i]) sequence += "1";
            else sequence += "0";
        }
        System.out.println(sequence);
        */

        /* Print the Thue-Morse n-by-n pattern
         * Create an n-by-n pattern by printing a + (plus sign) in row i and
         * column j if bits i and j in the sequence are equal, and a - (minus
         * sign) if they are different.
         */
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                if (thueMorseN[i] == thueMorseN[j]) row += "+  ";
                else row += "-  ";
            }
            System.out.println(row);
        }
    }
}
