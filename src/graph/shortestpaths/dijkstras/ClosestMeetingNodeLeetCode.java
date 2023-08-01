package src.graph.shortestpaths.dijkstras;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestMeetingNodeLeetCode {
    public static void main(String[] args) {
//        int edges[] = {2, 2, 3, -1}, node1 = 0, node2 = 1;
//        int edges[] = {1, 2, -1}, node1 = 0, node2 = 2;
        int edges[] = {5,4,5,4,3,6,-1}, node1 = 0, node2 = 1;

        int node = closestMeetingNode(edges, node1, node2);
        System.out.println("Node: " + node);
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        List<List<Pair1>> adjList = new ArrayList<>();
        int len = edges.length;
        createAdjListForMeetingNodeExample(adjList, edges, len);

        int distance1[] = new int[len];
        int distance2[] = new int[len];

        PriorityQueue<Pair1> priorityQueue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        PriorityQueue<Pair1> priorityQueue2 = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        priorityQueue.add(new Pair1(0, node1));
        priorityQueue2.add(new Pair1(0, node2));
        for (int i = 0; i < len; i++) {
            distance1[i] = Integer.MAX_VALUE;
            distance2[i] = Integer.MAX_VALUE;
        }
        distance1[node1] = 0;
        distance2[node2] = 0;

        //calculate distance from node1

        while (!priorityQueue.isEmpty()) {
            Pair1 pair = priorityQueue.poll();
            int current_distance = pair.distance;
            int current_node = pair.node;

            for (Pair1 adjPair : adjList.get(current_node)) {
                int nw = adjPair.distance;
                int nn = adjPair.node;
                if (current_distance + nw < distance1[nn]) {
                    distance1[nn] = current_distance + nw;
                    priorityQueue.add(new Pair1(distance1[nn], nn));
                }
            }
        }
        //calculate distance from node2
        while (!priorityQueue2.isEmpty()) {
            Pair1 pair = priorityQueue2.poll();
            int current_distance = pair.distance;
            int current_node = pair.node;

            for (Pair1 adjPair : adjList.get(current_node)) {
                int nw = adjPair.distance;
                int nn = adjPair.node;
                if (current_distance + nw < distance2[nn]) {
                    distance2[nn] = current_distance + nw;
                    priorityQueue2.add(new Pair1(distance2[nn], nn));
                }
            }
        }
        int minNode = -1;
        int n9 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int m = Math.max(distance1[i], distance2[i]);
            if(m < n9){
                n9 = m;
                minNode = i;
            }
        }
        return minNode;
    }

    private static void createAdjListForMeetingNodeExample(List<List<Pair1>> adjList, int[] edges, int len) {

        for (int i = 0; i < len; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            if (edges[i] != -1)
                adjList.get(i).add(new Pair1(1, edges[i]));
        }
    }
}

class Pair1 {
    int distance, node;

    Pair1(int d, int n) {
        this.distance = d;
        this.node = n;
    }
}