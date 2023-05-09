package src.graph.dijkstras;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
* ANy Graph with negative weights cannot be implemented with Dijkstras ; will result in infinite loop
* */
public class DijkstrasPQ {
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

        int distance[] = dijkstrasAlgo(adjList, nodes, startNode, matrix);
        for (int i = 0; i < distance.length; i++) {
            System.out.println(" " + distance[i]);
        }
    }

    private static int[] dijkstrasAlgo(List<List<DPair>> adjList, int nodes, int startNode, int[][] matrix) {
        createAdjList(nodes, adjList, matrix);
        System.out.println();

        PriorityQueue<PQPair> priorityQueue = new PriorityQueue<PQPair>();
        int distance[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            distance[i] = (int) 1e9;
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
                }
            }
        }
        return distance;
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

class DPair {
    int node;
    int distance;

    DPair(int n, int d) {
        this.node = n;
        this.distance = d;
    }
}

class PQPair implements Comparable<PQPair> {
    int distance;
    int node;

    PQPair(int d, int n) {
        this.distance = d;
        this.node = n;
    }

    @Override
    public int compareTo(PQPair other) {
        return Integer.compare(this.distance, other.distance);
    }
}