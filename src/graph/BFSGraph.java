package src.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
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
        Queue<Integer> queue = new LinkedList<>();
        //starting vertex
//        queue.add(1);
        queue.add(6);
//        visited[1] = true;
        visited[6] = true;
        List<Integer> bfsArray = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            bfsArray.add(currentVertex);
            List<Integer> neighbouringVertices = adjList.get(currentVertex);
            for (int neighbour : neighbouringVertices) {
                if (!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }

            }
        }
        System.out.println("BFS: " + bfsArray);

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
