package src.bitmanipulations;

public class Practice {
    public static void main(String[] args) {

        int x = 12;
        int ans = 12 >> 2;

        //TODO: when AND - becomes 1 only if two elements are 1
        //TODO: when OR - becomes 1 for all except both are 0s
        //TODO: when XOR - becomes 1 if both are different (0 ^ 1 or 1 ^ 0 )

        System.out.println(ans);
        System.out.println(12 << 2);

        //TODO: when >> by 1 ; means dividing by 2
        System.out.println(5 >> 1);
        System.out.println(4 >> 1);
        System.out.println(54 >> 1);
        //TODO: when << by 1 ; means multiplying by 2
        System.out.println(12 << 1);
        System.out.println(7 << 1);

        //TODO: in binary even numbers has last bit 0 and odd has 1
        //TODO: to check if number is even/odd ; just check last bit means AND by 1

        System.out.println(3 & 1);
        System.out.println(2 & 1);
        System.out.println(12 & 1);
        System.out.println(13 & 1);

        //TODO: Swap two numbers using XOR

        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Swapped: a:" + a + ": b" + b);


        System.out.println("Find ith bit: << left shift 1 by i times and AND with n");
        System.out.println("Find ith bit:  right shift number by i times and AND with n");

        int k = 13;
        int ith = 2;

        int z = k >> ith;
        int zth = z & 1;

        int mask = 1 << ith;
        int sh = k & mask;

        System.out.println("ith Bit: " + zth + " shifted no: " + sh);

        int number = 37; // Example number
        int i = 3; // The index of the bit you want to retrieve

        // Shifting the number i positions to the right
        int shiftedNumber = number >> i;

        // Masking the least significant bit
        int bit = shiftedNumber & 1;

        System.out.println("The " + i + "th bit of " + number + " is: " + bit);

        System.out.println("Set ith bit; left << shift 1 by i times and OR with the mask 'num | (1<<i)'  ");
        int n2 = 37; // 1 0 0 1 0 1
        int mask2 = 1 << i;
        int shiftedNum = n2 | mask2;
        System.out.println("ith bit set; hence  the result: " + shiftedNum);

        System.out.println("Clear ith bit: << left shift 1 by i times and negate the as ~(1<<i) and AND with number");
        int n3 = 45;
        int mask3 = ~(1 << i);
        int shiftedNum2 = n3 & mask3;
        System.out.println("cleared bit with result: " + shiftedNum2);

        System.out.println("find number of bits needed to convert number A to number B");
        System.out.println("XOR A and B; gives us number with 1s, then right shift >> XORed result in loop by 1 and AND with 1 to check odd number and increment count");
        int n4 = 37;
        int n5 = 8;

        int mask4 = n4 ^ n5;
        int count = 0;
        while (mask4 > 0) {

            if ((mask4 & 1) == 1)
                count++;
            mask4 = mask4 >> 1;
        }
        System.out.println("No of bits needed to convert A to B: " + count);

        System.out.println("Another way to use is (n & n-1) after XOR of A and B above and keep doing n = n & n-1 until reaches 0 ; which counts the set bits");
        int count2 = 0;
        int mask5 = n4 ^ n5;
        while (mask5 > 0) {
            mask5 = mask5 & mask5 - 1;
            count2++;
        }
        System.out.println("No of bits needed to convert A to B: " + count2);


        int A[] = {15, 5, 1, 10, 2};
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int first = A[0];
        for(int x1 = 1; x1< A.length;x1++){
            sum = first ^ A[x1];
            min = Math.min(sum, min);
            first= A[x1];
        }

    }
}
