package src.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirectedGraphUnitDistance {
    public static void main(String[] args) {
        //undirected graph
        int graph[][] = {
                {0, 1}, {0, 3}, {3, 4}, {4, 5}
                , {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        int sourceNode = 0;
        int nodes = 9;
        int[] distance = shortestPath(graph, sourceNode, nodes);
        System.out.println("Shortest distance from : " + sourceNode);
        for (int d : distance
        ) {
            System.out.println(" " + d);
        }
    }

    private static int[] shortestPath(int graph[][], int sourceNode, int nodes) {

        List<List<Integer>> adjList = new ArrayList<>();
        createAdjList(adjList, nodes, graph);
        int[] distance = new int[nodes];

        //set distance to infinity
        for (int i = 0; i < nodes; i++) {
            distance[i] = (int) 1e9;
        }

        distance[sourceNode] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjList.get(node)) {
                if (distance[node] + 1 < distance[neighbour]) {
                        distance[neighbour] = 1 + distance[node];
                        queue.add(neighbour);
                }
            }
        }

        for (int i = 0; i < nodes; i++) {
            if(distance[i]== (int) 1e9){
                distance[1]=-1;
            }
        }
        return distance;
    }

    public static void createAdjList(List<List<Integer>> adjList, int nodes, int[][] graph) {

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            //stored edges with weight; ex: 5--> {2,3}, {0,1}
            adjList.get(graph[i][0]).add(graph[i][1]);
            adjList.get(graph[i][1]).add(graph[i][0]);
        }

    }
}



