package week1.builtindatatype.webexercises;

/*
 * RGB to YIQ color converter. Write a program RGBtoYIQ.java that takes an 
 * RGB color (three integers between 0 and 255) and transforms it to a 
 * YIQ color (three different real numbers Y, I, and Q, with 0 ≤ Y ≤ 1, 
 * –0.5957 ≤ I ≤ 0.5957, and –0.5226 ≤ Q ≤ 0.5226). 
 * 
 * Write a program YIQtoRGB.java that applies the inverse transformation.
 * 
 */

public class YIQToRGB {

    public static void main(String[] args) {
        double y = Double.parseDouble(args[0]);
        double i = Double.parseDouble(args[1]);
        double q = Double.parseDouble(args[2]);

        int red =   (int) (1*y + 0.956*i + 0.619*q);
        int green = (int) (1*y - 0.272*i - 0.647*q);
        int blue =  (int) (1*y - 1.106*i + 1.703*q);

        System.out.println("YIQ color; (" + y + ", " + i + ", " + q + ")");
        System.out.println("RGB color conversion: ");
        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
    }
    
}
