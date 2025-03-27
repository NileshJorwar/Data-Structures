package src.leetcode;

public class CountAndSay {

    public static void main(String[] args) {
        new CountAndSay().countAndSay(4);
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String input = "1";
        while(n>1){
            String result = rle(input);
            input = result;
            n--;
        }
        return input;
    }
    public String rle(String str){
        if(str.length() == 1){
            return "11";
        }
        char start = str.charAt(0);
        int count=1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<str.length();i++){
            if(start == str.charAt(i)){
                count++;
            }else{
                sb.append(count+"").append(start);
                start=str.charAt(i);
                count=1;
            }
        }
        sb.append(count+"").append(start);
        return sb.toString();
    }
}
