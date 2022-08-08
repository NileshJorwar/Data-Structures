package binarySearch;

public class FirstAndLastOccurrenceOfElementInSortedArray {
    public static void main(String[] args) {
//        int arr[] = {1, 2, 5, 5, 5, 8, 20};
        int arr[] = {1, 2, 5, 5, 5, 5, 5};
        int searchElement = 5;
        int first = firstBinarySearch(arr, searchElement);
        int last = lastBinarySearch(arr, searchElement);
        if (first >= 0)
            System.out.println("First Occurrence: " + (first+1));
        else System.out.println("Not found ");
        if (last >= 0)
            System.out.println("Last Occurrence: " + (last+1));
    }

    static int firstBinarySearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        // to check the first occurrence of an element, use new variable result to store the mid which would give first occurrence
        // and traverse left when found end = mid - 1
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
        // to check the last occurrence of an element,
        // use new variable result to store the mid which would give last occurrence
        // and traverse right by setting start = mid + 1
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
