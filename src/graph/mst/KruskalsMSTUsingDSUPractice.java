package src.graph.mst;

import src.graph.disjointsets.DisjointSetsPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsMSTUsingDSUPractice {
    public static void main(String[] args) {
        int edges[][] = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        List<Edge> adjList = new ArrayList<>();
        int nodes = 5;
        kruskalsDSUAlgo(nodes, edges, adjList);

    }

    private static void kruskalsDSUAlgo(int nodes, int[][] edges, List<Edge> adjList) {
        createAdjListKruskals(nodes, edges, adjList);
        //Sort all the edges according to their weights
        Collections.sort(adjList);
        //Use DSU now
        DisjointSetsPractice disjointSetsPractice =
                new DisjointSetsPractice(nodes);
        List<int[]> mstArr = new ArrayList<>();
        int mstSum = 0;
        for (Edge ed :
                adjList) {
            int weight = ed.wt;
            int node = ed.src;
            int nNode = ed.dest;

            if (disjointSetsPractice.findUltimateParent(node)
                    != disjointSetsPractice.findUltimateParent(nNode)) {
                mstSum+=weight;
                mstArr.add(new int[]{node,nNode});
                disjointSetsPractice.unionByRank(node,nNode);
            }
        }
        System.out.println("Mst sum:" + mstSum);

    }

    private static void createAdjListKruskals(int nodes, int[][] edges, List<Edge> adjList) {
        for (int i = 0; i < edges.length; i++) {
            //node, neighbourNode, weight (sort on weight)
            adjList.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }
}
