package src.leetcode.binarysearch;

public class SearchRotatedArray {
    public static void main(String[] args) {
        System.out.println(new SearchRotatedArray().search(new int[]{4,5,6,7,8,1,2,3}, 8));
    }

    public int search(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[mid]>=nums[start]) {
                if (target < nums[mid] && target >=nums[start]) {
                    end = mid -1 ;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[start]) {
                    start = mid + 1;

                }else{
                    end = mid -1;
                }
            }

        }
        return -1;
    }
}
