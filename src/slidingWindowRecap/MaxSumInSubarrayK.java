package src.slidingWindowRecap;

public class MaxSumInSubarrayK {
    public static void main(String[] args) {
        int windowK = 3;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int arr[] = {2, 5, 1, 8, 2, 9, 1};
        int size = arr.length;
        while (j < size) {
            sum += arr[j];
            if ((j - i + 1) < windowK) {
                j++;
            } else if ((j - i + 1) == windowK) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        System.out.println(maxSum);
    }
}
