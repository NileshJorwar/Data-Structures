package src.slidingWindowRecap.variable;

import java.util.HashMap;
import java.util.Map;

// Variable Size window;
// Arrays have to be continuous
public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        minWindowSub(s, t);
    }

    public static String minWindowSub(String s, String k) {
        int i = 0, j = 0, len = s.length();
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int min = Integer.MAX_VALUE;
        while (j < len) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(ch) == 0)
                    count--;

            }

            if (count == 0) {
                min = Math.min(min, j - i + 1);
                res = s.substring(i, j);

            } else if (count == 0)
                j++;

        }
        return "";
    }
}
