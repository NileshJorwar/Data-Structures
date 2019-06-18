package Stringz;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "312";
		int result = 0;
		
		for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
			final int digit = s.charAt(i) - '0';
			System.out.println(digit);
			result = result * 10 + digit;
		}
		
		int len=s.length()-1;
		int res=0;
		
		for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
			final int digit = s.charAt(i) - '0';
			res = (int) (res+ digit*(Math.pow(10, len--)));
			System.out.println(res);
		}
		
		System.out.println(s.charAt(0) == '-' ? -result : result);
		System.out.println(result);
		
	}

}
