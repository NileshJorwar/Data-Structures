package binarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 8, 10, 15, 16};
        //Note: peak element is greater than neighbours
        // such as 20
        // for edge cases if a[0] > a[1] ; a[0] and a[n]>an[n-1]; a[n]
        int res = findPeakUsingBinarySearch(arr);
        System.out.println(" The peak element is : " + res);
    }

    static int findPeakUsingBinarySearch(int arr[]) {
        int size = arr.length;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < size - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return arr[mid];
                else if (arr[mid - 1] > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (mid == 0) {
                if (arr[0] > arr[1])
                    return arr[0];
                else return arr[1];
            } else if (mid == size - 1) {
                if (arr[size - 1] > arr[size - 2])
                    return arr[size - 1];
                else
                    return arr[size - 2];
            }
        }

        return -1;
    }
}
