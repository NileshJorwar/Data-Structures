package src.functional;

public class MyFunctionInterfaceDemo {
    public static void main(String[] args) {
        MyFunInterface myFunInterface = ()-> System.out.println("Hello");
        myFunInterface.myMethod();
        //passing functional interface on the fly
        onTheFly(()-> System.out.println("Hello2 "));
    }

    public static void onTheFly(MyFunInterface myFunInterface){
        myFunInterface.myMethod();
    }
}
