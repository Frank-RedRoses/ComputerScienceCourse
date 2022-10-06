package week1.builtindatatype.webexercises;
/*
 * Area of a triangle. Write a program TriangleArea.java that takes three 
 * command line inputs a, b, and c, representing the side lengths of a 
 * triangle, and prints the area of the triangle using Heron's formula: 
 * 
 *      area = sqrt(s(s-a)(s-b)(s-c))       where s = (a + b + c) / 2.
 */
public class TriangleArea {

    public static void main(String[] args) {
        int sideA = Integer.parseInt(args[0]);
        int sideB = Integer.parseInt(args[1]);
        int sideC = Integer.parseInt(args[2]);

        double s = (sideA + sideB + sideC) / 2.0;

        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

        System.out.println("Triangle area using Heron's formula = " + area);
    }
}
