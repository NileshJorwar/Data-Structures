package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIfStrContainsAlphabets {

	public static void main(String args[]) {
		String str = "1221";
		if (str == null)
		{
			System.out.println("false");
			return;
		}
		Pattern p = Pattern.compile("^[a-zA-Z]*$");
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
	}
}

