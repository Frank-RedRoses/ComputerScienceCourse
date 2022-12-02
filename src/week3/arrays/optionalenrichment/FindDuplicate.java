package week3.arrays.optionalenrichment;
/**********************************************************************
 * Find a duplicate. Given an integer array of length n, with each value 
 * between 1 and n, write a code fragment to determine whether there are 
 * any duplicate values. You may not use an extra array (but you do not 
 * need to preserve the contents of the given array.)
 * 
 */

public class FindDuplicate {
    public static void main(String[] args) {
        /*
        int[] arr = {15, 10, 7, 16, 12, 17, 8, 1, 11, 2, 
                      20, 4, 14, 6, 9, 13, 18, 3, 19, 5}; 
        */
        // Create a random array with values between 1 and n
        int n = 20;
        int[] arr = new int[n]; 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*n) + 1;
        }
        
        // Print the initial array
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%02d ", arr[j]);
            if ((j + 1) % 10 == 0) System.out.println();
        }
        System.out.println();
        
        // An array size N without a duplicated values contains every value from 1 to N.
        // The idea is to use the array index to order the values to the corresponding index 
        // if the index already contains its corresponding value the swaping value is duplicated.
        int i = 0;
        boolean isDuplicated = false;
        // While is not duplicated and the index is less than arr[] length
        while (!isDuplicated && i < arr.length) {
            // arr[i] = any number between 1 and n, subtract 1 to get the swaping index of the value
            int swapIndex = arr[i] - 1;
            if (swapIndex == i) {
                // arr[i] already have its corresponding value, increase i
                i++;
            } else if (swapIndex < i || arr[swapIndex] <= i || arr[swapIndex] == swapIndex + 1) {
                // swapIndex value < i, the value has been already sorted.
                // arr[swapIndex] is less or equal to i, arr[swapIndex] value is already sorted.
                // arr[swapIndex] == swapping value, there is already a value in the index so it's repeated.
                isDuplicated = true;
            } else {
                // swap the values 
                int temp = arr[swapIndex];
                arr[swapIndex] = swapIndex + 1;   // corresponding value = swap index + 1
                arr[i] = temp;
                /*
                // for debugging
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("%02d ", arr[j]);
                    if ((j + 1) % 10 == 0) System.out.println();
                }
                System.out.println(); 
                */
            }
        }

        if (isDuplicated) System.out.println("The value " + arr[arr[i] - 1] + " is duplicated");
        else              System.out.println("No duplicated values.");

    }
}
