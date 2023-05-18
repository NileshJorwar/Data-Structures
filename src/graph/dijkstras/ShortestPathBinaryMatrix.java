package src.graph.dijkstras;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0}, {1, 1, 0}, {1, 1, 0}
        };

        int distance = shortestDistanceDijkstras(grid);
        System.out.println("Shortest Path: " + distance);
    }

    private static int shortestDistanceDijkstras(int[][] grid) {


        int rows = grid.length;
        int cols = grid[0].length;
        //if source and destination does not contain 0
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }
        int distance[][] = new int[rows][cols]; // to store the distance for each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        distance[0][0] = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, 0, 0));
        //since traversal allowed in 8 directions
        int neighbours[][] = {
                {-1, 0},
                {-1, +1},
                {0, +1},
                {+1, +1},
                {+1, 0},
                {+1, -1},
                {0, -1},
                {-1, -1}
        };

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int cdistance = tuple.distance;
            int crow = tuple.row;
            int ccol = tuple.col;

            for (int i = 0; i < neighbours.length; i++) {
                int nrow = crow + neighbours[i][0];
                int ncol = ccol + neighbours[i][1];

                if (nrow >= 0 && nrow < rows
                        && ncol >= 0 && ncol < cols
                        //we are moving only if 0
                        && grid[nrow][ncol] == 0
                        && cdistance + 1 < distance[nrow][ncol]) {
                    distance[nrow][ncol] = cdistance + 1;
                    queue.add(new Tuple(1 + cdistance, nrow, ncol));
                }
            }
        }
        //if destination is 0 but not reachable through path
        return distance[rows - 1][cols - 1] == 1e9 ? -1 : distance[rows - 1][cols - 1] + 1;
    }
}


