package week9.adtcreation.lecture;

// Turtle client
public class Ngon {
    
    public static void main(String[] args) {
        // Get the number of sizes of the polygon
        int N = Integer.parseInt(args[0]);
        // Divide the 360 angle circle in N division
        double angle = 360.0 / N;
        // Compute the side of the polygon (with side = sin(angle/2.0) for a polygon of radius 0.5.
        double step = Math.sin(Math.toRadians(angle / 2.0));
        // Create the turtle 
        // Angle/2.0 is the angle for the horizontal to the side of the polygon
        Turtle turtle = new Turtle(0.5, 0.0, angle/2.0);     
        // Call the turtle to draw every side of the polygon
        for (int i = 0; i < N; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}
