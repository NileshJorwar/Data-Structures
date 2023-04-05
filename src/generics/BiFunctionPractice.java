package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


public class BiFunctionPractice {
    public static void main(String[] args) {

        BiFunction<String, Integer, Long> biFunction =
                (x,y)-> {
                    long l = 10l;
                    int len = x.length();
                    return l + len + y;
                };
        System.out.println(biFunction.apply("Sachin", 10));

    }
}
