
// pint natural numbers to n number without using any loop.
public class PrintNaturalNos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		recursePrint(10);
	}
	public static void recursePrint(int n)
	{
		if(n==0)
			return ;
		if(n>0)
		{
			recursePrint(n-1);
			System.out.println(n);
		}
	}
}
