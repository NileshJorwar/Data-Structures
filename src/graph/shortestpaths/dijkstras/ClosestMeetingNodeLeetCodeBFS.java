package src.graph.shortestpaths.dijkstras;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestMeetingNodeLeetCodeBFS {
    public static void main(String[] args) {
//        int edges[] = {2, 2, 3, -1}, node1 = 0, node2 = 1;
//        int edges[] = {1, 2, -1}, node1 = 0, node2 = 2;
        int edges[] = {5, 4, 5, 4, 3, 6, -1}, node1 = 0, node2 = 1;

        int node = closestMeetingNode(edges, node1, node2);
        System.out.println("Node: " + node);
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int len = edges.length;

        int distance1[] = new int[len];
        int distance2[] = new int[len];

        for (int i = 0; i < len; i++) {
            distance1[i] = Integer.MAX_VALUE;
            distance2[i] = Integer.MAX_VALUE;
        }
        distance1[node1] = 0;
        distance2[node2] = 0;

        bfsCloseDistanceToNode(node1, distance1, edges);
        bfsCloseDistanceToNode(node2, distance2, edges);


        int minNode = -1;
        int minDistSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int max = Math.max(distance1[i], distance2[i]);
            if (max < minDistSoFar) {
                minDistSoFar = max;
                minNode = i;
            }
        }
        return minNode;
    }

    private static void bfsCloseDistanceToNode(int node, int[] distance, int[] edges) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        boolean visited[] = new boolean[edges.length];
        visited[node] = true;
        while (!queue.isEmpty()) {
            int current_node = queue.poll();
            int neighbour_node = edges[current_node];
            if (neighbour_node != -1 && !visited[neighbour_node]) {
                visited[neighbour_node] = true;
                distance[neighbour_node] = 1 + distance[current_node];
               queue.add(neighbour_node);
            }
        }
    }
}
