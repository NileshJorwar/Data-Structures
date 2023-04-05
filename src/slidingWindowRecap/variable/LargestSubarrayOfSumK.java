package src.slidingWindowRecap.variable;

import java.util.HashMap;
import java.util.Map;

// Variable Size window;
// Arrays have to be continuous
public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        largestWindow();
        int windowKSum = 9;
        int actualSum = 0;
        int maxSubArr = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int arr[] = {2, 5, 2, 8, 2, 9, 1, 7, -1, -2};
        int size = arr.length;
        while (j < size) {
            actualSum += arr[j];
            if (actualSum < windowKSum) {
                j++;
            } else if (windowKSum == actualSum) {
                maxSubArr = Math.max(maxSubArr, j - i + 1);

                actualSum -= arr[i];
                i++;
                j++;
            } else if (actualSum > windowKSum) {
                while (actualSum > windowKSum) {
                    actualSum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println(maxSubArr);
    }

    //PrefixSum
    public int largestSubArrayOfWindowK(int[] arr, int windowKSum) {
        int sum = 0;
        int maxSubArr = 0;
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == windowKSum)
                maxSubArr = i + 1;
            if (indices.containsKey(sum - windowKSum))
                maxSubArr = Math.max(maxSubArr, i - indices.get(sum - windowKSum));
            if (!indices.containsKey(sum)) {
                indices.put(sum, i);
            }
        }
        return maxSubArr;
    }

    public static int largestWindow() {
        int windowKSum = 9;
        int actualSum = 0;
        int maxSubArr = Integer.MIN_VALUE;
        int arr[] = {2, 5, 2, 8, 2, 9, 1, 7, -1, -2};
        int size = arr.length;
        //PrefixSum
        Map<Integer, Integer> map = new HashMap<>();
        // 0, 2
        // 1, 7
        // 2, 9
        // 3, 17
        // 4, 19
        for (int i = 0; i < size; i++) {
            actualSum += arr[i];
            if (actualSum == windowKSum) {
                maxSubArr = i + 1;
            }
            if (map.containsKey(actualSum - windowKSum)) {
                maxSubArr = Math.max(maxSubArr, i - map.get(actualSum - windowKSum));
                System.out.println();
            }
            if (!map.containsKey(actualSum)) {
                map.put(actualSum, i);
            }
        }
        return maxSubArr;
    }
}
