package src.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OptionalDemo {
    public static void main(String[] args) {
        String s = "String A";
        Optional<String> optionalS = Optional.of(s);
        System.out.println(optionalS.get());

        Optional<Integer> optionalInteger = Optional.empty();
        System.out.println(optionalInteger);
        Optional<String> optionalS1 = Optional.ofNullable(s);
        System.out.println(optionalS1);
        Optional<String> optionalS2 = Optional.ofNullable(null);
        System.out.println(optionalS2);
        String st = "Shital";
        Optional<String> optionalS3 = Optional.ofNullable(st);
        System.out.println(optionalS3.isEmpty());
        Consumer<String> consumer = st3 -> System.out.println(st3);
        consumer.accept("Nilesh");
        optionalS3.ifPresentOrElse(consumer, () -> System.out.println("Thread"));
        System.out.println(st.charAt(0));

        System.out.println();
        String i = optionalS3.orElse("10");
        Supplier<String> supplier = () -> "Niles";
        System.out.println(supplier.get());
        String i1 = optionalS3.orElseGet(supplier);
//        String i1 =optionalS3.orElseGet(()->"Niles");
//
        System.out.println(i1);
//        optionalInteger.orElseThrow(()-> new IllegalArgumentException("args"));
        //map
        Optional<String> optionalS4 =
                Optional.of("Sameer");
        Integer optionalI = optionalS4.map(k -> k.length()).orElse(10);
        System.out.println(optionalI);
        Predicate<String> stringPredicate = (x) -> x.equals("Sameer");
        Optional<String> filter = optionalS4.filter(stringPredicate);
        System.out.println(filter.get());


        //flatMap one to may mappings and you want just single list
        //
        List<List<Integer>> phones = new ArrayList<>();
        phones.add(List.of(100, 122, 111, 1112));
        phones.add(List.of(101));
        phones.add(List.of(103, 899));
        phones.add(List.of(104, 1891, 89198));

        List<Integer> phone = phones.stream().flatMap(integers -> integers.stream()).sorted(
                (o1, o2) ->
                        o1.intValue() < o2.intValue() ? 1 : -1
        ).collect(Collectors.toList());

        List<Integer> phones2 = phones.stream().flatMap(integers -> integers.stream()).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() < o2.intValue() ? 1 : -1;
            }
        }).collect(Collectors.toList());
        System.out.println(phone);
        System.out.println(phones2);

        System.out.println("-------");
        Optional<String> optionalS5 = Optional.of("value");
        optionalS5.ifPresent((x)-> System.out.println(x));
        optionalS5.ifPresent(System.out::println);
        Optional.empty().ifPresentOrElse(System.out::println, ()-> System.out.println("Empty"));
        optionalS5.ifPresentOrElse(System.out::println, ()-> System.out.println("Empty"));

        //OR
        optionalS5.or(()->Optional.of("value OR")).ifPresent(System.out::println);
        Optional.empty().or(()->Optional.of("value OR")).ifPresent(System.out::println);

        //equals
        System.out.println(optionalS5.equals(Optional.of("value")));
        System.out.println(Optional.empty().equals(Optional.ofNullable(null)));
        System.out.println(optionalS5.hashCode());
        System.out.println(Optional.empty().hashCode());


    }
}
