package src.graph.practice;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslandsPractice {
    public static void main(String[] args) {
        char grid[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        new NoOfIslandsPractice().numIslands(grid);
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int cnt = 0;
        boolean visited[][] = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, visited, grid, rows, columns);
                }
            }
        }
        System.out.println("Total Islands:" + cnt);
        return cnt;
    }

    public void bfs(int row, int col, boolean visited[][], char grid[][], int rows, int columns) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        while (!queue.isEmpty()) {
            int pair[] = queue.poll();
            int current_row = pair[0];
            int current_col = pair[1];
            for (int i = 0; i < neighbours.length; i++) {
                int nrow = current_row + neighbours[i][0];
                int ncol = current_col + neighbours[i][1];
                if (nrow >= 0 && nrow < rows
                        && ncol >= 0 && ncol < columns
                        && grid[nrow][ncol] == '1'
                        && visited[nrow][ncol] == false) {
                    visited[nrow][ncol] = true;
                    queue.add(new int[]{nrow, ncol});
                }

            }
        }
    }
}