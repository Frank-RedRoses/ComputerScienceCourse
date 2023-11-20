package week8.adt.lecture;

import java.awt.Color;
import edu.princeton.cs.algs4.Picture;

// Java program to convert an image to grayscale.
public class Grayscale {

    public static void main(String[] args) {
        // Create a new picture
        Picture pic = new Picture(args[0]);

        // Change every pixel to grayscale 
        for (int col = 0; col < pic.width(); col++) {
            for (int row = 0; row < pic.height(); row++) {
                // get color and fill in each pixel with the corresponding gray tone
                Color color = pic.get(col, row);
                Color gray = Luminance.toGray(color);
                pic.set(col, row, gray);
            }
        }
        pic.show();
    }
    
}
