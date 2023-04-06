package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphDFS {
    public static void main(String[] args) {


        //a graph that can be colored with only two colors and cannot be having adj node of same colors
        int graph[][] = {
                {2, 3, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9},
                {0, 1, 3, 4, 5, 6, 7, 8, 9},
                {0, 1, 2, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 6, 9},
                {0, 1, 2, 3, 7, 8, 9},
                {0, 1, 2, 3, 4, 7, 8, 9},
                {0, 1, 2, 3, 5, 6, 8, 9},
                {0, 1, 2, 3, 5, 6, 7},
                {0, 1, 2, 3, 4, 5, 6, 7}
        };
        // graph is zero based node
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        createAdjacencyList(adjList, graph);
        System.out.println(adjList);

        int colorVisitedNodes[] = new int[graph.length];
        for (int i = 0; i < colorVisitedNodes.length; i++) {
            colorVisitedNodes[i] = -1;
        }
        boolean b = findBipartiteGraph(colorVisitedNodes, adjList);
        System.out.println(b);
    }

    private static boolean findBipartiteGraph(int[] colorVisitedNodes, ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            if (colorVisitedNodes[i] == -1) {
                if (dfs(0, colorVisitedNodes, i, adjList) == false)
                    return false;
            }
        }
        return true;
    }

    private static boolean dfs(int color, int[] colorVisitedNodes, int startNode, ArrayList<ArrayList<Integer>>
            adjList) {
        colorVisitedNodes[startNode] = color;
        for (int neighbour : adjList.get(startNode)) {
                if (colorVisitedNodes[neighbour] == -1) {
                    if (dfs(1 - color, colorVisitedNodes, neighbour, adjList) == false)
                        return false;
                }
            else if (colorVisitedNodes[neighbour] == colorVisitedNodes[startNode]) {
                return false;
            }
        }
        return true;
    }

    private static void createAdjacencyList(ArrayList<ArrayList<Integer>> adjList, int graph[][]) {
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
