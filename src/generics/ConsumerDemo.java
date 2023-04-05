package src.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerDemo {
    private static List<String> finalList = new ArrayList<>();

    public static void main(String[] args) {

        List<Integer> ls = List.of(1, 22, 99, 2323, 234, 90);
        List<String> ls2 = List.of("Nilesh", "Sachin", "ShitalAndI");

        Consumer<Integer> consumer = s -> {
            finalList.add(s + "");
            System.out.println(s);
        };
        Consumer<String> stringConsumer = s -> {
            finalList.add(s.length() + "");
            System.out.println(s.length());
        };

//        consumer.accept(ls.get(0));
        printElements(ls, consumer);
        System.out.println("String lengths: ");
        printElements(ls2, stringConsumer);
        System.out.println("Final List:");
        finalList.stream().forEach(System.out::println);
        //method reference
        Consumer<String> stringConsumer1 =
                 System.out :: println;

        stringConsumer1.accept("Sachin");
    }

    private static <T> void printElements(List<T> ls, Consumer<T> c) {
        for (T i : ls) {
            c.accept(i);
        }
    }

}
