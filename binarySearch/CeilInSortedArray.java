package binarySearch;

public class CeilInSortedArray {
    public static void main(String args[]) {
        int arr[] = { 1, 3 , 4, 10, 10, 19};
        int searchElement = 5;
        int result = findCeilUsingBinarySearch(arr, searchElement);
        System.out.println(result);
    }

    static int findCeilUsingBinarySearch(int arr[], int searchElement){
        int start =0, end = arr.length - 1;
        int result = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(searchElement == arr[mid]){
                return arr[mid];
            }
            else if(searchElement < arr[mid]){
                result = arr[mid];
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            
        }
        return result;
    }
}
