package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxXORofTwoNums {
    public static void main(String[] args) {
        int nums[] = {3,10,5,2,25};
        new MaxXORofTwoNums().findMaximumXOR(nums);
    }
    public int findMaximumXOR(int[] nums) {
        Map<Integer, String> map = new HashMap<>();
        for(int num: nums){
            map.put(num, Integer.toBinaryString(num));
        }
        int max = Integer.MIN_VALUE;

//        int first = Integer.parseInt(map.get(nums[0]));
        int first = nums[0];
        for(int i=1;i<nums.length; i++){
//            int binaryVal = Integer.parseInt(map.get(nums[i]));
            int sumXor = first ^ nums[i];
//            String m = sumXor+"";
//            int m2= Integer.parseInt(m,2);
            max = Math.max(max, sumXor);
            first  = nums[i];
        }
        return max;
    }
}
