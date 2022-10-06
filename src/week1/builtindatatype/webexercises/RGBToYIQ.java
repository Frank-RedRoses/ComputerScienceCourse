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

public class RGBToYIQ {
    
    public static void main(String[] args) {
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);
        
        double y = 0.299*red + 0.587*green + 0.144*blue;
        double i = 0.5959*red - 0.2746*green - 0.3213*blue;
        double q = 0.2115*red - 0.5227*green + 0.3112*blue;

        System.out.println("RGB color; (" + red + ", " + green + ", " + blue + ")");
        System.out.println("YIQ color conversion: ");
        System.out.println("y = " + y);
        System.out.println("i = " + i);
        System.out.println("q = " + q);
    }
}
