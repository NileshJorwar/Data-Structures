package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class NoOfIslandsII {
    public static void main(String[] args) {
//        int arr[][] = { {0, 0}, {0, 1}, {1, 2}, {2, 1}};
//        int arr[][] = { {0, 0}, {0, 1}};
        int arr[][] = {{0, 0}, {7, 1}, {6, 1}, {3, 3}, {4, 1}};
        List<Integer> noOfIslands = numIslands2(8, 4, arr);
        System.out.println(noOfIslands);
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        DisjointSetsDS disjointSetsDS = new DisjointSetsDS(n * m);
        int visited[][] = new int[m][n];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int neighbours[][] = {
                {-1, 0},
                {0, +1},
                {+1, 0},
                {0, -1}
        };

        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            if (visited[row][col] == 1) {
                ans.add(count);
                continue;
            }
            visited[row][col] = 1;
            count++;

            for (int j = 0; j < neighbours.length; j++) {
                int adjRow = row + neighbours[j][0];
                int adjCol = col + neighbours[j][1];
                if (isValidNeighbour(adjRow, adjCol, n, m)) {
                    if (visited[adjRow][adjCol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = adjRow * n + adjCol;
                        if (disjointSetsDS.findUltimateParent(nodeNo) != disjointSetsDS.findUltimateParent(adjNodeNo)) {
                            count--;
                            disjointSetsDS.unionByRank(nodeNo, adjNodeNo);
                        }
                    }
                }
            }

            ans.add(count);
        }


        return ans;
    }

    private static boolean isValidNeighbour(int adjRow, int adjCol, int n, int m) {
        return adjRow < m && adjRow >= 0 && adjCol < n && adjCol >= 0;
    }
}

class DisjointSetsDS {
    private List<Integer> ranks = new ArrayList<>();
    private List<Integer> sizes = new ArrayList<>();
    private List<Integer> parent = new ArrayList<>();

    public DisjointSetsDS(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            ranks.add(0);
            sizes.add(1);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node))
            return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {

        int u_ulp = findUltimateParent(u);
        int v_ulp = findUltimateParent(v);

        if (u_ulp == v_ulp)
            return;
        if (ranks.get(u_ulp) < ranks.get(v_ulp)) {
            parent.set(u_ulp, v_ulp);
        } else if (ranks.get(u_ulp) > ranks.get(v_ulp)) {
            parent.set(v_ulp, u_ulp);
        } else {
            parent.set(v_ulp, u_ulp);
            ranks.set(u_ulp, ranks.get(u_ulp) + 1);
        }

    }

    public void unionBySize(int u, int v) {

        int u_ulp = findUltimateParent(u);
        int v_ulp = findUltimateParent(v);

        if (u_ulp == v_ulp)
            return;
        if (sizes.get(u_ulp) < sizes.get(v_ulp)) {
            parent.set(u_ulp, v_ulp);
            sizes.set(v_ulp, sizes.get(u_ulp) + sizes.get(v_ulp));
        } else {
            parent.set(v_ulp, u_ulp);
            sizes.set(u_ulp, sizes.get(u_ulp) + sizes.get(v_ulp));
        }

    }
}
