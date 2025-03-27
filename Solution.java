public class Solution {
    public int solution(int[] S) {
        int max_sum = 0;
        int current_sum = 0;
        boolean positive = false;

        int n = S.length;
        for (int i = 0; i < n; i++) {
            int item = S[i];
            if (item < 0) {
                if (max_sum < current_sum) {
                    max_sum = current_sum;
                }
                current_sum = 0;
            } else {
                positive = true;
                current_sum += item;
            }
        }

        // Check the last non-negative slice
        if (current_sum > max_sum) {
            max_sum = current_sum;
        }

        // If there was at least one non-negative slice, return max_sum
        if (positive) {
            return max_sum;
        } else {
            return -1;  // If no non-negative slice found, return -1 as per the requirement
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] S1 = {0,1};
        System.out.println("Max sum of non-negative slices for S1: " + solution.solution(S1)); // Expected output: 11

        // Example 2
        int[] S2 = {-1, -2, -3};
        System.out.println("Max sum of non-negative slices for S2: " + solution.solution(S2)); // Expected output: -1

        // Example 3
        int[] S3 = {1, 2, 3, 4, 5};
        System.out.println("Max sum of non-negative slices for S3: " + solution.solution(S3)); // Expected output: 15
    }
}