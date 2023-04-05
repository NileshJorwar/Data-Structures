package src.slidingWindowRecap.variable;

import java.util.HashMap;
import java.util.Map;

// Variable Size window;
// Arrays have to be continuous
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s = "pwwekwp";
        System.out.println(longestSubWithKUniqueChars(s));
    }

    public static int longestSubWithKUniqueChars(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0, j = 0, size = s.length();
        while (j < size) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == j - i + 1) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    char atI = s.charAt(i);
                    map.put(atI, map.getOrDefault(atI, 0) - 1);
                    if (map.get(c) == 0)
                        map.remove(atI);
                    i++;
                }
                j++;
            }

        }
        return ans;
    }
}
