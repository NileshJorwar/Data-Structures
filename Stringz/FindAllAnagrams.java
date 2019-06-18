package Stringz;

import java.util.*;

public class FindAllAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		findAnagrams(s, p);
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		List<String> stList = new ArrayList<>();
		int len = s.length() - p.length();
		char arr[] = p.toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < s.length(); i++) {
			if (i <= len) {
				String s2 = s.substring(i, i + p.length());
				char arr2[] = s2.toCharArray();
				Arrays.sort(arr2);
				boolean flag = false;
				for (int j = 0; j < s2.length(); j++) {
					if (arr[j] != arr2[j]) {
						flag = true;
						break;
					}
				}
				if (!flag)
					list.add(i);
				stList.add(s2);
			}
		}
		System.out.println(stList);
		System.out.println("time complextiy --- O(m*n)");
		return list;
	}
}
