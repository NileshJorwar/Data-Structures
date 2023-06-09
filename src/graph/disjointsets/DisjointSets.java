package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class DisjointSets {

    //Initialize with rank with 0 values and parent array with self values
    private List<Integer> ranks = new ArrayList<>();
    private List<Integer> sizes = new ArrayList<>();
    private List<Integer> parent = new ArrayList<>();

    DisjointSets(int nodes) {
        //0-1 based indexing works

        for (int i = 0; i <= nodes; i++) {
            ranks.add(0);
            parent.add(i);
            sizes.add(1);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v)
            return;
        if (ranks.get(ulp_u) < ranks.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (ranks.get(ulp_v) < ranks.get(ulp_u)) {
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
        }else{
            parent.set(ulp_v, ulp_u);
            sizes.set(ulp_u, sizes.get(ulp_u) + sizes.get(ulp_v));
        }
    }

    public static void main(String[] args) {
//        DisjointSets disjointSets = new DisjointSets(7);
//        disjointSets.unionByRank(1, 2);
//        disjointSets.unionByRank(2, 3);
//        disjointSets.unionByRank(4, 5);
//        disjointSets.unionByRank(5, 6);
//        disjointSets.unionByRank(6, 7);
////        disjointSets.unionByRank(3,7);
//
//        //3 == 7?
//        if (disjointSets.findUltimateParent(3) == disjointSets.findUltimateParent(7))
//            System.out.println("same");
//        else
//            System.out.println("not same");
//        disjointSets.unionByRank(3, 7);
//        if (disjointSets.findUltimateParent(3) == disjointSets.findUltimateParent(7))
//            System.out.println("same");
//        else
//            System.out.println("not same");

        //TODO: use either unionByRank or unionBySize at once
        DisjointSets disjointSets = new DisjointSets(7);
        disjointSets.unionBySize(1, 2);
        disjointSets.unionBySize(2, 3);
        disjointSets.unionBySize(4, 5);
        disjointSets.unionBySize(5, 6);
        disjointSets.unionBySize(6, 7);

        //3 == 7?
        if (disjointSets.findUltimateParent(3) == disjointSets.findUltimateParent(7))
            System.out.println("same");
        else
            System.out.println("not same");
        disjointSets.unionBySize(3, 7);
        if (disjointSets.findUltimateParent(3) == disjointSets.findUltimateParent(7))
            System.out.println("same");
        else
            System.out.println("not same");
    }
}
