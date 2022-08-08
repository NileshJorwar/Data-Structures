package binarySearch;

public class CountOfElementInSortedArray {
    public static void main(String[] args) {
//        int arr[] = {1, 2, 5, 5, 5, 8, 20};
        int arr[] = {1, 2, 5, 5, 5, 5, 5};
        int searchElement = 5;
        // to find the count of particular element in an array
        // should find first and last occurrence and get the difference of the two + 1

        int first = firstBinarySearch(arr, searchElement);
        int last = lastBinarySearch(arr, searchElement);
        System.out.println("Count of Element: " + (last - first + 1));

    }

    static int firstBinarySearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == searchElement) {
                result = mid;
                end = mid - 1;
            } else if (searchElement < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    static int lastBinarySearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == searchElement) {
                result = mid;
                start = mid + 1;
            } else if (searchElement < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
