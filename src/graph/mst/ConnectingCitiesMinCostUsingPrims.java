package src.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectingCitiesMinCostUsingPrims {
    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        new ConnectingCitiesMinCostUsingPrims().minimumCost(n, connections);
    }

    public int minimumCost(int n, int[][] connections) {
        //Using Prims
        //Priority Queue
        //Visited Array, MSTArr, sum
        boolean visited[] = new boolean[n + 1];
        int mstSum = 0;
        List<int[]> mstList = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.add(new int[]{0, 1, -1});
        //needs adjList
        List<List<int[]>> adjList = new ArrayList<>();
        createAdjList(adjList, n, connections);

        while (!pq.isEmpty()) {

            int edge[] = pq.poll();
            int wt = edge[0];
            int node = edge[1];
            int parent = edge[2];
            if (visited[node])
                continue;
            if (parent != -1) {
                mstList.add(new int[]{node, parent});
            }
            mstSum += wt;
            visited[node] = true;
            for (int adj[] : adjList.get(node)) {
                int adjNode = adj[0];
                int adjWt = adj[1];
                if (!visited[adjNode]) {
                    pq.add(new int[]{adjWt, adjNode, node});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
            }
        }
        return count > 1 ? -1 : mstSum;
    }

    public void createAdjList(List<List<int[]>> adjList, int n, int[][] connections) {
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            adjList.get(connections[i][0]).add(new int[]{connections[i][1], connections[i][2]});
            adjList.get(connections[i][1]).add(new int[]{connections[i][0], connections[i][2]});
        }
    }
}
