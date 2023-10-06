package week7.performance.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;

/*
 * 4.1.33 Array rotation. 
 * Given an array of n elements, give a linear-time algorithm to rotate the 
 * array k positions. That is, if the array contains a[0], a[1], …, a[n–1], 
 * the rotated array is a[k], a[k+1], …, a[n–1], a[0], …, a[k–1]. 
 * Use at most a constant amount of extra memory. 
 * 
 * Hint : Reverse three subarrays.
 * 
 */
public class ArrayRotation {
    
    // Rotate the array k positions to the left using constant amount 
    // of extra memory.
    public static void rotateArray(int[] arr, int k) {
        int offset = k % arr.length; // in case of k > array size
        // inverse all the array
        inverseArray(arr);
        // inverse the array from index 0 to index (array size - k)  
        inverseArray(arr, 0, arr.length - offset); 
        // inverse the array the last k positions
        inverseArray(arr, arr.length - offset, arr.length);
    }

    // inverse the order of the values in the given array using constant
    // amount of memory.
    private static void inverseArray(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < (n / 2); i++) { // only iterates half of the array
            temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    // inverse the order of the values of the subarray [beginIndex, endIndex) 
    // of the give array, using constant amount of memory.
    private static void inverseArray(int[] arr, int beginIndex, int endIndex) {
        int temp;
        for (int i = 0; i < (endIndex - beginIndex) / 2; i++) {
            temp = arr[beginIndex + i];
            arr[beginIndex + i] = arr[endIndex - i - 1];
            arr[endIndex - i - 1] = temp;
        }
    }

    // print the given array
    private static void printArray(int[] arr) {
        StdOut.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            StdOut.print(arr[i] + ", ");
        }
        StdOut.println(arr[arr.length - 1] + "]");
    }

    public static void main(String[] args) {
        // get a command-line argument to rotate the array
        int k = Integer.parseInt(args[0]);
        k = 9;
        // create an array with integers from 0 to 9 in ascending order
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        } 

        printArray(numbers);
        rotateArray(numbers, k);
        printArray(numbers);
            
        
    }
    
}
