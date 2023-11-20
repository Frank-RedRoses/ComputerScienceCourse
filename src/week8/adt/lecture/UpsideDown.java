package week8.adt.lecture;

import edu.princeton.cs.algs4.Picture;

public class UpsideDown {

    public static void main(String[] args) {
        // get the picture from input.
        Picture source = new Picture(args[0]);
        int width = source.width();
        int height = source.height();
        // Create a new blank picture
        Picture target = new Picture(width, height);
        // copy the picture upside down pixel by pixel
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                target.set(col, height - row - 1, source.get(col, row));
            }
        }
        // show the new image
        target.show();
    }
    
}
