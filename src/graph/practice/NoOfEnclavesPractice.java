package graph.practice;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclavesPractice {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        };

//        int ans = noOfEnclavesDFS(grid);
        int ans2 = noOfEnclavesBFS(grid);
//        System.out.println("No of enclaves:" + ans);
        System.out.println("No of enclaves:" + ans2);
    }

    private static int noOfEnclavesDFS(int[][] grid) {

        int[][] neighbours = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        // find the boundary ones and run dfs on them
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dfsNoOfEnclaves(i, j, rows, cols, grid, visited, neighbours);
                    } else if (i == rows - 1 || j == cols - 1) {
                        dfsNoOfEnclaves(i, j, rows, cols, grid, visited, neighbours);
                    }
                }
            }
        }

        //find the visited array which will have all boundary 1s and adjacent ones visited ; keeping 1 within the grid (not on boundary unvisited)
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] != 1 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;

    }

    private static int noOfEnclavesBFS(int[][] grid) {

        int[][] neighbours = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // find the boundary ones and run dfs on them
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        visited[i][j] = 1;
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int pair[] = queue.poll();
            int row = pair[0];
            int col = pair[1];

            for (int i = 0; i < neighbours.length; i++) {
                int crow = row + neighbours[i][0];
                int ccol = col + neighbours[i][1];

                if (
                        crow >= 0 && crow < rows &&
                                ccol >= 0 && ccol < cols &&
                                visited[crow][ccol] != 1 &&
                                grid[crow][ccol] == 1
                ) {
                    visited[crow][ccol]=1;
                   queue.add(new int[]{crow, ccol});
                }
            }
        }
        //find the visited array which will have all boundary 1s and adjacent ones visited ; keeping 1 within the grid (not on boundary unvisited)
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] != 1 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;

    }

    private static void dfsNoOfEnclaves(int row, int col, int rows, int cols, int[][] grid, int[][] visited, int[][] neighbours) {
        visited[row][col] = 1;
        for (int i = 0; i < neighbours.length; i++) {
            int crow = row + neighbours[i][0];
            int ccol = col + neighbours[i][1];

            if (
                    crow >= 0 && crow < rows &&
                            ccol >= 0 && ccol < cols &&
                            visited[crow][ccol] != 1 &&
                            grid[crow][ccol] == 1
            ) {
                dfsNoOfEnclaves(crow, ccol, rows, cols, grid, visited, neighbours);
            }
        }
    }


}
