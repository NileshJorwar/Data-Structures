package src.graph.shortestpaths.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class LoudAndRich {
     ArrayList<Integer>[] graph;
     int[] answer;
     int[] quiet;

    public static void main(String[] args) {
        int richer[][] = {
                {1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}
        };
        int quite[] =
                {3, 2, 5, 4, 6, 1, 7, 0};
        int result [] = new LoudAndRich().loudAndRich(richer, quite);

    }

    public  int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        graph = new ArrayList[N];
        answer = new int[N];
        this.quiet = quiet;

        for (int node = 0; node < N; ++node)
            graph[node] = new ArrayList<Integer>();

        for (int[] edge: richer)
            graph[edge[1]].add(edge[0]);

        Arrays.fill(answer, -1);
        for (int i = 0; i < N; i++) {
            dfsLoudRich(i);
        }
        return answer;
    }

    private  int dfsLoudRich(int node) {
        if(answer[node] == -1){
            answer[node] = node;
            for (int adjNode: graph[node]) {
                    int adj = dfsLoudRich(adjNode);
                    if(quiet[adj] < quiet[answer[node]]){
                        answer[node] = adj;
                    }
            }
        }
        return answer[node];
    }
}
