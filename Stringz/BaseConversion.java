package Stringz;

public class BaseConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numAsString = "-615";
		int b1 = 7, b2 = 13;
		boolean isNeg = numAsString.startsWith("-");
		int num = 0;
		for (int i = (isNeg ? 1 : 0); i < numAsString.length(); i++) {
			num = num * b1;
			num += Character.isDigit(numAsString.charAt(i)) ? numAsString.charAt(i) - '0'
					: numAsString.charAt(i) - 'A' + 10;
		}
		System.out.println(num);
		System.out.println((isNeg ? "-" : "") + (num == 0 ? "0" : toOtherBase(num, b2)));
	}

	public static String toOtherBase(int num, int b2)
	{
		
		char r;
		StringBuilder sb=new StringBuilder();
		while(num!=0)
		{
			r=(char)(num%b2>=10?'A'+num%b2-10:'0'+num%b2);
			num=num/b2;
			sb=sb.append(r);
		}
		return sb.reverse().toString();
		//return num==0?"":toOtherBase(num/b2, b2)+(char)(num%b2>=10?
			//	'A'+num%b2-10:'0'+num%10);
		
		
	}

}
