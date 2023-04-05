package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramsHard {
    public static void main(String[] args) {
        new CountAnagramsHard().countAnagrams("ptx cccbhbq");
    }
    public int countAnagrams(String s) {
        // too, toh, tho, hot, hto, oht,oth
        // ott, toh, tho, hot, hto, oht,oth
        // tot, toh, tho, hot, hto, oht,oth
        String strs[] = s.split(" ");
        int sum=1;
        for(int i=0;i<strs.length;i++){
            String st = strs[i];
            int len = st.length();
            Map<Character, Integer> map = new HashMap<>();
            for(int j=0;j<len;j++){
                char c=st.charAt(j);
                map.put(c, map.getOrDefault(c,0)+1);
            }
            int f = fact(map.size());
            if(f==2)
                sum*=(f+1);
            else
                sum*=f;
            System.out.println(sum);

        }
        return sum;
    }
    public int fact(int n){
        if(n==0 || n==1)
            return 1;
        return n*fact(n-1);
    }
}
