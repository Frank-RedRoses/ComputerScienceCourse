package week6.recursion.lectures;

/* ****************************************************************************************
 * A legend of uncertain origin:
 * - n = 64 discs of differing size; 3 posts; discs on one of the posts from 
 *   largest to smallest.
 * - An ancient prophecy has commanded monks to move the discs to another post.
 * - When the task is completed, the world will end.
 * 
 * Solves the Towers of Hanoi problem on n discs. The discs are labeled
 * in increasing order of size from 1 to n.
 * 
 * hanoi(n): Print moves for n discs.
 * - R = move disc number n to right, L = move disc number n to left.
 * - Return one blank space for n = 0.
 * - Otherwise, set move to the specified move for disc n (R or L).
 * - Then sandwich the move between two copies of hanoi(n-1).
 * - Move right means: post 1 --> post 2 or 2 --> 3 or 3 --> 1
 * - Move left means: post 2 <-- post 3 or 1 <-- 2, or 3 <-- 1
 * 
 * Rules 
 * - Move discs one at a time.
 * - Never put a larger disc on a smaller disc.
 * 
 * 
 * Structure is the same as for the ruler function and suggests 3 useful and easy-to-prove facts.
 * - Each disc always moves in the same direction.
 * - Moving smaller disc always alternates with a unique legal move.
 * - Moving n discs requires 2n − 1 moves.
 * 
 * % java Hanoi 3
 * 1R 2L 1R 3R 1R 2L 1R
 ****************************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Hanoi {

    public static String hanoi(int n, boolean left) {
        // Base case: blank space between the disc number 1
        if (n == 0) return " ";  // to note that all other disc moves occur between disc 1 moves.
        // String that represents the movement direction and disc number.
        String move;
        if (left) move = n + "L";
        else move = n + "R";
        // Reduction step: move the next smaller disc (n-1) and invert the direction of the movement. 
        return hanoi(n - 1, !left) + move + hanoi(n - 1, !left);
        // Note that disc 1 is always between the other discs 
        // and the movement direction for a disc size is always the same.
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(hanoi(n, false));
    }
    
}
