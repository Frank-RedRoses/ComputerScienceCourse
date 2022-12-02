package week3.arrays.assigment;

public class randomnessTest {
    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int k = 25;
        int trials = 1000000;
        int[] trialsResult = new int[m*n];

        for (int t = 0; t < trials; t++) {

            int gridLength = m * n;
            boolean[] grid = new boolean[gridLength];

            // Create and initialize an array with the site number
            int[] sites = new int[gridLength];
            for (int i = 0; i < gridLength; i++) {
                sites[i] = i;
            }
            /*
            // Shuffling the all number sites
            for (int i = 0; i < gridLength; i++) {
                int rndSite = i + (int) (Math.random() * (gridLength - i));
                int temp = sites[rndSite];
                sites[rndSite] = sites[i];
                sites[i] =  temp;
            }*/


            // only shuffles k sites.
            for (int i = 0; i < k; i++) {
                int rndSite = i + (int) (Math.random() * (gridLength - i));
                int temp = sites[rndSite];
                sites[rndSite] = sites[i];
                sites[i] =  temp;
            }

            // Create a boolean array and sets true for k sites with mines
            for (int i = 0; i < k; i++) {
                grid[sites[i]] = true;
            }

            /*
            // This shuffle gives a good random distribution using only
            // a grid of boolean sites (without using the int array).
            for (int i = 0; i < k; i++) {
                grid[i] = true;
            }
             for (int i = 0; i < k; i++) {
                int mineSite = i + (int) (Math.random() * (gridLength - i));
                boolean swap = grid[mineSite];
                grid[mineSite] = grid[i];
                grid[i] = swap;
            }
            */

            /* This method also works for random sites, but it's slower
            boolean[][] grid = new boolean[m][n];
            int cnt = 0;
            while (cnt < k) {
                int mineSite = (int) (Math.random()*m*n);
                if (!grid[mineSite / m][mineSite % n]) {
                    grid[mineSite / m][mineSite % n] = true;
                    cnt++;
                }
            }*/


            /* This code does not give a random site. !!Do not use this!!.
            for (int i = 0; i < k; i++) {
                int mineSite = (int) (Math.random()*gripLength);
                boolean swap = grip[mineSite];
                grip[mineSite] = grip[i];
                grip[i] = swap;
            }*/

            /*
            // trial for 1 site false
            for (int i = 0; i < gridLength; i++) {
                    if (!grid[i]) trialsResult[i]++;
            }*/
            /*
            // trial for 1 site true
            for (int i = 0; i < gridLength; i++) {
                if (grid[i]) trialsResult[i]++;
            }*/

            // trial for test true values random per site.
            for (int i = 0; i < trialsResult.length; i++) {
                if (grid[i]) trialsResult[i]++;
            }
        }

        System.out.printf("%-6s %-8s %-8s %n", "site", "result", "fraction");
        double fraction = 0.0;
        for (int i = 0; i < trialsResult.length; i++) {
            fraction = trialsResult[i] * 1.0 / trials;

            System.out.printf("%-6d %-8d %.6f %n", (i + 1), trialsResult[i], fraction);
        }
    }
}
