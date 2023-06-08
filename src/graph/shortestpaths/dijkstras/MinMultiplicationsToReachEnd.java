package src.graph.shortestpaths.dijkstras;

import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int arr[] = {2, 5, 7};
        int start = 3;
        int end = 420;
        int min = minMultiplications(arr, start, end);
        System.out.println("Min Multiplications needed: " + min);
    }

    private static int minMultiplications(int[] arr, int start, int end) {
        int res = 0;
        Queue<DPair> queue = new LinkedList<>();
        queue.add(new DPair(0, start));

        int distance[] = new int[100000];
        for (int i = 0; i < 100000; i++) {
            distance[i] = (int) 1e9;
        }

        distance[start] = 0;
        while (!queue.isEmpty()) {
            DPair dPair = queue.poll();
            //first element is distance
            int steps = dPair.node;
            int node = dPair.distance;

            for (int i = 0; i < arr.length; i++) {
                int num = (node * arr[i]) % 100000;
                if (steps + 1 < distance[num]) {
                    distance[num] = steps + 1;
                    //
                    if (num == end) {
                        return steps + 1;
                    }
                    queue.add(new DPair(steps + 1, num));
                }
            }

        }

        return res;

    }
}
