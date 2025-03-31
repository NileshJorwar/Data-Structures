package src.leetcode;

import java.util.TreeMap;

public class StraightHand {

    public static void main(String[] args) {
        new StraightHand().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;

//        if(len%groupSize!=0){
//            return false;
//        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 1,2,3,4,5 \\ 4

        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (map.getOrDefault(key + i, 0) < count) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - count);
                }
            }
        }

        return true;
    }
}
