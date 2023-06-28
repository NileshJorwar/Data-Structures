package src.graph.disjointsets;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetsPractice {
    List<Integer> ranks = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();


    public DisjointSetsPractice(int nodes) {
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

    public void unionBySize(int u, int v) {
        //find ultimate parent
        int u_ulp = findUltimateParent(u);
        int v_ulp = findUltimateParent(v);

        if (u_ulp == v_ulp)
            return;
        if (sizes.get(u_ulp) < sizes.get(v_ulp)) {
            parent.set(u_ulp, v_ulp);
            sizes.set(v_ulp, sizes.get(v_ulp)+sizes.get(u_ulp));
        } else {
            parent.set(v_ulp, u_ulp);
            sizes.set(u_ulp, sizes.get(u_ulp)+sizes.get(v_ulp));
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
    public static void main(String[] args) {
        DisjointSetsPractice disjointSets = new DisjointSetsPractice(7);
        disjointSets.unionByRank(1, 2);
        disjointSets.unionByRank(2, 3);
        disjointSets.unionByRank(4, 5);
        disjointSets.unionByRank(5, 6);
        disjointSets.unionByRank(6, 7);
//        disjointSets.unionByRank(3,7);

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
