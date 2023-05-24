package week6.recursion.lectures;

// import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/* ***********************************************************************************
 * Draw a H-tree of order n (now with sound):
 * - Draw an H, centered.
 * - Draw four H-trees of order n − 1 and half the size, centered at the tips of the H
 * 
************************************************************************************* */
public class HtreeDeluxe {
    public static void draw(int n, double size, double centerX, double centerY) {
        if (n == 0)  return;
        double x0 = centerX - size/2, x1 = centerX + size/2;
        double y0 = centerY - size/2, y1 = centerY + size/2;
        // draw the H centered on (centerX, centerY)
        StdDraw.line(x0, centerY, x1, centerY);
        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);
        
        /* To add sound use this code:
         * StdAudio.play(PlayThatTone.note(n, .25*n)); 
         * To Do: Implement PlayThatNote class.
        */
        
        // draw four half-size H-trees
        draw(n-1, size/2, x0, y0);
        draw(n-1, size/2, x0, y1);
        draw(n-1, size/2, x1, y0);
        draw(n-1, size/2, x1, y1);
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, .5, .5, .5);
    }
    
}
