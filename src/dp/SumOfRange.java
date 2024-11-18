package dp;

public class SumOfRange {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -8, 0};

        int n = arr.length;
        int[] sum_until = new int[n];

        sum_until[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum_until[i] = sum_until[i - 1] + arr[i];
        }
        //argument passed 2,4 from config above 
        System.out.println("Take a range: " + args[0] + " " + args[1]);
        if (Integer.parseInt(args[0]) == 0)
            System.out.println(sum_until[0]);
        else
            System.out.println(sum_until[Integer.parseInt(args[1])] - sum_until[Integer.parseInt(args[0])-1]);
    }
}
