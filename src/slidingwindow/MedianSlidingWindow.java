package src.slidingwindow;
import java.util.*;

public class MedianSlidingWindow {
    public static void main(String[] args) {
        int nums[] = {2147483647, 2147483647};
        int k = 2;
        new MedianSlidingWindow().medianSlidingWindow(nums, k);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[k];
        double ansArr[] = new double[n - k + 1];
        int index = 0;
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                arr[index++] = nums[j];
            }
            index = 0;
            Arrays.sort(arr);
            if ((k & 1) == 1) {
                ansArr[i] = arr[k / 2];
            } else {
                ansArr[i] = (double) (arr[k / 2] + arr[k / 2 - 1]) / 2;
            }
        }
        return ansArr;
    }
}
