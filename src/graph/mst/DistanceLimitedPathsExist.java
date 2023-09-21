package src.graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DistanceLimitedPathsExist {
    public static void main(String[] args) {
        int n = 6;
        int[][] edgeList = {{0, 2, 4}, {0, 3, 2}, {1, 2, 3}, {2, 3, 1}, {4, 5, 5}};

        DistanceLimitedPathsExist ds =
                new DistanceLimitedPathsExist(n, edgeList);
        ds.query(2, 3, 2);
        ds.query(1, 3, 3);
        ds.query(2, 0, 3);
        ds.query(0, 5, 6);
    }

    DSU dsu;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        //Sort the edgeList
        Arrays.sort(edgeList, (x, y) -> x[2] - y[2]);
        dsu = new DSU(n);
        for (int edge[] : edgeList) {
            dsu.unionByRank(edge[0], edge[1], edge[2]);
        }
        // EdgeList Sorted 
        //         0 = {int[3]@696} [2, 3, 1]
        // 1 = {int[3]@697} [0, 3, 2]
        // 2 = {int[3]@698} [1, 2, 3]
        // 3 = {int[3]@699} [0, 2, 4]
        // 4 = {int[3]@700} [4, 5, 5]
        //Parents: [2, 2, 2, 2, 4, 4]
        //ranks: [0, 0, 1, 0, 1, 0]
        //limits: [2, 3, 0, 1, 0, 5]


    }

    public boolean query(int p, int q, int limit) {
        if ((dsu.findParent(p) == dsu.findParent(q))
                && (dsu.isFound(p, limit) && dsu.isFound(q, limit) == true)
        ) {
            System.out.println("true");
            return true;
        }
        System.out.println("false");

        return false;

    }

    private class DSU {
        List<Integer> parents = new ArrayList<>();
        List<Integer> ranks = new ArrayList<>();
        List<Integer> limits = new ArrayList<>();

        DSU(int n) {
            for (int i = 0; i < n; i++) {
                ranks.add(0);
                parents.add(i);
                limits.add(0);
            }
        }

        boolean isFound(int u, int limit) {
            int l = limits.get(u);

            return limits.get(u) < limit;
        }

        int findParent(int u) {
            if (u == parents.get(u)) {
                return u;
            }
            return findParent(parents.get(u));
        }

        void unionByRank(int u, int v, int limit) {

            int pu = findParent(u);
            int pv = findParent(v);

            if (pu == pv)
                return;
            if (ranks.get(pu) < ranks.get(pv)) {
                parents.set(pu, pv);
                limits.set(pu, limit);
            } else if (ranks.get(pu) > ranks.get(pv)) {
                parents.set(pv, pu);
                limits.set(pv, limit);
            } else {
                parents.set(pv, pu);
                limits.set(pv, limit);
                ranks.set(pu, ranks.get(pu) + 1);
            }
        }
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */