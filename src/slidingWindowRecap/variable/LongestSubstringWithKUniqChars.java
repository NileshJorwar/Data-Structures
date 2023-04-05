package src.slidingWindowRecap.variable;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

// Variable Size window;
// Arrays have to be continuous
public class LongestSubstringWithKUniqChars {
    public static void main(String[] args) {
        String s = "abacbbccnnddkklllvvbbaabbbbb";
        int k = 3;
        System.out.println(longestSubWithKUniqueChars(s, k));
    }

    public static int longestSubWithKUniqueChars(String s, int k) {
        int i = 0, j = 0, size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        while (j < size) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
//                if (map.size() != 0) {
//                    char ch = s.charAt(i);
//                    map.put(ch, map.getOrDefault(ch, 0) - 1);
//                    if (map.get(ch) == 0)
//                        map.remove(s.charAt(i));
//                }
//                i++;
                j++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char ch = s.charAt(i);
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }

        }
        return max;
    }
}
