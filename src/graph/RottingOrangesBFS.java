package src.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesBFS {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph

        int grid[][] = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 2}
        };
        int ans = findMin(grid);
        System.out.println("Min Time required:" + ans);

    }

    private static int findMin(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int visited[][] = new int[rows][cols];
        int cntFreshOriginal = 0;
        int cntOfFreshOrange=0;
        Queue<PairOfOranges> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //add to the queue the rotten oranges
                //fill visited array with rotten and empty oranges
                if (grid[i][j] == 2) {
                    queue.add(new PairOfOranges(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if(grid[i][j]==1)
                    cntFreshOriginal++;
            }
        }

        int neighbours[][] = new int[][]{
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };
        int tm = 0;
        while (!queue.isEmpty()) {
            PairOfOranges pairOfOranges =
                    queue.poll();
            int currentRottenRow = pairOfOranges.row;
            int currentRottenColumn = pairOfOranges.column;
            int currentTime = pairOfOranges.time;
            tm = Math.max(currentTime, tm);
            for (int i = 0; i < neighbours.length; i++) {
                int nrow = currentRottenRow + neighbours[i][0];
                int ncolumn = currentRottenColumn + neighbours[i][1];
                if (
                        nrow >= 0 && nrow < rows &&
                                ncolumn >= 0 && ncolumn < cols &&
                                grid[nrow][ncolumn] == 1 && visited[nrow][ncolumn] != 2
                ) {
                    queue.add(new PairOfOranges(nrow, ncolumn, tm + 1));
                    visited[nrow][ncolumn] = 2;
                    cntOfFreshOrange++;
                }
            }
        }
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if(visited[i][j]!=2 && grid[i][j]==1){
//                    return -1;
//                }
//            }
//        }
        //alternate
        if(cntOfFreshOrange!=cntFreshOriginal)
            return -1;
        return tm;
    }

}

class PairOfOranges {
    int row;
    int column;
    int time;

    public PairOfOranges(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}
