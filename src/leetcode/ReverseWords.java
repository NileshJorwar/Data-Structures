package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReverseWords {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String s = "the sky is blue";
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c != ' ') {
                sb.append(c);
            } else {

                if (sb.toString().length() != 0) {
                    System.out.println(sb.toString());
                    map.put(count++, sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.toString().length() != 0) {
            map.put(count++, sb.toString());
        }
        StringBuilder rs = new StringBuilder();
        for (int i = map.size() - 1; i >= 0; i--) {
            String r = map.get(i);
            if (i == 0) {
                rs.append(r);
                break;
            }
            if (r != " ") {
                rs.append(r).append(" ");
            }
        }
        System.out.println(rs.toString());
        //Alternate way
        System.out.println(otherWay(" hello world "));
    }

    public static String otherWay(String s) {
        String arr[] = s.trim().split(" ");
        String result = "";
        for (int i = arr.length - 1; i > 0; i--) {
            result += arr[i] + " ";
        }
        return result + arr[0];
    }
}
