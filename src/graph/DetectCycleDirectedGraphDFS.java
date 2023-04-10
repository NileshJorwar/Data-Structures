package src.graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraphDFS {
    public static void main(String[] args) {

        int matrix[][] = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        };
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        createAdjacencyListUsingMatrix(adjList, matrix);
        System.out.printf("");

        boolean res = dfsUtil(matrix, adjList);
    }

    private static boolean dfsUtil(int[][] matrix, ArrayList<ArrayList<Integer>> adjList) {
        int nodes = matrix.length;
        int vis[] = new int[nodes];
        int pathVis[] = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adjList, vis, pathVis) == true)
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int neighbour : adjList.get(node)) {
            if (vis[neighbour] == 0) {
                if (dfsCheck(neighbour, adjList, vis, pathVis) == true)
                    return true;
            } else if (pathVis[neighbour] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }

    private static void createAdjacencyListUsingMatrix(ArrayList<ArrayList<Integer>> adjList, int[][] matrix) {
        int nodes = matrix.length;
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    adjList.get(i).add(j);
            }
        }
    }
}
