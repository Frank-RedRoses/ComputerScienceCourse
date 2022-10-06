package week1.builtindatatype.webexercises;

public class Trig {
    public static void main(String[] args) {
        double degrees  = Double.parseDouble(args[0]);
        double radians = Math.toRadians(degrees);

        double sin = Math.sin(radians);
        System.out.println("sin(" + degrees + ") = " + sin);
        double cos = Math.cos(radians);
        System.out.println("cos(" + degrees + ") = " + cos);
        double tan = Math.tan(radians);
        System.out.println("tan(" + degrees + ") = " + tan);
        System.out.println(sin + " / " + cos + " = " + sin / cos);

        double r = sin*sin + cos*cos;
        System.out.println(sin*sin + " + " + cos*cos +" = " + r);
    }
}
