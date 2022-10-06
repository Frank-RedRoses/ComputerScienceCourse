package week1.builtindatatype.creativeexercises;
/*
 * Dragon curves. Dragon curvesWrite a program Dragon.java to print the instructions 
 * for drawing the dragon curves of order 0 through 5. The instructions are strings of 
 * the characters F, L, and R, where F means "draw line while moving 1 unit forward", 
 * L means "turn left", and R means turn right. 
 * 
 * A dragon curve of order n is formed when you fold a strip of paper in half n times, 
 * then unfold to right angles. 
 * 
 * The key to solving this problem is to note that a curve of order n is a curve of 
 * order n−1 followed by an L followed by a curve of order n−1 traversed in reverse order, 
 * and then to figure out a similar description of the reverse curve.
 */

 /**
  * Prints the instructions for drawing a dragon curve of orders 0
 *  through 5.
 *
 *  % java Dragon
 *  F
 *  FLF
 *  FLFLFRF
 *  FLFLFRFLFLFRFRF
 *  FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRF
 *  FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRFLFLFLFRFLFLFRFRFRFLFLFRFRFLFRFRF
  */
public class Dragon {
    
    public static void main(String[] args) {
        // dragon 0
        String order0 = "F";
        String reverse0 = "F";
        // dragon 1
        String order1 = order0 + "L" + reverse0;
        String reverse1 = order0 + "R" + reverse0;
        // dragon 2
        String order2 = order1 + "L" + reverse1;
        String reverse2 = order1 + "R" + reverse1;
        // dragon 3
        String order3 = order2 + "L" + reverse2;
        String reverse3 = order2 + "R" + reverse2;
        // dragon 4
        String order4 = order3 + "L" + reverse3;
        String reverse4 = order3 + "R" + reverse3;
        // dragon 5
        String order5 = order4 + "L" + reverse4;

        System.out.println("Dragon 0 : " + order0);
        System.out.println("Dragon 1 : " + order1);
        System.out.println("Dragon 2 : " + order2);
        System.out.println("Dragon 3 : " + order3);
        System.out.println("Dragon 4 : " + order4);
        System.out.println("Dragon 5 : " + order5);
    }
}
