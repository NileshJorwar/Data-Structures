package src.leetcode;

public class ReverseWordsInString {
    public static void main(String[] args) {
//        new ReverseWordsInString().reverseWords("Let's take LeetCode contest");
        new ReverseWordsInString().reverseWordsAnotherApproach("Let's take LeetCode contest");
    }

    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                StringBuilder rev = sb.reverse();
                res.append(rev);
                res.append(" ");
                sb = new StringBuilder();
            }
        }
        StringBuilder rev = sb.reverse();
        res.append(rev);
        System.out.println(sb);
        return res.toString();
    }

    public String reverseWordsAnotherApproach(String s) {

        int len = s.length();
        int lastSpaceIndex = -1;
        char arr[] = s.toCharArray();
        for (int i = 0; i <= len; i++) {
            if (i == len || arr[i] == ' ') {
                int start = lastSpaceIndex + 1;
                int end = i - 1;

                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
                lastSpaceIndex = i;
            }
        }

        System.out.println("Reversed String: " + new String(arr));

        return new String(arr);



    }

}
