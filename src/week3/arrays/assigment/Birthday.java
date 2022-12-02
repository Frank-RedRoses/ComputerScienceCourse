package week3.arrays.assigment;

public class Birthday {
    public static void main(String[] args) {
        int n = 365;
        int trials = 2;
        int[] peopleCntResults = new int[n+1];

        for (int i = 0; i < trials; i++) {
            // initialize an array with n days indexes with all days set to no birthdays.
            boolean[] daysOfTheYear = new boolean[n];
            int people = 0;     // people inside the room
            while (true) {
                people++;                            // increase the number of people in the room
                int birthday = (int) (Math.random() * n); // new person birthday (between 0 and n-1)
                if (daysOfTheYear[birthday]) break;     // one person already have the same birthday
                else daysOfTheYear[birthday] = true;    // set birthday as inside the room
            }
            // System.out.println(peopleCnt); // for debugging
            peopleCntResults[people - 1]++;  // Add 1 to the corresponding index for counting
        }

        // print the results from the simulation
        double fraction = 0.00;
        for (int i = 0; fraction < 0.5; i++) {
            fraction *= trials;
            fraction += peopleCntResults[i];
            fraction /= trials;
            // prints a table containing count of ith people,
            // the number of times that exactly ith people enter the room,
            // and the fraction of times that ith or fewer people enter the room
            System.out.printf("%-6d %-8d %.6f %n", (i + 1), peopleCntResults[i], fraction);
        }


    }
}
