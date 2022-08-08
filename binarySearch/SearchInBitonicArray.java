package binarySearch;

public class SearchInBitonicArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 8, 12, 4, 2};
        int key = 11;
        //Note: bitonic array is monotonically increasing where arr[i] ! = arr[i+1]
        // hence it is similar to find peak Element
        // and to search : split it in half from peakElement
        int resIndex = findPeakUsingBinarySearch(arr);
        int left = binarySearchIncreasingOrder(arr, key, 0, resIndex - 1);
        int right = binarySearchDecreasingOrder(arr, key, resIndex, arr.length - 1);
        if (left == -1)
            System.out.println(" The element found at : " + right);
        else
            System.out.println(" The element found at : " + left);

    }

    static int binarySearchIncreasingOrder(int arr[], int searchElement, int start, int end) {
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

    static int binarySearchDecreasingOrder(int arr[], int searchElement, int start, int end) {
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

    static int findPeakUsingBinarySearch(int arr[]) {
        int size = arr.length;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < size - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                else if (arr[mid - 1] > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (mid == 0) {
                if (arr[0] > arr[1])
                    return 0;
                else return 1;
            } else if (mid == size - 1) {
                if (arr[size - 1] > arr[size - 2])
                    return size - 1;
                else
                    return size - 2;
            }
        }

        return -1;
    }
}
