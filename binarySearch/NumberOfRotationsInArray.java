package binarySearch;

public class NumberOfRotationsInArray {
    public static void main(String[] args) {
//        int arr[] = {11, 12, 13, 18, 2, 3, 4, 5};
//        int arr[] = {18, 2, 3, 4, 5, 11, 15, 16};
        int arr[] = {16, 18, 2, 3, 4, 5, 11, 15};

        int result = binarySearch(arr);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at position:  " + (result + 1));
    }

    static int binarySearch(int arr[]) {
        int start = 0;
        int len = arr.length;
        int end = arr.length - 1;
        // to find the number of rotations in the array one
        // should find the previous and next element of an element with as arr[mid] <= arr[prev] && arr[mid] <= arr[next]
        // as element would be smaller than next and previous element and index of such element would be the number of rotations
        // if arr[start] <= arr[mid] then first half array is sorted ; hence to look in the right half
        // else arr[mid] <= arr[end] then second half i.e., right half is sorted hence look in left half
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % len;
            int prev = (mid - 1 + len) % len;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
        }
        return 0;
    }
}
