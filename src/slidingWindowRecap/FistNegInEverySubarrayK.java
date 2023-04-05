package src.slidingWindowRecap;

import java.util.ArrayList;
import java.util.List;

public class FistNegInEverySubarrayK {
    public static void main(String[] args) {
        int windowK = 3;
        int i = 0, j = 0;
        int arr[] = {12, -5, 1, 8, 2, -9, -1};
        int size = arr.length;
        List<Integer> arrList = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();
        while (j < size) {
            if (arr[j] < 0) {
                arrList.add(arr[j]);
            }
            if ((j - i + 1) < windowK) {
                j++;
            } else if ((j - i + 1) == windowK) {
                if (arrList.size() == 0)
                    ansList.add(0);
                else {
                    ansList.add(arrList.get(0));
                    if (arrList.get(0) == arr[i])
                        arrList.remove(0);
                }
                i++;
                j++;
            }
        }
        System.out.println(ansList);
    }
}
