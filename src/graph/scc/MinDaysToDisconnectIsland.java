package src.graph.scc;

import java.util.List;

public class MinDaysToDisconnectIsland {
    public static void main(String[] args) {
        int grid[][] = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int ans = new MinDaysToDisconnectIsland().minDays(grid);
        System.out.println("Min Days required to disconnect:" + ans);
    }

    public int minDays(int[][] grid) {
        int scc = getComps(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        if (scc > 1 || scc==0) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;

                    if (getComps(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int getComps(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };
        int scc = 0;
        boolean visited[][] = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int row = i;
                int col = j;
                if (grid[i][j] == 1) {
                    if (!visited[i][j]) {
                        scc++;
                        dfs(i, j, grid, neighbours, visited, rows, cols);
                    }
                }
            }
        }
        return scc;
    }

    private void dfs(int i, int j, int grid[][], int[][] neighbours, boolean visited[][], int rows, int cols) {
        visited[i][j] = true;
        for (int k = 0; k < neighbours.length; k++) {
            int crow = i + neighbours[k][0];
            int ccol = j + neighbours[k][1];
            if (isValid(crow, ccol, rows, cols) && grid[crow][ccol] == 1) {
                if (!visited[crow][ccol])
                    dfs(crow, ccol, grid, neighbours, visited, rows, cols);
            }
        }
    }

    private boolean isValid(int crow, int ccol, int rows, int cols) {

        return crow >= 0 && crow < rows && ccol >= 0 && ccol < cols;
    }
}
