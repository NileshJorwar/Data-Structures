package src.Stringz;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="ram is costly there in india";
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		//System.out.println(sb);
		String s[]=sb.toString().split(" ");
		for(String st:s)
		{
			StringBuilder sb2=new StringBuilder(st);
			//System.out.print(sb2.reverse()+" ");
		}
		String s2="";
		for(int i=str.length()-1;i>=0;i--)
		{
			s2+=str.charAt(i);
			
		}
		//System.out.println(s2);
		String result="";
		String temp="",temp2="";
		for(int i=0;i<s2.length();i++)
		{
			
			if(s2.charAt(i)!=' ')
			{
				temp+=s2.charAt(i);
			}
			else
			{
				for(int j=temp.length()-1;j>=0;j--)
				{
					temp2+=temp.charAt(j);
				}
				result+=" "+temp2;
				temp=temp2="";
			}	
		}
		for(int j=temp.length()-1;j>=0;j--)
		{
			temp2+=temp.charAt(j);
		}
		result+=" "+temp2;
		temp=temp2="";
		System.out.println(result);
		
	}

}
