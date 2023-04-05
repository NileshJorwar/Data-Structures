package src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclavesBFS2 {
    public static void main(String[] args) {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
//        int grid[][] = {
//                {0, 1, 1, 0},
//                {1, 0, 1, 0},
//                {0, 1, 1, 0},
//                {0, 0, 0, 0}
//        };

        int rows = grid.length;
        int cols = grid[0].length;

        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };

        int count = 0;
        int visited[][] = new int[rows][cols];
        Queue<PairLandSea> queue = new LinkedList<>();
        //first and last row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //first row, first col, last row, last column
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if(grid[i][j]==1) {
                        visited[i][j] = 1;
                        queue.add(new PairLandSea(i, j));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            PairLandSea pairLandSea = queue.poll();
            int currentRow = pairLandSea.r;
            int currentColumn = pairLandSea.c;
            for (int i = 0; i < neighbours.length; i++) {
                int nrow = currentRow + neighbours[i][0];
                int ncol = currentColumn + neighbours[i][1];
                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && visited[nrow][ncol] != 1 && grid[nrow][ncol] == 1) {
                    visited[nrow][ncol] = 1;
                    queue.add(new PairLandSea(nrow, ncol));
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] != 1 && grid[i][j] == 1)
                    count++;
            }
        }
        System.out.println(count);
    }
}


