package src.leetcode;

import java.util.Arrays;

public class TipS {
    public static void main(String[] args) {

        String palindrome = "abccba";
        char ba = palindrome.charAt(1);
        StringBuilder sb = new StringBuilder();
//        char d = (char)((int)(ba +1);
//        sb.append(((b - 'a') + 1));

        System.out.println("----------------");
        String s = "nileshJ";
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) + '0';
            System.out.println(x);
        }
        System.out.println("---------");
        int arr[] = {1, 3, 4, 5, 5, 6, 7, 8};
        //To convert to Wrapper Class Integer
        Integer arrInt[] = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrInt,
                (a, b) -> {
                    Integer x = Integer.bitCount(a);
                    Integer y = Integer.bitCount(b);
                    if (x < y)
                        return -1;
                    else if (y > x)
                        return 1;
                    else {
                        return x.compareTo(y);
                    }
                });
        int x[] = Arrays.stream(arrInt).mapToInt(Integer::intValue).toArray();
        System.out.println(x);
        System.out.println("--------");
        String num = "1210";
        int cnt[] = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c - '0'] += 1;
            int x2 = c - '0';
            int x3 = c + '0';
            char x4 = (char) (c + '0');
            System.out.println();
        }
        System.out.println("----Elements of String array of nums----");
        for (int i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i]);
        }
    }
}
