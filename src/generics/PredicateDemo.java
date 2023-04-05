package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sahcin");
        list.add("Nilesh");
        list.add("");
        list.add("Shital");
        list.add("Strong");
        list.add("");

        Predicate<String> predicate = s ->
                !list.contains(s);
        boolean res = predicate.test("Nilesh");
        System.out.println("Contains: " + res);
        Predicate<String> predicate1 = s -> !s.isEmpty();
        Predicate<String> predicate2 = s -> s.contains("Nilesh");
        Predicate<Integer> predicate3 = s -> s.intValue() % 2 == 0;

        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(122);

        List<String> strings = filterList(list, predicate1);
        List<String> strings2 = filterList(list, predicate2);
        List<Integer> integerList1 = filterList(integerList, predicate3);
        System.out.println(strings);
        System.out.println(strings2);
        System.out.println(integerList1);
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> p) {
        List<T> arr = new ArrayList<>();
        for (T s : list) {
            if (p.test(s))
                arr.add(s);
        }
        return arr;
    }
}
