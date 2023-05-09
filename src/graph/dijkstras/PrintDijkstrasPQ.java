package src.graph.dijkstras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * ANy Graph with negative weights cannot be implemented with Dijkstras ; will result in infinite loop
 * */
public class PrintDijkstrasPQ {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 1, 4},
                {0, 2, 4},
                {1, 2, 2},
                {2, 3, 3},
                {2, 4, 1},
                {2, 5, 6},
                {3, 5, 2},
                {4, 5, 3}
        };

        int nodes = 6;
        int startNode = 0;
        List<List<DPair>> adjList = new ArrayList<>();

        List<Integer> path = dijkstrasAlgo(adjList, nodes, startNode, matrix, 4);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(" " + path.get(i));
        }
    }

    private static List<Integer> dijkstrasAlgo(List<List<DPair>> adjList, int nodes, int startNode, int[][] matrix, int dest) {
        createAdjList(nodes, adjList, matrix);
        System.out.println();

        PriorityQueue<PQPair> priorityQueue = new PriorityQueue<PQPair>();
        int distance[] = new int[nodes];
        int parent[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            distance[i] = (int) 1e9;
            parent[i] = i;
        }
        distance[startNode] = 0;
        priorityQueue.add(new PQPair(0, startNode));
        while (priorityQueue.size() != 0) {
            PQPair pair = priorityQueue.poll();
            int dist = pair.distance;
            int node = pair.node;
            for (DPair neighbour : adjList.get(node)) {
                int nWeight = neighbour.distance;
                int neighborNode = neighbour.node;
                if (dist + nWeight < distance[neighborNode]) {
                    distance[neighborNode] = dist + nWeight;
                    priorityQueue.add(new PQPair(distance[neighborNode], neighborNode));
                    parent[neighborNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (distance[dest] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = dest;
        while (parent[node] !=node){
            path.add(node);
            node = parent[node];
        }
        path.add(startNode);
        Collections.reverse(path);
        return path;
    }

    public static void createAdjList(int nodes, List<List<DPair>> adjList, int[][] matrix) {
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            adjList.get(matrix[i][0]).add(new DPair(matrix[i][1], matrix[i][2]));
            adjList.get(matrix[i][1]).add(new DPair(matrix[i][0], matrix[i][2]));
        }
    }
}


