package week2.conditionalandloops.optionalenrichment;

/***************************************************************************************
 * 2D random walk. 
 ***************************************************************************************
 * A two-dimensional random walk simulates the behavior of a particle moving in 
 * a grid of points. At each step, the random walker moves north, south, east, 
 * or west with probability equal to 1/4, independent of previous moves. 
 * 
 * Write a program RandomWalker that takes an integer command-line argument n and 
 * estimates how long it will take a random walker to hit the boundary of a 2n-by-2n 
 * square centered at the starting point.
 * 
 *****************************************************************************************/

public class RandomWalker2D {
    public static void main(String[] args) {
        int n = 4;
        int stepCounter = 0;
        int positionX = 0;
        int positionY = 0;
        String limit = "";
        String path = "";

        while (positionX < n && positionX > -n &&
                positionY < n && positionY > -n) {
            int dir = (int) (Math.random()*4);
            stepCounter++;
            switch (dir) {
                case 0:
                    positionY++;
                    path += " north";
                    break;
                case 1:
                    positionY--;
                    path += " south";
                    break;
                case 2:
                    positionX++;
                    path += " east";
                    break;
                case 3:
                    positionX--;
                    path += " west";
                    break;
            }
        }
        if (positionY == n) limit = "north";
        else if (positionY == -n) limit = "south";
        else if (positionX == n) limit = "east";
        else if (positionX == -n) limit = "west";
        System.out.println("The walker hit the " + limit + " limit in " + stepCounter + " steps");
        System.out.println("Path:" + path);
    }   
}
