package src.leetcode;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 1, 2, 7, 5, 2};
        int indexArr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            indexArr[arr[i]]++;
        }
        for (int i = 1; i < indexArr.length; i++) {
            indexArr[i] += indexArr[i - 1];
        }
        int output[] = new int[arr.length];
        for (int i = 0; i < indexArr.length; i++) {
            output[indexArr[arr[i]]-1] = arr[i];
            indexArr[arr[i]]--;
        }
        System.out.println("---");
    }
}
