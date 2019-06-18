
/*
 * check whether the destination string is dervived from the source string.
the rule that you can follow is shift first elemnt to the last
source="abcde";
destination="deabc";
 * */
public class deriveDestStringFrmSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src="abcde";
		String dest="abcde";
		for(int i=0;i<src.length();i++)
		{
			src=src.substring(1, src.length())+src.charAt(0);
			if(src.equals(dest))
			{
				System.out.println("True");
				break;
			}
		}
	}
}
