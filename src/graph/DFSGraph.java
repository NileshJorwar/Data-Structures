package src.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSGraph {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph
        int n = 9;
        int edges[][] = {
                {1, 2}, {1, 6}, {2, 3}, {2, 4}, {6, 7}, {6, 9}, {4, 5}, {7, 8}, {5, 8}
        };
        findBFS(n, edges);
    }

    private static void findBFS(int n, int[][] edges) {
        //generate adjacency list for undirected graph
        adjancencyListCreate(n, edges);
        System.out.println(adjList);
        // create a visited boolean array (size to increase if node does not start with 0)
        boolean visited[] = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        visited[0] = true;
        dfs(1, adjList, visited, result);
        System.out.println("BFS: " + result);

    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean visited[], List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int vertex : adjList.get(node)) {
            if (!visited[vertex])
                dfs(vertex, adjList, visited, result);
        }
    }

    private static void adjancencyListCreate(int n, int[][] edges) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }


}
