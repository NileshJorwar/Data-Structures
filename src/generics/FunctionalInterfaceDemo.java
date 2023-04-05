package src.generics;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        MyFunInterface myFunInterface = ()-> System.out.println("Hello Fn");
        myFunInterface.method1();

        //we can also supply the behaviour on the fly using Fun Interface
        onTheFly(()-> System.out.println("On The Fly Fn"));
    }
    public static void onTheFly(MyFunInterface myFunInterface){
        myFunInterface.method1();
    }
}
