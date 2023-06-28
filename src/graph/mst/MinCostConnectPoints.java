package src.graph.mst;

import src.graph.disjointsets.DisjointSetsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostConnectPoints {
    public static void main(String[] args) {
        int points[][] = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
//        int points[][] = {
//                {3, 12},
//                {-2, 5},
//                {-4, 1},
//        };
        int res = minCostConnectPoints(points);
        System.out.println("Min cost:" + res);
    }

    private static int minCostConnectPoints(int[][] points) {
        int len = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int x = Math.abs(points[i][0] - points[j][0]);
                int y = Math.abs(points[i][1] - points[j][1]);
                //src,dest,wt
                int currentEdge[] = {i, j, x + y};
                edges.add(currentEdge);
            }
        }
        int minMst = 0;
        DisjointSetsPractice disjointSetsPractice = new DisjointSetsPractice(len - 1);
        Collections.sort(edges, (x, y) -> x[2] - y[2]);
        // use Kruskal's algo to find min weights using Disjoint Sets
        for (int edge[] : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];

            if (disjointSetsPractice.findUltimateParent(src)
                    != disjointSetsPractice.findUltimateParent(dest)) {
                minMst += wt;
                disjointSetsPractice.unionBySize(src, dest);
            }

        }
        return minMst;

    }
}
