package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class UnaryOpPractice {
    public static void main(String[] args) {

        // Unary Operator accepts one param and returns one param
        UnaryOperator<String> unaryOperator =
                s -> s + "Nilesh";
        System.out.println(unaryOperator.apply("Hello "));

        UnaryOperator<Integer> unaryOperator1 = i -> {
            int k = i * 100;
            return k + 1;
        };
        List<Integer> list = List.of(10, 20, 30, 40);

        List<Integer> res = getSeries(list, unaryOperator1);
        System.out.println(res);
    }

    private static <T> List<T> getSeries(List<T> list, UnaryOperator<T> unaryOperator1) {
        List<T> newList = new ArrayList<>();
        for (T i : list
        ) {
            newList.add(unaryOperator1.apply(i));
        }
        return newList;
    }
}
