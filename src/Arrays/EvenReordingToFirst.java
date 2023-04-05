package src.Arrays;

public class EvenReordingToFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,1,3,3,4,7,2,5};
		int even =0, odd=arr.length-1;
		while(even<odd)
		{
			if(arr[even]%2==0)
				even++;
			else
			{
				int temp=arr[even];
				arr[even]=arr[odd];
				arr[odd]=temp;
				odd--;
			}
		}
		for(Integer i:arr)
		{
			System.out.println(i);
		}
	}	

}
