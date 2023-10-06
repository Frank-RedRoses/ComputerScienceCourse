package week7.performance.optional_enrichment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


/* *
 *  4.1.34. Finding a repeated integer. 
 * (a) Given an array of n integers from 1 to n with one value repeated
 * twice and one missing, design an algorithm that finds the duplicated 
 * value, in linear time and constant extra memory. Integer overflow is 
 * not allowed. 
 * (b) Given a read-only array of n integers, where each value from 1 to
 * n–1 occurs once and one occurs twice, design an algorithm that finds
 * the duplicated value, in linear time and constant extra memory. 
 * (c) Given a read-only array of n integers with values between 1 and n–1,
 * design an algorithm that finds a duplicated value, in linear time and
 * constant extra memory.
 */

public class RepeatedInteger {

    // Solution to problem (a) using negative values:
    /* **************************************************
     * Only works with arrays containing only positive numbers
     * This approach modifies the array contents changing the values
     * to negative when the index has been visited.
     * Time Complexity: O(n), Auxiliary Space: O(1).
     */
    public static void findDuplicate(int[] nInts) {
        StdOut.print("Duplicate value using index negative value: ");
        // iterate through the array
        for (int i = 0; i < nInts.length; i++) {
            // get the value in the index i position
            int absVal = Math.abs(nInts[i]); // absolute value to prevent calling a negative index
            // visit the arr[arr[i]] position
            if (nInts[absVal - 1] > 0) // the array contains integers from 1 to n (subtract 1 to check the
                                       // corresponding index).
                // positive values has been not visited yet, change the value to negative.
                nInts[absVal - 1] = -nInts[absVal - 1];
            else {
                // a negative value has been previously visited and is repeated.
                StdOut.println(absVal);
                return; // end of the search.
            }
        }
    }

