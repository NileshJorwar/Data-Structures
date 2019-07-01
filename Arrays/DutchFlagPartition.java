package Arrays;

import java.util.*;

public class DutchFlagPartition {
	public static enum Color {
		RED, BLUE, WHITE
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Color> list = new ArrayList<>();
		list.add(Color.BLUE);
		list.add(Color.RED);
		list.add(Color.WHITE);
		list.add(Color.WHITE);
		list.add(Color.BLUE);
		list.add(Color.RED);
		list.add(Color.WHITE);

		// list.forEach(color -> System.out.println(color));
		int index = 2;
		List<Color> colorList=new ArrayList<>();
		colorList.addAll(list);
		dutchFlagPartitions(colorList,index);
		// smaller than pivot
		Color pivot = list.get(index);
		for (int i = 0; i < list.size(); ++i) {
			for (int j = i + 1; j < list.size(); ++j) {
				if (list.get(j).ordinal() < pivot.ordinal()) {
					Collections.swap(list, i, j);
					break;
				}
			}
		}

		//list.forEach(color -> System.out.println(color));
		//System.out.println("------------------------");
		// greater than pivot

		for (int i = list.size() - 1; i >= 0 && list.get(i).ordinal() >= pivot.ordinal(); i--) {
			for (int j = i - 1; j >= 0 && list.get(j).ordinal() >= pivot.ordinal(); j--) {
				if (list.get(j).ordinal() > pivot.ordinal()) {
					Collections.swap(list, i, j);
					break;
				}
			}
		}
		
		list.forEach(color -> System.out.println(color.ordinal()));
		System.out.println("Complexity---O(n2)");
		
		
	}
	
	public static void dutchFlagPartitions(List<Color> list, int index)
	{
		Color pivot = list.get(index);
		int smaller = 0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).ordinal()<pivot.ordinal())
				Collections.swap(list, smaller++, i);
		}
		int larger =list.size()-1;
		
		for(int i=list.size()-1;i>=0 && list.get(i).ordinal()>=pivot.ordinal();i--)
		{
			if(list.get(i).ordinal()>pivot.ordinal())
				Collections.swap(list, larger--, i);
		}
		
		list.forEach(color -> System.out.println(color.ordinal()));
		System.out.println("Complexity---O(n)");
	}

}
