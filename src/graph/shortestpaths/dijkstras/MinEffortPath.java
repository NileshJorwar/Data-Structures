package src.graph.shortestpaths.dijkstras;

import java.util.PriorityQueue;

public class MinEffortPath {
    public static void main(String[] args) {
//        int[][] heights = {
//                {1, 2, 2}, {3, 8, 2}, {5, 3, 5}
//        };

        int[][] heights = {
                {1,10,6,7,9,10,4,9}
        };
        int ans = minEffortPath(heights);
        System.out.println("Ans:" + ans);
    }

    private static int minEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int distance[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        //marking starting distance being 0
        distance[0][0] = 0;

        //Make sure to have Tuple class below implement comparable interface to sort based on distance
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);
        priorityQueue.add(new Tuple(0, 0, 0));

        //to traverse in all for directions
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };

        while (priorityQueue.size() != 0) {
            Tuple current = priorityQueue.poll();
            int difference = current.distance;
            int current_row = current.row;
            int current_col = current.col;

            if (current_row == rows - 1 && current_col == cols - 1)
                return difference;
            for (int i = 0; i < neighbours.length; i++) {
                int nrow = current_row + neighbours[i][0];
                int ncol = current_col + neighbours[i][1];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols) {
                    int newDiff = Math.abs(heights[current_row][current_col] - heights[nrow][ncol]);
                    int newEffort = Math.max(newDiff, difference);
                    if (newEffort < distance[nrow][ncol]) {
                        distance[nrow][ncol] = newEffort;
                        priorityQueue.add(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}
