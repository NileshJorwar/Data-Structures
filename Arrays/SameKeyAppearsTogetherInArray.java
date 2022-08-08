package Arrays;

import java.util.*;

public class SameKeyAppearsTogetherInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(1);
		list.add(3);

		int arr[] = { 0, 1, 0, 2, 0, 3, 4, 3, 1, 0, 3 };
		Map<Integer,Integer> map = new HashMap<>();
		for(int k=0;k<arr.length;k++)
		{
			map.put(arr[k], map.getOrDefault(arr[k], 0)+1);
		}
		
		System.out.println(map);
//		for(int k=0;k<map.size();k++)
//		{
//			if(map.containsKey(arr[i]))
//			{
////				for(int )
//			}
//		}
		
		int smaller = 0, larger = list.size() - 1, equal = 0;
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (arr[i] == arr[j]) {
				int t = arr[i + 1];
				arr[i + 1] = arr[j];
				arr[j] = t;
				i++;
				j++;
			}
			j--;
		}
		list.forEach(System.out::println);
	}

}
