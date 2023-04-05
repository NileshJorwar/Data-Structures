package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBFS {
    public static void main(String[] args) {
        int edges[][] = {
                {1, 2},
                {1, 3},
                {3, 4},
                {2, 5},
                {3,6},
                {5, 7},
                {6, 7}
        };
        int nodes = 7;
        boolean flag = detectCycleBFS(edges, nodes);
        System.out.println("Is Cycle Present: " + flag);
    }

    public static boolean detectCycleBFS(int[][] edges, int nodes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nodes + 1);
        createAdjList(adjList, nodes, edges);

        boolean visited[] = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                if (isCycle(i, nodes, adjList, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int src, int nodes, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[src] = true;
        Queue<PairOfCycle> queue = new LinkedList<>();
        queue.add(new PairOfCycle(src, -1));
        while (!queue.isEmpty()) {
            PairOfCycle pair = queue.poll();
            int srcNode = pair.node;
            int parent = pair.parent;

            for (int adjNode : adjList.get(srcNode)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.add(new PairOfCycle(adjNode, srcNode));
                } else if (parent != adjNode) {
                    return true;
                }
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

class PairOfCycle {
    int node;
    int parent;

    PairOfCycle(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}