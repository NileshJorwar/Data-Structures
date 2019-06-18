package Stringz;

import java.util.Arrays;

public class TwoAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "LISTEN";
		String s2 = "LISTEN";

		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		areAnagram(a1, a2);
		boolean flag = false;
		if (s1.length() != s2.length())
			System.out.println("Not anagrams");
		else {
			Arrays.sort(a1);
			Arrays.sort(a2);
			for (int i = 0; i < s1.length(); i++) {
				if (a1[i] != a2[i]) {
					flag = true;
					System.out.println("Not Aangrams");
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("Aangrams");
		}
	}

	static boolean areAnagram(char str1[], char str2[]) {
		int count1[] = new int[52];
		int count2[] = new int[52];
		Arrays.fill(count1, 0);
		Arrays.fill(count2, 0);
		boolean flag=false;
		if (str1.length != str2.length)
			System.out.println("Not anagrams");
		for (int i = 0; i < str1.length && i < str2.length; i++) {
			count1[str1[i]-'A']++;
			count1[str2[i]-'A']++;
			//count[str1]++;
			//count[str2]--; with single count
		}
		for(int i=0;i<256;i++)
		{
			if(count1[i]!=count2[i])
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Inside Not anagrams");
		}
		else
		{
			System.out.println("Inside Anagrams");
		}
		return false;
	}

}
