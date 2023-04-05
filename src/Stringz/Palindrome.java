package src.Stringz;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palindrome = "malayalam";
		boolean value= palin(palindrome);
		boolean value2=palindromeWhile("Malayalam");
		boolean value3=palindromeStack("Hello");
		if(value)
			System.out.println("Palindrome");
		else
			System.out.println("not Palindrome");
		if(value2)
			System.out.println("Palindrome");
		else
			System.out.println("not Palindrome");
		if(value3)
			System.out.println("Palindrome");
		else
			System.out.println("not Palindrome");
		
	}
	static boolean palin(String palindrome)
	{
		for (int i = 0, j = palindrome.length() - 1; i < j; i++, j--) {
			if (palindrome.charAt(i) != palindrome.charAt(j)) {
				return false;
			}
		}
		return true;
		
	}
	static boolean palindromeWhile(String palindrome)
	{
		int i=0, j=palindrome.length()-1;
		while(i<j)
		{
			if(palindrome.charAt(i)!=palindrome.charAt(j)) {
				return false;
			}
				i++;
				j--;
		}
		return true;
		
	}
	static boolean palindromeStack(String palindrome)
	{
		Stack<Character> stack=new Stack<>();
		for(int i =0;i<palindrome.length();i++)
		{
			stack.push(palindrome.charAt(i));
		}
		for(int i =0;i<palindrome.length();i++)
		{
			if(palindrome.charAt(i)!=stack.pop())
				return false;
		}
		return true;
		
	}
	
}
