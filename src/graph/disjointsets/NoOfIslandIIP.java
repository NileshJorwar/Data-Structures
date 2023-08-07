package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class NoOfIslandIIP {
    public static void main(String[] args) {
        int arr[][] = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
//        int arr[][] = { {0, 0}, {0, 1}};
//        int arr[][] = {{0, 0}, {7, 1}, {6, 1}, {3, 3}, {4, 1}};
        List<Integer> noOfIslands = new NoOfIslandIIP().numIslands2(3, 3, arr);
        System.out.println(noOfIslands);
    }

    private List<Integer> numIslands2(int rows, int cols, int[][] arr) {
        List<Integer> ans = new ArrayList<>();

        DisjointSets disjointSets = new DisjointSets(rows * cols);
        int visited[][] = new int[rows][cols];

        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int row = arr[i][0];
            int col = arr[i][1];
            if (visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            visited[row][col] = 1;
            count++;

            for (int j = 0; j < neighbours.length; j++) {
                int crow = row + neighbours[j][0];
                int ccol = col + neighbours[j][1];
                if (validNeighbour(crow, ccol, rows, cols)) {
                    if (visited[crow][ccol] == 1) {
                        int currentNodeNo = row * cols + col;
                        int adjNodeNo = crow * cols + ccol;

                        if (disjointSets.findUltimateParent(currentNodeNo) != disjointSets.findUltimateParent(adjNodeNo)) {
                            count--;
                            disjointSets.unionByRank(currentNodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }

    private boolean validNeighbour(int crow, int ccol, int rows, int cols) {
        return crow >= 0 && crow < rows && ccol >= 0 && ccol < cols;
    }
}
