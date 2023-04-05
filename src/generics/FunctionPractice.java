package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class FunctionPractice {
    public static void main(String[] args) {

        Function<String, Integer> function =
                s -> s.length();
        function.apply("Sachin");
        System.out.println(function.apply("Sachin"));
        Function<Integer, String> function1 =
                integer -> integer + "_nilesh";
        System.out.println(function1.apply(100));
        List<String> stringList = List.of("Nilesh", "Zac", "Hammer");
        List<Integer> list = map(stringList, function);
        System.out.println("----------");
        System.out.println(list);
    }

    private static <T, R> List<R> map(List<T> stringList, Function<T, R> function) {
        List<R> rList = new ArrayList<>();
        for (T s : stringList) {
            R r = function.apply(s);
            rList.add(r);
        }
        return rList;
    }
}
