package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdDraw;

/* *************************************************************************************
 * 2.3.16 A4 paper. 
 * The width-to-height ratio of paper in the ISO format is the square root of 2 to 1. 
 * Format A0 has an area of 1 square meter. Format A1 is A0 cut with a vertical line 
 * into two equal halves, A2 is A1 cut with a horizontal line into two halves, and so on. 
 * 
 * Write a program that takes an integer command-line argument n and uses StdDraw
 * to show how to cut a sheet of A0 paper into 2^n pieces.
 * 
 ************************************************************************************* */

public class Ex16A4Paper {

    // Recursive drawing that cuts a sheet of A0 paper into 2^n pieces.
    public static void formatA(int n, double width, double height) {
        // base case
        if (n == 0) return; 

        if (width > height) { 
            // horizontal format case, cut the paper in half with a vertical line in the middle of the width.
            width /= 2;
            StdDraw.line(width, 0, width, height); // vertical cut line
        } else {    
            // Vertical ISO format case, cut the paper in half with a horizontal line in the middle of the height. 
            height /= 2;
            StdDraw.line(0, height, width, height); // horzontal cut line
        
        }
        // animation for debug
        StdDraw.show();
        StdDraw.pause(1000);
        // next iteration
        formatA(--n, width, height);
    }

    public static void formatLabels(int n, int aSize, double width, double height) {
        // base case
        if (n == 0 ) return;
        aSize++;    // next small A size
        
        if (width > height) { 
            // horizontal format case, name and size of the smaller format (centered).
            width /= 2;
            StdDraw.text(width + width / 2, height / 2, "A" + aSize);
            StdDraw.text(width + width / 2, height / 2 - 25, Math.round(width) + "x" + Math.round(height));

        } else {    
            // Vertical ISO format case, name and size of the smaller format (centered)
            height /= 2;
            StdDraw.text(width / 2, height + height / 2, "A" + aSize);
            StdDraw.text(width / 2, height + height / 2 - 25, Math.round(width) + "x" + Math.round(height));
        }
        // next iteration
        formatLabels(--n, aSize, width, height);
    }

    public static void main(String[] args) {
        // Take the value for the command line
        // int n = Integer.parseInt(args[0]);
        int n = 7;

        // Constants for the ISO paper
        int aInitialSize = 0; // Biggest size of ISO PAPER
        double A0_AREA_SQR_METERS = 1;
        double ISO_PAPER_RATIO = Math.sqrt(2); // Width-to-height 1.41421:1 (width = 1.41421*height)

        // Set the canvas for the drawing
        int canvasHeight = 512;
        StdDraw.setCanvasSize((int) (ISO_PAPER_RATIO * canvasHeight),  canvasHeight);
        double yHeightA0 = Math.sqrt(A0_AREA_SQR_METERS / ISO_PAPER_RATIO) * 1000; // Area = 1.44*H x H --> H = sqrt(Area / 1.44)
        double xWidthA0 = Math.sqrt(A0_AREA_SQR_METERS * ISO_PAPER_RATIO) * 1000;  // Area = W x W/1.44 --> W = sqrt(Area * 1.44)
        StdDraw.setXscale(0.0, xWidthA0);
        StdDraw.setYscale(0.0, yHeightA0);
        
        // add animation
        StdDraw.enableDoubleBuffering();

        // Recursive drawing of the formats 
        formatA(n, xWidthA0, yHeightA0);

        // Labels every format
        formatLabels(n, aInitialSize, xWidthA0, yHeightA0);
        StdDraw.show();

    }   
    
}
