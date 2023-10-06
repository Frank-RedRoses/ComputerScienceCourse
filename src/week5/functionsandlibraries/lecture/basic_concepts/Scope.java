package week5.functionsandlibraries.lecture.basic_concepts;

import edu.princeton.cs.algs4.StdOut;

/** The scope of a variable is the code that can refer to it by name. 
 * In a Java library, a variable’s scope is the code following its 
 * declaration, in the same block.
*/
public class Scope {

    // sqrt() method
    public static double sqrt(double c, double eps) {
    // start of scope for c and eps
        if (c < 0) return Double.NaN;
        double t = c;
        // start of scope for t
        while (Math.abs(t - c/t) > eps * t)
        t = (c/t + t) / 2.0;
        return t;   
    // end of scope for c, eps and t
    }
    // cannot refer to c, eps or t in other block code

    // main() method
    public static void main(String[] args) {   
        double[] a = new double[args.length];
        // start of scope for a
        for (int i = 0; i < args.length; i++)   // two different variables named i
            // start of scope for i
            a[i] = Double.parseDouble(args[i]);
            // end of scope for i
        for (int i = 0; i < a.length; i++)     // two different variables named i
            // start of scope for i
            StdOut.println(sqrt(a[i], 1e-3));
            // end of scope for i
        // end of scope for a
    }
    // cannot refer to a in any other block code
    
}
