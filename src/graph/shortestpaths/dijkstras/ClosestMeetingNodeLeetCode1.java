package src.graph.shortestpaths.dijkstras;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestMeetingNodeLeetCode1 {
    public static void main(String[] args) {
//        int edges[] = {2, 2, 3, -1}, node1 = 0, node2 = 1;
//        int edges[] = {1, 2, -1}, node1 = 0, node2 = 2;
        int edges[] = {5,4,5,4,3,6,-1}, node1 = 0, node2 = 1;

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

        boolean visited[] = new boolean[len];
        boolean visited2[] = new boolean[len];
        dfsNew(node1, distance1, visited, edges);
        dfsNew(node2, distance2, visited2, edges);


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

    private static void dfsNew(int node, int[] distance, boolean[] visited, int[] edges) {
        visited[node] = true;
        int nextNode= edges[node];
        if(nextNode!=-1 && !visited[nextNode]){
            distance[nextNode] = 1 + distance[node];
            dfsNew(nextNode, distance, visited, edges);
        }
    }
}
