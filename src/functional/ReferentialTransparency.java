package src.functional;

//pure functions are always referential transparent but however vice-versa cannot be true always
public class ReferentialTransparency {
    public static void main(String[] args) {
        //we want same result always
//        int res = add(2, mul(2,2)+mul(2,2));
        int res = add(2, mul(2, 4));
        // but we change the mul() method ; the result wont be same
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }
}
