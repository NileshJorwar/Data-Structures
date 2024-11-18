package graph.practice;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraphDFSPracitce {
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


        boolean flag = dfsDetectCycleDirectedGraph(matrix);
        System.out.println("Is Cycle Exixt in directed graph: " + flag);
    }

    private static boolean dfsDetectCycleDirectedGraph(int[][] matrix) {
        List<List<Integer>> adjList = new ArrayList<>();
        int nodes = matrix.length;
        createAdjListForCycleDetection(adjList, matrix, nodes);
        int[] visited = new int[nodes];
        int[] pathVisited = new int[nodes];
        for (int node = 0; node < nodes; node++) {
            if (visited[node] == 0) {
                if (dfsUtilP(node, nodes, adjList, adjList, visited, pathVisited))
                    return true;
            }

        }
        return false;
    }

    private static boolean dfsUtilP(int node, int nodes, List<List<Integer>> adjList, List<List<Integer>> adjList1, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;
        for (int neighbour : adjList.get(node)) {
            if (visited[neighbour] == 0) {
                if (dfsUtilP(neighbour, nodes, adjList, adjList, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbour] == 1) {
                return true;
            }

        }
        pathVisited[node] = 0;
        return false;
    }

    private static void createAdjListForCycleDetection(List<List<Integer>> adjList, int[][] matrix, int nodes) {

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 1) {
                    adjList.get(row).add(column);
                }
            }
        }
    }
}
