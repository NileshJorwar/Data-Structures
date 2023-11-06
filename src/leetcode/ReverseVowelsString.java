package src.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsString {
    public static void main(String[] args) {
        new ReverseVowelsString().reverseWordsAnotherApproach("leetcode");
    }

    public String reverseWordsAnotherApproach(String s) {

        int start =0;
        int end=s.length()-1;
        char chArr[] = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while(start<end){
            if(!set.contains(chArr[start])){
                start++;
            }
            else{
                if(!set.contains(chArr[end])){
                    end--;
                }else{
                    char temp = chArr[start];
                    chArr[start] = chArr[end];
                    chArr[end] = temp;
                    start++;
                    end--;
                }
            }
        }
        return new String(chArr);



    }

}
