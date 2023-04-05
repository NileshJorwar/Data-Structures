package src.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighestNumberWithitsPresenceinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,2,2,2,2,2,2,2,2};
		//List<Integer> list=new ArrayList<>(Arrays.)
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			//System.out.print(map.getOrDefault(arr[i], 0)+"");
			//map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i])+1);
		}
		int fr=arr.length/2;
		List<Integer> keys=new ArrayList<>(map.keySet());
		System.out.println(map);
		System.out.println(keys);
		List<Integer> out=new ArrayList<>();
		
		for(int i=0;i<keys.size();i++)
		{
			if(map.get(keys.get(i))>=fr)
			{
				out.add(keys.get(i));
			}
		}
		System.out.println(out);
		
	}

}
