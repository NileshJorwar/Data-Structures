package src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclavesDFS {
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

        int gridCopy[][] = grid;
        int count = 0;
        int visited[][] = new int[rows][cols];
        //first and last row
        for (int i = 0; i < cols; i++) {

            //first row
            if (visited[0][i] != 1 && grid[0][i] == 1) {
                visited[0][i] = 1;
                gridCopy[0][i] = 0;
                dfs(0,i,rows,cols,neighbours,gridCopy,visited);
            }
            //last row
            if (visited[rows - 1][i] != 1 && grid[rows - 1][i] == 1) {
                visited[rows - 1][i] = 1;
                gridCopy[rows - 1][i] = 0;
                dfs(rows-1,i,rows,cols,neighbours,gridCopy,visited);
            }
        }
        //first and last column
        for (int i = 0; i < rows; i++) {

            //first row
            if (visited[i][0] != 1 && grid[i][0] == 1) {
                visited[i][0] = 1;
                gridCopy[i][0] = 0;
                dfs(i,0,rows,cols,neighbours,gridCopy,visited);

            }
            //last row
            if (visited[i][cols - 1] != 1 && grid[i][cols - 1] == 1) {
                visited[i][cols - 1] = 1;
                gridCopy[i][cols - 1] = 0;
                dfs(i,cols-1,rows,cols,neighbours,gridCopy,visited);

            }
        }
        //the unvisited land with grid value being 1 gives us the answer
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(visited[i][j]!=1 && gridCopy[i][j]==1)
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int row, int column, int rows, int cols, int [][]neighbours, int [][]gridCopy, int [][]visited){
        visited[row][column]=1;
        for (int i = 0; i < neighbours.length; i++) {
            int nrow = row + neighbours[i][0];
            int ncol = column + neighbours[i][1];
            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && visited[nrow][ncol] != 1 && gridCopy[nrow][ncol] == 1) {
                gridCopy[nrow][ncol] = 0;
                dfs(nrow,ncol,rows,cols,neighbours,gridCopy,visited);
            }
        }
    }

}


class PairLandSea {
    int r;
    int c;

    PairLandSea(int r, int c) {
        this.r = r;
        this.c = c;

    }
}
