package src.slidingWindowRecap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOccurancesOfAnagramInString {
    public static void main(String[] args) {
        String patternWindowK = "for";
        int windowSize = patternWindowK.length();
        String st = "xooxorfoxxofr";
        int i = 0, j = 0;
        int size = st.length();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : patternWindowK.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();
        int ans = 0;

        while (j < size) {
            char c = st.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0)
                    count--;
            }
            if ((j - i + 1) < windowSize) {
                j++;
            } else if ((j - i + 1) == windowSize) {
                if (count == 0) {
                    ans++;
                }
                if (map.containsKey(st.charAt(i))) {
                    map.put(st.charAt(i), map.getOrDefault(st.charAt(i), 0) + 1);
                    if (map.get(st.charAt(i)) == 1)
                        count++;
                }
                i++;
                j++;
            }
        }
        System.out.println("Occurrences:" + ans);
    }
}
