package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumRecolorstoGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        String blocks = "BWBBWWBBBWBWWWBWWBBWBWBBWBB";
        int k = 11;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : blocks.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append('B');
        }
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, count = 0;
        int len = blocks.length();
        while (j < len) {
            char c = blocks.charAt(j);
            if (c == 'W')
                count++;
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                min = Math.min(min, count);
                if (blocks.charAt(i) == 'W')
                    count--;
                i++;
                j++;
            }
        }
        System.out.println(min);
    }

    public int minColor(String blocks, int k) {
        // String blocks = "WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW";
        // int k = 15;
        // if(blocks.length()==1 && k==1)
        //     return 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : blocks.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append('B');
        }
        if (blocks.contains(sb.toString()))
            return 0;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, count = 0;
        int len = blocks.length();
        while (j < len) {
            char c = blocks.charAt(j);
            if (c == 'W')
                count++;
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                min = Math.min(min, count);
                if (blocks.charAt(i) == 'W')
                    count--;
                i++;
                j++;
            }
        }
        return min;
    }
}
