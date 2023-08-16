package src.graph.scc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Strongly Connected Components:
 * Only applicable in directed graph.
 * Each node is traversable from each other node.
 * Steps:
 * Sort the edges according to their finishing time.
 * Reverse all the edges
 * Perform DFS
 */

public class KosarajusStronglyConnectedComps {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 4},
                {6, 7},
                {4, 7},

        };


        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int scc = kosarajusAlgo(adj, n);
        System.out.println("Strongly connected comps:" + scc);
    }

    private static int kosarajusAlgo(List<List<Integer>> adj, int nodes) {
        //sort the edges based on finishing time; use of stack
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i])
                dfs(adj, i, stack, visited);
        }

        //once the edges are sorted, reverse the graph using another Adjlist
        List<List<Integer>> adjReverse = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjReverse.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes; i++) {
            visited[i] = false;
            for (int adjNode : adj.get(i)
            ) {
                adjReverse.get(adjNode).add(i);
            }
        }

        //once reversed, used adjList new one and use stack to get the SCCs
        int scc = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                scc++;
                dfs(node, visited, adjReverse);
            }
        }

        return scc;

    }

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adjT) {
        visited[node] = true;
        for (int adjNode : adjT.get(node)
        ) {
            if (!visited[adjNode])
                dfs(adjNode, visited, adjT);
        }
    }

    private static void dfs(List<List<Integer>> adj, int node, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for (int adjNode : adj.get(node)
        ) {
            if (!visited[adjNode])
                dfs(adj, adjNode, stack, visited);
        }
        stack.push(node);
    }
}
