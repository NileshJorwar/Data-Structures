package src.leetcode.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
     new BinarySearch().search(new int[]{-1,0,3,5,9,12}, 9);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, start, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, end);
        }
    }
}
