package src.leetcode;

import java.util.*;

public class SortIntByBits {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> l = new ArrayList<>(map.values());
//        Collections.sort(l, (a,b)->
//                b-a);
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            int cnt = 0;
            while (n != 0) {

                if ((n & 1) == 1)
                    cnt++;
                n = n >> 1;
            }
            map.put(arr[i], cnt);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(
                list, new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> o1,
                                       Map.Entry<Integer, Integer> o2) {
                        return (o1.getValue()).compareTo(o2.getValue());
                    }
                }
        );

        System.out.println(list);

    }
}
