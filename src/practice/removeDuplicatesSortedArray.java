package src.practice;

public class removeDuplicatesSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int arr[]= {0,1,1};
	int pos=0;
	int tmp=0;
	for(int i=1;i<arr.length;i++)
	{
		if(arr[i]==arr[pos])
		{
			pos++;
		}
		else
		{
			tmp=arr[i];
			arr[i]=arr[pos];
			arr[pos]=tmp;
			
		}
	}
	System.out.println("Pos"+pos);
	for(int i=0;i<arr.length;i++)
		System.out.println(arr[i]);
	}

}
