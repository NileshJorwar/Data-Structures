package binarySearch;

public class OrderAgnosticSearch {
    public static void main(String[] args) {
//        int arr[] = {1, 2, 3, 5, 6, 8, 20};
//        int searchElement = 15;
        //Check if the given array is asc/des and then perform search

        int arr[] = {21, 12, 10, 9, 4, 2, 0};
        int searchElement = 10;

        int result = agnosticBinarySearch(arr, searchElement);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at position:  " + (result + 1));
    }

    static int agnosticBinarySearch(int arr[], int searchElement) {
        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 1)
            return 0;
        // just check first two elements of an array and then perform search
        boolean ascOrDesc = arr[0] < arr[1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == searchElement) {
                return mid;
            }
            //Ascending Order
            if (ascOrDesc == true) {
                if (searchElement < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //Descending Order
            else {
                if (searchElement < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
