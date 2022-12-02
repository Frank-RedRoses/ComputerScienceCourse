package week2.conditionalandloops.creativeexercises;

public class MonteHall {
    public static void main(String[] args) {
        // int nTimes = Integer.parseInt(args[0]);
        int nTimes = 10000;
        int winsSwitching = 0;

        for (int i = 0; i < nTimes; i++) {

            int prizeDoor = (int) (3.0*Math.random());

            int pickedDoor = (int) (3.0*Math.random());

            int revealDoor;

            do {
                revealDoor =(int) (3.0*Math.random());    
            } while (revealDoor == pickedDoor || revealDoor == prizeDoor);

            int remainDoor = 0 + 1 + 2 - revealDoor - pickedDoor;

            if (remainDoor == prizeDoor) winsSwitching++;
        }

        System.out.println("Games won by staying with the door: " + (1.0 - 1.0 * winsSwitching/nTimes));
        System.out.println("Games won by switching the door: " + 1.0*winsSwitching/nTimes);
    }
}
