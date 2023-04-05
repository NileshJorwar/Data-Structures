package src.Primitives;

/*
 * Find parity of large no 
 * parity is 1 if no of 1 bits are-----odd else parity is 0
 */
public class ParityOfLargeNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x = 21;
		long y = 21;
		short res = 0;
		while (x != 0) {
			res = (short) (res + (x & 1));
			x >>>= 1;
		}
		System.out.println(res);
		System.out.println(res % 2 == 0 ? false : true);
		short res2 = 0;
		while (y != 0) {
			res2 ^= (y & 1);
			y >>>= 1;
		}
		System.out.println(res2);
		System.out.println(res2 % 2 == 0 ? false : true);

		// another approach

		long z = 10;
		z ^= z >>> 32;
		z ^= z >>> 16;
		z ^= z >>> 8;
		z ^= z >>> 4;
		z ^= z >>> 2;
		z ^= z >>> 1;
		System.out.println(z & 0x1);
	}

}
