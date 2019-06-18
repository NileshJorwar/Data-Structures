package Stringz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelexEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "a", "b", "c", "d", ".", ",", "?", "!" };
		Pattern p = Pattern.compile("([^a-zA-Z0-9]*)");
		Matcher m[] = new Matcher[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			m[i]=p.matcher(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			while (m[i].find()) {		
				arr[i]= "aaa";
			}
		}
		System.out.println(arr[6]);
	}

}
