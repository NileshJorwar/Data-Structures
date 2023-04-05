package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDFS {
    public static void main(String[] args) {
        int edges[][] = {
                {1, 2},
                {1, 3},
                {3, 4},
                {2, 5},
                {3, 6},
//                {5, 7},
                {6, 7},
                {8, 9},
                {9, 10},
                {10, 8},
        };
        int nodes = 10;
        boolean flag = detectCycleDFS(edges, nodes);
        System.out.println("Is Cycle Present: " + flag);
    }

    public static boolean detectCycleDFS(int[][] edges, int nodes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nodes + 1);
        createAdjList(adjList, nodes, edges);

        boolean visited[] = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                if (isCycle(i, -1, adjList, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int src, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        for (int adj : adjList.get(src)) {

            if (!visited[adj]) {
                if (isCycle(adj, src, adjList, visited) == true)
                    return true;
            } else if (adj != parent) {
                return true;
            }
        }
        return false;
    }

    public static void createAdjList(ArrayList<ArrayList<Integer>> adjList, int nodes, int[][] edges) {

        for (int i = 0; i < nodes + 1; i++) {
            adjList.add(new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }

}

class PairOfDFS {
    int node;
    int parent;

    PairOfDFS(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}