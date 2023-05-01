package src.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**

 */

public class ShortestPathInDAGTopologicalSortDFS {
    public static void main(String[] args) {
        //graph with edge and unit weight of 1 hence weighted graph
        int graph[][] = {
                {0, 1}, {0, 3}, {3, 4}, {4, 5}
                , {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        int sourceNode = 0;
        int nodes = 8;
        int[] distance = shortestPath(graph, sourceNode, nodes);
        System.out.println("Shortest distance from : " + sourceNode);
        for (int d : distance
        ) {
            System.out.println(" " + d);
        }
    }

    private static int[] shortestPath(int graph[][], int sourceNode, int nodes) {

        List<List<PairWithWeight>> adjList = new ArrayList<>();
        createAdjList(adjList, nodes, graph);

        //find the topo sort
        int visited[] = new int[nodes];
        Stack<Integer> stack = new Stack<>();
        for (int node = 0; node < nodes; node++) {
            if (visited[node] == 0) {
                dfsTopo(node, visited, adjList, stack);
            }
        }
        System.out.println(stack);

        //to keep the minimum distance from source node; initially infinity
        int distance[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            distance[i] = (int) (1e9);
//            distance[i] = Integer.MAX_VALUE;
        }

        //Considering source node to be 0 ; from where distance will be calculated

        distance[sourceNode] = 0;
        while (!stack.isEmpty()) {

            int node = stack.pop();
            for (PairWithWeight pair : adjList.get(node)) {
                int n = pair.neighbour;
                int w = pair.weight;
                if (distance[node] + w < distance[n]) {
                    distance[n] = w + distance[node];
                }
            }

        }

        for (int i = 0; i < nodes; i++) {
            if (distance[i] == 1e9)
                distance[i] = -1;
        }

        return distance;
    }

    public static void dfsTopo(int node, int visited[], List<List<PairWithWeight>> adjList, Stack<Integer> stack) {
        visited[node] = 1;
        for (PairWithWeight neighbourWithWeight : adjList.get(node)) {
            int neighbour = neighbourWithWeight.neighbour;
            if (visited[neighbour] == 0) {
                dfsTopo(neighbour, visited, adjList, stack);
            }
        }
        stack.push(node);

    }

    public static void createAdjList(List<List<PairWithWeight>> adjList, int nodes, int[][] graph) {

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            //stored edges with weight; ex: 5--> {2,3}, {0,1}
            adjList.get(graph[i][0]).add(new PairWithWeight(graph[i][1], graph[i][2]));
        }

    }
}

class PairWithWeight {
    int neighbour;
    int weight;

    public PairWithWeight(int n, int w) {
        this.neighbour = n;
        this.weight = w;
    }
}
