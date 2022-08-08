package binarySearch;

public class NextAlphabeticalInArray {
    public static void main(String args[]) {
        char arr[] = { 'a' , 'f', 'g', 'h', 'i', 'j', 'k'};
        char searchElement = 'h';
        char result = findNextAlphabeticalInArray(arr, searchElement);
        System.out.println(result);
    }

    static char findNextAlphabeticalInArray(char arr[], char searchElement){
        int start =0, end = arr.length - 1;
        char result = '#';
        while(start <= end){
            int mid = start + (end - start)/2;
            if(searchElement == arr[mid])
            {
                start = mid + 1;
                // return arr[mid+1];
            }
            else if(searchElement < arr[mid]){
                result = arr[mid];
                end = mid - 1;
            }
            else{

                start = mid + 1;
            }

        }
        return result;
    }
}
