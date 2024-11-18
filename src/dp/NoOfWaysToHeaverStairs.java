package dp;

/*
Climbing Stairs
* You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
* */
public class NoOfWaysToHeaverStairs {
    public static void main(String[] args) {
        int n = 3
                ;
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        System.out.println("Ways to heaven: " + ways[n]);
    }
}
