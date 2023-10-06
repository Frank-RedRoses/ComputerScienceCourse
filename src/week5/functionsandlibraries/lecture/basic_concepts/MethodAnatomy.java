package week5.functionsandlibraries.lecture.basic_concepts;

public class MethodAnatomy {
  
    /**
     * To implement a function (static method)
     * <ul>
     * <li> Create a name. ({@code sqrt})
     * <li> Declare type and name of argument(s). ({@code c} and {@code eps})
     * <li> Specify type for return value. ({@code double})
     * <li> Implement body of method.   
     * <li> Finish with return statement. ({@code return t})
     * 
     * @param c - The radicand
     * @param eps - The desired precision
     */
    public static double sqrt(double c, double eps) {   // the method's signature 
    // start of body 
        if (c < 0) return Double.NaN;
        double t = c;
        while (Math.abs(t - c / t) > eps * t) 
            t = (c/t + t) / 2.0;
        // return statement
        return t;
    // end of body   
    }

    /** 
     * Computes the square root of {@code c} using the Newton-Raphson method.
     * <p>
     * <ul><li>Initialize t(0) = c.
     * <li>Repeat until t(i) = c/t(i) (up to desired precision):
     *      Set t(i+1) to be the average of t(i) and c / t(i).</ul>
     * 
     * @param c value
     * @param eps desired precision 
     * @return the square root of {@code c}
     **/

    
}
