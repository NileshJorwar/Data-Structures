package src.graph.shortestpaths.dijkstras.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * ANy Graph with negative weights cannot be implemented with Dijkstras ; will result in infinite loop
 * */
public class DijkstrasPQPractice {
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
        practiceDijkstras(nodes, startNode, matrix);
    }

    private static int[] practiceDijkstras(int nodes, int startNode, int[][] matrix) {
        List<List<int[]>> adjList = new ArrayList<>();
        createAdjlistPractice(adjList, nodes, matrix);

        //initiate distance array with inifinities
        int distanceArr[] = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            distanceArr[i] = (int) 1e9;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        distanceArr[startNode] = 0;
        pq.add(new int[]{0, startNode});

        while (!pq.isEmpty()) {

            int current[] = pq.poll();

            int node = current[1];
            int dist = current[0];

            for (int[] adj : adjList.get(node)) {

                int neighbour = adj[0];
                int neighbourDist = adj[1];

                if (dist + neighbourDist < distanceArr[neighbour]) {
                    distanceArr[neighbour] = dist + neighbourDist;
                    pq.add(new int[]{dist + neighbourDist, neighbour});
                }
            }
        }

        for (int i = 0; i < distanceArr.length; i++) {
            System.out.println("" + distanceArr[i]);
        }
        return distanceArr;

    }

    private static void createAdjlistPractice(List<List<int[]>> adjList, int nodes, int[][] matrix) {

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            adjList.get(matrix[i][0]).add(new int[]{matrix[i][1], matrix[i][2]});
            adjList.get(matrix[i][1]).add(new int[]{matrix[i][0], matrix[i][2]});
        }
    }

}
