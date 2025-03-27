package src.leetcode.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
     new BinarySearch().search(new int[]{-1,0,3,5,9,12}, 9);
    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<end){
            mid = (end-start)/2  + 1;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid]){
                end = mid-1;
            }
            else{
                start=mid;
            }
        }
        return -1;
    }
}
