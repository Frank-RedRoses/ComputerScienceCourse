package week6.recursion.creative_exercises;

import edu.princeton.cs.algs4.StdDraw;

/* 2.3.22 Recursive squares.
 * Write a program to produce each of the following recursive patterns. The ratio of the 
 * sizes of the squares is 2.2:1. To draw a shaded square, draw a filled gray square, then 
 * an unfilled black square.
 */

public class Ex22RecursiveSquares {
    // 2.2:1 size ratio looks good
    private static final double SQUARE_SIZE_RATIO = 2.2;    

    public static void drawSquaresBottomUp(int nRecurCalls, double xCenter, double yCenter, double halfLength) {
        // Base case: no more n Recursive Calls to make 
        if (nRecurCalls == 0) return;

        // next recursion square dimensions and x-y coordinates
        double smallerLength = halfLength / SQUARE_SIZE_RATIO;
        double xRightSide = xCenter + halfLength;
        double xLeftSide = xCenter - halfLength;
        double yUpperSide = yCenter + halfLength;
        double yLowerSide = yCenter - halfLength;

        // Reduction step: nRecurCalls decreased by 1 for the next recursive calls
        drawSquaresBottomUp(nRecurCalls - 1, xLeftSide, yUpperSide, smallerLength);     // upper left
        drawSquaresBottomUp(nRecurCalls - 1, xRightSide, yUpperSide, smallerLength);    // upper right
        drawSquaresBottomUp(nRecurCalls - 1, xLeftSide, yLowerSide, smallerLength);     // lower left
        drawSquaresBottomUp(nRecurCalls - 1, xRightSide, yLowerSide, smallerLength);    // lower right

        // Draw a filled square in gray color
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(xCenter, yCenter, halfLength);
        // Draw the square in black color
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(xCenter, yCenter, halfLength);
    }

    public static void drawSquaresUpBottom(int nRecurCalls, double xCenter, double yCenter, double halfLength) {
        // Base case: no more n Recursive Calls to make 
        if (nRecurCalls == 0) return;

        // next recursion square dimensions and x-y coordinates
        double smallerLength = halfLength / SQUARE_SIZE_RATIO;
        double xRightSide = xCenter + halfLength;
        double xLeftSide = xCenter - halfLength;
        double yTopSide = yCenter + halfLength;
        double yBottonSide = yCenter - halfLength;

        // Draw a filled square in gray color
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(xCenter, yCenter, halfLength);
        // Draw the square in black color
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(xCenter, yCenter, halfLength);

        // Reduction step: decrease by 1 the nRecurCalls per each level of recursion
        drawSquaresUpBottom(nRecurCalls - 1, xLeftSide, yTopSide, smallerLength);       // upper left
        drawSquaresUpBottom(nRecurCalls - 1, xRightSide, yTopSide, smallerLength);      // upper right
        drawSquaresUpBottom(nRecurCalls - 1, xRightSide, yBottonSide, smallerLength);   // lower right 
        drawSquaresUpBottom(nRecurCalls - 1, xLeftSide, yBottonSide, smallerLength);    // lower left
    }

    public static void drawSquaresOnlyLowerRightUpBottom(int nRecurCalls, double xCenter, double yCenter, double halfLength) {
        // Base case: no more n Recursive Calls to make 
        if (nRecurCalls == 0) return;

        // next recursion square dimensions and x-y coordinates
        double smallerLength = halfLength / SQUARE_SIZE_RATIO;
        double xRightSide = xCenter + halfLength;
        double xLeftSide = xCenter - halfLength;
        double yTopSide = yCenter + halfLength;
        double yBottonSide = yCenter - halfLength;

        // Reduction step: decrease by 1 the nRecurCalls per each level of recursion
        drawSquaresOnlyLowerRightUpBottom(nRecurCalls - 1, xLeftSide, yTopSide, smallerLength); // upper left
        drawSquaresOnlyLowerRightUpBottom(nRecurCalls - 1, xRightSide, yTopSide, smallerLength); // upper right
        drawSquaresOnlyLowerRightUpBottom(nRecurCalls - 1, xLeftSide, yBottonSide, smallerLength); // lower left

        // Draw a filled square in gray color
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(xCenter, yCenter, halfLength);
        // Draw the square in black color
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(xCenter, yCenter, halfLength);

        drawSquaresOnlyLowerRightUpBottom(nRecurCalls - 1, xRightSide, yBottonSide, smallerLength); // lower right
    }

    public static void drawSquaresLowerUpBottom(int nRecurCalls, double xCenter, double yCenter, double halfLength) {
        // Base case: no more n Recursive Calls to make 
        if (nRecurCalls == 0) return;

        // next recursion square dimensions and x-y coordinates
        double smallerLength = halfLength / SQUARE_SIZE_RATIO;
        double xRightSide = xCenter + halfLength;
        double xLeftSide = xCenter - halfLength;
        double yTopSide = yCenter + halfLength;
        double yBottonSide = yCenter - halfLength;

        // Reduction step: decrease by 1 the nRecurCalls per each level of recursion
        drawSquaresLowerUpBottom(nRecurCalls - 1, xLeftSide, yTopSide, smallerLength);  // upper left
        drawSquaresLowerUpBottom(nRecurCalls - 1, xRightSide, yTopSide, smallerLength); // upper right
        
        // Draw a filled square in gray color
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(xCenter, yCenter, halfLength);
        // Draw the square in black color
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(xCenter, yCenter, halfLength);
        
        drawSquaresLowerUpBottom(nRecurCalls - 1, xLeftSide, yBottonSide, smallerLength); // lower left
        drawSquaresLowerUpBottom(nRecurCalls - 1, xRightSide, yBottonSide, smallerLength); // lower right
    }

    public static void main(String[] args) {
        int recursionFormat = 4;
        int n = 4;
        double x = 0.5, y = 0.5;
        double squareHalfLength = 0.25;

        switch (recursionFormat) {
            case 1:
                drawSquaresBottomUp(n, x, y, squareHalfLength);
                break;
            case 2:
                drawSquaresUpBottom(n, x, y, squareHalfLength);
                break;
            case 3:
                drawSquaresOnlyLowerRightUpBottom(n, x, y, squareHalfLength);
                break;
            case 4:
                drawSquaresLowerUpBottom(n, x, y, squareHalfLength);
                break;
            default:
                drawSquaresBottomUp(n, x, y, squareHalfLength);
                break;
        }

        
       
    }
    
}
