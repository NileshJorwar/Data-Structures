package src.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class PredefinedFunctionalInterfaces {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Sachin");
        list.add("Ramesh");
        list.add("");
        list.add("Ganesh");
        list.add("");

        Predicate<String> predicate = s -> !s.isEmpty();
        Predicate<String> predicate2 = s -> s.contains("Ganesh");

        List<String> newList = filterList(list, predicate);
        List<String> newList2 = filterList(list, predicate2);
        List<Integer> integerList = List.of(1, 3, 4, 5, 6, 7, 8);
        Predicate<Integer> pr = x -> x % 2 == 0;
        List<Integer> result = filterList(integerList, pr);
        System.out.println(result);
        System.out.println(newList);
        System.out.println(newList2);

        //Consumer

        List<Integer> list1 = List.of(12, 23, 3, 3, 1, 1212, 12, 90);
        System.out.println("Consumer Demo");
        Consumer<Integer> consumer = System.out :: println;
        printElements(list1, consumer);
        List<Integer> rsult = new ArrayList<>();
        Consumer<Integer> consumer2 = s -> {
            int x = 10 * s;
            rsult.add(x);
        };
        printElements(list1, consumer2);
        System.out.println("Consumer 2: " + rsult.get(0));
        System.out.println("Supplier Demo");

        Supplier<Integer> supplier = () -> "s".length();
        System.out.println(supplier.get());
        Supplier<Double> supplier2 = Math:: random;
        System.out.println(supplier2.get());

        System.out.println("Function Demo");
        Function<String, Integer> function =
                x -> x.length();
        System.out.println(function.apply("Sachin"));
        List<String> stringList = List.of("Sachin", "Nilesh", "Sam");
        List<Integer> map = findLength(stringList, function);
        System.out.println(map);

        System.out.println("-----------");
        System.out.println("Unary Operator");

        List<Integer> list2 = List.of(1, 2, 3, 3, 4, 6, 0);
        UnaryOperator<Integer> unaryOperator = i -> i * 100;
        List<Integer> resl = mulUsingUnaryOps(list2, unaryOperator);
        System.out.println(resl);
        System.out.println("-----------");
        System.out.println("Bi Function ");
        BiFunction<String, String, String> biFunction =
                (x,y)-> x+y;
        String r = biFunction.apply("Basics", "Stromg");
        System.out.println(r);
        BiFunction<Integer, String, Integer> biFunction2 =
                (x,y)-> x+y.length();
        List<Integer> re= biFunctionTest(list2, "Nilesh", biFunction2);
        System.out.println(re);

        System.out.println("-----------");
        System.out.println("Binary Operator ");

        BinaryOperator<String> binaryOperator = (x,y)->x+"..."+y;
        System.out.println(binaryOperator.apply("Nilesh", "Jorwar"));

    }

    private static <T,U,R> List<R> biFunctionTest(List<T> list2, U u, BiFunction<T,U,R> biFunction) {
        List<R> intList = new ArrayList<>();
        for (T i: list2
             ) {
            intList.add(biFunction.apply(i,u));
        }
        return intList;
    }

    private static <T> List<T> mulUsingUnaryOps(List<T> list2, UnaryOperator<T> unaryOperator) {
        List<T> res = new ArrayList<>();
        for (T t :
                list2) {
            res.add(unaryOperator.apply(t));
        }
        return res;
    }

    private static <T, R> List<R> findLength(List<T> stringList, Function<T, R> function) {
        List<R> map = new ArrayList<>();
        for (T s : stringList) {
            map.add(function.apply(s));
        }
        return map;
    }

    private static <T> void printElements(List<T> list1, Consumer<T> consumer) {
        for (T i : list1) {
            consumer.accept(i);
        }
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T s : list) {
            if (predicate.test(s))
                newList.add(s);
        }
        return newList;
    }
}
