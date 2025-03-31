package src.leetcode.binarysearch;

public class CountOccurancesInsortedArray {
    public static void main(String[] args) {
        new CountOccurancesInsortedArray().countFreq(new int[]{8,9,10,12,12,12}, 12);
    }

    int countFreq(int[] arr, int target) {
        int left = search(arr,target,true);
        int right = search(arr, target, false);
        if(left == -1 && right == -1){
            return 0;
        } else if (left == right){
            return 1;
        }
        int result = (right - left) + 1;
        return result;
    }

    int search(int[] arr, int target, boolean isLeft){
        int index = -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target == arr[mid]){
                index = mid;
                if(isLeft)
                    end = mid - 1;
                else
                    start = mid+1;

            }
            else if(target < arr[mid]){
                end = mid -1;
            }
            else{
                start = mid+1;
            }


        }
        return index;
    }
}
