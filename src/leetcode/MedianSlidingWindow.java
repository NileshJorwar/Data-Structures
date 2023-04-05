package src.leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

public class MedianSlidingWindow {
    public static void main(String[] args) {
        int nums[] = {2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647
        };
        int k = 2;
//        double median1 = (double) ((double) (nums[k / 2] + nums[k / 2 - 1])) / 2;
//        System.out.println(median1);

        medianSlidingWindow(nums, k);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ansArr = new double[n - k + 1];

        int i = 0, j = 0;
        Set<Integer> list = new TreeSet<>();
        int index = 0;
        while (j < n) {
            int num = nums[j];
            list.add(num);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {

                Integer arr[] = list.toArray(list.toArray(new Integer[0]));
                double median = 0.0;
                if ((k & 1) == 1)
//                    median = list.get(k / 2);
                    System.out.println();
                else {
                    System.out.println();
//                    median = (double) (list.get(k / 2) + list.get(k / 2 - 1)) / 2;
                }
                ansArr[index++] = median;
                list.remove(0);
                i++;
                j++;
            }
        }
        return ansArr;
    }
}
