package slidingwindow;

import java.util.*;

public class MinWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow("ADOBECODEBANC", "ABC");
	}

	public static String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		int begin = 0, end = 0;
		int count = map.size();
		String res = "";
		String res1 = "";
		int min = Integer.MAX_VALUE;
		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					count--;
			}
			end++;
			while (count == 0 && begin <= end) {
				char ch = s.charAt(begin);
				res += ch;
				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
					if (map.get(ch) > 0) {
						count++;
					}
				}
				begin++;
			}

			System.out.println(res);
			res = "";
		}
		return "";
	}
}
