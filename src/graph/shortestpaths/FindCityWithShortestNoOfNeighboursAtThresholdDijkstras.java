package src.graph.shortestpaths;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindCityWithShortestNoOfNeighboursAtThresholdDijkstras {
    public static void main(String[] args) {
//        int edges[][] = {
//                {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}
//        };
        int edges[][] = {
//                {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}
                {3, 5, 9558}, {1, 2, 1079}, {1, 3, 8040}, {0, 1, 9258}, {4, 7, 7558}, {5, 6, 8196}, {3, 4, 7284}, {1, 5, 6327}, {0, 4, 5966}, {3, 6, 8575}, {2, 5, 8604}, {1, 7, 7782}, {4, 6, 2857}, {3, 7, 2336}, {0, 6, 6}, {5, 7, 2870}, {4, 5, 5055}, {0, 7, 2904}, {1, 6, 2458}, {0, 5, 3399}, {6, 7, 2202}, {0, 2, 3996}, {0, 3, 7495}, {1, 4, 2262}, {2, 6, 1390}
        };

//        int n = 5;
        int n = 8;
//        int n = 4;
        int distanceThreshold = 7937;
//        int distanceThreshold = 4;
        int countCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int count = findShortestDistUsingDij(n, city, edges, distanceThreshold);
            System.out.println("City " + city + ": with thresholds: " + count);
            if (count <= countCity) {
                countCity = count;
                cityNo = city;
            }
        }
        System.out.println(cityNo);

    }

    public static int findShortestDistUsingDij(int n, int source, int[][] edges, int distanceThreshold) {

        //find the adjList
        ArrayList<ArrayList<NPair>> adjList = new ArrayList<>();
        createAdjListForNeighbours(adjList, edges, n);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        priorityQueue.add(new int[]{0, source});
        boolean visited[] = new boolean[n];
        int count = -1;
        while (!priorityQueue.isEmpty()) {
            int current[] = priorityQueue.poll();
            int weight = current[0];
            int node = current[1];
            if (visited[node])
                continue;
            visited[node] = true;
            count++;
            for (NPair pair : adjList.get(node)) {
                int adjWeight = pair.weight;
                int adjNode = pair.adjNode;
                if (!visited[adjNode] && weight + adjWeight <= distanceThreshold) {
                    priorityQueue.add(new int[]{weight + adjWeight, adjNode});
                }
            }

        }

        return count;

    }

    private static void createAdjListForNeighbours(ArrayList<ArrayList<NPair>> adjList, int[][] edges, int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new NPair(edges[i][2], edges[i][1]));
            adjList.get(edges[i][1]).add(new NPair(edges[i][2], edges[i][0]));
        }
    }


}

class NPair {

    int weight;
    int adjNode;

    public NPair(int weight, int adjNode) {
        this.adjNode = adjNode;
        this.weight = weight;
    }
}
