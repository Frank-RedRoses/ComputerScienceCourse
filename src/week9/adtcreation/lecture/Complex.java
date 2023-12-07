package week9.adtcreation.lecture;

import edu.princeton.cs.algs4.StdOut;

public class Complex {

    // Instance variables 
    private final double re;
    private final double im;

    // Constructor
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // get the real value of this complex number
    public double getReal() {
        return re;
    }
    // get the imaginary value of this complex number
    public double getImag() {
        return im;
    }

    // Methods
    // Returns the addition of this Complex and b
    public Complex plus(Complex b) {
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex(real, imag); 
    }

    // Returns the subtraction of this Complex and b
    public Complex minus(Complex b) {
        double real = re - b.re;
        double imag = im - b.im;
        return new Complex(real, imag);
    }

    // Returns the reciprocal of this complex number.
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // Multiplication
    // Returns the multiplication of this Complex by b (this * b)
    public Complex times(Complex b) {
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex(real, imag);
    }

    // Division
    // Returns the division of this Complex by b (this / b)
    public Complex divides(Complex b) {
        return this.times(b.reciprocal());
    }

    // Magnitude or Absolute value
    // Returns the Magnitude of this Complex
    public double abs() {
        return Math.sqrt(re*re + im*im);
    } 

    // String representation
    public String toString() {
        return re + " + " + im + "i";
    }

    public static void main(String[] args) {
        Complex a = new Complex(3.0, 4.0);
        Complex b = new Complex(-2.0, 3.0);
        StdOut.println("a = " + a);
        StdOut.println("b = " + b);
        StdOut.println("a * b = " + a.times(b));
        StdOut.println("a / b = " + a.divides(b));
        
    }
    
}
