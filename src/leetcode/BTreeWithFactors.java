package src.leetcode;

public class BTreeWithFactors {
    public static void main(String[] args) {
        int arr[] = {2, 4, 5, 10};
        new BTreeWithFactors().numFactoredBinaryTrees(arr);
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (i == j) {
                    count++;
                    break;
                }
                else if (i != 0 ) {
                    if (arr[i] == arr[i - 1] * arr[j])
                        count++;
                    break;
                }
                else if (j != 0 ) {
                    if (arr[j] == arr[j - 1] * arr[i])
                        count++;
                    break;
                }
            }
        }
        System.out.println("Factors: " + count);

        return count;
    }
}