package src.graph;


import java.util.*;

class NoOfDistinctIslandsDFS {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph
        int grid[][] = {
                {1, 1, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 1, 0},
        };
        System.out.println("Total Distinct Islands: " + findNoOfDistinctIslands(grid));
    }

    /**
     * Coordinates
     * first set is
     * (0,0) (0,1), (1,0) subtract starting point  (0,0) from each coordinate and store in list i.e. (0,0)
     * (0,0) - (0,0) = "0 0"
     * (0,1) - (0,0) = "0 1"
     * (1,0) - (0,0) = "1 0"
     * hence list now = ["0 0", "0 1" "1 0"]
     * and set is {["0 0", "0 1" "1 0"]}
     * second set is
     * (0,3) subtract starting point (0,3) from each coordinate and store in list i.e.
     * (0,3) - (0,3) == "0 0"
     * hence list now = ["0 0"]
     * and set is { ["0 0", "0 1" "1 0"], ["0 0"] }
     * Third set trying to be but not
     * (3,2) (3,3) (4,2) subtract starting point (3,2) from each coordinate and store in list
     * (3,2) - (3,2) = "0 0"
     * (3,3) - (3,2) = "0 1"
     * (4,2) - (3,2) = "1 0"
     * * hence list now = ["0 0", "0 1" "1 0"]
     * when trying to add to set , since set already has list available and discard this
     * Four set trying to be but not
     * (4,0) subtract starting point (4,0) from each coordinate and store in list i.e.
     * (4,0) - (4,0) == "0 0"
     * hence list now = ["0 0"]
     * since set already has the list and does not add it to set giving us two list in the end and distinct islands
     */
    private static int findNoOfDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };
        int visited[][] = new int[rows][cols];
        //set to store the distinct islands
        Set<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] != 1 && grid[i][j] == 1) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    dfs(i, j, visited, neighbours, grid, i, j, arrayList);
                    set.add(arrayList);
                }
            }
        }
        return set.size();
    }
    public  static String addString(int row, int column){
        return row + " " + column;
    }
    public static void dfs(int row, int column, int visited[][], int[][] neighbours, int[][] grid, int row0, int col0, ArrayList arrayList) {
        visited[row][column] = 1;
        int rows = grid.length;
        int cols = grid[0].length;
        arrayList.add(addString(row-row0, column-col0));
        for (int i = 0; i < neighbours.length; i++) {
            int nrow = row + neighbours[i][0];
            int ncol = column + neighbours[i][1];
            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols
                    && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, visited, neighbours, grid, row0, col0, arrayList);
            }
        }
    }
}

