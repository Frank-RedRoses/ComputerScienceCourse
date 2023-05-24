package week6.recursion.lectures;

import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Beckett.java
 *  Execution:    java Beckett n
 *
 *  Prints instructions for a Beckett play with n actors. Uses the gray code 
 *  to print the stage directions for a n-character play in such way that characters
 *  enter and exit one at the time so that each subset of characters on stage appears 
 *  exactly once.
 * 
 *  The gray code is an ordering of the binary numerical system such that two 
 *  successive values differ in only one bit (binary digit).
 * 
 *  For example, the representation of the decimal value "1" in binary would 
 *  normally be "001" and "2" would be "010". But in the gray code order these 
 *  values are represented as "001" and "011". That way, incrementing a value 
 *  from 1 to 2 requires only one bit to change, instead of two.
 * 
 *  An n-bit Gray code is a list of the 2^n different n-bit binary numbers
 *  such that every subsequent entry in the list differs in precisely one bit
 *  from its predecesor. The n bit binary reflected Gray code is defined recursively
 *  as follows:
 *      - The n−1 bit code, with 0 prepended to each binary number line, followed by
 *      - The n−1 bit code in reverse order, with 1 prepended to each binary number line.
 *      - The 0-bit code is defined to be null, so the 1-bit code is 0 followed by 1.
 * 
 *  1-bit code ordering
 *  0
 *  1
 *
 *  2-bit code ordering
 *  0 0 <-- 1-bit code
 *  0 1     
 *  1 1 <-- mirrored 1-bit code
 *  1 0
 * 
 *  3-bit code ordering
 *  0 0 0 <-- 2-bit code
 *  0 0 1
 *  0 1 1
 *  0 1 0 
 *  1 1 0 <-- mirrored 2-bit code
 *  1 1 1
 *  1 0 1
 *  1 0 0
 *
 *  % java Beckett 1
 *  enter 1
 *
 *  % java Beckett 2
 *  enter 1
 *  enter 2
 *  exit  1
 *
 *  % java Beckett 3
 *  enter 1
 *  enter 2
 *  exit  1
 *  enter 3
 *  enter 1
 *  exit  2
 *  exit  1
 *
 ******************************************************************************/

public class Beckett {

    public static void moves(int actorN, boolean forward) {
        // base case: 
        if (actorN == 0) return;                        // no more actors, return to actor 1 code;
        // reduction step:
        moves(actorN - 1, true);                // make the next actor to enter the stage
        if (forward) StdOut.println("enter " + actorN); // prints if an actor enters or leaves the stage (boolean)
        else         StdOut.println("exit " + actorN);  
        moves(actorN - 1, false);               // make the next actor to leave the stage
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        moves(n, true);
    }
    
}
