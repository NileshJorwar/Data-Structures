package src.slidingWindowRecap;

import java.util.LinkedList;
import java.util.List;

public class MaxInAllSubarrayK {
    public static void main(String[] args) {
        int windowK = 3;
        int i = 0, j = 0;
        int arr[] = {2, -5, 1, -8, -2, -9, -1};
        int size = arr.length;
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> maxlist = new LinkedList<>();
        while (j < size) {
            while (list.size()!=0 && arr[j] > list.getLast()) {
                list.removeLast();
            }
            list.add(arr[j]);
            if ((j - i + 1) < windowK) {
                j++;
            } else if ((j - i + 1) == windowK) {
                if (list.size() == 0)
                    maxlist.add(0);
                else
                    maxlist.add(list.getFirst());
                if (arr[i] == list.getFirst())
                    list.removeFirst();
                i++;
                j++;
            }
        }
        System.out.println(maxlist);
    }
}
