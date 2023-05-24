package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/* 2.3.26. Animated towers of Hanoi animation.
 * Write a program AnimatedHanoi.java that uses StdDraw to animate a solution 
 * to the towers of Hanoi problem, moving the discs at a rate of approximately 
 * 1 per second.
 * 
 * % Ex26animatedHanoi.java 4
 * 
 */

public class Ex26AnimatedHanoi {

    // My solution:
    public static void playHanoi(int nDisc) {
        int[] discOnPole = new int[nDisc + 1]; // discOnPole[disc #] = pole (take disc 0 as the base pole level)
        // draw the initial pole status
        drawHanoi(discOnPole);
        // start disc movemments
        moveDisc(discOnPole, nDisc, true);
    }

    // My solution:
    private static void moveDisc(int[] poles, int iDisc, boolean left) {
        // Base case: no disc, do nothing
        if (iDisc == 0) return;
        // Reduction step:  move a lower disc to the opossite direction of the actual one
        moveDisc(poles, iDisc - 1, !left);
        if (left) {
            // move the iDisc to the next left pole by decreasing the pole number
            poles[iDisc]--;
            // if disc in pole -1 move the disc to the pole 2 
            if (poles[iDisc] < 0) poles[iDisc] = 2;
        } else {
            // move the iDisc to the next right pole by increasing the pole number
            poles[iDisc]++;
            // if disc in pole 3 move the disc to the pole 0
            if (poles[iDisc] > 2) poles[iDisc] = 0;
        }
        // Show the poles after the disc is move
        drawHanoi(poles);
        // move a lower disc to the opossite direction of the actual one
        moveDisc(poles, iDisc - 1, !left);
    }

    // Solution from the booksite
    public static void hanoi(int n) {
        int[] pole = new int[n + 1];    // discOnPole[disc #] = pole (disc 0 = the base pole level)
        // draw the initial state of poles
        drawHanoi(pole);
        // start disc movemments
        hanoi(n, 0, 1, 2, pole);
    }

    /* The action of moving a disc can only be done between movements of the next smaller disc,
     * first take the smaller disc out of the way moving it to the "temp" or midpoint pole, then
     * move the actual disc to the "to" or end of movement pole and finally put the small disc 
     * on top of the actual disc, moving the small disc from the "temp" pole to the "to" (end) pole.*/
    private static void hanoi(int n, int from, int temp, int to, int[] pole) {
        // Base case: there are no more discs
        if (n == 0) return;

        // Reduction step: 
        // the next lower disc moves from the start pole to the mid point pole.
        hanoi(n-1, from, to, temp, pole);
        // move the disc the final (to) pole.
        StdOut.println("Move disc " + n + " from pole " + from + " to " + to);
        pole[n] = to;       // save the new location of the disc
        drawHanoi(pole);    // update the drawing of the poles
        // the next lower disc moves from the mid point pole to the end pole 
        hanoi(n-1, temp, from, to, pole);
    }

    // Draw the Hanoi poles with the discs. It receives an array containing the 
    // pole that corresponds for every disc (poles[disc number] = pole)
    private static void drawHanoi(int[] poles) {
        int nDisc = poles.length - 1;       // poles[0] represents the base of the pole (no disc level)
        // draw the poles
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < 3; i++) {                  // pole numbers 0, 1 and 2
            StdDraw.line(i, 0, i, poles.length);    // y1 = pole height = pole.length = nDisc + 1
        }
        // draw the base of the poles
        StdDraw.filledRectangle(2, 0, 4, 0.5);

        // draw the discs
        int[] discsOnPole = new int[3];     // To store the number of discs on a pole (discs[pole] = n of discs)
        double bigDiscRadio = 0.9 / 2;      // distance between poles is 1 unit. Big disc radio = 0.45 units 
        double smallDiscRadio = 0.1 / 2;    // distance between poles is 1 unit. Small disc radio = 0.05 units
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = nDisc ; i >= 1; i--) { // i represent the disc, drawing is made from bottom (bigger disc = nDisc) to top (small disc = 1) 
            int pole = poles[i];            // pole on where the disc is located
            // discRadio = disc 1 radio (fixed) + (disc number * ratio of the sizes difference between discs 1 and nDisc)
            double discRadio = smallDiscRadio + (i - 1) * (bigDiscRadio - smallDiscRadio) / (nDisc - 1) ;   
            double discHeight = ++discsOnPole[pole];   // first add a disc to the pole and then get the height level (height level = n of discs on a pole)
            StdDraw.line(pole - discRadio, discHeight, pole + discRadio, discHeight); // draw the disc.   
        }
        
        StdDraw.show();
        StdDraw.pause(500);
    }

    public static void main(String[] args) {
        // Input values:
        int nDisc = 4;
        // int nDisc = Integer.parseInt(args[0]);
        // int[] discOnPole = {-1, 0, 1, 0, 2, 2, 2, 1, 0, 2}; // for debug, 9 disc system
        // int[] discOnPole = new int[nDisc + 1]; // discOnPole[disc number] = pole

        // Set the canvas:
        // Set x scale using the number of poles (from pole 0 to pole 2, -1 and 3 are the canvas limits)
        // Set y scale using the number of discs (y=0 is base of the pole, from disc 1 to disc nDisc, -1 and nDisc+3 are canvas limits) 
        StdDraw.setCanvasSize(1200, 400);
        StdDraw.setXscale(-1, 3);
        StdDraw.setYscale(-1, nDisc + 3);
        // Set the animation
        StdDraw.enableDoubleBuffering();

        // drawHanoi(discOnPole);  // Fur debugging
        // Run Hanoi animation
        
        // My version using the hanoi.java class as base.
        // playHanoi(nDisc);

        // Run Hanoi from the website version
        hanoi(nDisc);
         
    }
    
}
