package binarySearch;

public class MinDiffElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 8, 10, 15, 16};
        int key = 12;
        //Note: have to find min absolute difference
        // 11 ,9 ,6 ,4 ,2 ,3 ,4
        // the difference would always lie between nearest element such as 10,15
        int res = minDiffBinarySearch(arr, key);
        System.out.println(" The element is : " + res);
    }

    static int minDiffBinarySearch(int arr[], int key) {
        int res = 0;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid])
                return arr[mid];
            else if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return Math.abs(arr[start] - key) > Math.abs(arr[end] - key) ? arr[end] : arr[start];
    }
}
