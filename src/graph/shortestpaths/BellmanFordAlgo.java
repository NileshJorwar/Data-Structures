package src.graph.shortestpaths;

import java.util.ArrayList;

public class BellmanFordAlgo {
    public static void main(String[] args) {

        int edges[][] = {
                {3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}
        };
        int nodes = 6;
        int d[] = bellmanFordAlgo(edges, nodes);
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }

    private static int[] bellmanFordAlgo(int[][] edges, int nodes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//        createAdjListForBellmanFord(edges, nodes, adjList);
        int distance[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            distance[i] = (int) 1e8;
        }
        distance[0] = 0;
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];

                if (distance[u] != 1e8 & distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        //iteration nth time to check cycle
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];

            if (distance[u] != 1e8 & distance[u] + wt < distance[v]) {
                return new int[]{-1};
            }
        }
        return distance;
    }

    private static void createAdjListForBellmanFord(int[][] edges, int nodes, ArrayList<ArrayList<Integer>> adjList) {
//        for (int i = 0; i < nodes; i++) {
//            adjList.add(new ArrayList<>());
//        }
//        for (int i = 0; i < edges.length; i++) {
//            adjList.get(edges[i][])
//        }
    }
}
