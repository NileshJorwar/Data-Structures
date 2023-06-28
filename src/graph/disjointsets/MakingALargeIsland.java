package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakingALargeIsland {


    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}};
//        int[][] grid = {{1, 0}, {0, 1}};
        int maxSize = largestIsland(grid);
        System.out.println("MaxSize: " + maxSize);
    }

    public static int largestIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid.length;
        DisjointSetMAL disjointSetMAL = new DisjointSetMAL(rows * columns);
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1},
        };

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                //dont connect if not 1
                if (grid[row][col] == 0) {
                    continue;
                }
                //connect all once in neighbours for directions
                for (int neighbour = 0; neighbour < neighbours.length; neighbour++) {
                    int newRow = row + neighbours[neighbour][0];
                    int newCol = col + neighbours[neighbour][1];
                    if (isValid(newRow, newCol, rows, columns) && grid[newRow][newCol] == 1) {
                        int nodeNo = row * columns + col;
                        int adjNodeNo = newRow * columns + newCol;
                        disjointSetMAL.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        //step 2 ; try to convert 0 to 1;
        int max = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // here, if 1 then don't do nothing
                if (grid[row][col] == 1) {
                    continue;
                }
                Set<Integer> components = new HashSet<>();
                for (int neighbour = 0; neighbour < neighbours.length; neighbour++) {
                    int newRow = row + neighbours[neighbour][0];
                    int newCol = col + neighbours[neighbour][1];
                    if (isValid(newRow, newCol, rows, columns) && grid[newRow][newCol] == 1) {
                        //0s neighbour (1's )
                        //find the ultimate parent of adjNode and add to set
                        components.add(disjointSetMAL.findUltimateParent(newRow * columns + newCol));
                    }
                }
                int sizeTotal = 0;
                for (Integer parent : components) {
                    sizeTotal += disjointSetMAL.sizes.get(parent);
                }
                max = Integer.max(max, sizeTotal + 1);
            }
        }

        return max == 0 ? rows * columns: max;
    }

    private static boolean isValid(int newRow, int newCol, int rows, int columns) {
        return newRow < rows && newRow >= 0 && newCol < columns && newCol >= 0;
    }
}

class DisjointSetMAL {
    List<Integer> ranks = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();


    DisjointSetMAL(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            ranks.add(0);
            sizes.add(1);
            parent.add(i);
        }
    }


    public void unionByRank(int u, int v) {
        //find ultimate parent
        int u_ulp = findUltimateParent(u);
        int v_ulp = findUltimateParent(v);

        if (u_ulp == v_ulp)
            return;
        if (ranks.get(u_ulp) > ranks.get(v_ulp)) {
            parent.set(v_ulp, u_ulp);
        } else if (ranks.get(u_ulp) < ranks.get(v_ulp)) {
            parent.set(u_ulp, v_ulp);
        } else {
            parent.set(v_ulp, u_ulp);
            ranks.set(u_ulp, ranks.get(u_ulp) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if (ulp_u == ulp_v)
            return;
        if (sizes.get(ulp_u) < sizes.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            sizes.set(ulp_v, sizes.get(ulp_v) + sizes.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            sizes.set(ulp_u, sizes.get(ulp_u) + sizes.get(ulp_v));
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }
}
