package graph.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoOfDistinctIslandsPractice {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 1, 0},
        };
        System.out.println("Total Distinct Islands: " + findNoOfDistinctIslandsPractice(grid));

    }

    private static int findNoOfDistinctIslandsPractice(int[][] grid) {
        int result = 0;

        int[][] neighbours = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];
        Set<List<Integer>> set = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                if (grid[row][column] == 1 & visited[row][column] == 0) {
                    List<Integer> arrayList = new ArrayList<>();
                    dfsCall(row, column, rows, cols, visited, grid, neighbours, arrayList, row, column);
                    set.add(arrayList);
                }
            }
        }
        return set.size();
    }

    private static void dfsCall(int row, int column, int rows, int cols, int[][] visited, int[][] grid,  int[][] neighbours, List<Integer> arrayList, int startRow, int startCol) {
        visited[row][column] = 1;
        arrayList.add(Math.abs(row-startRow), Math.abs(column-startCol));
        for(int adjNode = 0; adjNode < neighbours.length; adjNode++) {
            int crow = row + neighbours[adjNode][0];
            int ccol = column + neighbours[adjNode][1];
            if (crow < rows && crow >= 0
                    && ccol < cols & ccol >= 0
                    && visited[crow][ccol] == 0 && grid[crow][ccol] == 1) {
                dfsCall(crow, ccol, rows, cols, visited, grid, neighbours, arrayList, row, column);
            }

        }
    }
}
