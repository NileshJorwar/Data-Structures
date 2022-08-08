package binarySearch;

public class FindFloorInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 10, 12, 12, 19};
        int searchElement = 5;
        // in this case, usually an element which is not positioned well is having its actual position is either
        // at i, i+1, or i-1
        int result = findFloorBinarySearch(arr, searchElement);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at position:  " + (result + 1));
    }

    static int findFloorBinarySearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (searchElement == arr[mid]) {
                 result = mid;
            } else if (searchElement < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
