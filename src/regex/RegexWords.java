package src.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = { "hello123", "782872$@nil", "@cool@12@hi", "sachine", "12122" };
		Pattern pattern = Pattern.compile("([a-zA-Z]+)");
		Matcher m[] = new Matcher[words.length];
		for (int i = 0; i < words.length; i++) {
			m[i] = pattern.matcher(words[i]);
		}
		String arr[] = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			String temp = "";
			while (m[i].find()) {
				temp += m[i].group();
			}
			arr[i] = temp;
			//System.out.println(arr[i]);
		}
		Arrays.sort(arr);
		for (int i = 0; i < words.length; i++) {
				//System.out.println(arr[i]);
		}
		List<String> sList=Arrays.asList(arr);
		//sList.forEach(s->System.out.println(s));
		sList.forEach(System.out::println);
		//System.out.println("length of words" + m.length);
	}

}
