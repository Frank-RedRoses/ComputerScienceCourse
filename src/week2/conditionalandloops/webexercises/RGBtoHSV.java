package week2.conditionalandloops.webexercises;
/*************************************************************************************
 * RGB to HSB converter. 
 * Write a program RGBtoHSV.java that takes an RGB color (three integers between 0 and 255) 
 * and transforms it to an HSB color (three different integers between 0 and 255). 
 * Write a program HSVtoRGB.java that applies the inverse transformation.
 * 
 * % java RGBtoHSV 31 52 29
 * HSV color: (114.78, 44.231, 20.392)
 * 
 * % java RGBtoHSV 45 215 0
 * HSV color: (107.44, 100.000, 84.314)
 * 
 * % java RGBtoHSV 129 88 47
 * HSV color: (30.00, 63.566, 50.588)
 * 
 ***********************************************************************************/

public class RGBtoHSV {
    
    public static void main(String[] args) {
        double r = Double.parseDouble(args[0]) / 255.0;
        double g = Double.parseDouble(args[1]) / 255.0;
        double b = Double.parseDouble(args[2]) / 255.0;

        double xMax = Math.max(r, Math.max(g, b));
        double xMin = Math.min(r, Math.min(g, b));
        double c = xMax - xMin;
        double h = -1, s = -1;
        double v = xMax * 100;

        // formula for h, depends on the max value between r, g and b. max(R,G,B).
        if (c == 0) h = 0;
        else if (xMax == r) h = 60 * ((g - b) / c);
        else if (xMax == g) h = 60 * (2 + (b - r) / c);
        else if (xMax == b) h = 60 * (4 + (r - g) / c);

        if (xMax == 0) s = 0;
        else s = 100.0 * c / xMax;

        System.out.printf("HSV color: (%.2f, %.3f, %.3f)%n", h, s, v);




    }
}
