package src.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NoOfIslands {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph
        int grid[][] = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1},
        };
        System.out.println("Total Islands: " + findNoOfIslands(grid));
    }

    private static int findNoOfIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean visited[][] = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if (!visited[row][column] && grid[row][column] == 1) {
                    count++;
                    bfs(row, column, visited, grid);
                }
            }
        }
        return count;
    }

    public static void bfs(int row, int column, boolean visited[][], int[][] grid) {
        visited[row][column] = true;
        Queue<PairOfGraph> queue = new LinkedList<>();
        queue.add(new PairOfGraph(row, column));
        int acutalRow = grid.length;
        int actualColumn = grid[0].length;
        while (!queue.isEmpty()) {
            PairOfGraph pairOfGraph = queue.poll();
            int n = pairOfGraph.row;
            int m = pairOfGraph.column;
            //traverse neighbours
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delColumn = -1; delColumn <= 1; delColumn++) {
                    int nrow = n + delRow;
                    int ncol = m + delColumn;
                    //check if valid
                    if (nrow >= 0 && nrow < acutalRow && ncol >= 0 && ncol < actualColumn
                            //once the column/row are valid , next is to check if the current grid val is land
                            && grid[nrow][ncol] == 1 && !visited[nrow][ncol]
                    ) {
                        visited[nrow][ncol] = true;
                        queue.add(new PairOfGraph(nrow, ncol));
                    }
                }
            }
        }
    }
}

class PairOfGraph {
    int row;
    int column;

    PairOfGraph(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
