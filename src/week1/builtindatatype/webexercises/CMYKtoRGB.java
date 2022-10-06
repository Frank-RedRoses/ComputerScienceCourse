package week1.builtindatatype.webexercises;

/*
 * CMYK to RGB color matching. Write a program CMYKtoRGB that reads in four command line
 * inputs C, M, Y, and K between 0 and 1, and prints the corresponding RGB parameters. 
 * Devise the appropriate formula by "inverting" the RGB to CMYK conversion formula.
 */
public class CMYKtoRGB {

    public static void main(String[] args) {
        Double cyan = Double.parseDouble(args[0]);
        Double magenta = Double.parseDouble(args[1]);
        Double yellow = Double.parseDouble(args[2]);
        Double black = Double.parseDouble(args[3]);

        int red = (int) Math.round((255 * (1 - cyan) * (1 - black)));
        int green = (int) Math.round((255 * (1 - magenta) * (1 - black)));
        int blue = (int) Math.round((255 * (1 - yellow) * (1 - black)));

        System.out.println("CMYK values (" + cyan + ", " + magenta 
                            + ", " + yellow + ", " + black + ") to RBG:");
        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);

    }
    
}
