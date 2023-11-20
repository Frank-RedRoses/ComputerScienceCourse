package week8.adt.lecture;

import java.awt.Color;
import edu.princeton.cs.algs4.Picture;

public class Scale {

    public static void main(String[] args) {
        
        String filename = args[0];                                  // get the path with the name of the picture
        int scaleWidth = Integer.parseInt(args[1]);                 // get the new dimensions (scale picture)
        int scaleHeight = Integer.parseInt(args[2]);
        
        Picture source = new Picture(filename);                     // load the picture
        Picture target = new Picture(scaleWidth, scaleHeight);      // create the new scale picture

        // Fill the new proportions using a rule of three to select the corresponding pixel in the source image.
        // Downscaling by halving the pixels
        // Upscaling by doubling the pixels
        for (int tcol = 0; tcol < scaleWidth; tcol++) {
            for (int trow = 0; trow < scaleHeight; trow++) { 
                // rule of three
                int scol = tcol * source.width() / scaleWidth;   
                int srow = trow * source.height() / scaleHeight;
                
                Color color = source.get(scol, srow);       // Get the color from the source pixel
                target.set(tcol, trow, color);              // Set the color to the new picture.
            }
        }
        target.show();
    }
}
