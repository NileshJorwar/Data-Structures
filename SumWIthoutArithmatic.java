
public class SumWIthoutArithmatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1534236469;
		System.out.println(x);
		if (x < -2147483648 || x > 2147483647) {
			System.out.println("0");
		}
		boolean negativenumber = false;
		if (x < 0) {
			x = -x;
			negativenumber = true;
		}

		long sum = 0L;
		int x2 = 0;
		while (x > 0) {
			x2 = x % 10;
			x = x / 10;
			sum = (sum * 10) + x2;
		}
		long n=sum;
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(n);
		
		int result = (int)n;
		long bool = (negativenumber == true) ? -result : result;
		System.out.println(bool);
	}

}
