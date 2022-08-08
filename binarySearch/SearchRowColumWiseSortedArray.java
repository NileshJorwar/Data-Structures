package binarySearch;

public class SearchRowColumWiseSortedArray {
    public static void main(String[] args) {
        int arr[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
                {34, 36, 40, 52},
        };
        int key = 34;
        // start from top left and compare with key element move left or right based on comparison
        int result = binarySearch(arr, key);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at position:  " + (result ));
    }

    static int binarySearch(int arr[][], int searchElement) {
        int rows = arr.length;
        int col = arr[0].length;
        int i = 0, j = col - 1;
        while (i >= 0 && i < rows
                &&
                j >= 0 && j < col)
        {
            if(searchElement == arr[i][j])
                return arr[i][j];
            else if(searchElement < arr[i][j])
                j--;
            else if(searchElement > arr[i][j])
                i++;
        }
            return -1;
    }
}
