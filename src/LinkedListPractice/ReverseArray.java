package src.LinkedListPractice;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 9};
        rvereseArray(arr, 0, arr.length-1);
//        reverseArr(arr, 0, arr.length-1);
        printArray(arr, arr.length);
    }
    static void printArray(int arr[],
                           int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void reverseArr(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start]=arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }
}
