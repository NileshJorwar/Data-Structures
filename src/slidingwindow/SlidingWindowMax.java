package src.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7}, k = 3;
        int ans [] =new SlidingWindowMax().maxSlidingWindow(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(" " + ans[i]);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int ans[] = new int[size - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0, j = 0, index = 0;

        while (j < size) {
            //perform operation
            int num = nums[j];
            while (!list.isEmpty() && list.getLast() < num) {
                list.removeLast();
            }
            list.add(num);
            if (j - i + 1 < k) {
                j++;
                //don't slide window until reaches k
            } else if (j - i + 1 == k) {
                ans[index++] = list.getFirst();

                //remove first element
                if (!list.isEmpty() && list.getFirst() == nums[i]) {
                    list.removeFirst();
                }
                //slide window
                i++;
                j++;

            }
        }

        return ans;

    }
}
