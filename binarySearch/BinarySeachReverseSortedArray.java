package binarySearch;

public class BinarySeachReverseSortedArray {
    public static void main(String[] args) {
        int arr[] = {21, 12, 10, 9, 4, 2, 0};
        int searchElement = 0;
        int result = binarySearch(arr, searchElement);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at position:  " + (result + 1));
    }

    static int binarySearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == searchElement) {
                return mid;
            } else if (searchElement < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
