package src.graph.shortestpaths.dijkstras;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceMaze {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int start[] = {0, 4};
        int destination[] = {4, 4};

        int distance = shortestDistanceDijkstras(grid, start, destination);
        System.out.println("Shortest Path: " + distance);
    }

    private static int shortestDistanceDijkstras(int[][] grid, int[] start, int[] destination) {


        // if source and destination are same
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        int distance[][] = new int[rows][cols]; // to store the distance for each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        //setting  distance of start[] node to 0
        distance[start[0]][start[1]] = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, start[0], start[1]));
        //since traversal allowed in four directions
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
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
                        && grid[nrow][ncol] == 1
                        && cdistance + 1 < distance[nrow][ncol]) {
                    distance[nrow][ncol] = cdistance + 1;
                    if (nrow == destination[0] && ncol == destination[1])
                        return cdistance + 1;
                    queue.add(new Tuple(1 + cdistance, nrow, ncol));
                }
            }
        }
        return -1;
    }
}

class Tuple {
    int distance, row, col;

    Tuple(int d, int r, int c) {
        this.distance = d;
        this.row = r;
        this.col = c;
    }

//    @Override
//    public int compareTo(Tuple o) {
//        return Integer.compare(o.distance, this.distance);
//    }
}
