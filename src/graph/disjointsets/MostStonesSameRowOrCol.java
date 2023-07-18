package src.graph.disjointsets;

import java.util.HashMap;
import java.util.Map;

public class MostStonesSameRowOrCol {
    public static void main(String[] args) {

        int stones[][] = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int ans = removeStones(stones);
        System.out.println("Stones removed = " + ans);
    }

    public static int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        System.out.println();
        DisjointSetsPractice disjointSetsPractice =
                new DisjointSetsPractice(maxRow + maxCol + 1);
        Map<Integer, Integer> hasmap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            disjointSetsPractice.unionBySize(nodeRow, nodeCol);
            hasmap.put(nodeRow, 1);
            hasmap.put(nodeCol, 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hasmap.entrySet()
        ) {
            if (disjointSetsPractice.findUltimateParent(entry.getKey()) == entry.getKey())
                count++;
        }
        return stones.length -  count;
    }
}
