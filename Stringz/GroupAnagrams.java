package Stringz;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		//List<List<String>> anagramsList=new ArrayList<>();
		groupAnagrams(strs) ;
		
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null)
            return null;
        if(strs.length==1)
            return null;
        List<List<String>> anagramsList=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char [] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);
            if(map.containsKey(str))
                map.get(str).add(strs[i]);
            else
            {
                map.put(str,new ArrayList<>());
                map.get(str).add(strs[i]);
            }
        }
        
        for(String k:map.keySet())
        {
            anagramsList.add(map.get(k));
        }
        System.out.println(anagramsList);
        return null;
    }
}
