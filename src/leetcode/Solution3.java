package src.leetcode;

public class Solution3 {
    public static void main(String[] args) {
        String s = "owoztneoer";
        StringBuilder sb = new StringBuilder(s);
        for (char c : sb.toString().toCharArray()) {
            c = 'p';
        }
        System.out.println(sb);
    }


}
