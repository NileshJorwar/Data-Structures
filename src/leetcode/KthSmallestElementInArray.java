package src.leetcode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KthSmallestElementInArray {
    public static void main(String[] args) {
        new KthSmallestElementInArray().findKthSmallest2(new int[]{99, 99}, 1);
    }

    public int findKthSmallest(int[] nums, int k) {
        // 1 2 2 3  3 4 5 5 6 || 4
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            if (sum >= k) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int findKthSmallest2(int[] nums, int k) {
        // 1 2 2 3  3 4 5 5 6 || 4
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        while (k > 1) {
            k--;
            q.remove();
        }
        System.out.println(k);
        return q.peek();
    }

    public int findKthSmallest3(int[] nums, int k) {
        // 1 2 2 3  3 4 5 5 6 || 4
        int[] countNumsArr = new int[20001];
        for (int num : nums) {
            countNumsArr[num + 10000]++;
        }

        for (int i = 0; i < countNumsArr.length; i++) {
            if (countNumsArr[i] > 0) {
                k -= countNumsArr[i];
                if (k <= 0) {
                    return i - 10000;
                }
            }
        }
        return -1;
    }
}
