package src.functional;

//Consumer class has side effects as takes something but returns nothing
public class PureFunction {
    int value;

    //does not modifyParams
    public int pure(int a, int b) {
        return a + b;
    }

    //it has side effects at it modifies the value
    public int imPure(int a, int b) {
        this.value += (a + b);
        return this.value;
    }

    public static void main(String[] args) {
//        int result = add(multiply(2,3),multiply(3,4));
        int result = add(6,12);
        System.out.println(result);
    }
    public static int add(int a, int b){
        return a+b;
    }
    public static int multiply(int a, int b){
        log(String.format("Returning %s as the result of %s * %s", a*b, a,b));
        return a*b;
    }
    public static void log(String s){
        System.out.println(s);
    }

}
