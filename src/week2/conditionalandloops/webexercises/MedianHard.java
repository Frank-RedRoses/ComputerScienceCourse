package week2.conditionalandloops.webexercises;
/*
 * (hard) Now, try to compute the median of 5 elements such that when executed,
 *  it never makes more than 6 total comparisons.
 */

public class MedianHard {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]); 
        int e = Integer.parseInt(args[4]);

        int min, min2nd, med;
        
        min = Math.min(a, Math.min(b, c));
        med = Math.max(a, Math.max(b, c));
        min2nd = a + b + c - min - med;

        int next = d;
        for (int i = 0; i < 2; i++) {
            if (next < min) {
                med = min2nd;
                min2nd = min;
                min = next;
            } else if (next < min2nd) {
                med = min2nd;
                min2nd = next;
            } else if (next < med) {
                med = next;
            }
            next = e;
        }
    
        System.out.println("Median value = " + med);
    }
    
}
