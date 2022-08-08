package binarySearch;

public class BinarySeachClass {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 6, 8, 20};
        int searchElement = 5;
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
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
