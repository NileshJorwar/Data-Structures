package src.leetcode.binarysearch;

public class FindPeakElement {

    public static void main(String[] args) {
        new FindPeakElement().findPeakElement(new int[]{1,2,3,1});
    }
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -1 ;
        //handle the case for array size 3 before
        while(start<end){
            int mid = start + (end- start)/2;
            int midElement = nums[mid];
            if(midElement > nums[mid-1] && midElement > nums[mid+1]){
                return mid;
            }
            if(midElement>nums[mid-1] && midElement < nums[mid+1]){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
