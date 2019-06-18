
public class PrimeOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4;
		boolean flag = false;
		for (int i = 2; i <=num / 2; i++) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("Not a prime No");
		else
			System.out.println("Prime No");

		displayPrimes(5, 50);
	}

	public static void displayPrimes(int low, int high) {
		
		if(low==0)
			low++;
		if(low==1)
			low++;
		
		while(low<high)
		{
			boolean flag=false;
			for(int i=2;i<=low/2;i++)
			{
				if(low%i==0)
				{
					flag=true;
					break;
				}
			}
			if(!flag)
				System.out.print(low+" ");
			low++;
		}
	}

}
