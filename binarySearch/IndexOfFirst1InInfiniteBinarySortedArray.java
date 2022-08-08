package binarySearch;

public class IndexOfFirst1InInfiniteBinarySortedArray {
    public static void main(String args[]) {
        int arr[] = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int searchElement = 1;
        // in infinite array set start =0 and end = 1 until key > arr[end]
        // then perfrom fist index search algorithm we did in past
        int result = findIndexOfFirst1InInfiniteBinarySortedArray(arr, searchElement);
        System.out.println(result);
    }

    static int findIndexOfFirst1InInfiniteBinarySortedArray(int arr[], int searchElement){
        int start =0, end = 1;
        // int result = 0;
        while(searchElement > arr[end]){
            start = end;
            if(end*2 < arr.length - 1)
                end = end*2;
            else
                end = arr.length - 1;
        }
        int result = -1;
        // first index search algo
        while(start <= end){
            int mid = start + (end - start)/2;
            if(searchElement == arr[mid]){
                
                result = mid;
                end = end - 1;
            }
            else if(searchElement < arr[mid]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }
}
