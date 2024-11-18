package dp;

public class ShareMarket {

    public static void main(String[] args) {
        int[] sharesCost = {8, 1, 2, 4, 6, 5};

        int total = sharesCost.length;
        int[] minUptil = new int[total];
        int[] maxProfit = new int[total];
        minUptil[0] = sharesCost[0];
        for (int i = 1; i < total; i++) {
            minUptil[i] = Math.min(minUptil[i - 1], sharesCost[i]);
        }
        int highest = Integer.MIN_VALUE;
        for (int i = 0; i < total; i++) {
            maxProfit[i] = sharesCost[i] - minUptil[i];
            if (highest < maxProfit[i]) {
                highest = maxProfit[i];
            }
        }
        System.out.println();
    }
}