    // ***It's not working, needs to be fixed****
    // Another solution to problem (a) using XOR
    /* ************************************************
     * Follow the below steps to solve the problem:
     * Compute XOR of elements from 1 to n-1.
     * Compute XOR of array elements.
     * XOR of the above two would be our result.
     * Time Complexity: O(n), Auxiliary Space: O(1).
     */
    public static void findDuplicateWithXOR(int[] nInts) {
        int n = nInts.length;
        // res is going to store value of
        // 1 ^ 2 ^ 3 .. ^ (N-1) ^ arr[0] ^
        // arr[1] ^ .... arr[n-1]
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = res ^ (i + 1) ^ nInts[i];
        }
        res = res ^ nInts[n - 1];
        StdOut.println(res);
    }

    // Solution to (a) using the mod.
    /* ***************************************************************
     * Another solution to (a) using the mod to add n times
     * the repeated value appears. This approach modifies the array.
     * This solution works for several repeated values.
     * Time Complexity: O(n), Auxiliary Space: O(1).
     */
    public static void findDuplicateMod(int[] numRay) {
        int n = numRay.length;
        // iterate through the array
        for (int i = 0; i < n; i++) {
            // add n to the value on position numRay[i] % n
            numRay[numRay[i] % n] = numRay[numRay[i] % n] + n;
            /* Explanation:
             * adding n will not change the mod of a value.Ex:
             * n = 10
             * numRay[3] = 5
             * numRay[3] % 10 = 5
             * numRay[numRay[3] % 10] = 7
             * numRay[numRay[3] % 10] + 10 = 17
             * numRay[numRay[3] % 10] % 10 = 7
             * numRay[numRay[3] % 10] + 10 = 27
             * numRay[numRay[3] % 10] % 10 = 7
             ********************************************/
        }
        System.out.print("Using mod the repeating elements are: ");
        /* Traverse the array again and the indexes with arr[i]/n > 1
         * are those that have been visited more than once, meaning
         * i is repeated.
         */
        for (int i = 0; i < n; i++) {
            /* Explanation:
             * if numRay[5] = 27, then numRay[5] / 10 = 2,
             * which means 2 > 1 so 5 is repeated,
             * or also 27 >= 20 means repeated.
             */
            if (numRay[i] >= n * 2)
                System.out.print(i + " ");
        }
        StdOut.println();
    }

    // Solution to problem(b) using the sum of first N elements:
    /*
     * *******************************************************
     * (Note: This approach causes overflow for large arrays)
     * Knowing that the sum of the first n natural number is:
     * (n * (n - 1)) / 2
     * Compute the sum of the array elements and subtract the
     * natual number sum to find the difference, which is the
     * repeated number.
     */
    public static void findDuplicatedWithSumOfN(int[] readOnlyArray) {
        int n = readOnlyArray.length;
        // The problem stablishes that the array contains the numbers
        // from 1 to n-1 and one repeated number.
        long naturalSum = (n - 1) * n / 2;
        long arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum = arrSum + readOnlyArray[i];
        }
        StdOut.println("Repeated value in a read-only array using Sum of N:");
        // repeated value = sum array values - natural sum.
        StdOut.println(arrSum - naturalSum);
    }

    // Solution to problem(c) using Floyd's tortoise & hare algorithm
    /* **************************************************************
     * The array must contain values between 1 and n–1, this translate to
     * inside the array has to be at least one number repeated to fill 
     * all of the array's indexes.
     * Use the function f(x) = arr[x] to construct the sequence:
     * arr[0], arr[arr[0]], arr[arr[arr[0]]], arr[arr[arr[arr[0]]]] ……. 
     * Each new element in the sequence is an element in arr[] at the 
     * index of the previous element.
     * Starting from x = arr[0], it will produce a linked list with a cycle.
     * The cycle appears because arr[] contains duplicate elements
     * (at least one). The duplicate value is an entrance to the cycle. 
     * For Example: Let the array arr[] = {2, 6, 4, 1, 3, 1, 5}   
     * Starting from index 0, the traversal looks as follows: 
     * arr[0] = 2 –> arr[2] = 4 –> arr[4] = 3 –> arr[3] = 1 
     * –> arr[1] = 6 –> arr[6] = 5 –> arr[5] = 1.
     */
    public static void findDuplicatedFloydCycle(int[] readOnlyArray) {
        int slowP = readOnlyArray[0]; // single step pointer
        int fastP = readOnlyArray[0]; // double step pointer

        while (true) {
            slowP = readOnlyArray[slowP]; // move by one step at the time
            fastP = readOnlyArray[readOnlyArray[fastP]]; // move by two steps
            /* Explanation:
             * Repeated numbers create a cycle, since the fastP goes fast,
             * it would be the first one who enters the cycle and starts to
             * run around the cycle.
             * At some point, the slowP enters the cycle as well, and since
             * it’s moving slower the fastP catches the slowP up at some
             * intersection point.
             * Note that the intersection point is not the cycle entrance
             * in the general case, but the two intersect at somewhere
             * middle in cycle.
             */
            if (slowP == fastP)
                break; // colision point
        }
        // move the fast pointer to the start point
        fastP = readOnlyArray[0];
        // make both the fast and slow pointers move one step at the time.
        while (slowP != fastP) {
            slowP = readOnlyArray[slowP];
            fastP = readOnlyArray[fastP];
            /* Explanation:
             * Move fastP to the starting point (index 0) of the sequence 
             * and slowP remains within cycle and both move with the same 
             * speed i.e. slowP = arr[slowP] and fastP = arr[fastP].
             * Now they will intersect at the duplicate element.
             * slowP == fastP
             */
        }
        StdOut.println("A repeated value in a read-only array using Floyd's Cycle:");
        StdOut.println(slowP);
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
        // creates an array of n values for case (a)
        int n = 10;
        int[] nIntegers = new int[n];
        for (int i = 0; i < n; i++)
            nIntegers[i] = i + 1;
        // set the repeated value (hard coded)
        nIntegers[6] = 9;

        // find the value for Problem (a)
        StdOut.println("Solution (a):");
        printArray(nIntegers);
        findDuplicate(nIntegers);
        // findDuplicateWithXOR(nIntegers); // it doesn't work, needs to be fixed

        // set another array (repated values 4, 2 and 1) for case(a)
        int numRay[] = { 5, 9, 4, 7, 3, 2, 1, 8, 2, 6, 10, 4, 1 };
        // find the repeated value
        printArray(numRay);
        findDuplicateMod(numRay);

        // Set the array for case (b).
        int[] intsReadOnly = new int[n];
        for (int i = 0; i < n; i++) {
            intsReadOnly[i] = i + 1;
        }
        // randomize
        for (int i = 0; i < n - 1; i++) {
            int rnd = i + StdRandom.uniform(n - i);
            int temp = intsReadOnly[i];
            // to repeat a value, just set the value 10 to another one 
            // (in this case is hardcoded 7)
            if (intsReadOnly[rnd] == n)
                intsReadOnly[i] = 7;
            else
                intsReadOnly[i] = intsReadOnly[rnd];
            intsReadOnly[rnd] = temp;
        }
        // Find the value for Problem (b)
        StdOut.println("Solution (b):");
        printArray(intsReadOnly);
        findDuplicatedWithSumOfN(intsReadOnly);

        // Set the array for case (c)
        for (int i = 0; i < intsReadOnly.length; i++) {
            intsReadOnly[i] = StdRandom.uniform(1, n);
        }
        // Find the value for problem (c)
        StdOut.println("Solution (c):");
        printArray(intsReadOnly);
        findDuplicatedFloydCycle(intsReadOnly);

    }

}
