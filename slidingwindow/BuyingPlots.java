package slidingwindow;

import java.util.*;

/*
 * Find subarray of min length whose sum is K
 * */
public class BuyingPlots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2, 3, 0, 0, 0, 0 };
		// int arr[] = { 2, 1, 7, 0, 3, 2, 5, 1 };
		int k = 6;
		int m = minSubArray(k, arr);
		System.out.println(m);

		if (k > arr.length)
			return;
		int begin = 0, end = 0, sum = 0;
		int min = Integer.MAX_VALUE;
		while (end < arr.length) {
			sum += arr[end];
			while (sum >= k && begin <= end) {
				min = Math.min(min, end - begin + 1);
				sum -= arr[begin++];
			}
			end++;
		}
		while (sum >= k && begin < arr.length) {
			min = Math.min(min, arr.length - begin + 1);
			sum -= arr[begin++];
		}
		System.out.println(min);

	}

	public static int minSubArray(int s, int[] nums) {
		int arr[] = { 2, 1, 7, 0, 3, 2, 5, 1 };
		int left = 0, total = 0, min = Integer.MAX_VALUE;
		for (int right = 0; right < nums.length; right++) {
			total += nums[right];
			if (total < s) {
				continue;
			}
			while (total >= s && left <= right) {
				min = Math.min(min, right - left + 1);
				total -= nums[left++];
			}
		}

		while (total >= s && left <= nums.length) {
			min = Math.min(min, nums.length - left + 1);
			total -= nums[left++];
		}
		return min == Integer.MAX_VALUE ? 0 : min;

	}

}
