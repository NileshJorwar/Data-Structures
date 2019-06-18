package regex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractMaxFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aj11ah35ja100";
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(str);
		List<Integer> list=new ArrayList<>();
		int index=0;
		while(m.find())
		{
			//System.out.println(m.group());
			list.add(Integer.parseInt(m.group()));
			System.out.println(list.get(index));
			index++;
		}
		int max=0;
		if(list.isEmpty())
			System.out.println("No max value present");
		else
		{
			//list.forEach(a->System.out.println(a));
			for(int i:list)
			{
				if(max<i)
					max=i;
			}
		}
		System.out.println("Max-" + max);
	}

}
