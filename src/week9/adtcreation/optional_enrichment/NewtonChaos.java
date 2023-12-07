package week9.adtcreation.optional_enrichment;

import edu.princeton.cs.algs4.Picture;
import week9.adtcreation.lecture.Complex;
import java.awt.Color;

/*
 * 3.2.34 Chaos with Newton’s method. The polynomial f(z) = z^4 - 1
 * has four roots: at 1,−1,i and −i. We can find the roots using 
 * Newton’s method in the complex plane: 
 * 
 * zk+1 = zk - f(zk)/f'(zk). 
 * Here:
 * f(z)= z^4 - 1 
 * f'(z)= 4z^3.
 * 
 * The method converges to one of the four roots, depending on the 
 * starting point z0. Write a Complex and Picture client NewtonChaos
 * that takes a command-line argument n and creates an n-by-n picture
 * corresponding to the square of size 2 centered at the origin. 
 * Color each pixel white, red, green, or blue according to which of 
 * the four roots the corresponding complex number converges (black 
 * if no convergence after 100 iterations).
 */

public class NewtonChaos {
    
    public static Color Newton(Complex z) {
        for (int i = 0; i < 100; i++) {
            z = z.minus(f(z).divides(derivF(z)));
            if (z.getReal() == 1.0 && z.getImag() == 0.0)   return Color.WHITE;
            if (z.getReal() == -1.0 && z.getImag() == 0.0)  return Color.RED;
            if (z.getReal() == 0.0 && z.getImag() == 1.0)   return Color.GREEN;
            if (z.getReal() == 0.0 && z.getImag() == -1.0)  return Color.BLUE;
        }
        return Color.BLACK;
    }

    private static Complex f(Complex z) {
        Complex one = new Complex(1.0, 0.0);
        return z.times(z).times(z).times(z).minus(one);
    }

    private static Complex derivF(Complex z) {
        Complex four = new Complex(4.0, 0.0);
        return z.times(z).times(z).times(four);
    }


    public static void main(String[] args) {
        double xc = 0.0;
        double yc = 0.0;
        double size = 2.0;
        int N = Integer.parseInt(args[0]);
        Picture pic = new Picture(N, N);
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                double x0 = xc - size/2.0 + size * col / N;
                double y0 = yc - size/2.0 + size * row / N;
                Complex z0 = new Complex(x0, y0);
                Color color = Newton(z0);
                pic.set(col, N - 1 - row, color);
            }
        }
        pic.show();
    }
   

    /* Website solution:
    // return number of Mandelbrot iterations to check z = x + iy
    public static Color newton(Complex z) {
        double EPSILON = 0.00000001;
        Complex four = new Complex(4, 0);
        Complex one  = new Complex(1, 0);

        Complex root1 = new Complex(1, 0);
        Complex root2 = new Complex(-1, 0);
        Complex root3 = new Complex(0, 1);
        Complex root4 = new Complex(0, -1);

        for (int i = 0; i < 100; i++) {
            Complex f  = z.times(z).times(z).times(z).minus(one);
            Complex fp = four.times(z).times(z).times(z);
            z = z.minus(f.divides(fp));
            if (z.minus(root1).abs() <= EPSILON) return Color.WHITE;
            if (z.minus(root2).abs() <= EPSILON) return Color.RED;
            if (z.minus(root3).abs() <= EPSILON) return Color.GREEN;
            if (z.minus(root4).abs() <= EPSILON) return Color.BLUE;
        }
        return Color.BLACK;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double xmin   = -1.0;
        double ymin   = -1.0;
        double width  =  2.0;
        double height =  2.0;

        Picture picture = new Picture(n, n);

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xmin + col * width  / n;
                double y = ymin + row * height / n;
                Complex z = new Complex(x, y);
                Color color = newton(z);
                picture.set(col, n - 1 - row, color);
            }
        }
        picture.show();
    }
    */

}
