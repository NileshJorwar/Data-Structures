package src.dp;

// Java program to fill a subarray of given array

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int arr[] = {30, 10, 60, 10, 60, 50};
        int n = arr.length - 1;
        int res = frogJump(n, arr);
        int dp[] = new int[n + 2];
        Arrays.fill(dp, -1);
        int res1 = frogJumpDP(n, arr, dp);
        int res2 = frogJumpDPBottomUp(arr.length, arr);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);

    }

    public static int frogJump(int n, int arr[]) {
        if (n == 0)
            return 0;
        int right = Integer.MAX_VALUE;
        int left = frogJump(n - 1, arr) + Math.abs(arr[n] - arr[n - 1]);
        if (n > 1)
            right = frogJump(n - 2, arr) + Math.abs(arr[n] - arr[n - 2]);
        return Math.min(left, right);
    }

    public static int frogJumpDP(int n, int arr[], int dp[]) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int left = frogJumpDP(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = frogJumpDP(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]);
        return dp[n] = Math.min(left, right);
    }

    public static int frogJumpDPBottomUp(int n, int arr[]) {
        int dp2[] = new int[n + 1];
        dp2[0] = 0;
//       int prev = 0, next = 0;
        for (int i = 1; i < n; i++) {
            int prev = dp2[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int next = Integer.MAX_VALUE;
            if (i > 1)
                next = dp2[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp2[i] = Math.min(prev, next);
        }
        return dp2[n - 1];
    }

    public static int frogJumpDPBottomUpSpaceOptimized(int n, int arr[]) {
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            prev = prev + Math.abs(arr[i] - arr[i - 1]);
            int next = Integer.MAX_VALUE;
            if (i > 1)
                next = prev2 + Math.abs(arr[i] - arr[i - 2]);
            int curr = Math.min(prev, next);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }

}
