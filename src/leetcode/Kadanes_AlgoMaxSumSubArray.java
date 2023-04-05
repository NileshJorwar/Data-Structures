package src.leetcode;

public class Kadanes_AlgoMaxSumSubArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5, -2, -3, 5};
        int max_current = arr[0], max_global = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max_current = Math.max(arr[i], max_current + arr[i]);
            max_global = Math.max(max_current, max_global);
        }
        System.out.println(max_global);
    }
}
