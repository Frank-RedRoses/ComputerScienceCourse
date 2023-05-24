package week6.recursion.creative_exercises;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex31PlasmaCloud {

    private static void squareCloud(double xCenter, double yCenter, double halfLength, double stdDev,
                                    double colorTopLeft, double colorTopRight, double colorBottomLeft, double colorBottomRight) {
        // base case
        if (halfLength < 0.001) return;

        // calculate the new midpoint color using a random displacement
        double rand = StdRandom.gaussian(0, stdDev);
        double middleColor = (colorTopLeft + colorTopRight + colorBottomLeft + colorBottomRight) / 4.0 + rand;
        
        // draw a colored square
        Color color = Color.getHSBColor((float) middleColor, 0.8f, 0.8f);
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(xCenter, yCenter, halfLength);

        // midpoint colors 
        double colorTop = (colorTopLeft + colorTopRight) / 2.0;             // top side of square
        double colorBottom = (colorBottomLeft + colorBottomRight) / 2.0;    // bottom side of square
        double colorLeft = (colorTopLeft + colorBottomLeft) / 2.0;          // left side of square
        double colorRight = (colorTopRight + colorBottomRight) / 2.0;       // right side of square
        
        // halve the square's size
        double halfSize =  halfLength / 2.0;

        // Reduction step:
        // Top-right square
        squareCloud(xCenter + halfSize, yCenter + halfSize, halfSize, stdDev / 2,
                    colorTop, colorTopRight, middleColor, colorRight);
        // Top-left square
        squareCloud(xCenter + halfSize, yCenter - halfSize, halfSize, stdDev / 2,
                    colorTopLeft, colorTop, colorLeft, middleColor);
        // Bottom-right square
        squareCloud(xCenter - halfSize, yCenter + halfSize, halfSize, stdDev / 2,
                    middleColor, colorRight, colorBottom, colorBottomRight);
        // Bottom-left square
        squareCloud(xCenter - halfSize, yCenter - halfSize, halfSize, stdDev / 2,
                    colorLeft, middleColor, colorBottomLeft, colorBottom);
        
    }

    public static void main(String[] args) {

        // initial corner random colors between 0.0 and 1.0
        double color1 = StdRandom.uniform(.0, 1.0);
        double color2 = StdRandom.uniform(.0, 1.0);
        double color3 = StdRandom.uniform(.0, 1.0);
        double color4 = StdRandom.uniform(.0, 1.0);
        // controls variation in color
        double stdDev = 1.0;
        squareCloud(0.5, 0.5, .5, stdDev,
                    color1, color2, color3, color4);
    }
    
}
