package src.graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphPractice {
    public static void main(String[] args) {
        int n = 9;
        int edges[][] = {
                {1, 2}, {1, 6}, {2, 3}, {2, 4}, {6, 7}, {6, 9}, {4, 5}, {7, 8}, {5, 8}
        };
        findBFSPractice(n, edges, 6);
    }

    private static void findBFSPractice(int n, int[][] edges, int start) {
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjListForBFS(adjList, edges, n);
        System.out.println();
        //level wise traversal
        //hence needs queue
        //also needs to have starting point
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        //Visited array to keep track of
        boolean visited[] = new boolean[n + 1];
        visited[start] = true;

        List<Integer> bfsArray = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsArray.add(current);
            for (int adjNode : adjList.get(current)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }

        }

        System.out.println("BFS Array:" + bfsArray);
    }

    private static void createAdjListForBFS(List<List<Integer>> adjList, int[][] edges, int n) {
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
    }
}
