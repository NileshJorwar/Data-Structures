package src.Primitives;

/*
 * COunt no of bits that are set to 1 in number
 */
public class CountNoOf1BitsInNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;

		String binary = Integer.toBinaryString(x);
		System.out.println(binary);
		int count = 0;
		for (char c : binary.toCharArray())
			if (c == '1')
				count++;
		System.out.println(count);
		short numBits = 0;
		while (x != 0) {
			numBits = (short) (numBits + (x & 1));
			x >>>= 1;
		}
		System.out.println(numBits);
	}

}
