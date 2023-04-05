package src.ArrayList;

import java.util.*;
import java.util.stream.Collectors;
public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>(Arrays.asList(1,3,4,2,2,2,4,5,6)) ;
		List<Integer> newList=new ArrayList<>();
		for(Integer i:list)
		{
			if(!newList.contains(i))
				newList.add(i);
		}
		System.out.println(newList);
		Set<Integer> newSet=new LinkedHashSet<>();
		newSet.addAll(list);
		System.out.println(newSet);
		List<Integer> newStream=list.stream().distinct().collect(Collectors.toList());
		System.out.println(newStream);
		

	}

}
