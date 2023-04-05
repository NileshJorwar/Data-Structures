package src.generics;

public class LambdaUnderTheHood {
    public static void main(String[] args) {

//        MyFunInterface myFunInterface1 = new MyFunInterface() {
//            @Override
//            public void method1() {
//                System.out.println("Implementation 1");
//            }
//        };
//
//        MyFunInterface myFunInterface2 = new MyFunInterface() {
//            @Override
//            public void method1() {
//                System.out.println("Implementation 2");
//            }
//        };
        //Above approach creates two classes for inner classes and create a heavy jar
        MyFunInterface m = ()-> System.out.println("I am genius");
        //when used lambda, no new class is created for lambda
        // we can see the JVM instructions for current class  to see how lambda is called
        // javap -c /classPath
        //Lambda -- uses type inference and invoke dynamic functionality ; are smart and optimize memory

    }
}
