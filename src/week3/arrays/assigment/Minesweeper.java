package week3.arrays.assigment;

public class Minesweeper {
    public static void main(String[] args) {
        int m = 16;
        int n = 30;
        int k = 99;
        int gridLength = m * n;

        // Create and initialize an array with the sites
        int[] sites = new int[gridLength];
        for (int i = 0; i < gridLength; i++) {
            sites[i] = i;
        }
        // Shuffling only k sites
        for (int i = 0; i < k; i++) {
            int rndSite = i + (int) (Math.random() * (gridLength - i));
            int temp = sites[rndSite];
            sites[rndSite] = sites[i];
            sites[i] = temp;
        }

        // Creates a true mine boolean 2D-array to represents the grid
        boolean[][] grid = new boolean[m][n];
        // Set the first k random sites as true = mine in site i.
        for (int i = 0; i < k; i++) {
            grid[sites[i] / n] [sites[i] % n] = true;
        }

        // Check the grid to count the mines surrounding it every site
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if not mine check for surrounding sites
                if (!grid[i][j]) {
                    int neighborMines = 0;
                    // check top row
                    if (i != 0) {
                        if (j != 0 && grid[i - 1][j - 1]) neighborMines++;
                        if (grid[i - 1][j]) neighborMines++;
                        if (j != (n - 1) && grid[i - 1][j + 1]) neighborMines++;
                    }
                    // check site row
                    if (j != 0 && grid[i][j - 1]) neighborMines++;
                    if ((j != (n - 1)) && grid[i][j + 1]) neighborMines++;
                    // check button row
                    if (i != m - 1) {
                        if (j != 0 && grid[i + 1][j - 1]) neighborMines++;
                        if (grid[i + 1][j]) neighborMines++;
                        if ((j != (n - 1)) && grid[i + 1][j + 1]) neighborMines++;
                    }

                    System.out.print(neighborMines);
                } else {
                    // if mine site print a *
                    System.out.print("*");
                }
                // print double space between grid values or end of line
                if (j != (n - 1)) System.out.print("  ");
                else System.out.println();
            }

        }
        
        /*
        // Option 2: Create a boolean type linear array to represent the grid
        // with a true value for sites with mines
        boolean[] grid = new boolean[gridLength];
        // Set the first k random sites as true for mines.
        for (int i = 0; i < k; i++) {
            grid[sites[i]] = true;
        }

        // check for every space to count the mines surrounding it
        for (int i = 0; i < gridLength; i++) {
            // as the grid is a one dimensional array convert site
            // to row and col in order to check the grid boundaries sites
            int row = i / m;
            int col = i % n;
            // check for non-mine sites
            if (!grid[i]) {
                int neighborMines = 0;
                // check top row
                if (row != 0) {
                    if (col != 0 && grid[i - n - 1]) neighborMines++;
                    if (grid[i - n]) neighborMines++;
                    if (col != (n - 1) && grid[i - n + 1]) neighborMines++;
                }
                // check site row
                if (col != 0 && grid[i - 1]) neighborMines++;
                if ((col != (n - 1)) && grid[i + 1]) neighborMines++;
                // check button row
                if (row != m - 1) {
                    if (col != 0 && grid[i + n - 1]) neighborMines++;
                    if (grid[i + n]) neighborMines++;
                    if ((col != (n - 1)) && grid[i + n + 1]) neighborMines++;
                }
                System.out.print(neighborMines);
            } else {
                System.out.print("*");
            }

            if (i % n != (n - 1)) System.out.print("  ");
            else System.out.println();

        }
        */

    }
}
