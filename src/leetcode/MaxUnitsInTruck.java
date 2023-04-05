package src.leetcode;

import java.util.Arrays;

public class MaxUnitsInTruck {
    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {2, 5}, {3, 1}};
        Arrays.sort(
                arr, (a, b) -> a[1] - b[1]
        );
        for (int[] s :
                arr) {
            for (int x :
                    s) {
                System.out.println(x);
            }
        }
    }
}
