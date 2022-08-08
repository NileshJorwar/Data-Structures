package binarySearch;

public class SearchNearlySortedArray {
    public static void main(String[] args) {
        int arr[] = {5, 10, 15 , 32, 30, 20, 40};
        int searchElement = 40;
        // in this case, usually an element which is not positioned well is having its actual position is either
        // at i, i+1, or i-1
        int result = nearlySortedArrSearch(arr, searchElement);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at position:  " + (result + 1));
    }

    static int nearlySortedArrSearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (searchElement == arr[mid]) {
                return mid;
            } else if (searchElement == arr[mid - 1]) {
                return mid - 1;
            } else if (searchElement == arr[mid + 1]) {
                return mid + 1;
            } else if (searchElement < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
