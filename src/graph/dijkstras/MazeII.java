package src.graph.dijkstras;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MazeII {
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
        int distance[][] = new int[grid.length][grid[0].length]; // to store the distance for each cell
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        //setting  distance of start[] node to 0
        distance[start[0]][start[1]] = 0;
         shortestDistanceDijkstra(distance, grid, start, destination);
        System.out.println("Shortest Path: " +  shortestDistanceDijkstra(distance, grid, start, destination));
    }

    private static int shortestDistanceDijkstra(int distance[][], int[][] grid, int[] start, int[] destination) {

        int rows = grid.length;
        int cols = grid[0].length;


        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{start[0], start[1], 0});
        int visited[][] = new int[rows][cols];
        //since traversal allowed in four directions
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };

        while (!queue.isEmpty()) {
            int tuple[] = queue.poll();
            int cdistance = tuple[2];
            int crow = tuple[0];
            int ccol = tuple[1];
            if (crow == destination[0] && ccol == destination[1]) {
                return 0;
            }
            for (int i[] : neighbours) {
                int nrow = crow + i[0];
                int ncol = ccol + i[1];
                int current_step = 1;
                while (nrow >= 0 && nrow < rows
                        && ncol >= 0 && ncol < cols
                        && grid[nrow][ncol] == 0) {

                    nrow += i[0];
                    ncol += i[1];
                    current_step++;
                }
                nrow -= i[0];
                ncol -= i[1];
                current_step--;
                if (distance[crow][ccol] + current_step < distance[nrow][ncol]) {
                    distance[nrow][ncol] = distance[crow][ccol] + current_step;
                    queue.add(new int[]{nrow, ncol, distance[crow][ccol]});
                }
            }
        }
       return distance[destination[0]][destination[1]] == 1e9 ? -1 : distance[destination[0]][destination[1]];
    }
}


