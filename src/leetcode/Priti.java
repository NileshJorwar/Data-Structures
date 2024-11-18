package src.leetcode;

public class Priti {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] A1 = {1, 2, -3, 4, 5, -6};
        System.out.println("Maximum sum of non-negative slices for A1: " + Priti.solution(A1)); // Expected output: 11

        // Example 2
        int[] A2 = {-1, -2, -3};
        System.out.println("Maximum sum of non-negative slices for A2: " + Priti.solution(A2)); // Expected output: -1

        // Example 3
        int[] A3 = {1, 2, 3, 4, 5};
        System.out.println("Maximum sum of non-negative slices for A3: " + Priti.solution(A3)); // Expected output: 15

//        Maximum sum of non-negative slices for A1: 9
//        Maximum sum of non-negative slices for A2: -1
//        Maximum sum of non-negative slices for A3: 15
    }

    public static int solution(int[] A) {
        int max_sum = 0;
        int current_sum = 0;
        boolean positive = false;
        int n = A.length;
        for(int i = 0; i < n; ++i) {
            int item = A[i];
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

        if (current_sum > max_sum) {
            max_sum = current_sum;
        }
        if (positive) {
            return max_sum;
        }
        return -1;
    }
}
