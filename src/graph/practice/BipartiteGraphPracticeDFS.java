package graph.practice;

import java.util.*;

public class BipartiteGraphPracticeDFS {
    public static void main(String[] args) {
        int graph[][] = {
//                {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
                {1, 3}, {0, 2}, {1, 3}, {0, 2}
        };

        boolean isBipartiteGraph = checkBipartite(graph);
        System.out.println("Is Bipartite: ?" + isBipartiteGraph);
    }

    private static boolean checkBipartite(int[][] graph) {

        List<List<Integer>> adjList = new ArrayList<>();
        createAdjListForBipartite(adjList, graph);
        int rows = graph.length;

        int[] colorsVisited = new int[rows];
        Arrays.fill(colorsVisited, -1);
        for (int i = 0; i < rows; i++) {
            if (colorsVisited[i] == -1) {
                if (!bipartiteDFS(i, colorsVisited, adjList, 0))
                    return false;
            }
        }
        return true;

    }

    private static boolean bipartiteDFS(int startNode, int[] colorsVisited, List<List<Integer>> adjList, int initialColor) {
        colorsVisited[startNode] = initialColor;
        for (int adjNode : adjList.get(startNode)) {
            if (colorsVisited[adjNode] == -1) {
                if (!bipartiteDFS(adjNode, colorsVisited, adjList, 1 - colorsVisited[startNode]))
                    return false;
            } else if (colorsVisited[adjNode] == colorsVisited[startNode]) {
                return false;
            }
        }
        return true;
    }


    private static void createAdjListForBipartite(List<List<Integer>> adjList, int[][] graph) {

        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }
    }
}
