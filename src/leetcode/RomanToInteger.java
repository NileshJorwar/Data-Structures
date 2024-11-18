package src.leetcode;

import java.util.*;
public class RomanToInteger {
    public static void main(String[] args) {
        new RomanToInteger().romanToInt("LVIII");
    }
    public int romanToInt(String s) {


        // I II III IV V VI VII VIII IX X XI
        // L V III 58
        // M CM XC IV

        Map<Character,Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int val = 0;
        for(int i=s.length()-1;i>=0;i--){

            char ch = s.charAt(i);
            if(i!=0){
                if(ch=='V' || ch=='X'){
                    if(s.charAt(i-1)=='I')
                    {
                        val+=map.get(ch) - 1;
                        i--;
                        continue;
                    }
                }
                if(ch=='L' || ch=='C'){
                    if(s.charAt(i-1)=='X')
                    {
                        val+=map.get(ch) - 10;
                        i--;
                        continue;
                    }
                }
                if(ch=='D' || ch=='M'){
                    if(s.charAt(i-1)=='C')
                    {
                        val+=map.get(ch) - 100;
                        i--;
                        continue;
                    }
                }
            }
            val+=map.get(ch);

        }
        return val;
    }
}
