package src.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphATree {
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        //undirected graph
        int n = 5;
        int edges[][] = {
//                {1, 2}, {1, 3}, {2, 4}, {2, 5}, {4, 5}
                {1, 2}, {1, 3}, {3, 4}, {2, 5}
        };
        boolean flag = findGraphIsTree(n, edges);
        System.out.println("Graph a Tree:" + flag);
    }

    private static boolean findGraphIsTree(int n, int[][] edges) {
        //generate adjacency list for undirected graph
        boolean visited[] = new boolean[n + 1];
        adjancencyListCreate(n, edges);
        visited[0] = true;
        if (dfsCycle(1, visited, -1))
            return false;
        for (int u = 0; u < n; u++)
            if (!visited[u])
                return false;
        return true;
    }

    private static boolean dfsCycle(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;
        for (int eachVertex : adjList.get(vertex)) {
            if (!visited[eachVertex]) {
                if(dfsCycle(eachVertex, visited, vertex))
                    return true;
            } else if (eachVertex != parent)
                return true;
        }
        return false;
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
