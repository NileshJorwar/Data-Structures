package src.Stringz;

public class DecodeColumnSpreadshitsNdReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=0;
		String col="ZZZ";
		for(int i=0;i<col.length();i++)
		{
			char c=col.charAt(i);
			result=result*26 + c-'A'+1;
		}
		System.out.println(result+"----Time Complexity - O(n)");
		
		int colId=18278;
		String res="";
		int rem=0;
		char c = 0;
		while(colId!=0)
		{
			rem=(colId-1)%26;
			c=(char)(('A'+rem));
			colId=(colId-rem-1)/26;
			res=res+c;
		}
		System.out.println(res);
			
	}

}
