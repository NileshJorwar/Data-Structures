package src.graph.mst;

import java.util.*;

public class ConnectingCitiesMinCostUsingKruskals {
    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        new ConnectingCitiesMinCostUsingKruskals().minimumCost(n, connections);
    }

    public int minimumCost(int n, int[][] connections) {
        //Using Kruskals
        //Sort all the edges as per weights (wt, node, parent)
        //Use Disjoint sets ; check for ultimateParent if not same , connect and compute mst
        //check if and only if single ultimate parent found, if not then return -1

        int mstSum = 0;
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));

        DSU dsu = new DSU(n + 1);

        for (int connection[] : connections) {
            int src = connection[0];
            int dest = connection[1];
            int wt = connection[2];

            if (dsu.findUltimateParent(src) != dsu.findUltimateParent(dest)) {
                mstSum += wt;
                dsu.unionByRank(src, dest);
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dsu.findUltimateParent(i) == i) {
                count++;
            }
        }

        return count != 1 ? -1 : mstSum;
    }
}

class DSU {

    List<Integer> ranks = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DSU(int n) {
        for (int i = 0; i <= n; i++) {
            ranks.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int pNode = findUltimateParent(parent.get(node));
        parent.set(node, pNode);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int up = findUltimateParent(u);
        int vp = findUltimateParent(v);

        if (ranks.get(up) < ranks.get(vp)) {
            parent.set(up, vp);
        } else if (ranks.get(up) > ranks.get(vp)) {
            parent.set(vp, up);
        } else {

            parent.set(vp, up);
            ranks.set(up, ranks.get(up) + ranks.get(vp));
        }
    }
}
