package src.slidingwindow;

import java.util.*;

public class SumOfSubArrayK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 3, 4, 2, 6, 3, 11, 22, 1, 12 };
		int k = 3;
		bruteForce(arr, k);
		slidingWindow(arr, k);
	}

	public static void slidingWindow(int arr[], int k) {
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++)
			sum += arr[i];
		list.add(sum);
		for (int i = k; i < arr.length; i++) {
			sum += arr[i] - arr[i - k];
			list.add(sum);
		}
		System.out.println(list);
		System.out.println("Complexity----O(n-k)");
	}

	public static void bruteForce(int arr[], int k) {
		int n = arr.length;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i <= n - k) {
				for (int j = i; j < i + 3; j++) {
					sum += arr[j];
				}
				list.add(sum);
				sum = 0;
			}

		}
		System.out.println(list);
		System.out.println("Complexity----O(n*k)");
	}

}
