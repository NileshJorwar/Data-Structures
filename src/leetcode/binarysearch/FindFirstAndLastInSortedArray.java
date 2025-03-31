package src.leetcode.binarysearch;

public class FindFirstAndLastInSortedArray {
    public static void main(String[] args) {
        new FindFirstAndLastInSortedArray().searchRange(new int[]{5,7,7,8,8,10},8);
    }
    public int[] searchRange(int[] nums, int target) {
        int start= search(nums, target, true);
        int end= search(nums, target, false);

        int[] result = {-1,-1};
        result[0] = start;
        result[1] = end;
        return result;
    }


    public int search(int[] nums, int target, boolean isSearchLeft){
        int s = 0;
        int e = nums.length-1;
        int index= -1;
        while(s<=e){
            int mid = s +(e-s)/2;

            if(target<nums[mid]){
                e = mid-1;
            }
            else if(target>nums[mid]){
                s = mid+1;
            } else{
                index = mid;
                if(isSearchLeft)
                    e = mid-1;
                else s = mid+1;
            }
        }
        return index;
    }
}
