package src.graph.shortestpaths.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WaysToReachDestination {

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}
        };

        int paths = countPaths(n, roads);
        System.out.println("Total Paths: " + paths);
    }

    private static int countPaths(int n, int[][] roads) {
        int ways[] = new int[n];
            int mod = (int) (1e9 + 7);

        ArrayList<ArrayList<DistRoadPair>> adjList = new ArrayList<>();
        createAdjRoads(adjList, n, roads);
        int distance[] = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }

        distance[0] = 0;
        ways[0] = 1;
        PriorityQueue<DistRoadPair> priorityQueue = new PriorityQueue<>((x,y)-> x.node - y.node);
        priorityQueue.add(new DistRoadPair(0, 0));

        while (!priorityQueue.isEmpty()) {
            DistRoadPair pair = priorityQueue.poll();
            int dist = pair.node;
            int node = pair.dist;

            for (DistRoadPair neighbour : adjList.get(node)) {
                int adjRoad = neighbour.node;
                int adjRoadDist = neighbour.dist;
                //so first time coming
                if (dist + adjRoadDist < distance[adjRoad]) {
                    distance[adjRoad] = dist + adjRoadDist;
                    priorityQueue.add(new DistRoadPair(dist + adjRoadDist, adjRoad));
                    ways[adjRoad] = ways[node];
                } else if (dist + adjRoadDist == distance[adjRoad]) {
                    ways[adjRoad] = (ways[adjRoad] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    public static void createAdjRoads(ArrayList<ArrayList<DistRoadPair>> adjList, int n, int[][] roads) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adjList.get(roads[i][0]).add(new DistRoadPair(roads[i][1], roads[i][2]));
            adjList.get(roads[i][1]).add(new DistRoadPair(roads[i][0], roads[i][2]));
        }
    }
}

class DistRoadPair {
    int node;
    int dist;

    public DistRoadPair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
