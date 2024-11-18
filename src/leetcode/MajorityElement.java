package src.leetcode;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        new MajorityElement().majorityElement(new int[]{3,2,3});
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k: nums){
            map.put(k, map.getOrDefault(k,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(max<entry.getValue()){
                max = entry.getKey();
            }
        }
        return max;
    }
}
