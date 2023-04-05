package src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceNearestCell0Or01Matrix {
    public static void main(String[] args) {
//        int grid[][] = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {1, 1, 1}
//        };
        int grid[][] = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        //find the distance of nearest 1 in the cell
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = findNearestCell(grid, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(distance[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] findNearestCell(int[][] grid, int rows, int cols) {

        int distance[][] = new int[rows][cols];
        int visited[][] = new int[rows][cols];
        Queue<PairOfDistance> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    //starting the bfs from
                    queue.add(new PairOfDistance(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
            }
        }
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        //visited will look like {0,0,0),{0,1,0},{1,1,1}
        while (!queue.isEmpty()) {
            PairOfDistance pair = queue.poll();
            int currentRow = pair.row;
            int currentColum = pair.column;
            int steps = pair.steps;
            distance[currentRow][currentColum] = steps;
            for (int i = 0; i < neighbours.length; i++) {
                int nrow = currentRow + neighbours[i][0];
                int ncol = currentColum + neighbours[i][1];
                if (nrow >= 0 && nrow < rows &&
                        ncol >= 0 && ncol < cols &&
                        visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    queue.add(new PairOfDistance(nrow, ncol, steps + 1));
                }
            }
        }
        return distance;
    }
}
