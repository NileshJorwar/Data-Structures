package src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclavesBFS1 {
    public static void main(String[] args) {
//        int grid[][] = {
//                {0, 0, 0, 0},
//                {1, 0, 1, 0},
//                {0, 1, 1, 0},
//                {0, 0, 0, 0}
//        };
        int grid[][] = {
                {0, 1, 1, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

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
        for (int i = 0; i < cols; i++) {

            //first row
            if (visited[0][i] != 1 && grid[0][i] == 1) {
                visited[0][i] = 1;

                queue.add(new PairLandSea(0, i));
            }
            //last row
            if (visited[rows - 1][i] != 1 && grid[rows - 1][i] == 1) {
                visited[rows - 1][i] = 1;

                queue.add(new PairLandSea(rows - 1, i));
            }
        }
        //first and last column
        for (int i = 0; i < rows; i++) {

            //first row
            if (visited[i][0] != 1 && grid[i][0] == 1) {
                visited[i][0] = 1;

                queue.add(new PairLandSea(i, 0));
            }
            //last row
            if (visited[i][cols - 1] != 1 && grid[i][cols - 1] == 1) {
                visited[i][cols - 1] = 1;

                queue.add(new PairLandSea(i, cols - 1));
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
                if(visited[i][j]!=1 && grid[i][j]==1)
                    count++;
            }
        }
        System.out.println(count);
    }
}


