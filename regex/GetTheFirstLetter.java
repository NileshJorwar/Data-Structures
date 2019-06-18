package regex;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class GetTheFirstLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence="good morning, @ahsid 12123hello how12e32321 are you";
		Pattern getFirstLetter=Pattern.compile("\\b[a-zA-Z0-9]");
		Matcher m=getFirstLetter.matcher(sentence);
		while(m.find())
		{
			String tmp="";
			System.out.print(m.group()+" ");
			
		}
		
	}

}
