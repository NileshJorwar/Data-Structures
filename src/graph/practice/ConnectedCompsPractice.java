package src.graph.practice;

import java.util.ArrayList;
import java.util.List;

public class ConnectedCompsPractice {
    public static void main(String[] args) {
        int edges[][] = {
                {0, 1},
                {0, 3},
                {1, 2},
                {2, 3},
                {4, 5},
                {4, 6},
                {5, 6},
                {7, 7}
        };
        int nodes = 8;
        int comps = connectedComps(edges, nodes);
        System.out.println("Connected comps: " + comps);
    }

    private static int connectedComps(int[][] edges, int nodes) {
        //use dfs
        //create adjList
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjListForConnectedComps(adjList, edges, nodes);
        int comps = 0;
        //iterate through adjList for each node
        //when reaches end; found dfs
        boolean visited[] = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                comps++;
                dfsConnectedComps(i, adjList, visited);

            }
        }
        return comps;
    }

    private static void dfsConnectedComps(int i, List<List<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        for (int adjNode : adjList.get(i)) {
            if (!visited[adjNode]) {
                dfsConnectedComps(adjNode, adjList, visited);
            }
        }
    }

    private static void createAdjListForConnectedComps(List<List<Integer>> adjList, int[][] edges, int nodes) {
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }
}
