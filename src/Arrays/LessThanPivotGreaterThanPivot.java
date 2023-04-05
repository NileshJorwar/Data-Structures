package src.Arrays;

/*
 * Rearrange elements based on pivot ---< pivot >
 */
public class LessThanPivotGreaterThanPivot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 0, 1, 2, 0, 2, 1, 1 };
		int low = 0, high = arr.length - 1;
		quicksort(arr, low, high);
		for(Integer i:arr)
			System.out.println(i);
	}

	public static void quicksort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quicksort(arr, low, pi - 1);
			quicksort(arr, pi + 1, high);
		}
	}

	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;

	}

}
