package src.leetcode.binarysearch;

public class FindMinInSortedRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                // Minimum is in the right part
                start = mid + 1;
            } else {
                // Minimum is in the left part (including mid)
                end = mid;
            }
        }

        // The loop ends when start == end, pointing to the minimum
        return nums[start];
    }
}
