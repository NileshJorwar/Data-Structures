package src.leetcode;

public class TimeNeededRearrangeBinaryString {
    public static void main(String[] args) {
        String st = "0110101";
        int count=0;
        String str = st;
        while(str.contains("01")){
            str = str.replace("01", "10");
            count++;
        }
        // until string does not contain 01
    }


}
