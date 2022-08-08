package binarySearch;

public class FindPositionOfEleInfiniteArray {
    public static void main(String args[]) {
        int arr[] = { 1, 3 , 4, 10, 10, 19, 20, 21, 22, 23, 45, 56,78};
        int searchElement = 78;
        //Here, first we in an infinite array we dont know the length of an array, hence we set end to 1 and keep updating
        // end = end*2 until the key is greater than arr[end]
        // once start and end are set just run simple binary search
        int result = findPositionOfEleInfiniteArray(arr, searchElement);
        System.out.println(result);
    }

    static int findPositionOfEleInfiniteArray(int arr[], int searchElement){
        int start =0, end = 1;
        // int result = 0;
        while(searchElement > arr[end]){
            start = end;
            if(end*2 < arr.length - 1)
                end = end*2;
            else
                end = arr.length - 1;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(searchElement == arr[mid]){
                return mid;
            }
            else if(searchElement < arr[mid]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
