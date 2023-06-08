package src.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgoSpanningTree {
    public static void main(String[] args) {
        int edges[][] = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
//        int edges[][] = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int node = 5;
        primsAlgoSpanningTree(edges, node);
    }

    private static void primsAlgoSpanningTree(int[][] edges, int nodes) {

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        createAdjListForPrimsAlgo(adjList, edges, nodes);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        //visited array to mark nodes as visited
        int visited[] = new int[nodes];

        //add source/first node to the priorityQueue with parent being -1
        priorityQueue.add(new int[]{0, 0, -1});

        int minSum = 0;
        List<int[]> mst = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            int peek[] = priorityQueue.poll();
            int distance = peek[0];
            int node = peek[1];
            int parent = peek[2];

            if (visited[node] == 1)
                continue;
            if (parent != -1)
                mst.add(new int[]{node, parent});
            visited[node] = 1;
            minSum += distance;

            for (int neighbour[] : adjList.get(node)) {
                int neighbourWt = neighbour[1];
                int neighbourNode = neighbour[0];
                if (visited[neighbourNode] == 0)
                    priorityQueue.add(new int[]{neighbourWt, neighbourNode, node});
            }
        }

        System.out.println("MST sum : " + minSum + " and MST is:" + mst);

    }

    private static void createAdjListForPrimsAlgo(ArrayList<ArrayList<int[]>> adjList, int[][] edges, int nodes) {
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjList.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
    }
}
