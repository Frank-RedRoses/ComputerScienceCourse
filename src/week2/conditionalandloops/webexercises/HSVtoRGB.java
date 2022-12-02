package week2.conditionalandloops.webexercises;
/************************************************************************************
 * RGB to HSB converter. 
 * Write a program RGBtoHSV.java that takes an RGB color (three integers between 0 and 255) 
 * and transforms it to an HSB color (three different integers between 0 and 255). 
 * Write a program HSVtoRGB.java that applies the inverse transformation.
 * 
 * % java HSVtoRGB 174 75 75
 * RGB is: (48, 191, 177)
 * 
 * 
 * ***********************************************************************************/

public class HSVtoRGB {
    public static void main(String[] args) {
        double h = Double.parseDouble(args[0]); 
        double s = Double.parseDouble(args[1]) / 100; 
        double v = Double.parseDouble(args[2]) / 100;
        double r = -1, g = -1, b = -1;
        
        double c = v * s;
        double hPrim = h / 60;
        double x = c * (1 - Math.abs(hPrim % 2 - 1));
        double m = v - c;

        if (hPrim >= 5) {
            r = c + m;
            g = 0 + m;
            b = x + m;
        } else if (hPrim >= 4) {
            r = x + m;
            g = 0 + m;
            b = c + m;
        } else if (hPrim >= 3) {
            r = 0 + m;
            g = x + m;
            b = c + m;
        } else if (hPrim >= 2) {
            r = 0 + m;
            g = c + m;
            b = x + m;
        } else if (hPrim >= 1) {
            r = x + m;
            g = c + m;
            b = 0 + m;
        } else {
            r = c + m;
            g = x + m;
            b = 0 + m;
        }
        
        r = Math.round(r*255);
        g = Math.round(g*255);
        b = Math.round(b*255);

        System.out.println("RGB is: (" + (int) r + ", " + (int) g + ", " + (int) b + ")");
    }
    
}
