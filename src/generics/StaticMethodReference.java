package src.generics;

import java.util.function.BiFunction;

public class StaticMethodReference {
    public static void main(String[] args) {

//        BiFunction<String, String, Integer> biFunction = (x, y) -> A_Class.staticMethodCall(x, y);
        BiFunction<String, String, Integer> biFunction = A_Class::staticMethodCall;
        System.out.println(biFunction.apply("Sachin", "Nilesh"));
    }

}

class A_Class {
    static int staticMethodCall(String a, String b) {
        return (a + b).length();
    }
}
