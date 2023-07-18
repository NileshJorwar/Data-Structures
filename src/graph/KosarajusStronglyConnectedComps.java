package src.graph;

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
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };


        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        int comps = kosarajusAlgo(adj, n);
    }

    private static int kosarajusAlgo(List<List<Integer>> adj, int nodes) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                dfs(adj, i, stack, visited);
            }
        }

        System.out.println(stack);
        //found nodes with finishing time
        //now, reverse the edges, hence create new adjList

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjT.add(new ArrayList<>());

        }
        for (int i = 0; i < nodes; i++) {
            visited[i]=false;
            for (int adjNode: adj.get(i)
                 ) {
                adjT.get(adjNode).add(i);
            }
        }

        System.out.println(adjT);
        int scc = 0;
        while(!stack.isEmpty()){

            int node= stack.pop();
            if(!visited[node]){
                scc++;
                dfs(node, visited, adjT);
            }

        }

        return scc;
    }

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adjT) {
        visited[node] = true;
        for (int adjNode : adjT.get(node)
        ) {
            if(!visited[adjNode]){
                dfs(adjNode, visited, adjT);
            }
        }
    }

    private static void dfs(List<List<Integer>> adj, int node, Stack<Integer> stack, boolean[] visited) {
        visited[node] = true;
        for (int adjNode : adj.get(node)
        ) {
            if(!visited[adjNode]){
                dfs(adj, adjNode, stack,visited);
            }
        }
        stack.push(node);
    }
}
