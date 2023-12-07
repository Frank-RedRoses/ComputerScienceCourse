package week9.adtcreation.optional_enrichment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class IntervalClient {

     public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int N = StdIn.readInt();
        for (int i = 0; i < N; i++) {
            double left = StdIn.readDouble();
            double right = StdIn.readDouble();
            Interval interval = new Interval(left, right);
            if (interval.contains(x))
                StdOut.println(interval);
        }
     }
    
}
