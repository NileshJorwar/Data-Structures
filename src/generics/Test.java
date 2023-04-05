package src.generics;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String coordinates = "h6";
        Map<Character, Integer> map =
                new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);

        System.out.println(map);
        char c = coordinates.charAt(0);
        int x = map.get(c);
        System.out.println(x);
        boolean t = (coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') % 2 == 0;
        System.out.println("---------");

        String num = "1210";
        int cnt[] = new int[10];
        for(char c2 : num.toCharArray()){
            cnt[c2 - '0'] +=1;
        }
    }
}
