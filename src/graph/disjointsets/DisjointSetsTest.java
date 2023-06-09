package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetsTest {

    //Initialize ranks with 0 values for all nodes, sizes with 1 as initial size and parent being self
    List<Integer> ranks = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSetsTest(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            ranks.add(0);
            sizes.add(1);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v)
            return;
        if (ranks.get(ulp_u) < ranks.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (ranks.get(ulp_u) > ranks.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = ranks.get(ulp_u);
            ranks.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v)
            return;
        if (sizes.get(ulp_u) < sizes.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            sizes.set(ulp_v, sizes.get(ulp_v) + sizes.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            sizes.set(ulp_u, sizes.get(ulp_u) + sizes.get(ulp_v));
        }
    }

    public static void main(String[] args) {
        DisjointSetsTest disjointSets = new DisjointSetsTest(7);
        disjointSets.unionByRank(1, 2);
        disjointSets.unionByRank(2, 3);
        disjointSets.unionByRank(4, 5);
        disjointSets.unionByRank(5, 6);
        disjointSets.unionByRank(6, 7);

        //3 == 7?
        if (disjointSets.findUltimateParent(3) == disjointSets.findUltimateParent(7))
            System.out.println("same");
        else
            System.out.println("not same");
        disjointSets.unionByRank(3, 7);
        if (disjointSets.findUltimateParent(3) == disjointSets.findUltimateParent(7))
            System.out.println("same");
        else
            System.out.println("not same");

    }
}
