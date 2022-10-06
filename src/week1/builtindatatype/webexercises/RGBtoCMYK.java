package week1.builtindatatype.webexercises;

/*
 * CMYK to RGB color matching. Write a program CMYKtoRGB that reads in four command line
 * inputs C, M, Y, and K between 0 and 1, and prints the corresponding RGB parameters. 
 * Devise the appropriate formula by "inverting" the RGB to CMYK conversion formula.
 */

public class RGBtoCMYK {

    public static void main(String[] args) {
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);

        int maxRGB = Math.max(red, Math.max(green, blue));
        double black =  1.0 - (maxRGB / 255.0);
        double cyan = (1.0 - (red / 255.0) - black) / (1.0 - black);
        double magenta = (1.0 - (green / 255.0) - black) / (1.0 - black);
        double yellow = (1.0 - (blue / 255.0) - black) / (1.0 - black);

        System.out.println("RGB values (" + red + ", " + green 
                            + ", " + blue + ") to CMYK:");
        System.out.println("cyan = " + cyan);   
        System.out.println("magenta = " + magenta);
        System.out.println("yellow = " + yellow);
        System.out.println("black = " + black);
    }
    
}
