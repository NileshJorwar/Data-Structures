package src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegionsReplaceOsWithXsBFS {

    public void solve(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int visited[][] = new int[rows][cols];
        //find neighbours vertically and horizontally
        int neighbours[][] = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},
        };

        Queue<PairRegions> queue = new LinkedList<>();
        //traverse first and last row
        for (int i = 0; i < cols; i++) {
            //first row
            if (visited[0][i] != 1 && matrix[0][i] == 'O') {
                queue.add(new PairRegions(0, i));
                visited[0][i] = 1;
            }
            //last row
            if (visited[rows - 1][i] != 1 && matrix[rows - 1][i] == 'O') {
                queue.add(new PairRegions(rows - 1, i));
                visited[rows - 1][i] = 1;
            }
        }


        //traverse first and last column
        for (int i = 0; i < rows; i++) {
            //first column
            if (visited[i][0] != 1 && matrix[i][0] == 'O') {
                queue.add(new PairRegions(i, 0));
                visited[i][0] = 1;
            }
            //last column
            if (visited[i][cols - 1] != 1 && matrix[i][cols - 1] == 'O') {
                queue.add(new PairRegions(i, cols - 1));
                visited[i][cols - 1] = 1;
            }
        }

        while (!queue.isEmpty()) {
            PairRegions p = queue.poll();
            int crow = p.row;
            int ccol = p.col;
            for (int i = 0; i < 4; i++) {
                int nrow = crow + neighbours[i][0];
                int ncol = ccol + neighbours[i][1];
                if (
                        nrow >= 0 && nrow < rows &&
                                ncol >= 0 && ncol < cols &&
                                visited[nrow][ncol] == 0 &&
                                matrix[nrow][ncol] == 'O'
                ) {
                    visited[nrow][ncol] = 1;
                    queue.add(new PairRegions(nrow, ncol));

                }
            }
        }
        //
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 'O')
                    matrix[i][j] = 'X';
            }
        }

    }

}

class PairRegions {
    int row;
    int col;

    PairRegions(int row, int col) {
        this.row = row;
        this.col = col;
    }
}