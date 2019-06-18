package Stringz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "0A man, a plan, a canal, Panama.0";
		String s2 = str.replaceAll("[^a-zA-Z0-9]*", "");
		System.out.println(s2);
		Pattern p = Pattern.compile("[a-zA-Z0-9]*");
		Matcher m = p.matcher(str);
		String temp = "";
		int count = 0;
		while (m.find()) {
			// System.out.println(count++);
			temp = temp + m.group().toLowerCase();
		}
		// System.out.println(temp.toLowerCase());
		//int i = 0, j = temp.length() - 1;
		boolean flag = false;
		str = str.toLowerCase();
		int i = 0, j = str.length() - 1;
		System.out.println(str);
		while (i < j) {
			/*
			 * if (temp.charAt(i) != temp.charAt(j)) { flag = true; break; } i++; j--;
			 */
			// Another method
			while (!Character.isLetterOrDigit(str.charAt(i)) && i < j)
				i++;
			while (!Character.isLetterOrDigit(str.charAt(j)) && i < j)
				j--;
			if (str.charAt(i) != str.charAt(j)) {
				flag = true;
				break;
			}
			i++;
			j--;
		}
		if (flag)
			System.out.println("Not palindrome");
		else
			System.out.println("Yes palindrome");
	}

}
