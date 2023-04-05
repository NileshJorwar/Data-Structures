package src.leetcode;


import java.util.HashMap;
import java.util.Map;

class EquivalenLexString {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "programs";
        String baseStr = "sourcecode";
        new EquivalenLexString().smallestEquivalentString(s1, s2, baseStr);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int charArr[] = new int[26];
        Map<Character, int[]> map = new HashMap<>();
        int firstLen = s1.length();
        int secondLen = s2.length();
        if (firstLen != secondLen)
            return null;
        for (int i = 0; i < firstLen; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            int x[] = new int[26];
            if (map.containsKey(ch1) || map.containsKey(ch2)) {
                if (map.containsKey(ch1)) {
                    int x2[] = map.get(ch1);
                    x2[ch2 - 'a'] = 1;
                    map.put(ch2, x2);

                } else if (map.containsKey(ch2)) {
                    int x2[] = map.get(ch2);
                    x2[ch1 - 'a'] = 1;
                    map.put(ch1, x2);
                }

            } else {
                x[ch1 - 'a'] = 1;
                x[ch2 - 'a'] = 1;
                map.put(ch1, x);
                map.put(ch2, x);

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            if (map.containsKey(baseStr.charAt(i))) {
                int x3[] = map.get(baseStr.charAt(i));
                for (int j = 0; j < 26; j++) {
                    if (x3[j] != 0) {
                        char c = (char) (97 + j);
                        sb.append(c + "");
                        break;
                    }
                }
            } else {
                sb.append(baseStr.charAt(i));
            }
        }
        return "";
    }
}
