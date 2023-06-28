package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    public static void main(String[] args) {
        int edges[][] = {{1, 2}, {1, 3}, {2, 3}};
        findRedundantConnection(edges);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        DisjointSetMAL1 ds = new DisjointSetMAL1(edges.length);
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            if ((ds.unionBySize(edges[i][0], edges[i][1])) == false)
                return new int[]{edges[i][0], edges[i][1]};
        }
        return new int[]{};
    }
}

class DisjointSetMAL1 {
    List<Integer> ranks = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();


    DisjointSetMAL1(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            ranks.add(0);
            sizes.add(1);
            parent.add(i);
        }
    }


    public void unionByRank(int u, int v) {
        //find ultimate parent
        int u_ulp = findUltimateParent(u);
        int v_ulp = findUltimateParent(v);

        if (u_ulp == v_ulp)
            return;
        if (ranks.get(u_ulp) > ranks.get(v_ulp)) {
            parent.set(v_ulp, u_ulp);
        } else if (ranks.get(u_ulp) < ranks.get(v_ulp)) {
            parent.set(u_ulp, v_ulp);
        } else {
            parent.set(v_ulp, u_ulp);
            ranks.set(u_ulp, ranks.get(u_ulp) + 1);
        }
    }

    public boolean unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if (ulp_u == ulp_v)
            return false;
        if (sizes.get(ulp_u) < sizes.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            sizes.set(ulp_v, sizes.get(ulp_v) + sizes.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            sizes.set(ulp_u, sizes.get(ulp_u) + sizes.get(ulp_v));
        }
        return true;
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }
}
