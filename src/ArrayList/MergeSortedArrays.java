package src.ArrayList;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,5,10};
		int b[]= {0,0,1,2,15,25,26,26};
		int c[]=new int[a.length+b.length];
		int i=0,j=0,k=0;
		
		while(i<a.length&&j<b.length)
		{
			if(a[i]<=b[j])
				c[k++]=a[i++];
			else
				c[k++]=b[j++];			
		}
		
		while(i<a.length)
			c[k++]=a[i++];
		while(j<b.length)
			c[k++]=b[j++];
		int len=a.length;
		
		for(int l=0;l<b.length;l++)
		{
			a[len]=b[i];
			l++;
		}
		Arrays.sort(a);
		for(int l=0;l<c.length;l++)
			System.out.print(a[l]+ " ");
	}

}
