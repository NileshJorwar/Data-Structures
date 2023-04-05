package src.leetcode;

public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 4, 7, 6, 5, 3, 1};
//        int arr[] = {3, 2, 1};
//        int arr[] = {9, 5, 4, 3, 1};
        new NextPermutation().nextPermutation(arr);
        for (int i :
                arr) {
            System.out.print(i + " ");
//            System.out.println();
        }
    }

    public void nextPermutation(int[] nums) {
        // find first decreasing element from right
        // find just increasing number from decreasing element found above,
        // swap it and reverse the elements from decreasing element
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

