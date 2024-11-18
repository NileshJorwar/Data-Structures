package graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static src.graph.DetectCycleDFS.createAdjList;

public class DetectCycleDirectedGDFS {
    public static void main(String[] args) {
        int edges[][] = {
                {1, 2},
                {1, 3},
                {3, 4},
                {2, 5},
                {3, 6},
                {5, 7},
                {6, 7}
        };
        int nodes = 7;
        boolean flag = detectCycleDFSDG(edges, nodes);
        System.out.println("Is Cycle Present: " + flag);
    }

    private static boolean detectCycleDFSDG(int[][] edges, int nodes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nodes + 1);
        createAdjList(adjList, nodes, edges);
        int[] visited = new int[nodes + 1];
        int[] pathVisited = new int[nodes + 1];
        for (int node = 1; node <= nodes; node++) {
            if (dfsDG(visited, pathVisited, adjList, node, nodes) == true)
                return true;
        }
        return false;
    }

    private static boolean dfsDG(int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adjList, int node, int nodes) {
        visited[node] = 1;
        pathVisited[node] = 1;
        for (int adjNode : adjList.get(node)) {
            if (visited[adjNode] != 1) {
                if (dfsDG(visited, pathVisited, adjList, adjNode, nodes) == true)
                    return true;
            } else if (pathVisited[adjNode] == 1) {
                return true;
            }
        }
        pathVisited[node] = 0;
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
