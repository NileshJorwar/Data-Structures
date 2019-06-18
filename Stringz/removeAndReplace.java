package Stringz;

public class removeAndReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = { 'a', 'c', 'd', 'b', 'a', 'c', 'a' };
		String resArr = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a')
				resArr += "dd";
			else if (arr[i] == 'b')
				continue;
			else
				resArr += arr[i];
		}
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 'b')
				str += arr[i];
		}
		//System.out.println(str);
		differentApproach(arr);
	}

	public static void differentApproach(char[] arr) {
		int count=0, count2=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!='b')
				arr[count++]=arr[i];
			if(arr[i]=='a')
				count2++;
		}
		System.out.println(count+count2);
		int curr=count-1;
		count=count+count2-1;
		while(curr>=0)
		{
			if(arr[curr]=='a')
			{
				arr[count--]='d';
				arr[count--]='d';
			}
			else
			{
				arr[count--]=arr[curr];
			}
			curr--;
		}
		
	}

}
