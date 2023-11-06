package src.graph.practice;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int grid[][] = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        };

        int result = new RottenOranges().rottenOranges(grid);
        System.out.println("No of steps to rotten oranges:" + result);
    }

    int rottenOranges(int grid[][]) {
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int visited[][] = new int[rows][cols];
        int cntFresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    cntFresh++;
            }
        }
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };
        int cnt = 0;
        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int row = current[0];
            int col = current[1];
            int step = current[2];
            steps = Math.max(step, steps);
            for (int i = 0; i < neighbours.length; i++) {
                int crow = row + neighbours[i][0];
                int ccol = col + neighbours[i][1];
                if (
                        crow >= 0 && crow < rows &&
                                ccol >= 0 && ccol < cols &&
                                grid[crow][ccol] == 1 && visited[crow][ccol] != 2
                ) {
                    queue.add(new int[]{crow, ccol, step + 1});
                    visited[crow][ccol] = 2;
                    cnt++;
                }
            }

        }

        if (cnt != cntFresh)
            return -1;
        System.out.println("Total Steps:" + steps);
        return steps;
    }
}
