package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    public static void main(String[] args) {


        //a graph that can be colored with only two colors and cannot be having adj node of same colors
        int graph[][] = {
                {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
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
                if (checkColor(colorVisitedNodes, i, adjList) == false)
                    return false;
            }
        }
        return true;
    }

    private static boolean checkColor(int[] colorVisitedNodes, int startNode, ArrayList<ArrayList<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colorVisitedNodes[startNode] = 0; // start with color 0 for node 0
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbour : adjList.get(currentNode)) {

                //give the adj node the opposite color of current node
                if (colorVisitedNodes[neighbour] == -1) {
                    colorVisitedNodes[neighbour] = 1 - colorVisitedNodes[currentNode];
                    queue.add(neighbour);
                }
                //if adj node having same color
                else if (colorVisitedNodes[neighbour] == colorVisitedNodes[currentNode])
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
