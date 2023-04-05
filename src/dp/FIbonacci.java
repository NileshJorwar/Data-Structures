package src.dp;

public class FIbonacci {
    public static void main(String[] args) {
        int fib = fiboUsingRecursion(5);
        int fibDp = usingDP(5);
        int fibVars = usingVariables(5);
        System.out.println("Fib: " + fib + ", " + fibDp + ", " + fibVars);
    }

    public static int fiboUsingRecursion(int n) {
        if (n <= 1)
            return n;
        return fiboUsingRecursion(n - 1) + fiboUsingRecursion(n - 2);
    }

    public static int usingDP(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int usingVariables(int n) {
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return prev2;
    }
}
