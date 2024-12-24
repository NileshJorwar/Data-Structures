package src.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOutmostParanthesis {

    class PairOf {
        char c;
        int index;
        PairOf(char c, int index){
            this.c=c;
            this.index=index;
        }
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        String res = new RemoveOutmostParanthesis().removeOuterParentheses(s);
        System.out.println(res);
    }
    public String removeOuterParentheses(String s) {
        int count =0;
        StringBuilder stringBuilder = new StringBuilder();
        int first = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                count++;
            }else{
                count--;
            }
            if(count==0){
                stringBuilder.append(s.substring(first+1,i));
                first = i+1;
            }
        }
        return stringBuilder.toString();
    }

}


