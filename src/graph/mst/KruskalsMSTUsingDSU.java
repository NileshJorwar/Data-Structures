package src.graph.mst;

import src.graph.disjointsets.DisjointSetsPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsMSTUsingDSU {
    public static void main(String[] args) {
        int edges[][] = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        List<Edge> adjList = new ArrayList<>();
        int v = 4;
        kruskalsDSUAlgo(v, edges, adjList);

    }

    private static void kruskalsDSUAlgo(int nodes, int[][] edges, List<Edge> adjList) {

        createAdjListKruskals(nodes, edges, adjList);

        DisjointSetsPractice disjointSetsPractice = new DisjointSetsPractice(nodes);
        Collections.sort(adjList);

        int mstWt = 0;
        for (Edge edge : adjList) {
            int wt = edge.wt;
            int src = edge.src;
            int dest = edge.dest;

            if (disjointSetsPractice.findUltimateParent(src)
                    != disjointSetsPractice.findUltimateParent(dest)) {
                mstWt += wt;
                disjointSetsPractice.unionBySize(src, dest);
            }
        }
        System.out.println(mstWt);

    }

    private static void createAdjListKruskals(int nodes, int[][] edges, List<Edge> adjList) {

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            adjList.add(new Edge(src, dest, wt));
        }

    }
}
